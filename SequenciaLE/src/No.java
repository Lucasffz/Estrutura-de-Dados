
public class No {
	private Object elemento;
	private No anterior;
	private No proximo;
	
	public No getAnterior(){
		return anterior;
	}
	public void setAnterior(No anterior) {
		this.anterior = anterior;
	}
	
	public Object getElemento() {
		return elemento;
	}
	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
	public No getProximo() {
		return proximo;
	}
	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
	
	
}
