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
            String start = in.next().trim();
            String finish = in.next().trim();

            if(start.length() != finish.length() || !dict.contains(start) || !dict.contains(finish))
            {
                System.out.printf("There is no word ladder between %s and %s!%n", start, finish);
                continue;
            }

            HashSet<String> minidict = new HashSet<>();
            int targetLength = start.length();
            Iterator dictitr1 = dict.iterator();
            while(dictitr1.hasNext())
            {
                String entry = (String)dictitr1.next();
                if(entry.length() == targetLength)
                    minidict.add(entry);
            }
            //testing
            //System.out.println(minidict.size());


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


                //instead of searching entire dictionary for string w onechardiff,
                //see if dict contains
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

                        if(!usedWords.contains(tempWord) && minidict.contains(tempWord))
                        {
                            StackLL tempStack = baseStack.deepCopy();
                            tempStack.push(tempWord);
                            stacks.enqueue(tempStack);
                            usedWords.addFront(tempWord);

                            //System.out.println(stacks);
                        }

                    }
                }

                /*
                while(minidictitr1.hasNext())
                {
                    String nextWord = (String)minidictitr1.next();
                    if(!usedWords.contains(nextWord) && oneCharDiff((String)baseStack.peek(), nextWord))
                    {
                        StackLL temp = baseStack.deepCopy();
                        temp.push(nextWord);
                        stacks.enqueue(temp);
                        usedWords.addFront(nextWord);

                        //testing
                        //System.out.println(stacks);
                    }
                }
                */
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
