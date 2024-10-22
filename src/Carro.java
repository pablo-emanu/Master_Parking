public class Carro {

    private String placa;
    private String modelo;

    public Carro(String placa, String modelo){
        this.placa = placa;
        this.modelo = modelo;
    }

    public void setPlaca(String placa){
        this.placa = placa;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public String getPlaca(){
        return this.placa;
    }

    public String getModelo(){
        return this.modelo;
    }
}

