package com.kh.jdbc.day03.member.run;

import java.util.List;

import com.kh.jdbc.day03.member.controller.MemberController;
import com.kh.jdbc.day03.member.model.vo.Member;
import com.kh.jdbc.day03.member.view.MemberView;

public class MemberRun {

	public static void main(String [] args) {
		MemberView mView = new MemberView();
		MemberController mCon = new MemberController();
		List<Member> mList = null;
		Member member = null;
		int result = 0;
		String memberId = null;
		String memberName = null;
		gone:
		while(true) {
			int choice = mView.mainMenu();
			switch(choice) {
			case 1:
				mList = mCon.printAll();
				if(mList.size() > 0) {
					mView.showAll(mList, "전체");
				}
				else {
					mView.printMessage("회원 정보가 없습니다.");
				}
				break;
			case 2:
				// 회원 아이디로 조회
				memberId = mView.selectByMemberId("검색");
				member = mCon.printOneById(memberId);
				if(member != null) {
					mView.showOne(member);
				}
				else {
					mView.printMessage("일치하는 정보가 없습니다.");
				}
				break;
			case 3:
				memberName = mView.selectByMemberName("검색");
				mList = mCon.printByName(memberName);
				if(!mList.isEmpty()) {
					mView.showAll(mList, "회원");
				}
				else {
					mView.printMessage("일치하는 정보가 없습니다.");
				}
				break;
			case 4:
				member = mView.inputMember();
				result = mCon.registerMember(member);
				if(result > 0) {
					mView.printMessage("가입 성공");
				}
				else {
					mView.printMessage("회원가입이 완료되지 않았습니다.");
				}
				break;
			case 5:
				memberId = mView.selectByMemberId("수정");
				member = mCon.printOneById(memberId);
				if(member != null) {
					member = mView.modifyMember(member);
					mCon.modifyMember(member);
					mView.printMessage("정보 수정 완료");
				}
				else {
					mView.printMessage("정보 수정 실패");
				}
				break;
			case 6:
				memberId = mView.selectByMemberId("삭제");
				result = mCon.removeMember(memberId);
				if(result > 0) {
					mView.printMessage("회원 탈퇴 성공");
				}
				else {
					mView.printMessage("회원 탈퇴가 완료되지 않았습니다.");
				}
				break;
			case 7:
				break;
			case 0:
				break gone;
			}
		}
	}
}
