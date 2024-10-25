import java.util.Scanner;

public class Main {

    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);
        PersistenciaBdCarros pbdc = new PersistenciaBdCarros();
        PersistenciaBdVagas pbdv = new PersistenciaBdVagas();
        PersistenciaBdClientes pbdcl = new PersistenciaBdClientes();

        int opcaoMenu = 0;
        String respostaUsuario = null;
        int cont = 0;

        do{
            System.out.println("\n[1] - Registrar"+
                               "\n[2] - Atualizar"+
                               "\n[3] - Remover"+
                               "\n[0] - Finalizar Software");
            opcaoMenu = scan.nextInt();
            switch (opcaoMenu){
                case 1:
                    do{
                        System.out.println("# REGISTRO #"+
                                           "\n[1] - Cliente"+
                                           "\n[2] - Carro"+
                                           "\n[3] - Vaga"+
                                           "\n[4] - Sair");
                        opcaoMenu = scan.nextInt();
                        switch(opcaoMenu){
                            case 1:
                                Cliente cl1 = new Cliente("","");
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
                                Carro c1 = new Carro("","");
                                System.out.println("Digite a placa do carro");
                                respostaUsuario = scan.next();
                                c1.setPlaca(respostaUsuario);

                                System.out.println("Digite o modelo do carro");
                                respostaUsuario = scan.next();
                                c1.setModelo(respostaUsuario);

                                pbdc.salvar(c1);
                                break;
                            case 3:
                                Vaga v1 = new Vaga(cont++, false, null);
                                System.out.println("A vaga está ocupada?");
                                respostaUsuario = scan.next().toLowerCase();

                                if(respostaUsuario.equals("sim")){
                                    v1.setOcupada(true);
                                    System.out.println("Qual o carro que está ocupando ela?");
                                    respostaUsuario = scan.next();
                                    v1.setCarro(pbdc.buscarPorModelo(respostaUsuario));
                                }
                                break;
                            case 4:
                                System.out.println("# Voltando pro menu Inicial #");
                                break;
                            default:
                                System.out.println("## OPCAO INVALIDA ##");
                                break;
                        }
                    }while(opcaoMenu != 4);
                case 2:
                    do{
                        System.out.println("\n[1] - Cliente"+
                                "\n[2] - Carro"+
                                "\n[3] - Vaga"+
                                "\n[4] - Sair");
                        opcaoMenu = scan.nextInt();
                        switch(opcaoMenu){
                            case 1:
                                Cliente cl1 = new Cliente("","");
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
                                Carro c1 = new Carro("","");
                                System.out.println("Digite a placa do carro");
                                respostaUsuario = scan.next();
                                c1.setPlaca(respostaUsuario);

                                System.out.println("Digite o modelo do carro");
                                respostaUsuario = scan.next();
                                c1.setModelo(respostaUsuario);

                                pbdc.salvar(c1);
                                break;
                            case 3:
                                Vaga v1 = new Vaga(cont++, false, null);
                                System.out.println("A vaga está ocupada?");
                                respostaUsuario = scan.next().toLowerCase();

                                if(respostaUsuario.equals("sim")){
                                    v1.setOcupada(true);
                                    System.out.println("Qual o carro que está ocupando ela?");
                                    respostaUsuario = scan.next();
                                    v1.setCarro(pbdc.buscarPorModelo(respostaUsuario));
                                }
                                break;
                            case 4:
                                System.out.println("# Voltando pro menu Inicial #");
                                break;
                            default:
                                System.out.println("## OPCAO INVALIDA ##");
                                break;
                        }
                    }while(opcaoMenu != 4);
            }


        }while(opcaoMenu != 0);


    }
}
