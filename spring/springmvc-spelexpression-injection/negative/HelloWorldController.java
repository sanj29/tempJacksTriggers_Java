package com.programcreek.helloworld.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.*;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.ModelAndView;
import com.programcreek.helloworld.controller.Student;

@CrossOrigin(maxAge = 3600, methods = {RequestMethod.GET, RequestMethod.POST})
@Controller
public class HelloWorldController {

    public String message = "Welcome to Spring MVC!";

    @Value("#{ systemProperties['JAVA_HOME'] }")
    public String defaultLocale;

    @ModelAttribute(value="Student")
    public Student form(){

        return new Student();
    }

    @CrossOrigin(origins = "http://domain2.com,http://domain1.com", maxAge=3600, methods = {RequestMethod.GET})
    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public ModelAndView showMessage(
				    @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        System.out.println("in controller");

        ModelAndView mv = new ModelAndView("helloworld");
        mv.addObject("message", message);
        mv.addObject("name", name);

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression(name);

        String message = (String) exp.getValue();

        System.out.println("Expression parsed: "+message);

        //Evaluating on something by providing context
	//		EvaluationContext context = new StandardEvaluationContext(this);
	//		String evalName = (String) exp.getValue(context);
	//
	//		System.out.println("Context expression parsed: "+evalName);

        return mv;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String add(@ModelAttribute("SpringWeb")Student student, ModelMap model) {
        System.out.println("in POST");
        model.addAttribute("name", student.getName());
        model.addAttribute("age", student.getAge());
        model.addAttribute("id", student.getId());

        return "helloworld";
    }
}
