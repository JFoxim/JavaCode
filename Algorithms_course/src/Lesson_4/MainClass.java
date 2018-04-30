package Lesson_4;


public class MainClass {
    public static void main(String[] args) {
        LinkList mList = new LinkList();
        ListIterator listIterator = mList.getIterator();

        listIterator.insertAfter(20);
        listIterator.insertAfter(40);
        listIterator.insertAfter(80);
        listIterator.insertBefore(60);
        listIterator.insertBefore(90);

        mList.displayList();
        listIterator.deleteCurrent();

        mList.displayList();
    }
}

class Link
{
    public int data;
    public Link next;
    public Link previous;
    public Link(int dd){
        data = dd;
    }
     public void displayLink(){
        System.out.print(data + " ");
    }
}

class LinkList
{
    private Link first;
    private Link last;
    public LinkList() {
       first = null;
       last = null;
    }
    public Link getFirst() {
        return first;
    }
    public Link getLast() {
        return last;
    }

    public void setFirst(Link f)
    { first = f; }

    public void setLast(Link f)
    { last = f; }

    public void insertFirst(Link newLink)
    {
         if(isEmpty())
            last = newLink;
        else
            first.previous = newLink;
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(Link newLink)
    {
        if( isEmpty() )
            first = newLink;
        else
        {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
    }

    public Link deleteFirst()
    {
        Link temp = first;
        if(first.next == null)
            last = null;
        else
            first.next.previous = null;
        first = first.next;
        return temp;
    }

    public Link deleteLast()
    {
        Link temp = last;
        if(first.next == null)
            first = null;
        else
            last.previous.next = null;
        last = last.previous;
        return temp;
    }

    public boolean insertAfter(int key, int dd)
    {
        Link current = first;
        while(current.data != key)
        {
            current = current.next;
            if(current == null)
                return false;
        }
        Link newLink = new Link(dd);
        if(current == last)
        {
            newLink.next = null;
            last = newLink;
        }
        else
        {
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        newLink.previous = current;
        current.next = newLink;
        return true;
    }

    public Link deleteKey(int key)
    {
        Link current = first;
        while(current.data != key)
        {
            current = current.next;
            if(current == null)
                return null;
        }
        if(current == first)
            first = current.next;
        else
            current.previous.next = current.next;
        if(current==last)
            last = current.previous;
        else
            current.next.previous = current.previous;
        return current;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public ListIterator getIterator(){
        return new ListIterator(this);
    }

    public void displayList(){
        Link current = first;
        while(current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}

class ListIterator
{
    private Link current;
    private Link previous;
    private LinkList ourList;

    public ListIterator(LinkList list) {
        ourList = list;
        reset();
    }

    public void reset() {
        current = ourList.getFirst();
        previous = null;
    }

    public boolean atEnd(){
        return (current.next == null);
    }

    public void nextLink(){
        previous = current;
        current = current.next;
    }

    public Link getCurrent(){
        return current;
    }

    public Link deleteFirst()
    {
        Link temp =  ourList.getFirst();
        if(ourList.getFirst().next == null)
            ourList.setLast(null);
        else
            ourList.getFirst().next.previous = null;
        ourList.setFirst(ourList.getFirst().next);
        return temp;
    }

    public Link deleteLast()
    {
        Link temp = ourList.getLast();
        if(ourList.getFirst().next == null)
            ourList.setFirst(null);
        else
            ourList.getLast().previous.next = null;
        ourList.setLast(ourList.getLast().previous);
        return temp;
    }

    public void insertLast(int dd){
        Link newLink = new Link(dd);
        if(ourList.isEmpty())
           ourList.setFirst(newLink);
        else
        {
            ourList.getLast().next = newLink;
            newLink.previous = ourList.getLast();
        }
        ourList.setLast(newLink);
    }

    public void insertAfter(int dd) {
        Link newLink = new Link(dd);
        if(ourList.isEmpty())
        {
            ourList.setFirst(newLink);
            current = newLink;
        }
        else
        {
            newLink.next = current.next;
            current.next = newLink;
            nextLink();
        }
    }

    public void insertBefore(int dd){
        Link newLink = new Link(dd);
        if(previous == null){
           newLink.next = ourList.getFirst();
           ourList.insertFirst(newLink);
           reset();
        }
        else {
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
        }
    }

    public int deleteCurrent() {
        int value = current.data;
        if(previous == null){
            ourList.setFirst(current.next);
            reset();
        }
        else {
            previous.next = current.next;
            if(atEnd())
                reset();
            else
                current = current.next;
        }
        return value;
    }
}

