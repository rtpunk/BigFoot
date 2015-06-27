package com.woidkedesigns.bigfoot;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

public class BigFoot  extends Applet implements Runnable, KeyListener{

	private static final long serialVersionUID = 1L;
	public static final int stageWidth = 320;
	public static final int stageHeight = 470;
	
	private Image image, background, footRaised, grape, tack;
	
	private URL baseURL;
	private Graphics secondBuffer;
	
	private Foot foot;
	
	private ItemToStomp itemToStomp;
	
	private boolean isKeyPressedDown = false;
	private boolean isKeyPressedUp = false;

	public BigFoot() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void start() {
		foot = new Foot();
		getNewItem();
		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void init() {
		setSize(stageWidth, stageHeight);
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);
		Frame frame = (Frame)this.getParent().getParent();
		frame.setTitle("BigFoot");
		
		// Initialize images
		try {
			baseURL = getDocumentBase();
		} catch (Exception e) {
			//TODO: handle exception
		}
		
		background = getImage(baseURL, "data/background.png");
		footRaised = getImage(baseURL, "data/foot_raised.png");
		grape = getImage(baseURL, "data/grape.png");
		tack = getImage(baseURL, "data/tack.png");
		
		ItemToStompGenerator.setTackImage(tack);
		ItemToStompGenerator.setGrapeImage(grape);
	}

	@Override
	public void run() {
		while(true) {
			foot.update();
			
			repaint();
			
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void update(Graphics g) {
		if (image == null) {
			image = createImage(this.getWidth(), this.getHeight());
			secondBuffer = image.getGraphics();
		}
		
		secondBuffer.setColor(getBackground());
		secondBuffer.fillRect(0, 0, getWidth(), getHeight());
		secondBuffer.setColor(getForeground());
		paint(secondBuffer);
		
		g.drawImage(image, 0, 0, this);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, this);
		g.drawImage(ItemToStompGenerator.getCurrentImage(), itemToStomp.getX(), itemToStomp.getY(), this);
		g.drawImage(footRaised, foot.getX(), foot.getY(), this);
	}
	
	private void getNewItem() {
		itemToStomp = ItemToStompGenerator.generateItem();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:
				if(isKeyPressedUp) return;
				if(itemToStomp.getIsSquishable())
					System.out.println("OOPS!");
				else
					System.out.println("WHEW!");
				foot.setState(Foot.noState);
				isKeyPressedUp = true;
			break;
			
			case KeyEvent.VK_DOWN:
				if(isKeyPressedDown) return;
				if(itemToStomp.getIsSquishable())
					System.out.println("SQUISH!");
				else
					System.out.println("OUCH!!!!! *%#&@*!");
				foot.setState(Foot.downState);
				isKeyPressedDown = true;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:
				foot.setState(Foot.upState);
				isKeyPressedUp = false;
				getNewItem();
			break;
			
			case KeyEvent.VK_DOWN:
				foot.setState(Foot.upState);
				isKeyPressedDown = false;
				getNewItem();
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
