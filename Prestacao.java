package exer1;

import java.util.Scanner;

public class Prestacao {
	public static void main(String[] args) {
		float salario, emprestimo;
		Scanner scan = new Scanner(System.in);
		System.out.println("Informe seu sal�rio e o valor da presta��o a ser solicitada respectivamente:");
		salario = scan.nextFloat();
		emprestimo = scan.nextFloat();
		if (emprestimo <= (0.3 * salario)) {
			System.out.println("empr�stimo pode ser concedido");
		} else {
			System.out.println("empr�stimo nao pode ser concedido");
		}
	}
}
