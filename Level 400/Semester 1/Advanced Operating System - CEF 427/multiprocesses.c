#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

#define NUM_PROCESSES 3
#define NUM_TASKS_PER_PROCESS 2

void performTask(int processId, int taskId) {
    // Simulate task execution
    printf("Process %d executing task %d\n", processId, taskId);
}

int main() {
    for (int i = 0; i < NUM_PROCESSES; ++i) {
        pid_t pid = fork();

        if (pid == -1) {
            // Fork failed
            perror("Fork failed");
            exit(EXIT_FAILURE);
        } else if (pid == 0) {
            // Child process
            for (int j = 0; j < NUM_TASKS_PER_PROCESS; ++j) {
                performTask(i, j);
            }
            exit(EXIT_SUCCESS);
        }
    }

    // Parent process waits for all child processes to complete
    for (int i = 0; i < NUM_PROCESSES; ++i) {
        int status;
        wait(&status);

        if (WIFEXITED(status)) {
            printf("Process %d exited with status %d\n", i, WEXITSTATUS(status));
        } else {
            printf("Process %d terminated abnormally\n", i);
        }
    }

    return 0;
}

