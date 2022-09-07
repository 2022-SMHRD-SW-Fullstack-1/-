package Controller;

import java.util.ArrayList;

import Model.PlayerDAO;
import Model.PlayerDTO;

public class GameController implements GameInterface{
	
	PlayerDAO dao = new PlayerDAO();
	
	public void printMenu() {
		System.out.println("[1] 엔트리 생성 [2] 배틀 시작 [3] 선수 명단 확인 [4] 선수 랭킹 확인 [5] 뒤로가기");
	}
	
	public ArrayList<PlayerDTO> conSelect() { 
		ArrayList<PlayerDTO> totalList = new ArrayList<>();
		
		totalList = dao.select();
		return totalList;
	}
	
	public void conChoice(ArrayList<PlayerDTO> All) {
		dao.choice(All);
	}

	public void conAtt() {
		ArrayList<PlayerDTO> 매개 = new ArrayList<>();
		매개 = dao.attack();		
		dao.insert(매개);
	}
	
	public void conDef() {
		ArrayList<PlayerDTO> 매개 = new ArrayList<>();
		매개 = dao.defense();
		dao.insert(매개);
	}


	public void conCheck() {
		dao.M();
		
	}

	public void conScore() {
		dao.score();
		
	}

	public void conRank() {
		dao.rank();
		
	}
	
	public void conRs() {
		dao.rs();
	}
	public void reSetAbility() {
		dao.reSetAbility();
	}
	public void reSetC() {
	
		dao.reSetC();
	}
}
