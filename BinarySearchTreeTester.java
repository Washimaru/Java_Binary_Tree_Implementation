import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;
import java.lang.IndexOutOfBoundsException;

public class BinarySearchTreeTester {
    

    @Test
    public void testInsert(){
        BinarySearchTree<Integer, Integer> list = new BinarySearchTree<Integer, Integer>();

        list.insert(9, 3);
        list.insert(5, 4);
        list.insert(3, 7);
        list.insert(2, 9);
        list.insert(8, 11);
        list.insert(6, 12);
        list.insert(7, 13);
        list.insert(13, 14);
        list.insert(10, 15);
        list.insert(18, 16);
        list.insert(15, 17);
        list.insert(26, 19);

        assertEquals("[9, 7, 4, 12, 13, 11, 3, 15, 14, 17, 16, 19]", list.inorderRec().toString());

        list.insert(1, 10);
        assertEquals("[10, 9, 7, 4, 12, 13, 11, 3, 15, 14, 17, 16, 19]", list.inorderRec().toString());

        list.insert(4, 6);
        list.insert(11, 20);
        assertEquals("[10, 9, 7, 6, 4, 12, 13, 11, 3, 15, 20, 14, 17, 16, 19]", list.inorderRec().toString());
    }

    @Test
    public void testSearch(){
        BinarySearchTree<Integer, Integer> list = new BinarySearchTree<Integer, Integer>();

        list.insert(9, 3);
        list.insert(5, 4);
        list.insert(3, 7);
        list.insert(2, 9);
        list.insert(8, 11);
        list.insert(6, 12);
        list.insert(7, 13);
        list.insert(13, 14);
        list.insert(10, 15);
        list.insert(18, 16);
        list.insert(15, 17);
        list.insert(26, 19);

        assertEquals("7", list.search(3).toString());
        list.delete(7);
        assertEquals(null, list.search(7));

    }

    @Test
    public void testDelete(){
        BinarySearchTree<Integer, Integer> list = new BinarySearchTree<Integer, Integer>();

        list.insert(9, 3);
        list.insert(5, 4);
        list.insert(3, 7);
        list.insert(2, 9);
        list.insert(8, 11);
        list.insert(6, 12);
        list.insert(7, 13);
        list.insert(13, 14);
        list.insert(10, 15);
        list.insert(18, 16);
        list.insert(15, 17);
        list.insert(26, 19);

        list.delete(7);
        assertEquals("[9, 7, 4, 12, 11, 3, 15, 14, 17, 16, 19]", list.inorderRec().toString());
        list.delete(8);
        assertEquals("[9, 7, 4, 12, 3, 15, 14, 17, 16, 19]", list.inorderRec().toString());
        list.delete(9);
        assertEquals("[9, 7, 4, 12, 15, 14, 17, 16, 19]", list.inorderRec().toString());
        list.delete(5);
        list.delete(3);
        list.delete(6);
        list.delete(10);
        assertEquals("[9, 14, 17, 16, 19]", list.inorderRec().toString());

    }

    @Test
    public void testInorderRec(){
        BinarySearchTree<Integer, Integer> list = new BinarySearchTree<Integer, Integer>();

        list.insert(9, 3);
        list.insert(5, 4);
        list.insert(3, 7);
        list.insert(2, 9);
        list.insert(8, 11);
        list.insert(6, 12);
        list.insert(7, 13);
        list.insert(13, 14);
        list.insert(10, 15);
        list.insert(18, 16);
        list.insert(15, 17);
        list.insert(26, 19);

        list.delete(7);
        assertEquals("[9, 7, 4, 12, 11, 3, 15, 14, 17, 16, 19]", list.inorderRec().toString());
        list.delete(8);
        assertEquals("[9, 7, 4, 12, 3, 15, 14, 17, 16, 19]", list.inorderRec().toString());
        list.delete(9);
        assertEquals("[9, 7, 4, 12, 15, 14, 17, 16, 19]", list.inorderRec().toString());
        list.delete(5);
        list.delete(3);
        list.delete(6);
        list.delete(10);
        assertEquals("[9, 14, 17, 16, 19]", list.inorderRec().toString());
    }

    @Test
    public void testKthSmallest(){
        BinarySearchTree<Integer, Integer> list = new BinarySearchTree<Integer, Integer>();

        list.insert(9, 3);
        list.insert(5, 4);
        list.insert(3, 7);
        list.insert(2, 9);
        list.insert(8, 11);
        list.insert(6, 12);
        list.insert(7, 13);
        list.insert(13, 14);
        list.insert(10, 15);
        list.insert(18, 16);
        list.insert(15, 17);
        list.insert(26, 19);

        try{
            list.kthSmallest(13);
            Assert.fail("Didn't work");
        }
        catch(IndexOutOfBoundsException e){

        }
        catch(Exception e){
            Assert.fail("method threw wrong exception");
        }

        assertEquals("9", list.kthSmallest(1).toString());
        assertEquals("12", list.kthSmallest(4).toString());
        assertEquals("15", list.kthSmallest(8).toString());
        assertEquals("19", list.kthSmallest(12).toString());

    }
}