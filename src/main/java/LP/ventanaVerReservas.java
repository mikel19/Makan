package LP;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import LD.BaseDeDatos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import LN.Menu;
import LN.Plato;
import LN.Reserva;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ventanaVerReservas extends JFrame implements ActionListener{

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
	private JTable table;
	private DefaultTableModel model;
	private JButton btnNewButton2;
	private ArrayList <Reserva> listaReservas = new ArrayList <Reserva>();
	private BaseDeDatos datos = new BaseDeDatos();
	


	public ventanaVerReservas() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 947, 738);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LISTA DE RESERVAS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 101, 925, 20);
		contentPane.add(lblNewLabel);
		
		btnNewButton2 = new JButton("ATRAS");
		btnNewButton2.setForeground(Color.GRAY);
		btnNewButton2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton2.setBounds(20, 80, 130, 30);
		btnNewButton2.addActionListener(this);
		contentPane.add(btnNewButton2);
		
		
		model = new DefaultTableModel();
		table = new JTable(model);
		JScrollPane sp =new JScrollPane();
		sp.setViewportView(table);
		
			
		model.addColumn("NOMBRE");
	    model.addColumn("APELLIDO");
	    model.addColumn("FECHA");
	    model.addColumn("TELEFONO");
	    model.addColumn("HORA");
	    model.addColumn("MENU");
	    model.addColumn("Nº PERSONAS");
	
		
		contentPane.add(sp);
		contentPane.setLayout(new FlowLayout());
		
		
		
		listaReservas.addAll(datos.leerReservas());
		
		for(int i=0;i<listaReservas.size();i++)
		{
			
			
			nombre = listaReservas.get(i).getNombre();
			apellido = listaReservas.get(i).getApellido();
			fecha = listaReservas.get(i).getFecha();
			hora = listaReservas.get(i).getHora();
			telefono = listaReservas.get(i).getTelefono();
			//menu=listaReservas.get(i).getMenu();
			numPersonas=listaReservas.get(i).getNumPersonas();
			
			
			Object[] data= {nombre, apellido, fecha, telefono, hora, null, numPersonas};
			
			model.addRow(data);
			
		}
		
		
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


}