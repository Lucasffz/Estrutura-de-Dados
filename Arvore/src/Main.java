
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
        arvore.insert(8);
        arvore.insert(7);
        arvore.insert(9);
        arvore.insert(14);
        arvore.insert(17);
        arvore.insert(13);
        arvore.insert(15);
        arvore.insert(16);
        arvore.remover(14);
        arvore.insert(20);
        arvore.insert(25);
        arvore.insert(5);
        arvore.insert(3);
      
     
        System.out.println(arvore.toString());

        
        
    	
    	
           
      
    }
}
