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
public class MaxHeap {
    BTree<Comparable> elements;
    
    MaxHeap(){
        elements = null;
    }
    //Method: add(Comparable newElement)
    //pre:Comparable newElement:element to be added to the heap
    //post:adds the element to the last position to make the heap balanced in strcture
    //     after insertion, restructure the heap to maintain max heap property
    //return:nothing
    public void add(Comparable newElement){
        if (this.elements == null) {
            this.elements = new BTree<>(newElement);
            fixHeap(this.elements);
            return;
        }
        this.elements.LevelInsert(elements, newElement);
        fixHeap(this.elements);
    }
    
    //method:empty()
    //return:true if no element is stored in the heap, false otherwise
    public Boolean empty() {
        return (this.elements == null);
    }
    //methode:peek()
    //return:the root node of the heap(which is the largest element)
    public BTree<Comparable> peek(){
        return this.elements;
    }
    
    //method:remove()
    //pre:a maxheap
    //post:the root node of maxheap is deleted and returned
    //     the heap is restructured if max heap property is broken
    //return:the value of the max element
    public Comparable remove(){
        Comparable dataOut = this.elements.data;
        BTree<Comparable> lastElement = this.findLastElement();
        if (this.elements == lastElement){
            return dataOut;
        }
        BTree<Comparable> parent = findParent(this.elements, lastElement);
        this.elements.data = lastElement.data;
        if(getLeftChild(parent) == lastElement){
            parent.left = null;
        }
        else if(getRightChild(parent) == lastElement){
            parent.right = null;
        }          //  put the last node at the root node then delete the last node
        //restructure the tree to maintain max heap characteristic
        fixHeap(this.elements);
        return dataOut;
    }
    
    //method:findParent(BTree<Comparable> root, BTree<Comparable> Element)
    //pre:BTree<Comparable> root:the tree to find the parent node of  an element in
    //    BTree<Comparable> Element:the element of which to find the parent
    //post:tree unchanged
    //return:the parent node of Element
    public BTree<Comparable> findParent(BTree<Comparable> root, BTree<Comparable> Element){
        if (root == null || root == Element) {
            return root; //if the root is null or the root is the Element itself. simply return root
        }
        if (root.left == Element || root.right == Element){
            return root;//if root is the parent node of Element, return root
        }
        
        BTree<Comparable> p1 = findParent(root.left, Element);
        BTree<Comparable> p2 = findParent(root.right, Element);
        if (p1 != null) return p1;
        else return p2;//otherwise recursively find the parent and return it
    }
    
    //pre:a tree
    //post:tree unchanged
    //return:the newly added element in the tree
    public BTree<Comparable> findLastElement() {
        LinkedList<BTree<Comparable>> treeQueue = new LinkedList<>();
        treeQueue.insertTail(this.elements);
        BTree<Comparable> temp = null;
        try {
            while (!treeQueue.isEmpty()){ 
                //the last element in the queue is the target
                temp = treeQueue.deleteHead();
                if (temp.left != null) { // insert into left subtree if left subtree is empty
                    treeQueue.insertTail(temp.left);
                }
                if (temp.right != null) { // insert into right subtree if left subtree is empty
                    treeQueue.insertTail(temp.right);
                }
            }
        }
        catch (Exception ex) {
            System.out.println("Cannot delete from an empty list!");
        }
        return temp;
    }
    
    //pre:BTree<Comparable> tree1, BTree<Comparable> tree2
    //post:swap the data stored in two trees
    //return:nothing
    public void swap(BTree<Comparable> tree1, BTree<Comparable> tree2) {
        if (tree1 == null || tree2 == null){
            return;
        }
        Comparable temp = tree1.data;
        tree1.data = tree2.data;
        tree2.data = temp;
    }
    
    //pre:a tree
    //post:the tree is restructured to maintain max heap property
    //     if it's already a max heap, it stay unchanged
    //return: nothing
    private void fixHeap(BTree<Comparable> tree){
        if (tree == null){
            return;
        }
        fixHeap(tree.left); //fix subtress first
        fixHeap(tree.right);
        BTree<Comparable> max = tree;//fixing tree
        if(tree.left != null && (tree.left.data.compareTo(max.data)>0)){
            max = tree.left;
        }//because we call fixheap after each insertion, the children node of a node cannot be both larger than the parent node
        if(tree.right != null && (tree.right.data.compareTo(max.data)>0)){
            max = tree.right;
        }
        if(tree != max){
            swap(tree, max);
        }
        fixHeap(tree.left); //after fixing current tree, make sure the subtree's maxheap property is not broken;
        fixHeap(tree.right);
    }
    
    //pre:BTree<Comparable> rootOfTree
    //post:rootOfTree unchanged
    //return:the left subtree of rootOfTree
    private BTree<Comparable> getLeftChild(BTree<Comparable> rootOfTree){
        return rootOfTree.left;
    }

    //pre:BTree<Comparable> rootOfTree
    //post:rootOfTree unchanged
    //return:the right subtree of rootOfTree
    private BTree<Comparable> getRightChild(BTree<Comparable> rootOfTree){
        return rootOfTree.right;
    }
    
}
