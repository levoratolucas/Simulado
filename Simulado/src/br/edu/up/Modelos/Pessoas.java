package br.edu.up.Modelos;

public class Pessoas {

    private int cod;
    private String  nome;
    private String rua;
    private String cidade;
   
    

    public Pessoas(int cod, String nome) {
        this.cod = cod;
        this.nome = nome;
        
    }

   public String GetNome(){return nome;}

   public String GetRua(){return rua;}

   public String GetCidade(){return cidade;}

   public int GetCod(){return cod;}
   
   
   public void SetCod(int cod){this.cod= cod;}
   
   public void SetNome(String nome){this.nome= nome;}
   
   public void SetCidade(String cidade){this.cidade= cidade;}
   
   public void SetRua(String rua){this.rua= rua;}

   public String ToCSV(){
    return cod + ";" + nome + ";" + rua + ";" + cidade;
   }



}