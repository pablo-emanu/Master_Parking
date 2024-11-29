public class Carro {

    private  int id;
    private String placa;
    private String modelo;
    private int idCliente;

    public Carro(String placa, String modelo, int idCliente){
        this.placa = placa.toUpperCase();
        this.modelo = modelo.toUpperCase();
        this.idCliente = idCliente;
    }

    public void setPlaca(String placa){
        this.placa = placa.toUpperCase();
    }

    public void setModelo(String modelo){
        this.modelo = modelo.toUpperCase();
    }

    public String getPlaca(){
        return this.placa;
    }

    public String getModelo(){
        return this.modelo;
    }

    public int getIdCliente(){
        return this.idCliente;
    }

    public void setIdCliente(int idCliente){
        this.idCliente = idCliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Carro: " +this.modelo +" Placa: "+ this.placa;
    }

}

