package com.kh.jdbc.day01.student.run;

import java.util.List;

import com.kh.jdbc.day01.student.controller.StudentController;
import com.kh.jdbc.day01.student.model.vo.Student;
import com.kh.jdbc.day01.student.view.StudentView;

public class StudentRun {

	public static void main(String [] args) {
		StudentView sView = new StudentView();
		StudentController sCon = new StudentController();
		Student student = null;
		List<Student> sList = null;
		String studentId = "";
		String studentName = "";
		int result = 0;
		DONE :
		while(true) {
			int choice = sView.mainMenu();
			switch(choice) {
			case 1: 
				// 전체 조회
				sList = sCon.printAll();
				if(!sList.isEmpty()) {
					sView.showAll(sList);
				}
				else {
					sView.displayError("일치하는 데이터가 없습니다.");
				}
				break;
			case 2: 
				// 아이디로 조회
				studentId = sView.inputStudentId("검색");
				student = sCon.printOneById(studentId);
				if(student != null) {
					sView.showOne(student);
				}
				else {
					sView.displayError("일치하는 데이터가 없습니다.");
				}
				break;
			case 3: 
				// 이름으로 조회
				studentName = sView.inputStudentName("검색");
				sList = sCon.printAllByName(studentName);
				// sList는 항상 NULL이 아니다. StudentDAO:70
				if(!sList.isEmpty()) { // List는 != null 대신 .isEmpty()사용
					sView.showAll(sList);
				}
				else {
					sView.displayError("일치하는 데이터가 없습니다.");
				}
				break;
			case 4: 
				// 회원가입
				student = sView.inputStudent();
				result = sCon.registerStudent(student);
				if(result > 0) {
					// 성공메시지
					sView.displaySuccess("가입이 완료되었습니다.");
				}
				else {
					// 실패메시지
					sView.displayError("가입 실패하였습니다.");
				}
				break;
			case 5: 
				// 회원정보수정
				studentId = sView.inputStudentId("수정");
				student = sCon.printOneById(studentId);
				if(student != null) {
					student = sView.modifyStudent(student);
//					student.setStudentId(studentId);
					sCon.modifyStudent(student);
				}
				else {
					sView.displayError("일치하는 학생이 없습니다.");
				}
				
				break;
			case 6:
				// 회원 탈퇴
				studentId = sView.inputStudentId("삭제");
				result = sCon.removeStudent(studentId);
				if(result > 0) {
					// 성공메시지
					sView.displaySuccess("탈퇴 완료");
				}
				else {
					// 실패메시지
					sView.displayError("탈퇴되지 않았습니다.");
				}
				break;
			case 0:
				break DONE;
			default : 
				sView.printMessage("잘못입력하셨습니다 1 ~ 6 사이의 수를 입력해주세요.");
				break;
			}
		}
	}
}
