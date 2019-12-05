package LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventanaComandas2 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnNewButton2;

	
	public ventanaComandas2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 738);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GESTIÓN DE COMANDAS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 101, 849, 20);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("NUEVO PLATO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaComandas comandas=new ventanaComandas();
				comandas.setVisible(true);
				
			}
		});
		
		btnNewButton.setBounds(150, 350, 239, 143);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton3 = new JButton("NUEVA COMANDA");
		btnNewButton3.setBounds(450, 350, 239, 143);
		btnNewButton3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton3.addActionListener(this);
		contentPane.add(btnNewButton3);
		
		btnNewButton2 = new JButton("ATRAS");
		btnNewButton2.setForeground(Color.GRAY);
		btnNewButton2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton2.setBounds(20, 80, 130, 30);
		btnNewButton2.addActionListener(this);
		contentPane.add(btnNewButton2);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{		
			case "ATRAS":
				dispose();
				break;
			
			case "NUEVA COMANDA":
				ventanaNuevaComanda fNuevaComanda = new ventanaNuevaComanda();
				fNuevaComanda.setVisible(true);
					break;
				
			
		}
		
	}
}