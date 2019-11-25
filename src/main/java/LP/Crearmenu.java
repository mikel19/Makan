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

import LD.BaseDeDatos;
import LN.Menu;
import LN.Plato;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Crearmenu extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tipo;
	private JTextField precio;
	private JTextField plato2;
	private JTextField plato3;
	private String tipo1;
	private float precio1;
	private String plato11;
	private String plato22;
	private String plato33;
	private ArrayList <Plato> lista = new ArrayList <Plato>();
	private BaseDeDatos datos = new BaseDeDatos();
	private Menu menu;
	
	public Crearmenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 738);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INTRODUCIR LOS DATOS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 101, 849, 20);
		contentPane.add(lblNewLabel);
		
		tipo = new JTextField();
		tipo.setBounds(139, 147, 86, 20);
		contentPane.add(tipo);
		tipo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("TIPO");
		lblNewLabel_1.setBounds(72, 150, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setBounds(72, 199, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		precio = new JTextField();
		precio.setBounds(139, 196, 86, 20);
		contentPane.add(precio);
		precio.setColumns(10);
		
		JLabel lblPlato = new JLabel("Plato 1");
		lblPlato.setBounds(364, 274, 46, 14);
		contentPane.add(lblPlato);
		
		JLabel lblPlato_1 = new JLabel("Plato 2");
		lblPlato_1.setBounds(364, 321, 46, 14);
		contentPane.add(lblPlato_1);
		
		JComboBox plato2 = new JComboBox();
		plato2.setBounds(439, 318, 86, 20);
		contentPane.add(plato2);
//		plato2.setColumns(10);
		
		JLabel lblPlato_2 = new JLabel("plato 3");
		lblPlato_2.setBounds(364, 373, 46, 14);
		contentPane.add(lblPlato_2);
		
		
		plato3 = new JTextField();
		plato3.setBounds(439, 370, 86, 20);
		contentPane.add(plato3);
		plato3.setColumns(10);
		
		JButton aceptar = new JButton("aceptar");
		aceptar.addActionListener(this); 
			
		
		aceptar.setBounds(222, 553, 109, 36);
		contentPane.add(aceptar);
		BaseDeDatos datos=new BaseDeDatos();
		Plato platos=new Plato(plato11, precio1, plato11, plato11);
		JComboBox plato1 = new JComboBox();
		plato1.setBounds(439, 270, 61, 22);
		contentPane.add(plato1);
		
		lista.addAll(datos.leerdatos());
		for(int i=0;i<lista.size();i++)
		{
		
			plato1.addItem(lista.get(i).getNombre());
		}
		
		String nombrePlato = plato1.getSelectedItem()+"";
		for(int i=0;i<lista.size();i++)
		{
			
			if(lista.get(i).getNombre().equalsIgnoreCase(nombrePlato)) {
				
			}else {
			plato2.addItem(lista.get(i).getNombre());
			}
		}
		String nombrePlato2 = plato2.getSelectedItem()+"";
	
		menu=new Menu("",0,"","","");
		menu.setPlato1(nombrePlato);
		menu.setPlato2(nombrePlato2);
//		  Plato plato=new Plato("",2,"","");
//		Connection c = null;
//	      Statement stmt = null;
//			ResultSet resultados = null;
//	      try {
//			Class.forName("org.sqlite.JDBC");
//		    c = DriverManager.getConnection("jdbc:sqlite:test.db");
//		    stmt = c.createStatement();
//	         c.setAutoCommit(false);
//	         System.out.println("Opened database successfully");
//	         resultados = stmt.executeQuery("SELECT NOMBRE FROM PLATOS;");
//	     	while (resultados.next()) {
//	     		ArrayList<Plato>list=new ArrayList<Plato>();
//			    System.out.println("NOMBRE " + resultados.getString("NOMBRE"));
//			   // plato.setNombre(resultados.getString("NOMBRE"));
//			   
//			    plato.datosarray(resultados.getString("NOMBRE"));
//			    comboBox.addItem(resultados.getString("NOMBRE"));
//			 //plato.setNombre(resultados.getString(1));
//			 //return plato;  
//			   }
//	     	resultados.close();
//	     	c.close();
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch(e.getActionCommand())
		{
		case "aceptar":
			tipo1=tipo.getText();
		precio1=Float.parseFloat(precio.getText());
			
			plato22=plato2.getText();
		plato33=plato3.getText();
		
			Menu menu=new Menu("",0,"","","");
			BaseDeDatos datos=new BaseDeDatos();
			datos.añadirmenu(menu);
		}
		
	}
}