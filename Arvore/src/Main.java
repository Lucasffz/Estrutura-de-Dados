
import binary.ClassBT;
import binary.ClassBTArray;
import binary.NodeBT;
import generic.ClassGT;
import generic.NodeGT;
import interfaces.InvalidPositionException;
import interfaces.Position;
import java.util.Iterator;
import AVL.AVLTree;
import AVL.NodeAVL;

public class Main {
    
    public static void main(String[] args) throws InvalidPositionException{
        
      
    	AVLTree arvore = new AVLTree();
    	arvore.insert(10);
    
   
        
               
        NodeAVL raiz = (NodeAVL) arvore.search(10, arvore.root());
        
        System.out.println(arvore.root().getFb());
        
        
    	
    	
           
      
    }
}
