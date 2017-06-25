package algorithms;

/**
 * Created by olexandra on 6/24/17.
 */
public class LinkedListElement {

    private LinkedListElement next;
    private String content;

    public LinkedListElement(String content) {
        this.content = content;
    }

    public LinkedListElement getNext() {
        return next;
    }

    public void setNext(LinkedListElement next) {
        this.next = next;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkedListElement)) return false;

        LinkedListElement that = (LinkedListElement) o;

        if (next != null ? !next.equals(that.next) : that.next != null) return false;
        return content.equals(that.content);
    }

    @Override
    public int hashCode() {
        int result = next != null ? next.hashCode() : 0;
        result = 31 * result + content.hashCode();
        return result;
    }
}
