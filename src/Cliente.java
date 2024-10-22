public class Cliente {

    private String cpf;
    private String nome;

    public Cliente (String cpf, String nome){
        this.nome = nome;
        this.cpf = cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }

}
