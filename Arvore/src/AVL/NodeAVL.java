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
    
    
    
}
