package br.edu.up.Modelos;

public class Endereco {

    private String rua;
    private String cidade;
    private int codPessoa;

   
    

    public Endereco(String rua, String cidade, int codPessoa) {
        this.codPessoa = codPessoa;        
        this.rua = rua;
        this.cidade = cidade;
        
    }

    

    public String GetRua(){return rua;}
 
    public String GetCidade(){return cidade;}
 
    public int GetCodPessoa(){return codPessoa;}
    
    public void SetRua(String rua){this.rua= rua;}
    
    
    public void SetCidade(String cidade){this.cidade= cidade;}
    
    public void SetCodPessoa(int codPessoa){this.codPessoa= codPessoa;}


}
