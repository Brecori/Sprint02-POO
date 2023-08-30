package br.com.heinzenberg.controller.menu;

import br.com.heinzenberg.controller.dao.MensagemDAO;
import br.com.heinzenberg.controller.dao.ObjetivoDAO;
import br.com.heinzenberg.controller.dao.ProdutoDAO;
import br.com.heinzenberg.model.Mensagem;
import br.com.heinzenberg.model.Objetivo;
import br.com.heinzenberg.model.Produto;

import java.util.Date;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Menu {
    public void menu() {
        int opcao = 0;

        do {
            opcao = parseInt(showInputDialog(gerarMenu()));
            if (opcao < 1 || opcao > 8) {
                System.out.println("Opcao invalida");
            }
            else {
                switch(opcao) {
                    case 1:
                        cadastrarMensagem();
                        break;
                    case 2:
                        cadastrarProduto();
                        break;
                    case 3:
                        cadastrarObjetivo();
                        break;
                    case 4:
                        pesquisarObjetivo();
                        break;
                    case 5:
                        listarObjetivo();
                        break;
                    case 6:
                        atualizarObjetivo();
                        break;
                    case 7:
                        excluirObjetivo();
                        break;
                }
            }
        } while (opcao != 8);
    }

    private void pesquisarObjetivo() {
        ObjetivoDAO daoObj = new ObjetivoDAO();
        int id = parseInt(showInputDialog("ID"));
        Objetivo objetivo = daoObj.pesquisar(id);
        if (objetivo == null) {
            showMessageDialog(null, "Objetivo nao encontrado");
        }
        else {
            showMessageDialog(null, objetivo.toString());
        }
    }

    private void excluirObjetivo() {
        ObjetivoDAO daoObj = new ObjetivoDAO();
        int id = parseInt(showInputDialog("Digite o ID do objetivo a ser excluido"));
        Objetivo objetivo = daoObj.pesquisar(id);
        if (objetivo == null) {
            showMessageDialog(null, "Objetivo nao encontrado");
        }
        else {
            daoObj.remover(id);
        }
    }

    private void atualizarObjetivo() {
        ObjetivoDAO daoObj = new ObjetivoDAO();
        int id = parseInt(showInputDialog("ID"));
        Objetivo objetivo = daoObj.pesquisar(id);

        if (objetivo == null) {
            showMessageDialog(null, "Objetivo nao encontrado");
        }
        else {
            String nome = showInputDialog("Novo nome");
            double meta = parseDouble(showInputDialog("Nova meta"));
            int tipoEsg = parseInt(showInputDialog("Novo tipo de esg \n" + "1 - SOCIAL\n" + "2 - AMBIENTAL\n" + "3 - GOVERNANÇA\n"));
            String descricao = showInputDialog("Nova descricao");
            objetivo.setId(id);
            objetivo.setNome(nome);
            objetivo.setMeta(meta);
            objetivo.setTipoEsg(tipoEsg);
            objetivo.setDescricao(descricao);
            daoObj.atualizar(objetivo);
        }
    }

    private void listarObjetivo() {
        ObjetivoDAO daoObj = new ObjetivoDAO();
        List<Objetivo> objetivos = daoObj.listar();
        if (objetivos.isEmpty()) {
            showMessageDialog(null, "Sem objetivos cadastrados!");
        } else {
            String aux = "LISTA DE OBJETIVOS" + "\n\n";
            for (Objetivo o : objetivos) {
                aux += o.toString() + "\n";
            }
            showMessageDialog(null, aux);
        }
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
        descricaoObj = showInputDialog("Faça uma descricao do objetivo");
        tipoEsg = parseInt(showInputDialog("INFORME O TIPO DE ESG QUE O OBJETIVO ABRANGE\n" + "1 - SOCIAL\n" + "2 - AMBIENTAL\n" + "3 - GOVERNANÇA"));
        metaObj = parseDouble(showInputDialog("Qual a meta do objetivo? (em numeros)"));
        Objetivo objetivo = new Objetivo(idObj, nomeObj, metaObj, tipoEsg, descricaoObj);
        daoObj.inserir(objetivo);
    }

    private void cadastrarMensagem() {
        MensagemDAO daoMsg = new MensagemDAO();
        ObjetivoDAO daoObj = new ObjetivoDAO();
        ProdutoDAO daoPdt = new ProdutoDAO();
        int idMsg;
        String nacionalidade;
        int qtd;
        Date data = new Date();
        java.sql.Date sqlData = new java.sql.Date(data.getTime());
        String feedback;
        Produto produto = null;
        Objetivo objetivo = null;
        List<Objetivo> listaObjetivo = daoObj.listar();
        List<Produto> listaProduto = daoPdt.listar();
        idMsg = parseInt(showInputDialog("Id da Mensagem"));
        nacionalidade = showInputDialog("Nacionalidade");
        qtd = parseInt(showInputDialog("Quantidade de mensagens"));
        feedback = showInputDialog("Mensagem");
        if (listaObjetivo.isEmpty()) {
            showMessageDialog(null, "Sem objetivos cadastrados!");
            cadastrarObjetivo();
            List<Objetivo> listaObjetivo2 = daoObj.listar();
            String auxObj = "";
            for (Objetivo o : listaObjetivo2) {
                auxObj += o.toString() + "\n";
            }
            int idObj = parseInt(showInputDialog("A qual objetivo a mensagem esta relacionada? \n\n" +auxObj));
            objetivo = new Objetivo(idObj);
        } else {

            String auxObj = "";
            for (Objetivo o : listaObjetivo) {
                auxObj += o.toString() + "\n";
            }
            int idObj = parseInt(showInputDialog("A qual objetivo a mensagem esta relacionada? \n\n" +auxObj));
            objetivo = new Objetivo(idObj);
        }
        if (listaProduto.isEmpty()) {
            showMessageDialog(null, "Sem produtos cadastrados!");
            cadastrarProduto();
            List<Produto> listaProduto2 = daoPdt.listar();
            String auxPdt = "";
            for (Produto p : listaProduto2) {
                auxPdt += p.toString() + "\n";
            }
            int idPdt = parseInt(showInputDialog("A qual produto a mensagem esta relacionada? \n\n" + auxPdt));
            produto = new Produto(idPdt);
        } else {
            String auxPdt = "";
            for (Produto p : listaProduto) {
                auxPdt += p.toString() + "\n";
            }
            int idPdt = parseInt(showInputDialog("A qual produto a mensagem esta relacionada? \n\n" +auxPdt));
            produto = new Produto(idPdt);
        }
        Mensagem mensagem = new Mensagem(idMsg, nacionalidade, qtd, sqlData, feedback, produto, objetivo);
        daoMsg.inserir(mensagem);

    }

    private String  gerarMenu() {
        String menu = "CONTROLE DE MENSAGENS - ESCOLHA UMA OPCAO\n";
        menu += "1. Cadastrar mensagem\n";
        menu += "2. Cadastrar produto\n";
        menu += "3. Cadastrar objetivo\n";
        menu += "4. Pesquisar objetivo\n";
        menu += "5. Listar objetivos\n";
        menu += "6. Atualizar objetivo\n";
        menu += "7. Excluir objetivo\n";
        menu += "8. Finalizar\n";
        return menu;
   }
}
