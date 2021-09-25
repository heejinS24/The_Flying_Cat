package the_flying_cat_10;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TheFlyingCat extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
	private Image barImage = new ImageIcon(Main.class.getResource("../images/bar.png")).getImage();
	private Image boomBlockBasicImage_1 = new ImageIcon(Main.class.getResource("../images/boomBlockBasic_1.png")).getImage();
	private Image boomBlockBasicImage_2 = new ImageIcon(Main.class.getResource("../images/boomBlockBasic_2.png")).getImage();
	private Image boomBlockBasicImage_3 = new ImageIcon(Main.class.getResource("../images/boomBlockBasic_3.png")).getImage();
	private Image punchBlockBasicImage = new ImageIcon(Main.class.getResource("../images/punchBlockBasic.png")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
	private ImageIcon pickButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/pickButtonEntered.png"));
	private ImageIcon pickButtonBasicImage = new ImageIcon(Main.class.getResource("../images/pickButtonBasic.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));
	
	
	/*버튼 변수 생성*/
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton pickButton = new JButton(pickButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);
	
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;
	private boolean isGameScreen = false;
	
	ArrayList<Level> levelList = new ArrayList<Level>();
	
	private Image titleImage;
	private Image selectedImage;
	private Level selectedLevel;
	private Music introMusic = new Music("introMusic.mp3", true);
	private int nowSelected= 0;

	public TheFlyingCat() {
		setUndecorated(true);// 메뉴바 보이지 않게됨
		setTitle("TheFlyingCat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);// 사용자 창크기 변경불가
		setLocationRelativeTo(null);// 중앙배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 게임종료시 모두종료
		setVisible(true);// 게임창 실행가능하게함
		setBackground(new Color(0, 0, 0, 0)); // 배경이 하얀색?
		setLayout(null);
		
		introMusic.start();
		
		levelList.add(new Level("Level_1_title.png","Level_1.png","Level_1_Game.png"));
		levelList.add(new Level("Level_2_title.png","Level_2.png","Level_2_Game.png"));
		levelList.add(new Level("Level_3_title.png","Level_3.png","Level_3_Game.png"));
		
		exitButton.setBounds(1245, 0, 30, 30); // x축,y축,가로크기,세로크기
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서 모양 바꾸기
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서 모양 바꾸기
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);
				}catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		
		add(exitButton);
		
		startButton.setBounds(850, 440, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서 모양 바꾸기
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서 모양 바꾸기
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				enterMain();
			}
		});
		
		add(startButton);
		
		quitButton.setBounds(850, 560, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서 모양 바꾸기
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서 모양 바꾸기
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);
				}catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		
		add(quitButton);
		
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 70, 70);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서 모양 바꾸기
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서 모양 바꾸기
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				selectLeft();
			}
		});
		
		add(leftButton);
		
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 70, 70);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서 모양 바꾸기
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서 모양 바꾸기
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				selectRight();
			}
		});
		
		add(rightButton);
		
		pickButton.setVisible(false);
		pickButton.setBounds(510, 600, 250, 67);
		pickButton.setBorderPainted(false);
		pickButton.setContentAreaFilled(false);
		pickButton.setFocusPainted(false);
		pickButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pickButton.setIcon(pickButtonEnteredImage);
				pickButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서 모양 바꾸기
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pickButton.setIcon(pickButtonBasicImage);
				pickButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서 모양 바꾸기
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				gameStart(nowSelected,"pick");
			}
		});
		
		add(pickButton);
		
		backButton.setVisible(false);
		backButton.setBounds(70, 50, 60, 60);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서 모양 바꾸기
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서 모양 바꾸기
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				backMain();
			}
		});
		
		add(backButton);
		
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);

	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		if(isMainScreen) {
			g.drawImage(selectedImage, 340, 120, null);
			g.drawImage(titleImage, 340, 40, null);
		}
		if(isGameScreen) {
			g.drawImage(barImage, 520, 650, null);
			g.drawImage(punchBlockBasicImage, 600, 570, null);
			g.drawImage(boomBlockBasicImage_1, 240, 30, null);
			g.drawImage(boomBlockBasicImage_1, 340, 30, null);
			g.drawImage(boomBlockBasicImage_3, 440, 30, null);
			g.drawImage(boomBlockBasicImage_1, 540, 30, null);
			g.drawImage(boomBlockBasicImage_1, 640, 30, null);
			g.drawImage(boomBlockBasicImage_3, 740, 30, null);
			g.drawImage(boomBlockBasicImage_2, 840, 30, null);
			g.drawImage(boomBlockBasicImage_1, 940, 30, null);
			g.drawImage(boomBlockBasicImage_3, 240, 130, null);
			g.drawImage(boomBlockBasicImage_2, 340, 130, null);
			g.drawImage(boomBlockBasicImage_3, 440, 130, null);
			g.drawImage(boomBlockBasicImage_1, 540, 130, null);
			g.drawImage(boomBlockBasicImage_2, 640, 130, null);
			g.drawImage(boomBlockBasicImage_1, 740, 130, null);
			g.drawImage(boomBlockBasicImage_1, 840, 130, null);
			g.drawImage(boomBlockBasicImage_2, 940, 130, null);
			g.drawImage(boomBlockBasicImage_2, 240, 230, null);
			g.drawImage(boomBlockBasicImage_1, 340, 230, null);
			g.drawImage(boomBlockBasicImage_3, 440, 230, null);
			g.drawImage(boomBlockBasicImage_2, 540, 230, null);
			g.drawImage(boomBlockBasicImage_3, 640, 230, null);
			g.drawImage(boomBlockBasicImage_2, 740, 230, null);
			g.drawImage(boomBlockBasicImage_1, 840, 230, null);
			g.drawImage(boomBlockBasicImage_3, 940, 230, null);
		}
		paintComponents(g);
		this.repaint();
	}
	
	public void selectLevel(int nowSelected) {
		titleImage = new ImageIcon(Main.class.getResource("../images/"+levelList.get(nowSelected).getTitleImage())).getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/"+levelList.get(nowSelected).getStartImage())).getImage();
	}
	
	public void selectLeft() {
		if(nowSelected == 0)
			nowSelected = levelList.size()-1; //
		else
			nowSelected--;
		selectLevel(nowSelected);
	}
	
	public void selectRight() {
		if(nowSelected == levelList.size()-1)
			nowSelected = 0; //
		else
			nowSelected++;
		selectLevel(nowSelected);
	}
	
	/*게임화면 실행*/
	public void gameStart(int nowSelected, String gamepick) {
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		pickButton.setVisible(false);
		backButton.setVisible(true);
		background = new ImageIcon(Main.class.getResource("../images/"+levelList.get(nowSelected).getGameImage())).getImage();
		isGameScreen = true;
	}
	
	/*뒤로가기 실행*/
	public void backMain() {
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		pickButton.setVisible(true);
		backButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
		selectLevel(nowSelected);
		isGameScreen = false;
	}
	
	/*레벨화면 실행*/
	public void enterMain() {
		startButton.setVisible(false);
		quitButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		pickButton.setVisible(true);
		introMusic.close();
		selectLevel(0);
	}
}	



