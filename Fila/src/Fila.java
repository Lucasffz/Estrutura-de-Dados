public interface Fila {
	public int tamanho();
	public boolean estaVazia();
	public Object inicio() throws EFilaVazia;
	public Object desenfileirar() throws EFilaVazia;
	public void enfileirar(Object o);

}
