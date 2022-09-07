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

		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿" + "\n"
				+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡐⣎⡉⠉⠛⠓⢒⠻⡿⠿⠿⠿⠿⠿⢿⣽⠿⢿⠛⠓⠒⠛⠛⠉⠉⢩⠝⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿" + "\n"
				+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⢻⣀⠘⣯⡟⡇⡀⢱⣒⣒⡶⠀⢀⡼⣿⠒⢺⠀⠘⠛⠛⠛⠋⢀⣺⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿" + "\n"
				+ "⣿⣿⣿⣿⣿⣟⠻⠿⠿⢿⣿⣿⡿⣌⣇⠀⢻⣧⣳⢀⠸⣿⠟⠀⡀⠹⣾⡇⠀⡌⠉⣉⣁⣀⣉⣁⣤⡼⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿" + "\n"
				+ "⣿⣿⣿⣿⡋⢷⠒⠀⢀⣀⡈⠙⢾⣏⠉⠄⠀⠤⠤⠤⠤⠧⠄⢸⡗⠀⣼⠃⠀⢣⠀⠉⢩⠭⠭⠭⠝⠉⠩⠷⠿⡟⣿⡏⠉⠉⣳⠉⣻⣿⣿⣿" + "\n"
				+ "⣿⣿⣿⣿⣧⠘⣧⠀⠈⢧⠹⡄⠀⠛⠂⠈⠄⠀⢤⠤⠤⠤⠤⠼⡇⠀⣉⠀⠀⠘⠀⠀⡞⠀⢰⠤⢤⡄⠀⠀⣼⠁⡾⠀⠀⢰⠃⢠⣿⣿⣿⣿⣿" + "\n"
				+ "⣿⣿⣿⣿⣿⣧⠘⣆⠀⠈⢧⠹⡄⠀⢶⣆⠈⠄⠈⣿⣿⣿⣿⣿⣆⣀⣀⣉⣀⣿⠁⠀⡇⠀⡾⣴⠋⠀⣠⠎⠛⠛⠁⠀⢠⠏⢠⣿⣿⣿⣿⣿" + "\n"
				+ "⣿⣿⣿⣿⣿⣿⣦⡘⠳⢤⠈⠧⡽⠀⠈⣿⡄⠘⣤⠤⠤⠤⠤⠤⢿⠀⠀⠓⠶⠿⠶⠴⠃⢰⠟⠁⡀⠀⢹⡓⣲⠂⠀⢠⠏⢠⣿⣿⣿⣿⣿⣿" + "\n"
				+ "⣿⣿⣿⣿⣿⣿⣿⣿⣦⣌⠹⣄⣀⣀⡴⣯⠙⠤⠾⠶⠒⠒⠒⠒⣛⣛⡒⠒⠒⠒⠒⠒⠒⠺⠦⠜⢹⣀⣈⢧⡏⠀⢠⠋⢀⣿⣿⣿⣿⣿⣿⣿" + "\n"
				+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣤⣤⣤⣾⣿⣿⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣿⣥⣬⣴⣏⣛⣁⣰⣿⣿⣿⣿⣿⣿⣿⣿" + "\n"
				+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");

		while (true) {
			gcont.conRs();
			System.out.print("💙💙 [1] 회원가입 [2] 로그인 [3] 조회 [4] 닉네임 변경 [5] 탈퇴 [6] 종료 💙💙 >> ");
			
			
			int menu = sc.nextInt();
			if (menu == 1) {
				System.out.println("                                   __  __              \r\n"
						+ "         __                       /\\ \\/\\ \\             \r\n"
						+ "  ____  /\\_\\      __       ___    \\ \\ \\ \\ \\    _____   \r\n"
						+ " /',__\\ \\/\\ \\   /'_ `\\   /' _ `\\   \\ \\ \\ \\ \\  /\\ '__`\\ \r\n"
						+ "/\\__, `\\ \\ \\ \\ /\\ \\L\\ \\  /\\ \\/\\ \\   \\ \\ \\_\\ \\ \\ \\ \\L\\ \\\r\n"
						+ "\\/\\____/  \\ \\_\\\\ \\____ \\ \\ \\_\\ \\_\\   \\ \\_____\\ \\ \\ ,__/\r\n"
						+ " \\/___/    \\/_/ \\/___L\\ \\ \\/_/\\/_/    \\/_____/  \\ \\ \\/ \r\n"
						+ "                  /\\____/                        \\ \\_\\ \r\n"
						+ "                  \\_/__/                          \\/_/ \r\n");
				System.out.print("아이디 : ");
				String id = sc.next();
				System.out.print("비밀번호 : ");
				String pw = sc.next();
				System.out.print("닉네임 : ");
				String nick = sc.next();
				result = mcont.conInsert(id, pw, nick);
				if (result > 0) {
					System.out.println("가입 성공😊😊. 환영합니다." + nick + "님!");
				} 
				
			
			} else if (menu == 2) {
				System.out.println(" __         _____       ____       ______      __  __     \r\n"
						+ "/\\ \\       /\\  __`\\    /\\  _`\\    /\\__  _\\    /\\ \\/\\ \\    \r\n"
						+ "\\ \\ \\      \\ \\ \\/\\ \\   \\ \\ \\L\\_\\  \\/_/\\ \\/    \\ \\ `\\\\ \\   \r\n"
						+ " \\ \\ \\  __  \\ \\ \\ \\ \\   \\ \\ \\L_L     \\ \\ \\     \\ \\ , ` \\  \r\n"
						+ "  \\ \\ \\L\\ \\  \\ \\ \\_\\ \\   \\ \\ \\/, \\    \\_\\ \\__   \\ \\ \\`\\ \\ \r\n"
						+ "   \\ \\____/   \\ \\_____\\   \\ \\____/    /\\_____\\   \\ \\_\\ \\_\\\r\n"
						+ "    \\/___/     \\/_____/    \\/___/     \\/_____/    \\/_/\\/_/\r\n");
				System.out.print("아이디 입력 : ");
				String id = sc.next();
				System.out.print("비밀번호 입력 : ");
				String pw = sc.next();
				String nick = mcont.conLogin(id, pw);

				if (nick != null) {

					while (true) {
						System.out.println("환영합니다~~😊😊 " + nick + "님");

						System.out.print("💙💙 [1] 게임 준비 [2] 메인으로 돌아가기 💙💙");
						int myCSize = 0;
						gcont.reSetAbility();
						gcont.reSetC();

						int ans = sc.nextInt();
						if (ans == 1) {

							dc.battle();

							while (true) {
								gcont.printMenu();
								int menu1 = sc.nextInt();
								if (menu1 == 1) { // 엔트리 생성 & 선택
									System.out.println("디지몬들을 불러오고 있습니다.");
									ArrayList<PlayerDTO> resultList = new ArrayList<PlayerDTO>();
									resultList = gcont.conSelect();
									gcont.conChoice(resultList);
									myCSize++;
								} else if (menu1 == 2) { // 배틀
									if (myCSize != 0) {
										gcont.conAtt();
										gcont.conDef();
									} else {
										System.out.println("엔트리를 먼저 생성 해주세요.");
									}
									break;
								} else if (menu1 == 3) { // 명단 확인
									gcont.conCheck();
								} else if (menu1 == 4) { // 선수 랭킹
									gcont.conRank();
								} else if (menu1 == 5) {
									break; 
								}
							}
						} else if (ans == 2) {
							break;
						} else {
							System.out.println("1 or 2만 입력해주세요.");
						}

					}
				}
			}

			else if (menu == 3) { // 조회 기능
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
				System.out.print("어느 아이디를 탈퇴하시겠습니까? ");
				String id = sc.next();
				mcont.conDel(id);
				System.out.println("삭제가 완료되었습니다!");
			} else if (menu == 6) {
				System.out.println("게임을 종료합니다.");
				dc.stop();
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
					} catch (Exception e) {
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

		}

	}
}



