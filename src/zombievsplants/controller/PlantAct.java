package zombievsplants.controller;


import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import zombievsplants.model.CherryBomb;
import zombievsplants.model.Plant;
import zombievsplants.model.SunFlower;
import zombievsplants.model.Zombie;
import zombievsplants.view.GameView;
import zombievsplants.view.SunClick;
//每轮循环植物的行为
public class PlantAct {
	public static void shoot() {
		//遍历所有的植物
		synchronized (GameController.allPlant) {
			Iterator <Plant> iter = GameController.allPlant.iterator(); 
			while(iter.hasNext()) {
				Plant p = iter.next();
				//循环次数最大不能为int的最大值，否则坚果等会产生产物导致错误
				if(p.getI()== Integer.MAX_VALUE-1) {
					p.setI(0);
				}
				else p.setI(p.getI()+1);
				//植物死亡时清除内存
				if(p.getHp()<=0) {
					GameView.hasPlant[p.getX()-1][p.getY()-1]=false;
					GameView.frame.remove(p.getPlant());
					//清除植物的产物
					for(JLabel pb:p.getProducts()) {
						GameView.frame.remove(pb);
					}
					iter.remove();
					GameView.frame.repaint();
				}
				//若植物为樱桃炸弹
				if(p instanceof CherryBomb) {
					//0~19为樱桃炸弹膨胀变大的过程
					//i=20时开始放爆炸的声音，并更换图片为“砰”的烟雾
					if(p.getI()==20) {
						GameController.music.cherryBomb();
						p.getPlant().setIcon(new ImageIcon("src/zombievsplants/photos/Boom.gif"));
						p.getPlant().setBounds(p.getPlant().getBounds().x-50, p.getPlant().getBounds().y-50
								, p.getPlant().getIcon().getIconWidth(), p.getPlant().getIcon().getIconHeight());
					}
					//i=25时清除樱桃炸弹附近的僵尸
					if(p.getI()==25) {
						for(Zombie z:GameController.allzom) {
							int temp = (z.getZom().getBounds().x+80+29)/85;
							if(Math.abs(z.getY()-p.getY())<=1&&Math.abs(temp-p.getX())<=1) {
								z.setHp(z.getHp()-30);
							}
						}
					}
					//i=40时移除樱桃炸弹的痕迹
					if(p.getI()==40) {
						GameView.frame.remove(p.getPlant());
						GameView.hasPlant[p.getX()-1][p.getY()-1]=false;
						iter.remove();			
						GameView.frame.repaint();
					}
					
					
				}
				//判断是否生成产物
				p.setGenerated(false);
				//太阳花生成产物不需要僵尸存在
				if(p instanceof SunFlower) {
					if (p.getI()%p.getIntervalTime()==0) {
						p.setGenerated(true);
					}
				}
				//豌豆射手生成产物需要冷却时间到达且有僵尸的存在
				else {
					for (Zombie z:GameController.allzom) {
						if(z.getY()==p.getY()&&(z.getZom().getBounds().x-p.getPlant().getBounds().x)>=-80&&p.getI()%p.getIntervalTime()==0) {
							p.setGenerated(true);
							break;
						}			
					}
				}	
				//如果生成产物
				if (p.isGenerated()) {
					//太阳光的产物需要点击，设置为按钮，其他为标签
	    			if(p instanceof SunFlower) {
	    				GameController.music.sunAct();            //太阳花生产阳光的音效
	    				JButton pb = new JButton(p.getProduct());
	    				pb.setOpaque(false);
	    		    	pb.setBorderPainted(false);
	    		    	pb.setContentAreaFilled(false);
	    		    	pb.setBorder(null);
	    				GameView.frame.remove(p.getPlant());
		    			GameView.frame.add(pb);
		    			GameView.frame.add(p.getPlant());
		    			GameController.allsun.add(pb);
		    			pb.addActionListener(new SunClick());
		    			pb.setBounds(p.getIconX()+30, p.getIconY(), p.getProduct().getIconWidth(),p.getProduct().getIconHeight());
	    			}
	    			else{				
	    				JLabel pb = new JLabel(p.getProduct());
	    				p.getProducts().add(pb);
	    				GameView.frame.add(pb);
	    				pb.setBounds(p.getIconX()+30, p.getIconY(), p.getProduct().getIconWidth(),p.getProduct().getIconHeight());
	    			}
	    			
	    			GameView.frame.repaint();
	    		}
				if (p.getProducts().size()>0) {
					//设置所有豌豆的坐标
					if (p.getProducts().size()!=0&&!(p instanceof SunFlower)) {
						for(JLabel pb:p.getProducts()) {
							pb.setBounds(pb.getBounds().x+4, 5+100*p.getY(), p.getProduct().getIconWidth(), p.getProduct().getIconHeight());
						}
					}
		    		//打到僵尸
		    		if (p.getProducts().size()!=0&&!(p instanceof SunFlower)) {
		    			for (Zombie z:GameController.allzom) {
		    				if (z.getY()==p.getY()) {
		    					if ((p.getProducts().get(0).getBounds().x-z.getZom().getBounds().x)>=40&&(p.getProducts().get(0).getBounds().x-z.getZom().getBounds().x)<=100) {
		    						GameView.frame.remove(p.getProducts().get(0));
		    						p.getProducts().remove(0);
		    						z.setHp(z.getHp()-p.getDamage());
		    						GameController.music.bleep();  //豌豆的打击音效
		    						break;
		    					}
		    					
		    				}
		    			}
		    			
		    		}
		    		if (p.getProducts().size()!=0) {
		    			//打到窗口外面
		        		if(p.getProducts().get(0).getBounds().x>=GameView.WIDTH) {
		        			GameView.frame.remove(p.getProducts().get(0));
		        			p.getProducts().remove(0);
		        		}
		    		}
				}
			}
		}
		
	}
}
