package exer1;

import java.util.Scanner;

public class Media {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i, aprovados = 0, exame = 0, reprovados = 0;
		float nota1, nota2, somaDasMedias = 0, media;
		for (i = 1; i <= 6; i++) {
			System.out.println("informe as 2 notas do aluno " + i + ":");
			nota1 = scan.nextFloat();
			nota2 = scan.nextFloat();
			media = (nota1 + nota2) / 2;
			somaDasMedias += media;
			System.out.println("Média:" + media);
			if (media < 3) {
				System.out.println("Reprovado");
				reprovados++;
			} else if (media > 7) {
				System.out.println("Aprovado");
				aprovados++;
			} else {
				System.out.println("Exame");
				exame++;
			}
		}
		System.out.println("Total de alunos aprovados:" + aprovados);
		System.out.println("Total de alunos reprovados:" + reprovados);
		System.out.println("Total de alunos de exame:" + exame);
		System.out.println("Média total da turma:" + (somaDasMedias / 6));
	}
}
