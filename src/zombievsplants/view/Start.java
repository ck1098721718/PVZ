package zombievsplants.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
//鼠标进出按钮，切换图片
public class Start implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根
		GameView.frame.remove(GameView.begin);
		GameView.begin.setIcon(new ImageIcon("src/zombievsplants/photos/maoxian2.gif"));
		GameView.frame.add(GameView.begin);
		GameView.begin.setBounds(515, 100, 330,143);
		GameView.frame.repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		GameView.frame.remove(GameView.begin);
		GameView.begin.setIcon(new ImageIcon("src/zombievsplants/photos/maoxian1.gif"));
		GameView.frame.add(GameView.begin);
		GameView.begin.setBounds(515, 100, 330, 143);
		GameView.frame.repaint();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO 自动生成的方法存根

	}

}
