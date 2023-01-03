package com.kh.jdbc.day02.member.run;

import java.util.List;

import com.kh.jdbc.day02.member.controller.MemberController;
import com.kh.jdbc.day02.member.model.vo.Member;
import com.kh.jdbc.day02.member.view.MemberView;

public class MemberRun {

	public static void main(String [] args) {
		List<Member> mList = null; 
		MemberView mView = new MemberView();
		MemberController mCon = new MemberController();
		Member member = null;
		String memberId = null;
		String memberName = null;
		int result = 0;
		done:
		while(true) {
			int choice = mView.mainMenu();
			switch(choice) {
			case 1:
				// 회원 전체 조회
				mList = mCon.printAll();
				mView.showMember(mList, "회원 전체");
				break;
			case 2:
				// 회원 아이디로 조회
				memberId = mView.selectByMemberId("검색");
				member = mCon.printById(memberId);
				mView.showOne(member);
				break;
			case 3:
				// 회원 이름으로 조회
				mList = mCon.printByName(memberName);
				memberName = mView.selectByMemberName("검색");
				if(!mList.isEmpty()) {
					mView.showMember(mList, "회원 이름으로");					
				}
				else {
					mView.printMessage("실패");
				}
				break;
			case 4: 
				// 회원 가입
				member = mView.inputMember();
				result = mCon.registerMember(member);
				if(result > 0) {
					mView.printMessage("회원 가입 성공");
				}
				else {
					mView.printMessage("회원 가입 실패");
				}
				break;
			case 5:
				// 회원 정보 수정
				memberId = mView.selectByMemberId("수정");
				member = mCon.printById(memberId);
				if(member != null) {
					member = mView.modifyMember(member);
					mCon.modifyMember(member);
				}
				else {
					mView.printMessage("정보 수정 실패");
				}
				break;
			case 6:
				// 회원 탈퇴
				memberId = mView.selectByMemberId("삭제");
				result = mCon.removeMember(memberId);
				if(result > 0) {
					mView.printMessage("회원 탈퇴 성공");
				}
				else {
					mView.printMessage("회원 탈퇴 실패");
				}
				break;
			case 7:
				// 로그인
				member = mView.inputLoginInfo();
				result = mCon.checkInfo(member);
				if(result > 0) {
					mView.printMessage("로그인 성공");
				}
				else {
					mView.printMessage("일치하는 정보가 존재하지 않습니다.");
				}
				break;
			case 0:
				break done;
			default:
				break;
			}
		}
	}
}
