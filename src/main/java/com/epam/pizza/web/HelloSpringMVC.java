package com.epam.pizza.web;


import com.epam.pizza.domain.Pizza;
import com.epam.pizza.domain.PizzaType;
import com.epam.pizza.repository.PizzaRepository;
import com.epam.pizza.repository.impl.JPAPizzaRepository;
import com.epam.pizza.services.impl.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by dennis on 8/7/2015.
 */
@Controller("helloController")
public class HelloSpringMVC {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello SpringMVC";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String handleDefaultRequest(Model model) throws Exception {
        model.addAttribute("msg", new Date());
        return "hello";
    }

}
