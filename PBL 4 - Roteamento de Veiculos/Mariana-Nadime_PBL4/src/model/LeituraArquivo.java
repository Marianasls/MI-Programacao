/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Nadine
 */
public class LeituraArquivo {

    private String nome;

    public LeituraArquivo(String nome) {
        this.nome = nome;
    }

    public void lerArquivo() throws FileNotFoundException, IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(nome));
        String str;
        while ((str = buffRead.readLine()) != null) {
            String array[] = str.split(";");
            int posXCidadeOrigem = Integer.parseInt(array[3]);
            int posYCidadeOrigem = Integer.parseInt(array[4]);
            Cidade origem = new Cidade(array[0], posXCidadeOrigem, posYCidadeOrigem);
            int posXCidadeDestino = Integer.parseInt(array[5]);
            int posYCidadeDestino = Integer.parseInt(array[6]);
            Cidade destino = new Cidade(array[1], posXCidadeDestino, posYCidadeDestino);
        }
    }
}
