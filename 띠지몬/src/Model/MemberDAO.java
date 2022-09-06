package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	int b;
	// DAO : Data Access Object
	// 데이터베이스의 data에 접근을 위한 객체! (접근 로직)
	// 실제 DATA 베이스와 연결되어 있다.

	// 객체 생성
	Connection conn = null; // 출입증
	PreparedStatement psmt = null; // execute Query와 execute update psmt: sql문을 전달하기 위한 바구니
	ResultSet rs = null; // execute Query 실행시 행을 통째로 받아오기 위해

	int cnt = 0; // executeUpdate의 결과값을 담아주는 변수
	int limit = 0;

	// 데이터베이스 접속을 위한 연결 메소드
	public void getCon() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 오라클 드라이버가 있는지 확인해준다(lib에 ojdbc6.jar있는지 확인)

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_id = "hr";
			String db_pw = "hr";

			conn = DriverManager.getConnection(url, db_id, db_pw); // 출입증
			// 데이터베이스와의 연결을 해주는 커넥션이다.

			if (conn != null) {
				System.out.println("접속 성공");
			} else {
				System.out.println("접속 실패");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 사용된 객체를 닫아주는 메소드
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// [1] 회원 가입

	public int insert(String id, String pw, String nick) {
		getCon();

		try {
			String sql = "insert into memberInfo values(?,?,?)";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, nick);

			cnt = psmt.executeUpdate(); // executeUpdate의 결과 값에는 업데이트 된 행 개수가 반환된다.
			// 회원 가입을 할 때는 한 회원 즉 한 행씩 들어오므로 회원 가입이 되면 1이 반환 될 것이다.
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

	// [2] 로그인
	public String login(String id, String pw) {
		getCon();
		String nick = null;

		try {
			String sql = "select nick from memberInfo where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery(); // 행을 통째로 가져온다.

			if (rs.next()) {
				nick = rs.getString(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return nick;

	}

	// [3] 조회 -> 전체 회원의 아이디와 닉네임만 출력!
	public ArrayList<MemberDTO> select() {
		ArrayList<MemberDTO> totalList = new ArrayList<>();

		getCon();

		String sql = "select id, nick from memberInfo";

		try {
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String nick = rs.getString("nick");

				MemberDTO dto = new MemberDTO(id, nick);
				totalList.add(dto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return totalList;

	}
	
	// [4] 탈퇴
	public void del(String id) {
		getCon();
		
		
		try {
			String sql = "delete from memberInfo where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			cnt = psmt.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
	}
	int a;
	
	

}
