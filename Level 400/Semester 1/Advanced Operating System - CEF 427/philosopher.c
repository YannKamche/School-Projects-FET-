#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>

#define NUM_PHILOSOPHERS 5

sem_t chopstick[NUM_PHILOSOPHERS];
sem_t mutex;  // Mutex to protect access to the chopsticks

int cocoyams_eaten[NUM_PHILOSOPHERS];  // Counter for the number of cocoyams eaten

void *philosopher(void *arg);
void eat(int philosopher_id);
void think(int philosopher_id);
int is_satisfied();

int main()
{
    int i;
    pthread_t philosophers[NUM_PHILOSOPHERS];

    // Initialize semaphores
    sem_init(&mutex, 0, 1);
    for (i = 0; i < NUM_PHILOSOPHERS; i++)
    {
        sem_init(&chopstick[i], 0, 1);
        cocoyams_eaten[i] = 0;  // Initialize cocoyams eaten counter
    }

    // Create philosopher threads
    for (i = 0; i < NUM_PHILOSOPHERS; i++)
        pthread_create(&philosophers[i], NULL, philosopher, (void *)(intptr_t)i);

    // Join philosopher threads
    for (i = 0; i < NUM_PHILOSOPHERS; i++)
        pthread_join(philosophers[i], NULL);

    // Destroy semaphores
    sem_destroy(&mutex);
    for (i = 0; i < NUM_PHILOSOPHERS; i++)
        sem_destroy(&chopstick[i]);

    return 0;
}

void *philosopher(void *arg)
{
    int philosopher_id = (int)(intptr_t)arg;

    while (1)
    {
        think(philosopher_id);

        sem_wait(&mutex);
        sem_wait(&chopstick[philosopher_id]);
        sem_wait(&chopstick[(philosopher_id + 1) % NUM_PHILOSOPHERS]);
        sem_post(&mutex);

        eat(philosopher_id);

        sem_post(&chopstick[philosopher_id]);
        sem_post(&chopstick[(philosopher_id + 1) % NUM_PHILOSOPHERS]);

        // Check if the philosopher is satisfied and decides to stop eating
        if (is_satisfied()) {
            printf("Philosopher %d is satisfied and decides to stop eating. Cocoyams eaten: %d\n", philosopher_id, cocoyams_eaten[philosopher_id]);
            pthread_exit(NULL);
        }
    }
}

void eat(int philosopher_id)
{
    printf("Philosopher %d is eating. Cocoyams eaten: %d\n", philosopher_id, ++cocoyams_eaten[philosopher_id]);
    sleep(rand() % 5 + 1); // Simulate eating time
    printf("Philosopher %d has finished eating\n", philosopher_id);
}

void think(int philosopher_id)
{
    printf("Philosopher %d is thinking\n", philosopher_id);
    sleep(rand() % 5 + 1); // Simulate thinking time
}

int is_satisfied()
{
    // Randomly determine if the philosopher is satisfied (e.g., 20% chance of being satisfied)
    return rand() % 100 < 20;
}
