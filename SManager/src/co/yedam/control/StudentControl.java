package co.yedam.control;

import java.util.List;
import java.util.Scanner;

import co.yedam.dao.StudentDAO;
import co.yedam.vo.StudentVO;

//사용자입력을 가이드, 처리된 결과 출력.

public class StudentControl {
		
	
		//필드
		Scanner sc = new Scanner(System.in);
		StudentDAO sdao = new StudentDAO();
		
		
		
		//메서드 함수
		public void run() {
			boolean isTrue = true;
			
			while(isTrue) {
				System.out.println("1.학생목록 2.등록 3.수정 4.삭제 5.종료");
				System.out.print("선택 >");
				int menu = Integer.parseInt(sc.nextLine());
				
				switch(menu) {
				case 1:
					studentList(); 
					break;
				case 2:
					addStudent();
					break;
				case 3:
					modStudent();
					break;
				case 4:
					break;
				case 5:
					System.out.println("종료합니다.");
					isTrue = false;
				}
			}
		}//end of run()
		//등록 기능.
		void addStudent() {
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
			
			//입력기능 호출.
			if(sdao.insertSutdent(std)) {
				System.out.println("저장완료");
			}else {
				System.out.println("처리중 예외발생!");
			}
		}
		//목록 출력 기능
		void studentList() {
			List<StudentVO> students = sdao.selectList();
			System.out.println("학생번호  학생이름 	 연락처 ");
			System.out.println("--------------------------------");
			for(StudentVO svo : students) {
				System.out.println(svo.briefShow());
			}
		}///end of studentList()
		//업데이트 기능
		void modStudent() {
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
			
			//수정기능 호출
			if(sdao.modStudent(std)) {
				System.out.println("수정완료");
			}else {
				System.out.println("수정중 예외발생!");
			}
			
			
		}
}
