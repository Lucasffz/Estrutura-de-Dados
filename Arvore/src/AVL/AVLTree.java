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
    
        
        
      public NodeBT insert(Object o, int key,Position p) throws InvalidPositionException{
        NodeBT node;  
        if(isEmpty()){
              node = new NodeBT(key,o,null);
              setRoot(node);
              size++;
          }
          else{
          node = (NodeBT) search(key,(NodeBT) p);
          if(key == node.getKey())//significa que o nodo é interno nesse caso faz uma chamada recursiva para o filho e insere
              return insert(o,key,node.getLeft());
          insertAtExternal(node,o);
          size++;
          }
          return node;
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
    
    
    
    
}
