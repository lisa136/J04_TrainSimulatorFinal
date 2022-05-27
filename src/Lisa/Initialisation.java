package Lisa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Thomas.Jeu;
import Thomas.SNCF;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Initialisation extends JFrame {

	private JPanel contentPane;
	private int levelChoose;
	private Jeu sim;
	private MonJPanelDessin panel;
	private JSpinner spinner_1;
	private JPanel panel_bouton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Initialisation init = new Initialisation();
					init.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(); 
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Initialisation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new MonJPanelImage();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		panel.setOpaque(false);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_3.setOpaque(false);

		JLabel lblNewLabel = new JLabel("A vous de jouer !");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.setOpaque(false);

		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		panel_1.add(panel_4, BorderLayout.NORTH);
		panel_4.setOpaque(false);

		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(6, 3, 0, 0));
		panel_5.setOpaque(false);

		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7);
		panel_7.setOpaque(false);

		JPanel panel_8 = new JPanel();
		panel_5.add(panel_8);
		panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_8.setOpaque(false);

		JLabel lblNewLabel_1_1_1 = new JLabel("Choisissez le niveau de difficult\u00E9 :\u200B");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_8.add(lblNewLabel_1_1_1);
		
		JPanel panel_9 = new JPanel();
		panel_5.add(panel_9);
		panel_9.setOpaque(false);

		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		panel_9.add(spinner_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_2.setOpaque(false);

		JPanel panel_10 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_10.getLayout();
		panel_2.add(panel_10, BorderLayout.WEST);
		panel_10.setOpaque(false);

		JButton btnNewButton = new JButton("REGLES DU JEU");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicRegles();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_10.add(btnNewButton);
		
		JPanel panel_11 = new JPanel();
		panel_2.add(panel_11, BorderLayout.EAST);
		panel_11.setOpaque(false);

		JButton btnNewButton_1 = new JButton("JOUER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicJouer();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_11.add(btnNewButton_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setOpaque(false);
		panel_2.add(panel_1_1, BorderLayout.NORTH);
		panel_1_1.setLayout(new BorderLayout(0, 0));
	}
	// marche, ferme fenetre
	public void clicJouer() 
	{
		levelChoose = (Integer)spinner_1.getValue();
		System.out.println("débutsncf");
		SNCF newsncf = new SNCF(levelChoose);
		
		System.out.println("finsncf");
		sim = new Jeu(newsncf, this);
	
		panel = new MonJPanelDessin(sim);
		contentPane.removeAll();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setOpaque(false);// peut recup valeur et pas que ecrire
		ajoutBouton();
		contentPane.repaint();
		panel.revalidate();
		panel.repaint();// choisir bon panel		
	}
	
	public void ajoutBouton()
	{
		panel_bouton = new JPanel();
		contentPane.add(panel_bouton, BorderLayout.SOUTH);
		panel_bouton.setLayout(new BorderLayout(0, 0));
		panel_bouton.setOpaque(false);
		
		JPanel panel_11 = new JPanel();
		panel_bouton.add(panel_11, BorderLayout.EAST);
		panel_11.setOpaque(false);

		JButton btnNewButton_1 = new JButton("JOUER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				demarrerJouer();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_11.add(btnNewButton_1);
	}
	
	public void demarrerJouer()
	{
		contentPane.remove(panel_bouton);
		panel.setConfigTerminer(true);
		panel.removeAll();
		panel.revalidate();
		panel.repaint();
		sim.start();
	}
	
	public void gameOver()
	{
		Initialisation frame= new Initialisation();
		frame.setVisible(false);
		dispose();
		JFramePerdu perdu= new JFramePerdu();
		perdu.setVisible(true);
	}
	
	public void victoire()
	{
		Initialisation frame= new Initialisation();
		frame.setVisible(false);
		dispose();
		JFrameFinJeu perdu= new JFrameFinJeu();
		perdu.setVisible(true);
	}
	
	//marche, affiche Règles sans fermer Init
	public void clicRegles() {
		Initialisation init = new Initialisation();
		init.setVisible(false);
		Regles regles = new Regles();
		regles.setVisible(true);
	}

}
