package Makan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import LD.BaseDeDatos;
import LN.Menu;
import LN.Reserva;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private BaseDeDatos b;
	private Reserva reserva;
	private ArrayList <Reserva> listaReservas;

	@Before
	public void setUp()
	{
		listaReservas = new ArrayList<Reserva>();
		reserva = new Reserva(null, null, null, 0, null, null, null);
		b = new BaseDeDatos();
		reserva.setIdReserva(100);
		reserva.setNombre("TestReserva");
		reserva.setApellido("Probando");
		reserva.setFecha("25/12/2019");
		reserva.setHora("11:05");
		reserva.setMenu(new Menu("Degustacion",20,"Macarrones","Filete","Tarta de queso"));
		reserva.setNumPersonas(2);
		reserva.setTelefono("90292929");
		
		
	}
	
	@Test
	public void usoMockito() {
		
	    ArrayList <Reserva> mockList = Mockito.mock(ArrayList.class);
	     
	    mockList.add(reserva);
	    Mockito.verify(mockList).add(reserva);
	    assertEquals(0, mockList.size());
	 
	    Mockito.when(mockList.size()).thenReturn(100);
	    assertEquals(100, mockList.size());
	}
	
	
	@Test
	public void testReserva()
	{
		b.anadirdatosreserva(reserva);
		
		listaReservas.addAll(b.leerReservas());
		int tam=listaReservas.size()-1;
		
		assertEquals(reserva.getNombre(),listaReservas.get(tam).getNombre());

	}


    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Test
    public void calcularPrecio()
    {
    	 assertEquals(12.3f, b.sumar(10.3f, 2.0f), 0);
    }
	
	@After
	public void endTests()
	{
		b.eliminarReserva(reserva);
	}

}
