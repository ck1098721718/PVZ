package zombievsplants.model;

import java.awt.Image;

import javax.swing.ImageIcon;
//豌豆射手
public class Peashooter extends Plant{	
	
	public Peashooter() {
		this.setHp(300);
		this.setIntervalTime(107);
		this.setDamage(1);
		this.setPrice(100);
		this.setCx(200);
		this.setCoolTime(500);
		
		this.getPlant().setIcon(new ImageIcon("src/zombievsplants/photos/Peashooter.gif"));
		this.setProduct(new ImageIcon("src/zombievsplants/photos/PB00.gif"));
		this.setPlantImage(new ImageIcon("src/zombievsplants/photos/Peashooter.gif"));
		ImageIcon img1 = new ImageIcon("src/zombievsplants/photos/psc1.png");
		img1.setImage(img1.getImage().getScaledInstance(60,80,Image.SCALE_DEFAULT));
		this.setCard1(img1);
		ImageIcon img2 = new ImageIcon("src/zombievsplants/photos/psc2.png");
		img2.setImage(img2.getImage().getScaledInstance(60,80,Image.SCALE_DEFAULT));
		this.setCard2(img2);
	}
	public void SetXY(int x,int y) {
		this.setX(x);
		this.setY(y);	
		this.setIconX(-29+85*x);
		this.setIconY(5+100*y);	
	}

}
