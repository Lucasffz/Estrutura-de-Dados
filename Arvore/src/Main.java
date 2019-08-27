
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
        
        arvore.insert(18);
        arvore.insert(22);
        arvore.insert(25);
        arvore.insert(23);
        arvore.insert(27);
        arvore.insert(30);
        arvore.remover(25);
        arvore.remover(22);
        arvore.insert(35);
        arvore.insert(44);
        System.out.println(arvore.toString());
        System.out.println(arvore.root().getFb());
      
        
    	
    	
           
      
    }
}
