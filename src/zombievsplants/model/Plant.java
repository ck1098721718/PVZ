package zombievsplants.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//植物抽象类
public abstract class Plant implements Cloneable{
	private int hp; //植物的生命值
	private int damage; //植物的伤害值
	private int intervalTime; //植物生成产物的间隔时间
	private int i = 0;	//每循环一次加一，间隔标志
	private int price; //植物的价格
	private int coolTime; //植物的冷却时间
	private int x;	//植物的位置坐标
	private int y;
	private	int iconX;	//图片的初始位置
	private int iconY;
	private int cx;	//卡片的位置
	private boolean isGenerated = false;			//判断是否生成产物
	private ImageIcon product = new ImageIcon();	//产物的图片
	private ImageIcon card1 = new ImageIcon();		//卡片不可点击时的图片
	private ImageIcon card2 = new ImageIcon();		//卡片可点击时的图片
	private ImageIcon plantImage = new ImageIcon();	//植物的图片
	private JLabel plant = new JLabel();			//植物在界面上的显示
	private List<JLabel> products = new ArrayList<JLabel>();	//植物产物的图片
	
	public abstract void SetXY(int x,int y);	//设置坐标
	
	
	public int getCx() {
		return cx;
	}
	public void setCx(int cx) {
		this.cx = cx;
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
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public boolean isGenerated() {
		return isGenerated;
	}
	public void setGenerated(boolean isGenerated) {
		this.isGenerated = isGenerated;
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
	public int getIntervalTime() {
		return intervalTime;
	}
	public void setIntervalTime(int intervalTime) {
		this.intervalTime = intervalTime;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCoolTime() {
		return coolTime;
	}
	public void setCoolTime(int coolTime) {
		this.coolTime = coolTime;
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
	public JLabel getPlant() {
		return plant;
	}
	public void setPlant(JLabel plant) {
		this.plant = plant;
	}
	public List<JLabel> getProducts() {
		return products;
	}
	public void setProducts(List<JLabel> products) {
		this.products = products;
	}
	public ImageIcon getProduct() {
		return product;
	}
	public void setProduct(ImageIcon product) {
		this.product = product;
	}
	public ImageIcon getCard1() {
		return card1;
	}
	public void setCard1(ImageIcon card1) {
		this.card1 = card1;
	}
	public ImageIcon getCard2() {
		return card2;
	}
	public void setCard2(ImageIcon card2) {
		this.card2 = card2;
	}
	public ImageIcon getPlantImage() {
		return plantImage;
	}
	public void setPlantImage(ImageIcon plantImage) {
		this.plantImage = plantImage;
	}
	
}
