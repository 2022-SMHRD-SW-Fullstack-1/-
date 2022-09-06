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
	
//	
//	
//	public void gameStart(File Sound) {
//	try {		
//		Clip clip = AudioSystem.getClip();
//		AudioInputStream ais = AudioSystem.getAudioInputStream(Sound);
//		clip.open(ais);
//		clip.start();
//	}
//	catch (Exception e) {
//		System.out.println("음악이 재생되지 않습니다.");
//		e.printStackTrace();
//	}
//}
//	
//	public void dStop(File Sound) {
//	
//		try {
//			Clip clip = AudioSystem.getClip();
//			AudioInputStream ais = AudioSystem.getAudioInputStream(Sound);
//			clip.open(ais);
//			clip.stop();
//			clip.close();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	

//	public void play() {
//		// 노래 재생을 위한 메소드
//		// 호출시 mList에 있는 노래를 play
//		if(mp3.isPlaying()) {
//			mp3.stop();
//		}
//		mp3.play(mList.get(index).getMusicPath());
//	}
	
	public void stop() {
		mp3.stop();
	}
	
	public void next() {
		if(mp3.isPlaying()) {
			mp3.stop();
		}
		
		// index 번호가 3일 때 다시 0으로 돌아갈 수 있는 작업 진행
		if(index<mList.size()-1) {
			index++;	
		}else { //마지막 인덱스에서 다시 다음버튼을 눌렀을 때
			index = 0;
		}
			mp3.play(mList.get(index).getMusicPath());			
	}
	
	public void pre() {
		if(mp3.isPlaying()) {
			mp3.stop();
		}
		if(index > 0) {
			index--;
		}else { //마지막 인덱스에서 다시 다음부턴을 눌렀을 때
			index = mList.size()-1;
		}
			mp3.play(mList.get(index).getMusicPath());
	}
}