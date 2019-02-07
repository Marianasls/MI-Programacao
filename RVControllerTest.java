/** *****************************************************************************
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: <Mariana Lima> e <Nadime Centeno>
 * Data:  <08/02/2019>
 *
 * Declaro que este código foi elaborado por mim de forma individual e não
 * contém nenhum trecho de código de outro colega ou de outro autor, tais como
 * provindos de livros e apostilas, e páginas ou documentos eletrônicos da
 * Internet. Qualquer trecho de código de outra autoria que uma citação para o
 * não a minha está destacado com autor e a fonte do código, e estou ciente que
 * estes trechos não serão considerados para fins de avaliação. Alguns trechos
 * do código podem coincidir com de outros colegas pois estes foram discutidos
 * em sessões tutorias.
 * ****************************************************************************
 */
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
 * @author Mariana Lima
 * @author Nadime
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
