/*
Basic Operations
    Insertion
    Search
    Deletion




                                    10
                                /        \
                               5           15
                            /    \         /   \
                            3      8      12    17     
                                  /      /  \  
                                7       11  13




Traversal Techniques
    Inorder Traversal (Left, Root, Right)
    Preorder Traversal (Root, Left, Right)
    Postorder Traversal (Left, Right, Root)
    Level-order Traversal (Breadth-First Search)
Properties and Measures
    Height of the Tree
    Depth of a Node
    Size of the Tree (Number of Nodes)
Extremum Values
    Find Minimum Value
    Find Maximum Value
Sorting
    Ascending Order (Inorder Traversal)
    Descending Order
Advanced Operations
    Find Kth Smallest Element
    Find Kth Largest Element
    Find Successor of a Node
    Find Predecessor of a Node
Tree Properties Verification
    Check if the Tree is a BST
    Find Lowest Common Ancestor (LCA)
    Check if the Tree is Balanced
    Check if the Tree is Symmetric
Augmented BST
    Count Nodes in a Given Range
    Find Sum of Nodes in a Given Range
    Rank of a Node (Order Statistics)
    Median of the BST
Modifications
    Convert BST to Doubly Linked List
    Convert BST to Greater Sum Tree
    Merge Two BSTs into One
    Split BST into Two Trees Based on a Value
Visualization
    Print All Paths from Root to Leaf
    Print a Path for a Given Sum
    Boundary Traversal
    Vertical Order Traversal
Optimization
    Self-Balancing BST (e.g., AVL Tree, Red-Black Tree)
    Threaded Binary Tree (for in-order traversal without recursion or stack)
Applications
    Range Search (Find Keys in a Range)
    Floor and Ceiling of a Given Value
    Intersection and Union of Two BSTs
    Check if Two Trees are Identical
Special Traversals
    Reverse Level Order Traversal
    Zig-Zag Level Order Traversal
Serialization and Deserialization
    Serialize the Tree to a String
    Deserialize a String Back to a Tree
Debugging and Testing
    Print BST Structure (Graphical Representation)
    Count Leaf Nodes
    Count Non-Leaf Nodes
    Check if the Tree is Complete
Conversion
    Convert a Sorted Array to a Balanced BST
    Convert a BST to a Min-Heap
    Convert a BST to a Max-Heap
 */

class Node {
    int data;
    Node left, right = null;

    Node(int data) {
        this.data = data;
    }
}

class BSTimplementation {
    Node root = null;

    public boolean insert(int data) {
        // Node newNode=new Node(data);
        root = insertion(root, data);
        return true;
    }

    private Node insertion(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        } else if (data < root.data)
            root.left = insertion(root.left, data);
        else if (data > root.data)
            root.right = insertion(root.right, data);
        return root;
    }

    private boolean search(Node root, int target) {
        try {
            if (root == null)
                return false;
            System.out.println(root.data);
            if (root.data == target)
                return true;
            return (target<root.data) ? search(root.left, target) : search(root.right, target);
        } catch (Exception e) {
            return false;
        }
    }
    protected boolean search(int target) {
        return search(root, target);
    }

    protected boolean delete(int target) {
        try {
            if(root==null)return false;   //............ if root null 
            Node parNode=null;
            Node curNode=root;
            while (curNode!=null && curNode.data!=target) {
                parNode=curNode;
                if(target<curNode.data)curNode=curNode.left;
                else curNode=curNode.right;
            }
            if(curNode.left==null && curNode.right==null){    //.... if root has no child
                if(curNode==root){
                    root=null;
                }else if(parNode.left==curNode){
                    parNode.left=null;
                }else{
                    parNode.right=null;
                }
            }
            else if(curNode.left==null || curNode.right==null)//......If root has one child 
            {
                Node tempNode=(curNode.left!=null)?curNode.left:curNode.right;
                if(curNode==root){
                    // root=null;
                    root=tempNode;
                }
                if(parNode.left==tempNode){
                    parNode.left=tempNode;
                }
                else{
                    parNode.right=tempNode;
                }
            }
            else          //..........if root has two child
            {
                Node parentSuccNode=curNode;
                Node succNode=curNode.right;
                while (succNode.left!=null) {
                    parentSuccNode=succNode;
                    succNode=succNode.left;
                }
                curNode.data=succNode.data;
                if(parentSuccNode.left==succNode)parentSuccNode.left=succNode.right;
                else parentSuccNode.right=succNode.right;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    protected void inOrder(Node root)
    {
        if(root==null)return ;
        inOrder(root.left);
        System.out.print(root.data+" -> ");
        inOrder(root.right);
    }
    protected void preOrder(Node root)
    {
        if(root==null)return ;
        System.out.print(root.data+" -> ");
        preOrder(root.left);
        preOrder(root.right);
    }
    protected void postOrder(Node root)
    {
        if(root==null)return ;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" -> ");
    }
    

}

public class BST {
    public static void main(String[] args) {
        BSTimplementation bst = new BSTimplementation();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(10);
        bst.insert(3);
        bst.insert(8);
        bst.insert(7);
        bst.insert(17);
        bst.insert(12);
        bst.insert(11);
        bst.insert(13);
        bst.inOrder(bst.root);
        System.out.println(bst.search(10));
        System.out.println(bst.delete(10));
        System.out.println(bst.search(10));
        System.out.println(bst.search(5));
        System.out.println(bst.search(15));
        // System.out.println(bst.search(10)+"- 10");
        // System.out.println(bst.search(5)+"- 5");
        // System.out.println(bst.search(15)+"- 15");
        // System.out.println(bst.search(3)+"- 3");
        // System.out.println(bst.search(8)+"- 8");
        // System.out.println(bst.search(7)+"- 7");
        // System.out.println(bst.search(17)+"- 17");
        // System.out.println(bst.search(12)+"- 12");
        // System.out.println(bst.search(11)+"- 11");
        // System.out.println(bst.search(13)+"- 13");
        // System.out.println(bst.search(1)+"- 1");
        // System.out.println(bst.min(bst.root));
        // System.out.println(bst.minimum(bst.root));
    }
}