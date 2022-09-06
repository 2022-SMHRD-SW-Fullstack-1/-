package Controller;

import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javazoom.jl.player.MP3Player;
import Model.DMusic;

public class DMusicController {

	ArrayList<DMusic> mList = new ArrayList<>();
	
	MP3Player mp3 = new MP3Player();
	
	int index = 0;
	
	public DMusicController() {
		mList.add(new DMusic("dmusic/hidisimon.wav"));
		mList.add(new DMusic("dmusic/bounce.wav"));
		mList.add(new DMusic("dmusic/catchit.wav"));
		mList.add(new DMusic("dmusic/butterfly.wav"));
	}
	
	public void gameStart(File Sound) {
	try {		
		Clip clip = AudioSystem.getClip();
		AudioInputStream ms = AudioSystem.getAudioInputStream(Sound);
		clip.open(ms);
		clip.start();
	}
	
	catch (Exception e)
	{System.out.println("음악이 재생되지 않습니다.");
	e.printStackTrace();
	
	}
}
	
	
	
	public void play() {
		// 노래 재생을 위한 메소드
		// 호출시 mList에 있는 노래를 play
		
		if(mp3.isPlaying()) {
			mp3.stop();
		}
		mp3.play(mList.get(index).getMusicPath());
	}
	
	public void stop() {
		mp3.stop();
	}
}