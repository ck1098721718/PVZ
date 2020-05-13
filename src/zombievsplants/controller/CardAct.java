package zombievsplants.controller;


import zombievsplants.model.Card;
//卡片每一轮循环的变化
public class CardAct {
	public static void update() {
		for (Card c: GameController.allcard) {
			//卡片未冷却完毕时，将冷却时间减一
			if(c.getCurrentTime()!=0) {
				c.setCurrentTime(c.getCurrentTime()-1);
			}
			//设置卡片是否可点击
			if (c.getThePlant().getPrice()>GameController.sunNum||c.getCurrentTime()>0) { 
				c.getCard().setIcon(c.getThePlant().getCard1());
				c.setClick(false);
			}
			else {
				c.getCard().setIcon(c.getThePlant().getCard2());
				c.setClick(true);
			}
		}
	}
}
