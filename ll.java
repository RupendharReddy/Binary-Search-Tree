// single linked list
// view,Reverse ,view based on id,view Size
// insert first ,insert last, insert position
// Update based on id
// Delete first,Delete Last, Delete by id
// find

// import dl.node;

class Node{
    int data;
    Node link=null;
    Node(int data)
    {
        this.data=data;
    }
}
class List {
    private Node startNode;
    private Node endNode;
    private int size=0;
    // .......... Insert......


    public boolean insertFirst(int data)
    {
        try {
            Node newNode=new Node(data);
            if(startNode==null){
                // if StartNode is null, newnode itself Head
                startNode=newNode;
                endNode=newNode;
            }
            else{
                // if startnode is not null, startNode is link of newNode
                newNode.link=startNode;
                startNode=newNode;
            }
            size++;
            return true;
            
        } catch (Exception e) {
            return false;
        }
    }
    public boolean insertLast(int data)
    {
        try {
            Node newNode=new Node(data);
            if(startNode==null)
            {
                startNode=newNode;
                endNode=newNode;
            }
            else{
                endNode.link=newNode;
                endNode=newNode;
            }
            size++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean insertAt(int data,int index)
    {
        try {
            if(index-1>size || index<0 || size==0){
                return false;
            }
            else if(index==0){
                return insertFirst(data);
            }
            else if(index==size-1){
                return insertLast(data);
            }
            Node newNode=new Node(data);
            // 1,2,3  index 1,data 5
            Node currNode = startNode; // 1
            // int currIndex=0;//0
            // while(currIndex!=index-1){//0!=0 
            //     currNode=currNode.link;//2
            //     currIndex++;//1
            // }
            // newNode.link=currNode.link;
            // currNode.link=newNode;
            for(int i=1;i<index;i++)
            {
                currNode=currNode.link;
            }
            newNode.link=currNode.link;
            currNode.link=newNode;
            
            size++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    // ..............View .........
    public String view(boolean rev){
        try {
            Node currNode=startNode;
            Node prevNode=null;
            Node nextNode=null;
            while(currNode!=null)
            {
                nextNode=currNode.link;
                currNode.link=prevNode;
                prevNode=currNode;
                currNode=nextNode;
            }       
            endNode=startNode;
            startNode=prevNode;     
            return view();
        } catch (Exception e) {
            return "Error on view rev obj";
        }
    }
    // public String view(boolean rev)
    // {
    //     if(rev){
    //         Node prev=null;
    //         Node curr=startNode;
    //         Node next=null;
    //         while(curr!=null){
    //             next=curr.link;
    //             curr.link=prev;
    //             prev=curr;
    //             curr=next;
    //         }
    //         endNode=startNode;
    //         startNode=prev;
    //     }
    //     return view();
    // }

    public String views(boolean rev){
        try {
            if(rev){
                Node curr=startNode;
                Node next=null;
                Node prev=null;
                while(curr!=null)
                {
                    next=curr.link;
                    curr.link=prev;
                    prev=curr;
                    curr=next;
                }
                endNode=startNode;
                startNode=prev;
            }
            return view();
        } catch (Exception e) {
            return "Error in views";
        }
    }
    public String view()
    {
        try {
            if(size==0)return "List is Empty";
            else if(size==1)return startNode.data+"";
            else{
                String nodeList="";
                Node curr=startNode;
                while (curr!=null) {
                    nodeList+=curr.data+"-> ";
                    curr=curr.link;
                }
                nodeList+="Null";
                return nodeList;
            }
        } catch (Exception e) {
            return "Error on view obj";
        }
    }
    public String view(int index){
        try {
            if(index<0 || index>=size){
                return "Index out of range";
            }
            Node currNode = startNode; 
            for(int i=0;i<index;i++)
            {
                currNode=currNode.link;
            }
            return currNode.data+"";
            
        } catch (Exception e) {
            return "Error on view obj";
        }
    }
    public int size(){
        return this.size;
    }


    // .......... Update ........
    public boolean update(int data,int index)
    {
        try {
            if(index<0 || index>=size){
                return false;
            }
            Node currNode = startNode; 
            for(int i=0;i<index;i++)
            {
                currNode=currNode.link;
            }
            currNode.data=data;
            return true;
            
        } catch (Exception e) {
            return false;
        }
    }
    
// ..................Delete ..........
    public boolean deleteFirst()
    {
        try {
            Node currNode=startNode;
            startNode=startNode.link;
            currNode.link=null;
            size--;
            return true;
        } catch (Exception e) {
            return false;
        }
    }public boolean deleteLast()
    {
        try {
            Node currNode=startNode;
            while (currNode.link.link!=null) {
                currNode=currNode.link;
            }            
            endNode=currNode;
            currNode.link=null;
            size--;
            return true;
        } catch (Exception e) {
            return false;
        }
    }public boolean deleteIndex(int index)
    {
        try {
            if(index<0 || index>=size){
                return false;
            }
            else if(index==0){
                System.out.println("delete first block");
                return deleteFirst();
            }
            else if(index+1==size){
                System.out.println("delete last block");
                return deleteLast();
            }
            else{
                System.out.println("else block in delete at index");
                Node currNode = startNode.link; 
                Node prevNode = startNode; 
                for(int i=1;i<index;i++)
                {
                    currNode=currNode.link;
                    prevNode=prevNode.link;
                }
                prevNode.link=currNode.link;
                currNode.link=null;
                size--;
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    // ........... Find .........
    public boolean find(int target)
    {
        try {
            Node currNode = startNode; 
            for(int i=0;i<size;i++)
            {
                if(currNode.data==target){
                    return true;
                }
                currNode=currNode.link;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
public class ll {
    public static void main(String[] args) {
        List listObj = new List();
        listObj.insertFirst(30);
        listObj.insertLast(40);
        listObj.insertFirst(20);
        listObj.insertLast(50);
        listObj.insertFirst(10);
        // listObj.insertAt(15,3);
        // System.out.println(listObj.insertAt(35,0));
        System.out.println(listObj.view());
        System.out.println(listObj.view(0));
        System.out.println(listObj.size());

        // System.out.println("Deletion first : "+listObj.deleteFirst());
        // System.out.println(listObj.view());
        // System.out.println(listObj.size());

        // System.out.println("Deletion Last : "+listObj.deleteLast());
        // System.out.println(listObj.view());
        // System.out.println(listObj.size());

        // System.out.println("Deletion Index : "+listObj.deleteIndex(0));
        // System.out.println(listObj.view());
        // System.out.println(listObj.size());

        System.out.println(listObj.find(30));
        System.out.println(listObj.update(99,5));
        System.out.println(listObj.view());
        System.out.println(listObj.size());
        System.out.println(listObj.views(true));
        System.out.println(listObj.view(true));
        System.out.println(listObj.view(true));
    }

}
