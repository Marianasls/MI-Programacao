package controller;

import java.util.ArrayList;
import java.util.List;
import model.Vertice;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mariana Lima
 */


public class RVControllerTest {
    private final RVController controlador;
    
    public RVControllerTest() {
        controlador = new RVController();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addVeiculos method, of class RVController.
     */
    @Test
    public void testAddVeiculos() {
    }

    /**
     * Test of getVeiculos method, of class RVController.
     */
    @Test
    public void testGetVeiculos() {
    }

    /**
     * Test of lerArquivo method, of class RVController.
     */
    @Test
    public void testLerArquivo() {
        //para ler o arquivo de texto
        controlador.lerArquivoBinario();
    }

    
}
