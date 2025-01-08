public class LinkedList {
    class node{
        int data;
        node next;
        node(int data){
            this.data = data;
            this.next = null;
        }

    }
    node head;
    node temp;
    public void insert(int data){
        node newNode = new node(data);
        if(head==null){
            head=newNode;
            temp=head;
        }
        else{
            temp.next=newNode;
            temp=newNode;
        }
    }
    public void insertfirst(int data){
        node newNode=new node(data);
        if(head==null){
            head=newNode;
            temp=head;
        }
        else{
            newNode.next=head;
            head=newNode;
        }
    }

    public void deleteFirst(){
        if(head==null)
        {
            System.out.print(" List is empty");
            return;
        }
        head=head.next;
    }
    public void deletelast()
    {
        if(head==null)
        {
            System.out.print(" List is empty");
            return;
        }
        if(head.next==null)
        {
            head=null;
            return;
        }
        node last=head.next;
        node pre=head;
        while(last.next!=null)
        {
            last=last.next;
            pre=pre.next;
        }
        pre.next=null;
    } 
    public void find(int d)
    {
        int i=1;
        temp=head;
        if(temp==null)
        {
            System.out.print(" List is empty");
            return;
        }
        while(temp.next!=null)
        {
            if(temp.data==d )
            {
                System.out.print(" Element found at node "+i);
                return;
            }
            temp=temp.next;
            i++;
        }
        if(temp.data==d)
        {
            System.out.print(" Element found at node "+i);
            return;
        }
        System.out.print(" Element not found");
    }
    public void display(){
        node temp=head;
        if(head==null)
        {
            System.out.println(" List is empty");
            return;
        }
        while(temp.next!=null)
        {
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.print(temp.data+" NULL "+'\n');
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        System.out.print(" Inserted at Last : ");
        list.display();
        list.insertfirst(5);
        list.insertfirst(6);
        System.out.print(" inserted at First : ");
        list.display();
        System.out.print(" Deletion at First : ");
        list.deleteFirst();
        list.display();
        System.out.print(" Deletion at Last : ");
        list.deletelast();
        list.display();
        System.out.print(" Element finding : ");
        list.find(2);
    }
}
