class Node {
    int data;
    Node right=null;
    Node left=null;
    Node(int data) {
        this.data = data;
    }
}
class InnerDoubleCircularLinkedList {
    Node startNode=null;
    protected int size=0;
    public boolean createFirstNode(Node newNode) {
        newNode.right=newNode;
        newNode.left=newNode;
        startNode=newNode;
        size++;
        return true;
    }
    public boolean insertFirst(int data) {
        try {
            Node newNode=new Node(data);
            if(startNode==null)return createFirstNode(newNode);
            else {
                newNode.right=startNode;
                newNode.left=startNode.left;
                startNode.left.right=newNode;
                startNode.left=newNode;
                startNode=newNode;
                size++;
                return true;
            }            
        } catch (Exception e) {
            return false;
        }
    }
    public boolean insertLast(int data) {
        try {
            Node newNode =new Node(data);
            if(startNode==null)return createFirstNode(newNode);
            else{
                newNode.right=startNode;
                newNode.left=startNode.left;
                startNode.left.right=newNode;
                startNode.left=newNode;
                size++;
                return true;
            }            
        } catch (Exception e) {
            return false;
        }
    }
    public boolean insertAt(int index,int data) {
        try {
            Node newNode=new Node(data);
            if(index>size-1 || index<0)return false;
            else if(startNode==null)return createFirstNode(newNode);
            else if(index==0)return insertFirst(data);
            else if(index==size-1)return insertLast(data);
            else{
                Node currNode=startNode;
                for(int i=0;i<index-1;i++){
                    currNode=currNode.right;
                }
                newNode.right=currNode.right;
                newNode.left=currNode;
                currNode.right.left=newNode;
                currNode.right=newNode;
                size++;
                return true;
            }            
        } catch (Exception e) {
            return false;
        }
    }
    protected boolean deletionOfNode(Node currNode){
        try {
            if(startNode==null)return false;
            else if(startNode.right==startNode){
                startNode=null;
                size--;
                return true;
            }
            else{
                currNode.left.right=currNode.right;
                currNode.right.left=currNode.left;
                size--;
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    public boolean deleteFirst() {
        try {
            if(deletionOfNode(startNode))
            {
                Node temp=startNode.right;
                startNode=null;
                startNode=temp;
                return true;          
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean deleteLast() {
        try {
            return deletionOfNode(startNode.left);
        } catch (Exception e) {
            return false;
        }
    }
    public boolean deleteIndex(int index) {
        try {
            if(index>size-1 || index<0)return false;
            else if(index==0)return deleteFirst();
            else if(index==size-1)return deleteLast();
            else{
                Node currNode=startNode;
                for(int i=0;i<index-1;i++){
                    currNode=currNode.right;
                }
                deletionOfNode(currNode.right);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    public boolean update(int index,int data) {
        try {
            if(index>size-1 || index<0)return false;
            else if(index==0){
                startNode.data=data;    
                return true;
            }
            else if(index==size-1){
                startNode.left.data=data;
                return true;
            }
            else{
                Node currNode=startNode;
                for(int i=0;i<index-1;i++){
                    currNode=currNode.right;
                }
                currNode.right.data=data;
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    public boolean search(int data) {
        try {
            Node currNode=startNode;
            for(int i=0;i<size;i++){
                if(currNode.data==data)return true;
                currNode=currNode.right;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    public String findIndexData(int index) {
        try {
            if(index>size-1 || index<0)return "Index out of range";
            else if(index==0)return startNode.data+"";
            else if(index==size-1)return startNode.left.data+"";
            else{
                Node currNode=startNode;
                for(int i=0;i<index-1;i++){
                    currNode=currNode.right;
                }
                return currNode.right.data+"";
            }
        } catch (Exception e) {
            return "Error in findIndexData";
        }
    }
    public int size() {
        return size;
    }
    public String view() {
        try {
            if(startNode==null)return "List is empty";
            else{
                String s="";
                Node curr=startNode;
                while(curr.right!=startNode){
                    s+=curr.data+"<->";
                    curr=curr.right;
                }
                return s+curr.data;
            }
        } catch (Exception e) {
            return "Error in view";
        }
    }
    public String view(boolean rev) {
        try {
            if(startNode==null)return "List is empty";
            else{
                String s="";
                Node curr=startNode.left;
                while (curr.left != startNode.left) {
                    s += curr.data + "<->";
                    curr = curr.left;
                }
                return s+curr.data;
            }
        } catch (Exception e) {
            return "Error in view";
        }
    }
    
}
public class DoubleCircularLinkedList {
    public static void main(String[] args) {
        System.out.println("hello");
        InnerDoubleCircularLinkedList listObj = new InnerDoubleCircularLinkedList();
        listObj.insertFirst(20);
        listObj.insertLast(40);
        listObj.insertFirst(10);
        listObj.insertLast(50);
        System.out.println(listObj.insertAt(3, 00));
        System.out.println(listObj.view());
        // listObj.deleteFirst();
        // System.out.println(listObj.view());
        // listObj.deleteFirst();
        // System.out.println(listObj.view());
        // listObj.deleteFirst();
        // System.out.println(listObj.view());
        // listObj.deleteFirst();
        // System.out.println(listObj.view());
        // listObj.deleteFirst();
        // System.out.println(listObj.view());
        // listObj.deleteFirst();
        // System.out.println(listObj.view());

        // System.out.println(listObj.view(true));
        
        // listObj.deleteLast();
        // System.out.println(listObj.view()+" deleton....");
        // listObj.deleteLast();
        // System.out.println(listObj.view());
        // listObj.deleteLast();
        // System.out.println(listObj.view());
        // listObj.deleteLast();
        // System.out.println(listObj.view());
        // listObj.deleteLast();
        // System.out.println(listObj.view());
        // listObj.deleteLast();
        // System.out.println(listObj.view());

        // listObj.deleteIndex(4);
        // System.out.println(listObj.view());

        // listObj.update(4, 99);
        // System.out.println(listObj.view());

        // System.out.println(listObj.search(10));
        // System.out.println(listObj.search(20));
        // System.out.println(listObj.search(30));
        // System.out.println(listObj.search(40));
        // System.out.println(listObj.search(50));

        // System.out.println(listObj.findIndexData(-1));
        // System.out.println(listObj.findIndexData(0));
        // System.out.println(listObj.findIndexData(1));
        // System.out.println(listObj.findIndexData(2));
        // System.out.println(listObj.findIndexData(3));
        // System.out.println(listObj.findIndexData(4));
        // System.out.println(listObj.findIndexData(5));

    }    
}
