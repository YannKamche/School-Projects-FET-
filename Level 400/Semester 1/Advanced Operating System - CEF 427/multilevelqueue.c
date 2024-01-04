#include <stdio.h>
#include <stdlib.h>

#define NUM_PRIORITY_LEVELS 3
#define QUEUE_CAPACITY 10

// Task structure
typedef struct {
    int priority;
    int task_id;
} Task;

// Queue structure
typedef struct {
    Task tasks[QUEUE_CAPACITY];
    int front, rear;
} Queue;

// Global variables
Queue queues[NUM_PRIORITY_LEVELS];

// Function prototypes
void enqueue(Task task);
Task dequeue();
int isQueueEmpty(int priority);

int main() {
    // Initialize queues
    for (int i = 0; i < NUM_PRIORITY_LEVELS; ++i) {
        queues[i].front = queues[i].rear = -1;
    }

    // Enqueue tasks with different priorities
    for (int i = 0; i < 10; ++i) {
        Task task;
        task.priority = rand() % NUM_PRIORITY_LEVELS;
        task.task_id = i;
        enqueue(task);
    }

    // Dequeue and process tasks
    while (!isQueueEmpty(0) || !isQueueEmpty(1) || !isQueueEmpty(2)) {
        Task task = dequeue();
        printf("Processing task %d with priority %d\n", task.task_id, task.priority);
        // Simulate task execution
    }

    return 0;
}

void enqueue(Task task) {
    int priority = task.priority;

    if (queues[priority].rear == QUEUE_CAPACITY - 1) {
        printf("Queue at priority %d is full. Cannot enqueue task %d\n", priority, task.task_id);
        return;
    }

    if (queues[priority].front == -1) {
        queues[priority].front = 0;
    }

    queues[priority].rear++;
    queues[priority].tasks[queues[priority].rear] = task;

    printf("Enqueued task %d with priority %d\n", task.task_id, priority);
}

Task dequeue() {
    for (int i = 0; i < NUM_PRIORITY_LEVELS; ++i) {
        if (!isQueueEmpty(i)) {
            Task task = queues[i].tasks[queues[i].front];

            if (queues[i].front == queues[i].rear) {
                queues[i].front = queues[i].rear = -1;
            } else {
                queues[i].front++;
            }

            return task;
        }
    }

    // Return a task with a special value if all queues are empty
    Task emptyTask = { -1, -1 };
    return emptyTask;
}

int isQueueEmpty(int priority) {
    return queues[priority].front == -1;
}

