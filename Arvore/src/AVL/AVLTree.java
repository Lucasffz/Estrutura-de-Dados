package AVL;

import binary.ClassBT;
import binary.NodeBT;
import interfaces.InvalidPositionException;
import interfaces.Position;
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
public class AVLTree extends ClassBT {
        NodeAVL root;
        int size;
        
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
        NodeBT node = (NodeBT) search(key, root);
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
            NodeBT passer = node.getRight();
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
    
    public void simpleRotationLeft (NodeAVL node){
      //O nó que está a direita do desbalanceado irá rotacionar e se tonará o novo pai deste nó  
      NodeAVL newParent = node.getRight();
      // Se o novo pai tiver uma subarvore a sua esquerda, essa subárvore passará a ser o filho direito do nó rotacionado; 
      if(newParent.getLeft() != null)
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
    
    public void simpleRotationRight (NodeAVL node){
      NodeAVL newParent = node.getLeft();
        
      if(newParent.getRight() != null)
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
    
    
    
    
    
    
    
    
    //Métodos da árvore binária sobreescritos
    
    
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
