import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PersistenciaBdCarros pbdc = new PersistenciaBdCarros();
        PersistenciaBdVagas pbdv = new PersistenciaBdVagas();
        PersistenciaBdClientes pbdcl = new PersistenciaBdClientes();

        int opcaoMenu = 0;
        String respostaUsuario = null;
        String id = null;
        int numUsuario = 0;

        do {
            System.out.println("\n[1] - Registrar" +
                    "\n[2] - Atualizar" +
                    "\n[0] - Finalizar Software");
            opcaoMenu = scan.nextInt();
            switch (opcaoMenu) {
                case 1:
                    int opMenu = 0;
                    do {
                        System.out.println("# REGISTRO #" +
                                "\n[1] - Cliente" +
                                "\n[2] - Carro" +
                                "\n[3] - Vaga" +
                                "\n[4] - Sair");
                        opMenu = scan.nextInt();
                        switch (opMenu) {
                            case 1:
                                Cliente cl1 = new Cliente("", "");
                                System.out.println("Digite o CPF do cliente");
                                respostaUsuario = scan.next();
                                cl1.setCpf(respostaUsuario);

                                System.out.println("Digite o nome do cliente");
                                respostaUsuario = scan.nextLine();
                                respostaUsuario = scan.nextLine();
                                cl1.setNome(respostaUsuario);

                                pbdcl.salvar(cl1);
                                break;
                            case 2:
                                Carro c1 = new Carro("", "");
                                System.out.println("Digite a placa do carro");
                                id = scan.next();
                                c1.setPlaca(id);

                                System.out.println("Digite o modelo do carro");
                                scan.next();
                                respostaUsuario = scan.nextLine();
                                c1.setModelo(respostaUsuario);

                                pbdc.salvar(c1);
                                break;
                            case 3:
                                Vaga v1 = new Vaga(0, false, null);
                                System.out.println("Digite o numero da vaga que deseja registrar");
                                numUsuario = scan.nextInt();
                                v1.setNumVaga(numUsuario);

                                System.out.println("Essa vaga esta ocupada?");
                                respostaUsuario = scan.next().toLowerCase();

                                if(respostaUsuario.equals("sim")){
                                    v1.setOcupada(true);
                                    System.out.println("Qual carro está ocupando ela?");
                                    respostaUsuario = scan.nextLine();
                                    respostaUsuario = scan.nextLine();
                                    System.out.println(respostaUsuario);
                                    if(pbdc.buscarPorModelo(respostaUsuario) == null){
                                        System.out.println("Esse carro nao esta registrado no sistema");
                                        break;
                                    } else {
                                        System.out.println(respostaUsuario+ " Inserido na vaga "+ numUsuario);
                                        v1.setCarro(pbdc.buscarPorModelo(respostaUsuario));
                                        pbdv.salvarVaga(v1);
                                        break;
                                    }
                                } else {
                                    v1.setCarro(null);
                                    v1.setOcupada(false);
                                    pbdv.salvarVaga(v1);
                                }
                                break;
                            case 4:
                                System.out.println("# Voltando para o menu Inicial #");
                                break;
                            default:
                                System.out.println("## OPCAO INVALIDA ##");
                                break;
                        }
                    } while (opMenu != 4);
                    break;
                case 2:
                    do {
                        System.out.println("# ATUALIZACAO #" +
                                "\n[1] - Vaga" +
                                "\n[2] - Carro" +
                                "\n[3] - Sair");
                        opMenu = scan.nextInt();
                        switch (opMenu) {
                            case 1:
                                System.out.println("Qual o numero da vaga que deseja atualizar?");
                                numUsuario = scan.nextInt();

                                if(pbdv.buscarPorNumVaga(numUsuario) == null){
                                    System.out.println("vaga inexistente");
                                    break;
                                } else {
                                    Carro c2 = new Carro("","");
                                    System.out.println("Vaga: "+numUsuario+"\nocupada pelo"+
                                                        pbdc.buscarPorPlaca(id) +
                                                       "\nDeseja sobstituir por qual modelo?");
                                    respostaUsuario = scan.nextLine();
                                    c2.setModelo(respostaUsuario);

                                    System.out.println("Qual a placa do veiculo?");
                                    respostaUsuario = scan.next();
                                    c2.setPlaca(respostaUsuario);

                                    pbdv.atualizarVaga(c2, numUsuario);
                                }
                                break;
                            case 2:
                                System.out.println("Digite a placa do carro que voce deseja ");


                                break;
                            case 3:
                                System.out.println("# Voltando ao menu inicial #");

                            default:
                                System.out.println("## OPCAO INVALIDA ##");
                                break;
                        }
                    } while (opcaoMenu != 3);
            }
        } while (opcaoMenu != 0);
    }
}
