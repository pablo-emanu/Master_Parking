public interface Persistencia {

    public void salvar(Cliente cliente);
    public void removerPorCpf(String cpf);
    public Cliente buscarPorCpf(String cpf);
    public void atualizar(Cliente cliente, String cpf);

}
