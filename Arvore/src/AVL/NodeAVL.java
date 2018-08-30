/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AVL;

import binary.NodeBT;

/**
 *
 * @author 20171014040029
 */
public class NodeAVL extends NodeBT {
    private NodeAVL parent,left,right;
    private int fb;
    
    public NodeAVL(int key, Object element, NodeBT parent) {
        super(key, element, parent);
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
