package com.springlec.base0401;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	//-----------------------------------------------------
	// version 4는 @@RequestParm 사용한다.
	// get parameter를 사용할 때 
	
	@RequestMapping("board/confirmid") // version 3	
	public String confirmId(HttpServletRequest httpServletRequest, Model model) { //request : url의 변수값 가져오는 역할, model : 처리 후 넘겨주는 역할
		// get 방식 사용
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");
		
		
		model.addAttribute("id", id); // get한 id를 model을 통해 view 로 보낸다.
		model.addAttribute("pw", pw);
		
		return "board/confirmid";
		
	}
	
	@RequestMapping("board/checkId") // version 4	
	public String checkId(@RequestParam("id") String id, @RequestParam("pw") int pw, Model model) { 
		
	// @RequestParam("id") String id는 HttpServletRequest와 같은 역할로 바로 id값을 가져온다.
		
		model.addAttribute("identify", id);
		model.addAttribute("password", pw);
		
		return "board/checkId";
		
	}
	
	//-------------------------------------------------
	// bean으로 데이터 받고 넘길때
	// version 4
	@RequestMapping("board/join")
	public String join(@RequestParam("name") String name, @RequestParam("id") String id,
			@RequestParam("pw") String pw, @RequestParam("email") String email, Model model) {
		
		Member member = new Member();
		member.setName(name);
		member.setId(id);
		member.setPw(pw);
		member.setEmail(email);
		
		model.addAttribute("member", member); //bean으로 보내면 보안에는 좋지만 매개변수가 너무 길어진다.
		return "board/join";
		
	}
	
	// 매개변수를 bean으로 바로 받을 경우
	// version4
	@RequestMapping("board/join2")
	public String join2(Member member) {
		return "board/join";
	}
	
	// version 4
	// http://localhost:8080/base0401/student/1234/qkr : url 입력
	@RequestMapping("student/{studentId}/{student}") //{ 데이터값 } : @PathVariable 의 데이터 값을 url 에 넣어준다. 
	public String student(@PathVariable String studentId, @PathVariable String student, Model model) {
		
		model.addAttribute("studentId", studentId);
		model.addAttribute("student", student);
		return "board/studentView";
	}
	
}
