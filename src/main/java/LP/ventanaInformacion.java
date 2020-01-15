package LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import LD.BaseDeDatos;
import LN.Comanda;
import LN.Menu;

public class ventanaInformacion extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton2;
	private String tipo;
	
	private JTable table;
	private DefaultTableModel model;
	
	JFrame frame;
	private JButton btnNewButton4;
	private ArrayList <Menu> listaMenus = new ArrayList <Menu>();
	private ArrayList <Comanda> listaComandas = new ArrayList <Comanda>();
	private ArrayList <JButton> listaBotones;
	private BaseDeDatos datos = new BaseDeDatos();
	private float precio;
	private String plato1;
	private JButton boton;
	private int id;
	private String plato2;
	private String plato3;

	
	public ventanaInformacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 947, 738);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Comandas DISPONIBLES");
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
		sp.setBounds(70, 150,781, 355);
		sp.setViewportView(table);
		
	
		model.addColumn("Tipo");
		model.addColumn("precio");

	 
	    
	    contentPane.add(sp);
		//contentPane.setLayout(new FlowLayout());
		

		listaComandas.addAll(datos.leerComandas());
		
		
		for(int i=0;i<listaComandas.size();i++) {
			
			tipo=listaComandas.get(i).getNombreM();
			precio=listaComandas.get(i).getPrecio();
			Object[]data= {tipo, precio};
			model.addRow(data);
		}
	
		
	
		
		JButton btnNewButton3 = new JButton("VER PLATOS");
		btnNewButton3.setBounds(332, 535, 207, 111);
		btnNewButton3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton3.addActionListener(this);
		contentPane.add(btnNewButton3);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{		
			case "ATRAS":
				dispose();
				break;
			case "VER PLATOS":
				ventanaVerPlatos fVerPlatos = new ventanaVerPlatos();
				fVerPlatos.setVisible(true);
				break;
		}
		
	}

}
