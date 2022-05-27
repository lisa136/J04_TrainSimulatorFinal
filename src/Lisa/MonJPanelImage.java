package Lisa;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MonJPanelImage extends JPanel {
	
	private static final long serialVersionUID = 3641337531772753865L;
	private String sNomImage;
	private Image image=null;

	
	public MonJPanelImage() {
		super();
		sNomImage=null;
	}
	public MonJPanelImage(String sNom) {
		super();
		sNomImage=sNom;
		chargerImage();	
	}
	
	public void setImage(String sNom) {
		sNomImage=sNom;
		chargerImage();	
	}
	
	private void chargerImage(){
		if(sNomImage!=null) {
			String sNomFile=".\\images\\"+sNomImage;
			try {                
		          image = ImageIO.read(new File(sNomFile));
		       } catch (IOException ex) {
		    	   image=null;
		       }
		}	
		this.repaint();
	}
	/**
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("hop");
		this.setBackground(Color.green);
		if(image!=null) {
			 g.drawImage(image, 0, 0, 10,10, null);
		}
		
	}	
	**/
}




		
	

