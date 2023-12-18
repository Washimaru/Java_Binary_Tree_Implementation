import java.util.NoSuchElementException;
import java.lang.IndexOutOfBoundsException;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

/** 
 * Binary Search Tree class, that takes generic of T and V, extends Comparable
*/
public class BinarySearchTree<T extends Comparable<? super T>, V> {

    /** 
     * nested class of BinaryNode which takes generics of T and V
     * componenets of Binary Search Tree
    */
    private static class BinaryNode<T extends Comparable<? super T>, V> {
        /** 
         * field to store key in the binary node for directions
        */
        private T key;

        /** 
         * field to store the actual data inside of Binary Node
        */
        private V value;

        /** 
         * field to store the left node
        */
        private BinaryNode<T, V> left;

        /** 
         * field to store the right node 
        */
        private BinaryNode<T, V> right;

        /**
         * constructor which sets up the BinaryNode class
         * @param keyVal input to be inserted as a key value
         * @param valueToAdd input to be inserted as the value 
        */
        public BinaryNode(T keyVal, V valueToAdd) {
            this.key = keyVal;
            this.value = valueToAdd;
            this.left = null;
            this.right = null;
        }

        /**
         * setter method for key 
         * @param keyVal value which can be set up as key 
        */
        private void setKey(T keyVal) {
            this.key = keyVal;
        }

        /**
         * getter method for key
         * @return returns key value of the Binary Node
        */
        private T getKey() {
            return key;
        }

        /**
         * setter method for value
         * @param valToAdd value which can be added/edited
        */
        private void setValue(V valToAdd) {
            this.value = valToAdd;
        }

        /**
         * getter method for value
         * @return returns value of the binary node
        */
        private V getValue() {
            return value;
        }

        /**
         * getter method for left node
         * @return returns the left node 
        */
        private BinaryNode<T, V> getLeft() {
            return left;
        }

        /**
         * setter method for left node
         * @param leftToAdd sets up the left node 
        */
        private void setLeft(BinaryNode<T, V> leftToAdd) {
            this.left = leftToAdd;
        }

        /**
         * getter method for right node
         * @return returns right node of the Binary Node
        */
        private BinaryNode<T, V> getRight() {
            return right;
        }

        /**
         * setter method for right node
         * @param rightToAdd input which can be added/edited as the right node
        */
        private void setRight(BinaryNode<T, V> rightToAdd) {
            this.right = rightToAdd;
        }

    }

    /** 
     * field to store the root binary search tree
    */
    private BinaryNode<T, V> root;

    /** 
     * BinarySearchTree constructor which sets up the root node
    */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * getter method for the root node
     * @return returns root node 
    */
    private BinaryNode<T, V> getRoot() {
        return root;
    }

    /**
     * setter method for root node
     * @param root input value of root which can be set up as root
    */
    private void setRoot(BinaryNode<T, V> root) {
        this.root = root;
    }

    /**
     * inserts the node based on the value
     * if greater than the key of the root, then it goes right, else goes left
     * @param key key value which wants to be added
     * @param value value of the binary node which wants to be added to the binary search tree
     */
    public void insert(T key, V value) {
        BinaryNode<T, V> temp = root;
        BinaryNode<T, V> parent = null;
        // while node to search through the binary search tree
        while (temp != null) {
            parent = temp;
            if (key.compareTo(temp.getKey()) < 0)
                temp = temp.left;
            else
                temp = temp.right;
        }
        if (root == null)
            root = new BinaryNode<T, V>(key, value);
        else if (key.compareTo(parent.getKey()) < 0)
            parent.left = new BinaryNode(key, value);
        else
            parent.right = new BinaryNode(key, value);
    }

    /**
     * Method to search for the binary node which has the key
     * @param key key value of the node which we want it to find
     * @return returns the value of the node which we are searching for
    */
    public V search(T key) {
        BinaryNode<T, V> nodeToSearch = searchTree(root, key);
        return (nodeToSearch == null ? null : nodeToSearch.getValue());
    }

    /**
     * helper method for the search method which helps to return the binary node which contains the key value
     * @param root the binary node which we begin searching
     * @param key key value for the binary node which we want to search for
     * @return returns the binary node which equals to the input key
    */
    private BinaryNode<T, V> searchTree(BinaryNode<T, V> root, T key){
        BinaryNode<T, V> temp = root;
        // loop to go through the binary search tree 
        // as well as to return the binary node if the key value is equal to the input key
        while (temp != null) {
            if (key.compareTo(temp.getKey()) == 0)
                return temp;
            else if (key.compareTo(temp.getKey()) < 0)
                temp = temp.left;
            else
                temp = temp.right;
        }
        return null;
    }

    /**
     * Method which deletes the binary node that we are searching for based on the input key
     * @param key key input is the key value that we are searching the binary node to delete for
     * @throws NoSuchElementException throws NoSuchElementException if the key does not exist 
    */
    public void delete(T key) throws NoSuchElementException {
        BinaryNode<T, V> changer = null;
        BinaryNode<T, V> temp = root;
        // loop to go through the binary search tree
        while (temp != null && temp.key != key) {
            changer = temp;
            if (key.compareTo(temp.getKey()) < 0)
                temp = temp.left;
            else
                temp = temp.right;
        }
        if (temp == null)
            throw new NoSuchElementException("The element does not exist");
        else
            deleteNode(temp, changer);
    }

