package zombievsplants.controller;

import java.util.Iterator;

import javax.swing.ImageIcon;

import zombievsplants.model.Plant;
import zombievsplants.model.Zombie;
import zombievsplants.view.GameView;
//每轮循环僵尸的行为
public class ZombieAct {
	public static void walk() {
		synchronized(GameController.allzom) {
			Iterator<Zombie> iter = GameController.allzom.iterator();
			while(iter.hasNext()) {
				boolean iswalk = true;
				Zombie z = iter.next();
				if(z.getHp()==10) {
					z.setWalk(new ImageIcon("src/zombievsplants/photos/Zombie.gif"));
					z.setAttack(new ImageIcon("src/zombievsplants/photos/ZombieAttack.gif"));
				}
				//僵尸死亡时清除内存
				if (z.getHp()<=0) {
					GameView.frame.remove(z.getZom());
					iter.remove();
					GameView.frame.repaint();
					z.endEat();
				}
				//吃植物时
				for(Plant p:GameController.allPlant) {
					if ((z.getY()==p.getY())&&(z.getZom().getBounds().x-p.getPlant().getBounds().x)<=-20&&(z.getZom().getBounds().x-p.getPlant().getBounds().x)>=-80) {
						//更换图片，设置停止行走
						z.getZom().setIcon(z.getAttack());
						GameView.frame.repaint();
						if(z.isIswalk()) {
							z.startEat();         
							z.stopWalk(); 
						}
						iswalk = false;
						//植物生命减1
						p.setHp(p.getHp()-z.getDamage());
						//z.startEat();
						break;
					}
					
				}
				//僵尸吃了你的脑子了
				if (z.getZom().getBounds().x<=-90) {
					GameController.run = -1;
				}
				if (GameController.i%3==0&&iswalk) {//僵尸停止吃植物
					if(z.getZom().getIcon()!=z.getWalk()) {
						z.getZom().setIcon(z.getWalk());
					}
					if(!z.isIswalk()) {
						z.endEat();
						z.startWalk();
					}
					z.getZom().setBounds(z.getZom().getBounds().x-1, -55+100*z.getY(), z.getWalk().getIconWidth(), z.getWalk().getIconHeight());
				}
				
			}
		}
		
	}
}
