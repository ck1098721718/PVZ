package zombievsplants.controller;

import java.awt.Image;
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
//僵尸胜利，玩家失败时的游戏界面
public class ZombieWon {
	public static void zombiewon() {
		GameController.music.lose();
		GameController.run--;
		GameView.zwrestart = new JButton(new ImageIcon("src/zombievsplants/photos/tryAgain.gif"));
		GameView.zwrestart.setBorder(null);
		GameView.frame.add(GameView.zwrestart);
		GameView.zwrestart.setBounds(350, 420, GameView.zwrestart.getIcon().getIconWidth(),GameView.zwrestart.getIcon().getIconHeight());
		
		
		GameView.zwmenu = new JLabel(new ImageIcon("src/zombievsplants/photos/gameOver.gif"));
		GameView.frame.add(GameView.zwmenu);
		GameView.zwmenu.setBounds(300, 250, GameView.zwmenu.getIcon().getIconWidth(),GameView.zwmenu.getIcon().getIconHeight());
		
		ImageIcon img = new ImageIcon("src/zombievsplants/photos/ZombiesWon.gif");//背景图片
    	img.setImage(img.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT));
		GameView.zombiewon = new JLabel(img);
		GameView.frame.add(GameView.zombiewon);
		GameView.zombiewon.setBounds(150, 100, GameView.zombiewon.getIcon().getIconWidth(), GameView.zombiewon.getIcon().getIconHeight());
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
		GameView.zwrestart.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Remove.remove();
				GameView.frame.remove(GameView.menuButton);
				GameView.frame.remove(GameView.zombiewon);
				GameView.frame.remove(GameView.zwmenu);
				GameView.frame.remove(GameView.zwrestart);
				GameView.frame.repaint();
				Initialize.initialize();
			}
			
		});
	}

}
