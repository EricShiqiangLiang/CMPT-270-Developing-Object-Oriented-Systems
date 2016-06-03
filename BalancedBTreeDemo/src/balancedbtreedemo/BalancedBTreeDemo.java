/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balancedbtreedemo;

/**
 *
 * @author 世强
 */
public class BalancedBTreeDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BalancedBTree myTree = new BalancedBTree();
        myTree.inorderInsert("A");
        myTree = myTree.reBalance(myTree);
        myTree.inorderInsert("B");
        myTree = myTree.reBalance(myTree);
        myTree.inorderInsert("C");
        myTree = myTree.reBalance(myTree);
        myTree.inorderInsert("D");
        myTree = myTree.reBalance(myTree);
        myTree.inorderInsert("E");
        myTree = myTree.reBalance(myTree);
        myTree.inorderInsert("F");
        myTree = myTree.reBalance(myTree);
        myTree.inorderInsert("G");
        myTree = myTree.reBalance(myTree);
        myTree.inorderInsert("H");
        myTree = myTree.reBalance(myTree);
        myTree.inorderInsert("I");
        myTree = myTree.reBalance(myTree);
        String result = myTree.leftBtree.leftBtree.someInfo + myTree.leftBtree.someInfo
        + myTree.leftBtree.rightBtree.someInfo + myTree.someInfo + myTree.rightBtree.leftBtree.someInfo
        + myTree.rightBtree.someInfo + myTree.rightBtree.rightBtree.leftBtree.someInfo + myTree.rightBtree.rightBtree.someInfo
        + myTree.rightBtree.rightBtree.rightBtree.someInfo;
        System.out.println("Should be ABCDEFGHI if the reBalance method is correct:" + result);
        System.out.println("The tree is balanced:" + myTree.isBalanced(myTree));
    }
    
}
