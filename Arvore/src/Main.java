
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
        NodeAVL A = arvore.root();
        arvore.insert(14);
        NodeAVL B = arvore.root().getRight();
        arvore.insert(19);
        
        
         
        
        System.out.println(A.getFb());
        System.out.println(B.getRight().getKey());
        //System.out.println(arvore.root().getFb());
        
        
    	
    	
           
      
    }
}
