public class FilaArray implements Fila {
	private Object aFila[]; // Array de conteúdo da fila
	private int i = 0 ;// índice referente ao primeiro elemento
	private int f = i ; // índice apos o ultimo elemento 
	private int n; // tamanho da fila.
	private int fc;// fator de crescimento 
	
	public FilaArray(int n, int fc) {
		this.n = n;
		this.fc = fc;
	}

	@Override
	public int tamanho() {
		return (n-i+f) % n;
	}
	
	private boolean cheio() {
		return tamanho() == n;
	}

	@Override
	public boolean estaVazia() {
		return i == f;
	}

	@Override
	public Object inicio() throws EFilaVazia {
		if(estaVazia()) 
			throw new EFilaVazia("Fila vazia.");
		else
			return aFila[i];
	}

	@Override
	public Object desenfileirar() throws EFilaVazia {
		if(estaVazia()) 
			throw new EFilaVazia("Fila vazia.");
		else
			return aFila[--f];
	}

	@Override
	public void enfileirar(Object o) {
		if(cheio()) {
			Object aux[];
			if(fc == 0)
				aux = new Object[n*2];
			else
				aux = new Object[n+fc];
			for (int i = 0; i <n; i++) 	aux[i] = aFila[i];
			aFila = aux;
		}
		aFila[f++] = o;
	}

}
