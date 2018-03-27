import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws ExceptionRank {
		Scanner input = new Scanner(System.in);
		SequenciaLE sequencia = new SequenciaLE();
		
		int op = -1;
		int rank;
		String ob;
		No no;
		Object objeto;
		while(op!=0) {
		System.out.println("--------------------------------------------------------");	
		System.out.println("1- size; \n2- isEmpty; \n3- elmentAtRank; \n4- replaceAtRank; \n5- removeAtrank; \n6- fist; \n7- last;"
					+ "\n8-before;\n9-after;\n10-replaceElement;\n11-swapElements;\n12-insertBefore\n13-insertAfter;\n14-insertFist;\n15insertLast;\n16-remove.");
			
		System.out.print(">>");
		op = input.nextInt();
			
		switch(op) {
		case 1:
			System.out.println(sequencia.size());
			break;
		case 2:
			System.out.println(sequencia.isEmpty());
			break;
		case 3:
				rank = input.nextInt();
				System.out.println(sequencia.elemAtRank(rank));
				break;
		case 4:
				System.out.print("objeto:");
				ob = input.next();
				rank = input.nextInt();
				System.out.println(sequencia.replaceAtRank(ob, rank));
				break;
		case 5:
				System.out.print("Rank:");
				rank = input.nextInt();
				sequencia.removeAtRank(rank);
				System.out.println("removido.");
				break;
		case 6:
				Object n = sequencia.fist();
				System.out.println(n);
				break;
		case 7:
				System.out.println(sequencia.last());
				break;
		case 8:
				System.out.println("digite a posição do nó:");
				rank = input.nextInt();
				no = sequencia.atRank(rank);
				objeto = sequencia.before(no).getElemento();
				System.out.println(objeto);
				break;
		case 9:
			System.out.println("digite a posição do nó:");
			rank = input.nextInt();
			no = sequencia.atRank(rank);
			objeto = sequencia.after(no).getElemento();
			System.out.println(objeto);
			break;
		case 10:
			System.out.println("digite a posição do nó:");
			rank = input.nextInt();
			no = sequencia.atRank(rank);
			System.out.println("Elemento:");
			ob = input.next();
			objeto = sequencia.replaceElement(no,ob);
			System.out.println(objeto);
			break;
		case 11:
			System.out.println("Posição do primeiro nó:");
			rank = input.nextInt();
			no = sequencia.atRank(rank);
			System.out.println("Posição do segundo nó:");
			int rank2 = input.nextInt();
			No no2 = sequencia.atRank(rank2);
			sequencia.swapElements(no, no2);
			break;
		case 12:
			System.out.println("Posição do nó:");
			rank = input.nextInt();
			no = sequencia.atRank(rank);
			System.out.println("Objeto:");
			ob =input.next();
			sequencia.insertBefore(no,ob);
			break;
		case 13:
			System.out.println("Posição do nó:");
			rank = input.nextInt();
			no = sequencia.atRank(rank);
			System.out.println("Objeto:");
			ob =input.next();
			sequencia.insertAfter(no,ob);
			break;
		case 14:
			System.out.print("Elemento:");
			ob = input.next();
			sequencia.insertFist(ob);
			break;
		case 15:
			System.out.println("Elemento:");
			ob = input.next();
			sequencia.insertLast(ob);
			break;
		case 16:
			System.out.println("Posição do nó:");
			rank = input.nextInt();
			no = sequencia.atRank(rank);
			sequencia.remove(no);
			break;
		default:
			System.out.println("opção errada!!!");
			break;
			
		}
			
		}
		

	}

}
