package zombievsplants.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import zombievsplants.controller.GameController;
//点击阳光时的响应
public class SunClick implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		GameView.frame.remove((JButton)e.getSource());
		e.setSource(null);
		GameController.sunNum +=25;
		GameView.frame.remove(GameView.sun);		    		
		GameView.sun.setText(String.valueOf(GameController.sunNum));
		GameView.frame.add(GameView.sun);
		GameView.frame.repaint();
	}

}
