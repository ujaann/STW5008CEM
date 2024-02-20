package Q3;

import java.util.ArrayList;

public class PriorityQueueu {

    MinHeap heap;

    PriorityQueueu() {
        heap = new MinHeap();
    }

    int dequeue() {
        return heap.deleteHeap(0);
        // we just deque top element
    }

    void queue(int element) {
        heap.insertHeap(element);
        // no heapify is used only heap insert
    }

    public static void main(String[] args) {
        PriorityQueueu pq = new PriorityQueueu();
        pq.queue(12);
        pq.queue(213);
        pq.queue(99);
        pq.queue(21);
        pq.queue(143);

        pq.dequeue();
        // we get minimium value

        System.out.println(pq);

    }

    @Override
    public String toString() {
        return heap.heapList.toString();
    }

}
