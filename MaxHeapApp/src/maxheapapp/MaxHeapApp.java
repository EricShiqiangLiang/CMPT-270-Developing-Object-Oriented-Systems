/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxheapapp;

/**
 *
 * @author 世强
 */
public class MaxHeapApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MaxHeap myHeap = new MaxHeap();
        myHeap.add(1);
        myHeap.add(2);
        myHeap.add(3);
        myHeap.add(4);
        myHeap.add(5);
        myHeap.add(6);
        myHeap.add(7);
        myHeap.add(8);
        myHeap.add(9);
        myHeap.add(10);
        System.out.println(myHeap.elements.left.left.left.data);
        System.out.println(myHeap.elements.right.left.data);
        System.out.println(myHeap.elements.left.right.left.data);
        System.out.println(myHeap.elements.left.left.right.data);
        System.out.println(myHeap.elements.right.right.data);
        System.out.println(myHeap.elements.right.data);
        System.out.println(myHeap.elements.left.left.data);
        System.out.println(myHeap.elements.left.right.data);
        System.out.println(myHeap.elements.left.data);
        System.out.println(myHeap.elements.data);      
        //Correct output should be:1 2 3 4 5 6 7 8 9 10
        //                10
        //               /  \
        //              9    6
        //             / \  / \
        //           7    8 2   5
        //          / \  /
        //         1  4  3
        //Max Heap achieved.
        System.out.println(myHeap.remove());
        System.out.println(myHeap.remove());
        System.out.println(myHeap.remove());
        System.out.println(myHeap.remove());
        System.out.println(myHeap.remove());
        System.out.println(myHeap.remove());
        System.out.println(myHeap.remove());
        System.out.println(myHeap.remove());
        System.out.println(myHeap.remove());
        System.out.println(myHeap.remove());
        //Correct output should be:10 9 8 7 6 5 4 3 2 1 
        //Remove function worked properly
        MaxHeap stuHeap = new MaxHeap();
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
        stuHeap.add(stu1);
        stuHeap.add(stu2);
        stuHeap.add(stu3);
        stuHeap.add(stu4);
        stuHeap.add(stu5);
        stuHeap.add(stu6);
        Student stu;
        stu = (Student) stuHeap.remove();
        System.out.println(stu.outputStudent());
        stu = (Student) stuHeap.remove();
        System.out.println(stu.outputStudent());
        stu = (Student) stuHeap.remove();
        System.out.println(stu.outputStudent());
        stu = (Student) stuHeap.remove();
        System.out.println(stu.outputStudent());
        stu = (Student) stuHeap.remove();
        System.out.println(stu.outputStudent());
        stu = (Student) stuHeap.remove();
        System.out.println(stu.outputStudent());
        //should get:
        //tyw361 Troy Williams
        //pfr566 Peter Raksinoff
        //kjb455 Kel Boechler
        //jks771 Joan Smith
        //cmc133 Cyril Coupal
        //cfh201 Carl Hampton*/
    }    
}
