/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balancedbtreedemo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 世强
 */
public class BalancedBTreeTest {
    
    public BalancedBTreeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of rotateLL method, of class BalancedBTree.
     */
    @Test
    public void testRotateLL() {
        System.out.println("rotateLL");
        BalancedBTree instance = new BalancedBTree();
        instance.inorderInsert("D");
        instance.inorderInsert("C");
        instance.inorderInsert("B");
        instance.inorderInsert("A");
        instance.inorderInsert("E");
        BalancedBTree Tree = instance.rotateLL(instance);
        String expResult = "EDCBA";
        String result = Tree.rightBtree.rightBtree.someInfo + Tree.rightBtree.someInfo
        + Tree.someInfo + Tree.leftBtree.someInfo + Tree.leftBtree.leftBtree.someInfo;
        assertEquals(expResult, result);
    }

    /**
     * Test of rotateRR method, of class BalancedBTree.
     */
    @Test
    public void testRotateRR() {
        System.out.println("rotateRR");
        BalancedBTree instance = new BalancedBTree();
        instance.inorderInsert("B");
        instance.inorderInsert("C");
        instance.inorderInsert("D");
        instance.inorderInsert("E");
        instance.inorderInsert("A");
        BalancedBTree Tree = instance.rotateRR(instance);
        String expResult = "EDCBA";
        String result = Tree.rightBtree.rightBtree.someInfo + Tree.rightBtree.someInfo
        + Tree.someInfo + Tree.leftBtree.someInfo + Tree.leftBtree.leftBtree.someInfo;
        assertEquals(expResult, result);
    }

    /**
     * Test of rotateLR method, of class BalancedBTree.
     */
    @Test
    public void testRotateLR() {
        System.out.println("rotateLR");
        BalancedBTree instance = new BalancedBTree();
        instance.inorderInsert("F");
        instance.inorderInsert("G");
        instance.inorderInsert("B");
        instance.inorderInsert("A");
        instance.inorderInsert("D");
        instance.inorderInsert("C");
        instance.inorderInsert("E");
        BalancedBTree Tree = instance.rotateLR(instance);
        String expResult = "ABCDEFG";
        String result = Tree.leftBtree.leftBtree.someInfo + Tree.leftBtree.someInfo
        + Tree.leftBtree.rightBtree.someInfo + Tree.someInfo + Tree.rightBtree.leftBtree.someInfo
        + Tree.rightBtree.someInfo + Tree.rightBtree.rightBtree.someInfo;
        assertEquals(expResult, result);
    }

    /**
     * Test of rotateRL method, of class BalancedBTree.
     */
    @Test
    public void testRotateRL() {
        System.out.println("rotateRL");
        BalancedBTree instance = new BalancedBTree();
        instance.inorderInsert("B");
        instance.inorderInsert("A");
        instance.inorderInsert("F");
        instance.inorderInsert("D");
        instance.inorderInsert("C");
        instance.inorderInsert("E");
        instance.inorderInsert("G");
        BalancedBTree Tree = instance.rotateRL(instance);
        String expResult = "ABCDEFG";
        String result = Tree.leftBtree.leftBtree.someInfo + Tree.leftBtree.someInfo
        + Tree.leftBtree.rightBtree.someInfo + Tree.someInfo + Tree.rightBtree.leftBtree.someInfo
        + Tree.rightBtree.someInfo + Tree.rightBtree.rightBtree.someInfo;
        assertEquals(expResult, result);
    }

    /**
     * Test of getHeight method, of class BalancedBTree.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        BalancedBTree instance = new BalancedBTree();
        instance.leftHeight = 10;
        instance.rightHeight = 11;
        int expResult = 11;
        int result = instance.getHeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of height method, of class BalancedBTree.
     */
    @Test
    public void testHeight() {
        System.out.println("height");
        BalancedBTree instance = new BalancedBTree();
        instance.inorderInsert("A");
        instance.inorderInsert("B");
        instance.inorderInsert("C");
        instance.inorderInsert("D");
        instance.inorderInsert("E");
        int expResult = 5;
        int result = instance.height(instance);
        assertEquals(expResult, result);
    }

