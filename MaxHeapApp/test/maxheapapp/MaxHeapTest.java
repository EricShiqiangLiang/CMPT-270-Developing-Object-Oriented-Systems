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
public class MaxHeapTest {
    
    public MaxHeapTest() {
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
     * Test of add method, of class MaxHeap.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        MaxHeap instance = new MaxHeap();
        instance.add(1);
        int expResult = 1;
        int result = (int) instance.elements.data;
        assertEquals(expResult, result);
        instance.add(2);// heap structure:    3        
        instance.add(3);//                   / \
        expResult = 2;//                    1   2
        result = (int) instance.elements.right.data;
        assertEquals(expResult, result);
    }

    /**
     * Test of empty method, of class MaxHeap.
     */
    @Test
    public void testEmpty() {
        System.out.println("empty");
        MaxHeap instance = new MaxHeap();
        Boolean expResult = true;
        Boolean result = instance.empty();
        assertEquals(expResult, result);
        instance.add(1);
        expResult = false;//a heap with one element is not empty
        result = instance.empty();
        assertEquals(expResult, result);
    }

    /**
     * Test of peek method, of class MaxHeap.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        MaxHeap instance = new MaxHeap();
        instance.add(1);
        instance.add(4);
        instance.add(7);
        instance.add(9);
        int expResult = 9;
        int result = (int) instance.peek().data;//should get 9
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class MaxHeap.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        MaxHeap instance = new MaxHeap();
        instance.add(1);
        instance.add(2);
        instance.add(3);
        instance.add(4);
        instance.remove();
        int result = (int) instance.elements.data;
        int expResult = 3;
        assertEquals(expResult, result);
        result = (int) instance.elements.left.data;
        expResult = 1;
        assertEquals(expResult, result);
        result = (int) instance.elements.right.data;
        expResult = 2;
        assertEquals(expResult, result);//remove should delete the root and maintain max heap property
    }

    /**
     * Test of findLastElement method, of class MaxHeap.
     */
    @Test
    public void testFindLastElement() {
        System.out.println("findLastElement");
        MaxHeap instance = new MaxHeap();
        instance.add(1);
        instance.add(2);
        instance.add(3);
        instance.add(4);
        int expResult = 1;
        int result = (int) instance.findLastElement().data;
        assertEquals(expResult, result);//the last element should be 1
    }


    /**
     * Test of findParent method, of class MaxHeap.
     */
    @Test
    public void testFindParent() {
        System.out.println("findParent");
        MaxHeap instance = new MaxHeap();
        instance.add(1);
        BTree<Comparable> lastElement = instance.findLastElement();
        int expResult = (int) instance.elements.data;
        BTree<Comparable> parent = instance.findParent(instance.elements, lastElement);
        int result = (int) parent.data;
        assertEquals(expResult, result);//if there is only one element in the heap, then the reulst should be itself
        instance.add(2);
        instance.add(3);
        instance.add(4);
        lastElement = instance.findLastElement();
        expResult = (int) instance.elements.left.data;
        parent = instance.findParent(instance.elements, lastElement);
        result = (int) parent.data;
        assertEquals(expResult, result);//the parent of the last element should be correctly found
    }

    /**
     * Test of swap method, of class MaxHeap.
     */
    @Test
    public void testSwap() {
        System.out.println("swap");
        MaxHeap instance = new MaxHeap();
        instance.add(1);
        instance.add(2);
        instance.add(3);
        instance.add(4);
        int expResult = 4;
        int result = (int) instance.elements.data;
        assertEquals(expResult, result);//swap is embeded  in add method, if it works then the root node should be the largest
    }
    
}
