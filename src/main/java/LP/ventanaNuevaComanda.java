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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ventanaNuevaComanda extends JFrame implements ActionListener{

	private String nombre;
	private JPanel contentPane;
	private JTable table;
	private JTable table1;
	private DefaultTableModel model;
	private DefaultTableModel model1;
	private JButton btnNewButton2;
	JFrame frame;
	private JButton btnNewButton;
	private ArrayList <Plato> listaPlatos = new ArrayList <Plato>();
	private ArrayList <Plato> listaPComandas = new ArrayList <Plato>();
	private ArrayList <JButton> listaBotones;
	private BaseDeDatos datos = new BaseDeDatos();
	private float precio;
	private String alergenos;
	private JButton boton;
	private int id;
	private String chef;
	private ArrayList <Menu> listaMenus = new ArrayList <Menu>();
	private ArrayList <Float> listaPrecios = new ArrayList <Float>();
	private float precio1;
	private String plato1;
	private String plato2;
	private String plato3;
	private String tipo;
	private Float resultado;
	


	public ventanaNuevaComanda() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 947, 738);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREAR NUEVA COMANDA");
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
		
		JLabel lblNewLabel1 = new JLabel("PLATOS DISPONIBLES:");
		lblNewLabel1.setForeground(Color.WHITE);
		lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel1.setBounds(30, 120, 200, 20);
		contentPane.add(lblNewLabel1);
		
		model = new DefaultTableModel();
		table = new JTable(model);
		JScrollPane sp =new JScrollPane();
		sp.setBounds(70, 150,800, 100);
		sp.setViewportView(table);
		
		model.addColumn("ID");
		model.addColumn("NOMBRE");
	    model.addColumn("PRECIO");
	    model.addColumn("ALERGENOS");
	    model.addColumn("CHEF");
	
	    contentPane.add(sp);
	    
	    btnNewButton=new JButton("AÑADIR A LA COMANDA");
	    btnNewButton.setForeground(Color.GRAY);
	    btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
	    btnNewButton.setBounds(600,280,200, 50);
	    btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
	    
	    JLabel lblNewLabel2 = new JLabel("MENÚS DISPONIBLES:");
		lblNewLabel2.setForeground(Color.WHITE);
		lblNewLabel2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel2.setBounds(30, 370, 200, 20);
		contentPane.add(lblNewLabel2);
	    
	    model1 = new DefaultTableModel();
		table1 = new JTable(model1);
		JScrollPane sp1 =new JScrollPane();
		sp1.setBounds(70, 400,800, 100);
		sp1.setViewportView(table1);
		
	
		model1.addColumn("TIPO");
	    model1.addColumn("PRECIO");
	    model1.addColumn("PLATO 1");
	    model1.addColumn("PLATO 2");
	    model1.addColumn("PLATO 3");
	 
	    
	    contentPane.add(sp1);
	    
	    boton=new JButton("VER");
	    boton.setForeground(Color.GRAY);
	    boton.setFont(new Font("Tahoma", Font.BOLD, 18));
	    boton.setBounds(600,570,130, 80);
	    boton.addActionListener(this);
		contentPane.add(boton);
		
		listaPlatos.addAll(datos.leerdatos());
		
		for(int i=0;i<listaPlatos.size();i++)
		{
			id=listaPlatos.get(i).getIdPlato();
			nombre = listaPlatos.get(i).getNombre();
			precio = listaPlatos.get(i).getPrecio();
			alergenos = listaPlatos.get(i).getAlergenos();
			chef=listaPlatos.get(i).getNombreChef();
			
			Object[] data= {id, nombre, precio, alergenos,chef};
			
			model.addRow(data);
		
		}
		
		
		listaMenus.addAll(datos.leerMenus());
		
		for(int i=0;i<listaMenus.size();i++)
		{
			
			tipo=listaMenus.get(i).getTipo();
			plato1 = listaMenus.get(i).getPlato1();
			precio1 = listaMenus.get(i).getPrecio();
			plato2 = listaMenus.get(i).getPlato2();
			plato3=listaMenus.get(i).getPlato3();
			
			Object[] data= {tipo, precio1, plato1,plato2, plato3};
			
			model1.addRow(data);
		
		}
		resultado=resultado;
		
	
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{		
			case "ATRAS":
				dispose();
				break;
				
			case "AÑADIR A LA COMANDA":
				
				int row=table.getSelectedRow();
				String nombre1=(String) table.getValueAt(row, 1);
				Float precio1=(Float) table.getValueAt(row, 2);
				String alergenos1=(String) table.getValueAt(row, 3);
				String chef1=(String) table.getValueAt(row, 4);
				
				Plato p=new Plato(nombre1, precio1, alergenos1, chef1);
				
				listaPComandas.add(p);
				
				for(int i=0;i<listaPComandas.size();i++)
				{
					System.out.println(listaPComandas.get(i).getNombre());
				}
				
			//	Comanda c=new Comanda(0,listaPComandas);
				
				listaPrecios.add(precio1);
				for(int i=0;i<listaPrecios.size();i++)
				{
					System.out.println("Precios:" + listaPrecios.get(i));
				}
				
				break;
				
			case "VER":
				resultado=0.0f;
				for(int i=0;i<listaPrecios.size();i++)
				{
					System.out.println("Precios:" + listaPrecios.get(i));
					System.out.println("R:" + resultado);
					resultado=datos.sumar(resultado, listaPrecios.get(i));
				}
				
				
				System.out.println("Total Comanda: " + resultado);
				
		}
		
	}


}