package com.springlec.base0702.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springlec.base0702.dao.BDao;

public class BDeleteCommand implements BCommand {

	
	private BDao dao = null;
	
	@Autowired // 선언해야 xml의 이름을 불러온다.
	public void setDao(BDao dao) { // BDao dao는 context.xml의 이름이다.
		this.dao = dao;
	}
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String addressId = request.getParameter("addressId");
		dao.delete(addressId);
		
		
	}

}
