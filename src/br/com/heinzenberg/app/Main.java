package br.com.heinzenberg.app;

import br.com.heinzenberg.model.Funcionario;
import br.com.heinzenberg.model.Mensagem;
import br.com.heinzenberg.model.Regiao;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Mensagem> MensagemSocialR = new LinkedList<>();
        List<Mensagem> MensagemSocialS = new LinkedList<>();
        List<Mensagem> MensagemAmbientalR = new LinkedList<>();
        List<Mensagem> MensagemAmbientalS = new LinkedList<>();
        List<Mensagem> MensagemGovernancaR = new LinkedList<>();
        List<Mensagem> MensagemGovernancaS = new LinkedList<>();

        int controleMenu = -1;
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Encerrar Programa: \t\t\t(Digite 0)");
            System.out.println("Inserir mensagem: \t\t\t(Digite 1)");
            System.out.println("Ler mensagem: \t\t\t\t(Digite 2)");

            controleMenu = input.nextInt();
            System.out.println();
            switch (controleMenu) {
                case 0:
                    System.out.println("Encerrando programa...");
                    System.exit(0);
                    break;
                case 1:
                    Mensagem mensagem = new Mensagem();
                    System.out.println("Informe o seu nome: ");
                    String nome = input.next() + input.nextLine();
                    System.out.println("Informe o seu cargo: ");
                    String cargo = input.next() + input.nextLine();


                    Funcionario funcionario = new Funcionario(nome, cargo);
                    mensagem.setFuncionario(funcionario);

                    int recsug = 0;
                    String motivo;
                    do {
                        System.out.println("Por favor, informe se a mensagem se trata de uma reclamação (1) ou uma sugestao (2)");
                        recsug = input.nextInt();
                    } while (recsug != 1 && recsug != 2);
                    if (recsug == 1) {
                        motivo = "Reclamacao";
                    }
                    else {
                        motivo = "sugestao";
                    }
                    mensagem.setMotivo(motivo);

                    LocalDate data = LocalDate.now();
                    mensagem.setData(data);

                    System.out.println("Digite abaixo a mensagem a ser inserida no sistema: ");
                    String mensagemStr = input.next() + input.nextLine();
                    mensagem.setMensagem(mensagemStr);

                    System.out.println("Informe o país de onde a mensagem foi enviada: ");
                    String pais = input.next() + input.nextLine();

                    Regiao regiao = new Regiao();
                    regiao.setPais(pais);
                    mensagem.setRegiao(regiao);

                    int tipoESG = 4;
                    do {
                        System.out.println("Informe o tipo de ESG que mensagem diz sobre, sendo elas SOCIAL (1), AMBIENTAL (2) ou GOVERNANCA (3): ");
                        tipoESG = input.nextInt();
                    } while (tipoESG != 1 && tipoESG != 2 && tipoESG != 3);

                    switch (tipoESG) {
                        case 1:
                            mensagem.setTipoEsg(Mensagem.Tipo_ESG.SOCIAL);
                            break;
                        case 2:
                            mensagem.setTipoEsg(Mensagem.Tipo_ESG.AMBIENTAL);
                            break;
                        case 3:
                            mensagem.setTipoEsg(Mensagem.Tipo_ESG.GOVERNANCA);
                            break;
                    }

                    switch (recsug) {
                        case 1:
                        switch (tipoESG) {
                            case 1:
                                MensagemSocialR.add(mensagem);
                                break;
                            case 2:
                                MensagemAmbientalR.add(mensagem);
                                break;
                            case 3:
                                MensagemGovernancaR.add(mensagem);
                                break;
                        }
                        break;
                        case 2:
                            switch (tipoESG) {
                                case 1:
                                    MensagemSocialS.add(mensagem);
                                    break;
                                case 2:
                                    MensagemAmbientalS.add(mensagem);
                                    break;
                                case 3:
                                    MensagemGovernancaS.add(mensagem);
                                    break;
                            }
                            break;
                    }


                    break;

                case 2:
                    int opcaoRS = 0;
                    do {
                        System.out.println("Voce deseja ler as mensagens de reclamacao (1) ou sugestao (2)? ");
                        opcaoRS = input.nextInt();
                    } while (opcaoRS != 1 && opcaoRS != 2);

                    if (opcaoRS == 1) {
                        int opcaoSAG = 0;
                        do {
                            System.out.println("Voce deseja ler as reclamacoes de SOCIAL (1), AMBIENTAL (2) ou GOVERNANCA (3): ");
                            opcaoSAG = input.nextInt();
                        } while (opcaoSAG != 1 && opcaoSAG != 2 && opcaoSAG != 3);
                        switch (opcaoSAG) {
                            case 1:
                                if (MensagemSocialR.isEmpty()) {
                                    System.out.println("Nao ha mensagens disponiveis com esses atributos!");
                                }
                                else {
                                    for (Mensagem mensagens: MensagemSocialR) {
                                        System.out.println(mensagens.toString());
                                    }
                                }
                                break;
                            case 2:
                                if (MensagemAmbientalR.isEmpty()) {
                                    System.out.println("Nao ha mensagens disponiveis com esses atributos!");
                                }
                                else {
                                    for (Mensagem mensagens: MensagemAmbientalR) {
                                        System.out.println(mensagens.toString());
                                    }
                                }
                                break;
                            case 3:
                                if (MensagemGovernancaR.isEmpty()) {
                                    System.out.println("Nao ha mensagens disponiveis com esses atributos!");
                                }
                                else {
                                    for (Mensagem mensagens: MensagemGovernancaR) {
                                        System.out.println(mensagens.toString());
                                    }
                                }
                                break;
                        }
                    }
                    else {
                        int opcaoSAG = 0;
                        do {
                            System.out.println("Voce deseja ler as sugestoes de SOCIAL (1), AMBIENTAL (2) ou GOVERNANCA (3): ");
                            opcaoSAG = input.nextInt();
                        } while (opcaoSAG != 1 && opcaoSAG != 2 && opcaoSAG != 3);
                        switch (opcaoSAG) {
                            case 1:
                                if (MensagemSocialS.isEmpty()) {
                                    System.out.println("Nao ha mensagens disponiveis com esses atributos!");
                                }
                                else {
                                    for (Mensagem mensagens: MensagemSocialS) {
                                        System.out.println(mensagens.toString());
                                    }
                                }
                                break;
                            case 2:
                                if (MensagemAmbientalS.isEmpty()) {
                                    System.out.println("Nao ha mensagens disponiveis com esses atributos!");
                                }
                                else {
                                    for (Mensagem mensagens: MensagemAmbientalS) {
                                        System.out.println(mensagens.toString());
                                    }
                                }
                                break;
                            case 3:
                                if (MensagemGovernancaS.isEmpty()) {
                                    System.out.println("Nao ha mensagens disponiveis com esses atributos!");
                                }
                                else {
                                    for (Mensagem mensagens: MensagemGovernancaS) {
                                        System.out.println(mensagens.toString());
                                    }
                                }
                                break;
                        }
                    }

                    break;
            }
        }
    }
}
