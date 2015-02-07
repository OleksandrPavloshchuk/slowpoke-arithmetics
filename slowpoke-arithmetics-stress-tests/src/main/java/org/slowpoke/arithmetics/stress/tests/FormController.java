package org.slowpoke.arithmetics.stress.tests;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FormController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("testData", new TestData());
		return "form";
	}

	@RequestMapping(value = "/report", method = RequestMethod.POST)
	public String submit(@ModelAttribute TestData testData, Model model) {
		testData.perform();
		model.addAttribute("testData", testData);
		return "result";
	}
}
