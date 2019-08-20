package AVL;

import binary.NodeBT;

/**
 *
 * @author 20171014040029
 */
public class NodeAVL extends NodeBT {
    private NodeAVL parent,left,right;
    private int fb; // Fator de balanceamento
    
    public NodeAVL(int key, Object element, NodeBT parent) {
        super(key, element, parent);
    }
    
    public NodeAVL(int key, NodeBT parent) {
    	super(key, parent);
        this.fb = 0;
    }
    
    public int getFb(){
        return fb;
    }
    public void setFb(int fb){
        this.fb = fb;
    }

    public NodeAVL getParent() {
        return parent;
    }

    public void setParent(NodeAVL parent) {
        this.parent = parent;
    }

    public NodeAVL getLeft() {
        return left;
    }

    public void setLeft(NodeAVL left) {
        this.left = left;
    }

    public NodeAVL getRight() {
        return right;
    }

    public void setRight(NodeAVL right) {
        this.right = right;
    }
    
    
    
    
    
}
