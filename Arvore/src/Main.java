
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

        arvore.insert(12);
        arvore.insert(13);
        
        
        arvore.remover(12);
        arvore.remover(13);
        arvore.remover(10);
        System.out.println(arvore.toString());
        System.out.println(arvore.root().getFb());
      
        
    	
    	
           
      
    }
}
