import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CarroDAO DBCarro = new CarroDAO();
        VagaDAO DBVaga = new VagaDAO();
        ClienteDAO DBCliente = new ClienteDAO();

        int opcaoMenu = 0;
        String respostaUsuario = null;
        String id = null;
        int numUsuario = 0;

        do {
            System.out.println("# MENU PRINCIPAL #");
            System.out.println("\n[1] - Registrar" +
                    "\n[2] - Atualizar" +
                    "\n[3] - Deletar" +
                    "\n[4] - Listar" +
                    "\n[0] - Finalizar Software");
            opcaoMenu = scan.nextInt();

            scan.nextLine();
            switch (opcaoMenu) {
                case 1:
                    int opMenu = 0;
                    do {
                        System.out.println("# REGISTRO #" +
                                "\n[1] - Cliente" +
                                "\n[2] - Carro" +
                                "\n[3] - Vaga" +
                                "\n[5] - Voltar");
                        opMenu = scan.nextInt();

                        scan.nextLine();

                        switch (opMenu) {
                            case 1:
                                Cliente cl1 = new Cliente("","");
                                System.out.println("Digite o CPF do cliente");
                                respostaUsuario = scan.next();
                                cl1.setCpf(respostaUsuario);

                                scan.nextLine();

                                System.out.println("Digite o nome do cliente");
                                respostaUsuario = scan.nextLine();
                                cl1.setNome(respostaUsuario);


                                DBCliente.salvar(cl1);
                                System.out.println("Cliente salvo");
                                break;
                            case 2:
                                Carro c1 = new Carro("", "", 0);
                                System.out.println("Digite a placa do carro");
                                id = scan.next();
                                c1.setPlaca(id);
                                //limpando buffer
                                scan.nextLine();

                                System.out.println("Digite o modelo do carro");
                                respostaUsuario = scan.nextLine();
                                c1.setModelo(respostaUsuario);

                                System.out.println("Digite o ID do Cliente dono");
                                numUsuario = scan.nextInt();
                                c1.setIdCliente(numUsuario);

                                DBCarro.salvar(c1);
                                System.out.println("Carro salvo");
                                break;
                            case 3:
                                Vaga v1 = new Vaga(false, null);

                                System.out.println("Essa vaga esta ocupada?");
                                respostaUsuario = scan.next().toLowerCase();
                                //limpando buffer
                                scan.nextLine();

                                if (respostaUsuario.equals("sim")) {
                                    v1.setEstado(true);
                                    System.out.println("Digite a placa do veículo que está ocupando a vaga");
                                    respostaUsuario = scan.nextLine();
                                    if (DBCarro.buscarPorPlaca(respostaUsuario) != null) {
                                        v1.setPlacaCarro(respostaUsuario);
                                        DBVaga.salvar(v1);
                                        System.out.println("Vaga Salva");
                                    } else {
                                        System.out.println("Carro não encontrado no sistema.");
                                    }
                                } else {
                                    System.out.println("Salvando vaga vazia");
                                    DBVaga.salvar(v1);
                                }
                                break;
                            case 5:
                                System.out.println("Voltando ao menu Principal");
                                break;
                            default:
                                System.out.println("# Opcao invalida #");
                        }
                    }while(opMenu != 5);
                    break;
                case 2:
                    do {
                        System.out.println("# ATUALIZACAO #" +
                                    "\n[1] - Cliente"+
                                    "\n[2] - Carro" +
                                    "\n[3] - Vaga" +
                                    "\n[5] - Sair");
                            opMenu = scan.nextInt();

                            scan.nextLine();
                            switch (opMenu) {
                                case 1:
                                    System.out.println("Digite o CPF do cliente que deseja atualizar");
                                    respostaUsuario = scan.nextLine();

                                    scan.nextLine();

                                    if (DBCliente.buscarPorCPF(respostaUsuario) != null) {
                                        Cliente cl1 = DBCliente.buscarPorCPF(respostaUsuario);

                                        System.out.println("Digite o novo nome");
                                        respostaUsuario = scan.nextLine();
                                        cl1.setNome(respostaUsuario);

                                        //Limpando Buffer
                                        scan.nextLine();

                                        System.out.println("Digite o novo CPF");
                                        respostaUsuario = scan.next();
                                        cl1.setCpf(respostaUsuario);

                                        //limpando buffer
                                        scan.nextLine();

                                        DBCliente.atualizar(cl1);
                                    } else {
                                        System.out.println("Cliente nao encontrado");
                                    }
                                    break;
                                case 2:
                                    System.out.println("Digite a placa do carro que voce deseja atualizar");
                                        respostaUsuario = scan.nextLine();

                                        if(DBCarro.buscarPorPlaca(respostaUsuario) != null){
                                            Carro c1 = DBCarro.buscarPorPlaca(respostaUsuario);

                                            System.out.println("Digite a nova placa");
                                            respostaUsuario = scan.nextLine();
                                            c1.setPlaca(respostaUsuario);

                                            scan.nextLine();

                                            System.out.println("Digite o novo modelo");
                                            respostaUsuario = scan.nextLine();
                                            c1.setModelo(respostaUsuario);

                                            scan.nextLine();

                                            DBCarro.atualizar(c1);
                                        } else {
                                            System.out.println("Carro nao encontrado");
                                        }
                                    break;
                                case 3:
                                    System.out.println("Digite o numero da vaga que deseja atualizar");
                                    numUsuario = scan.nextInt();

                                    scan.nextLine();

                                    if(DBVaga.buscarPorNumVaga(numUsuario) != null){
                                        Vaga v1 = DBVaga.buscarPorNumVaga(numUsuario);
                                        System.out.println("Vai remover ou adicionar/atualizar um carro novo na vaga?");
                                        respostaUsuario = scan.nextLine().toLowerCase();


                                        if(respostaUsuario.equals("adicionar")){
                                            v1.setEstado(true);

                                            System.out.println("Digite a placa do carro que ira ocupar a vaga");
                                            respostaUsuario = scan.nextLine();
                                            v1.setPlacaCarro(respostaUsuario);


                                            DBVaga.atualizar(v1);
                                            System.out.println("# ATUALIZADA #");
                                        } else {
                                            System.out.println("Esvaziando vaga");
                                            v1.setEstado(false);
                                            v1.setPlacaCarro(null);

                                            DBVaga.atualizar(v1);
                                            System.out.println("# ATUALIZADA #");
                                        }
                                    } else {
                                        System.out.println("Vaga nao encontrada.");
                                    }
                                    break;
                                case 5:
                                    System.out.println("# Retornando ao Menu Principal #");
                                    break;
                                default:
                                    System.out.println("## OPCAO INVALIDA ##");
                                    break;
                            }
                    }while (opMenu != 5);
                    break;
                case 3:
                    do{
                        System.out.println("# DELETAR #"+
                                        "\n[1] - Cliente"+
                                        "\n[2] - Carro"+
                                        "\n[3] - Vaga"+
                                        "\n[5] - Sair");
                        opcaoMenu = scan.nextInt();

                        scan.nextLine();

                        switch(opcaoMenu){
                            case 1:
                                System.out.println("Digite o CPF do cliente que deseja remover");
                                respostaUsuario = scan.nextLine();
                                

                                if(DBCliente.buscarPorCPF(respostaUsuario) != null){
                                    System.out.println("Cliente encontrado");
                                    DBCliente.deletar(respostaUsuario);
                                    System.out.println("Cliente deletado");
                                } else {
                                    System.out.println("Cliente nao encontrado");
                                }
                                break;
                            case 2:
                                System.out.println("Digite a placa do carro que deseja remover");
                                respostaUsuario = scan.nextLine();

                                if(DBCarro.buscarPorPlaca(respostaUsuario) != null){
                                    System.out.println("Carro encontrado");
                                    DBCarro.deletar(respostaUsuario);
                                    System.out.println("Carro deletado");
                                } else {
                                    System.out.println("Carro nao encontrado");
                                }
                                break;
                            case 3:
                                System.out.println("Digite o numero da vaga que deseja deletar");
                                numUsuario = scan.nextInt();

                                scan.nextLine();

                                if(DBVaga.buscarPorNumVaga(numUsuario) != null){
                                    System.out.println("Vaga encontrada");
                                    DBVaga.deletar(numUsuario);
                                    System.out.println("Vaga deletada");
                                } else {
                                    System.out.println("Vaga não encontrada");
                                }
                                break;
                            case 5:
                                System.out.println("# Retornando ao menu principal #");
                                break;
                            default:
                                System.out.println("# OPCAO INVALIDA #");
                                break;
                        }

                    }while(opcaoMenu != 5);
                    break;
                case 4:
                    do {
                        System.out.println("# Listar #"+
                                "\n[1] - Clientes"+
                                "\n[2] - Carros"+
                                "\n[3] - Vagas"+
                                "\n[5] - Sair");
                        opcaoMenu = scan.nextInt();

                        scan.nextLine();

                        switch (opcaoMenu){
                            case 1:
                                System.out.println("Listando clientes: ");
                                DBCliente.listarClientes();
                                break;
                            case 2:
                                System.out.println("Listando carros: ");
                                DBCarro.listarCarros();
                                break;
                            case 3:
                                System.out.println("Listando vagas: ");
                                DBVaga.listarVagas();
                                break;
                            case 5:
                                System.out.println("# Retornando ao menu principal #");
                                break;
                            default:
                                System.out.println("# OPCAO INVALIDA #");
                                break;
                        }
                    }while(opcaoMenu != 5);
                    break;
                case 0:
                    System.out.println("# ENCERRADO SOFTWARE #");

                default:
                    System.out.println("# OPCAO INVALIDA #");
            }
        } while (opcaoMenu != 0);
    }
}
