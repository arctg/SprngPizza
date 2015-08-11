package com.epam.pizza.web;

import com.epam.pizza.domain.Pizza;
import com.epam.pizza.domain.PizzaType;
import com.epam.pizza.repository.PizzaRepository;
import com.epam.pizza.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by dennis on 8/10/2015.
 */
@Controller("pizzaController")
public class PizzaController {

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
    public String addNewPizza(@ModelAttribute Pizza newPizza) {
        // pizzaService.save(new Pizza(name,price,pizzaType));
        System.out.println(newPizza.getId());
        pizzaService.save(newPizza);
//        return viewPizzas(model);
        return "redirect:";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editPizza(Model model, @RequestParam(value = "id") Integer id) {
        Pizza pizza = pizzaService.getPizzaById(id);
        model.addAttribute("pizza", pizza);
        System.out.println(pizza.getId());
        return addNewPizza(model);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deletePizza(Model model, @RequestParam(value = "id") Integer id){
        pizzaService.delete(id);
        model.addAttribute("pizzaTypes", PizzaType.values());
        return viewPizzas(model);
    }


}
