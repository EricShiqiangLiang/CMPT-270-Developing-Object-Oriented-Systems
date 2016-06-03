/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxheapapp;

/**
 *
 * @author 世强
 * @param <Comparable>
 */
public class LinkedList<Comparable> {
    Comparable info;
    LinkedList<Comparable> nextList;
    
    LinkedList() {
        info = null;
        nextList = null;
    }
    //Method isEmpty():
    //pre: None
    //post: List unchanged
    //return: true if the List is empty (both fields are null)
    //        false otherwise
    public boolean isEmpty() {
        return(this.info == null && this.nextList == null);
    }
    //Method insertHead(inInfo):
    //pre: String::inInfo
    //post: inInfo is inserted as the first node of the IList object 
    public void insertHead(Comparable inInfo) {
        if (this.isEmpty()) {
            this.info = inInfo;
        }
        else {
        LinkedList<Comparable> temp = new LinkedList<>();
        temp.info = this.info;
        temp.nextList = this.nextList;
        this.info = inInfo;
        this.nextList = temp; 
        }
    }
    //Method insertTail(inInfo):
    //pre: String::inInfo
    //post: inInfo is inserted as the first node of the IList object 
    public void insertTail(Comparable inInfo) {
        if (this.isEmpty()) {
            this.info = inInfo;
        }
        else {
        LinkedList<Comparable> tail = new LinkedList<>();
        tail.info = inInfo;
        tail.nextList = null;
        LinkedList<Comparable> temp = this;
        while(temp.nextList != null){
            temp = temp.nextList;
        }
        temp.nextList = tail;
        }
    }
    //Method DeleteHead():
    //pre: none
    //post: If the first node exists, it's deleted
    //return: the content of first node
    public Comparable deleteHead() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("The Linked List is empty!");
        }
        else {
            Comparable dataOut = this.info;
            if (this.nextList == null){
                this.info = null;
                return dataOut;
            }
            LinkedList<Comparable> temp = this.nextList;
            this.info = temp.info;
            this.nextList = temp.nextList; 
            return dataOut;
        }
    }
    
    //Method DeleteTail():
    //pre: none
    //post: delete the last node if it exists
    //return: the content of last node
    public Comparable deleteTail() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("The Linked List is empty!");
        }
        else if (this.nextList == null){
            return deleteHead();
        }
        else {
        LinkedList<Comparable> temp = this;
        while(temp.nextList.nextList != null){
            temp = temp.nextList;
        }
        Comparable dataOut = temp.nextList.info;
        temp.nextList = null;
        return dataOut;
        }
    }
    //Method nextList()
    //pre: none
    //post: List object unchanged
    //return: returns the nextList field of LinkedList object
    public LinkedList<Comparable> nextList() {
        return(this.nextList);
    }
    //Method ISize()
    //pre: none
    //post: IList object unchanged
    //return: number of nodes in IList
    public int ListSize() {
        if (this.isEmpty()) {
            return(0);
        }
        else if (this.info != null && this.nextList == null) {
            return(1);
        }
        
            return(1 + this.nextList.ListSize());
        
    }
    //Method deleteinfo(outInfo)
    //pre: String::outInfo  target to delete
    //post: if there is a target match, delete the first matching node
    //      otherwise the LinkedList is left unchanged
    public void deleteinfo(Comparable outInfo) {
        if (!this.isEmpty()) {
            if (this.nextList != null){
                if (this.info.equals(outInfo)){
                    this.info = this.nextList.info;
                    this.nextList = this.nextList.nextList;
                }
                else{
                    this.nextList.deleteinfo(outInfo);
                }
            }
            else {
                if (this.info.equals(outInfo)){
                    this.info = null;
                }
            }
        }
    }
    
}