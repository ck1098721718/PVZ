package zombievsplants.model;

import java.awt.Image;

import javax.swing.ImageIcon;
//太阳花
public class SunFlower extends Plant {
	
	public SunFlower(){
		
		this.setHp(150);
		this.setIntervalTime(800);
		this.setDamage(0);
		this.setPrice(50);
		this.setCx(135);
		this.setCoolTime(400);
		
		this.getPlant().setIcon(new ImageIcon("src/zombievsplants/photos/SunFlower1.gif"));
		this.setProduct(new ImageIcon("src/zombievsplants/photos/Sun.gif"));
		this.setPlantImage(new ImageIcon("src/zombievsplants/photos/SunFlower1.gif"));
		ImageIcon img1 = new ImageIcon("src/zombievsplants/photos/sfc1.png");
		img1.setImage(img1.getImage().getScaledInstance(60,80,Image.SCALE_DEFAULT));
		this.setCard1(img1);
		ImageIcon img2 = new ImageIcon("src/zombievsplants/photos/sfc2.png");
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
