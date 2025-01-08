// Double linked list
// view,Reverse ,view based on id,view Size
// insert first ,insert last, insert position
// Update based on id
// Delete first,Delete Last, Delete by id
// find

class Node{
    int data;
    Node link=null;
    Node prev=null;
    Node(int data)
    {
        this.data=data;
    }
}
class DLL{
    protected Node startNode=null;
    protected Node endNode=null;
    protected int size=-1;
    public boolean createFirstNode(Node newNode){
        try {
            startNode=newNode;
            endNode=newNode;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean insertFirst(int data){
        try {
            Node newNode=new Node(data);
            if(startNode==null){
                return createFirstNode(newNode);
            }
            else{
            newNode.link=startNode;
            startNode.prev=newNode;
            startNode=newNode;
        }
        size++;
        return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean insertLast(int data){
        try {
            Node newNode = new Node(data);
            if(endNode==null){
                return createFirstNode(newNode);
            }
            else{
                newNode.prev=endNode;
                endNode.link=newNode;
                endNode=newNode;
            }
            size++;
            return true;
        } catch (Exception e) {
            return false;
        }        
    }
    public boolean insertAt(int index,int data){
        try {
            if(index>size || index<0)return false;
            else if(index==0)return insertFirst(data);
            else if(index==size)return insertLast(data);
            else{
                Node newNode=new Node(data);
                Node curr=startNode;
                for(int i=0;i<index;i++){
                    curr=curr.link;
                }
                newNode.link=curr;
                newNode.prev=curr.prev;
                curr.prev.link=newNode;
                curr.prev=newNode;
            }
            size++;
            // System.out.println(size);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean deleteFirst(){
        try {
            Node curr=startNode;
            startNode=curr.link;
            startNode.prev=null;
            curr=null;
            size--;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean deleteLast(){
        try {
            Node curr=endNode;
            endNode=curr.prev;
            endNode.link=null;
            curr=null;
            size--;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean deleteIndex(int index){
        try {
            Node curr=startNode;
            if(index>size || index<0)return false;
            else if(index==0)return deleteFirst();
            else if(index==size)return deleteLast();
            else{
                // Node currNode=startNode;
                for(int i=0;i<index;i++)
                {
                    curr=curr.link;
                }
                curr.link.prev=curr.prev;
                curr.prev.link=curr.link;
                size--;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean update(int index,int data){
        try {
            if(index>size || index<0)return false;
            else if(index==0){
                startNode.data=data;
                return true;
            }
            else if(index==size){
                endNode.data=data;
                return true;
            }
            else{
                Node curr=startNode;
                for(int i=0;i<index;i++)
                {
                    curr=curr.link;
                }
                curr.data=data;
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    public boolean search(int data){
        try {
            Node currNode=startNode;
            for(int i=0;i<=size;i++)
            {
                if(currNode.data==data)
                {
                    return true ;            
                }
                currNode=currNode.link;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    public String findIndexData(int target){
        try {
            Node currNode=startNode;
            if(target>size || target<0)return "Index out of range";
            else if(target==0)return startNode.data+" found at "+target;
            else if(target==size)return endNode.data+" found at "+target;
            else{
                for(int i=0;i<target;i++)
                {
                    currNode=currNode.link;
                }
                return currNode.data+" found at "+target;
            }
        } catch (Exception e) {
            return "Error in the findIndex";
        }
    }
    public int size(){
        return size+1;
    }
    public String view(boolean farword){
        try {
            if(startNode==null)
            {
                return "List is Empty";
            }
            String dataString="Null";
            if(farword){
                Node curr=startNode;
                while(curr.link!=null){
                    dataString+=" <-> "+curr.data;
                    curr=curr.link;
                }
                dataString+=" <-> "+curr.data;
            }
            else{
                Node curr=endNode;
                while(curr.prev!=null){
                    dataString+=" <-> "+curr.data;
                    curr=curr.prev;
                }
                dataString+=" <-> "+curr.data;
            }
            return dataString+" <-> Null";
        } catch (Exception e) {
            return "Error in view";
        }
    }

}
class Doublelinkedlist
{
    public static void main(String[] args) {
        System.out.println("hello");
        DLL listObj=new DLL();
        listObj.insertFirst(30);
        listObj.insertLast(40);
        listObj.insertFirst(20);
        listObj.insertLast(50);
        listObj.insertLast(60);
        listObj.insertFirst(10);
        listObj.insertAt(0, 0);
        System.out.println(listObj.view(true));
        System.out.println(listObj.view(false));
        listObj.deleteFirst();
        System.out.println(listObj.view(true));
        listObj.deleteLast();
        System.out.println(listObj.view(true));
        listObj.deleteIndex(0);
        System.out.println(listObj.view(true));
        listObj.update(2,35);
        System.out.println(listObj.view(true));
        System.out.println(listObj.search(30));
        System.out.println(listObj.search(60));
        System.out.println(listObj.findIndexData(4));
        System.out.println(listObj.findIndexData(3));
        System.out.println(listObj.findIndexData(2));
        System.out.println(listObj.findIndexData(1));
        System.out.println(listObj.findIndexData(0));
        System.out.println(listObj.findIndexData(-1));
        System.out.println(listObj.size());
        
    }
}