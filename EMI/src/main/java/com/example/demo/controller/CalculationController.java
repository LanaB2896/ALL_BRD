package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Performance;
import com.example.demo.service.EMICalculator;


@Controller
public class CalculationController {

	@Autowired
	private EMICalculator emis;
	@RequestMapping(value="/Value", method= RequestMethod.GET)
public String insert(Model model)
//	public String insert(m)
	{
		model.addAttribute("userValues", new Performance());
		return "console";	
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String push(@RequestParam("principle")Float principle, 
			@RequestParam("rateofinterest")Float rateofinterest,
			@RequestParam("tenure")Float tenure,
			@RequestParam("noOfInstallenment")Float noOfInstallenment)
	{
		this.emis = new EMICalculator(principle, rateofinterest, tenure, noOfInstallenment);  
		return "hai";
		
	}
	
}
