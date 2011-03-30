package utilities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class IconProcess {
	
	public BufferedImage resizeImage(BufferedImage originalImage, int type, int imageWidth, int imageHeight){
		BufferedImage resizedImage = new BufferedImage(imageWidth, imageHeight, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, imageWidth, imageHeight, null);
		g.dispose();
	 
		return resizedImage; 
	}
 
	public ImageIcon resizeIcon(String iconPath, int imageWidth, int imageHeight) {
		
		BufferedImage image = null;
		ImageIcon icon = null;
		
		try {
			
			image = ImageIO.read(getClass().getResource(iconPath));
			int type = image.getType() == 0? BufferedImage.TYPE_INT_ARGB : image.getType();
			image = resizeImage(image, type, imageWidth, imageHeight);
			Image test = image;
			icon = new ImageIcon(test);
			
		} catch (Exception e) {
			
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Error! Cannot Resize Image!");
		}
		return icon;
	}


}
