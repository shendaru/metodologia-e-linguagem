package exer1;

import java.util.Scanner;

public class Par {
	public static void main(String[] args) {
		System.out.println("informe 10 n�meros inteiros na tela;ser� informado se s�o par ou �mpar");
		Scanner scan = new Scanner(System.in);
		int i, num;
		for (i = 0; i < 10; i++) {
			num = scan.nextInt();
			if (num % 2 == 0) {
				System.out.println("Par");
			} else {
				System.out.println("�mpar");
			}
		}
	}
}
