package Lisa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Regles extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Regles regle = new Regles();
					regle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Regles() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel paneRe = new MonJPanelImage();
		paneRe.setBorder(new EmptyBorder(5, 5, 5, 5));
		paneRe.setLayout(new BorderLayout(0, 0));
		setContentPane(paneRe);
		
		JPanel panel = new JPanel();
		paneRe.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		panel.setOpaque(false);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		panel_2.setOpaque(false);

		JLabel lblNewLabel = new JLabel("Que devez-vous faire ?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_3);
		panel_3.setOpaque(false);

		JButton btnFermer = new JButton("FERMER");
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicFermer();
			}
		});
		btnFermer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(btnFermer);
		
		
		
		JPanel panel_1 = new JPanel();
		paneRe.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.setOpaque(false);

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(11, 0, 0, 0));
		panel_4.setOpaque(false);

		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setOpaque(false);

		JLabel lblNewLabel_1 = new JLabel("Afin d'atteindre votre objectif vous pouvez :\u200B");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(lblNewLabel_1);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setOpaque(false);

		JLabel lblNewLabel_2 = new JLabel("     - D\u00E9terminer l'ordre de d\u00E9part des trains\u200B");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("             Ce qui permet d'\u00E9viter que 2 trains arrivent en m\u00EAme temps \u00E0 un aiguillage\u200B");
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("     - Le sens de l'aiguillage\u200B");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_4.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("             Ce qui permet que le train avec le plus de wagon passe avant celui qui en a le moins\u200B");
		panel_4.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("             La position de l'aiguillage change automatiquement d\u00E8s qu'un train est pass\u00E9\u200B");
		panel_4.add(lblNewLabel_6);
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);
		panel_7.setOpaque(false);
		
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8);
		panel_8.setOpaque(false);

		
	}
	//marche, ferme fenetre
	public void clicFermer() { 
		Regles regle = new Regles();
		regle.setVisible(false);
		dispose();
	}

}
