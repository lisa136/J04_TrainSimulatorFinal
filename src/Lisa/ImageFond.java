package Lisa;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageFond extends MaJFrame {
	private Container c;
	private JPanel imagePanel;
	private String filePath;

	public ImageFond(String filePath) {
		super();
		this.filePath = filePath;
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c = getContentPane();
		imagePanel = new JPanel() {
			public void paint(Graphics g) {
				try {
					BufferedImage image = ImageIO.read(new File(filePath));
					g.drawImage(image, 0, 0, null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		/**
		imagePanel.setPreferredSize(new Dimension(640, 480));
		**/
		c.add(imagePanel);
	}

}
