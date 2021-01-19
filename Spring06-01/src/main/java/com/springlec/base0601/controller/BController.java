package com.springlec.base0601.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0601.command.BCommand;
import com.springlec.base0601.command.BContentViewCommand;
import com.springlec.base0601.command.BDeleteCommand;
import com.springlec.base0601.command.BListCommand;
import com.springlec.base0601.command.BUpdateCommand;
import com.springlec.base0601.command.BWriteCommand;

@Controller
public class BController {

	BCommand command = null;
	
	@RequestMapping("list")
	public String list(Model model) {
		
		System.out.println("list()");
		command = new BListCommand();
		command.execute(model);
		
		return "list";
	}
	
	
	@RequestMapping("write_view")
	public String write_view() { // jsp 부르는거라 model 없어도 된다.
		
		System.out.println("write_view()");
		
		return "write_view";
	}
	
	
	@RequestMapping("write")
	public String write(HttpServletRequest request, Model model) { // request로 값을 받아야 하므로 정의 해준다.
		
		System.out.println("write()");
		model.addAttribute("request", request); // 여기서 "request"는 나갈 request이다.
		command = new BWriteCommand();
		command.execute(model);
		
		//return "list"; // list.jsp를 부른다. 그래서 redirect를 이용하여 controller로 온다.
		return "redirect:list"; // redirect: 는 controller 안에 잇는 list를 부르는것이다.
	
	}
	
	@RequestMapping("update_view")
	public String update_view(HttpServletRequest request, Model model) { // request로 값을 받아야 하므로 정의 해준다.
		
		System.out.println("update_view()");
		
		model.addAttribute("request", request);
		command = new BContentViewCommand();
		command.execute(model);
		
		
		return "content_view"; // redirect: 는 controller 안에 잇는 list를 부르는것이다.
	
	}
	
	@RequestMapping("update")
	public String update(HttpServletRequest request, Model model) { // request로 값을 받아야 하므로 정의 해준다.
		
		System.out.println("update()");
		
		model.addAttribute("request", request);
		command = new BUpdateCommand();
		command.execute(model);
		
		
		return "redirect:list"; // redirect: 는 controller 안에 잇는 list를 부르는것이다.
	
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model) { // request로 값을 받아야 하므로 정의 해준다.
		
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		
		
		return "redirect:list"; // redirect: 는 controller 안에 잇는 list를 부르는것이다.
	
	}

	
}
