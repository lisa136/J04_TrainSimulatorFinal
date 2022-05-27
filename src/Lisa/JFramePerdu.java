package Lisa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

public class JFramePerdu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFramePerdu frame = new JFramePerdu();
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
	public JFramePerdu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new MonJPanelImage();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GREEN);
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("REJOUER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicRejouer();
			}
		});
		panel_2.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.GREEN);
		contentPane.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.GREEN);
		panel_3.add(panel_5);
		
		JTextArea txtrPerdu = new JTextArea();
		txtrPerdu.setBackground(Color.GREEN);
		txtrPerdu.setForeground(Color.RED);
		txtrPerdu.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		txtrPerdu.setText("PERDU ...");
		panel_5.add(txtrPerdu);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.GREEN);
		panel_3.add(panel_6);
		
		JTextArea txtrVousPouvezRejouer = new JTextArea();
		txtrVousPouvezRejouer.setBackground(Color.GREEN);
		txtrVousPouvezRejouer.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtrVousPouvezRejouer.setText("        Vous pouvez rejouer\r\nou jeter votre ordi par la fen\u00EAtre !");
		panel_6.add(txtrVousPouvezRejouer);
	}
	public void clicRejouer() {
		JFramePerdu perdu = new JFramePerdu();
		perdu.setVisible(false);
		dispose();
		Initialisation jeu = new Initialisation();
		jeu.setVisible(true);
	}

}
