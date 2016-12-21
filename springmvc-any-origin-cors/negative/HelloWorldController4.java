//negative example
//The @CrossOrigin annotation is set to the POST method with default values
//By default all origins and GET, HEAD and POST methods are allowed.

package com.programcreek.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController4 {

    String message = "Welcome to Spring MVC!";

    @ModelAttribute(value="Student")
    public Student form(){

        return new Student();
    }

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public ModelAndView showMessage(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        System.out.println("in controller");

        ModelAndView mv = new ModelAndView("helloworld");
        mv.addObject("message", message);
        mv.addObject("name", name);
        return mv;
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String add(@ModelAttribute("SpringWeb")Student student, ModelMap model) {
        System.out.println("in POST");
        model.addAttribute("name", student.getName());
        model.addAttribute("age", student.getAge());
        model.addAttribute("id", student.getId());

        return "helloworld";
    }
}