    /**
     * helper method for delete method which helps to identify which binary node needs to be deleted
     * @param nodeToDelete input binary node which we want it to be deleted
     * @param parentNode input binary node to contain the node information which we want to delete the node of 
    */
    private void deleteNode(BinaryNode<T, V> nodeToDelete, BinaryNode<T, V> parentNode) {
        BinaryNode<T, V> childNodeToDelete = null;
        BinaryNode<T, V> parentNodeToReplace = nodeToDelete;
        BinaryNode<T, V> childNodeToReplace = nodeToDelete.right;
        if (nodeToDelete.left == null || nodeToDelete.right == null) {
            if (nodeToDelete.left != null)
                childNodeToDelete = nodeToDelete.left;
            else
                childNodeToDelete = nodeToDelete.right;
            if (nodeToDelete == root)
                root = childNodeToDelete;
            else if (nodeToDelete.key.compareTo(parentNode.key) < 0)
                parentNode.setLeft(childNodeToDelete);
            else
                parentNode.setRight(childNodeToDelete);
        } else {
            // loop to go through the binary tree
            while (childNodeToReplace.left != null) {
                parentNodeToReplace = childNodeToReplace;
                childNodeToReplace = childNodeToReplace.left;
            }

            nodeToDelete.key = childNodeToReplace.key;
            nodeToDelete.value = childNodeToReplace.value;

            deleteNode(childNodeToReplace, parentNodeToReplace);
        }
    }

    /**
     * method which returns all the values of the binary tree, in inorder traversal
     * @return returns the list which contains all values of the binary tree
    */
    public List<V> inorderRec() {
        LinkedList<V> storeList = new LinkedList<V>();
        if (root != null)
            inOrderPrint(root, storeList);
        return storeList;
    }

    /**
     * helper method for inorderRec() method which helps to store all the values
     * @param root binary node which starts at level 0 of the binary node
     * @param list list which we want to add all the values in the binary tree in
    */
    private void inOrderPrint(BinaryNode<T, V> root, List<V> list) {
        if (root.left != null)
            inOrderPrint(root.left, list);
        list.add(root.getValue());
        if (root.right != null)
            inOrderPrint(root.right, list);
    }

    /** 
     * Method to find the kth smallest value
     * @param k determines kth smallest value to get
     * @return returns value of the kth smallest
    */
    public V kthSmallest(int k) throws IndexOutOfBoundsException {
        List<V> list = inorderRec();
        // if k - 1 is greater than the amount of values, get() throws IndexOutOfBoundsException
        V value = list.get(k-1);
        return value;
    }

    public static void main(String[] args){
        System.out.println("Demonstration for Binary Search Tree Class");
        System.out.println("Code: ");
        System.out.println("BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<Integer, Integer>();" + "\n" +
                            "tree.insert(2,2);" + "\n" +
                            "tree.insert(1,1);" + "\n" +
                            "tree.insert(4,4);" + "\n" + 
                            "tree.insert(5,5);" + "\n" + 
                            "tree.insert(9,9);" + "\n" + 
                            "tree.insert(3,3);" + "\n" +
                            "tree.insert(6,6);" + "\n" +
                            "tree.insert(7,7);" + "\n" +
                            "tree.insert(10,10);" + "\n" +
                            "tree.insert(12,12);" + "\n" +
                            "tree.insert(11,11);" + "\n"
        );
        
        BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<Integer, Integer>();
        tree.insert(2,2);
        tree.insert(1,1);
        tree.insert(4,4);
        tree.insert(5,5);
        tree.insert(9,9);
        tree.insert(3,3);
        tree.insert(6,6);
        tree.insert(7,7);
        tree.insert(10,10);
        tree.insert(12,12);
        tree.insert(11,11);
        System.out.println(tree.inorderRec().toString());
        
        System.out.println("Code keys deleted for code: ");
        System.out.println("tree.delete(4);" + "\n" +
                            "tree.delete(9);" + "\n" 
        );
        tree.delete(4);
        tree.delete(9);
        System.out.println(tree.inorderRec().toString());

        try{
            tree.search(4);
        }
        catch(NullPointerException e) {
            System.out.println("Results for searching speific values: " + "\n" + 
                            tree.search(12).toString() + "\n" +
                            tree.search(4).toString()
        );
        }
        System.out.println("Results for searching speific values: " + "\n" + 
                            tree.search(12).toString() + "\n"
        );

        System.out.println("Result for the 3rd smallest element: " + "\n"
                            + tree.kthSmallest(3).toString()
        );
        
        System.out.println("Demonstration of tree with two different types" );
        BinarySearchTree<Integer, Character> tree2 = new BinarySearchTree<Integer, Character>();

        tree2.insert(2,'b');
        tree2.insert(1,'a');
        tree2.insert(4,'d');
        tree2.insert(5,'e');
        tree2.insert(9,'h');
        tree2.insert(3,'c');
        tree2.insert(6,'f');
        tree2.insert(7,'g');
        tree2.insert(10,'i');
        tree2.insert(12,'k');
        tree2.insert(11,'j');

        System.out.println("The Result of the New Binary Tree is: " + "\n" + 
                            tree2.inorderRec().toString());
    }

}
