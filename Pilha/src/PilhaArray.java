
public class PilhaArray implements Pilha {
	private Object S[]; //conte�do da pilha.
	private int t = -1; //�ndice do topo, inicia com -1 indicando que esta vazia.
	private int tc; //taxa de crescimento, dependendo do resultado indica se o crescimento � incremental ou de duplica��o.
	 
	
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
			throw new Epilhavazia("Pilha sem conte�do.");
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
			throw new Epilhavazia("Pilha sem conte�do.");
		}
		
		else {
			Object auxiliar = new Object();
			auxiliar = S[t];
			t--;
			return auxiliar; 
		}
		
	}
	
}
