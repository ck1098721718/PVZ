package zombievsplants.model;


import javax.swing.ImageIcon;
//普通僵尸
public class Common extends Zombie {
	public Common (int y)  {
		this.setY(y);
		this.setIconX(820);
		this.setIconY(-55+100*y);
		this.setHp(10);
		this.setWalk(new ImageIcon("src/zombievsplants/photos/Zombie.gif"));
		this.setAttack(new ImageIcon("src/zombievsplants/photos/ZombieAttack.gif"));
		this.setDie(new ImageIcon("‪src/zombievsplants/photos/ZombieLostHead.gif"));
		this.getZom().setIcon(this.getWalk());
		this.setDamage(1);
	}

}
