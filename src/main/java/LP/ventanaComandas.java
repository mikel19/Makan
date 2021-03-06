package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LD.BaseDeDatos;
import LN.Menu;
import LN.Plato;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventanaComandas extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField id;
	private JTextField precio;
	private JTextField nombrep;
	private JTextField alergenos;
	private JTextField cheff2;
	private JButton btnNewButton2;

	
	public ventanaComandas() {
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
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(Color.WHITE);
		lblId.setBounds(32, 185, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setBounds(220, 255, 86, 17);
		contentPane.add(lblPrecio);
		
		JLabel lblDescripcion = new JLabel("Nombre");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setBounds(207, 179, 99, 27);
		contentPane.add(lblDescripcion);
		
		JLabel lblIngredientes = new JLabel("Alergenos");
		lblIngredientes.setForeground(Color.WHITE);
		lblIngredientes.setBounds(207, 330, 100, 20);
		contentPane.add(lblIngredientes);
		
		id = new JTextField();
		id.setBounds(93, 182, 86, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		precio = new JTextField();
		precio.setBounds(322, 248, 136, 27);
		contentPane.add(precio);
		precio.setColumns(10);
		
		nombrep = new JTextField();
		nombrep.setBounds(325, 182, 130, 27);
		contentPane.add(nombrep);
		nombrep.setColumns(10);
		
		alergenos = new JTextField();
		alergenos.setBounds(322, 330, 136, 27);
		contentPane.add(alergenos);
		alergenos.setColumns(10);
		
		
		JLabel cheff = new JLabel("Chef");
		cheff.setForeground(Color.WHITE);
		cheff.setBounds(490, 179, 73, 27);
		contentPane.add(cheff);
		
		cheff2 = new JTextField();
		cheff2.setBounds(592, 177, 151, 30);
		contentPane.add(cheff2);
		cheff2.setColumns(10);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
			Plato plato=new Plato(nombrep.getText(),Float.parseFloat(precio.getText()),alergenos.getText(),cheff2.getText());
				
					
					BaseDeDatos datos=new BaseDeDatos();
					datos.anadirplatos(plato);
					vaciarTextFields();
			}
		});
		btnAceptar.setBounds(262, 446, 259, 102);
		contentPane.add(btnAceptar);
	
		
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
		}
		
	}
	private void vaciarTextFields() 
	{
		id.setText("");
		nombrep.setText("");
		precio.setText("");
		alergenos.setText("");
		cheff2.setText("");
		
		
	}


	
}
