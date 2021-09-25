package the_flying_cat_1;


import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class TheFlyingCat extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic;
	private Image introBackground;
	
	public TheFlyingCat() {
		setTitle("TheFlyingCat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);// 사용자 창크기 변경불가
		setLocationRelativeTo(null);// 중앙배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//게임종료시 모두종료
		setVisible(true);//게임창 실행가능하게함
		
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		this.repaint();
	}
}
