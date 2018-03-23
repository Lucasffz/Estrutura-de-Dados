
public interface Sequencia {
	//Tamanho da sequencia
	public int size();
	//Sequencia está vazia
	public boolean isEmpty();
	//Retorna o elemento do índice setado
	public Object elemAtRank(int r);
	
	public Object replaceAtRank(Object o,int r);
	//remove o elemento com este índice
	public void removeAtRank(int r);
	
	//retorna o primeiro elemento
	public Object fist();
	
	//retorna o ultimo elemento
	public Object last();
	
	//retorna o nó anterior ao nó setado
	public No before(No n);
	
	//retorna o nó posterior ao nó setado
	public No after(No n);
	
	//substituir o elemento de um nó
	public Object replaceElement(No n, Object o);
	
	//troca o elemento de dois nós
	public void swapElements(No n,No q);
	
	//Insere um elemento antes do nó setado
	public void insertBefore(No n,Object o);
	
	//Insere um elemento depois do nó setado
	public void insertAfter(No n,Object o);
	
	//Insere um elemento no primeiro nó
	public void insertFist(Object o);
	
	//insere o elemento no ultimo
	void insertLast(Object o);
	
	//remove o nó
	public void remove(No n);
	//
	public No atRank(int r);
	
	public int rankOf(No n);
	
}
