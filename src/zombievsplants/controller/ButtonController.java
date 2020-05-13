package zombievsplants.controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import zombievsplants.model.Card;
import zombievsplants.model.Plant;
import zombievsplants.model.Zombie;
import zombievsplants.view.GameView;
//处理各种按钮的响应
public class ButtonController implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		//点击开始冒险的按钮，初始化游戏
		if (e.getSource()==GameView.begin) {
			Initialize.initialize();		
		}
		//点击菜单按钮
		if (e.getSource()==GameView.menuButton) {
			GameController.music.pause();
			//生成菜单上返回游戏的按钮
			GameView.back = new JButton(new ImageIcon ("src/zombievsplants/photos/返回游戏.png"));
			GameView.back.setBorder(null);
			GameView.frame.add(GameView.back);
			GameView.back.setBounds(290, 440, GameView.back.getIcon().getIconWidth(), GameView.back.getIcon().getIconHeight());
			GameView.back.addActionListener(this);
			//生成菜单上重新开始的按钮
			ImageIcon img1 = new ImageIcon("src/zombievsplants/photos/重新开始.png");
	    	img1.setImage(img1.getImage().getScaledInstance(230,80,Image.SCALE_DEFAULT));
			GameView.restart = new JButton (img1);
			GameView.restart.setBorder(null);
			GameView.frame.add(GameView.restart);
			GameView.restart.setBounds(342, 330, img1.getIconWidth(), img1.getIconHeight());
			GameView.restart.addActionListener(this);
			//生成菜单上主菜单的按钮
			ImageIcon img2 = new ImageIcon("src/zombievsplants/photos/主菜单.png");
	    	img2.setImage(img2.getImage().getScaledInstance(230,80,Image.SCALE_DEFAULT));
			GameView.mainmenu = new JButton (img2);
			GameView.mainmenu.setBorder(null);
			GameView.frame.add(GameView.mainmenu);
			GameView.mainmenu.setBounds(342, 240, img2.getIconWidth(), img2.getIconHeight());
			GameView.mainmenu.addActionListener(this);
			//生成菜单的界面，以标签显示
			GameView.menu = new JLabel(new ImageIcon("src/zombievsplants/photos/OptionsMenuback32.gif"));
			GameView.frame.add(GameView.menu);
			GameView.menu.setBounds(250, 50, GameView.menu.getIcon().getIconWidth(), GameView.menu.getIcon().getIconHeight());
			//取消卡片的响应
			for(Card c: GameController.allcard) {
				c.getCard().removeActionListener(GameController.cardc);
			}
			//把所有的植物和僵尸先remove再add，防止植物和僵尸遮挡住菜单栏
			for(Plant p :GameController.allPlant) {
				GameView.frame.remove(p.getPlant());
				GameView.frame.add(p.getPlant());
				for(JLabel pb:p.getProducts()) {
					GameView.frame.remove(pb);
					GameView.frame.add(pb);
				}
			}
			for(Zombie z:GameController.allzom) {
				GameView.frame.remove(z.getZom());
				GameView.frame.add(z.getZom());
			}
			//点击菜单时暂停游戏
			GameController.run = Integer.MIN_VALUE;
			GameView.frame.repaint();
		}
		//点击返回游戏的按钮
		if(e.getSource()==GameView.back) {
			//将菜单及其上的按钮都remove
			GameView.frame.remove(GameView.menu);
			GameView.frame.remove(GameView.back);
			GameView.frame.remove(GameView.mainmenu);
			GameView.frame.remove(GameView.restart);
			GameView.frame.repaint();
			//重新加入卡片的响应
			for(Card c: GameController.allcard) {
				c.getCard().addActionListener(GameController.cardc);
			}
			//重新开始游戏
			GameController.run = 0;
		}
		//点击重新开始的按钮
		if (e.getSource()==GameView.restart) {
			//清除游戏上的僵尸植物等
			Remove.remove();
			//清除菜单
			GameView.frame.remove(GameView.menu);
			GameView.frame.remove(GameView.mainmenu);
			GameView.frame.remove(GameView.restart);
			GameView.frame.remove(GameView.back);
			GameView.frame.remove(GameView.menuButton);
			//重新初始化游戏
			Initialize.initialize();
		}
		
		//点击主菜单的按钮
		if(e.getSource()==GameView.mainmenu) {
			//更换背景图片，显示主菜单
			ImageIcon backImg = new ImageIcon("src/zombievsplants/photos/Surface.jpg");//背景图片
	    	backImg.setImage(backImg.getImage().getScaledInstance(GameView.WIDTH,GameView.HEIGHT,Image.SCALE_DEFAULT));	   	
	    	GameView.background.setIcon(backImg);
	    	//将原游戏的数据清空
	    	Remove.remove();   
	    	//清除原游戏界面的菜单栏
	    	GameController.music.end();
	    	GameController.music.playBack();
	    	GameView.frame.remove(GameView.menu);
			GameView.frame.remove(GameView.mainmenu);
			GameView.frame.remove(GameView.restart);
			GameView.frame.remove(GameView.back);
			GameView.frame.remove(GameView.menuButton);
			GameView.frame.remove(Level.levelName);
	    	//主菜单界面加入开始冒险的按钮
	    	GameView.begin.setBorder(null);
	    	GameView.begin.setIcon(new ImageIcon("src/zombievsplants/photos/maoxian1.gif"));
	    	GameView.frame.add(GameView.begin);
	    	GameView.begin.setBounds(515, 100, GameView.begin.getIcon().getIconWidth()
	    			, GameView.begin.getIcon().getIconHeight());
	    	
		}
	}
	

}
