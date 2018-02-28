
public interface Pilha {
	
	public int size();
	public boolean isEmpty();
	public Object top() throws Epilhavazia;
	public void push(Object o);
	public Object pop() throws Epilhavazia;
	

}
