package LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ventanaInformacion extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton2;

	
	public ventanaInformacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 738);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INFORMACION DEL NEGOCIO");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 101, 849, 20);
		contentPane.add(lblNewLabel);
		
		btnNewButton2 = new JButton("ATRAS");
		btnNewButton2.setForeground(Color.GRAY);
		btnNewButton2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton2.setBounds(20, 80, 130, 30);
		btnNewButton2.addActionListener(this);
		contentPane.add(btnNewButton2);
		
		JButton btnNewButton3 = new JButton("VER PLATOS");
		btnNewButton3.setBounds(450, 350, 289, 191);
		btnNewButton3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton3.addActionListener(this);
		contentPane.add(btnNewButton3);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{		
			case "ATRAS":
				dispose();
				break;
			case "VER PLATOS":
				ventanaVerPlatos fVerPlatos = new ventanaVerPlatos();
				fVerPlatos.setVisible(true);
				break;
		}
		
	}

}
