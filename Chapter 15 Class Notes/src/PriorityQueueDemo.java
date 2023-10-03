import java.util.PriorityQueue;
import java.util.Queue;


/**
 * This program demonstrates a priority queue of to-do items. The
 * most important to-do items are removed first.
*/
public class PriorityQueueDemo
{
    public static void main(String[] args)
    {
        // create a to do list 
        // the work order class has a priority and a description
        Queue<WorkOrder> toDo = new PriorityQueue<>();

        toDo.add(new WorkOrder(3, "water plants"));
        toDo.add(new WorkOrder(2, "make dinner"));
        toDo.add(new WorkOrder(2, "conquer world"));
        toDo.add(new WorkOrder(1, "play le epic video game"));
        toDo.add(new WorkOrder(10, "study for chapter 15 test"));
        toDo.add(new WorkOrder(1, "excrete oils"));
        
        //print out priority q
        //objects arent stored in priority order
        System.out.println(toDo);

        //objects are removed in priority order
        while(toDo.peek() != null)
            System.out.println(toDo.remove());
    }
}
