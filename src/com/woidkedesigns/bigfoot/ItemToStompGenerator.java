package com.woidkedesigns.bigfoot;

import java.awt.Image;

import com.woidkedesigns.bigfoot.items.Grape;
import com.woidkedesigns.bigfoot.items.Tack;

public class ItemToStompGenerator {

	private static Image grapeImage, tackImage, currentImage;
	
	public ItemToStompGenerator() {
	}
	
	public static ItemToStomp generateItem() {
		int type = (int) (Math.random() * 2);
		System.out.println("--------");
		System.out.println("Random: " + type);
		
		switch(type) {

			case 0:
				System.out.println("GRAPE!");
				currentImage = grapeImage;
				return new Grape();
			
			case 1:
				System.out.println("TACK!!!!");
				currentImage = tackImage;
				return new Tack();
				
			default:
				return new Grape();
		
		}

	}

	public static Image getCurrentImage() {
		return currentImage;
	}

	public static void setGrapeImage(Image grapeImage) {
		ItemToStompGenerator.grapeImage = grapeImage;
	}

	public static void setTackImage(Image tackImage) {
		ItemToStompGenerator.tackImage = tackImage;
	}

}
