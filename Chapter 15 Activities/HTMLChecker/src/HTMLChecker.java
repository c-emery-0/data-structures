import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
    public static void main(String[] args)
    {
        String filename = "Chapter 15 Activities\\HTMLChecker\\src\\TagSample1.html";

        try (Scanner in = new Scanner(new File(filename)))
        {
            // Your code goes here
            
            Stack<String> tags =  new Stack<>();
            tags.push(in.next());
            while(in.hasNext()){
                String word = in.next();
                if (tags.peek().equals("<"+word.substring(2))) {
                    tags.pop();
                } else {
                    tags.push(word);
                }
            }
            if (!tags.empty()) {
                System.out.println("invalid syntax");
            } else {
                System.out.println("valid syntax");
            }


        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }

    }
}
