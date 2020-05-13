package zombievsplants.model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import zombievsplants.view.GameView;

public class LawnCleaner {
	private int y;
	private	int iconX;	//图片的初始位置
	private int iconY;
	private boolean run = false;
	private ImageIcon CleanerImage = new ImageIcon();	//推车的图片
	private JLabel Cleaner = new JLabel();			//推车在界面上的显示
	
	public LawnCleaner (int y) {
		this.y = y;
		this.iconX = -30;
		this.iconY = 15+100*y;
		this.setCleanerImage(new ImageIcon("src/zombievsplants/photos/LawnCleaner.gif"));
		this.Cleaner.setIcon(CleanerImage);
		GameView.frame.add(Cleaner);
		this.Cleaner.setBounds(iconX, iconY, CleanerImage.getIconWidth(), CleanerImage.getIconHeight());
	}
	
	public boolean isRun() {
		return run;
	}

	public void setRun(boolean run) {
		this.run = run;
	}

	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
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
	public ImageIcon getCleanerImage() {
		return CleanerImage;
	}
	public void setCleanerImage(ImageIcon cleanerImage) {
		CleanerImage = cleanerImage;
	}
	public JLabel getCleaner() {
		return Cleaner;
	}
	public void setCleaner(JLabel cleaner) {
		Cleaner = cleaner;
	}
	
}
