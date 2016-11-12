package Projeto;

import java.util.Scanner;

/**
 * Created by Douglas on 11/11/2016.
 */
public class Pedido {
    public int id;
    Scanner l = new Scanner(System.in);
    Cliente cli = new Cliente();
    Cardapio car = new Cardapio();

    public void ler() {
        System.out.println("Digite o ID do pedido: ");
        id = l.nextInt();
    }


}
