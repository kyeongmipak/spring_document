package com.springlec.base0601.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.springlec.base0601.dto.BDto;

public class BDao {

	DataSource dataSource;
	
	public BDao() {
		// TODO Auto-generated constructor stub
		try {
			//context : javax.naming
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
		
	public ArrayList<BDto> list(){
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select bId, bName, bTItle, bContent, bDate from mvc_board";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int bId =resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTItle = resultSet.getString("bTItle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				
				BDto dto = new BDto(bId, bName, bTItle, bContent, bDate);
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try{
				if(resultSet!=null) resultSet.close();
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}
		
		return dtos;
	}
	
	
	// insert
	public void write(String bName, String bTitle, String bContent) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into mvc_board (bName, bTitle, bContent, bDate) values (?,?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,  bName);
			preparedStatement.setString(2,  bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try{
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}
	}
	
	// content select
	public BDto contentView(String bId){
		BDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select bId, bName, bTItle, bContent, bDate from mvc_board where bId = ?";
			preparedStatement = connection.prepareStatement(query); // query 문장 연결
			preparedStatement.setInt(1, Integer.parseInt(bId));
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int inbId =resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTItle = resultSet.getString("bTItle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				
				dto = new BDto(inbId, bName, bTItle, bContent, bDate);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try{
				if(resultSet!=null) resultSet.close();
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}
		
		return dto;
	}
	
	// update
	public void update(String bId, String bName, String bTitle, String bContent) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ?, bDate = now() where bId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,  bName);
			preparedStatement.setString(2,  bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.setInt(4, Integer.parseInt(bId));
			preparedStatement.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try{
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}
	}

	// delete
	public void delete(String bId) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "delete from mvc_board where bId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(bId));
			preparedStatement.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try{
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}
	}
	
		
} //-------
	
