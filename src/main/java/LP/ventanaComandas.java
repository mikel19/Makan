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

public class ventanaComandas extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField precio;
	private JTextField nombrep;
	private JTextField alergenos;
	private JTextField cheff2;

	
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
		lblId.setBounds(31, 143, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 208, 46, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblDescripcion = new JLabel("Nombre");
		lblDescripcion.setBounds(236, 154, 46, 14);
		contentPane.add(lblDescripcion);
		
		JLabel lblIngredientes = new JLabel("Alergenos");
		lblIngredientes.setBounds(225, 222, 46, 14);
		contentPane.add(lblIngredientes);
		
		id = new JTextField();
		id.setBounds(55, 140, 86, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		precio = new JTextField();
		precio.setBounds(55, 205, 86, 20);
		contentPane.add(precio);
		precio.setColumns(10);
		
		nombrep = new JTextField();
		nombrep.setBounds(299, 151, 86, 20);
		contentPane.add(nombrep);
		nombrep.setColumns(10);
		
		alergenos = new JTextField();
		alergenos.setBounds(299, 219, 86, 20);
		contentPane.add(alergenos);
		alergenos.setColumns(10);
		
		
		JLabel cheff = new JLabel("chef");
		cheff.setBounds(395, 154, 46, 14);
		contentPane.add(cheff);
		
		cheff2 = new JTextField();
		cheff2.setBounds(426, 151, 86, 20);
		contentPane.add(cheff2);
		cheff2.setColumns(10);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
			Plato plato=new Plato(nombrep.getText(),Float.parseFloat(precio.getText()),alergenos.getText(),cheff2.getText());
				
					
					BaseDeDatos datos=new BaseDeDatos();
					datos.añadirplatos(plato);
					vaciarTextFields();
			}
		});
		btnAceptar.setBounds(141, 253, 89, 23);
		contentPane.add(btnAceptar);
	
		
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
