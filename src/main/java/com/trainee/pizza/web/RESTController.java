package com.trainee.pizza.web;

import com.trainee.pizza.domain.Pizza;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.beans.PropertyEditorSupport;


/**
 * Created by dennis on 8/12/2015.
 */
@RestController
public class RESTController extends AbstractController {


    protected Pizza getPizzaById(Integer id) {
        return pizzaService.getPizzaById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "hello")
    public ResponseEntity<String> hello() {
//        return "hello from rest controller";
        return new ResponseEntity<>("Hello from rest controller", HttpStatus.I_AM_A_TEAPOT);
    }

    @RequestMapping(value = "pizza/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pizza> viewPizzaById(@PathVariable("id") Pizza pizza) {
        if(pizza==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pizza, HttpStatus.OK);
    }

    @RequestMapping(value = "/pizza", method = RequestMethod.POST, headers = "Content-Type=application/json")
    public ResponseEntity<?> createNewPizza(@RequestBody Pizza pizza, UriComponentsBuilder builder) {
        pizzaService.save(pizza);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/pizza/{id}").buildAndExpand(pizza.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @Override
    @InitBinder
    protected void pizzaBinder(WebDataBinder binder){
        binder.registerCustomEditor(Pizza.class,
                new PropertyEditorSupport(){
                    @Override
                    public void setAsText(String id){
                        Pizza pizza = null;
                        if(id != null && !id.trim().isEmpty()){
                            Integer ID = Integer.valueOf(id);
                            pizza = getPizzaById(ID);
                        }
                        setValue(pizza);
                    }
                });
    }
}
