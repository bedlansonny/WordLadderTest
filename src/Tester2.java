import java.util.*;
import java.io.*;
public class Tester2
{
    public static void main(String args[]) throws IOException
    {
        /*
        StackLL baseStack = new StackLL();
        baseStack.push(1);
        baseStack.push(2);
        baseStack.push(3);
        baseStack.push(4);
        System.out.println(baseStack);

        StackLL temp = baseStack.deepCopy();
        temp.pop();
        System.out.println(temp);
        System.out.println(baseStack);
        */

        Scanner in = new Scanner(new File("output2.txt"));
        String output = "";
        while(in.hasNext())
        {
            output += in.next().replaceAll("\\[", "").replaceAll("]", "").replaceAll(",", "") + "\n";
        }

        System.out.println(output);

        /*
        StackLL stack = new StackLL();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack);

        StackLL stack2 = new StackLL();
        stack2.push(99);
        stack2.push(100);

        StackLL stack3 = new StackLL();
        stack3.push("Potato");
        stack3.push("Panda");
        stack3.push("Pudding");

        QueueLL queue = new QueueLL();
        queue.enqueue(stack);
        queue.enqueue(stack2);
        queue.enqueue(stack3);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue);

        System.out.println(oneCharDiff("smart", "scart"));
        System.out.println(oneCharDiff("smart", "start"));
        System.out.println(oneCharDiff("smart", "swart"));
        System.out.println(oneCharDiff("smart", "dmart"));
        System.out.println(oneCharDiff("smart", "smarf"));
        System.out.println(oneCharDiff("smart", "dmarf"));
        System.out.println(oneCharDiff("smart", "smabf"));
        System.out.println(oneCharDiff("smart", "bruhh"));

        Scanner kb = new Scanner(System.in);
        while(kb.hasNext())
        {
            String input = kb.next();
            if(dict.contains(input))
                System.out.printf("%s IS in the dictionary.%n", input);
            else
                System.out.printf("%s IS NOT in the dictionary.%n", input);
        }
        */
    }
}
