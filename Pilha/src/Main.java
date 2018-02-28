import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Epilhavazia {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Tamanho da pilha:");
		int tamanho = input.nextInt();
		System.out.println("Taxa de crescimento: ");
		int tc = input.nextInt();
		PilhaArray pilha = new PilhaArray(tamanho,tc);
		int op = -1;
		
		while(op != 6) {
			System.out.println("1 - método push; \n2 - método pop;\n3 - método top;\n4 - método isEmpty;\n5 - size;\n6  - sair.");	
			System.out.print(">>");	
			op = input.nextInt();	
				
			switch(op) {
				case 1:
					System.out.println("nome para inserir na pilha:");
					String nome;
					nome = input.next();
					pilha.push(nome);
					break;
				case 2:
					System.out.println(pilha.pop());
					break;
				case 3:
					System.out.println(pilha.top());
					break;
				case 4:
					System.out.println(pilha.isEmpty());
					break;
				case 5:
					System.out.println(pilha.size());
					break;
				default:
					System.out.println("operação errada.");
			}
			
		}
	}
	
	
	

}
