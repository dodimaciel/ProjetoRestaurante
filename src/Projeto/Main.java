package Projeto;

import java.util.Scanner;

/**
 * Created by Douglas on 11/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        int opmaster;
        int opsingle;
        Cliente cliente = new Cliente();

        Scanner l = new Scanner(System.in);

        do {
            System.out.println("Digite a opção Desejada: ");
            System.out.println(" --------------------- ");
            System.out.println(" 1 - MENU CLIENTE ");
            System.out.println(" 2 - MENU CARDAPIO  ");
            System.out.println(" 3 - MENU PEDIDO");
            System.out.println(" 4 - ENCERRAR PROGRAMA ");
            System.out.println(" --------------------- ");
            opmaster = l.nextInt();

            switch (opmaster) {

                case 1:
                    do {

                        System.out.println(" --- CLIENTE --- ");
                        System.out.println(" 1 - ADICIONAR ");
                        System.out.println(" 2 - REMOVER ");
                        System.out.println(" 3 - ATUALIZAR ");
                        System.out.println(" 4 - LISTAR ");
                        System.out.println(" 5 - VOLTAR AO MENU ANTERIOR ");
                        opsingle = l.nextInt();

                        switch (opsingle) {
                            case 1:
                                cliente.ler();
                                cliente.inserir();
                                break;
                            case 2:
                                cliente.delete();
                                break;
                            case 3:
                                cliente.update();
                                break;
                            case 4:
                                cliente.listar();
                                break;
                        }
                    } while (opsingle != 5);
                    break;

                case 2:
                    Cardapio cardapio = new Cardapio();
                    do {
                        System.out.println(" --- CARDAPIO --- ");
                        System.out.println(" 1 - ADICIONAR ");
                        System.out.println(" 2 - REMOVER ");
                        System.out.println(" 3 - ATUALIZAR ");
                        System.out.println(" 4 - LISTAR ");
                        System.out.println(" 5 - VOLTAR AO MENU ANTERIOR ");
                        opsingle = l.nextInt();

                        switch (opsingle) {
                            case 1:
                                cardapio.ler();
                                cardapio.inserir();
                                break;
                            case 2:
                                cardapio.delete();
                                break;
                            case 3:
                                cardapio.update();
                                break;
                            case 4:
                                cardapio.listar();
                                break;
                        }
                    } while (opsingle != 5);
                    break;
                case 3:
                    Pedido pedido = new Pedido();
                    cardapio = new Cardapio();
                    boolean bool = false;

                    System.out.println("LISTA DOS CARDAPIOS!! ");
                    cardapio.listar();
                    pedido.ler();


            }

        } while (opmaster != 3);
    }

}
