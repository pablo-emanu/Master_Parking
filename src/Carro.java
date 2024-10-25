public class Carro {

    private String placa;
    private String modelo;

    public Carro(String placa, String modelo){
        this.placa = placa.toUpperCase();
        this.modelo = modelo.toUpperCase();
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

    @Override
    public String toString() {
        return this.modelo +" Placa: "+ this.placa;
    }
}

