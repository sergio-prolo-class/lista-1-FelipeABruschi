/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

	public class App {
	
    	public static void main(String[] args) {

			if(args.length < 2)
				System.out.println("Digite uma forma geometrica e seu tamanho.");

			String forma_geometrica = args[0];
			int tamanho = Integer.parseInt(args[1]);

			if(forma_geometrica.equals("triangulo")) {
				for(int espaco = tamanho, asterisco=1; espaco > 1; espaco--, asterisco++)
					System.out.println(" ".repeat(espaco-1) + "*".repeat(asterisco));
				System.out.println("*".repeat(tamanho));
			}
			else if (forma_geometrica.equals("losango")) {
				if(tamanho % 2 == 0)
					System.out.println("Digite um número ímpar.");
				else{
					for(int i = 0, espaco = tamanho, asterisco = 1; i < tamanho / 2 + 1; i++, asterisco += 2, espaco -= 2)
						System.out.println(" ".repeat((espaco-1)/2) + "*".repeat(asterisco) + " ".repeat(((espaco-1)/2)));
					for(int i = 0, espaco = 1, asterisco = tamanho; i < tamanho / 2; i++, espaco++, asterisco -= 2)
						System.out.println(" ".repeat(espaco) + "*".repeat(asterisco - 2) + " ".repeat(espaco));
				}
			}
			else if (forma_geometrica.equals("retangulo")) {
				if(args.length < 3)
					System.out.println("Digite o lado e a altura do retangulo.");
				int lado = Integer.parseInt(args[1]);
				int altura = Integer.parseInt(args[2]);
				System.out.println("*".repeat(lado));
				for(int i = 0; i < altura - 2; i++)
					System.out.println("*" + " ".repeat(lado - 2) + "*");
				System.out.println("*".repeat(lado));
			}
			else
				System.out.println("Digite uma forma geométrica válida: triangulo, losango ou retangulo.");
		}
}
