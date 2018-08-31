package AVL;

import binary.ClassBT;
import binary.NodeAVL;
import interfaces.InvalidPositionException;
import interfaces.Position;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 20171014040029
 */
public class AVLTree  {
        NodeAVL root;
        int size;
        ArrayList<NodeAVL> nodesPost = new ArrayList<NodeAVL>();
        ArrayList<NodeAVL> nodesPre = new ArrayList<NodeAVL>();
        ArrayList<NodeAVL> nodesIn = new ArrayList<NodeAVL>();
        
        public AVLTree(){
            root = null;
            size = 0;
        }
    
        
      public void insert(Object o, int key) throws InvalidPositionException{
          NodeAVL node = new NodeAVL (key,o,null);
          if(isEmpty()){
              setRoot(node);
              size = 1;       
          } 
          else
              insert(node, root);
      }
           
      public void insert(NodeAVL node,NodeAVL subTree) throws InvalidPositionException{
          NodeAVL auxnode = (NodeAVL) search(node.getKey(),subTree);
          node.setParent(auxnode);
          //Se a chave do nó a ser inserido for menor ou igual a do nó retornado na busca, inserimos o nó o lado esquerdo
          if( node.getKey() <= auxnode.getKey() ){
                auxnode.setLeft(node);
                size++;
            }
          else{
              auxnode.setRight(node);
              size++;
          }
      }
         
        
     public Object remover(int key) throws InvalidPositionException {
        if( isEmpty()){
            throw new InvalidPositionException("Ávore vazia");
        }
        NodeAVL node = (NodeAVL) search(key, root);
        if(isRoot(node)){
            throw new InvalidPositionException("Não é possível remover a raiz");
         }
        //Sendo nó externo
        if(isExternal(node)){
            //se a chave do nó a ser removido for menor que a chave do pai, siginifica que ele esta
            //a esquerda do pai
            if(node.getKey()<= node.getParent().getKey())
                node.getParent().setLeft(null);         
            else
                node.getParent().setRight(null);
            node.setParent(null);
            size--;
            return node.getKey();
        }
        //caso tenha um filho esquerdo
        if(hasLeft(node) && !hasRight(node)){
            //caso o nó a ser removido esteja do lado esquerdo
            if(node.getKey()<= node.getParent().getKey()){
                node.getParent().setLeft(node.getLeft());
                node.getLeft().setParent(node.getParent());
            }
            else{
                node.getParent().setRight(node.getRight());
                node.getRight().setParent(node.getRight());
            }
            node.setParent(null);
            size--;
            return node.getKey();
        }
        //caso tenha um filho direito
        if(!hasLeft(node) && hasRight(node)){
            if(node.getKey()<= node.getParent().getKey()){
                node.getParent().setLeft(node.getRight());
                node.getRight().setParent(node.getParent());
                
            }
            else{
                node.getParent().setRight(node.getRight());
                node.getRight().setParent(node.getParent());
            }
            node.setParent(null);
            size--;
            return node.getKey();
        }
        //No caso do nó ter dois filhos, precisamos descobrir o substituto
        if(hasLeft(node) && hasRight(node)){ 
            NodeAVL passer = node.getRight();
            while (passer.getLeft() != null) 
                passer = passer.getLeft();
            int auxKey = passer.getKey();
            int antkey = node.getKey();
            Object element = passer.getElement();
            remover(auxKey);
            node.setKey(auxKey);
            node.setElement(element);
            size--;
            return antkey;
         }
        return null;
    }
     
     public Position search(int key,Position p){
        NodeAVL node = (NodeAVL) p;
        if(isExternal(node)) // Nesse caso o nó inserido não tem filhos
            return node;
        if(key < node.getKey()){//Procura o nodo na subarvore esquerda
            if(node.getLeft() == null)
                return node;
            return search(key,node.getLeft());
        }
        else if(key == node.getKey()) 
            return node;
        else{ //procura o nó na subarvore direita
            if(node.getRight() == null)
                return node;
            return search(key,node.getRight());
        }
    }
    //método pra pegar o fator de balanceamento, verificando a altura dos filhos
    public int checkFB(NodeAVL node){
        return height(node.getLeft()) - height(node.getRight());
    }
    
    //Caso o fator de balanceamento esteja maior que 1 ou menor que -1
    public boolean isUnbalanced(NodeAVL node) throws InvalidPositionException {
        if (node.getFb()> 1 || node.getFb() < -1) 
            return true;       
        return false;
    }
    
    public void simpleRotationLeft (NodeAVL node) throws InvalidPositionException{
      //O nó que está a direita do desbalanceado irá rotacionar e se tonará o novo pai deste nó  
      NodeAVL newParent = node.getRight();
      // Se o novo pai tiver uma subarvore a sua esquerda, essa subárvore passará a ser o filho direito do nó rotacionado; 
      if(hasLeft(newParent))
          node.setRight(newParent.getLeft());
      else
          node.setRight(null);
      // Node passa a ser o pai da antiga subarvore direita
      node.getLeft().setParent(node);
      //verifica se o node possui um pai se sim o node newParent irá receber
      if(node.getParent() != null)
          newParent.setParent(node.getParent());
      else
          newParent.setParent(null);
      //seta o new parent como pai do nodo
      node.setParent(newParent);
      
      // aqui no fim atualiza o fato de balanceamento
        
    }
    
