package com.kh.jdbc.day02.member.controller;

import java.util.List;

import com.kh.jdbc.day02.member.mode.dao.MemberDAO;
import com.kh.jdbc.day02.member.model.vo.Member;

public class MemberController {

	/**
	 * 
	 * @return
	 */
	public List<Member> printAll() {
		MemberDAO mDao = new MemberDAO();
		List<Member> mList = mDao.selctAll(); //DAO에서 리스트를 받아서 mList에 넣어준다.
		return mList;
	}
	/**
	 * 
	 * @param member
	 * @return
	 */
	public int checkInfo(Member member) {
		MemberDAO mDao = new MemberDAO();
		int result = mDao.checkLogin(member);
		return result;
	}
	/**
	 * 
	 * @param memberId
	 * @return
	 */
	public Member printById(String memberId) {
		MemberDAO mDao = new MemberDAO();
		Member member = mDao.findById(memberId);
		return member;
	}
	/**
	 * 
	 * @param memberName
	 * @return
	 */
	public List<Member> printByName(String memberName) {
		MemberDAO mDao = new MemberDAO();
		List<Member> mList = mDao.findByName(memberName);
		return mList;
	}
	/**
	 * 
	 * @param member
	 * @return
	 */
	public int registerMember(Member member) {
		MemberDAO mDao = new MemberDAO();
		int result = mDao.insertMember(member);
		return result;
	}
	/**
	 * 
	 * @param memberId
	 * @return
	 */
	public int removeMember(String memberId) {
		MemberDAO mDao = new MemberDAO();
		int result = mDao.deleteMember(memberId);
		return result;
	}
	/**
	 * 
	 * @param member
	 * @return
	 */
	public int modifyMember(Member member) {
		MemberDAO mDao = new MemberDAO();
		int result = mDao.updateMember(member);
		return result;
	}
}
