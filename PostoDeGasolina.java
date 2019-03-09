package exer1;

import java.util.Scanner;

public class PostoDeGasolina {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		float litros;
		System.out.println("informe quantos litros de gasolina serão abastecidos");
		litros = scan.nextFloat();
		// 2 refrigerantes é 6 reais
		System.out.println("Valor total:" + (6 + litros * 2.5));
	}
}
