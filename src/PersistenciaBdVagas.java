import java.util.ArrayList;

public class PersistenciaBdVagas implements PersistenciaVaga {

    private ArrayList<Vaga> tabelaVaga = new ArrayList<>();

    @Override
    public void salvarVaga(Vaga vaga) {
        tabelaVaga.add(vaga);
    }

    @Override
    public String atualizarVaga(Carro carro, int numVaga) {
        Vaga tmp = this.buscarPorNumVaga(numVaga);
        if(tmp == null){
            return "Vaga inexistente";
        } else {
            tabelaVaga.remove(tmp.getCarro());
            tmp.setCarro(carro);
            tmp.setOcupada(true);
            return tmp.toString();
        }
    }

    @Override
    public String removerCarro(int numVaga) {
        Vaga tmp = this.buscarPorNumVaga(numVaga);
        if(tmp == null){
            return "Vaga inexistente";
        } else {
            tabelaVaga.remove(tmp.getCarro());
            return tmp.toString();
        }
    }

    @Override
    public Vaga buscarPorNumVaga(int numVaga) {
        Vaga tmp;
        for(int i = 0; i < tabelaVaga.size(); i++){
            tmp = tabelaVaga.get(i);
            if(tmp.getNumVaga() == numVaga){
                return tmp;
            }
        }
        return null;
    }

    @Override
    public Vaga buscarPorCarro(String modelo) {
        Vaga tmp;
        for(int i = 0; i < tabelaVaga.size(); i++){
            tmp = tabelaVaga.get(i);
            if(tmp.getCarro().getModelo().equals(modelo.toUpperCase())){
                return tmp;
            }
        }
        return null;
    }
}
