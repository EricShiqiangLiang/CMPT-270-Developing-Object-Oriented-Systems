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
public class IList {
    String info;
    IList nextList;
    IList() {
        info = null;
        nextList = null;
    }
    //Method isEmpty():
    //pre: None
    //post: IList unchanged
    //return: true if the IList is empty (both fields are null)
    //        false otherwise
    public boolean isEmpty() {
        return(this.info == null && this.nextList == null);
    }
    //Method insert(inInfo):
    //pre: String::inInfo
    //post: inInfo is inserted as the first node of the IList object 
    public void insert(String inInfo) {
        if (this.isEmpty()) {
            this.info = inInfo;
        }
        else {
        IList temp = new IList();
        temp.info = this.info;
        temp.nextList = this.nextList;
        this.info = inInfo;
        this.nextList = temp; 
        }
    }
    //Method nextList()
    //pre: none
    //post: IList object unchanged
    //return: returns the nextList field of IList object
    public IList nextList() {
        return(this.nextList);
    }
    //Method ISize()
    //pre: none
    //post: IList object unchanged
    //return: number of nodes in IList
    public int ISize() {
        if (this.isEmpty()) {
            return(0);
        }
        else if (this.info != null && this.nextList == null) {
            return(1);
        }
        
            return(1 + this.nextList.ISize());
        
    }
    //Method deleteinfo(outInfo)
    //pre: String::outInfo  target to delete
    //post: if there is a target match, delete the first matching node
    //      otherwise the IList is left unchanged
    public void deleteinfo(String outInfo) {
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
    //Method traverse()
    //pre: none
    //post: IList object unchanged
    //return: empty string if the Ilist Object is empty, otherwise a string which is 
    //the current natural order of the linked list as a comma separated set
    //of strings
    public String traverse() {
        String res = "";
        if (this.isEmpty()){
            return(res);
        }
        else {
            res = res + this.info;
           if (this.nextList != null) {
                res = res + "," + this.nextList.traverse();
            }
        }
        return res;
    }
}