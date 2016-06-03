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
public class Student implements Comparable<Student>{
    String name;
    String NSID;
    
    Student(){
        name = null;
        NSID = null;
    }
    //pre:Student object
    //post:the name is set to inName
    public void setName(String inName){
        name = inName;
    }
    //pre:Student object
    //return:the name of Student
    public String getName(){
        return this.name;
    }
    //pre:Student object
    //post:the NSID is set to inNSID
    public void setNSID(String inNSID){
        NSID = inNSID;
    }
    //pre:Student object
    //return:the NSID of Student   
    public String getNSID(){
        return this.NSID;
    }
    //pre:Student object
    //return:String:"NSID name" of the student
    public String outputStudent(){
        return this.NSID + " " + this.name;
    }
    //overide the compareTo method of Comparable<> interface so the Student object can compare themselves
    //according to NSID
    //pre:Student otherStudent
    //return:-1 if the NSID of current student is less than the NSID of otherStudent
    //       0 if same
    //       1 if larger
    @Override
    public int compareTo(Student otherStudent){
        if(this.NSID.compareTo(otherStudent.NSID) < 0){
            return -1;
        }
        else if(this.NSID.compareTo(otherStudent.NSID) == 0){
            return 0;
        }
        else return 1;   
    }
}
