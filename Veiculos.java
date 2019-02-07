/*******************************************************************************
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: <Mariana Lima>
 * Data:  <04/12/2018>
 *
 * Declaro que este código foi elaborado por mim de forma individual e não
 * contém nenhum trecho de código de outro colega ou de outro autor, tais como
 * provindos de livros e apostilas, e páginas ou documentos eletrônicos da
 * Internet. Qualquer trecho de código de outra autoria que uma citação para o
 * não a minha está destacado com autor e a fonte do código, e estou ciente que
 * estes trechos não serão considerados para fins de avaliação. Alguns trechos
 * do código podem coincidir com de outros colegas pois estes foram discutidos
 * em sessões tutorias.
*******************************************************************************/
package model;

/**
 * Classe que armazena os dados de um Veiculo
 * @author Mariana Lima
 * @author Nadime
 */
public class Veiculos {
    private String nome;
    private String tipoCombustivel;
    private double precoCombustivel;
    private double consumo;

    public Veiculos (String nome, String tipoC, double precoC, double c){
        this.nome = nome;
        this.consumo = c;
        this.tipoCombustivel = tipoC;
        this.precoCombustivel = precoC;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public double getPrecoCombustivel() {
        return precoCombustivel;
    }

    public void setPrecoCombustivel(double precoCombustivel) {
        this.precoCombustivel = precoCombustivel;
    }
    
    
    
}
