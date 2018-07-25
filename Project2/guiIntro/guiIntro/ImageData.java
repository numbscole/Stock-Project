package guiIntro;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class ImageData {
		private ArrayList<ImageIcon> myImages;
		private ArrayList<String> names;
		private Random rand;
	   
		public ImageData () {
			rand = new Random();
			myImages = new ArrayList<ImageIcon>();
			myImages.add(new ImageIcon (this.getClass().getResource("/guiIntro/sun.gif")));
			myImages.add(new ImageIcon (this.getClass().getResource("/guiIntro/Bird.gif")));
			myImages.add(new ImageIcon (this.getClass().getResource("/guiIntro/Dog.gif")));
			names = new ArrayList<String>();
			names.add("sun");
			names.add("bird");
			names.add("dog");
			
		}
	   public int getImageCount () {
		   return myImages.size();
	   }
	   public ImageIcon getImage (int index) {
		   return myImages.get(index);
	   }	   
	   public String getName (int index) {
		   return names.get(index);
	   }
	   public ImageIcon getRandomImage () {
		   return myImages.get(rand.nextInt(getImageCount()));
	   }
}
