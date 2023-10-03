import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * This program simulates a print queue. Note that documents are printed
 * in the same order as they are submitted.
*/
public class QueueDemo
{
    public static void main(String[] args)
    {
        Queue<String> jobs = new LinkedList<>();

        //push  a bunch of jobs to the top of the stack
        jobs.add("joe: quarter 2 expense report");
        jobs.add("cathy: top secret document");
        
        System.out.println("Printing:" + jobs.remove());

        jobs.add("cathy: really top secret document");
        jobs.add("joe: grocery list");
        jobs.add("cathy: can i get fired for this");

        System.out.println("Printing:" + jobs.remove());

        jobs.add("boss: cathy termination letter");


        while(jobs.peek() != null)        
            System.out.println("Printing:" + jobs.remove());
    }
}
