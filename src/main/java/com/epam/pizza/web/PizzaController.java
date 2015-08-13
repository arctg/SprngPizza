package com.epam.pizza.web;

import com.epam.pizza.domain.*;
import com.epam.pizza.repository.PizzaRepository;
import com.epam.pizza.services.PizzaService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dennis on 8/10/2015.
 */
@Controller("pizzaController")
@SessionAttributes(types = HashMap.class)
public class PizzaController extends AbstractController {

    @Autowired
    private PizzaService pizzaService;

    @RequestMapping(value = "/pizzas", method = RequestMethod.GET)
    public String viewPizzas(Model model) {
        model.addAttribute("pizzas", pizzaService.getAllPizzas());
        model.addAttribute("pizzaTypes", PizzaType.values());
        return "pizzas";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String addNewPizza(Model model) {
        model.addAttribute("pizzaTypes", PizzaType.values());
        return "create";
    }

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

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deletePizza(Model model, @RequestParam(value = "id") Integer id) {
        pizzaService.delete(id);
        model.addAttribute("pizzaTypes", PizzaType.values());
        return viewPizzas(model);
    }


    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ModelAndView sessionAttributes(Model model) {
        ModelAndView modelAndView = new ModelAndView("order");
        model.addAttribute("pizzas", pizzaService.getAllPizzas());
        return modelAndView;
    }

    @RequestMapping(value = "order", method = RequestMethod.POST)
    public ModelAndView addToOrder(Model model,
                                   @RequestParam(value = "id") Integer id,
                                   @RequestParam(value = "customer") String name,
                                   @RequestParam(value = "count") Integer count,
                                   //????? ?? ?????? ????
                                   @ModelAttribute HashMap<Pizza, Integer> pizzasToOrder) {
        if (pizzasToOrder.containsKey(getPizzaById(id))) {
            pizzasToOrder.put(getPizzaById(id), pizzasToOrder.get(getPizzaById(id)) + count);
        } else pizzasToOrder.put(getPizzaById(id), count);
        System.out.println("Pizza: " + getPizzaById(id) + "___" + "count: " + count);
        System.out.println(pizzasToOrder);
        System.out.println(pizzasToOrder.size());
        try {
            TotalOrderCostCalculator totalOrderCostCalculator = new TotalOrderCostCalculator();
            model.addAttribute("summ", totalOrderCostCalculator.calculateTotalOrderPrice(pizzasToOrder));
            model.addAttribute("pizzasToOrder", pizzasToOrder);
        } catch (Exception ex) {
            model.addAttribute("msg", "There is more than ten pizzas in one order!");
        }

        TotalOrderCostCalculator totalOrderCostCalculator = new TotalOrderCostCalculator();
        model.addAttribute("summ", totalOrderCostCalculator.calculateTotalOrderPrice(pizzasToOrder));
        return sessionAttributes(model);
    }

    //????? ? ?????? ?????? ????(??????????????); ??? ?????????????
    // ?????? ????????? ? ????? ????????? ?????? ? @SessionAttributes(types = HashMap.class) - ?????
    @ModelAttribute
    public HashMap<Pizza, Integer> init() {
        return new HashMap<Pizza, Integer>();
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleIOException(Exception exception, Model model) {
        model.addAttribute("msg", "There is more than ten pizzas in one order!");
        return sessionAttributes(model);
    }

}
