/*
            Stack operations
            1. Push
            2. Pop
            3. Peek
            4. Display
            5. Size
            6. isEmpty
            7. isFull
            8. Search
            9. Clear
 */
class Node{
    Node link=null;
    int data;
    Node(int data){
        this.data=data;
    }
}
class StackUsingLL{
    Node head=null;
    protected int top=-1;
    protected int limit;
    StackUsingLL(int limit){
        this.limit=limit;
    }
    public String push(int data){
        try {
            if(top>=limit-1)return "Stack Overflow";
            else if(top==-1)
            {
                Node newNode=new Node(data);
                head=newNode;
            }
            else{
                Node newNode=new Node(data);
                newNode.link=head;
                head=newNode;
            }
            top+=1;
            return "Data Pushed Successfuly";
        } catch (Exception e) {
            return "Error in push method";
        }
    } 
    public String pop(){
        try {
            if(head==null)return "Stack Underflow";
            Node temp=head.link;
            head=null;
            head=temp;
            top-=1;
            return "Pop operation successful";
        } catch (Exception e) {
            return "Error in pop methood";
        }
    } 
    public String peek(){
        if(head==null)return "Stack is empty";
        return head.data+" is at the peek";
    }
    public String display(){
        try {
            if(head==null)return "Stack is Empty";
            else{
                String dataString="Stack data";
                Node currNode=head;
                System.out.println("\n");
                while(currNode!=null){
                    System.out.println("| "+currNode.data+" |");
                    System.out.println(" ---- ");
                    // dataString+=currNode.data+" ";
                    currNode=currNode.link;
                }
                return dataString;
            }
        } catch (Exception e) {
            return "Error in the diplay method";
        }
    }
    public int size(){
        return top+1;
    }
    public boolean isEmpty(){
        return head==null;
    }
    public boolean isFull(){
        return top==limit-1;
    }
    public boolean search(int data){
        Node currNode=head;
        while(currNode!=null){
            if(currNode.data==data)return true;
            currNode=currNode.link;
        }
        return false;
    }
    public String clear(){
        head=null;
        top=-1;
        return "Stack is cleared";
    }
}
public class Stack{
    public static void main(String[] args) {
        StackUsingLL stackObj=new StackUsingLL(5);
        System.out.println(stackObj.push(10));
        System.out.println(stackObj.push(20));
        System.out.println(stackObj.push(30));
        System.out.println(stackObj.push(40));
        System.out.println(stackObj.push(50));
        System.out.println(stackObj.push(60));

        // System.out.println(stackObj.display());
        // System.out.println(stackObj.pop());
        // System.out.println(stackObj.display());
        // System.out.println(stackObj.pop());
        // System.out.println(stackObj.display());

        // System.out.println(stackObj.peek());
        System.out.println(stackObj.size());
        System.out.println(stackObj.isEmpty());
        System.out.println(stackObj.isFull());
        System.out.println(stackObj.search(40));
        System.out.println(stackObj.clear());
        System.out.println(stackObj.display());
    }
}