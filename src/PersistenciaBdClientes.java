import java.util.ArrayList;

public class PersistenciaBdClientes implements PersistenciaCliente {

    private ArrayList<Cliente> tabelaCliente = new ArrayList<>();

    @Override
    public void salvar(Cliente cliente) {
        tabelaCliente.add(cliente);
    }

    @Override
    public String removerPorCpf(String cpf) {
        Cliente c = this.buscarPorCpf(cpf);

        if(c == null){
            return "Cliente inexistente";
        } else {
            tabelaCliente.remove(c);
            return "Cliente: "+ c.getNome() +" Removido";
        }

    }

    @Override
    public Cliente buscarPorCpf(String cpf) {
        Cliente tmp;
        for(int i = 0; i < tabelaCliente.size(); i++){
            tmp = tabelaCliente.get(i);
            if(tmp.getCpf().equals(cpf)){
                return tmp;
            }
        }
        return null;
    }

    @Override
    public void atualizar(Cliente cliente, String cpf) {
        Cliente c = this.buscarPorCpf(cpf);

        if(c == null){
            System.out.println("Cliente inexistente");
        } else {
            tabelaCliente.remove(c);
            tabelaCliente.add(cliente);
        }
    }
}
