public class QueueLL
{
    LinkedList ll;

    QueueLL()
    {
        ll = new LinkedList();
    }

    public void enqueue(Object data)
    {
        ll.addBack(data);
    }

    public Object peek()
    {
        return ll.get(0);
    }

    public Object dequeue()
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

    public String toString()
    {
        return ll.toString();
    }
}
