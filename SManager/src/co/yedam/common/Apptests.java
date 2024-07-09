package co.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import co.yedam.vo.StudentVO;

public class Apptests {
	public static Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 오라클 접속 주소
		String driver = "oracle.jdbc.driver.DracleDriver";
		String user = "jsp";
		String pass = "jsp";

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {

		// 1) Oracle JDBC Driver 자바라이브러리
		// 2) Connection 객체
		Scanner sc = new Scanner(System.in);
		//addStudent 출력
//		System.out.println(">학생번호 입력 : ");
//		String sno = sc.nextLine();
//		System.out.println(">학생이름 입력 : ");
//		String sname = sc.nextLine();
//		System.out.println(">연락처 입력 : ");
//		String phon = sc.nextLine();
		
//		/modStudent2 출력
		System.out.println(">학생번호 입력 : ");
		String sno = sc.nextLine();
		System.out.println(">학생이름 입력 : ");
		String sname = sc.nextLine();
		System.out.println(">연락처 입력 : ");
		String phon = sc.nextLine();
		System.out.println(">주소 입력 : ");
		String addr = sc.nextLine();
		System.out.println(">생일 입력 : ");
		String birth = sc.nextLine();
		
		StudentVO std = new StudentVO();
		std.setStdNo(sno);
		std.setStdName(sname);
		std.setStdPhone(phon);
		std.setAddress(addr);
		std.setBirthDate(birth);
//				addStudent(sno, snaem, phon); // 입력

		search();// 목록조회
//		removsStudent(sno);
		modStudent2(std);
		
//		modStudent();
		search();// 목록조회

//		update tbl_student
//		set address = '서울76번지'
//		where std_no =  'S2024-02';
	}

//	DELETE from tbl_student
//	where std_no = 'S2024-01';
	// 삭제기능
	public static void removsStudent(String stdNo) {
		Connection conn = getConn();
		String rm = " DELETE from tbl_student";
		rm += " where std_no ='" + stdNo + "'";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(rm); // insert, updatem, delete => 처리되 건수 반환
			System.out.println("처리된 건수는 " + r + "건");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	String stdNo, String stdName, String phone
	// 수정기능
	public static void modStudent() {
		Connection conn = getConn();
		String ms1 = " update tbl_student";
		ms1 += " set address  = '대구1번지'";
		ms1 += " where std_no = 'S2024-01'";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(ms1); // insert, updatem, delete => 처리되 건수 반환
			System.out.println("처리된 건수는 " + r + "건");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 수정기능2
	public static void modStudent2(StudentVO svo) {

		Connection conn = getConn();
		String sql = " update tbl_student";
		sql += " set    std_name = nvl('" + svo.getStdName() + "', std_name)";
		sql += "       ,std_phone = nvl('" + svo.getStdPhone() + "', std_phone)";
		sql += "       ,address = nvl('" + svo.getAddress() + "', address)";
		sql += "       ,birth_date = nvl(to_date('" + svo.getBirthDate() + "', yyyy-mm-dd),birth_date)";
		sql += "  where std_no = '" + svo.getStdNo() + "'";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // insert, updatem, delete => 처리되 건수 반환
			System.out.println("처리된 건수는 " + r + "건");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 전체 삭제
	// drop table -이름- purge; -- 삭제 손대지말것
//	public static void god() {
//		Connection conn = getConn();
//		String gg = " drop table tbl_student purge";
//				try {
//					Statement stmt = conn.createStatement();
//					int r = stmt.executeUpdate(gg); // insert, updatem, delete => 처리되 건수 반환
//					System.out.println("처리된 건수는 " + r + "건");
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//	}

	// update tbl_student
	// set address = '서울76번지'
	// where std_no = 'S2024-02';

//		sql += "values(S2024-06', '산와머니','010-1644-3939')";
	// 입력기능
	// insert into tbl_student (std_no, std_name,std_phone,address)
	// values('S2024-03', '김수호','010-8886-2779','서울77번지');
	public static void addStudent(String stdNo, String stdName, String phone) {
		Connection conn = getConn();
		String sql = "insert into tbl_student (std_no, std_name,std_phone)";
		sql += "values('" + stdNo + "', '" + stdName + "','" + phone + "')";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // insert, updatem, delete => 처리되 건수 반환
			System.out.println("처리된 건수는 " + r + "건");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 조회기능
	public static void search() {
		// 조회기능

		try {
			Connection conn = getConn(); // <<<<예외처리
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from tbl_student");// 공부
			// [객체1, 객체2, 객체3]
			while (rs.next()) {
				System.out.println(rs.getString("std_no") + "," + rs.getString("std_name") + ","
						+ rs.getString("std_phone") + "," + rs.getString("address"));

			}
			System.out.println("end of date");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 조회기능 끝

	}
}
