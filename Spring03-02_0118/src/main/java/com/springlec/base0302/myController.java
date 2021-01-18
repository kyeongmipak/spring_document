package com.springlec.base0302;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 내가 만드는 controller
// 아래 @ 선언해줘야 controller인지 인지한다.
@Controller
public class myController {

	@RequestMapping("test/view1")
	public String view1() {
		return "test/view1";
	}
	
	@RequestMapping("test/view2")
	public String view2(Model model) { // data를 넘겨야하므로 model을 기입해 준다.
		
		model.addAttribute("id", "tester");
		
		return "test/viewid";
	
		
	}
	
}
