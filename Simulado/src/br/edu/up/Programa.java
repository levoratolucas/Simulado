package br.edu.up;


import java.io.IOException;

import br.edu.up.Controller.PessoaControler;


public class Programa {

    public static void main(String[] args) throws IOException {
        PessoaControler pessoaControler;
        pessoaControler = new PessoaControler();
        pessoaControler.Mesclar();
    }
}
