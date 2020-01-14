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
	private Float precio;
	private String plato1;
	private String plato2;
	private String plato3;
	private JComboBox comboBox;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnNewButton2;
	private ArrayList <Reserva> listaReservas = new ArrayList <Reserva>();
	private ArrayList <Menu> listaMenus = new ArrayList <Menu>();
	private BaseDeDatos datos = new BaseDeDatos();
	private JButton boton1;



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
		
		boton1=new JButton("ELIMINAR");
	    boton1.setForeground(Color.GRAY);
	    boton1.setFont(new Font("Tahoma", Font.BOLD, 18));
	    boton1.setBounds(330,600,200, 50);
	    boton1.addActionListener(this);
		contentPane.add(boton1);
		
		model = new DefaultTableModel();
		table = new JTable(model);
		JScrollPane sp =new JScrollPane();
		sp.setBounds(70, 150,800, 445);
		sp.setViewportView(table);
		
		
			
		model.addColumn("NOMBRE");
	    model.addColumn("APELLIDO");
	    model.addColumn("FECHA");
	    model.addColumn("TELEFONO");
	    model.addColumn("HORA");
	    model.addColumn("MENU");
	    model.addColumn("Nº PERSONAS");
	
		
		contentPane.add(sp);
	
		cargar();
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{		
			case "ATRAS":
				dispose();
				break;
				
			
			case "ELIMINAR":
				eliminar();
				dispose();
				break;
		}
		
	}
	
	public void eliminar()
	{
		int row=table.getSelectedRow();
		
		Menu menu1=new Menu("",0.0f,"","","");
		
		String nombre1=(String) table.getValueAt(row, 0);
		String apellido=(String) table.getValueAt(row, 1);
		String fecha=(String) table.getValueAt(row, 2);
		String telefono=(String) table.getValueAt(row, 3);
		String hora=(String) table.getValueAt(row, 4);
		String menu=(String) table.getValueAt(row, 5);
		int personas=(int) table.getValueAt(row, 6);
		
		listaMenus.addAll(datos.leerMenus());
		for(int i=0;i<listaMenus.size();i++)
		{
			
			
			if(listaMenus.get(i).getTipo().equals(menu))
			{
		
				precio=listaMenus.get(i).getPrecio();
				plato1=listaMenus.get(i).getPlato1();
				plato2=listaMenus.get(i).getPlato2();
				plato3=listaMenus.get(i).getPlato3();
					
			}
		}
		
		menu1.setPlato1(plato1);
		menu1.setPlato2(plato2);
		menu1.setPlato3(plato3);
		menu1.setPrecio(precio);
		menu1.setTipo(menu);
		
		Reserva reserva =new Reserva(nombre1, apellido, telefono, personas, fecha, hora, menu1);
		
		

		datos.eliminarReserva(reserva);
		
	   
	}
	public void cargar()
	{
		listaReservas.addAll(datos.leerReservas());
		
		for(int i=0;i<listaReservas.size();i++)
		{
			
			
			nombre = listaReservas.get(i).getNombre();
			apellido = listaReservas.get(i).getApellido();
			fecha = listaReservas.get(i).getFecha();
			hora = listaReservas.get(i).getHora();
			telefono = listaReservas.get(i).getTelefono();
			String menu=listaReservas.get(i).getMenu().getTipo();
			numPersonas=listaReservas.get(i).getNumPersonas();
			
			
			Object[] data= {nombre, apellido, fecha, telefono, hora, menu, numPersonas};
			
			model.addRow(data);
			
		}
	}
	



}