import java.util.Iterator;
import java.util.LinkedList;

public class RewindIterator<E> implements Iterator<E> {

    private Iterator<E> client;
    private LinkedList<E> buffer = new LinkedList<>();
    private LinkedList<E> emitted = new LinkedList<>();
    private LinkedList<Integer> markPositions = new LinkedList<>();

    public RewindIterator(Iterator<E> client) {
        this.client = client;
    }

    @Override
    public boolean hasNext() {
        return !buffer.isEmpty() || client.hasNext();
    }

    @Override
    public E next() {
        E nextElement;
        if (!buffer.isEmpty()) {
            nextElement = buffer.removeFirst();
        } else {
            nextElement = client.next();
        }

        if (!markPositions.isEmpty()) {
            emitted.add(nextElement);
        }

        return nextElement;
    }

    public void mark() {
        markPositions.add(emitted.size());
    }

    public void rewind() throws IllegalStateException {
        if (markPositions.isEmpty()) {
            throw new IllegalStateException("No active marks.");
        }

        int lastMarkPosition = markPositions.removeLast();
        int rewindAmount = emitted.size() - lastMarkPosition;
        while (rewindAmount-- > 0) {
            buffer.addFirst(emitted.removeLast());
        }
    }
}
