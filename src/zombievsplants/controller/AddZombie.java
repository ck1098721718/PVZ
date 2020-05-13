package zombievsplants.controller;

import java.util.Random;

import zombievsplants.model.BucketheadZombie;
import zombievsplants.model.Common;
import zombievsplants.model.ConeheadZombie;
import zombievsplants.model.Zombie;
import zombievsplants.view.GameView;

public class AddZombie {	
	/**
	 * @param y			y为僵尸所在的行，决定生成的僵尸的位置
	 * @param level		level为当前关卡，函数根据level生成随机数，决定僵尸的种类
	 */
	public static void addZombie(int y,int level) {		
		//增加僵尸,根据随机数得到的数字生成不同的僵尸
		synchronized (GameController.allzom) {
			Random rand = new Random();
			Zombie z = null;
			int temp = rand.nextInt(level);
			switch (temp) {
				case 0:z = new Common(y);
					break;
				case 1:z = new ConeheadZombie(y);
					break;
				case 2:z = new BucketheadZombie(y);
					break;
				default:
			}
			GameView.frame.add(z.getZom());
			GameController.allzom.add(z);
			z.getZom().setBounds(z.getIconX(), z.getIconY(), z.getZom().getIcon().getIconWidth(), z.getZom().getIcon().getIconHeight());
		}
		
	}
}
