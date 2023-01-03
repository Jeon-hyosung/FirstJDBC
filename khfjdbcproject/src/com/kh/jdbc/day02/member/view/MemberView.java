package com.kh.jdbc.day02.member.view;

import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.day02.member.model.vo.Member;

public class MemberView {

	public int mainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== === === 회원관리 프로그램 === === ===");
		System.out.println("1. 회원 전체 조회");
		System.out.println("2. 회원 아이디로 조회");
		System.out.println("3. 회원 이름으로 조회");
		System.out.println("4. 회원 가입");
		System.out.println("5. 회원 정보 수정");
		System.out.println("6. 회원 탈퇴");
		System.out.println("7. 로그인");
		System.out.println("0. 프로그램 종료");
		System.out.print("메뉴선택 : ");
		int choice = sc.nextInt();
		return choice;
	}
	
	public void showMember(List<Member> member, String Message) { // 회원 전체 또는 이름으로 찾기 2.
		System.out.println("=== === === "+ Message +" 조회 === === ===");
		for(Member mOne : member) {
			System.out.print("아이디 : " + mOne.getMemberId());
			System.out.print(", 비밀번호 : " + mOne.getMemberPwd());
			System.out.print(", 이름 : " + mOne.getMemberName());
			System.out.print(", 성별 : " + mOne.getMemberGender());
			System.out.print(", 나이 : " + mOne.getMemberAge());
			System.out.print(", 이메일 : " + mOne.getMemberEmail());
			System.out.print(", 전화번호 : " + mOne.getMemberPhone());
			System.out.print(", 주소 : " + mOne.getMemberAddress());
			System.out.print(", 취미 : " + mOne.getMemberHobby());
			System.out.println(", 가입날짜 : " + mOne.getMemberDate());
		}
	}
	
	public void showOne(Member member) { // 아이디로 찾기 2.
		System.out.println("=== === === 회원 아이디로 조회 === === ===");
		System.out.print("아이디 : " + member.getMemberId());
		System.out.print(", 비밀번호 : " + member.getMemberPwd());
		System.out.print(", 이름 : " + member.getMemberName());
		System.out.print(", 성별 : " + member.getMemberGender());
		System.out.print(", 나이 : " + member.getMemberAge());
		System.out.print(", 이메일 : " + member.getMemberEmail());
		System.out.print(", 전화번호 : " + member.getMemberPhone());
		System.out.print(", 주소 : " + member.getMemberAddress());
		System.out.print(", 취미 : " + member.getMemberHobby());
		System.out.println(", 가입날짜 : " + member.getMemberDate());
	}
	
	public Member inputMember() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== === === 회원 정보 입력 === ==== ===");
		System.out.print("아이디 : ");
		String memberId = sc.next();
		System.out.print("비밀번호 : ");
		String memberPwd = sc.next();
		System.out.print("이름 : ");
		String memberName = sc.next();
		System.out.print("성별 : ");
		String memberGender = sc.next();
		System.out.print("나이 : ");
		int memberAge = sc.nextInt();
		System.out.print("이메일 : ");
		String memberEmail = sc.next();
		System.out.print("전화번호 : ");
		String memberPhone = sc.next();
		System.out.print("주소 : ");
		sc.nextLine();
		String memberAddress = sc.nextLine();
		System.out.print("취미 : ");
		String memberHobby = sc.next();
		
		Member member = new Member(
				memberId
				, memberPwd
				, memberName
				, memberGender
				, memberAge
				, memberEmail
				, memberPhone
				, memberAddress
				, memberHobby);
		
		return member;
	}
	
	public Member inputLoginInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== === 로그인 정보 입력 === ===");
		System.out.print("아이디 : ");
		String memberId = sc.next();
		System.out.print("비밀번호  : ");
		String memberPwd = sc.next();
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPwd(memberPwd);
		return member;
	}
	
	
	public Member modifyMember(Member member) {
		Scanner sc = new Scanner(System.in);
		System.out.print("비밀번호 : ");
		String memberPwd = sc.next();
		System.out.print("이메일 : ");
		String memberEmail = sc.next();
		System.out.print("전화번호 : ");
		String memberPhone = sc.next();
		System.out.print("주소 : ");
		sc.nextLine();
		String memberAddress = sc.nextLine();
		System.out.print("취미 : ");
		String memberHobby = sc.next();
		
		member.setMemberPwd(memberPwd);
		member.setMemberEmail(memberEmail);
		member.setMemberPhone(memberPhone);
		member.setMemberAddress(memberAddress);
		member.setMemberHobby(memberHobby);
		return member;
	}
	
	public String selectByMemberId(String Message) { // 아이디로 찾기 1.
		Scanner sc = new Scanner(System.in);
		System.out.print(Message + "할 아이디 입력 : ");
		String memberId = sc.next();
		return memberId;
	}
	
	public String selectByMemberName(String Message) { // 이름으로 찾기 1.
		Scanner sc = new Scanner(System.in);
		System.out.print(Message + "할 이름 입력 : ");
		String memberName = sc.next();
		return memberName;
	}
	
	public void printMessage(String Message) {
		System.out.println("[처리결과] : " + Message);
	}
	
}
