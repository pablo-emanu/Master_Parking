public class Vaga {

    private int numVaga;
    private boolean estado;
    private String placaCarro;

    public Vaga (boolean estado, String placaCarro){
        this.estado = estado;
        this.placaCarro = placaCarro;
    }

    public int getNumVaga (){
        return this.numVaga;
    }

    public Boolean getEstado(){
        return this.estado;
    }

    public void setNumVaga(int numVaga){
        this.numVaga = numVaga;
    }

    public void setEstado(Boolean estado){
        this.estado = estado;
    }

    public String getPlacaCarro() {
        return placaCarro;
    }

    public void setPlacaCarro(String placaCarro) {
        this.placaCarro = placaCarro;
    }

    @Override
    public String toString() {
        if(this.estado == true){
            return "Vaga: "+ this.numVaga + "\nVaga: Ocupada" +"\nPlaca do veiculo: "+ this.placaCarro;
        } else {
            return "Vaga: "+ this.numVaga + "\nVaga: Vazia";
        }
    }
}
