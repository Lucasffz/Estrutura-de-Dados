public class FilaArray implements Fila {
	private Object aFila[]; // Array de conteúdo da fila
	private int i;// índice referente ao primeiro elemento
	private int f; // índice apos o ultimo elemento 
	private int n; // tamanho da fila.
	private int fc;// fator de crescimento 
	
	public FilaArray(int n, int fc) {
		i = 0;
		f = i;
		this.n = n;
		this.fc = fc;
		aFila = new Object[n];
	}

	@Override
	public int tamanho() {
		return (n-i+f) % n;
	}
	
	private boolean cheio() {
		return tamanho() == n - 1;
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
		else {
			Object aux = new Object();
			aux = aFila[i];
			i = (i+1) % n;
			return aux;
		}
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
		aFila[f] = o;
		f = (f-1) % n;
	}
}
