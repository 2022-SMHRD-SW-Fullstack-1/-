package Controller;

import java.util.ArrayList;

import Model.MemberDAO;
import Model.MemberDTO;



public class MemberController {
	int b;
	// jdbc Controller 역할을 진행하는 클래스!
	
	// view <-> DAO(DB의 로직)
	
	
	MemberDAO dao = new MemberDAO();
	int cnt =0;
	
	public int conInsert(String id, String pw, String nick) {
		
		cnt = dao.insert(id,pw,nick);
		return cnt;
	}
	
	public String conLogin(String id, String pw) {
		String nick = dao.login(id, pw);
		
		return nick;
		
	}
	
	public ArrayList<MemberDTO> conSelect(){
		
		ArrayList<MemberDTO> totalList = new ArrayList<>();
		
		totalList = dao.select();
		return totalList;
		
	}
	
	public void conDel(String id) {
		dao.del(id);
	}
	
}
