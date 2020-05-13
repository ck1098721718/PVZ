package zombievsplants.controller;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import zombievsplants.model.Card;
import zombievsplants.model.CherryBomb;
import zombievsplants.model.Peashooter;
import zombievsplants.model.Plant;
import zombievsplants.model.SunFlower;
import zombievsplants.model.WallNut;
import zombievsplants.model.Zombie;
import zombievsplants.view.GameView;
//游戏关卡的设置
public class Level {
	public static JLabel finalwave;		//提醒最后一波僵尸即将到来的标签
	public static JLabel largewave;		//提醒一大波僵尸即将到来的标签
	public static JLabel levelName;		//关卡的名称的标签
	public static int theLevel = 3;		//当前游戏关卡
	//所有关卡都一样的初始设定
	//游戏一轮循环为20ms，50*20=1000ms，即1s
	
	public static void removeAndAdd() {
		//把所有的植物和僵尸先remove再add，防止植物和僵尸遮挡住字
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
	}
	
	public static void level0() {
		//提示准备安放植物
		if(GameController.i==1*50) {
			GameView.prepare = new JLabel(new ImageIcon("src/zombievsplants/photos/PrepareGrowPlants1.gif"));
			GameView.frame.add(GameView.prepare);
			GameView.prepare.setBounds(350, 300, GameView.prepare.getIcon().getIconWidth(), GameView.prepare.getIcon().getIconHeight());
		}
		if(GameController.i==2*50) {
			GameView.prepare.setIcon(new ImageIcon("src/zombievsplants/photos/PrepareGrowPlants2.gif"));
			GameView.frame.repaint();
		}
		if(GameController.i==3*50) {
			GameView.prepare.setIcon(new ImageIcon("src/zombievsplants/photos/PrepareGrowPlants3.gif"));
			GameView.frame.repaint();
		}
		if(GameController.i==4*50) {
			GameView.frame.remove(GameView.prepare);
			GameView.frame.repaint();
			//在窗口中加入鼠标监听器
			GameView.frame.addMouseListener(GameController.panell);
			GameView.frame.addMouseMotionListener(GameController.panell);
		}
		
		
		
		
	}
	public static void level1() {		//第一关
		level0();
		//生成卡片，并将除第3行外的草坪设为不可安放植物的状态
		if(GameController.i==4*50) {	
			new Card(new SunFlower());
			new Card(new Peashooter());
			for(int i=0;i<9;i++) {
				for(int j=0;j<5;j++) {
					if(j!=2) {
						GameView.hasPlant[i][j]=true;
					}
					else {
						GameView.hasPlant[i][j]=false;
					}
				}
			}
			//右下角添加游戏关卡名字的标签
			levelName = new JLabel(new ImageIcon("src/zombievsplants/photos/关卡1.png"));
			GameView.frame.add(levelName);
			levelName.setBounds(800	, 615, levelName.getIcon().getIconWidth(), levelName.getIcon().getIconHeight());
		}		
		//初始缓慢生成僵尸
		if(GameController.i<120*50) {
			if (GameController.i%1000==900) {
				AddZombie.addZombie(3,theLevel);
			}
		}
		else if(GameController.i<160*50){
			if (GameController.i%1000==1) {
				AddZombie.addZombie(3,theLevel);
				AddZombie.addZombie(3,theLevel);
			}
		}
				
		//提醒一大波僵尸即将到来
		if(GameController.i==160*50) {
			largewave = new JLabel(new ImageIcon("src/zombievsplants/photos/LargeWave.gif"));
			GameView.frame.add(largewave);
			largewave.setBounds(350, 300, largewave.getIcon().getIconWidth(),largewave.getIcon().getIconHeight());
			Level.removeAndAdd();
		}	
		if(GameController.i==162*50) {
			GameView.frame.remove(largewave);
		}
				
		//提醒最后一波到来
		if(GameController.i==169*50) {
			finalwave = new JLabel(new ImageIcon("src/zombievsplants/photos/FinalWave.gif"));
			GameView.frame.add(finalwave);
			finalwave.setBounds(350, 300, finalwave.getIcon().getIconWidth(),finalwave.getIcon().getIconHeight());
			Level.removeAndAdd();
		}
		//最后一波
		if(GameController.i>=170*50&&GameController.i<=190*50) {
			GameView.frame.remove(finalwave);
			if(GameController.i%100==0) {
				AddZombie.addZombie(3,theLevel);
			}
		}
		//胜利
		if(GameController.i>190*50) {
			if(GameController.allzom.size()==0) {
				GameController.run = Integer.MAX_VALUE;
				GameController.i=0;
			}
		}
	}
	
	
	public static void level2() {	//第二关
		level0();
		//生成卡片，并将第1、5行的草坪设为不可安放植物的状态
		if(GameController.i==4*50) {
			new Card(new SunFlower());
			new Card(new Peashooter());
			new Card(new WallNut());
			for(int i=0;i<9;i++) {
				for(int j=0;j<5;j++) {
					if(j==0||j==4) {
						GameView.hasPlant[i][j]=true;
					}
					else {
						GameView.hasPlant[i][j]=false;
					}			
				}
			}
			JLabel l = new JLabel(new ImageIcon("src/zombievsplants/photos/关卡2.png"));
			GameView.frame.add(l);
			l.setBounds(800	, 615, l.getIcon().getIconWidth(), l.getIcon().getIconHeight());
		}		
		//初始缓慢生成僵尸
		if(GameController.i<120*50) {
			if (GameController.i%1000==900) {
				Random rand = new Random();
				AddZombie.addZombie(rand.nextInt(3)+2,1);
			}
		}
		else if(GameController.i<210*50){
			if (GameController.i%1000==1) {
				Random rand = new Random();
				AddZombie.addZombie(rand.nextInt(3)+2,theLevel);
				AddZombie.addZombie(rand.nextInt(3)+2,theLevel);
			}
		}
				
		//提醒一大波僵尸即将到来
		if(GameController.i==210*50) {
			largewave = new JLabel(new ImageIcon("src/zombievsplants/photos/LargeWave.gif"));
			GameView.frame.add(largewave);
			largewave.setBounds(350, 300, largewave.getIcon().getIconWidth(),largewave.getIcon().getIconHeight());
			Level.removeAndAdd();
		}	
		if(GameController.i==212*50) {
			GameView.frame.remove(largewave);
		}
		//第一波		
		if(GameController.i>=220*50&&GameController.i<=240*50) {
			if(GameController.i%60==0) {
				Random rand = new Random();
				AddZombie.addZombie(rand.nextInt(3)+2,theLevel);
			}
		}
		//中间缓冲
		if(GameController.i>=270*50&&GameController.i<=330*50) {
			if(GameController.i%500==0) {
				Random rand = new Random();
				AddZombie.addZombie(rand.nextInt(3)+2,theLevel);
			}
		}
		//提醒一大波僵尸即将到来
		if(GameController.i==335*50) {
			largewave = new JLabel(new ImageIcon("src/zombievsplants/photos/LargeWave.gif"));
			GameView.frame.add(largewave);
			largewave.setBounds(350, 300, largewave.getIcon().getIconWidth(),largewave.getIcon().getIconHeight());
			Level.removeAndAdd();
		}	
		if(GameController.i==337*50) {
			GameView.frame.remove(largewave);
		}
		//提醒最后一波
		if(GameController.i==343*50) {
			finalwave = new JLabel(new ImageIcon("src/zombievsplants/photos/FinalWave.gif"));
			GameView.frame.add(finalwave);
			finalwave.setBounds(350, 300, finalwave.getIcon().getIconWidth(),finalwave.getIcon().getIconHeight());
			Level.removeAndAdd();
		}
		//最后一波
		if(GameController.i>=350*50&&GameController.i<=370*50) {
			GameView.frame.remove(finalwave);
			if(GameController.i%50==0) {
				Random rand = new Random();
				AddZombie.addZombie(rand.nextInt(3)+2,theLevel);
			}
		}
		
		//胜利
		if(GameController.i>370*50) {
			if(GameController.allzom.size()==0) {
				GameController.run = Integer.MAX_VALUE;
				GameController.i=0;
			}
		}
	}
	
