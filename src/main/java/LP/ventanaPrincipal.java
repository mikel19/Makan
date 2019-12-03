package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;

public class ventanaPrincipal extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnReservas;
	private JButton btnMenus;
	private JButton btnComandas;
	private JButton btnInformacion;

	/**
	 * Launch the application.
	 */
	public void lanzarVentana() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaPrincipal frame = new ventanaPrincipal();
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
	public ventanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 675);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GESTOR RESTAURANTE MAKAN");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(0, 68, 809, 20);
		contentPane.add(lblNewLabel);
		
		btnReservas = new JButton("RESERVAS");
		btnReservas.setBackground(Color.GRAY);
		btnReservas.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReservas.setBounds(114, 179, 239, 143);
		btnReservas.addActionListener(this);
		contentPane.add(btnReservas);
		
		btnMenus = new JButton("MENUS");
		btnMenus.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMenus.setBackground(Color.GRAY);
		btnMenus.setBounds(417, 179, 239, 143);
		btnMenus.addActionListener(this);
		contentPane.add(btnMenus);
		
		btnComandas = new JButton("COMANDAS");
		btnComandas.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnComandas.setBackground(Color.GRAY);
		btnComandas.setBounds(114, 388, 239, 143);
		btnComandas.addActionListener(this);
		contentPane.add(btnComandas);
		
		btnInformacion = new JButton("INFORMACION");
		btnInformacion.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnInformacion.setBackground(Color.GRAY);
		btnInformacion.setBounds(417, 388, 239, 143);
		btnInformacion.addActionListener(this);
		contentPane.add(btnInformacion);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch(e.getActionCommand())
		{
		case "RESERVAS":
			ventanaReservas fReservas = new ventanaReservas();
			fReservas.setVisible(true);
				break;
		case "MENUS":
			ventanaMenus fMenus = new ventanaMenus();
			fMenus.setVisible(true);
			break;
		case "COMANDAS":
			ventanaComandas fComandas = new ventanaComandas();
			fComandas.setVisible(true);
			break;
		case "INFORMACION":
			ventanaInformacion fInformacion = new ventanaInformacion();
			fInformacion.setVisible(true);
			break;
			
		
		
		}
		
	}
}
