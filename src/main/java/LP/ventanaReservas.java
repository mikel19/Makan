package LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import LD.BaseDeDatos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import LN.Menu;
import LN.Reserva;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ventanaReservas extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldTelefono;
	private JTextField textFieldNumPersonas;
	private JTextField textFieldFecha;
	private JTextField textFieldHora;
	private JButton btnNewButton;
	private Reserva reserva;
	private String nombre;
	private String apellido;
	private String telefono;
	private int numPersonas;
	private String fecha;
	private String hora;
	private Menu menu;
	private JComboBox comboBox;
	


	public ventanaReservas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 947, 738);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GESTIÓN DE RESERVAS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 101, 925, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNombre.setBounds(77, 234, 169, 20);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblApellido.setBounds(77, 319, 169, 20);
		contentPane.add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Teléfono");
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTelefono.setBounds(77, 410, 169, 20);
		contentPane.add(lblTelefono);
		
		JLabel lblNumPersonas = new JLabel("Num. Personas");
		lblNumPersonas.setForeground(Color.WHITE);
		lblNumPersonas.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNumPersonas.setBounds(77, 495, 169, 20);
		contentPane.add(lblNumPersonas);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFecha.setBounds(468, 234, 169, 20);
		contentPane.add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setForeground(Color.WHITE);
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHora.setBounds(468, 319, 169, 20);
		contentPane.add(lblHora);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setForeground(Color.WHITE);
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMenu.setBounds(468, 410, 169, 20);
		contentPane.add(lblMenu);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(240, 232, 146, 26);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(240, 317, 146, 26);
		contentPane.add(textFieldApellido);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(240, 408, 146, 26);
		contentPane.add(textFieldTelefono);
		
		textFieldNumPersonas = new JTextField();
		textFieldNumPersonas.setColumns(10);
		textFieldNumPersonas.setBounds(240, 493, 76, 26);
		contentPane.add(textFieldNumPersonas);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(585, 232, 146, 26);
		contentPane.add(textFieldFecha);
		
		textFieldHora = new JTextField();
		textFieldHora.setColumns(10);
		textFieldHora.setBounds(585, 317, 146, 26);
		contentPane.add(textFieldHora);
		
		btnNewButton = new JButton("RESERVAR");
		btnNewButton.setForeground(Color.GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(585, 551, 191, 67);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		comboBox = new JComboBox();
		comboBox.setBounds(585, 408, 146, 26);
		comboBox.addItem("Menu Temporal");
		comboBox.addItem("Menu Degustacion");
		contentPane.add(comboBox);
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{

		switch(e.getActionCommand())
		{
		case "RESERVAR":
			recogerDatos();
			//reserva = new Reserva(nombre, apellido, telefono, numPersonas, fecha,hora,menu);
			vaciarTextFields();
			break;
			

		}
		
	}

	private void vaciarTextFields() 
	{
		textFieldNombre.setText("");
		textFieldApellido.setText("");
		textFieldTelefono.setText("");
		textFieldNumPersonas.setText("");
		textFieldFecha.setText("");
		textFieldHora.setText("");
		
	}


/**
 * Introduzco un valor aleatorio en el Menu, falta concretar
 */
	private void recogerDatos()
	{
		
		int id=0;
		nombre = textFieldNombre.getText();
		apellido = textFieldApellido.getText();
		telefono = textFieldTelefono.getText();
		numPersonas = Integer.parseInt(textFieldNumPersonas.getText());
		String fecha2="ff";
		
		//fecha = textFieldFecha.getText();
		
		hora = textFieldHora.getText();
		menu = new Menu(comboBox.getSelectedItem()+"",20);
		Reserva reserva=new Reserva(nombre, apellido, telefono, numPersonas, fecha, hora, menu);
		
	
		
		
	
	BaseDeDatos datos=new BaseDeDatos();
		datos.anadirdatosreserva(reserva);
		JOptionPane.showMessageDialog(null,"Reserva realizada correctamente");
		
		
	
		
		
		
		
	}
}
