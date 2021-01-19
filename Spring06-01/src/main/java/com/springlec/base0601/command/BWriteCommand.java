package com.springlec.base0601.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.springlec.base0601.dao.BDao;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		// 데이터 받아온다.
		// MODEL로 들어온 값을 키값과 value 값으로 벗긴다.(암호화 되어 있기 때문에)
		// object인 경우는 value값이 int 인지, string 인지 모르기 때문에
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request"); // model 이름이 requset : controller에서 설정한 model 이름
		
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BDao dao = new BDao();
		dao.write(bName, bTitle, bContent);
	}

}
