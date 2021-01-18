package com.springlec.base0503;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedurectController {

	@RequestMapping("studentConfirm")
	public String studentRedirect(HttpServletRequest httpServletRequest, Model model) {
		String id = httpServletRequest.getParameter("id");
		
		if(id.equals("abc")) {
			return "redirect:studentOK2"; // JSP가 아니다, 해당 url로 이동하는 역할이 redirect:(mapping명) 이다. 해당 맵핑으로 이동
		}
		
		return "redirect:studentNG2";
	}
	
	@RequestMapping("studentOK2")
	public String studentOK() {
		return "student/studentOK"; // 폴더명 / jsp 파일명 
	}

	@RequestMapping("studentNG2")
	public String studentNG() {
		return "student/studentNG";
	}
	
}
