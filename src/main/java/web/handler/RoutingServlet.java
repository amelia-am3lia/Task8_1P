package web.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import web.service.LoginService;
import web.service.MathQuestionService;

@Controller
@RequestMapping
public class RoutingServlet {

	@GetMapping("/")
	public String welcome() {
		System.out.println("Welcome ...");
		return "view-welcome";
	}
	@GetMapping("/login")
	public String loginView() {
		System.out.println("login view...");
		return "view-login";
	}
	@PostMapping("/login")
	public RedirectView login(
			HttpServletRequest request, 
			RedirectAttributes redirectAttributes) {
		System.out.println("login form...");
		String username = request.getParameter("username");
		String password = request.getParameter("passwd");
		String dob = request.getParameter("dob");
		System.out.println("Username/password: " + username + ", " + password);
		RedirectView redirectView = null;
		if (LoginService.login(username, password, dob)) {
			redirectView = new RedirectView("/q1", true);
		} else {
			// Login failed, stay with login page.
			//
			redirectView = new RedirectView("/login", true);
			// Show error message
			//
			redirectAttributes.addFlashAttribute("message", "Incorrect credentials.");
		}
		return redirectView;
	}
	

	@GetMapping("/q1")
	public String q1View() {		
		System.out.println("q1 view...");
		return "view-q1";
	}

	@PostMapping("/q1")
	public RedirectView q1(HttpServletRequest request, RedirectAttributes redirectAttributes) 
	{
		RedirectView redirectView = null;
		System.out.println("q1 form...");
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		String resultUser = request.getParameter("result");
		//handle null inputs
		if(number1 == null || number2 == null || resultUser == null)
		{
			redirectAttributes.addFlashAttribute("message", "Null values not accepted. Try again.");
			redirectView = new RedirectView("/q1", true);
			return redirectView;
		}
		// handle any empty inputs
		if(number1.isEmpty() || number2.isEmpty() || resultUser.isEmpty())
		{
			redirectAttributes.addFlashAttribute("message", "Please complete all fields");
			redirectView = new RedirectView("/q1", true);
			return redirectView;
		}
		// handle any string inputs
		try {
			Double.valueOf(resultUser);
			Double.valueOf(number1);
			Double.valueOf(number2);
		}
		catch(Exception e) {
			redirectAttributes.addFlashAttribute("message", "Please only enter numbers.");
			redirectView = new RedirectView("/q1", true);
			return redirectView;
		}
		// after checkign numbers are usable, calculate result
		double calculatedResult = MathQuestionService.q1Addition(number1, number2);
		// last error check as fallback
		if(calculatedResult == 9999)
		{
			redirectAttributes.addFlashAttribute("message", "Ivalid input, try again.");
			redirectView = new RedirectView("/q1", true);
			return redirectView;
		}
		// check if user correct and move to next q, or let them try again
		if (calculatedResult == Double.valueOf(resultUser)) {
			redirectView = new RedirectView("/q2", true);
			System.out.println("User result: " + resultUser + ", answer: " + calculatedResult);
			return redirectView;
		} 
		else {
			// Q1 wrong.
			//
			redirectView = new RedirectView("/q1", true);
			// Show error message
			//
			redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
		}		
		return redirectView;
	}	
	

	@GetMapping("/q2")
	public String q2View() {		
		System.out.println("q2 view...");
		return "view-q2";
	}	


