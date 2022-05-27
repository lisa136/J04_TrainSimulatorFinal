package Lisa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class JFrameFinJeu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameFinJeu frame = new JFrameFinJeu();
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
	public JFrameFinJeu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GREEN);
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("BRAVO");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		panel_2.add(lblNewLabel);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.GREEN);
		panel_2.add(panel_7);
		
		JTextArea txtrVousPouvezMaintenant_1 = new JTextArea();
		txtrVousPouvezMaintenant_1.setBackground(Color.GREEN);
		txtrVousPouvezMaintenant_1.setText("    Vous pouvez maintenant choisir de rejouer \r\n    ou de continuer en augmentant la difficult\u00E9 !\u200B\r\n");
		txtrVousPouvezMaintenant_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_7.add(txtrVousPouvezMaintenant_1);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.GREEN);
		panel_4.add(panel_5);
		
		JButton btnNewButton = new JButton("REJOUER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicRejouer();
			}
		});
		panel_5.add(btnNewButton);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.GREEN);
		panel_4.add(panel_6);
		
		JButton btnNewButton_1 = new JButton("CONTINUER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicContinuer();
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(Color.BLACK);
		panel_6.add(btnNewButton_1);
	}
	public void clicRejouer() {
		JFrameFinJeu fin = new JFrameFinJeu();
		fin.setVisible(false);
		dispose();
		Initialisation jeu = new Initialisation();
		jeu.setVisible(true);
	}
	public void clicContinuer() {
		JFrameFinJeu fin = new JFrameFinJeu();
		fin.setVisible(false);
		dispose();
		Initialisation init = new Initialisation();
		init.setVisible(true);
	}

}
