package Controller;
import java.util.ArrayList;
import javazoom.jl.player.MP3Player;
import Model.DMusic;
public class DMusicController {
	ArrayList<DMusic> mList = new ArrayList<>();
	
	MP3Player mp3 = new MP3Player();
	
	int index = 0;
	
	public DMusicController() {
		mList.add(new DMusic("opening","C:\\Users\\smhrd\\Desktop\\dmusic\\butterfly.mp3"));
		mList.add(new DMusic("ending","C:\\Users\\smhrd\\Desktop\\dmusic\\hidisimon.mp3"));
		mList.add(new DMusic("battle","C:\\Users\\smhrd\\Desktop\\dmusic\\dmusic/bounce.mp3"));
	}
	
	public void opening() {			
		if(mp3.isPlaying()) {
				mp3.stop();
		}
		mp3.play(mList.get(0).getMusicPath());
	}
	
	public void ending() {
		if(mp3.isPlaying()) {
				mp3.stop();
		}
			mp3.play(mList.get(1).getMusicPath());
	}
	
	public void battle() {
		if(mp3.isPlaying()) {
				mp3.stop();
		}
		mp3.play(mList.get(2).getMusicPath());
	}
	
	public void stop() {
		mp3.stop();
	}
	
}