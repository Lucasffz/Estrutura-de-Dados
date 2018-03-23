public class SequenciaLE implements Sequencia {
	private No inicio, fim;
	private int tamanho;
	
	
	
	SequenciaLE(){
		this.inicio = new No();
		this.fim = new No();
		this.inicio.setProximo(fim);
		this.fim.setAnterior(inicio);
		fim.setProximo(null);
		this.tamanho = 0;
	}
	
	@Override
	public int size() {
		return tamanho;
	}

	@Override
	public boolean isEmpty() {
		return tamanho == 0;
	}

	@Override
	public Object elemAtRank(int r) {
		No no = atRank(r);
		return no.getElemento();
	}

	@Override
	public Object replaceAtRank(Object o, int r) {
		No no = atRank(r);
		Object aux = no.getElemento();
		no.setElemento(o);
		return aux;
		
	}
	

	@Override
	public void removeAtRank(int r) {
		No no = atRank(r);
		no.getAnterior().setProximo(no.getProximo());
		no.getProximo().setAnterior(no.getAnterior());
		no.setAnterior(null);
		no.setProximo(null);
		tamanho --;		
		
	}

	@Override
	public Object fist() {
		return inicio.getProximo().getElemento();
	}

	@Override
	public Object last() {
		return fim.getAnterior().getElemento();
	}

	@Override
	public No before(No n) {
		return n.getAnterior();
	}

	@Override
	public No after(No n) {
		return n.getProximo();
	}

	@Override
	public Object replaceElement(No n, Object o) {
		Object aux = n.getElemento();
		n.setElemento(o);
		return aux;
	}

	@Override
	public void swapElements(No n, No q) {
		Object aux;
		aux = n.getElemento();
		n.setElemento(q.getElemento());
		q.setElemento(aux);
		
	}

	@Override
	public void insertBefore(No n, Object o) {
		No antigo = n;
		No anterior = antigo.getAnterior();
		No no = new No();
		no.setAnterior(anterior);
		no.setProximo(antigo);
		no.setElemento(o);
		anterior.setProximo(no);
		antigo.setAnterior(no);
		tamanho++;
	}

	@Override
	public void insertAfter(No n, Object o) {
		No antigo = n;
		No proximo = antigo.getProximo();
		No no = new No();
		no.setAnterior(antigo);
		no.setProximo(proximo);
		no.setElemento(o);
		antigo.setProximo(proximo);
		proximo.setAnterior(no);
		tamanho++;

	}

	@Override
	public void insertFist(Object o) {
		No proximo1 = inicio.getProximo();
		No no = new No();
		no.setAnterior(inicio);
		no.setProximo(proximo1);
		no.setElemento(o);
		proximo1.setAnterior(no);
		inicio.setProximo(no);
		tamanho++;
		
		
	}

	
	public void insertLast(Object o) {
		No anterior1 = fim.getAnterior();
		No no = new No();
		no.setAnterior(anterior1);
		no.setProximo(fim);
		no.setElemento(o);
		anterior1.setProximo(no);
		fim.setAnterior(no);
		tamanho++;
	}

	@Override
	public void remove(No n) {
		n.getAnterior().setProximo(n.getProximo());
		n.getProximo().setAnterior(n.getAnterior());
		n.setAnterior(null);
		n.setProximo(null);
		tamanho --;
	}

	@Override
	public No atRank(int r) {
		No no = new No();
		if(r <=size()/2) {
			no = inicio;
			for (int i = 0; i < r; i++) {
				no = no.getProximo();
			}
		}
		else {
			no = fim;
			for (int i = 0; i < size()-r-1; i++) {
				no = no.getAnterior();
			}
		}
		return no;
	}

	@Override
	public int rankOf(No n) {
		No aux = inicio.getProximo();
		int r = 0;
		while(aux != n && aux!=fim) {
			aux = aux.getProximo();
			r++;
		}
		
		return r;
	}
	
}
