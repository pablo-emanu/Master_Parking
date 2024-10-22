public class Vaga {

    private int numVaga;
    private boolean ocupada;

    public Vaga (int numVaga, boolean ocupada){
        this.numVaga = numVaga;
        this.ocupada = ocupada;
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
}
