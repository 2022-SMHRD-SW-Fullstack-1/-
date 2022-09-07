package Controller;
import java.util.ArrayList;
import Model.PlayerDTO;
public interface GameInterface {
	public abstract void printMenu();
	
	public abstract ArrayList<PlayerDTO> conSelect();
	
	public abstract void conChoice(ArrayList<PlayerDTO> All);
	
	public abstract void conAtt();
	
	public abstract void conDef();
	
	public abstract void conCheck();
	
	public abstract void conScore();
	
	public abstract void conRank();
	
	public abstract void conRs();
	
	public abstract void reSetAbility();
	
	public abstract void reSetC();
	
}