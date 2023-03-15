package com.jjang051.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDao {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "TIS001";
	private String pw = "1234";

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public void getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int insertBoard(BoardDto boardDto) {
		int result = 0;
		try {
			getConnection();
			String sql = "INSERT INTO BOARD02 VALUES (BOARD02_SEQ.NEXTVAL,?,?,SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getUserName());
			pstmt.setString(2, boardDto.getContents());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	public ArrayList<BoardDto> getAll() {
		ArrayList<BoardDto> boardList = null;
		
		try {
			getConnection();
			String sql = "SELECT * FROM BOARD02";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			boardList= new ArrayList<>();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setNo(rs.getInt("no"));
				boardDto.setUserName(rs.getString("userName"));
				boardDto.setContents(rs.getString("contents"));
				boardDto.setRegDate(rs.getString("regDate"));
				boardList.add(boardDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return boardList;
	}

	public BoardDto getSelectOne(int no) {
		BoardDto boardDto = null;
		try {
			getConnection();
			String sql = "SELECT * FROM BOARD02 WHERE NO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				boardDto = new BoardDto();
				boardDto.setNo(rs.getInt("no"));
				boardDto.setUserName(rs.getString("userName"));
				boardDto.setContents(rs.getString("contents"));
				boardDto.setRegDate(rs.getString("regDate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return boardDto;
	}
}





