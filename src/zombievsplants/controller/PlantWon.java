package zombievsplants.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import zombievsplants.model.Card;
import zombievsplants.model.LawnCleaner;
import zombievsplants.model.Plant;
import zombievsplants.model.Zombie;
import zombievsplants.view.GameView;
//植物（玩家）胜利时的界面
public class PlantWon {
	public static void plantwon() {
		GameController.music.win();
		GameController.run--;
		GameView.pwstart = new JButton(new ImageIcon("src/zombievsplants/photos/下一关.gif"));
		GameView.pwstart.setBorder(null);
		GameView.frame.add(GameView.pwstart);
		GameView.pwstart.setBounds(350, 420, GameView.pwstart.getIcon().getIconWidth(),GameView.pwstart.getIcon().getIconHeight());		
		
		GameView.pwmenu = new JLabel(new ImageIcon("src/zombievsplants/photos/游戏胜利.gif"));
		GameView.frame.add(GameView.pwmenu);
		GameView.pwmenu.setBounds(300, 250, GameView.pwmenu.getIcon().getIconWidth(),GameView.pwmenu.getIcon().getIconHeight());
		//把所有的植物和僵尸先remove再add，防止植物和僵尸遮挡住图片
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
		for(Card c :GameController.allcard) {
			GameView.frame.remove(c.getCard());
			GameView.frame.add(c.getCard());
		}
		for(LawnCleaner c:GameController.allcleaner) {
			GameView.frame.remove(c.getCleaner());
			GameView.frame.add(c.getCleaner());
		}
		//加入按钮响应
		GameView.pwstart.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Level.theLevel++;
				System.out.println("666");
				GameView.frame.remove(GameView.menuButton);
				GameView.frame.remove(GameView.pwmenu);
				GameView.frame.remove(GameView.pwstart);
				Remove.remove();
				GameView.frame.repaint();
				Initialize.initialize();
			}
			
		});		
	}
}
