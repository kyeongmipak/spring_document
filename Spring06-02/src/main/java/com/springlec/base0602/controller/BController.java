package com.springlec.base0602.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springlec.base0602.command.BCommand;

@Controller
public class BController {
	
	/////////////////////////////
	// 1.20 추가
	BCommand listCommand = null;
	BCommand writeCommand = null;
	BCommand modifyCommand = null;
	BCommand deleteCommand = null;
	BCommand contentCommand = null;
	
	// list command와 연결시키는 역할 : autowired
	// list, write .. 이런식으로 command bean을 옆으로 추가해준다.
	@Autowired
	public void auto(BCommand list, BCommand write, BCommand modify, BCommand delete, BCommand content) { // BCommand list의 list는 servlet-context에서 정의한 이름을 쓴다.
		this.listCommand = list;
		this.writeCommand = write;
		this.modifyCommand = modify;
		this.deleteCommand = delete;
		this.contentCommand = content;
	}

	/////////////////////////////
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		// new할 필요가 없어 바로 execute한다.
		listCommand.execute(model);
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		
		model.addAttribute("request", request);
		writeCommand.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model){
		System.out.println("content_view()");
		
		model.addAttribute("request", request);
		
		contentCommand.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST )
	public String modify(HttpServletRequest request, Model model){
		System.out.println("modify()");
		
		model.addAttribute("request", request);
		modifyCommand.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		deleteCommand.execute(model);
		
		return "redirect:list";
	}
	
	
}
