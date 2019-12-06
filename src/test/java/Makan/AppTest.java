package Makan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import LD.BaseDeDatos;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	
	BaseDeDatos b=new BaseDeDatos();


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
	
	

}
