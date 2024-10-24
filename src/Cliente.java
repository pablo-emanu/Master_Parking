public class Cliente {

    private String cpf;
    private String nome;

    public Cliente (String cpf, String nome){
        this.nome = nome.toUpperCase();
        this.cpf = cpf.toUpperCase();
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

    @Override
    public String toString() {
        return "Cliente: "+ this.nome +" CPF: "+ this.cpf;
    }
}
