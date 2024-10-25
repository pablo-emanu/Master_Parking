public class Vaga {

    private int numVaga;
    private boolean ocupada;
    private Carro carro;

    public Vaga (int numVaga, boolean ocupada, Carro carro){
        this.numVaga = numVaga;
        this.ocupada = ocupada;
        this.carro = carro;
    }

    public int getNumVaga (){
        return this.numVaga;
    }

    public boolean getOcupada(){
        return this.ocupada;
    }

    public void setNumVaga(int numVaga){
        this.numVaga = numVaga;
    }

    public void setOcupada(boolean ocupada){
        this.ocupada = ocupada;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    @Override
    public String toString() {
        return "Vaga numero: "+ this.numVaga +"\nA vaga esta "+ this.ocupada +
                "\nPelo carro "+ this.carro;
    }
}
