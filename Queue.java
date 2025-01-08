/*
 *            Queue using Linked List
 *            1. Enqueue
 *            2. Dequeue
 *            3. Size
 *            4. property queue
 *            5. view
 *            6. doubleended queue
 *            7. Circular queue
 *            8. 
 * 
 */
class Node{
    Node link=null;
    int data;
    Node(int data){
        this.data=data;
    }
}
class QuqueUsingLL{
    Node head;
    Node tail;
    protected int size=0;
    public boolean enqueue(int data){
        try {
            Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
            size++;
            return true;
        }
        else{
            tail.link=newNode;
            tail=newNode;
            size++;
            return true;
        }
        } catch (Exception e) {
            return false;
        }
    }
    public boolean Dequeue(){
        try{
            if(head==null)return false;
            head=head.link;
            size--;
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public int size(){
        return size;
    }
}
public class Queue {
    public static void main(String[] args) {
        
    }
    
}
