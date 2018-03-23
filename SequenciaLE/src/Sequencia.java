
public interface Sequencia {
	//Tamanho da sequencia
	public int size();
	//Sequencia est� vazia
	public boolean isEmpty();
	//Retorna o elemento do �ndice setado
	public Object elemAtRank(int r);
	
	public Object replaceAtRank(Object o,int r);
	//remove o elemento com este �ndice
	public void removeAtRank(int r);
	
	//retorna o primeiro elemento
	public Object fist();
	
	//retorna o ultimo elemento
	public Object last();
	
	//retorna o n� anterior ao n� setado
	public No before(No n);
	
	//retorna o n� posterior ao n� setado
	public No after(No n);
	
	//substituir o elemento de um n�
	public Object replaceElement(No n, Object o);
	
	//troca o elemento de dois n�s
	public void swapElements(No n,No q);
	
	//Insere um elemento antes do n� setado
	public void insertBefore(No n,Object o);
	
	//Insere um elemento depois do n� setado
	public void insertAfter(No n,Object o);
	
	//Insere um elemento no primeiro n�
	public void insertFist(Object o);
	
	//insere o elemento no ultimo
	void insertLast(Object o);
	
	//remove o n�
	public void remove(No n);
	//
	public No atRank(int r);
	
	public int rankOf(No n);
	
}
