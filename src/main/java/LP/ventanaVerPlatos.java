package LP;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import LD.BaseDeDatos;
import LN.Menu;
import LN.Plato;
import LN.Reserva;





public class ventanaVerPlatos extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnNewButton;
	private Plato plato;
	private Menu menu;
	private Float precio;
	private String plato1;
	private String plato2;
	private String plato3;
	private JComboBox comboBox;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnNewButton2;
	private ArrayList <Plato> listaPlatos = new ArrayList <Plato>();

	private BaseDeDatos datos = new BaseDeDatos();
	private JButton boton1;
	private String nombre;
	private String alergenos;
	private Object chef;

	public ventanaVerPlatos() 
	{
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 947, 738);
	contentPane = new JPanel();
	contentPane.setBackground(Color.DARK_GRAY);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("CARTA DE PLATOS");
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
    model.addColumn("PRECIO");
    model.addColumn("ALERGENOS");
    model.addColumn("CHEF");


	
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
	
	
	
	String nombre1=(String) table.getValueAt(row, 0);
	Float precio1=(Float) table.getValueAt(row, 1);
	String alergenos1=(String) table.getValueAt(row, 2);
	String chef1=(String) table.getValueAt(row, 3);
	
	
	
	
	
	
	Plato plato =new Plato(nombre1, precio1, alergenos1, chef1);
	
	

	datos.eliminarPlato(plato);
	
   
}
public void cargar()
{
	listaPlatos.addAll(datos.leerdatos());
	
	for(int i=0;i<listaPlatos.size();i++)
	{
		
		
		nombre = listaPlatos.get(i).getNombre();
		precio = listaPlatos.get(i).getPrecio();
		alergenos = listaPlatos.get(i).getAlergenos();
		chef = listaPlatos.get(i).getNombreChef();
		
		
		
		Object[] data= {nombre, precio, alergenos, chef};
		model.addRow(data);
		
	}
}
}
