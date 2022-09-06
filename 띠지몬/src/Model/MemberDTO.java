package Model;

public class MemberDTO {
	
	//Model -> VO(Value Object) -> DTO(Data Transfer Object)
	int b;
	//회원관리를 위한 설계도
	private String id;
	private String pw;
	private String nick;
	
	public MemberDTO(String id, String nick) {
		this.id = id;
		this.pw = pw;
		this.nick = nick;
	}
	
	public String getId() {
		return id;
	}
	
	public String getNick() {
		return nick;
	}
	int a;
}
