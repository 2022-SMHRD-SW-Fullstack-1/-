package View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Controller.DMusicController;
import Controller.GameController;
import Controller.MemberController;
import Model.MemberDTO;
import Model.PlayerDTO;

public class GameMain {
	public static void main(String[] args) {
		int a = 0;
		Connection conn = null;
		Scanner sc = new Scanner(System.in);
		GameController gcont = new GameController();
		MemberController mcont = new MemberController();
		
		DMusicController dc = new DMusicController();
		int index = 0;
		
		int result;
		int b;
		
		dc.opening();
		
		while (true) {
			gcont.conRs();
			System.out.print("[1] 회원가입 [2] 로그인 [3] 조회 [4] 닉네임 변경 [5] 탈퇴 [6] 종료  >> ");
			int menu = sc.nextInt();
			if (menu == 1) {
				System.out.println("====회원가입 기능====");
				System.out.print("아이디 : ");
				String id = sc.next();
				System.out.print("비밀번호 : ");
				String pw = sc.next();
				System.out.print("닉네임 : ");
				String nick = sc.next();
				result = mcont.conInsert(id, pw, nick);
				if (result > 0) {
					System.out.println("가입 성공");
				} else {
					System.out.println("가입 실패");
				}
			} else if (menu == 2) {
				System.out.println("====로그인 기능!====");
				System.out.print("아이디 입력 : ");
				String id = sc.next();
				System.out.print("비밀번호 입력 : ");
				String pw = sc.next();
				String nick = mcont.conLogin(id, pw);
				if (nick != null) {
					System.out.println("환영합니다~~ " + nick + "님");
					System.out.print("게임을 시작하시겠습니까?? Y/N >>");
					String ans = sc.next();
					if (ans.equals("Y") || ans.equals("y")) {
						a = 1;
						break;
					}
				} else {
					System.out.println("로그인 정보를 다시 확인 해주세요");
					a = 0;
				}
			} else if (menu == 3) { // 조회 기능
				ArrayList<MemberDTO> resultList = new ArrayList<MemberDTO>();
				resultList = mcont.conSelect();
				for (int i = 0; i < resultList.size(); i++) {
					System.out.println(resultList.get(i).getId() + " / " + resultList.get(i).getNick());
				}
			} else if (menu == 5) { // 탈퇴
				ArrayList<MemberDTO> resultList = new ArrayList<MemberDTO>();
				resultList = mcont.conSelect();
				dc.ending();
				for (int i = 0; i < resultList.size(); i++) {
					System.out.println(resultList.get(i).getId() + " / " + resultList.get(i).getNick());
				}
				System.out.println("어느 아이디를 탈퇴하시겠습니까? ");
				String id = sc.next();
				mcont.conDel(id);
				System.out.println("삭제가 완료되었습니다!");
			} else if (menu == 6) {
				System.out.println("게임을 종료합니다.");
				break;
			}
			// =====================================================================
			else if (menu == 4) {// 닉네임 수정
				PreparedStatement psmt = null;
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					String url = "jdbc:oracle:thin:@localhost:1521:xe";
					String db_id = "hr";
					String db_pw = "hr";
					try {
						conn = DriverManager.getConnection(url, db_id, db_pw);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				try {
					System.out.print("아이디 : ");
					String id = sc.next();
					System.out.print("변경 할 닉네임 : ");
					String nick = sc.next();
					String sql = "update memberinfo set nick=? where id=?";
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, nick);
					psmt.setString(2, id);
					int result_modify = psmt.executeUpdate();
					if (result_modify != 0) {
						System.out.println("수정 성공");
					} else {
						System.out.println("수정 실패");
					}
				} catch (Exception e) {
					System.out.println("오류 발생!");
					e.printStackTrace();
				} finally {
					try {
						if (psmt != null) {
							psmt.close();
						}
						if (conn != null) {
							conn.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
//================================================================================
		}

			if (a == 1) {
				while (true) {
					dc.battle();
					gcont.printMenu();
					int menu = sc.nextInt();
					if (menu == 1) { // 엔트리 생성 & 선택
						System.out.println("디지몬들을 불러오고 있습니다.");
						ArrayList<PlayerDTO> resultList = new ArrayList<PlayerDTO>();
						resultList = gcont.conSelect();
						gcont.conChoice(resultList);
					} else if (menu == 2) { // 배틀
						gcont.conAtt();
						gcont.conDef();
					} else if (menu == 3) { // 명단 확인
						gcont.conCheck();
					} else if (menu == 4) { // 선수 랭킹
						gcont.conRank();
					}
				}
			}
		
	}
}