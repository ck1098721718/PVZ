package zombievsplants.model;

import java.awt.Image;

import javax.swing.ImageIcon;
//坚果
public class WallNut extends Plant{
	public WallNut() {
		this.setHp(3000);
		this.setIntervalTime(Integer.MAX_VALUE);
		this.setPrice(50);
		this.setCx(265);
		this.setCoolTime(800);
		
		this.setPlantImage(new ImageIcon("src/zombievsplants/photos/WallNut.gif"));
		this.getPlant().setIcon(this.getPlantImage());		
		ImageIcon img1 = new ImageIcon("src/zombievsplants/photos/wnc1.png");
		img1.setImage(img1.getImage().getScaledInstance(60,80,Image.SCALE_DEFAULT));
		this.setCard1(img1);
		ImageIcon img2 = new ImageIcon("src/zombievsplants/photos/wnc2.png");
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
