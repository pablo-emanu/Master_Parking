import java.util.ArrayList;

public class PersistenciaBdCarros implements PersistenciaCarro {

    private ArrayList<Carro> tabelaCarro = new ArrayList<>();

    @Override
    public void salvar(Carro carro) {
        tabelaCarro.add(carro);
    }

    @Override
    public void removerPorPlaca(String placa){
        Carro c = this.buscarPorPlaca(placa.toUpperCase());
        if(c == null){
            System.out.println("Carro de placa "+placa.toUpperCase()+" inexistente");
        } else {
            tabelaCarro.remove(c);
            System.out.println("Carro removido");
        }
    }

    @Override
    public void removerPorModelo(String modelo) {
        Carro c = this.buscarPorModelo(modelo.toUpperCase());
        if(c == null){
            System.out.println("Carro de inexistente");
        } else {
            tabelaCarro.remove(c);
            System.out.println("Carro removido");
        }
    }

    @Override
    public Carro buscarPorPlaca(String placa) {
        Carro tmp;
        for(int i = 0; i < tabelaCarro.size(); i++){
            tmp = tabelaCarro.get(i);
            if(tmp.getPlaca().equals(placa.toUpperCase())){
                return tmp;
            }
        }
        return null;
    }

    @Override
    public Carro buscarPorModelo(String modelo) {
        Carro tmp;
        for(int i = 0; i < tabelaCarro.size(); i++){
            tmp = tabelaCarro.get(i);
            if(tmp.getModelo().equals(modelo.toUpperCase())){
                return tmp;
            }
        }
        return null;
    }

    @Override
    public String atualizar(Carro carro, String placa) {
        Carro tmp = this.buscarPorPlaca(placa.toUpperCase());

        if(tmp == null){
            return "Carro inexistente";
        } else {
            tabelaCarro.remove(tmp);
            tabelaCarro.add(carro);
            return carro.toString();
        }

    }
}
