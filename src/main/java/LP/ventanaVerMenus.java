package LP;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

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

import LN.Comanda;
import LN.Menu;
import LN.Plato;
import LN.Reserva;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ventanaVerMenus extends JFrame implements ActionListener{

	private String tipo;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnNewButton2;
	JFrame frame;
	private JButton btnNewButton4;
	private ArrayList <Menu> listaMenus = new ArrayList <Menu>();
	private ArrayList <JButton> listaBotones;
	private BaseDeDatos datos = new BaseDeDatos();
	private float precio;
	private String plato1;
	private JButton boton;
	private int id;
	private String plato2;
	private String plato3;
	private JButton boton1;
	


	public ventanaVerMenus() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 947, 738);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MENUS DISPONIBLES");
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
		sp.setBounds(70, 150,800, 418);
		sp.setViewportView(table);
		
	
		model.addColumn("TIPO");
	    model.addColumn("PRECIO");
	    model.addColumn("PLATO 1");
	    model.addColumn("PLATO 2");
	    model.addColumn("PLATO 3");
	 
	    
	    contentPane.add(sp);
		//contentPane.setLayout(new FlowLayout());
		

		
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
		
		String tipo1=(String) table.getValueAt(row, 0);
		String plato1=(String) table.getValueAt(row, 2);
		String plato2=(String) table.getValueAt(row, 3);
		String plato3=(String) table.getValueAt(row, 4);
		Float precio1=(Float) table.getValueAt(row, 1);
		
		listaMenus.addAll(datos.leerMenus());
		for(int i=0;i<listaMenus.size();i++)
		{
			if(listaMenus.get(i).getTipo().equals(tipo1))
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
		menu1.setTipo(tipo1);
		
		Menu menu =new Menu(tipo1,precio1, plato1, plato2, plato3);
		
		

		datos.eliminarMenu(menu);
		
	}
	
	public void cargar()
	{
		listaMenus.addAll(datos.leerMenus());
		
		for(int i=0;i<listaMenus.size();i++)
		{
			
			tipo=listaMenus.get(i).getTipo();
			plato1 = listaMenus.get(i).getPlato1();
			precio = listaMenus.get(i).getPrecio();
			plato2 = listaMenus.get(i).getPlato2();
			plato3=listaMenus.get(i).getPlato3();
			
			Object[] data= {tipo, precio, plato1,plato2, plato3};
			
			model.addRow(data);
		
		}
	}


}