	public static void level3() {		//第三关
		level0();
		//生成卡片，并将所有草坪设置为可安放植物的状态
		if(GameController.i==4*50) {
			new Card(new SunFlower());
			new Card(new Peashooter());
			new Card(new WallNut());
			new Card(new CherryBomb());
			for(int i=0;i<9;i++) {
				for(int j=0;j<5;j++) {
						GameView.hasPlant[i][j]=false;		
				}
			}
			JLabel l = new JLabel(new ImageIcon("src/zombievsplants/photos/关卡3.png"));
			GameView.frame.add(l);
			l.setBounds(800	, 615, l.getIcon().getIconWidth(), l.getIcon().getIconHeight());
		}		
		//初始缓慢生成僵尸
		if(GameController.i<120*50) {
			if (GameController.i%1000==900) {
				Random rand = new Random();
				AddZombie.addZombie(rand.nextInt(5)+1,1);
			}
		}
		else if(GameController.i<210*50){
			if (GameController.i%1000==0) {
				Random rand = new Random();
				AddZombie.addZombie(rand.nextInt(5)+1,theLevel);
				AddZombie.addZombie(rand.nextInt(5)+1,theLevel);
			}
		}
				
		//提醒一大波僵尸即将到来
		if(GameController.i==210*50) {
			largewave = new JLabel(new ImageIcon("src/zombievsplants/photos/LargeWave.gif"));
			GameView.frame.add(largewave);
			largewave.setBounds(350, 300, largewave.getIcon().getIconWidth(),largewave.getIcon().getIconHeight());
			Level.removeAndAdd();
		}	
		if(GameController.i==212*50) {
			GameView.frame.remove(largewave);
		}
		//第一波		
		if(GameController.i>=220*50&&GameController.i<=240*50) {
			if(GameController.i%60==0) {
				Random rand = new Random();
				AddZombie.addZombie(rand.nextInt(5)+1,theLevel);
			}
		}
		//中间缓冲
		if(GameController.i>=270*50&&GameController.i<=330*50) {
			if(GameController.i%300==0) {
				Random rand = new Random();
				AddZombie.addZombie(rand.nextInt(5)+1,theLevel);
			}
		}
		//提醒一大波僵尸即将到来
		if(GameController.i==335*50) {
			largewave = new JLabel(new ImageIcon("src/zombievsplants/photos/LargeWave.gif"));
			GameView.frame.add(largewave);
			largewave.setBounds(350, 300, largewave.getIcon().getIconWidth(),largewave.getIcon().getIconHeight());
			Level.removeAndAdd();
		}	
		if(GameController.i==337*50) {
			GameView.frame.remove(largewave);
		}
		
		if(GameController.i>=340*50&&GameController.i<=370*50) {
			if(GameController.i%50==0) {
				Random rand = new Random();
				AddZombie.addZombie(rand.nextInt(5)+1,theLevel);
			}
		}
		//中间缓冲
		if(GameController.i>=400*50&&GameController.i<=430*50) {
			if(GameController.i%250==0) {
				Random rand = new Random();
				AddZombie.addZombie(rand.nextInt(5)+1,theLevel);
			}
		}
		//提醒一大波僵尸即将到来
		if(GameController.i==435*50) {
			largewave = new JLabel(new ImageIcon("src/zombievsplants/photos/LargeWave.gif"));
			GameView.frame.add(largewave);
			largewave.setBounds(350, 300, largewave.getIcon().getIconWidth(),largewave.getIcon().getIconHeight());
			Level.removeAndAdd();
		}	
		if(GameController.i==437*50) {
			GameView.frame.remove(largewave);
		}
		//提醒最后一波
		if(GameController.i==443*50) {
			finalwave = new JLabel(new ImageIcon("src/zombievsplants/photos/FinalWave.gif"));
			GameView.frame.add(finalwave);
			finalwave.setBounds(350, 300, finalwave.getIcon().getIconWidth(),finalwave.getIcon().getIconHeight());
			Level.removeAndAdd();
		}
		if(GameController.i>=440*50&&GameController.i<=480*50) {
			GameView.frame.remove(finalwave);
			if(GameController.i%50==0) {
				Random rand = new Random();
				AddZombie.addZombie(rand.nextInt(5)+1,theLevel);
			}
		}
		//胜利
		if(GameController.i>480*50) {
			if(GameController.allzom.size()==0) {
				GameController.run = Integer.MAX_VALUE;
				GameController.i=0;
			}
		}
	}
}
