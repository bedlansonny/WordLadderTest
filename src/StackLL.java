public class StackLL
{
    LinkedList ll;

    public StackLL()
    {
        ll = new LinkedList();
    }

    public StackLL(LinkedList presetll)
    {
        ll = presetll;
    }

    public void push(Object data)
    {
        ll.addFront(data);
    }

    public Object peek()
    {
        return ll.get(0);
    }

    public Object pop()
    {
        Object output = ll.get(0);
        ll.remove(output);
        return output;
    }

    public int size()
    {
        return ll.size();
    }

    public boolean isEmpty()
    {
        return ll.size() == 0;
    }

    public void clear()
    {
        ll = new LinkedList();
    }

    public String toString()
    {
        return ll.toString();
    }

    public String toStringBackwards()
    {
        String output = "[";
        for(int i = ll.size()-1; i > 0; i--)
        {
            output += ll.get(i).toString() + ", ";
        }
        output += ll.get(0).toString() + "]";

        return output;
    }

    public StackLL deepCopy()
    {
        StackLL output = new StackLL(ll.deepCopy());
        return output;
    }
}