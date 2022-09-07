package Model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PlayerDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	Scanner sc = new Scanner(System.in);
	Random rd = new Random();

	ArrayList<PlayerDTO> My = new ArrayList<>();
	ArrayList<PlayerDTO> Op = new ArrayList<>();
//	ArrayList<PlayerDTO> temp = new ArrayList<>();

	int b;
	int score = 0; // 랭킹 환산
	int goal1 = 0; // 경기 상황
	int goal2 = 0;

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
				System.out.println("");
			} else {
				System.out.println("접속 실패");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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

	// 조회

	public ArrayList<PlayerDTO> select() {
		ArrayList<PlayerDTO> totalList = new ArrayList<>();

		getCon();

		String sql = "select d_name,d_ability,d_score from playerinfo";

		try {
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString("d_name");
				int ability = rs.getInt("d_ability");
				int score = rs.getInt("d_score");

				PlayerDTO dto = new PlayerDTO(name, ability, score);
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

	public void choice(ArrayList<PlayerDTO> All) {
		System.out.println("4명의 선수를 영입 할 수 있습니다.");
		System.out.println();

		for (int i = 1; i <= 4; i++) { // 4번 반복
			for (int j = 0; j < All.size(); j++) {
				System.out.println(j + 1 + ", " + All.get(j).getD_name());
			}

			System.out.println();
			System.out.print("영입 할 선수의 번호를 선택하세요 >> ");
			int num = sc.nextInt();
			My.add(All.get(num - 1));
			All.remove(num - 1);
		}
		if (All.size() != 6) {
			for (int i = 0; i < All.size(); i++) {
				System.out.println(All.get(i).getD_name());
			}
		}

		System.out.println();

		for (int i = 1; i <= 4; i++) {
			for (int j = 0; j < All.size(); j++) {
				Random rd = new Random();
				int num = rd.nextInt(All.size());
				Op.add(All.get(num));
				All.remove(num);
			}
		}

		System.out.println("\n 우리팀 선수 명단");

		for (int i = 0; i < My.size(); i++) {
			System.out.println(My.get(i).getD_name() + " 능력치 : " + My.get(i).getAbility());
		}

		System.out.println("\n 상대팀 선수 명단");
		for (int i = 0; i < My.size(); i++) {
			System.out.println(Op.get(i).getD_name() + " 능력치 : " + Op.get(i).getAbility());
		}

	}

	public void M() {

		if (My.size() != 0) {
			for (int i = 0; i < My.size(); i++) {
				System.out.println("나의 선수 명단 : ");
				System.out.println(i + 1 + ", " + My.get(i).getD_name() + " 능력치 :  " + My.get(i).getAbility());
			}
		} else {
			System.out.println("엔트리를 먼저 생성 해주세요.");
		}
	}

	public ArrayList<PlayerDTO> attack() {

		ArrayList<PlayerDTO> temp = new ArrayList<>();
		ArrayList<PlayerDTO> 넘길거다 = new ArrayList<>();

		for (int i = 0; i < My.size(); i++) {
			temp.add(My.get(i));
		}
		int num1;

		boolean gi = true;
		for (int i = 0; i < 3; i++) {
			System.out.println("다음 타자 준비!");
			int cnt = 0;
			for (int j = 0; j < temp.size(); j++) {
				System.out.println(j + 1 + ", " + temp.get(j).getD_name() + " 능력치 : " + temp.get(j).getAbility());
			}
			System.out.print("출전 시킬 디지몬 : ");
			num1 = sc.nextInt();
			System.out.println(temp.get(num1 - 1).getD_name() + " 능력 : " + temp.get(num1 - 1).getAbility());
			PlayerDTO my = null;

			while (cnt < 3) {

				System.out.println("Are you ready? Y/N");
				String ans = sc.next();

				int num = rd.nextInt(Op.size());
				System.out.println("상대의 캐릭터 :  " + Op.get(num).getD_name() + ", 능력 : " + Op.get(num).getAbility());
				my = temp.get(num1 - 1);
				PlayerDTO op = Op.get(num);

				if (ans.equals("N")||ans.equals("n")) {
					System.out.println("============경기를 포기하시겠습니까? ================");
					System.out.println("==============Yes    or  No===============");
					String ans2 = sc.next();
					if (ans2.equals("Y")||ans2.equals("y")) {
						gi = false;
						break;
					}else {
						System.out.println("===========게임계속 진행합니다.============");
					}
				}

				if (my.getAbility() <= op.getAbility()+9) {
					System.out.print("스트라이크!");
					if (cnt == 0) {
						System.out.println(" ● ○ ○ ");
					} else if (cnt == 1) {
						System.out.println(" ● ● ○ ");
					} else if (cnt == 2) {
						System.out.println(" ● ● ● 삼진 아웃");
					}
					cnt++;
				} else if (my.getAbility() >= op.getAbility() + 40) {
					System.out.println("홈런 4득점!");
					my.score += 4;
					goal1 += 4;
					break;
				} else if (my.getAbility() >= op.getAbility() + 30) {
					System.out.println("3루타 3득점!");
					my.score += 3;
					goal1 += 3;
					break;
				} else if (my.getAbility() >= op.getAbility() + 20) {
					System.out.println("2루타 2득점!");
					my.score += 2;
					goal1 += 2;
					break;
				} else if (my.getAbility() >= op.getAbility() + 10) {
					System.out.println("1루타 1득점!");
					my.score += 1;
					goal1 += 1;
					break;
				}
//
			}
			넘길거다.add(my);
			System.out.println();
			temp.remove(num1 - 1);
			if (gi = false) {
				break;
			}
		}
		System.out.println("공수 교대!!!!!!!\n");
		System.out.println("========우리팀이 얻은 스코어=========");

		return 넘길거다;
	}

	public ArrayList<PlayerDTO> defense() {

		ArrayList<PlayerDTO> 넘길거다 = new ArrayList<>();
		ArrayList<PlayerDTO> temp = new ArrayList<>();
		
		for (int i = 0; i < My.size(); i++) {
			temp.add(My.get(i));
		}
		int num1=0;
		

		int Lotto[] = new int[3];

		int min = 0; // 1번째 디지몬
		int max = 3; // 4번째 디지몬

		for (int i = 0; i < Lotto.length; i++) {
			Lotto[i] = (rd.nextInt(4));

			for (int j = 0; j < i; j++) {
				if (Lotto[i] == Lotto[j]) {
					i--;
				}
			}
		}
		
		
		for (int i = 0; i < 3; i++) {
			int cnt = 0;
			PlayerDTO op = Op.get(Lotto[i]);
				
			
			for (int j = 0; j < temp.size(); j++) {
				System.out.println(j + 1 + ", " + temp.get(j).getD_name() + " 능력치 : " + temp.get(j).getAbility());
			}
			System.out.print("출전 시킬 디지몬 : ");
			num1 = sc.nextInt();
			PlayerDTO my = temp.get(num1 - 1);
			
			
			System.out.println("상대의 캐릭터 : " + op.getD_name() + ", 능력 : " + op.getAbility());
			System.out.println("나의 캐릭터 : " + my.getD_name() + " 능력 : " + my.getAbility());
			
			
			

			//My.remove(num1 - 1);
			
			while (cnt < 3) {

				if (op.getAbility() <= my.getAbility()+9) {
					System.out.print("스트라이크!");
					if (cnt == 0) {
						System.out.println(" ● ○ ○ ");
					} else if (cnt == 1) {
						System.out.println(" ● ● ○ ");
					} else if (cnt == 2) {
						System.out.println(" ● ● ● 삼진 아웃");
					}
					cnt++;
				} else if (op.getAbility() >= my.getAbility() + 40) {
					System.out.println("홈런 4득점!");
					op.score += 4;
					goal2 += 4;
					break;
				} else if (op.getAbility() >= my.getAbility() + 30) {
					System.out.println("3루타 3득점!");
					op.score += 3;
					goal2 += 3;
					break;
				} else if (op.getAbility() >= my.getAbility() + 20) {
					System.out.println("2루타 2득점!");
					op.score += 2;
					goal2 += 2;
					break;
				} else if (op.getAbility() >= my.getAbility() + 10) {
					System.out.println("1루타 1득점!");
					op.score += 1;
					goal2 += 1;
					break;
				}
			}
			넘길거다.add(op);
			temp.remove(num1-1);
			
		}

		System.out.println("경기 종료! " + goal1 + " : " + goal2);
		if (goal1 > goal2) {
			System.out.println("우리팀이 승리했습니다.");
		} else if (goal1 == goal2) {
			System.out.println("무승부입니다");
		} else {
			System.out.println("상대팀이 승리했습니다");

		}
		
		
		System.out.println("========상대팀이 낸 스코어=========");

		return 넘길거다;
	}

	public void score() {
		System.out.println("득점 기록 : " + score);

	}

	public void insert(ArrayList<PlayerDTO> 매개) {
		getCon();

		for (int i = 0; i <= 2; i++) {
			System.out.println(매개.get(i).score);
		}

		try {
			for (int i = 0; i <= 2; i++) {
				String sql = "update playerinfo set d_score = ?  where d_name = ? ";
				psmt = conn.prepareStatement(sql);

				psmt.setInt(1, 매개.get(i).score);
				psmt.setString(2, 매개.get(i).getD_name());

				psmt.executeUpdate();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void rank() {

		getCon();
		ArrayList<PlayerDTO> totalList = new ArrayList<>();

		try {
			String sql = "select d_name, d_ability, d_score from playerInfo order by d_score desc";
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString("d_name");
				int ability = rs.getInt("d_ability");
				int score = rs.getInt("d_score");

				PlayerDTO dto = new PlayerDTO(name, ability, score);
				totalList.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		for (int i = 0; i < totalList.size(); i++) {
			System.out.println(totalList.get(i).getD_name() + " / " + totalList.get(i).getScore());
		}

	}

	public void rs() {

		getCon();

		try {
			String sql = "update playerInfo SET d_score = 0 WHERE d_name is not null";
			psmt = conn.prepareStatement(sql);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public void reSetAbility() {

		getCon();
		try {
			String sq = "UPDATE playerinfo SET d_ability = ROUND(DBMS_RANDOM.VALUE(0, 100)) WHERE d_name is not null";
			psmt = conn.prepareStatement(sq);
			psmt.executeUpdate();
			// }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}
	public void reSetC() {
		
		My.clear();
		
		Op.clear();
		
	}

}
