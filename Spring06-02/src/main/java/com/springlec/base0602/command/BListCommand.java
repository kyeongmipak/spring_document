package com.springlec.base0602.command;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springlec.base0602.dao.BDao;
import com.springlec.base0602.dto.BDto;

public class BListCommand implements BCommand {
	
	//////////////////////////////
	// 1.20 추가
	private BDao dao = null;
	
	@Autowired // 선언해야 xml의 이름을 불러온다.
	public void setDao(BDao dao) { // BDao dao는 context.xml의 이름이다.
		this.dao = dao;
	}
	//////////////////////////////

	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

	
		ArrayList<BDto> dtos = dao.list();
		model.addAttribute("list", dtos);
		
		
	}

}
