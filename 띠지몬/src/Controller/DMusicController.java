package Controller;

import java.util.ArrayList;

import javazoom.jl.player.MP3Player;
import Model.DMusic;

public class DMusicController {

	ArrayList<DMusic> mList = new ArrayList<>();
	
	MP3Player mp3 = new MP3Player();
	
	int index = 0; 
	
	public DMusicController() {
		mList.add(new DMusic("opening","dmusic/butterfly.mp3"));
		mList.add(new DMusic("ending","dmusic/hidisimon.mp3"));
		mList.add(new DMusic("battle","dmusic/bounce.mp3"));
	}
	
	public void opening() {
		try {			
			if(mp3.isPlaying()) {
				mp3.stop();
			}
			mp3.play(mList.get(0).getMusicPath());
		}catch(Exception e) {
		}
	}
	
	public void ending() {
		try {			
			if(mp3.isPlaying()) {
				mp3.stop();
			}
			mp3.play(mList.get(1).getMusicPath());
		}catch(Exception e) {
		}
	}
	
	public void battle() {
		try {			
			if(mp3.isPlaying()) {
				mp3.stop();
			}
			mp3.play(mList.get(2).getMusicPath());
		}catch(Exception e) {
		}
	}
	
	public void stop() {
		mp3.stop();
	}
	
}