/**
    This class implements a binary search tree whose
    nodes hold objects that implement the Comparable
    interface.
*/
public class BinarySearchTree
{   
    private Node root;

    /**
        Constructs an empty tree.
    */
    public BinarySearchTree()
    {   
        this.root = null;
    }
    
    /**
        Inserts a new node into the tree.
        @param obj the object to insert
    */
    public void add(Comparable obj) 
    {   
        Node newNode = new Node();
        newNode.data = obj;
        newNode.left = null;
        newNode.right = null;
        if (root == null) this.root = newNode;
        else {
            this.root.addNode(newNode);
        }
    }

    /**
        Tries to find an object in the tree.
        @param obj the object to find
        @return true if the object is contained in the tree
    */
    public boolean find(Comparable obj)
    {
        Node current = this.root;
        while (current != null) {   
            if (current.data.compareTo(obj) == 0) {
                return true;
            }
            else if (current.data.compareTo(obj) > 0) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return false;
    }
    
    /**
        Tries to remove an object from the tree. Does nothing
        if the object is not contained in the tree.
        @param obj the object to remove
    */
    public void remove(Comparable obj)
    {
        Node toBeRemoved = this.root;
        Node parent = null;
        boolean found = false;

        while (!found && toBeRemoved != null) {
            if (obj.compareTo(toBeRemoved.data) == 0) {
                found = true;
            } else {
                parent = toBeRemoved;
                
                if (obj.compareTo(toBeRemoved.data) > 0) 
                    toBeRemoved = toBeRemoved.right;
                else 
                    toBeRemoved = toBeRemoved.left;
            }
        }
        
        if (found == false) return;

        if (toBeRemoved.left == null || toBeRemoved.right == null) {
            Node newChild;

            if (toBeRemoved.left == null) {
                newChild = toBeRemoved.right;
            } else {
                newChild = toBeRemoved.left;
            }

            if (parent == null) {
                this.root = newChild;
            } else if (parent.left == toBeRemoved) {
                parent.left = newChild;
            } else {
                parent.right = newChild;
            }
        }
        return;
        
        Node leastParent = toBeRemoved;
        Node least = toBeRemoved.right;
        while (least.left != null) {
            leastParent = least;
            least = least.left;
        }
        toBeRemoved.data = least.data;
        if (leastParent == toBeRemoved)
            leastParent.right = least.right;
        else
            leastParent.left = least.right;
    
    }
    
    /**
        Prints the contents of the tree in sorted order.
    */
    public void print()
    {   
        print(this.root);
    }   

    /**
        Prints a node and all of its descendants in sorted order.
        @param parent the root of the subtree to print
    */
    private static void print(Node parent)
    {   
        if (parent == null) {
            return;
        }
        print(parent.left);
        System.out.print(parent.data + " ");
        print(parent.right);
    }

    /**
        A node of a tree stores a data item and references
        to the left and right child nodes.
    */
    static class Node
    {   
        public Comparable data;
        public Node left;
        public Node right;

        /**
            Inserts a new node as a descendant of this node.
            @param newNode the node to insert
        */
        public void addNode(Node newNode)
        {   
            if (newNode.data.compareTo(data) < 0) {
                if (left == null) left = newNode;
                else left.addNode(newNode);
            } else {
                if (right == null) right = newNode;
                else right.addNode(newNode);
            }
        }
    }
}



