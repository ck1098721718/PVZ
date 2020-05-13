package zombievsplants.model;

import javax.swing.ImageIcon;
//铁通僵尸
public class BucketheadZombie extends Zombie {
	public BucketheadZombie (int y) {
		this.setY(y);
		this.setIconX(820);
		this.setIconY(-55+100*y);
		this.setHp(20);
		this.setWalk(new ImageIcon("src/zombievsplants/photos/BucketheadZombie.gif"));
		this.setAttack(new ImageIcon("src/zombievsplants/photos/BucketheadZombieAttack.gif"));
		this.setDie(new ImageIcon("‪src/zombievsplants/photos/ZombieLostHead.gif"));
		this.getZom().setIcon(this.getWalk());
		this.setDamage(1);
	}

}
