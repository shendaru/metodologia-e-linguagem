package exer1;

import java.util.Scanner;

public class AumentoDoSalario {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		float salario, percentual, novosal;
		System.out.println("Informe o seu salário atual, e o percentual de aumento respectivamente:");
		salario = scan.nextFloat();
		percentual = scan.nextFloat();
		novosal = salario * ((percentual + 100) / 100);
		System.out.println("seu novo salário é:" + novosal);
		System.out.println("foi aumentado " + (novosal - salario) + " do seu salário");
	}
}
