// circular linked list
// view,Reverse ,view based on id,view Size
// insert first ,insert last, insert position
// Update based on id
// Delete first,Delete Last, Delete by id
// find


class Node{
    int data;
    Node link=null;
    Node(int data){
        this.data=data;
    }
}
class InnerCircularLinkedList {
    protected Node startNode=null;
    protected Node endNode=null;
    protected int size=-1;
    protected boolean indexValidation(int index){
        if(index<0 || index>size)return false;
        return true;
    }
    protected boolean createFirstNode(int data){
        if(startNode==null){
            Node newNode=new Node(data);
            startNode=newNode;
            startNode.link=startNode;
            endNode=startNode;
            size++;
            return true;
        }
        return false;
    }
    public boolean insertFirst(int data){
        try {
            if(createFirstNode(data)==false){
                Node newNode=new Node(data);
                Node temp=startNode;
                startNode=newNode;
                startNode.link=temp;
                endNode.link=startNode;
                size++;
            }            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean insertLast(int data){
        try {
            if(createFirstNode(data)==false){
                Node newNode=new Node(data);
                Node temp=endNode;
                endNode=newNode;
                endNode.link=startNode;
                temp.link=endNode;
                size++;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
    public boolean insertAt(int index,int data){
        try {
            if(index<0 || index>size)return false;
            else if(index==0)return insertFirst(data);
            else if(index==size)return insertLast(data);
            else{
                Node newNode =new Node(data);
                Node temp1=startNode.link;
                Node temp2=startNode;
                for(int i=1;i<index;i++)
                {
                    temp2=temp1;
                    temp1=temp1.link;
                }
                temp2.link=newNode;
                newNode.link=temp1;
                size++;
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    public String view(){
        try {
            Node curr=startNode;
            String data="";
            if(curr==null)return "List is Empty";
            while(curr.link!=startNode){
                data+=curr.data+" -> ";
                curr=curr.link;
            }
            data+=curr.data;
            // data+=endNode.link.data;
            // System.out.println(startNode" "+endNode.data);
            return data;
        } catch (Exception e) {
            return "Error in view";
        }
    }
    public String view(boolean rev){
        try {
            if(startNode==null)return "List is Empty";
            Node curNode=startNode;
            Node next=null;
            Node prev=endNode;
            Node temp=startNode;
            while (curNode.link!=startNode) {
                next=curNode.link;
                curNode.link=prev;
                prev=curNode;
                curNode=next;
            }
            curNode.link=prev;
            startNode=curNode;
            endNode=temp;
            // endNode=prev;
            return view();
        } catch (Exception e) {
            return "Error in view rev";
        }
    }
    public String viewIndexData(int index){
        try {
            if(index<0 || index>size)return "Out of Range";
            else if(index==0)return startNode.data+"";
            else if(index==size)return endNode.data+"";
            else{
                Node curr=startNode;
                for(int i=0;i<index;i++){
                    curr=curr.link;
                }
                return curr.data+" found at "+index;
            }
        } catch (Exception e) {
            return "Error in viewIndexData";       
        }
    }
    public int size(){
        return size+1;
    }
    public boolean update(int index,int data){
        try {
            if(index<0 || index>size)return false;
            else if(index==0){
                startNode.data=data;
                return true;
            }
            else if(index==size){
                endNode.data=data;
                return true;
            }
            else{
                Node tempNode=startNode;
                for(int i=0;i<index;i++)
                {
                    tempNode=tempNode.link;
                }
                tempNode.data=data;
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    public boolean deleteFirst(){
        try {
            if(startNode!=null){
                if(startNode==endNode){
                    startNode=null;
                    // endNode=null;  //Not required because address is null as startnode is null
                }
                Node temp=startNode;
                startNode=temp.link;
                endNode.link=startNode;
                temp=null;
                size--;
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }    
    public boolean deleteLast(){
        try {
            if(startNode!=null){
                if(startNode==endNode){
                    startNode=null;
                    // endNode=null;  //Not required because address is null as startnode is null
                    return true;
                }
                Node temp=startNode;
                while (temp.link.link!=startNode) {
                    temp=temp.link;
                }
                temp.link=startNode;
                endNode=null;
                endNode=temp;
                size--;
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean deleteIndex(int index){
        try {
            if(index<0 || index>size)return false;
            else if(index==0)return deleteFirst();
            else if(index==size-1) return deleteLast();
            else{
                Node currNode=startNode;
                for(int i=0;i<index-1;i++){
                    currNode=currNode.link;
                }
                Node temp=currNode.link;
                currNode.link=temp.link;
                temp=null;
                size--;
                return true;
            }            
        } catch (Exception e) {
            return false;
        }
    }
    public String search(int target){
        try {
            Node curr=startNode;
            do{
                if(curr.data==target){
                    return curr.data+" found ";
                }
                curr=curr.link;
            }while(curr!=startNode);
            return "Not found";
        } catch (Exception e) {
            return "Error in search";            
        }
    }
    public String findIndexData(int index){
        try {
            if(index<0 || index>size)return "Index out of range";
            else if(index==0)return startNode.data+" found at "+index;
            else if(index==size)return endNode.data+" found at "+index;
            else{
                Node curr=startNode;
                for(int i=0;i<index;i++){
                    curr=curr.link;
                }
                return curr.data+" found at index "+index;
            }
        } catch (Exception e) {
            return "Error in findIndexData";
        }
    }

}
class CircularLinkedList {
    public static void main(String[] args) {
        InnerCircularLinkedList listObj = new InnerCircularLinkedList();
        listObj.insertLast(10);
        listObj.insertFirst(00);
        listObj.insertLast(20);
        listObj.insertLast(30);
        // System.out.println(listObj.view());
        // listObj.insertAt(3,15);
        // System.out.println("reversing");
        // System.out.println(listObj.view(true));
        // System.out.println(listObj.size()+"----"+listObj.viewIndexData(7));
        // System.out.println(listObj.view(true));
        // listObj.update(2, 99);

        // System.out.println(listObj.view()+"   size : "+listObj.size());
        // listObj.deleteLast();
        // System.out.println(listObj.view()+"   size : "+listObj.size());
        // listObj.deleteLast();
        // System.out.println(listObj.view()+"   size : "+listObj.size());
        // listObj.deleteLast();
        // System.out.println(listObj.view()+"   size : "+listObj.size());
        // listObj.deleteLast();
        // System.out.println(listObj.view()+"   size : "+listObj.size());
        // listObj.deleteLast();
        // System.out.println(listObj.view()+"   size : "+listObj.size());

        // System.out.println(listObj.view()+"   size : "+listObj.size());
        // listObj.deleteFirst();
        // System.out.println(listObj.view()+"   size : "+listObj.size());
        // listObj.deleteFirst();
        // System.out.println(listObj.view()+"   size : "+listObj.size());
        // listObj.deleteFirst();
        // System.out.println(listObj.view()+"   size : "+listObj.size());
        // listObj.deleteFirst();
        // System.out.println(listObj.view()+"   size : "+listObj.size());
        // listObj.deleteFirst();
        // System.out.println(listObj.view()+"   size : "+listObj.size());
        
        // System.out.println(listObj.view()+"   size : "+listObj.size());
        // listObj.deleteIndex(4);
        // System.out.println(listObj.view()+"   size : "+listObj.size());
        
        // System.out.println(listObj.view()+"   size : "+listObj.size());
        // System.out.println(listObj.search(30));

        System.out.println(listObj.view()+"   size : "+listObj.size());
        // System.out.println(listObj.findIndexData(2));
    }
}
