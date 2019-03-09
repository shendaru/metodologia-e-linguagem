package exer1;

import java.util.Scanner;

public class Par {
	public static void main(String[] args) {
		System.out.println("informe 10 números inteiros na tela;será informado se são par ou ímpar");
		Scanner scan = new Scanner(System.in);
		int i, num;
		for (i = 0; i < 10; i++) {
			num = scan.nextInt();
			if (num % 2 == 0) {
				System.out.println("Par");
			} else {
				System.out.println("Ímpar");
			}
		}
	}
}
