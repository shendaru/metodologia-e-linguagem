package exer1;

import java.util.Scanner;

public class Tabuada {
	public static void main(String[] args) {
		float num;
		int i;
		Scanner scan = new Scanner(System.in);
		System.out.println("informe um número no qual deseja ver a tabuada:");
		num = scan.nextFloat();
		for (i = 1; i <= 10; i++) {
			System.out.println(num + "*" + i + "=" + (num * i));
		}
	}
}
