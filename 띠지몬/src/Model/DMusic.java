package Model;

public class DMusic {
	
	private String musicPath;
	private String title;
	
	public DMusic(String title, String musicPath) {
		this.title = title;
		this.musicPath = musicPath;	
	}
	
	public String getMusicPath() {
		return musicPath;
	}

}
