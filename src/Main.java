import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //PersistenciaBdCarros pbdc = new PersistenciaBdCarros();
        //PersistenciaBdVagas pbdv = new PersistenciaBdVagas();
        //PersistenciaBdClientes pbdcl = new PersistenciaBdClientes();

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
                                "\n[4] - Exibir Veiculos" +
                                "\n[5] - Voltar");
                        opMenu = scan.nextInt();

                        scan.nextLine();

                        switch (opMenu) {
                            case 1:
                                Cliente cl1 = new Cliente("", "");
                                System.out.println("Digite o CPF do cliente");
                                respostaUsuario = scan.next();
                                cl1.setCpf(respostaUsuario);

                                scan.nextLine();

                                System.out.println("Digite o nome do cliente");
                                respostaUsuario = scan.nextLine();
                                cl1.setNome(respostaUsuario);

                                //pbdcl.salvar(cl1);
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

                                //pbdc.salvar(c1);
                                break;
                            case 3:
                                Vaga v1 = new Vaga(false, null);
                                System.out.println("Digite o numero da vaga que deseja registrar");
                                numUsuario = scan.nextInt();
                                v1.setNumVaga(numUsuario);
                                //limpando buffer
                                scan.nextLine();

                                System.out.println("Essa vaga esta ocupada?");
                                respostaUsuario = scan.next().toLowerCase();
                                //limpando buffer
                                scan.nextLine();

                                if(respostaUsuario.equals("sim")){
                                    v1.setEstado(null);
                                    System.out.println("Qual carro está ocupando ela?");
                                    respostaUsuario = scan.nextLine();
                                    if(true){
                                        System.out.println("Esse carro nao esta registrado no sistema");
                                        break;
                                    } else {
                                       System.out.println("\nInserido na vaga: "+ numUsuario);


                                        break;
                                    }
                                } else {

                                }
                                break;
                            case 4:
                                System.out.println("# Imprimindo Vagas #");
                                //pbdv.imprimirVagas();
                                break;
                            case 5:
                                System.out.println("# Voltando para o menu Inicial #");
                                break;
                            default:
                                System.out.println("## OPCAO INVALIDA ##");
                                break;
                        }
                    } while (opMenu != 5);
                    break;
                case 2:
                    do {
                        System.out.println("# ATUALIZACAO #" +
                                "\n[1] - Vaga" +
                                "\n[2] - Carro" +
                                "\n[3] - Sair");
                        opMenu = scan.nextInt();

                        scan.nextLine();
                        switch (opMenu) {
                            case 1:
                                System.out.println("Qual o numero da vaga que deseja atualizar?");
                                numUsuario = scan.nextInt();
                                //limpando buffer
                                scan.nextLine();

                                if(true){
                                    System.out.println("vaga inexistente");
                                    break;
                                } else {
                                    Carro c1 = new Carro("","", 0);
                                    System.out.println("Vaga: "+numUsuario+"\nocupada pelo"+

                                                       "\nDeseja sobstituir por qual modelo?");
                                    respostaUsuario = scan.nextLine();

                                    c1.setModelo(respostaUsuario);

                                    System.out.println("Qual a placa do veiculo?");
                                    respostaUsuario = scan.next();
                                    //limpando buffer
                                    scan.nextLine();

                                    c1.setPlaca(respostaUsuario);


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
