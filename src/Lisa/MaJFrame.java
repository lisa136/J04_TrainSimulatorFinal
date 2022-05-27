package Lisa;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Bodian.Circuit;
import Bodian.TrainBis;
import Bodian.Wagon;
import Guoyu.Aguillage;
import Guoyu.Gare;
import Guoyu.Position;
import Lisa.MonJPanelDessin;
import Thomas.Jeu;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.DropMode;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MaJFrame extends JFrame {

	private JPanel contentPane;
	private Image ImFond;
	
	public MaJFrame(Jeu jeu) 
	{
		this.setLayout(null);
		try 
		{
			ImFond=ImageIO.read(new File("images/fond_1.jpg"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	public  void paintComponent(Graphics g) {
	    g.drawImage(ImFond, 0, 0, null);
	  }
		

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaJFrame frame = new MaJFrame();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}
	
	/**
	 * Create the frame.
	 */
	public MaJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_7 = new MonJPanelImage();
		contentPane.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BorderLayout(0, 0));
		panel_7.setOpaque(false);

		
		JPanel panel_2_1 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2_1.getLayout();
		flowLayout_2.setAlignment(FlowLayout.TRAILING);
		panel_2_1.setOpaque(false);
		panel_7.add(panel_2_1, BorderLayout.SOUTH);
		
		JPanel panel_6_1 = new JPanel();
		panel_2_1.add(panel_6_1);
		panel_6_1.setOpaque(false);

		
		JButton btnNewButton_1 = new JButton();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicSuivant();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\passe\\Desktop\\ECLIPSE\\J04_TrainSimulator\\images\\fleches.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_6_1.add(btnNewButton_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setOpaque(false);
		panel_7.add(panel_1_1, BorderLayout.CENTER);
		panel_1_1.setLayout(new GridLayout(10, 0, 0, 0));
		
		JLabel lblNewLabel_1_1 = new JLabel("But du jeu :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1_1.add(lblNewLabel_1_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_1_1.add(panel_3_1);
		panel_3_1.setOpaque(false);

		
		JLabel lblNewLabel_2_1 = new JLabel("     - Que tous les trains arrivent en gare");
		panel_1_1.add(lblNewLabel_2_1);
		
		JPanel panel_4_1 = new JPanel();
		panel_1_1.add(panel_4_1);
		panel_4_1.setOpaque(false);

		
		JLabel lblNewLabel_3_1 = new JLabel("Les regles sont simples :");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1_1.add(lblNewLabel_3_1);
		
		JPanel panel_5_1 = new JPanel();
		panel_1_1.add(panel_5_1);
		panel_5_1.setOpaque(false);

		
		JLabel lblNewLabel_4_1 = new JLabel("     - A chaque train est associe un circuit et une gare, ainsi qu'un nombre de wagon, de façon aléatoire​");
		panel_1_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("     - Les trains ne peuvent pas changer de direction au niveau des aiguillages (situés à chaque intersection entre les circuits)​");
		panel_1_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("     -  Rien n'empeche un train de changer de circuit ");
		panel_1_1.add(lblNewLabel_6_1);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		panel_1.setOpaque(false);
		panel_7.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Bienvenue dans Train Simulator");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblNewLabel_1);
		
	
	
	}
	
	public void clicSuivant() {
		MaJFrame frame= new MaJFrame();
		frame.setVisible(false);
		dispose();
		Initialisation init = new Initialisation();
		init.setVisible(true);
	}
}
