package com.epam.pizza.web;

import com.epam.pizza.domain.*;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;
import java.time.ZoneId;
import java.util.*;

/**
 * Created by dennis on 8/10/2015.
 */
@Controller("pizzaController")
@SessionAttributes(types = HashMap.class)
public class PizzaController extends AbstractController {


    @RequestMapping(value = "/pizzas", method = RequestMethod.GET)
    public String viewPizzas(Model model) {
        model.addAttribute("pizzas", pizzaService.getAllPizzas());
        model.addAttribute("pizzaTypes", PizzaType.values());
        Object authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("auth", authorities);
        model.addAttribute("prin", principal);
        return "pizzas";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String addNewPizza(Model model) {
        model.addAttribute("pizzaTypes", PizzaType.values());
        return "create";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public String addNewPizza(Model model,
//                              @RequestParam(value = "name", required = true) String name,
//                              @RequestParam(value = "price" , required = true) Integer price,
//                              @RequestParam(value = "pizzaType" , required = true) PizzaType pizzaType)
    public String addNewPizza(Model model,
                              @ModelAttribute Pizza newPizza,
                              @RequestParam(value = "pricel", required = true) String price) {
        // pizzaService.save(new Pizza(name,price,pizzaType));
        Float newPrice = Float.parseFloat(price) * 100;
        newPizza.setPrice(newPrice.intValue());
        System.out.println(newPizza.getId());
        pizzaService.save(newPizza);
//        return viewPizzas(model);
        return viewPizzas(model);
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editPizza(Model model, @RequestParam(value = "id") Pizza pizza) {
//        Pizza pizza = getPizzaById(id);
        model.addAttribute("pizza", pizza);
        System.out.println(pizza.getId());
        return addNewPizza(model);
    }

    protected Pizza getPizzaById(Integer id) {
        return pizzaService.getPizzaById(id);
    }

    @Override
    @InitBinder
    protected void pizzaBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Pizza.class,
                new PropertyEditorSupport() {
                    @Override
                    public void setAsText(String id) {
                        Pizza pizza = null;
                        if (id != null && !id.trim().isEmpty()) {
                            Integer ID = Integer.valueOf(id);
                            pizza = getPizzaById(ID);
                        }
                        setValue(pizza);
                    }
                });
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deletePizza(Model model, @RequestParam(value = "id") Integer id) {
        pizzaService.delete(id);
        model.addAttribute("pizzaTypes", PizzaType.values());
        return viewPizzas(model);
    }


    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ModelAndView goToOrder(Model model) {
        ModelAndView modelAndView = new ModelAndView("order");
        model.addAttribute("pizzas", pizzaService.getAllPizzas());
        return modelAndView;
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "order", method = RequestMethod.POST)
    public ModelAndView addToOrder(Model model,
                                   @RequestParam(value = "id") Integer id,
                                   @RequestParam(value = "count") Integer count,
                                   //get map from session
                                   @ModelAttribute HashMap<Pizza, Integer> pizzasToOrder) {

        TotalOrderCostCalculator totalOrderCostCalculator = new TotalOrderCostCalculator();
        if (totalOrderCostCalculator.getPizzasCount(pizzasToOrder) + count > totalOrderCostCalculator.getLimit()) {
            throw new MoreThanLimitPizzasException("Oops");
        } else {
            if (pizzasToOrder.containsKey(getPizzaById(id))) {
                pizzasToOrder.put(getPizzaById(id), pizzasToOrder.get(getPizzaById(id)) + count);
            } else pizzasToOrder.put(getPizzaById(id), count);
        }

        System.out.println("Pizza: " + getPizzaById(id) + "___" + "count: " + count);
        System.out.println(pizzasToOrder);
        System.out.println(pizzasToOrder.size());
        model.addAttribute("summ", totalOrderCostCalculator.calculateTotalOrderPrice(pizzasToOrder));
        model.addAttribute("pizzasToOrder", pizzasToOrder);
        return goToOrder(model);
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "submit", method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute HashMap<Pizza, Integer> pizzasToOrder) {
        Integer customerId = customerService.getIdByName(SecurityContextHolder.getContext().getAuthentication().getName());
        Integer accumulatedSumm = customerService.getCustomerById(customerId).getAccumulativeCard().getAccumulatedSumm();
        TotalOrderCostCalculator totalOrderCostCalculator = new TotalOrderCostCalculator();
        if (accumulatedSumm == null) accumulatedSumm = 0;
        Double discount = (double) accumulatedSumm;
        model.addAttribute("pizzasToOrder", pizzasToOrder);
        model.addAttribute("discount", discount);
        model.addAttribute("totalPrice", totalOrderCostCalculator.calculateTotalOrderPrice(pizzasToOrder));
        return "orderConfirmation";
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "confirm", method = RequestMethod.POST)
    public ModelAndView confirm(Model model,
                                @ModelAttribute HashMap<Pizza, Integer> pizzasToOrder,
                                @ModelAttribute Address newAddress,
                                HttpServletRequest request,
                                SessionStatus sessionStatus) {
        Integer customerId = customerService.getIdByName(SecurityContextHolder.getContext().getAuthentication().getName());
        Integer accumulatedSumm = customerService.getCustomerById(customerId).getAccumulativeCard().getAccumulatedSumm();
        if (accumulatedSumm == null) accumulatedSumm = 0;
        model.addAttribute("pizzasToOrder", pizzasToOrder);
        TotalOrderCostCalculator totalOrderCostCalculator = new TotalOrderCostCalculator();
        PizzaOrder pizzaOrder = new PizzaOrder();
        pizzaOrder.setAddress(newAddress);
        pizzaOrder.setPizzas(pizzasToOrder);
        Double sum = totalOrderCostCalculator.calculateTotalOrderPrice(pizzasToOrder) * 100 - accumulatedSumm / 100;
        pizzaOrder.setSumm(sum.longValue());
        pizzaOrder.setCustomerId(customerId);
        accumulatedSumm = accumulatedSumm + sum.intValue();
        pizzaOrder.setOrderDateTime(new GregorianCalendar(TimeZone.getTimeZone(ZoneId.systemDefault())));
        pizzaOrderService.save(pizzaOrder);
        Customer customer = customerService.getCustomerById(customerId);
        customer.getAccumulativeCard().setAccumulatedSumm(accumulatedSumm);
        customerService.update(customer);
        System.out.println(request.getSession().getId());
        sessionStatus.setComplete();
        request.getSession().invalidate();
        model.addAttribute("pizzasToOrder", null);
        return goToOrder(model);
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String viewUsers(Model model) {
        model.addAttribute("users", customerService.getAll());
        model.addAttribute("roleTypes", Roles.values());
        Object authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("auth", authorities);
        model.addAttribute("prin", principal);
        return "users";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public String goToAddNewUserForm(Model model) {
        model.addAttribute("roles", Roles.values());
        return "adduser";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "adduser", method = RequestMethod.POST)
    public String addNewUser(Model model,
//                             @ModelAttribute Customer newCustomer,
                             @RequestParam(value = "blocked", required = false) Boolean blocked,
                             @RequestParam(value = "ROLE_ADMIN", required = false) Boolean adminRole,
                             @RequestParam(value = "ROLE_USER", required = false) Boolean userRole,
                             @RequestParam(value = "name", required = true) String name,
                             @RequestParam(value = "password", required = true) String password) {
        Customer newCustomer = new Customer();
        AccumulativeCard accumulativeCard = new AccumulativeCard();
        List<Roles> roles = new ArrayList<>();
        if (blocked == null) blocked = false;
        if (adminRole != null) {
            roles.add(Roles.ROLE_ADMIN);
            roles.add(Roles.ROLE_USER);
        } else roles.add(Roles.ROLE_USER);
        newCustomer.setName(name);
        newCustomer.setBlocked(blocked);
        newCustomer.setRoles(roles);
        newCustomer.setPassword(password);
        newCustomer.setAccumulativeCard(accumulativeCard);
        customerService.save(newCustomer);
        return "users";
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/cabinet", method = RequestMethod.GET)
    public String goToCabinet(Model model) {
        Integer id = customerService.getIdByName(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("orders", pizzaOrderService.getPizzaOrdersByCustomerId(id));
        model.addAttribute("accumulativeCard", accumulativeCardService.getAccumulativeCardById(id));
        return "cabinet";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String goToAdminPanel(Model model) {
        Integer id = customerService.getIdByName(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("orders", pizzaOrderService.getAll());
        return "admin";
    }

    //put empty map into session(init); return type of method
    // must be the same as in  @SessionAttributes(types = HashMap.class) - see at top
    @ModelAttribute
    public HashMap<Pizza, Integer> init() {
        return new HashMap<Pizza, Integer>();
    }

//    @ExceptionHandler(Exception.class)
//    public ModelAndView handleIOException(Exception exception, Model model) {
//        model.addAttribute("msg", "There is more than ten pizzas in one order!");
//        return sessionAttributes(model);
//    }

}
