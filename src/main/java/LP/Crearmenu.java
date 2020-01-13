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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import LD.BaseDeDatos;
import LN.Menu;
import LN.Plato;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
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
	private JButton btnNewButton2;
	private String plato33;
	private JComboBox platos1;
	private JComboBox platos2;
	private JComboBox platos3 ;
	private String nombrePlato;
	private ArrayList <Plato> lista = new ArrayList <Plato>();
	private BaseDeDatos datos = new BaseDeDatos();
	private Menu menu;
	private String nombrePlato2;
	private String nombrePlato3;
	
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
		
		btnNewButton2 = new JButton("ATRAS");
		btnNewButton2.setForeground(Color.GRAY);
		btnNewButton2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton2.setBounds(20, 80, 130, 30);
		btnNewButton2.addActionListener(this);
		contentPane.add(btnNewButton2);
		
		tipo = new JTextField();
		tipo.setBounds(157, 249, 106, 30);
		contentPane.add(tipo);
		tipo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("TIPO");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(90, 262, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(100, 331, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		precio = new JTextField();
		precio.setBounds(167, 328, 106, 30);
		contentPane.add(precio);
		precio.setColumns(10);
		
		JLabel lblPlato = new JLabel("Plato 1");
		lblPlato.setForeground(Color.WHITE);
		lblPlato.setBounds(386, 214, 106, 20);
		contentPane.add(lblPlato);
		
		JLabel lblPlato_1 = new JLabel("Plato 2");
		lblPlato_1.setForeground(Color.WHITE);
		lblPlato_1.setBounds(386, 277, 106, 31);
		contentPane.add(lblPlato_1);
		
		platos2 = new JComboBox();
		platos2.setBounds(477, 282, 100, 30);
		contentPane.add(platos2);
		
//		plato2.setColumns(10);
		
		platos3 = new JComboBox();
		platos3.setBounds(477, 353, 100, 30);
		contentPane.add(platos3);
//		plato2.setColumns(10);
		
		JLabel lblPlato_2 = new JLabel("Plato 3");
		lblPlato_2.setForeground(Color.WHITE);
		lblPlato_2.setBounds(386, 349, 106, 36);
		contentPane.add(lblPlato_2);
		
		
		
		JButton aceptar = new JButton("Aceptar");
		aceptar.setFont(new Font("Tahoma", Font.BOLD, 18));
		aceptar.addActionListener(this); 
			
		
		aceptar.setBounds(222, 480, 284, 109);
		contentPane.add(aceptar);
		BaseDeDatos datos=new BaseDeDatos();
		Plato platos=new Plato(plato11, precio1, plato11, plato11);
		platos1 = new JComboBox();
		platos1.setBounds(477, 214, 100, 30);
		contentPane.add(platos1);
		
		lista.addAll(datos.leerdatos());
		platos1.addItem("");
		platos2.addItem("");
		platos3.addItem("");
		for(int i=0;i<lista.size();i++)
		{
		
			platos1.addItem(lista.get(i).getNombre());
			platos2.addItem(lista.get(i).getNombre());
			platos3.addItem(lista.get(i).getNombre());
		
		}
		
		//nombrePlato = (String)platos1.getSelectedItem()+"";

		
	
//		menu=new Menu("",0,"","","");
//		menu.setPlato1(nombrePlato);
//		menu.setPlato2(nombrePlato2);
//		menu.setPlato3(nombrePlato3);
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
//			plato11=nombrePlato;
//			plato22=nombrePlato2;
//			plato33=nombrePlato3;
			String plato11 = platos1.getSelectedItem()+"";
			String plato22 = platos2.getSelectedItem()+"";
			String platos33 = platos3.getSelectedItem()+"";
			
		
			Menu menu=new Menu(tipo1,precio1, plato11, plato22,platos33);
			BaseDeDatos datos=new BaseDeDatos();
			datos.añadirmenu(menu);
			break;
			
		case "ATRAS":
			dispose();
			break;
		}
		
	}

	
}