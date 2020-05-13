package zombievsplants.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import zombievsplants.controller.GameController;


//显示背景房屋和不动的东西
public class GameView {
	public static final int WIDTH = 958;		//窗口的大小
	public static final int HEIGHT =638;
	public static boolean [][] hasPlant = new boolean [9][5]; //判断该处是否已有植物
	public static JFrame frame;
	public static JLabel sun = new JLabel(String.valueOf(GameController.sunNum));;	//显示当前阳光数量的标签	
	public static JButton menuButton;			//菜单按钮
	public static JLabel menu;				//菜单标签
	public static JLabel background;	//背景图片
	public static JButton begin;		//开始游戏的按钮
	public static JButton back;		//返回游戏的按钮
	public static JButton restart ;	//重新开始的按钮
	public static JButton mainmenu ;//主菜单的按钮
	public static JLabel prepare;	//开始安放植物的标签
	public static JLabel zombiewon;	//僵尸胜利
	public static JLabel zwmenu;	//僵尸胜利
	public static JButton zwrestart;//僵尸胜利
	public static JLabel pwmenu;	//僵尸胜利
	public static JButton pwstart;//僵尸胜利
	
	public GameView() {
		frame = new JFrame("植物大战僵尸");
		ImageIcon backImg = new ImageIcon("src/zombievsplants/photos/Surface.jpg");//背景图片
    	backImg.setImage(backImg.getImage().getScaledInstance(WIDTH,HEIGHT,Image.SCALE_DEFAULT));
    	background = new JLabel(backImg);//将背景图放在标签里
    	ImageIcon beginImg = new ImageIcon("src/zombievsplants/photos/maoxian1.gif");//这是开始按钮的图片
    	//开始按钮的初始化
    	begin = new JButton(beginImg);
    	begin.setOpaque(false);
    	begin.setBorderPainted(false);
    	begin.setContentAreaFilled(false);
    	begin.setBorder(null);
    	frame.add(begin);
		begin.setBounds(515, 100, beginImg.getIconWidth(), beginImg.getIconHeight());
    	begin.addMouseListener(new Start ());
    	begin.addActionListener(GameController.buttonc);

		
		//设置背景图片
    	frame.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));//注意这里是关键,将背景标签添加到JFrame的LayeredPane面板里
    	background.setBounds(0,0,backImg.getIconWidth(), backImg.getIconHeight());//设置背景标签的位置
    	Container cp=frame.getContentPane();
    	cp.setLayout(new BorderLayout());
    	((JPanel)cp).setOpaque(false); //注意这里,将内容面板设为透明。这样LayeredPane面板中的背景才能显示出来
    	
    	//设置窗口的位置  	
    	Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
    	Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
    	int screenWidth = screenSize.width/2; // 获取屏幕的宽
    	int screenHeight = screenSize.height/2; // 获取屏幕的高
    	frame.setLocation(screenWidth-WIDTH/2, screenHeight-HEIGHT/2);//设置窗口居中
    	frame.setVisible(true);
    	frame.setSize(WIDTH, HEIGHT+35);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setResizable(false);
	}



	
}