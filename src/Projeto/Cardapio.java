package Projeto;

import Banco.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * Created by Douglas on 11/11/2016.
 */
public class Cardapio {
    public int idCardapio;
    public String nomeprato;
    public float precoprato;
    public String descricao;

    Scanner l = new Scanner(System.in);

    public void ler() {
        System.out.println("Digite o Numero do Prato: ");
        idCardapio = l.nextInt();
        System.out.println("Digite o nome do prato: ");
        nomeprato = l.next();
        System.out.println("Digite o Preco do prato: ");
        precoprato = l.nextFloat();
        System.out.println("Digite a Descrição do Pedido: ");
        descricao = l.next();
    }

    public void exibir() {
        System.out.println("Numero Pedido: " +idCardapio);
        System.out.println("Nome do Prato: " +nomeprato);
        System.out.println("Preço do Prato: " +precoprato);
        System.out.println("Descricao do Prato: " +descricao);
    }

    // INSERÇÃO DOS DADOS NO BANCO DE DADOS
    public void inserir() {
        try {
            System.out.println("Abrindo Conexão...");
            Connection conexao = ConnectionFactory.createConnection();

            String sql = "INSERT INTO Cardapio(idCardapio, nomeprato, precoprato, descricao)" +
                    "VALUES ('" + this.idCardapio + "', '" + this.nomeprato + "', '"
                    + this.precoprato + "', '" + this.descricao + "')";

            PreparedStatement comando = conexao.prepareStatement(sql);

            //System.out.println("Executando comando...");
            comando.execute();
            //System.out.println("Fechando conexão...");
            conexao.close();
            System.out.println("\nINSERIDO COM SUCESSO!!\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // LISTAGEM DOS DADOS NO BANCO DE DADOS
    public void listar() {
        try {
            System.out.println("Abrindo conexão...");

            Connection conexao = ConnectionFactory.createConnection();
            String sql = "SELECT * FROM Cardapio;";
            PreparedStatement comando = conexao.prepareStatement(sql);

            System.out.println("Executando Comando...");
            ResultSet resultado = comando.executeQuery();

            System.out.println("Resultados encontrados: \n");
            while (resultado.next()) {
                System.out.printf("\n\nID: %d  \nNome: %s \nPreco: %f \nDescrição: %s ",
                        resultado.getInt("idCardapio"),
                        resultado.getString("nomeprato"),
                        resultado.getDouble("precoprato"),
                        resultado.getString("descricao"));
            }

            //System.out.println("\nFechando conexão...");
            conexao.close();
            System.out.println("\n\nLISTADO COM SUCESSO!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        try {
            Connection conexao = ConnectionFactory.createConnection();
            System.out.println("Abrindo Conexão... ");
            String idcard;

            listar();
            System.out.print("Digite o id do cliente para efetuar a Exclusão:  ");
            idcard = l.next();

            String sql = "DELETE FROM Cardapio where idCardapio = '" + idcard + "'";

            PreparedStatement comando = conexao.prepareStatement(sql);

            //System.out.println("Executando comando...");
            comando.execute();
            //System.out.println("\nFechando Conexão...");
            conexao.close();

            System.out.println("\nDELETADO COM SUCESSO\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        try {
            System.out.println("Abrindo Conexão");
            Connection conexao = ConnectionFactory.createConnection();

            listar();
            System.out.println("Digite o id do Cardapio: ");
            int ide = l.nextInt();
            String novonome;
            String novopreco;
            String novadescricao;

            System.out.println("Novo nome: ");
            novonome = l.next();
            System.out.println("Novo Preço: ");
            novopreco = l.next();
            System.out.println("Nova Descrição: ");
            novadescricao = l.next();

            String sql = "UPDATE Cardapio SET nomeprato = '" + novonome + "',  precoprato = '" + novopreco + "'," +
                    "  descricao = '" + novadescricao + "' WHERE idCardapio = " + ide +";";

            PreparedStatement comando = conexao.prepareStatement(sql);

            //System.out.println("Executando Comando...");
            comando.execute();
            //System.out.println("Fechando Conexão...");
            conexao.close();
            System.out.println("ATUALIZADO COM SUCESSO");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
