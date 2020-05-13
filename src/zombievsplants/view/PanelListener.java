package zombievsplants.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import zombievsplants.controller.AddPlant;
import zombievsplants.controller.GameController;

//监视整个窗口的鼠标监听器
public class PanelListener implements MouseListener,MouseMotionListener {
	


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		int x =(e.getPoint().x+29)/85;
		int y =(e.getPoint().y-5)/100;
		if(e.getButton()==MouseEvent.BUTTON1) {
			if(x<=9&&y<=5&&x>=1&&y>=1) {
				//已点击卡片，处于安放植物的状态，且点击处没有安放植物
				if (GameController.plant!=null&&GameView.hasPlant[x-1][y-1]==false) {
					AddPlant.addPlant(GameController.plant, x, y);
					//植物放置成功，减少阳光
					GameController.sunNum -= GameController.plant.getPrice();
					
					//原卡片变成不可点击状态
					GameController.card.setClick(false);
					GameController.card.setCurrentTime(GameController.plant.getCoolTime());
					GameController.plant = null;
					GameView.frame.remove(GameController.plantImage);
					GameView.frame.repaint();
				}
			}
		}		
		
		//右键添加僵尸
		if(e.getButton()==MouseEvent.BUTTON3&&GameController.plant!=null) {
//			System.out.println("右键，位置为"+x+" "+y);
//			AddZombie.addZombie(y,Level.theLevel);
			GameController.plant = null;
			GameView.frame.remove(GameController.plantImage);
			GameView.frame.repaint();
		}
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根

	}


	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}


	@Override
	//让植物的图片随鼠标的移动而移动
	public void mouseMoved(MouseEvent e) {
		// TODO 自动生成的方法存根
		if (GameController.plant!=null) {
			int ex=e.getPoint().x;
			int ey=e.getPoint().y;
			GameController.plantImage.setBounds(ex-40, ey-50, GameController.plant.getPlantImage().getIconWidth(), GameController.plant.getPlantImage().getIconHeight());
			GameView.frame.repaint();
		}
	}

}