    /**
     * Test of setHeight method, of class BalancedBTree.
     */
    @Test
    public void testSetHeight() {
        System.out.println("setHeight");
        BalancedBTree instance = new BalancedBTree();
        instance.inorderInsert("A");
        instance.inorderInsert("B");
        instance.inorderInsert("C");
        instance.setHeight(instance);
        int expResult1  = 0;
        int expResult2 = 2;
        int result1 = instance.leftHeight;
        int result2 = instance.rightHeight;
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of inorderInsert method, of class BalancedBTree.
     */
    @Test
    public void testInorderInsert() {
        System.out.println("inorderInsert");
        String inString = "";
        BalancedBTree instance = new BalancedBTree();
        instance.inorderInsert("A");
        instance.inorderInsert("B");
        instance.inorderInsert("C");
        String expResult = "ABC";
        String result = instance.someInfo + instance.rightBtree.someInfo
        + instance.rightBtree.rightBtree.someInfo;
        assertEquals(expResult, result);
    }

    /**
     * Test of inorderDelete method, of class BalancedBTree.
     */
    @Test
    public void testInorderDelete() {
        System.out.println("inorderDelete: Empty tree:");
        BTree instance = new BTree();
        String inString = "";
        // Test 1: Delete in an empty tree
        BTree expResult = instance;
        BTree result = instance.inorderDelete(inString);
        assertEquals(expResult, result);
        
        // test 2: Delete when BTree is only leaf
        System.out.println("inorderDelete: Leaf delete:");
        instance.inorderInsert("Cyril");   // already tested so know this works
        assertEquals(false, instance.isEmpty()); // not empty
        result = instance.inorderDelete("Cyril");
        assertEquals(true, result.isEmpty()); // is now empty
        
        // test 3 (left and right): Delete when an non-empty tree exists in one or the other subtrees
        System.out.println("inorderDelete: intermediate one non-empty subtree delete:");
        instance = new BTree();
        instance.inorderInsert("Cyril"); 
        instance.inorderInsert("Adam"); 
        result = instance.inorderDelete("Cyril");
        assertEquals("Adam", result.someInfo); // is now empty
        System.out.println("Non empty right subtree delete");
        instance = result;
        instance.inorderInsert("Barry"); 
        result = instance.inorderDelete("Adam");
        assertEquals("Barry", result.someInfo); // is now empty
        // test 4: two non-empty subtrees
        System.out.println("Non empty subtrees delete");
        instance = new BTree();
        instance.inorderInsert("C");
        instance.inorderInsert("B");
        instance.inorderInsert("D");
        instance.inorderInsert("A");
        instance.inorderInsert("B1");
        instance.inorderInsert("C1");
        String traverse = instance.inOrderTraverse();
        assertEquals("A, B, B1, C, C1, D, ", traverse); // is now empty
        System.out.println("Non empty subtrees before delete");
        result = instance.inorderDelete("B");
        traverse = result.inOrderTraverse();
        assertEquals("A, B1, C, C1, D, ", traverse); // is now empty
    }

    /**
     * Test of rotate method, of class BalancedBTree.
     */
    @Test
    public void testReBalance() {
        System.out.println("reBalance");
        BalancedBTree instance = new BalancedBTree();
        instance.inorderInsert("B");
        instance.inorderInsert("A");
        //instance = instance.reBalance(instance);
        instance.inorderInsert("C");
        //instance = instance.reBalance(instance);
        instance.inorderInsert("D");
        //instance = instance.reBalance(instance);
        instance.inorderInsert("E");
        //instance = instance.reBalance(instance);
        instance.inorderInsert("F");
        instance = instance.reBalance(instance);
        boolean expResult = true;
        boolean result = instance.isBalanced(instance);
        assertEquals(expResult, result);
    }

    /**
     * Test of diff method, of class BalancedBTree.
     */
    @Test
    public void testGetDiff() {
        System.out.println("GetDiff");
        BalancedBTree instance = new BalancedBTree();
        instance.inorderInsert("A");
        instance.inorderInsert("B");
        instance.inorderInsert("C");
        instance.setHeight(instance);
        int expResult = 2;
        int result = instance.getDiff();
        assertEquals(expResult, result);
    }

    /**
     * Test of isBalanced method, of class BalancedBTree.
     */
    @Test
    public void testIsBalanced() {
        System.out.println("isBalanced");
        BalancedBTree tree = null;
        BalancedBTree instance = new BalancedBTree();
        boolean expResult = true;
        boolean result = instance.isBalanced(instance);
        assertEquals(expResult, result);
        instance.inorderInsert("A");
        instance.inorderInsert("B");
        expResult = true;
        result = instance.isBalanced(instance);
        assertEquals(expResult, result);
        instance.inorderInsert("C");
        expResult = false;
        result = instance.isBalanced(instance);
        assertEquals(expResult, result);
    }

    /**
     * Test of rotate method, of class BalancedBTree.
     */
    @Test
    public void testRotate() {
        System.out.println("rotate");
        BalancedBTree instance = new BalancedBTree();
        instance.inorderInsert("B");
        instance.inorderInsert("A");
        instance.inorderInsert("F");
        instance.inorderInsert("D");
        instance.inorderInsert("C");
        instance.inorderInsert("E");
        instance.inorderInsert("G");
        BalancedBTree Tree = instance.rotate(instance);
        String expResult = "ABCDEFG";
        String result = Tree.leftBtree.leftBtree.someInfo + Tree.leftBtree.someInfo
        + Tree.leftBtree.rightBtree.someInfo + Tree.someInfo + Tree.rightBtree.leftBtree.someInfo
        + Tree.rightBtree.someInfo + Tree.rightBtree.rightBtree.someInfo;
        assertEquals(expResult, result);
    }
    
    
}
