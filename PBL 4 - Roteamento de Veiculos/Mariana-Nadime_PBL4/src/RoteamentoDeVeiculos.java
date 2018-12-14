/*******************************************************************************
 * Componente Curricular: Módulo Integrado de Programação 
 * Autor: <Mariana Lima>
 * Data:  <04/12/2018>
 *
 * Declaro que este código foi elaborado por mim de forma individual e
 * não contém nenhum trecho de código de outro colega ou de outro autor, 
 * tais como provindos de livros e apostilas, e páginas ou documentos 
 * eletrônicos da Internet. Qualquer trecho de código de outra autoria que
 * uma citação para o  não a minha está destacado com  autor e a fonte do
 * código, e estou ciente que estes trechos não serão considerados para fins
 * de avaliação. Alguns trechos do código podem coincidir com de outros
 * colegas pois estes foram discutidos em sessões tutorias.
 ******************************************************************************/
package controller;
import java.util.LinkedList;
import java.util.List;
import model.Veiculos;

/**
 *
 * @author Mariana Lima
 */
public class RoteamentoDeVeiculos {
    private final List<Veiculos> veiculos;
    
    public RoteamentoDeVeiculos() {
        veiculos = new LinkedList<>();
    }
    
    public void addVeiculos(Veiculos v) {
        veiculos.add(v);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
