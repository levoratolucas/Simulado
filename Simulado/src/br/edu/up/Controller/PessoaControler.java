package br.edu.up.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.up.DAO.PessoasDaos;
import br.edu.up.Modelos.Endereco;
import br.edu.up.Modelos.Pessoas;

public class PessoaControler {

    private PessoasDaos pessoasDaos;

    public PessoaControler() {
        this.pessoasDaos = new PessoasDaos("Pessoas.csv", "Enderecos.csv", "PessoasComEndereco.csv");
    }

    public void Mesclar() throws IOException {
        List<Pessoas> pessoas = pessoasDaos.lerPessoas();
        List<Endereco> enderecos = pessoasDaos.lerEnderecos();
        
        List<Pessoas> pessoasComEndereco = new ArrayList<>();
    
        enderecos.forEach(endereco -> {
            pessoas.stream()
                    .filter(pessoa -> pessoa.GetCod() == endereco.GetCodPessoa())
                    .findFirst()
                    .ifPresent(pessoa -> {
                        Pessoas pessoaComEndereco = new Pessoas(pessoa.GetCod(), pessoa.GetNome());
                        pessoaComEndereco.SetRua(endereco.GetRua());
                        pessoaComEndereco.SetCidade(endereco.GetCidade());
                        pessoasComEndereco.add(pessoaComEndereco);
                    });
        });
    
        pessoasDaos.salvarPessoas(pessoasComEndereco);
    }
    
}
