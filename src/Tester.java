import java.util.*;
import java.io.*;
public class Tester
{
    public static void main(String args[]) throws IOException
    {
        HashSet<String> dict = new HashSet<>();

        Scanner dictFile = new Scanner(new File("dictionary.txt"));     //make alphabetized dict, use binary sort

        while(dictFile.hasNext())
            dict.add(dictFile.nextLine());

        Scanner in = new Scanner(new File("input.txt"));
        while(in.hasNext())
        {
            String start = in.next().trim();
            String finish = in.next().trim();

            if(start.length() != finish.length() || !dict.contains(start) || !dict.contains(finish))
            {
                System.out.printf("There is no word ladder between %s and %s!%n", start, finish);
                continue;
            }

            //Make hashmap of minidicts, key being word length and value being the minidict.
            //make copy of it to manipulate. going through the big dictionary again to make another 4-word dictionary won't be necessary
            HashSet<String> minidict = new HashSet<>();
            int targetLength = start.length();
            Iterator dictitr1 = dict.iterator();
            while(dictitr1.hasNext())
            {
                String entry = (String)dictitr1.next();
                if(entry.length() == targetLength)
                    minidict.add(entry);
            }

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

                char[] topWordArr = ((String)baseStack.peek()).toCharArray();
                for(int repl = 0; repl < topWordArr.length; repl++)
                {
                    for(int c = 97; c < 123; c++)
                    {
                        if(c == topWordArr[repl])
                            continue;
                        char[] tempWordArr = ((String)baseStack.peek()).toCharArray();
                        tempWordArr[repl] = (char)c;
                        String tempWord = String.valueOf(tempWordArr);

                        if(minidict.contains(tempWord))
                        {
                            StackLL tempStack = baseStack.deepCopy();
                            tempStack.push(tempWord);
                            stacks.enqueue(tempStack);
                            minidict.remove(tempWord);
                        }

                    }
                }
            }
        }

    }
}
