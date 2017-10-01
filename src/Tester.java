import java.util.*;
import java.io.*;
public class Tester
{
    public static void main(String args[]) throws IOException
    {
        HashSet<String> dict = new HashSet<>();

        Scanner dictFile = new Scanner(new File("dictionary.txt"));

        while(dictFile.hasNext())
            dict.add(dictFile.nextLine());

        Scanner in = new Scanner(new File("input.txt"));
        while(in.hasNext())
        {
            String start = in.next();
            String finish = in.next();

            if(start.length() != finish.length() || !dict.contains(start) || !dict.contains(finish))
            {
                System.out.printf("There is no word ladder between %s and %s!%n", start, finish);
                continue;
            }

            LinkedList usedWords = new LinkedList();
            usedWords.addFront(start);

            QueueLL stacks = new QueueLL();

            StackLL firstStack = new StackLL();
            firstStack.push(start);

            stacks.enqueue(firstStack);

            while(true) //change this boolean later, or don't
            {
                if(stacks.isEmpty())
                {
                    System.out.printf("There is no word ladder between %s and %s!%n", start, finish);
                    break;
                }

                StackLL baseStack = (StackLL)stacks.dequeue();
                if(baseStack.peek().equals(finish))
                {
                    System.out.println(baseStack.toStringBackwards());
                    break;
                }

                Iterator itr = dict.iterator();
                while(itr.hasNext())
                {
                    String nextWord = (String)itr.next();
                    if(!usedWords.contains(nextWord) && oneCharDiff((String)baseStack.peek(), nextWord))
                    {
                        StackLL temp = baseStack.deepCopy();
                        temp.push(nextWord);
                        stacks.enqueue(temp);
                        usedWords.addFront(nextWord);
                    }
                }
            }
        }

    }

    static boolean oneCharDiff(String s1, String s2)
    {
        if(s1.length() != s2.length())
            return false;

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int diffCount = 0;
        for(int i = 0; i < c1.length; i++)
        {
            if(c1[i] != c2[i])
                diffCount++;
        }
        return (diffCount == 1);
    }

}
