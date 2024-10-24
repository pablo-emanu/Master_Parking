public interface PersistenciaCarro {

    public void salvar(Carro carro);
    public void removerPorPlaca(String placa);
    public void removerPorModelo(String modelo);
    public Carro buscarPorPlaca(String placa);
    public Carro buscarPorModelo(String modelo);
    public String atualizar(Carro carro, String placa);

}
