package zombievsplants.controller;


import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

import zombievsplants.model.Card;
import zombievsplants.model.LawnCleaner;
import zombievsplants.model.Plant;
import zombievsplants.model.Zombie;
import zombievsplants.view.GameView;
import zombievsplants.view.PanelListener;
//游戏控制中心
public class GameController {
	public static int run = Integer.MIN_VALUE;		//是否运行程序
	public static int i = 0;				//记录游戏运行的时间
	public static int sunNum;			//阳光数量
	public static Plant plant = null;		//被点击卡片所代表的植物
	public static JLabel plantImage = null;	//被点击的卡片所代表植物在界面上的显示（用于随鼠标的移动而移动）
	public static Card card = null;			//被点击的卡片
	public static List<Plant> allPlant = new ArrayList<Plant>();	//所有植物的集合
	public static List<Zombie> allzom = new ArrayList<Zombie>();	//所有僵尸的集合
	public static List<Card> allcard = new ArrayList<Card>();		//所有卡片的集合
	public static List<LawnCleaner> allcleaner = new ArrayList<LawnCleaner>(); //所有推车的集合
	public static List<JButton> allsun= new ArrayList<JButton>(); 
	public static Music music = new Music();		//音乐
	public static ButtonController buttonc = new ButtonController();	//按钮响应
	public static PanelListener panell = new PanelListener();		//鼠标响应
	public static CardController cardc = new CardController();
	

	public static void main(String[] args) {
		//初始化窗口
		new GameView();
		//背景音乐
		music.playBack();
    	//循环实现动画效果
		while(true) {
			//运行游戏
			if(run==0) {
				if (i == Integer.MAX_VALUE) {
					i = 201;
				}
				else {
					i++;
				}
	    		ZombieAct.walk();
	    		PlantAct.shoot();
	    		CardAct.update();
	    		LawnCleanerAct.clean();
	    		SunAct.AddSunFromSky();
	    		GameView.frame.remove(GameView.sun);		    		
	    		GameView.sun.setText(String.valueOf(GameController.sunNum));
	    		GameView.frame.add(GameView.sun);
	    		GameView.sun.setBounds(58, 76, 60, 25);
				GameView.frame.repaint();
	    		switch(Level.theLevel) {
	    		case 1:Level.level1();
	    		break;
	    		case 2:Level.level2();
	    		break;
	    		case 3:Level.level3();
	    		break;
	    		default: ;
	    		}
	    	}
			//僵尸胜利
			if(run==-1) {
				ZombieWon.zombiewon();
			}
			//植物胜利
			if(run==Integer.MAX_VALUE) {
				PlantWon.plantwon();
			}
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}   
		}
    	
    	
    }

}
