/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balancedbtreedemo;

/**
 *
 * @author Shiqiang Liang shl083 11208088
 */
public class BTree {
    BTree leftBtree;
    BTree rightBtree;
    String someInfo;
    
    BTree() {
        leftBtree = null;
        rightBtree = null;
        someInfo = "";  // we don't really care about this
    }
    
    String getInfo() {
        return (this.someInfo);
    }
    boolean isEmpty() {
        return (this.leftBtree == null && this.rightBtree == null);
    }
    String inOrderTraverse() {
        String tempS = new String("");
        // insert left subtree stuff if there
        if (!this.leftBtree.isEmpty()) {
            tempS = this.leftBtree.inOrderTraverse();
            
        }
        // insert our value
        tempS = tempS.concat(this.someInfo);
        tempS = tempS.concat(", "); 
        
        if (!this.rightBtree.isEmpty()) {
            tempS = tempS.concat(this.rightBtree.inOrderTraverse());
        }
        return (tempS);
    }
    String postOrderTraverse() {
        String tempS = new String("");
        // insert left subtree stuff if there
        if (!this.leftBtree.isEmpty()) {
            tempS = this.leftBtree.postOrderTraverse();
        }
                
        if (!this.rightBtree.isEmpty()) {
            tempS = tempS.concat(this.rightBtree.postOrderTraverse());
        }
        // insert our value
        tempS = tempS.concat(this.someInfo);
        tempS = tempS.concat(", "); 
        return (tempS);
    }
    String preOrderTraverse() {
        String tempS = new String("");
        // insert our value
        tempS = this.someInfo.concat(", ");
        // insert left subtree stuff if there
        if (!this.leftBtree.isEmpty()) {
            tempS = tempS.concat(this.leftBtree.preOrderTraverse());
        }
                
        if (!this.rightBtree.isEmpty()) {
            tempS = tempS.concat(this.rightBtree.preOrderTraverse());
        }
        
        return (tempS);
    }
    BTree inorderInsert(String inString) {
        // will usually return a ref to itself
        //insert here if current tree is empty
        if (this.isEmpty()) {
            this.someInfo = inString;
            this.leftBtree = new BTree();
            this.rightBtree = new BTree();
            return (this);
        }
        if (this.someInfo.compareTo(inString) > 0) { // insert into left subtree
            this.leftBtree.inorderInsert(inString);
            return (this);
        } else {
            this.rightBtree.inorderInsert(inString);
        }
        return (this);
    }
    BTree inorderDelete(String inString) {
        BTree tempBtree, mySuccessor;
        // don't do anything if I am empty
        if (this.isEmpty()) {
            return (this);  // simply return
        }
        // if we don't contain the value go left or right as required by inOrder
        if (this.someInfo.compareTo(inString) < 0)  {  // go right
            this.rightBtree = this.rightBtree.inorderDelete(inString);
            return (this);
        } else { // go left
            if (this.someInfo.compareTo(inString) > 0)  { // go left
                this.leftBtree = this.leftBtree.inorderDelete(inString);
                return (this);
            }
        }
        
        // we contain the info - if one BTree is empty return the other
           
            if (this.leftBtree.isEmpty()) { 
                tempBtree = this.rightBtree;
                this.rightBtree = null;
                return (tempBtree);  // return after making me empty
            } else {
                if (this.rightBtree.isEmpty()) {
                    tempBtree = this.leftBtree;
                    this.leftBtree = null;
                    return (tempBtree);  // return after making me empty
                }
            }
            // to get here we contain the info to delete and have two non-empty subtrees
            // find either immediate predecessor or successor - doesn't matter which at this point
            // my successor = predessor of my right sub tree
            mySuccessor = this.rightBtree.predecessor();
            // copy info from successor to me
            this.someInfo = mySuccessor.getInfo();
            // delete the successor BTree
            this.rightBtree = this.rightBtree.inorderDelete(this.someInfo);
            // done
        return (this);
    }
    BTree predecessor() {
        // move left as far as we can go
       if (this.leftBtree.isEmpty()) {
           return (this);
       } else {
           return(this.leftBtree.predecessor());
       }
    }
}
