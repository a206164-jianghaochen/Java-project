package genshin;
import java.util.PriorityQueue;
class Task implements Comparable<Task> {
    String name;
    int priority;
    Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    @Override
    public int compareTo(Task other) {
        return Integer.compare(other.priority, this.priority); // Higher priority first
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + '}';
    }
}
class TaskScheduler {
    public static void main(String[] args) {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();

        // Add tasks to the priority queue
        taskQueue.add(new Task("Write report", 3));
        taskQueue.add(new Task("Email client", 1));
        taskQueue.add(new Task("Prepare presentation", 2));

        // Process tasks based on priority
        System.out.println("Processing tasks:");
        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }
    }
}
