package com.kh.jdbc.day01.student.view;

import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.day01.student.model.vo.Student;

public class StudentView {

	public void showAll(List<Student> students) {
		System.out.println("=== === 학생 전체 목록 조회 === ===");
		for(Student sOne : students) {
			System.out.print("아이디 : " + sOne.getStudentId());
			System.out.print(", 비밀번호 : " + sOne.getStudentPwd());
			System.out.print(", 이름 : " + sOne.getStudentName());
			System.out.print(", 성별 : " + sOne.getGender());
			System.out.print(", 나이  : " + sOne.getAge());
			System.out.print(", 이메일 : " + sOne.getEmail());
			System.out.print(", 전화번호 : " + sOne.getPhone());
			System.out.print(", 주소 : " + sOne.getAddress());
			System.out.print(", 취미 : " + sOne.getHobby());
			System.out.println(", 가입날짜 : " + sOne.getEnrollDate());
		}
	}
	
	public Student inputStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		String studentId = sc.next();
		System.out.print("이름 : ");
		String studentName = sc.next();
		System.out.print("비밀번호 : ");
		String studentPwd = sc.next();
		System.out.print("성별 : ");
		String gender = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		System.out.print("이메일 : ");
		String email = sc.next();
		System.out.print("전화번호 : ");
		String phone = sc.next();
		System.out.print("주소 : ");
		sc.nextLine();
		String address = sc.nextLine();
		System.out.print("취미(,로 구분) : ");
		String hobby = sc.next();
		Student student = 
				new Student(studentId
						, studentName
						, studentPwd
						, gender
						, age
						, email
						, phone
						, address
						, hobby
						, null);
		return student;
//		student.setStudentId(studentId);
//		student.setStudentName(studentName);
//		student.setStudentPwd(studentPwd);
//		student.setGender(gender);
//		student.setAge(age);
//		student.setEmail(email);
//		student.setPhone(phone);
//		student.setAddress(address);
//		student.setHobby(hobby);
	}

	public int mainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("메뉴선택 : ");
		int select = sc.nextInt();
		return select;
	}
	public void printMessage(String msg) {
		System.out.println(msg);
	}
	
	public void displaySuccess(String message) {
		System.out.println("[서비스 성공] : " + message);
	}
	public void displayError(String message) {
		System.out.println("[서비스 실패] : " + message);
	}
	
}
