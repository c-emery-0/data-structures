import java.util.Stack;

/**
 * This program simulates an undo stack. Note that operations
 * must be undone in the opposite order in which they are first
 * issued.
*/
public class StackDemo
{
    public static void main(String[] args)
    {
        Stack<String> commands = new Stack<>();

        //push  a bunch of commands to the top of the stack
        commands.push("insert: 'hello'");
        commands.push("insert: ','");
        commands.push("insert: ' '");
        commands.push("insert: 'world'");
        commands.push("insert: '?'");
        commands.push("delete: '?'");
        commands.push("insert: '!'");
        
        //top of stack is on the farright
        System.out.println(commands);

        //simulate the user pressing undo 4 times
        commands.pop();
        commands.pop();
        commands.pop();
        commands.pop();
        
        System.out.println(commands);

    }
}
