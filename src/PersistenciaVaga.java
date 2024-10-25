public interface PersistenciaVaga {

    public void salvarVaga(Vaga vaga);
    public String atualizarVaga(Carro carro, int numVaga);
    public String removerCarro(int numVaga);
    public Vaga buscarPorNumVaga(int numVaga);
    public Vaga buscarPorCarro(String modelo);


}
