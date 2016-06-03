/* CMPT 270 Asignment 1
 * Shiqiang Liang
 * NSID:shl083
 * StuID:11208088
 */
package ilisttester;

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
public class IListTest {
    
    public IListTest() {
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
     * Test of isEmpty method, of class IList.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        //test 1:check if an newly constructed IList is empty
        IList instance = new IList();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        //test 2:check if an IList with one node is empty
        instance.insert("a");
        expResult = false;
        result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of insert method, of class IList.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        //test 1: insert one node
        IList instance = new IList();
        instance.insert("a");
        String expResult = "a";
        String result = instance.info;
        assertEquals(expResult, result);
    }

    /**
     * Test of nextList method, of class IList.
     */
    @Test
    public void testNextList() {
        System.out.println("nextList");
        IList instance = new IList();
        instance.insert("a");
        instance.insert("b");
        IList result = instance.nextList();
        IList expResult = instance.nextList;
        assertEquals(expResult, result);
    }

    /**
     * Test of ISize method, of class IList.
     */
    @Test
    public void testISize() {
        System.out.println("ISize");
        IList instance = new IList();
        instance.insert("a");
        instance.insert("a");
        instance.insert("a");
        int expResult = 3;
        int result = instance.ISize();
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteinfo method, of class IList.
     */
    @Test
    public void testDeleteinfo() {
        System.out.println("deleteinfo");
        IList instance = new IList();
        //test 1:delete existing info
        instance.insert("a");
        instance.deleteinfo("a");
        instance.insert("b");
        //test 2:delete info that's not in the list
        instance.deleteinfo("z");
        int Result = instance.ISize();
        int expResult = 1;
        assertEquals(expResult, Result);
    }

    /**
     * Test of traverse method, of class IList.
     */
    @Test
    public void testTraverse() {
        System.out.println("traverse");
        IList instance = new IList();
        instance.insert("a");
        instance.insert("b");
        instance.insert("c");
        instance.insert("d");
        String expResult = "d,c,b,a";
        String result = instance.traverse();
        assertEquals(expResult, result);
    }
    
}
