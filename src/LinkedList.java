public class LinkedList
{
    Node head;
    Node tail;  //haven't properly implemented tail yet
    int count;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void addFront(Object data)
    {
        Node newNode = new Node(data);
        newNode.setNextPtr(head);
        head = newNode;
        count++;
        if(count == 1)
        {
            tail = newNode;
        }
    }

    public void addBack(Object data)
    {
        Node newNode = new Node(data);
        if(count == 0)
        {
            head = newNode;
            tail = newNode;
            count = 1;
        }
        else
        {
            tail.setNextPtr(newNode);
            tail = newNode;
            count++;
        }
    }

    public void remove(Object data)     //what if they want to remove the head?
    {
        if(count == 0)
            return;

        if(head.get().toString().equals(data.toString()))
        {
            head = head.getNextPtr();
            count--;
            return;
        }
        else
        {
            Node current = head;
            while(current.getNextPtr() != null)
            {
                //bad code: should compare more than just their toStrings. Works in this context, though.
                if(current.getNextPtr().get().toString().equals(data.toString()))
                {
                    current.setNextPtr(current.getNextPtr().getNextPtr());
                    count--;
                    break;
                }
                else
                {
                    current = current.getNextPtr();
                }
            }
        }
    }

    public Object get(int index)
    {
        if(index < 0 || index >= count)
            return null;

        Node current = head;

        for(int i = 0; i < index; i++)
        {
            current = current.next;
        }

        return current.get();
    }

    public Node getNode(int index)
    {
        if(index < 0 || index >= count)
            return null;

        Node current = head;

        for(int i = 0; i < index; i++)
        {
            current = current.next;
        }

        return current;
    }

    public boolean contains(Object data)
    {
        Node current = head;
        while(current != null)
        {
            //bad code: should compare more than just their toStrings. Works in this context, though.
            if(current.get().toString().equals(data.toString()))
            {
                return true;
            }
            else
            {
                current = current.getNextPtr();
            }
        }
        return false;
    }

    public int size()
    {
        return count;
    }

    public String toString()
    {
        Node current = head;
        String output = "[";
        while(current.getNextPtr() != null)
        {
            output += current.toString() + ", ";
            current = current.getNextPtr();
        }
        output += current.toString() + "]";

        return output;
    }

    public LinkedList deepCopy()
    {
        LinkedList output = new LinkedList();

        Node current = head;
        output.addBack(current.get());
        while(current.getNextPtr() != null)
        {
            current = current.getNextPtr();
            output.addBack(current);
        }

        return output;
    }
}
