package zombievsplants.controller;

import java.util.Iterator;

import javax.swing.JLabel;

import zombievsplants.model.LawnCleaner;
import zombievsplants.model.Plant;
import zombievsplants.model.Zombie;
import zombievsplants.view.GameView;
//推车每轮循环的行为
public class LawnCleanerAct {
	public static void clean() {
		//遍历所有推车
		Iterator<LawnCleaner> iter = GameController.allcleaner.iterator();
		while(iter.hasNext()) {
			LawnCleaner l = iter.next();
			//推车处于不动状态时，判断是否要动
			if (!l.isRun()) {
				for (Zombie z :GameController.allzom) {
					if (z.getY() == l.getY()&&(z.getZom().getBounds().x+50)<=l.getCleaner().getBounds().x) {
						l.setRun(true);
						break;
					}
				}
			}
			//推车处于动的状态时，将经过的所有僵尸和植物全部清空
			else {
				//推车向右移动
				l.getCleaner().setBounds(l.getCleaner().getBounds().x+4,l.getCleaner().getBounds().y, 
						l.getCleanerImage().getIconWidth(), l.getCleanerImage().getIconHeight());
				//判断推车是否出了屏幕，若出了屏幕，移除推车
				if (l.getCleaner().getBounds().x >= GameView.WIDTH) {
					GameView.frame.remove(l.getCleaner());
					iter.remove();
				}
				//遍历僵尸，判断每个僵尸和推车的坐标是否一致，若一致，清除僵尸
				Iterator<Zombie> iter2 = GameController.allzom.iterator();
				while(iter2.hasNext()) {
					Zombie z = iter2.next();
					//判断位置
					if (z.getY() == l.getY()&&(z.getZom().getBounds().x+50)<=l.getCleaner().getBounds().x){
						GameView.frame.remove(z.getZom());
						iter2.remove();
						GameView.frame.repaint();
						z.endEat();
					}
				}
				//遍历植物，判断每个植物和推车的坐标是否一致，若一致，清除植物
				Iterator<Plant> iter3 = GameController.allPlant.iterator();
				while(iter3.hasNext()) {
					Plant p = iter3.next();
					//判断位置
					if ((p.getY()==l.getY()&&p.getPlant().getBounds().x<=(l.getCleaner().getBounds().x+55))&&
							p.getPlant().getBounds().x>=(l.getCleaner().getBounds().x)) {
						GameView.hasPlant[p.getX()-1][p.getY()-1]=false;
						GameView.frame.remove(p.getPlant());
						for(JLabel pb:p.getProducts()) {
							GameView.frame.remove(pb);
						}
						iter3.remove();
						GameView.frame.repaint();
					}
				}
			}
		}	
	}
}
