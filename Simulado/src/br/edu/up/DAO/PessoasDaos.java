package br.edu.up.DAO;

import br.edu.up.Modelos.Endereco;
import br.edu.up.Modelos.Pessoas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoasDaos {
    private String arquivoA;
    private String arquivoB;
    private String arquivoC;

    public PessoasDaos(String arquivoA, String arquivoB, String arquivoC) {
        this.arquivoA = "./dbbanco/" + arquivoA;
        this.arquivoB = "./dbbanco/" + arquivoB;
        this.arquivoC = "./dbbanco/" + arquivoC;
    }

    public List<Endereco> lerEnderecos() throws IOException {
        List<Endereco> enderecos = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(arquivoB));
        String linha;

        while ((linha = br.readLine()) != null) {
            if (linha.startsWith("cod"))
                continue;

            String[] dados = linha.split(";");
            String rua = dados[0];
            String cidade = dados[1];
            int codPessoa = Integer.parseInt(dados[2]);
            Endereco endereco = new Endereco(rua, cidade, codPessoa);
            enderecos.add(endereco);
        }
        br.close();
        return enderecos;
    }

    public List<Pessoas> lerPessoas() throws IOException {
        List<Pessoas> pessoas = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(arquivoA));
        String linha;

        while ((linha = br.readLine()) != null) {
            if (linha.startsWith("cod"))
                continue;

            String[] dados = linha.split(";");
            int cod = Integer.parseInt(dados[0]);
            String nome = dados[1];
            Pessoas pessoa = new Pessoas(cod, nome);
            pessoas.add(pessoa);
        }
        br.close();
        return pessoas;
    }

    public void salvarPessoas(List<Pessoas> pessoas) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoC));
        bw.write("cod;nome;rua;cidade\n");
        for (Pessoas pessoa : pessoas) {
            bw.write(pessoa.ToCSV() + "\n");
        }
        bw.close();
    }
}