    public void simpleRotationRight (NodeAVL node) throws InvalidPositionException{
      NodeAVL newParent = node.getLeft();
        
      if(hasRight(newParent))
          node.setLeft(newParent.getRight());
      else
          node.setLeft(null);
      // Node passa a ser o pai da antiga subarvore direita
      node.getRight().setParent(node);
      //verifica se o node possui um pai se sim o node newParent irá receber
      if(node.getParent() != null)
          newParent.setParent(node.getParent());
      else
          newParent.setParent(null);
      //seta o new parent como pai do nodo
      node.setParent(newParent);
      
      //Atualiza o fator de balanceamento dos 2 nodos alterados
        
    }
    
    public void doubleRotationLeft (NodeAVL node){
        simpleRotationRight(node);
        simpleRotationLeft(node);
    }
    
    public void DoubleRotationRight (NodeAVL node){
        simpleRotationRight(node);
        simpleRotationLeft(node);
    }
    
    
    public void balance(NodeAVL node){
        if(node.getFb() >= 2){
            if(node.getLeft().getFb() >=0)
                simpleRotationRight(node);
            else
                DoubleRotationRight(node);
        }
        else{
            if(node.getRight().getFb() <0)
                   simpleRotationLeft(node);
            else
                doubleRotationLeft(node);
        } 
    }
    
    //passear ávore e alterar os fatores de balanceamento
    public void passerChangeFB(NodeAVL node, int method) throws InvalidPositionException{
        
       
        NodeAVL passer;
        if(isRoot(node))
            return;
        else
            passer = node.getParent();
         //se o method é igual a 1, significa que se trata do método de inserção
        if (method == 1){
            //Se o nodo for esquerdo significa que o pai irá receber +1 no fator de balanceamento ou -1 caso direito
            if(passer.getLeft() == node)
                passer.setKey(passer.getKey()+1);
            else
                passer.setKey(passer.getKey()-1);
            // A codição de parada no caso da inserção
            if(passer.getFb() == 0)
                return;
            //Verificar se após a alteração do fator de balanceamento a subArvore desbalanceou
            if(isUnbalanced(passer))
                balance(passer);
            passerChangeFB(passer, 1);
        }
        //se for diferente de 1 siginifica que o método é uma remoção
        else{
         //Se o nodo for esquerdo significa que o pai irá receber -1 no fator de balanceamento ou +1 caso direito
            if(passer.getLeft() == node)
                passer.setKey(passer.getKey()-1);
            else
                passer.setKey(passer.getKey()+1);
            // A codição de parada no caso da remoção
            if(passer.getFb() != 0)
                return;
            //Verificar se após a alteração do fator de balanceamento a subArvore desbalanceou
            if(isUnbalanced(passer))
                balance(passer);
            passerChangeFB(passer, 1);
            
        }
            
    }
    
    
    
    
    
    
    //Métodos da árvore binária sobreescritos
    
     public NodeAVL getLeft(NodeAVL no) throws InvalidPositionException {
        if(hasLeft(no))
            return no.getLeft();      
        else
            return null;
    }

    
     public NodeAVL insertLeft(NodeAVL no,Object o,int key) throws InvalidPositionException{
         if(hasLeft(no))
             throw new InvalidPositionException("Já tem nó esquerdo!");
         
         NodeAVL n = new NodeAVL(key,o,no);
         no.setLeft(n);
         n.setParent(no);
         size++;
         return n;
     }
     
   
    public NodeAVL insertRight(NodeAVL no,Object o, int key) throws InvalidPositionException{
        if(hasRight(no))
            throw new InvalidPositionException("Já tem nó direito!");
        
        NodeAVL n = new NodeAVL(key,o,no);
        no.setRight(n);
        size++;
        return n;
    }
     
     
    
    public NodeAVL getRight(NodeAVL no) throws InvalidPositionException {
         if(hasRight(no))
            return no.getRight();       
        else
            return null;
    }

    
    public boolean hasLeft(NodeAVL no) throws InvalidPositionException {
        return no.getLeft() != null;
    }

    
    public boolean hasRight(NodeAVL no) throws InvalidPositionException {
        return  no.getRight() != null;
    }

    
    public int size() {
       return size;
    }

   
    public int height(Position p) {
        if(root == null)
            return 0;
        NodeAVL node = (NodeAVL) p;
        int heightLeft;  
        int heightRight; 
        
        if(node!=null)  {  
            heightLeft = height(node.getLeft());  
            heightRight = height(node.getRight());   
            
            if(heightLeft > heightRight)   
                return (heightLeft+1);  
            else  
                return (heightRight+1);  
        }  
        else  
            return 0;
    }

    
    public int depth(Position p) {
        NodeAVL node = (NodeAVL) p;
        
        if(isRoot(node))
            return 0;
        else
            return 1 + depth(node.getParent());
    }

  
   
