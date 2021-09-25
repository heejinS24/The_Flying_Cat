package the_flying_cat_8;

public class Level {
	
	private String titleImage; // 제목부분이미지
	private String startImage; // 게임선택 창 표지 이미지
	private String gameImage; // 해당 곡을 실행했을 때 표지 이미지
	public String getTitleImage() {
		return titleImage;
	}
	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}
	public String getStartImage() {
		return startImage;
	}
	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}
	public String getGameImage() {
		return gameImage;
	}
	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}
	public Level(String titleImage, String startImage, String gameImage) {
		super();
		this.titleImage = titleImage;
		this.startImage = startImage;
		this.gameImage = gameImage;
	}
	
	
}
