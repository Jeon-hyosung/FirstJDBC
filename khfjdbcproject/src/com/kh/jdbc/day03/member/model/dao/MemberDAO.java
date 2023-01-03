package com.kh.jdbc.day03.member.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.jdbc.day03.member.model.vo.Member;

public class MemberDAO {	
	
	private Properties prop;
	
	public MemberDAO() {
		prop = new Properties();
		try {
			FileReader reader = new FileReader("resources/query.properties");
			prop.load(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 전체 회원 정보 조회
	 * @param conn
	 * @return
	 */
	public List<Member> selectAll(Connection conn){
		List<Member> mList = null;
		String sql = prop.getProperty("selectAll");
			try {
				Statement stmt = conn.createStatement();
				ResultSet rset = stmt.executeQuery(sql);
				mList = new ArrayList<Member>();
				while(rset.next()) {
					// 후처리
					Member member = new Member();
					member.setMemberId(rset.getString("MEMBER_ID"));
					member.setMemberPwd(rset.getString("MEMBER_PWD"));
					member.setMemberName(rset.getString("MEMBER_NAME"));
					member.setMemberAge(rset.getInt("MEMBER_AGE"));
					member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
					member.setMemberPhone(rset.getString("MEMBER_PHONE"));
					member.setMemberHobby(rset.getString("MEMBER_HOBBY"));
					member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
					member.setMemberDate(rset.getTimestamp("MEMBER_DATE"));
					mList.add(member);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return mList;
	}
	/**
	 * 아이디로 찾기
	 * @param conn
	 * @param memberId
	 * @return
	 */
	public Member selectOneById(Connection conn, String memberId) {
		Member member = null;
		String sql = prop.getProperty("selectOneById");
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPwd(rset.getString("MEMBER_PWD"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setMemberAge(rset.getInt("MEMBER_AGE"));
				member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				member.setMemberPhone(rset.getString("MEMBER_PHONE"));
				member.setMemberHobby(rset.getString("MEMBER_HOBBY"));
				member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
				member.setMemberDate(rset.getTimestamp("MEMBER_DATE"));
			}
			pstmt.close();
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	/**
	 * 회원 이름으로 찾기
	 * @param conn
	 * @param memberName
	 * @return
	 */
	public List<Member> selectByName(Connection conn, String memberName) {
		List<Member> mList = null;
		String sql = prop.getProperty("selectAllByName");
		mList = new ArrayList<Member>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+memberName+"%");
			ResultSet rset = pstmt.executeQuery();
			while(rset.next()) {
				Member member = new Member();
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPwd(rset.getString("MEMBER_PWD"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setMemberAge(rset.getInt("MEMBER_AGE"));
				member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				member.setMemberPhone(rset.getString("MEMBER_PHONE"));
				member.setMemberHobby(rset.getString("MEMBER_HOBBY"));
				member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
				member.setMemberDate(rset.getTimestamp("MEMBER_DATE"));
				mList.add(member);
			}
			pstmt.close();
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mList;
	}
	
	/**
	 * 회원 정보 등록
	 * @param conn
	 * @param member
	 * @return
	 */
	public int insertMember(Connection conn, Member member) {
		int result = 0;
		String sql = prop.getProperty("insertMember");
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberGender());
			pstmt.setInt(5, member.getMemberAge());
			pstmt.setString(6, member.getMemberEmail());
			pstmt.setString(7, member.getMemberPhone());
			pstmt.setString(8, member.getMemberAddress());
			pstmt.setString(9, member.getMemberHobby()); // 쿼리문 실행 준비
			result = pstmt.executeUpdate(); // 쿼리문 실행
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 회원 정보 수정
	 * @param conn
	 * @param member
	 * @return
	 */
	public int updateMember(Connection conn, Member member) {
		int result = 0;
		String sql = prop.getProperty("updateMember");
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberPwd());
			pstmt.setString(2, member.getMemberEmail());
			pstmt.setString(3, member.getMemberPhone());
			pstmt.setString(4, member.getMemberAddress());
			pstmt.setString(5, member.getMemberHobby());
			pstmt.setString(6, member.getMemberId()); // 쿼리문 실행 준비 완료
			result = pstmt.executeUpdate();			  // 쿼리문 실행
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 회원 탈퇴
	 * @param conn
	 * @param memberId
	 * @return
	 */
	public int deleteMember(Connection conn, String memberId) {
		String sql = prop.getProperty("deleteMember");
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
}

	