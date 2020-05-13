package zombievsplants.controller;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import zombievsplants.model.LawnCleaner;
import zombievsplants.view.GameView;
//初始化游戏
public class Initialize {
	public static void initialize () {
		GameController.music.buttonAct();//按键音效
		
		ImageIcon img = null;
		switch(Level.theLevel) {	//根据关卡决定游戏的背景图片
			case 1:{
				img = new ImageIcon("src/zombievsplants/photos/background1.gif");//这是背景图片
				break;
			}
			case 2:{
				img = new ImageIcon("src/zombievsplants/photos/background3.gif");//这是背景图片
				break;
			}
			default:{
				img = new ImageIcon("src/zombievsplants/photos/background5.jpg");//这是背景图片
				break;
			}
		}
    	img.setImage(img.getImage().getScaledInstance(GameView.WIDTH,GameView.HEIGHT,Image.SCALE_DEFAULT));
    	GameController.music.endBack();
    	GameController.music.play();         //更改背景音乐
		GameView.background.setIcon(img);
		GameView.frame.remove(GameView.begin);
		
		//初始化游戏相关数据
		GameController.run = 0;		//开始游戏
		GameController.sunNum = 50;	//初始阳光数量设置为50
		GameController.i=0;			//重置循环次数
		GameController.plant = null;//卡片点击状态为空
		GameController.card = null;
		//加入推车
		for (int i =1;i<=5;i++) {
			LawnCleaner l = new LawnCleaner(i);
			GameController.allcleaner.add(l);
		}
		//加入菜单按钮
		GameView.menuButton = new JButton(new ImageIcon("src/zombievsplants/photos/菜单按钮.png"));
		GameView.menuButton.setBorder(null);
		GameView.menuButton.addActionListener(GameController.buttonc);
		GameView.frame.add(GameView.menuButton);		
		GameView.menuButton.setBounds(830, 0, GameView.menuButton.getIcon().getIconWidth(), GameView.menuButton.getIcon().getIconHeight());
		
		//加入显示记录阳光数量的标签
		
		GameView.sun.setFont(new Font("Serief",Font.BOLD,24));
		GameView.frame.add(GameView.sun);
		GameView.sun.setBounds(58, 76, 60, 25);	
		
		GameView.frame.repaint();	
	}

}
