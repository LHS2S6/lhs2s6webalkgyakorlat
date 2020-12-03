package com.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

@Controller

public class MainController{
 
	@RequestMapping("/")
   public String showPage() {
     

      return "main";
   }

}