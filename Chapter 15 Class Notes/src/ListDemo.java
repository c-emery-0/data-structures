import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        /* The addLast method can populate a list */
        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("Tony");
        staff.addLast("Natasha");
        staff.addLast("Peter");
        staff.addLast("Gamorra");
        /* List is currently: T N P G */


        /* 
         * The listIterator method creates a new list iterator
         * that is positioned at the head of the list
         * The "|" represents the iterator position in comments
         */
        ListIterator<String> iterator = staff.listIterator(); // | T N P G

        /* The next method advances the iterator over the next element in the list. */
        iterator.next(); // T | N P G

        /* The net method also returns the element that the iterator is passing. */
        String avenger = iterator.next(); // T N | P G
        System.out.println(avenger);
        System.out.println("Expected: Natasha");

        /* The add method inserts an element at the iterator position.
         * The iterator is then positioned AFTER the elemenet that was added
         */
        iterator.add("Bruce"); // T N B | P G
        iterator.add("Rocket"); // T N B R | P G

        /* The remove method removes the element returned by the last call
         * to the next or previous.
         * The remove method can ONLY be called after calling next or previous.
         * The remove method CANNOT be called after calling add.
         */ 
        iterator.next(); // T N B R P | G
        iterator.remove(); // T N B R | G
        System.out.println(staff);
        System.out.println("Expected: T N B R G");

        /* The set method updates the element returned by the last call to 
         * next or previous.
         */
        iterator.previous(); // T N B | R G
        iterator.set("Scott"); // T N B | S G

        /* The hasNext method is used to determine if there is a next node
         * after the iterator.
         * The hasNext is often used in a while loop condition
         */
        while(iterator.hasNext()) {


        }

        //through the looking class line 225..!!

    }
}
