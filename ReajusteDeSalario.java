package exer1;

import java.util.Scanner;

public class ReajusteDeSalario {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		float sal;
		String funcionario = "a";
		while (!funcionario.equals("fim")) {
			System.out.println("Informe seu nome(fim para sair) e salário atual respectivamente:");
			funcionario = scan.next();
			if (funcionario.equals("fim")) {
				break;
			}
			sal = scan.nextFloat();
			if (sal < 500) {
				System.out.println("salário reajustado, novo salario:" + (sal * 1.2));
			} else {
				System.out.println("nao tem direito a reajuste no salário");
			}
		}
	}
}
