package zombievsplants.model;

import java.awt.Image;

import javax.swing.ImageIcon;
//樱桃炸弹
public class CherryBomb extends Plant {

	public CherryBomb() {
		this.setHp(400);
		this.setIntervalTime(Integer.MAX_VALUE);
		this.setPrice(150);
		this.setCx(330);
		this.setCoolTime(1000);
		
		this.setPlantImage(new ImageIcon("src/zombievsplants/photos/CherryBomb0.gif"));
		this.getPlant().setIcon(this.getPlantImage());		
		ImageIcon img1 = new ImageIcon("src/zombievsplants/photos/cbc1.png");
		img1.setImage(img1.getImage().getScaledInstance(60,80,Image.SCALE_DEFAULT));
		this.setCard1(img1);
		ImageIcon img2 = new ImageIcon("src/zombievsplants/photos/cbc2.png");
		img2.setImage(img2.getImage().getScaledInstance(60,80,Image.SCALE_DEFAULT));
		this.setCard2(img2);
	}
	public void SetXY(int x,int y) {
		this.setX(x);
		this.setY(y);	
		this.setIconX(-44+85*x);
		this.setIconY(5+100*y);	
		this.getPlant().setIcon(new ImageIcon("src/zombievsplants/photos/CherryBomb.gif"));
	}

}
