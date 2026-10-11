package dataStructureExercise;
public class CircularQueue {
    private int[] queue;
    private int front, rear, size, capacity;
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    public boolean isFull() {
        return size == capacity;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue element: " + element);
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = element;
        size++;
        System.out.println("Enqueued: " + element);
    }
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return -1;
        }
        int element = queue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("Dequeued: " + element);
        return element;
    }
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);      
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        circularQueue.enqueue(4);
        circularQueue.enqueue(5);      
        circularQueue.displayQueue();      
        circularQueue.dequeue();
        circularQueue.dequeue();     
        circularQueue.displayQueue();      
        circularQueue.enqueue(6);
        circularQueue.enqueue(7);       
        circularQueue.displayQueue();
    }
}
