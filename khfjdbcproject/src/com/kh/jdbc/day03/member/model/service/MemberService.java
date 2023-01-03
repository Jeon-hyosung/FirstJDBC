package com.kh.jdbc.day03.member.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.jdbc.common.JDBCTemplate;
import com.kh.jdbc.day03.member.model.dao.MemberDAO;
import com.kh.jdbc.day03.member.model.vo.Member;

public class MemberService {

	private MemberDAO mDao;
	
	public MemberService() {
		mDao = new MemberDAO(); // 생략하지 말기
	}
	
	public List<Member> selectAll() {
		List<Member> mList = null;
		Connection conn = JDBCTemplate.getConnection();
		mList = mDao.selectAll(conn);
		return mList;
	}
	public Member selectOneById(String memberId) {
		Member member = null;
		Connection conn = JDBCTemplate.getConnection();
		member = mDao.selectOneById(conn, memberId);
		return member;
	}
	public List<Member> selectByName(String memberName) {
		List<Member> mList = null;
		Connection conn = JDBCTemplate.getConnection();
		mList = mDao.selectByName(conn, memberName);
		return mList;
	}
	public int insertMember(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		int result = mDao.insertMember(conn, member);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
	public int updateMember(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		int result = mDao.updateMember(conn, member);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
	public int deleteMember(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = mDao.deleteMember(conn, memberId);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
}
