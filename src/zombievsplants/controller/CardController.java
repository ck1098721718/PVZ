package zombievsplants.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import zombievsplants.model.Card;
import zombievsplants.view.GameView;
//卡片的按钮响应
public class CardController implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		//只有当卡片可点击时，单机卡片按钮才有反应
		if (Card.map.get(e.getSource()).isClick()) {
			//如果卡片已被点击，回到未点击状态
			if (GameController.plant!=null) {
				GameController.plant = null;
				GameView.frame.remove(GameController.plantImage);
				GameView.frame.repaint();
			}
			//如果卡片未被点击，进入安放植物的状态
			else{
				GameController.card = Card.map.get(e.getSource());
				GameController.plant = Card.map.get(e.getSource()).getThePlant();
				GameController.plantImage = new JLabel (GameController.plant.getPlantImage());
				GameView.frame.add(GameController.plantImage);
			}
			
		}
	}

}
