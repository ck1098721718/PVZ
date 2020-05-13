package zombievsplants.controller;

import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;

import zombievsplants.model.Card;
import zombievsplants.model.LawnCleaner;
import zombievsplants.model.Plant;
import zombievsplants.model.Zombie;
import zombievsplants.view.GameView;

public class Remove {
	//清除游戏的数据
	public static void remove() {
		//清除卡片
		Iterator<Card> iter1 = GameController.allcard.iterator();
		while(iter1.hasNext()) {
			Card c = iter1.next();
			GameView.frame.remove(c.getCard());
			iter1.remove();
		}
		//清除僵尸
		Iterator<Zombie> iter2 = GameController.allzom.iterator();
		while(iter2.hasNext()) {
			Zombie z = iter2.next();			
			GameView.frame.remove(z.getZom());
			z.endEat();
			iter2.remove();
			
		}
		//清除植物
		Iterator<Plant> iter3 = GameController.allPlant.iterator();
		while(iter3.hasNext()) {
			Plant p = iter3.next();
			GameView.hasPlant[p.getX()-1][p.getY()-1]=false;
			GameView.frame.remove(p.getPlant());
			//清除植物的产物
			for(JLabel pb:p.getProducts()) {
				GameView.frame.remove(pb);
			}
			iter3.remove();
			GameView.frame.repaint();	
		}
		//清除推车
		Iterator<LawnCleaner> iter4 = GameController.allcleaner.iterator();
		while (iter4.hasNext()) {
			LawnCleaner l = iter4.next();
			GameView.frame.remove(l.getCleaner());
			iter4.remove();
		}
		
		//清除阳光
		Iterator<JButton> iter6 = SunAct.allskysun.iterator();
		while (iter6.hasNext()) {
			JButton j = iter6.next();
			GameView.frame.remove(j);
			iter6.remove();
		}
		Iterator<JButton> iter5 = GameController.allsun.iterator();
		while (iter5.hasNext()) {
			JButton j = iter5.next();
			GameView.frame.remove(j);
			iter5.remove();
		}
		GameView.frame.remove(GameView.sun);
		//清除鼠标响应
		GameView.frame.removeMouseListener(GameController.panell);
		GameView.frame.removeMouseMotionListener(GameController.panell);
	}
}
