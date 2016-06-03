/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxheapapp;


/**
 *
 * @author 世强
 * @param <Comparable>
 */
public class BTree<Comparable> {
    BTree<Comparable> left;
    BTree<Comparable> right;
    Comparable data;

    BTree() {
    left = null;
    right = null;
    data = null;
    }    
    
    BTree(Comparable Data) {
    left = null;
    right = null;
    data = Data;
    }    
    //return:true if the tree is empty(has no element stored)
    //       false otherwise
    public boolean isEmpty() {
        return (this.left == null && this.right == null && this.data == null);
    }
    
    //return:content of this.data
    public Comparable getData() {
        return (this.data);
    }
    
    //This insert method simply inserts element from left to right. 
    //It doesn't generate an ordered BST, e.i, the BTree's root, left subtree and 
    //right subtree do not follow the left<root<right rule.
    //pre:BTree<Comparable> root:the root tree node of the tree 
    //    Comparable inData: the element to be inserted
    //post:the inData is inserted at the last postion of the tree to make the tree
    //     balanced in strcture
    //return: nothing     
    public void LevelInsert(BTree<Comparable> root, Comparable inData) {
        if (root.data == null) {
            root.data = inData;
            return;
        }
        LinkedList<BTree<Comparable>> treeQueue = new LinkedList<>();
        treeQueue.insertTail(root);
        while (!treeQueue.isEmpty()){
            try {
                BTree<Comparable> temp = treeQueue.deleteHead();
                if (temp.left != null) { // insert into left subtree if left subtree is empty
                    treeQueue.insertTail(temp.left);
                } 
                else {
                    temp.left = new BTree<>(inData);
                    return;
                }   
                if (temp.right != null) { // insert into right subtree if left subtree is empty
                    treeQueue.insertTail(temp.right);
                } 
                else {
                    temp.right = new BTree<>(inData);
                    return;
                }
            } 
            catch (Exception ex) {
                System.out.println("Cannot delete from an empty list!");
                break;
            }
        }
    }
    
}
