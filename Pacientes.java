package exer1;

import java.util.Scanner;

public class Pacientes {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = 0, idade, sexo, qntGeral = 0, qntHomem = 0, qntJovens = 0, mulherGorda = 0, maisVelho = 0,
				somaDasIdades = 0;
		float altura, peso, maisBaixa = 5;
		String nome, velho = "Nenhum", baixa = "Nenhum";
		while (a == 0) {
			System.out.println(
					"Informe seu nome(fim para sair),sexo(1 para homem 2 para mulher),idade,peso e altura respectivamente:");
			nome = scan.next();
			if (nome.equals("fim")) {
				a++;
				break;
			}
			sexo = scan.nextInt();
			idade = scan.nextInt();
			if (sexo == 1) {
				qntHomem++;
				somaDasIdades += idade;
			}
			if (idade >= 18 && idade <= 25) {
				qntJovens++;
			}
			peso = scan.nextFloat();
			altura = scan.nextFloat();
			if (sexo == 2 && altura >= 1.6 && altura <= 1.7 && peso > 70) {
				mulherGorda++;
			}
			if (idade > maisVelho) {
				velho = nome;
				maisVelho = idade;
			}
			if (sexo == 2 && altura < maisBaixa) {
				baixa = nome;
				maisBaixa = altura;
			}
			qntGeral++;
		}
		System.out.println("RELATÓRIO:");
		System.out.println("Quantidade de pacientes:" + qntGeral);
		if (qntHomem == 0) {
			System.out.println("Idade média dos homens:Não há homens");
		} else {
			System.out.println("Idade média dos homens:" + (somaDasIdades / qntHomem));
		}
		System.out.println("quantidade de mulheres entre 1.60 e 1.70 de altura e peso acima de 70:" + mulherGorda);
		System.out.println("quantidade de pessoas entre 18 e 25 anos:" + qntJovens);
		System.out.println("Nome do paciente mais velho:" + velho);
		System.out.println("Nome da mulher mais baixa:" + baixa);
	}
}