    public boolean isEmpty() {       
       return root == null;
    }

    
    public Iterator elements() {
        if(isEmpty())
            return null;
        ArrayList<Object> elements = new ArrayList<Object>();
        Iterator nodes = inOrder(root);
        while(nodes.hasNext()){
            NodeAVL node = (NodeAVL) nodes.next();
            elements.add(node.getElement());
        }
        return elements.iterator();
    }
    
    
    public Iterator nos() {   
        if(root == null)
            return null;
        else
            return inOrder(root);
    }

   
    public NodeAVL root() {
       return root;
    }
    
    public void setRoot(NodeAVL root){
        this.root = root;
    }

    
    public Position parent(Position p) {
         NodeAVL node = (NodeAVL) p;
         return node.getParent();
    }

   
    public Iterator children(Position p) {
        NodeAVL node = (NodeAVL) p;
        if(isExternal(node))
            return null;
        else{
            ArrayList<NodeAVL> children = new ArrayList<NodeAVL>();
            children.add(node.getLeft());
            children.add(node.getRight());
            return (Iterator) children;
        }
    }

    
    public boolean isExternal(Position p) {
        NodeAVL node = (NodeAVL) p;
        return node.getLeft()== null && node.getRight()== null;
    }

  
    public boolean isInternal(Position p) {
         NodeAVL node = (NodeAVL) p;
         return !isExternal(node); // ou return node.getLeft()!= null && node.getRight()!= null;
    }

    
    public boolean isRoot(Position p) {
        NodeAVL node = (NodeAVL) p;
        return node == root;
    }

   
    public Object replace(Position p, Object o) {
        NodeAVL node = (NodeAVL) p;
        Object aux = node.getElement();
        node.setElement(o);
        return aux;   
    }
    
  



    
    
    private NodeAVL removeLower(NodeAVL node) throws InvalidPositionException{
        if (node == null) {
            return root;
        } 
        else if (node.getLeft() != null) {
            node.setLeft(removeLower(node.getLeft()));
            return node;
        } 
        else
            return node.getRight();
    }

  
    public NodeAVL getSibling(NodeAVL no) throws InvalidPositionException {
        if(isEmpty()){
            throw new InvalidPositionException("ávore vazia.");
        }
        NodeAVL node = no.getParent();
        NodeAVL nodeAux = null;
        if(node.getLeft()==no)
            nodeAux = node.getRight();
        else if(node.getRight()==no)
            nodeAux =  node.getLeft();
        return nodeAux;
    }
    
    
    public void add(int key, Object o) throws InvalidPositionException {
        NodeAVL node = new NodeAVL(key,o,null);
        NodeAVL node2 = (NodeAVL) search(key,root());
        if(key == node2.getKey()){
           throw new InvalidPositionException("Posição inválida");
        }
        else if(key<node2.getKey()){
            node2.setLeft(node);
            node.setParent(node2);
            size++;
        }
        
        else{
            node2.setRight(node);
            node.setParent(node2);
            size++;
        }
       
    }
    //Para o root como primeiro nodo

  
    
    public void insertAtExternal(NodeAVL node,Object o){
        node.setLeft(null);
        node.setRight(null);
        node.setElement(o);
        size++;
    }
    
    
    public void swapElements(Position p1, Position p2) throws InvalidPositionException {
        NodeAVL node1 = (NodeAVL) p1;
        NodeAVL node2 = (NodeAVL) p2;
        Object aux = node1.getElement();
        node1.setElement(node2.getElement());
        node2.setElement(aux);
        
    }
    
    //Métodos de ordenação
    public ArrayList<NodeAVL> posOrder(Position p){

        NodeAVL node = (NodeAVL) p;
        if(node.getLeft() != null){
            posOrder(node.getLeft());
        }
        if(node.getRight() != null)
            posOrder(node.getRight());
        nodesPost.add(node);
        return nodesPost;
    }
    
    public ArrayList<NodeAVL> preOrder(Position p){
        NodeAVL node = (NodeAVL) p;
        nodesPre.add(node);
        if(node.getLeft() != null)
            preOrder(node.getLeft());
        if(node.getRight()!=null)
            preOrder(node.getRight());
        return nodesPre;
    }
    
    public ArrayList<NodeAVL> inOrder(Position p){
        NodeAVL node = (NodeAVL) p;
        if(isInternal(node)){
            inOrder(node.getLeft());
            nodesIn.add(node);
        }
        else if(node != null){
            nodesIn.add(node);
        }
        if(isInternal(node)){
            inOrder(node.getRight());
        }
        return nodesIn;    
       
    }
   
        
    public void printTree(NodeAVL no, String indent, Boolean last){
        System.out.println(indent + "+- " + no.getElement());
        indent += last ? "   " : "|  ";
                
        Iterator itr = inOrder(no);
        while(itr.hasNext()){
            NodeAVL n = (NodeAVL)itr.next();
            printTree(n, indent, itr.hasNext());
        }
    }
     
    
}

    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   