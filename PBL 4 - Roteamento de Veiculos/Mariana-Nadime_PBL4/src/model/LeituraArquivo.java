/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Grafo;

/**
 *
 * @author Nadine
 */
public class LeituraArquivo {
    private Grafo grafo;
    private String nome;

    public LeituraArquivo(String nome) {
        this.nome = nome;
    }
    
    public LeituraArquivo(String nome, Grafo grafo){
        this.nome = nome;
        this.grafo = grafo;
    }

    /**
     * Ler informações do arquivo binario e salva as cidades e caminhos na estrutura do grafo 
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void lerArquivoBinario() throws FileNotFoundException, IOException {
        ObjectInputStream b = new ObjectInputStream(new FileInputStream(new File(nome)));
        //Lendo o arquivo com o objeto serializado
        try {
            grafo = (Grafo)b.readObject();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LeituraArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Ler informações do arquivo de texto e salva no grafo os vertices e arestas 
     * correspondentes.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void lerArquivoTexto() throws FileNotFoundException, IOException{
        BufferedReader buffRead = new BufferedReader(new FileReader(nome));
        String str;
        while ((str = buffRead.readLine()) != null) {
            String array[] = str.split(";");
            int posXCidadeOrigem = Integer.parseInt(array[3].trim());
            int posYCidadeOrigem = Integer.parseInt(array[4].trim());
            int posXCidadeDestino = Integer.parseInt(array[5].trim());
            int posYCidadeDestino = Integer.parseInt(array[6].trim());
            double distancia = Double.valueOf(array[2]);
            grafo.adicionarAresta(grafo.adicionarVertice(array[0], posXCidadeOrigem, posYCidadeOrigem),
                    grafo.adicionarVertice(array[1], posXCidadeDestino, posYCidadeDestino), distancia);
        }
    }
    
}
