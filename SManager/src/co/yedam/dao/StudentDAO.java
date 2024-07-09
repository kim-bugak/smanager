package co.yedam.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.yedam.vo.StudentVO;

// 목록(R), 등록(C), 수정(U), 삭제(D) 기본적인 기능 
// 주의 : DAO 메세지 System.out.println();가 없음.
public class StudentDAO extends DAO {

	// 목록반환기능. 1번
	public List<StudentVO> selectList() {
		String sql = " select *  from tbl_student order by std_no";
		List<StudentVO> list = new ArrayList<>();

		conn = getConn();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				StudentVO svo = new StudentVO();
				svo.setAddress(rs.getString("address"));
				svo.setBirthDate(rs.getString("birth_date"));
				svo.setCreationDate(rs.getDate("creation_date"));
				svo.setStdName(rs.getString("std_name"));
				svo.setStdNo(rs.getString("std_no"));
				svo.setStdPhone(rs.getString("std_phone"));

				list.add(svo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	} // end of selectList()

	// 등록기능. 2번
	public boolean insertSutdent(StudentVO svo) {
		String sql = "insert into tbl_student (std_no, std_name, std_phone, address, birth_date) ";
		sql += "values(?, ?, ?, ?, ? )";
		conn = getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, svo.getStdNo());
			psmt.setString(2, svo.getStdName());
			psmt.setString(3, svo.getStdPhone());
			psmt.setString(4, svo.getAddress());
			psmt.setString(5, svo.getBirthDate());

			int r = psmt.executeUpdate(); // 쿼리실행
			if (r == 1) {
				return true; // 정상처리.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 비정상처리.

	}

	// 수정 기능 3번
	public boolean modStudent(StudentVO svo) {
		conn = getConn();
		try {
		String sql = " update tbl_student";
			sql += " set    std_name = nvl('" + svo.getStdName() + "', std_name)";
			sql += "       ,std_phone = nvl('" + svo.getStdPhone() + "', std_phone)";
			sql += "       ,address = nvl('" + svo.getAddress() + "', address)";
			sql += "       ,birth_date = nvl(to_date('" + svo.getBirthDate() + "', 'yyyy-mm-dd'),birth_date)";
			sql += "  where std_no = '" + svo.getStdNo() + "'";
			

			
//			System.out.println(sql);
//			ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // 
			if (r == 1) {
				return true; // 정상처리.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 비정상처리.

	}

}
