package zombievsplants.model;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
//僵尸抽象类
public abstract class Zombie {
	private String name;    //僵尸的类型名字
	private int hp;  //僵尸现在的生命值
	private int damage;       //僵尸对植物的伤害大小
	private Integer speed;   //僵尸移动的速度
    private int x=845;;    //僵尸的位置
	private int y;
	private int iconX;	//图片的初始位置
	private int iconY;
	private ImageIcon walk;	//僵尸一般时候的图片
	private ImageIcon attack;
	private ImageIcon die;
	private JLabel zom = new JLabel();
	private AudioClip eat;
	private boolean iswalk = true;

	
	public void stopWalk() {
		iswalk = false;
	}
	
	public void startWalk() {
		iswalk = true;
	}
	
	public int getIconX() {
		return iconX;
	}

	public void setIconX(int iconX) {
		this.iconX = iconX;
	}

	public int getIconY() {
		return iconY;
	}

	public void setIconY(int iconY) {
		this.iconY = iconY;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ImageIcon getWalk() {
		return walk;
	}

	public void setWalk(ImageIcon walk) {
		this.walk = walk;
	}

	public ImageIcon getAttack() {
		return attack;
	}

	public void setAttack(ImageIcon attack) {
		this.attack = attack;
	}

	public ImageIcon getDie() {
		return die;
	}

	public void setDie(ImageIcon die) {
		this.die = die;
	}

	public JLabel getZom() {
		return zom;
	}

	public void setZom(JLabel zom) {
		this.zom = zom;
	}
	
	public void startEat() {
		  File f;
		  URI uri;
		  URL url = null;
		  f = new File("src/zombievsplants/music/chompsoft.wav"); 
	      uri = f.toURI();
	      try {
			url = uri.toURL();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  //解析地址
	      eat = Applet.newAudioClip(url);
	      
		this.eat.loop();
	}
	
	public void endEat() {
		if(!iswalk) {
			this.eat.stop();
		}
	}

	public boolean isIswalk() {
		return iswalk;
	}
	
	

}