	@PostMapping("/q2")
	public RedirectView q2(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		RedirectView redirectView = null;
		System.out.println("q2 form...");
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		String resultUser = request.getParameter("result");
		//handle null inputs
		if(number1 == null || number2 == null || resultUser == null)
		{
			redirectAttributes.addFlashAttribute("message", "Null values not accepted. Try again.");
			redirectView = new RedirectView("/q2", true);
			return redirectView;
		}
		// handle any empty inputs
		if(number1.isEmpty() || number2.isEmpty() || resultUser.isEmpty())
		{
			redirectAttributes.addFlashAttribute("message", "Please complete all fields");
			redirectView = new RedirectView("/q2", true);
			return redirectView;
		}
		// handle any string inputs
		try {
			Double.valueOf(resultUser);
			Double.valueOf(number1);
			Double.valueOf(number2);
		}
		catch(Exception e) {
			redirectAttributes.addFlashAttribute("message", "Please only enter numbers.");
			redirectView = new RedirectView("/q2", true);
			return redirectView;
		}
		// after checkign numbers are usable, calculate result
		double calculatedResult = MathQuestionService.q2Subtraction(number1, number2);
		// last error check as fallback
		if(calculatedResult == 9999)
		{
			redirectAttributes.addFlashAttribute("message", "Ivalid input, try again.");
			redirectView = new RedirectView("/q2", true);
			return redirectView;
		}
		// check if user correct and move to next q, or let them try again
		if (calculatedResult == Double.valueOf(resultUser)) {
			redirectView = new RedirectView("/q3", true);
			System.out.println("User result: " + resultUser + ", answer: " + calculatedResult);
			return redirectView;
		} 
		else {
			// Q1 wrong.
			//
			redirectView = new RedirectView("/q2", true);
			// Show error message
			//
			redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
		}		
		return redirectView;
	}	
	

	@GetMapping("/q3")
	public String q3View() {		
		System.out.println("q3 view...");
		return "view-q3";
	}	
	
	@PostMapping("/q3")
	public RedirectView q3(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		RedirectView redirectView = null;
		System.out.println("q3 form...");
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		String resultUser = request.getParameter("result");
		//handle null inputs
		if(number1 == null || number2 == null || resultUser == null)
		{
			redirectAttributes.addFlashAttribute("message", "Null values not accepted. Try again.");
			redirectView = new RedirectView("/q3", true);
			return redirectView;
		}
		// handle any empty inputs
		if(number1.isEmpty() || number2.isEmpty() || resultUser.isEmpty())
		{
			redirectAttributes.addFlashAttribute("message", "Please complete all fields");
			redirectView = new RedirectView("/q3", true);
			return redirectView;
		}
		// handle any string inputs
		try {
			Double.valueOf(resultUser);
			Double.valueOf(number1);
			Double.valueOf(number2);
		}
		catch(Exception e) {
			redirectAttributes.addFlashAttribute("message", "Please only enter numbers.");
			redirectView = new RedirectView("/q3", true);
			return redirectView;
		}
		// after checkign numbers are usable, calculate result
		double calculatedResult = MathQuestionService.q3Multiplication(number1, number2);
		// last error check as fallback
		if(calculatedResult == 9999)
		{
			redirectAttributes.addFlashAttribute("message", "Ivalid input, try again.");
			redirectView = new RedirectView("/q3", true);
			return redirectView;
		}
		// check if user correct and move to next q, or let them try again
		if (calculatedResult == Double.valueOf(resultUser)) {
			redirectView = new RedirectView("/end", true);
			System.out.println("User result: " + resultUser + ", answer: " + calculatedResult);
			return redirectView;
		} 
		else { 
			// Q1 wrong.
			//
			redirectView = new RedirectView("/q3", true);
			// Show error message
			//
			redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
		}		
		return redirectView;
	}	
	
	@GetMapping("/end")
	public String endView() {		
		System.out.println("End view...");
		return "view-end";
	}	
	@PostMapping("/end")
	public RedirectView end(
	        HttpServletRequest request,
	        RedirectAttributes redirectAttributes) {
	    System.out.println("End of questions...");
	    String action = request.getParameter("action");
	    RedirectView redirectView = null;
	    if ("restart".equals(action)) {
	        System.out.println("Restarting quiz...");
	        redirectView = new RedirectView("/q1", true);
	    } else {

	        redirectView = new RedirectView("/end", true);
	        redirectAttributes.addFlashAttribute(
	            "message",
	            "Invalid option selected."
	        );
	    }
	    return redirectView;
	}
}
