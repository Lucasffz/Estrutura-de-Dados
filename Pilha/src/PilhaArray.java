
public class PilhaArray implements Pilha {
	private Object S[]; //conteúdo da pilha.
	private int t = -1; //índice do topo, inicia com -1 indicando que esta vazia.
	private int tc; //taxa de crescimento, dependendo do resultado indica se o crescimento é incremental ou de duplicação.
	 
	
	PilhaArray(int tam){
		S = new Object[tam];	
	}
	
	
	public int size() {
		return t+1;
	}

	public boolean isEmpty() {
		return t == -1;
	}
	
	private boolean isFull() {
		return S.length == t;
	}

	public Object top() throws Epilhavazia {
		if(isEmpty())
			throw new Epilhavazia("Pilha sem conteúdo.");
		else
			return S[t];
	}

	public void push(Object o) {	
		if(isFull()) {
			Object np[]; 
			if(tc == 0) {
				np = new Object[size()*2];
				for (int i = 0; i < size(); i++) np[i] = S[i];
				S = np;	
			}
			else {
				np = new Object[size()+tc];
				for (int i = 0; i < size(); i++) np[i] = S[i];
				S = np;
			}
		}
		S[++t] = o;
		
	}
	
	public Object pop() throws Epilhavazia {
		if(isEmpty()) {
			throw new Epilhavazia("Pilha sem conteúdo.");
		}
		
		else {
			Object auxiliar = new Object();
			auxiliar = S[t];
			t--;
			return auxiliar; 
		}
		
	}
	
}
