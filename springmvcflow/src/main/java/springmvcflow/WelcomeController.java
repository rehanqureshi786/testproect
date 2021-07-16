package springmvcflow;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@RequestMapping(value="/codeN",method= RequestMethod.GET)
	
	public ModelAndView helloWorld(ModelAndView model)
	{
		String message="This is Spring Mvc Flow";
		System.out.println(message);
		model.addObject("welcomeMessage",message);
		model.setViewName("welcomePage");
		
		return model;
		
		
	}//ModelAndView Closs
}
