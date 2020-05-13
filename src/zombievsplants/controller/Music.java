package zombievsplants.controller;

import java.io.File;
import java.applet.AudioClip; 
import java.applet.Applet;
import java.net.URI;
import java.net.URL;

//播放音乐
public class Music {

    private AudioClip aau1,aau2,aau3,sun,button,plant1,win,lose,cherryBomb,pause;
	Music(){  
		  try {
			  File f;
			  URI uri;
			  URL url;
			  f = new File("src/zombievsplants/music/Laura Shigihara - Crazy Dave IN-GAME.wav"); 
		      uri = f.toURI();
		      url = uri.toURL();  //解析地址
		      aau1 = Applet.newAudioClip(url);
		      f = new File("src/zombievsplants/music/Laura Shigihara - Ultimate Battle.wav"); 
		      uri = f.toURI();
		      url = uri.toURL();  //解析地址
		      aau2 = Applet.newAudioClip(url);
		      f = new File("src/zombievsplants/music/bleep.wav"); 
		      uri = f.toURI();
		      url = uri.toURL();  //解析地址
		      aau3 = Applet.newAudioClip(url);
		      f = new File("src/zombievsplants/music/sun.wav"); 
		      uri = f.toURI();
		      url = uri.toURL();  //解析地址
		      sun = Applet.newAudioClip(url);
		      f = new File("src/zombievsplants/music/button.wav"); 
		      uri = f.toURI();
		      url = uri.toURL();  //解析地址
		      button = Applet.newAudioClip(url);
		      f = new File("src/zombievsplants/music/plant1.wav"); 
		      uri = f.toURI();
		      url = uri.toURL();  //解析地址
		      plant1 = Applet.newAudioClip(url);
		      f = new File("src/zombievsplants/music/win.wav"); 
		      uri = f.toURI();
		      url = uri.toURL();  //解析地址
		      win = Applet.newAudioClip(url);
		      f = new File("src/zombievsplants/music/lose.wav"); 
		      uri = f.toURI();
		      url = uri.toURL();  //解析地址
		      lose = Applet.newAudioClip(url);
		      f = new File("src/zombievsplants/music/cherrybomb.wav"); 
		      uri = f.toURI();
		      url = uri.toURL();  //解析地址
		      cherryBomb = Applet.newAudioClip(url);
		      f = new File("src/zombievsplants/music/pause.wav"); 
		      uri = f.toURI();
		      url = uri.toURL();  //解析地址
		      pause = Applet.newAudioClip(url);

		  } catch (Exception e) { 
			  e.printStackTrace();
		  } 
	}
	
	public void lose() {
		lose.play();
	}
	
	public void playBack() {
		aau1.loop();
	}
	
	public void endBack() {
		aau1.stop();
	}
	
	public void play() {
		aau2.loop();
	}
	
	public void end() {
		aau2.stop();
	}
	
	public void bleep() {
		aau3.play();
	}
	
	public void sunAct() {
		sun.play();
	}
	
	public void buttonAct() {
		button.play();
	}
	
	public void plantProduce() {
		plant1.play();
	}
	
	public void win() {
		win.play();
	}
	
	public void cherryBomb() {
		cherryBomb.play();
	}
	
	public void pause() {
		pause.play();
	}
}
