package Projeto;

import Banco.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * Created by Douglas on 11/11/2016.
 */
public class Cliente {
    public int idcliente;
    public String nomecliente;
    public String contato;
    public String endereco;
    public String cidade;
    Scanner l = new Scanner(System.in);
    // VAI LER OS DADOS DIGITADOS PELO ADMINISTRADOR.
    public void ler() {


        System.out.println("Digite o ID do cliente: ");
        idcliente = l.nextInt();
        System.out.println("Digite o nome do cliente: ");
        nomecliente = l.next();
        System.out.println("Digite o contato do cliente: ");
        contato = l.next();
        System.out.println("Digite o endereço do cliente: ");
        endereco = l.next();
        System.out.println("Digite a cidade do cliente: ");
        cidade = l.next();
    }

    // EXIBIÇÃO DOS DADOS
    public void exibir() {
        System.out.println("ID: " + this.idcliente);
        System.out.println("Nome: " + this.nomecliente);
        System.out.println("Contato: " + this.contato);
        System.out.println("Endereço: " + this.endereco);
        System.out.println("Cidade: " + this.cidade);
    }

    // INSERÇÃO DOS DADOS NO BANCO DE DADOS
    public void inserir() {
        try {
            System.out.println("Abrindo Conexão...");
            Connection conexao = ConnectionFactory.createConnection();

            String sql = "INSERT INTO cliente(idcliente, nomecliente, contato, endereco, cidade)" +
                    "VALUES ('" + this.idcliente + "', '" + this.nomecliente + "', '"
                    + this.contato + "', '" + this.endereco + "', '" + this.cidade + "')";

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
            String sql = "SELECT * FROM cliente;";
            PreparedStatement comando = conexao.prepareStatement(sql);

            System.out.println("Executando Comando...");
            ResultSet resultado = comando.executeQuery();

            System.out.println("Resultados encontrados: \n");
            while (resultado.next()) {
                System.out.printf("ID: %d  \nNome: %s \nContato: %s \nEndereço: %s \nCidade: %s ",
                        resultado.getInt("idcliente"),
                        resultado.getString("nomecliente"),
                        resultado.getString("contato"),
                        resultado.getString("endereco"),
                        resultado.getString("cidade"));
            }

            System.out.println("\nFechando conexão...");
            conexao.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        try {
            Connection conexao = ConnectionFactory.createConnection();
            System.out.println("Abrindo Conexão... ");
            String idcli;

            listar();
            System.out.print("Digite o id do cliente para efetuar a Exclusão:  ");
             idcli = l.next();

            String sql = "DELETE FROM cliente where idcliente = '" + idcli + "'";

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
            System.out.println("Digite o id do cliente: ");
            int ide = l.nextInt();
            String novonome;
            String novocontato;
            String novoendereco;
            String novacidade;

            System.out.println("Novo nome: ");
            novonome = l.next();
            System.out.println("Novo Contato: ");
            novocontato = l.next();
            System.out.println("Novo Endereço: ");
            novoendereco = l.next();
            System.out.println("Nova Cidade: ");
            novacidade = l.next();

            String sql = "UPDATE cliente SET nomecliente = '" + novonome + "',  contato = '" + novocontato + "'," +
                    "  endereco = '" + novoendereco + "', cidade = '" + novacidade + "' WHERE idcliente = " + ide +";";

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
