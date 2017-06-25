package algorithms;

/**
 * Created by olexandra on 6/25/17.
 */
public class LinkedListOneDirection {
    private LinkedListElement current;
    private LinkedListElement first;
    private int size = 0;

    public void add(String content) {
        current = new LinkedListElement(content);
        if (first == null) {
            first = current;
        } else {
            LinkedListElement lastElement = findLastElement();
            lastElement.setNext(this.current);
        }
        size++;
    }

    private LinkedListElement findLastElement() {
        LinkedListElement maybeLast = first;
        LinkedListElement next;
        do {
            next = maybeLast.getNext();
            if (next != null)
                maybeLast = next;
        } while (next != null);
        return maybeLast;
    }

    public LinkedListElement get(int index) {
        if (index < size) {
            LinkedListElement searchedElement = first;
            for (int elementNumber = 0; elementNumber < index; ++elementNumber) {
                searchedElement = searchedElement.getNext();
            }
            return searchedElement;
        }
        throw new IndexOutOfBoundsException("The size of the list is " + size + " so it doesn't contain element with index " + index);
    }

    public int size() {
        return size;
    }

}
