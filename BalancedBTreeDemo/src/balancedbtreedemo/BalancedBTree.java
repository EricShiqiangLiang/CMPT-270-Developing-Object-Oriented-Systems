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
public class BalancedBTree extends BTree{
    int leftHeight;
    int rightHeight;
    BalancedBTree() {
        super();
        leftHeight = 0;
        rightHeight = 0;
    }
    // There are 4 situations where a binary tree is not balanced, for each
    // situation, I develop a helper method called rotate to rebalance it.
    public BalancedBTree rotateLL(BalancedBTree root){
    // 1.left left (the left sub tree exceeds the right sub tree by 2)
    //       C                    B    
    //      /          =====>    / \   
    //     B                    A   C   
    //    /
    //   A
        
        BalancedBTree pivot = new BalancedBTree();
        pivot = (BalancedBTree) root.leftBtree;
        root.leftBtree = pivot.rightBtree;
        pivot.rightBtree = root;
        return (pivot);
    }
    public BalancedBTree rotateRR(BalancedBTree root){
    // 2.right right (the right sub tree exceeds the left sub tree by 2)
    //         A                    B                       
    //          \                  / \
    //           B                A   C
    //            \    =====>           
    //             C                     
        BalancedBTree pivot = new BalancedBTree();
        pivot = (BalancedBTree) root.rightBtree;
        root.rightBtree = pivot.leftBtree;
        pivot.leftBtree = root;
        return (pivot);
    }
    public BalancedBTree rotateLR(BalancedBTree root){
    // 3.left right (the right sub tree of the left sub tree exceeds 
    //                  the left sub tree by 2)
    //         F                    F                   D         
    //        / \                  / \                 / \
    //       B   G   rotateRR     D   G  rotateLL     B    F
    //      / \        =====>    / \      =====>     / \  / \
    //     A   D                B   E               A  C  E  G
    //        / \              / \                 
    //       C   E            A   C
    // In this case, rebalance steps are as follows::
    //    1. rotateRR at node B
    //    2. rotateLL at node F
    //    
        
        root.leftBtree = rotateRR((BalancedBTree) root.leftBtree);
        return (rotateLL(root));
    }
    public BalancedBTree rotateRL(BalancedBTree root){
    // 3.left right (the left sub tree of the right sub tree exceeds 
    //                  the left sub tree by 2)
    //         B                    B                   D         
    //        / \                  / \                 / \
    //       A   F   rotateLL     A   D  rotateRR     B    F
    //          / \    =====>        / \  =====>     / \  / \
    //         D   G                C   F           A   C E  G
    //        / \                      / \            
    //       C   E                    E   G
    // In this case, rebalance steps are as follows::
    //    1. rotateLL at node F
    //    2. rotateRR at node B
    //    
        
        root.rightBtree = rotateLL((BalancedBTree) root.rightBtree);
        return (rotateRR(root));
    }
    public BalancedBTree rotate(BalancedBTree tree) {
        setHeight(tree);
        if (tree.leftHeight - tree.rightHeight == 2){
                if (height((BalancedBTree)tree.leftBtree.rightBtree) > height((BalancedBTree)tree.leftBtree.leftBtree)){
                    tree = rotateLR(tree);
                    setHeight(tree);
                    return(tree);
                }
                else {
                    tree = rotateLL(tree);
                    setHeight(tree);
                    return(tree);
                }
            }
        else if (tree.rightHeight - tree.leftHeight == 2) {
                if (height((BalancedBTree)tree.rightBtree.leftBtree) > height((BalancedBTree)tree.rightBtree.rightBtree)){
                    tree = rotateRL(tree);
                    setHeight(tree);
                    return(tree);
                }
                else {
                    tree = rotateRR(tree);
                    setHeight(tree);
                    return(tree);
                    }
            }
        return(tree);
    }
    public BalancedBTree reBalance(BalancedBTree tree){
        if (!isBalanced(tree)) {
            if (isBalanced((BalancedBTree)tree.leftBtree) && isBalanced((BalancedBTree)tree.rightBtree)){
                tree = rotate(tree);
            }
            else {
                if (!isBalanced((BalancedBTree)tree.leftBtree)){
                    tree.leftBtree = reBalance((BalancedBTree) tree.leftBtree);
                    return(reBalance(tree));
                }
                if (!isBalanced((BalancedBTree)tree.rightBtree)){
                    tree.rightBtree = reBalance((BalancedBTree) tree.rightBtree);
                    return(reBalance(tree));
                }
            }
        }
        return(tree);
    }
    
    public int getHeight(){
        return Math.max(this.leftHeight, this.rightHeight);
    }
    //height() method is used in calculating the balance factor
    public int height(BalancedBTree tree){
        if (tree == null || tree.isEmpty()){
            return 0;
        }
        else {
            return (Math.max(height((BalancedBTree)tree.leftBtree), height((BalancedBTree)tree.rightBtree)) + 1);
        }
    }
    public void setHeight(BalancedBTree tree){
        tree.leftHeight = height((BalancedBTree)tree.leftBtree);
        tree.rightHeight = height((BalancedBTree)tree.rightBtree);
    }
    public int getDiff() {
        return Math.abs(this.leftHeight - this.rightHeight);
    }
    public boolean isBalanced(BalancedBTree tree) {
        if (tree == null || tree.isEmpty()){
            return true;
        }
        setHeight(tree);
        if (tree.getDiff() >= 2){
            return false;
        }
        if (tree.getDiff() < 2) {
            return (isBalanced((BalancedBTree) tree.leftBtree) && isBalanced((BalancedBTree) tree.rightBtree));
        }
        return true;
    }

    @Override
    BalancedBTree inorderInsert(String inString) {
        // will usually return a ref to itself
        //insert here if current tree is empty
        if (this.isEmpty()) {
            this.someInfo = inString;
            this.leftBtree = new BalancedBTree();
            this.rightBtree = new BalancedBTree();
            return (this);
        }
        if (this.someInfo.compareTo(inString) > 0) { // insert into left subtree
            this.leftBtree.inorderInsert(inString);
        } else {
            this.rightBtree.inorderInsert(inString);
        }
        return (this);    
    }
    @Override
        BalancedBTree inorderDelete(String inString) {
        BalancedBTree tempBtree, mySuccessor;
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
                tempBtree = (BalancedBTree) this.rightBtree;
                this.rightBtree = null;
                return (tempBtree);  // return after making me empty
            } else {
                if (this.rightBtree.isEmpty()) {
                    tempBtree = (BalancedBTree) this.leftBtree;
                    this.leftBtree = null;
                    return (tempBtree);  // return after making me empty
                }
            }
            // to get here we contain the info to delete and have two non-empty subtrees
            // find either immediate predecessor or successor - doesn't matter which at this point
            // my successor = predessor of my right sub tree
            mySuccessor =(BalancedBTree) this.rightBtree.predecessor();
            // copy info from successor to me
            this.someInfo = mySuccessor.getInfo();
            // delete the successor BTree
            this.rightBtree = this.rightBtree.inorderDelete(this.someInfo);
            // done
        return (this);
    }
}
