package exer1;

import java.util.Scanner;

public class Pousada {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int controle = 1, dias, conta, contaTotal = 0;
		String cliente;
		while (controle == 1) {
			System.out.println(
					"Informe o nome do cliente, e o número total de dias passados por ele na pousada respectivamente:");
			cliente = scan.next();
			dias = scan.nextInt();
			if (dias < 10) {
				conta = 40 * dias + 15 * dias;
				contaTotal += conta;
			} else {
				conta = 40 * dias + 15 * 9 + 8 * (dias - 9);
				contaTotal += conta;
			}
			System.out.println("Nome do cliente:" + cliente);
			System.out.println("Conta:" + conta);
			System.out
					.println("Deseja continuar informando mais clientes?(1 para sim,qualquer outro número para sair)");
			controle = scan.nextInt();
		}
		System.out.println("Valor total arrecadado:" + contaTotal);
	}
}
