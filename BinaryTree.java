import java.util.Scanner;

class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
    }
}
class BinaryTreeImplementation{
    // Node root=null;
    Scanner sc=new Scanner(System.in);
    int index = 0;

    public Node insert(int[] data) {
        if (index >= data.length || data[index] == 0) {
            index++;
            return null;
        }

        Node root = new Node(data[index++]);
        root.left = insert(data);
        root.right = insert(data);

        return root;
    }
    public Node insert()
    {
        System.out.println("Enter Data : ");
        int key=sc.nextInt();
        if(key==0)return null;
        Node root=new Node(key);
        System.out.println("Enter left of "+root.data);
        root.left=insert();
        System.out.println("Enter Right of "+root.data);
        root.right=insert();
        return root;
    }
    public boolean find(Node root,int key){
        try {
            if(root==null)return false;
            if(root.data==key) return true;
            boolean flag=find(root.left,key);
            if(flag) return true;
            boolean flag1=find(root.right,key);
            return flag1;
        } catch (Exception e) {
            return false;
        }
    }
    // public boolean deletionOfNode(Node root){
    //     try {
    //         if(root==null)return false;
    //         if(root.left==null && root.right==null)return true;
    //         boolean flag=deletionOfNode(root.left);
    //         if(flag)return true;
    //         boolean flag1=deletionOfNode(root.right);
    //         return flag1;
    //     } catch (Exception e) {
    //         return false;
    //     }
    // }
    public void InOrder(Node root){
        if(root==null)return;
        InOrder(root.left);
        System.out.print(root.data+" -> ");
        InOrder(root.right);
    }
    public void PreOrder(Node root){
        if(root==null)return;
        System.out.print(root.data+" -> ");
        PreOrder(root.left);
        PreOrder(root.right);    
    }
    public void PostOrder(Node root){
        if(root==null)return;
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.data+" -> ");
    }

}
public class BinaryTree{
    public static void main(String[] args) {
        BinaryTreeImplementation tree=new BinaryTreeImplementation();
        int[] data = {1, 2, 4, 0, 0, 5, 0, 0, 3, 6, 0, 0, 7, 0, 0};
        Node root = tree.insert(data);
        // Node root=tree.insert();
        tree.InOrder(root);
        System.out.println();
        tree.PreOrder(root);
        System.out.println();
        tree.PostOrder(root);
        System.out.println(tree.find(root, 10));
    }
}
