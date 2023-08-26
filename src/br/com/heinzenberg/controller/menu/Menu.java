package br.com.heinzenberg.controller.menu;

import br.com.heinzenberg.controller.dao.ObjetivoDAO;
import br.com.heinzenberg.controller.dao.ProdutoDAO;
import br.com.heinzenberg.model.Objetivo;
import br.com.heinzenberg.model.Produto;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;

public class Menu {
    public void menu() {
        int opcao = 0;

        do {
            opcao = parseInt(showInputDialog(gerarMenu()));
            if (opcao < 1 || opcao > 7) {
                System.out.println("Opcao invalida");
            }
            else {
                switch(opcao) {
                    case 1:
                        cadastrarMensagem();
                        break;
                    case 2:
                        cadastrarObjetivo();
                        break;
                    case 3:
                        cadastrarProduto();
                        break;
                    case 4:
                        listarObjetivo();
                        break;
                    case 5:
                        atualizarObjetivo();
                        break;
                    case 6:
                        excluirObjetivo();
                        break;
                }
            }
        } while (opcao != 7);
    }

    private void excluirObjetivo() {
    }

    private void atualizarObjetivo() {
    }

    private void listarObjetivo() {
    }

    private void cadastrarProduto() {
        ProdutoDAO daoProd = new ProdutoDAO();
        int idProd;
        String nomeProd;

        idProd = parseInt(showInputDialog("Id do Produto"));
        nomeProd = showInputDialog("Nome do Produto");
        Produto produto = new Produto(idProd, nomeProd);
        daoProd.inserir(produto);
    }

    private void cadastrarObjetivo() {
        ObjetivoDAO daoObj = new ObjetivoDAO();
        int idObj;
        String nomeObj;
        double metaObj;
        int tipoEsg = 0;
        String descricaoObj;

        idObj = parseInt(showInputDialog("Id do Objetivo"));
        nomeObj = showInputDialog("Nome do Objetivo");
        metaObj = parseDouble(showInputDialog("Quantos % o objetivo ja foi concluido ate o momento?"));
        tipoEsg = parseInt(showInputDialog("INFORME O TIPO DE ESG QUE O OBJETIVO ABRANGE\n" + "1 - SOCIAL\n" + "2 - AMBIENTAL\n" + "3 - GOVERNANÇA"));


        descricaoObj = showInputDialog("Faça uma descricao do objetivo");
        Objetivo objetivo = new Objetivo(idObj, nomeObj, metaObj, tipoEsg, descricaoObj);
        daoObj.inserir(objetivo);
    }

    private void cadastrarMensagem() {
    }

    private String  gerarMenu() {
        String menu = "CONTROLE DE MENSAGENS - ESCOLHA UMA OPCAO\n";
        menu += "1. Cadastrar mensagem\n";
        menu += "2. Cadastrar objetivo\n";
        menu += "3. Cadastrar produto\n";
        menu += "4. Listar objetivo\n";
        menu += "5. Atualizar objetivo\n";
        menu += "6. Excluir objetivo\n";
        menu += "7. Finalizar\n";
        return menu;
   }
}
