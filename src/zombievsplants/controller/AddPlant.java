package zombievsplants.controller;

import zombievsplants.model.Plant;
import zombievsplants.view.GameView;

public class AddPlant {
	
	/**
	 * @param plant 要生成的植物的类型，由点击卡片时给GameController.plant确定
	 * @param x	坐标
	 * @param y	坐标
	 */
	public static void addPlant(Plant plant,int x,int y) {
		synchronized (GameController.allPlant) {
			GameController.music.plantProduce();
			Plant p = null;
			try {
				p = plant.getClass().newInstance();
			} catch (InstantiationException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			p.SetXY(x, y);
			GameView.frame.add(p.getPlant());
			GameController.allPlant.add(p);
			p.getPlant().setBounds(p.getIconX(), p.getIconY(), p.getPlant().getIcon().getIconWidth(), p.getPlant().getIcon().getIconHeight());
			GameView.hasPlant[x-1][y-1]=true;
		}
		
	}
}
