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

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;
import java.util.HashMap;

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
    public String addNewPizza(Model model, @ModelAttribute Pizza newPizza) {
        // pizzaService.save(new Pizza(name,price,pizzaType));
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
        model.addAttribute("pizzasToOrder", pizzasToOrder);
        return "orderConfirmation";
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "confirm", method = RequestMethod.POST)
    public ModelAndView confirm(Model model,
                                @ModelAttribute HashMap<Pizza, Integer> pizzasToOrder,
                                @ModelAttribute Address newAddress,
                                HttpServletRequest request,
                                SessionStatus sessionStatus) {
        model.addAttribute("pizzasToOrder", pizzasToOrder);
        PizzaOrder pizzaOrder = new PizzaOrder();
        pizzaOrder.setAddress(newAddress);
        pizzaOrder.setPizzas(pizzasToOrder);
        System.out.println(newAddress);
        System.out.println(pizzaOrder);
        pizzaOrderService.save(pizzaOrder);
        System.out.println(request.getSession().getId());
        sessionStatus.setComplete();
        request.getSession().invalidate();
        model.addAttribute("pizzasToOrder", null);
        return goToOrder(model);
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
