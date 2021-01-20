package com.springlec.base0702.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.springlec.base0702.dto.BDto;
import com.springlec.base0702.util.Constant;

public class BDao {

	// 내가 만든 jdbc를 사용하겠다.
	JdbcTemplate template;
	
	public BDao() {
		// TODO Auto-generated constructor stub
		// constant class 파일을 가져와서 사용하므로
		// 기존에 사용하던 코드는 필요없다.
		this.template = Constant.template;
		
	}
	
	// final을 붙여 변수가 변하지 않다고 선언해준다.
	public void write(final String addressName, final String addressTel, final String addressAddress, final String addressEmail, final String addressRelation) {
		// TODO Auto-generated method stub
		
		// new PreparedStatementCreator()로 insert 할때 ?값을 넣어주기 위해
		// Creator 이면 Insert이다.
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String query = "insert into mvc_address (addressName, addressTel, addressAddress, addressEmail, addressRelation) values (?, ?, ?, ?, ?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, addressName);
				pstmt.setString(2, addressTel);
				pstmt.setString(3, addressAddress);
				pstmt.setString(4, addressEmail);
				pstmt.setString(5, addressRelation);
				return pstmt;
			}
		});
		
	}
		
	public ArrayList<BDto> list() {

		String query = "select addressId, addressName, addressTel, addressAddress, addressEmail, addressRelation from mvc_address";

		return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		
	}

	
	public BDto contentView(String strID) {
		// TODO Auto-generated method stub
		String query = "select * from mvc_address where addressId = " + strID;
		
		// queryForObject는 한개의 값만 가져올 때 사용한다.
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));		
		
	}
	
	public void modify(final String addressId, final String addressName, final String addressTel, final String addressAddress, final String addressEmail, final String addressRelation) {
		// TODO Auto-generated method stub
		
		String query = "update mvc_address set addressName = ?, addressTel = ?, addressAddress = ?, addressEmail = ?, addressRelation = ? where addressId = ?";
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, addressName);
				ps.setString(2, addressTel);
				ps.setString(3, addressAddress);
				ps.setString(4, addressEmail);
				ps.setString(5, addressRelation);
				ps.setString(6, addressId);
			}
		});

	}
		
	public void delete(final String addressId) {
		// TODO Auto-generated method stub
		String query = "delete from mvc_address where addressId = ?";
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, addressId); // 빨간줄 뜨면 매개변수 앞에 final 을 넣어준다.
			}
		});
		
	}
	
}
