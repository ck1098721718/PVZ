package zombievsplants.model;

import javax.swing.ImageIcon;
//路障僵尸
public class ConeheadZombie extends Zombie{
	public ConeheadZombie (int y) {
		this.setY(y);
		this.setIconX(820);
		this.setIconY(-55+100*y);
		this.setHp(30);
		this.setWalk(new ImageIcon("src/zombievsplants/photos/ConeheadZombie.gif"));
		this.setAttack(new ImageIcon("src/zombievsplants/photos/ConeheadZombieAttack.gif"));
		this.setDie(new ImageIcon("‪src/zombievsplants/photos/ZombieLostHead.gif"));
		this.getZom().setIcon(this.getWalk());
		this.setDamage(1);
	}
}
