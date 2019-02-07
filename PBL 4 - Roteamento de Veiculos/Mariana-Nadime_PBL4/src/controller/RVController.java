/** *****************************************************************************
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: <Mariana Lima>
 * Data:  <04/02/2019>
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

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.LeituraArquivo;
import model.Rotas;
import model.Veiculos;
import model.Vertice;
import util.Grafo;
import view.TelaPrincipal;

/**
 *
 * @author Mariana Lima
 */
public class RVController {

    private final List<Veiculos> veiculos;
    private Grafo grafo;
    private final Rotas rota;
    
    public RVController() {
        this.lerArquivoBinario();
        veiculos = new ArrayList<>();
        rota = new Rotas(grafo);
        TelaPrincipal tela = new TelaPrincipal(this);
        tela.pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        tela.setSize(new Dimension(450, 450));
        tela.setLocation((screenSize.width-450)/2, (screenSize.height-450)/2);
        tela.setVisible(true);
    }

    public Rotas getRota() {
        return rota;
    }

    /**
     * Adiciona um veiculo a lista de veiculos sempre que a classe
     * CadastroVeiculos receber uma solicitação do usuario, chamando esse método
     * do controller.
     *
     * @param v
     */
    public void addVeiculos(Veiculos v) {
        veiculos.add(v);
    }

    public List<Veiculos> getVeiculos() {
        return veiculos;
    }

    /**
     * Classe que ler o arquivo e salva as informações no grafo
     *
     * 
     */
    public void lerArquivoBinario() {
        try {
            grafo = new LeituraArquivo("Mapa-Westeros.txt", grafo).lerArquivoBinario();
        } catch (IOException ex) {
            Logger.getLogger(RVController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void lerArquivoTexto(String file) {
        try {
            new LeituraArquivo(file, grafo).lerArquivoTexto();
        } catch (IOException ex) {
            Logger.getLogger(RVController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * chama o método menorCaminho da classe rota
     *
     * @param cidadesSelecionadas
     */
    public void MenorCaminho(List<Vertice> cidadesSelecionadas) {
        rota.MenorCaminho(cidadesSelecionadas);
    }

    /**
     * Classe que escreve arquivo de saida com as informacoes da rota,
     * detalhando o trajeto, consumo total de combustivel e distancia
     * percorrida.
     */
    public void arquivoSaida() {

        try {
            File file = new File("arquivoSaida.txt");
            try (FileWriter arquivoSaida = new FileWriter(file, true)) {
                arquivoSaida.write("Rota do menor caminho entre as cidades escolhidas: \n\n");
                Vertice v;
                
                //Escreve no arquivo a rota de ida de entrega nas cidades
                for (int i = 0; i < rota.getLista_de_rota().size() - 1; i++) {
                    for (int j = 0; j < rota.getLista_de_rota().get(i).size(); j++) {
                        v = rota.getLista_de_rota().get(i).get(j);
                        arquivoSaida.write(v.getId() + "; ");
                    }
                }
                
                arquivoSaida.write("\n\nRota do menor caminho de volta: (Considerando que não há mais nenhuma entrega)\n\n");
                // pegando a ultima posição da lista geral em que está a lista do menor caminho de volta
                int t = rota.getLista_de_rota().size() - 1; 
                
                //Escreve a rota do caminho de volta, verificando a distancia entre a cidade origem e a cidade destino
                for (int j = rota.getLista_de_rota().get(t).size() - 1; j >= 0; j--) {
                    v = (Vertice) rota.getLista_de_rota().get(t).get(j);
                    arquivoSaida.write(v.getId() + "; ");
                }
                arquivoSaida.write("Distancia percorrida: "+rota.getDistancia()+"\n");
                arquivoSaida.close();
            }
        } catch (IOException ex) { //caso nao seja possivel abrir algum dos arquivos
            System.out.println("Não foi possivel abrir arquivo");
        }
    }
    
    public List<Vertice> getCidades() {
        return grafo.getVertices();
    }
}
