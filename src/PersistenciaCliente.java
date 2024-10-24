public interface PersistenciaCliente {

    public void salvar(Cliente cliente);
    public String removerPorCpf(String cpf);
    public Cliente buscarPorCpf(String cpf);
    public void atualizar(Cliente cliente, String cpf);

}
