package zombievsplants.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import zombievsplants.view.GameView;
import zombievsplants.view.SunClick;

public class SunAct {
	static ImageIcon img = new ImageIcon("src/zombievsplants/photos/Sun.gif");
	static List<JButton> allskysun= new ArrayList<JButton>(); 
	//用于从天上每隔一段时间掉下阳光
	public static void AddSunFromSky() {
		if (GameController.i%400==0) {
			//生成阳光
			JButton sun = new JButton (img);
			sun.setOpaque(false);
	    	sun.setBorderPainted(false);
	    	sun.setContentAreaFilled(false);
	    	sun.setBorder(null);
	    	GameView.frame.add(sun);
	    	//阳光的位置
			Random rand = new Random();
	    	sun.setBounds(rand.nextInt(800), 100, img.getIconWidth(), img.getIconHeight());
	    	sun.addActionListener(new SunClick());
	    	allskysun.add(sun);
	    	GameController.allsun.remove(sun);
		}
		Iterator <JButton> iter = allskysun.iterator();
		while(iter.hasNext()) {
			JButton j = iter.next();
			//阳光被点击时，清除
			if  (j==null) {
				iter.remove();
			}
			//阳光到达底部时，不再下坠
			else if(j.getBounds().y<=580){
				j.setBounds(j.getBounds().x, j.getBounds().y+1, img.getIconWidth(), img.getIconHeight());
			}
			GameView.frame.repaint();
		}
	}

}
