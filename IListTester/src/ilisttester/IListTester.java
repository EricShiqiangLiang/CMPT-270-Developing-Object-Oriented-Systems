/* CMPT 270 Asignment 1
 * Shiqiang Liang
 * NSID:shl083
 * StuID:11208088
 */
package ilisttester;

/**
 *
 * @author Shiqiang Liang
 */
public class IListTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IList myList = new IList();
        System.out.println(myList.isEmpty());
        myList.insert("G");
        myList.insert("F");
        myList.insert("E");
        myList.insert("D");
        myList.insert("C");
        myList.insert("B");
        myList.insert("B");
        myList.insert("A");
        myList.deleteinfo("B");
        myList.deleteinfo("Z");
        System.out.println(myList.traverse());//should be A,B,C,D,E,F,G
        System.out.println(myList.ISize());//should be 7
        System.out.println(myList.nextList().ISize());//should be 6
        System.out.println(myList.nextList().nextList().traverse());//should be C,D,E,F,G
        
    }
    
}
