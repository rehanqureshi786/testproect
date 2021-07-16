package springmvcflow;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstSpringMvc {
	@RequestMapping("/firstmvc")
	public ModelAndView helloWorld(ModelMap model,HttpServletRequest req)
	{
		String message="This is my first Mvc Application!!1";
		System.out.println(message);
		model.addAttribute("message",message);
		return new ModelAndView("welcome","welcomeMessage",message);
	}

}
