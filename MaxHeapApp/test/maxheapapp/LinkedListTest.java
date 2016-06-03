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
public class LinkedListTest {
    
    public LinkedListTest() {
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
     * Test of isEmpty method, of class LinkedList.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        LinkedList<Comparable> instance = new LinkedList<>();
        instance.insertTail(1);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of insertHead method, of class LinkedList.
     */
    @Test
    public void testInsertHead() {
        System.out.println("insertHead");
        LinkedList<Comparable> instance = new LinkedList<>();
        instance.insertHead(1);
        instance.insertHead(2);
        int expResult = 2;
        int result = (int) instance.info;
        assertEquals(expResult, result);
    }

    /**
     * Test of insertTail method, of class LinkedList.
     */
    @Test
    public void testInsertTail() {
        System.out.println("insertTail");
        LinkedList<Comparable> instance = new LinkedList<>();
        instance.insertHead(1);
        instance.insertTail(2);
        int expResult = 2;
        int result = (int) instance.nextList.info;
        assertEquals(expResult, result);
    }

    /**
     * Test of DeleteHead method, of class LinkedList.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteHead() throws Exception {
        System.out.println("DeleteHead");
        LinkedList<Comparable> instance = new LinkedList<>();
        instance.insertHead(1);
        int expResult = 1;
        int result = (int) instance.deleteHead();
        assertEquals(expResult, result);
    }

    /**
     * Test of DeleteTail method, of class LinkedList.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteTail() throws Exception {
        System.out.println("DeleteTail");
        LinkedList<Comparable> instance = new LinkedList<>();
        instance.insertHead(1);
        instance.insertHead(2);
        instance.deleteTail();
        int expResult = 2;
        int result = (int) instance.deleteTail();
        assertEquals(expResult, result);
    }

    /**
     * Test of nextList method, of class LinkedList.
     */
    @Test
    public void testNextList() {
        System.out.println("nextList");
        LinkedList<Comparable> instance = new LinkedList<>();
        instance.insertHead(1);
        instance.insertHead(2);
        int expResult = 1;
        int result = (int) instance.nextList().info;
        assertEquals(expResult, result);
    }

    /**
     * Test of ListSize method, of class LinkedList.
     */
    @Test
    public void testListSize() {
        System.out.println("ListSize");
        LinkedList instance = new LinkedList();
        instance.insertHead(1);
        instance.insertHead(2);
        instance.insertHead(3);
        instance.insertHead(4);        
        int expResult = 4;
        int result = instance.ListSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteinfo method, of class LinkedList.
     */
    @Test
    public void testDeleteinfo() {
        System.out.println("deleteinfo");
        LinkedList<Comparable> instance = new LinkedList<>();
        instance.insertHead(1);
        instance.insertHead(2);
        instance.insertHead(3);
        int expResult = 1;
        instance.deleteinfo(2);
        int result = (int) instance.nextList.info;
        assertEquals(expResult, result);
    }
    
}
