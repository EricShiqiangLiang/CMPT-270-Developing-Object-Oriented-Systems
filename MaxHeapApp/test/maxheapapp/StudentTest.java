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
public class StudentTest {
    
    public StudentTest() {
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
     * Test of setName method, of class Student.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        Student instance = new Student();
        instance.setName("jack");
        String expResult = "jack";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Student.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Student instance = new Student();
        instance.setName("jack");
        String expResult = "jack";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNSID method, of class Student.
     */
    @Test
    public void testSetNSID() {
        System.out.println("setNSID");
        Student instance = new Student();
        instance.setNSID("shl083");
        String expResult = "shl083";
        String result = instance.getNSID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNSID method, of class Student.
     */
    @Test
    public void testGetNSID() {
        System.out.println("getNSID");
        Student instance = new Student();
        instance.setNSID("shl083");
        String expResult = "shl083";
        String result = instance.getNSID();
        assertEquals(expResult, result);
    }

    /**
     * Test of outputStudent method, of class Student.
     */
    @Test
    public void testOutputStudent() {
        System.out.println("outputStudent");
        Student instance = new Student();
        instance.setName("Shiqiang Liang");
        instance.setNSID("shl083");
        String expResult = "shl083 Shiqiang Liang";
        String result = instance.outputStudent();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Student.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Student stu1 = new Student();
        Student stu2 = new Student();
        Student stu3 = new Student();
        Student stu4 = new Student();
        Student stu5 = new Student();
        Student stu6 = new Student();
        stu1.setNSID("cmc133");
        stu1.setName("Cyril Coupal");
        stu2.setNSID("kjb455");
        stu2.setName("Kel Boechler");
        stu3.setNSID("pfr566");
        stu3.setName("Peter Raksinoff");
        stu4.setNSID("jks771");
        stu4.setName("Joan Smith");
        stu5.setNSID("cfh201");
        stu5.setName("Carl Hampton");
        stu6.setNSID("tyw361");
        stu6.setName("Troy Williams");
        int expResult = 1;
        int result = stu6.compareTo(stu3);
        assertEquals(expResult, result);
        expResult = 1;
        result = stu3.compareTo(stu2);
        assertEquals(expResult, result);
        expResult = 1;
        result = stu2.compareTo(stu4);
        assertEquals(expResult, result);
        expResult = 1;
        result = stu4.compareTo(stu1);
        assertEquals(expResult, result);
        expResult = 1;
        result = stu1.compareTo(stu5);
        assertEquals(expResult, result);//all comparisons should yied 1
        
    }    
}
