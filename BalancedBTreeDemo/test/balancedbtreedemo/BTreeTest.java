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
public class BTreeTest {
    
    public BTreeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getInfo method, of class BTree.
     */
    @Test
    public void testGetInfo() {
        System.out.println("getInfo");
        BTree instance = new BTree();
        String expResult = "";
        String result = instance.getInfo();
        assertEquals(expResult, result);
        
        // test non-empty
        instance.inorderInsert("C");
        expResult = "C";
        result = instance.getInfo();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isEmpty method, of class BTree.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        BTree instance = new BTree();
        
        // test 1: New tree should be empty
        boolean expResult = true;
        boolean result = instance.isEmpty();  
        assertEquals(expResult, result);
        
        // insert a single value into a new tree should make new tree non-empty but
        // with two empty subtrees
        instance.inorderInsert("C");
        expResult = false;
        result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of inOrderTraverse method, of class BTree.
     */
    @Test
    public void testInOrderTraverse() {
        System.out.println("inOrderTraverse");
        BTree instance = new BTree();
        // insert some names
        instance.inorderInsert("Cyril");
        instance.inorderInsert("Donald");
        instance.inorderInsert("Adam");
        String expResult = "Adam, Cyril, Donald, ";
        String result = instance.inOrderTraverse();
        assertEquals(expResult, result);
        expResult = "Adam, Donald, Cyril, ";
        result = instance.postOrderTraverse();
        assertEquals(expResult, result);
    }

    /**
     * Test of postOrderTraverse method, of class BTree.
     */
    @Test
    public void testPostOrderTraverse() {
        System.out.println("postOrderTraverse");
        BTree instance = new BTree();
        // insert some names
        instance.inorderInsert("Cyril");
        instance.inorderInsert("Donald");
        instance.inorderInsert("Adam");
        String expResult = "Adam, Donald, Cyril, ";
        String result = instance.postOrderTraverse();
        assertEquals(expResult, result);
    }

    /**
     * Test of PreOrderTraverse method, of class BTree.
     */
    @Test
    public void testPreOrderTraverse() {
        System.out.println("PreOrderTraverse");
        BTree instance = new BTree();
       // insert some names
        instance.inorderInsert("Cyril");
        instance.inorderInsert("Donald");
        instance.inorderInsert("Adam");
        String expResult = "Cyril, Adam, Donald, ";
        String result = instance.preOrderTraverse();
        assertEquals(expResult, result);
    }

    /**
     * Test of inorderInsert method, of class BTree.
     */
    @Test
    public void testInorderInsert() {
        System.out.println("inorderInsert");
        String inString = "Cyril";
        BTree instance = new BTree();
        // test 1: Insert a single value and demonstrate it is in the info of the current BTree
        String expResult = "Cyril";
        instance.inorderInsert(inString);
        String result = instance.someInfo;
        assertEquals(expResult, result);
        
       // test 2: Insert a value that should go into the left subtree immediately below this current tree
        System.out.println("inorderInsert: into left subtree....");
        instance.inorderInsert("Adam");
        result = instance.leftBtree.someInfo;
        expResult = "Adam";
        assertEquals(expResult, result);
        
        // test 3: Insert a value that should go into
        
        
        //right subtree immediately below this current tree
        System.out.println("inorderInsert: into right subtree....");
        instance.inorderInsert("Donald");
        result = instance.rightBtree.someInfo;
        expResult = "Donald";
        assertEquals(expResult, result);
        
        // final test 4: insert into right subtree of leftsubtree of this Btree
        System.out.println("inorderInsert: into right subtree of left subtree....");
        instance.inorderInsert("Bob");
        result = instance.leftBtree.rightBtree.someInfo;
        expResult = "Bob";
        assertEquals(expResult, result);
    }

    /**
     * Test of inorderDelete method, of class BTree.
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
     * Test of predecessor method, of class BTree.
     */
    @Test
    public void testPredecessor() {
        System.out.println("predecessor");
        BTree instance = new BTree();
        instance.inorderInsert("C");
        instance.inorderInsert("B");
        instance.inorderInsert("D");
        instance.inorderInsert("A");
        instance.inorderInsert("B1");
        instance.inorderInsert("C1");
        String traverse = instance.inOrderTraverse();
        assertEquals("A, B, B1, C, C1, D, ", traverse); // is now empty
        System.out.println("Test predecessor");
        BTree result = instance.rightBtree.predecessor();
        assertEquals("C1", result.someInfo); // is now empty
    }
    
}
