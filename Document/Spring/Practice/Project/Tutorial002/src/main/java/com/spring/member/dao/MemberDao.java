package com.spring.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.member.ojbect.Member;
@Repository
public class MemberDao implements IMemberDao {
	
	@Autowired
	private DataSource datasource;
	
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	@Override
	public int memberInsert(Member member) {
		
		int result = 0;
		final String sql = 
				"INSERT INTO nike_member (firstName, lastName, account, password)"+
				" values (?,?,?,?)";
		try {
			conn = datasource.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getFn());
			pstmt.setString(2, member.getLn());
			pstmt.setString(3, member.getAccount());
			pstmt.setString(4, member.getPassword());
			result = pstmt.executeUpdate();
				
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public Member memberSelect(Member member) {
		Member mem = null;
		
		final String sql = "SELECT * FROM nike_member WHERE account = ? AND password = ?";
		
		
		try {
			conn = datasource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getAccount());
			pstmt.setString(2, member.getPassword());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String account = rs.getString("account");
				String password = rs.getString("password");
				
				mem.setFn(firstName);
				mem.setLn(lastName);
				mem.setAccount(account);
				mem.setPassword(password);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if ( conn != null ) conn.close();
				if ( pstmt != null ) pstmt.close();
				if ( rs != null ) rs.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mem;
	}

	@Override
	public int memberUpdate(Member member) {
		int result = 0;
		final String sql = "UPDATE member SET password = ? WHERE account = ?";
		try {
			
			conn = datasource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getAccount());
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null)pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int memberDelete(Member member) {
		
		int result = 0;
		final String sql = "DELETE member WHERE account = ? password = ?";
		try {
			conn = datasource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,member.getAccount());
			pstmt.setString(2,member.getPassword());
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int userCheck(Member member) {
		String dbpassword = "";
		int x = -1;
		
		final String sql = "SELECT * FROM nike_member where account = ?";
		try {
			conn = datasource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getAccount());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dbpassword = rs.getString("password");
				if(dbpassword.equals(member.getPassword()))
					x = 1;
				else
					x = 0;
			}
			else 
				x = -1;
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return x;
	}

	@Override
	public ArrayList<Member> getMemberList() {
		
		Member member = null;
		ArrayList<Member> member_list = null;
		
		final String sql = "SELECT * FROM nike_member ORDER BY account";
		try {
			conn = datasource.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member_list = new ArrayList<Member>();
				do {
					member = new Member();
					member.setFn("firstName");
					member.setLn("lastName");
					member.setAccount("account");
					member.setPassword("password");
					
					member_list.add(member);
				}while(rs.next());
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
				if (rs != null) rs.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return member_list;
	}

}
