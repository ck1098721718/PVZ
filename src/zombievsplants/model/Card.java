package zombievsplants.model;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;

import zombievsplants.controller.GameController;
import zombievsplants.view.GameView;

public class Card {
	public static Map<JButton,Card> map= new HashMap<JButton,Card>();	//用于通过点击按钮获得卡片的信息
	private Plant thePlant;				//卡片所代表的植物
	private boolean isClick = true;		//卡片是否冷却完毕
	private int currentTime =0;			//卡片剩余的冷却时间
	private JButton card;				//卡片在窗口上以按钮的形式显示
		
	//getter和setter
	public Plant getThePlant() {
		return thePlant;
	}
	public void setThePlant(Plant thePlant) {
		this.thePlant = thePlant;
	}
	public boolean isClick() {
		return isClick;
	}
	public void setClick(boolean isClick) {
		this.isClick = isClick;
	}
	public int getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(int currentTime) {
		this.currentTime = currentTime;
	}	
	public JButton getCard() {
		return card;
	}
	public void setCard(JButton card) {
		this.card = card;
	}
	//构造函数
	public Card(Plant thePlant) {
		this.thePlant = thePlant;
		if (thePlant.getPrice()>GameController.sunNum) {
			this.setCard(new JButton (thePlant.getCard1()));
		}
		else {
			this.setCard(new JButton (thePlant.getCard2()));
		}
		//下面四行代码用于去除图片按钮的边框
		card.setOpaque(false);
    	card.setBorderPainted(false);
    	card.setContentAreaFilled(false);
    	card.setBorder(null);
    	
		GameView.frame.add(card);
		card.setBounds(thePlant.getCx(),12, 60, 80);
		GameController.allcard.add(this);
		card.addActionListener(GameController.cardc);
		map.put(card, this);
	}

}
