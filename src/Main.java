public class Main {

    public static void main (String [] args){

        Carro c1 = new Carro("45b3-e45", "celta");
        Carro c2 = new Carro("23r4-76p", "Hillux");
        Carro c3 = new Carro("87br-67u", "Civic");
        Carro c4 = new Carro("34hb-129", "S10");

        Cliente cl1 = new Cliente("463.166.868-90", "Pablo");
        Cliente cl2 = new Cliente("187.703.238-09", "Massavi");
        Cliente cl3 = new Cliente("738.519.642-87", "Abner");

        PersistenciaBdCarros pbdc = new PersistenciaBdCarros();
        PersistenciaEmColecao pec = new PersistenciaEmColecao();

        pec.salvar(cl1);
        pec.salvar(cl2);
        pec.salvar(cl3);

        pbdc.salvar(c1);
        pbdc.salvar(c2);
        pbdc.salvar(c3);

        pbdc.removerPorModelo("");
        pbdc.removerPorPlaca("613h-6bf");

        System.out.println(pec.buscarPorCpf("463.166.868-90")+"\n"+
                           pec.removerPorCpf("738.519.642-87"));

        System.out.println(pbdc.buscarPorPlaca("45B3-E45")+"\n"+
                           pbdc.buscarPorModelo("ciVIC")+"\n"+
                           pbdc.buscarPorPlaca("23R4-76p"));

        System.out.println(pbdc.atualizar(c4, "87br-67u"));

    }
}
