/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxheapapp;

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
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isEmpty method, of class BTree.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        BTree<String> instance = new BTree("A");
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);//a Btree with one element is not empty
    }

    /**
     * Test of getData method, of class BTree.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        BTree<String> instance = new BTree<>("A");
        String expResult = "A";
        String result = instance.getData();
        assertEquals(expResult, result);//should correctly get "A"
    }

    /**
     * Test of LevelInsert method, of class BTree.
     */
    @Test
    public void LevelInsert() {
        System.out.println("LevelInsert");
        BTree<Integer> instance = new BTree<>();
        instance.LevelInsert(instance, 1);//should result in a tree exactly like this:
        instance.LevelInsert(instance, 2);//          1
        instance.LevelInsert(instance, 3);//         / \
        instance.LevelInsert(instance, 4);//        2   3
        instance.LevelInsert(instance, 5);//       / \
        int expResult = 5;                //      4   5
        int result = instance.left.right.data;
        assertEquals(expResult, result);
    }
}
