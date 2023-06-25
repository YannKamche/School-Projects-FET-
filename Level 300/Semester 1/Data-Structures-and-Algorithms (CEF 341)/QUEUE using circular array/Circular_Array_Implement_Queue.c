/* IMPLEMENTATION OF QUEUE 
Using Circular Arrays
10/20/2022
*/

#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#define MAX_SIZE 100

int A[MAX_SIZE];
int front = -1; 
int rear = -1;
int result;

void Create(int Queue_Size)
{
	int A[Queue_Size];
	return;
}
//Queue is Full
void Queue_Full()
{
		printf("Error: QUEUE OVERFLOW\n");
		return;
}

//Queue is Empty
void Queue_Empty()
{
		printf("Error: QUEUE EMPTY\n");
		return;
}

/*Enqueue inserts an element into the queue
Elements are inserted from the rear. 
The are three conditions to check in this case, which are:
	- Is the queue full, if yes display the state of the queue being 'FULL'
	- Is there only one element, if yes, both the front and the rear will automatically
		acquire the index of the first position in the queue.
	- Are there more than one element, if yes, increment the rear in a modulo fashion and insert an element
*/
void Enqueue(int max_size, int element)
{
	int index;
	index = (rear + 1)%max_size;
		if (index == front)
			Queue_Full();
	    else if (front == -1 && rear == -1)
			rear = front = 0;
		else
			rear = (++rear) % max_size;
		
	A[rear] = element;
	return;
}

/*Dequeue removes or pops an element out of the queue
Elements are removed from the front
There are three conditions to check in this case, which are:
	- Is the queue empty, if yes, display the state of the queue being 'EMPTY'
	- Is there only one element in the queue, if yes, both the rear and the front
		will acquire the null index(-1), signifying that the queue is empty
	- Are there more than one element in the queue, increment the front.
*/

int Dequeue(int max_size)
{
	int index;
	index =  front;
	if(front == -1)
		return 0;
	else if(front == rear)
		front = rear = -1;
	else 
		front = (front + 1)% max_size;
	return A[index];
	
}

//Display: Prints the content of the queue

void Display(int max_size)
{
		int i;
		i = front;
		if( front == -1 )
			Queue_Empty();	
		else
		{
			printf("Queue:  ");
			do
			{
				printf("%d ", A[i]);
				i = (i+1)%max_size;
			}while ( i != rear);
			
			printf("\n");
		}
		return;
}

//headOfQueue: Displays the element at the front of the queue

int headOfQueue()
{
	if(front == -1)
		return 0;
	else
		return A[front];
}

//endOfQueue: Displays the element at the rear of the queue

int endOfQueue()
{
	if(rear == -1)
		return 0;
	else 
		return A[rear];
}

//sizeOfQueue: Displays the size of the Queue

int sizeOfQueue()
{
	if( front ==-1 || rear == -1)
		return 0;
	else if(front < rear)
		return rear - front +1;
	else 
		return front - rear+ 1;
}

void statusOfQueue(int size)
{
	int index;
	index = (rear + 1)%size;
	if(front == -1)
		Queue_Empty();
	else if (index == front)
		Queue_Full();
	else
		printf("STATUS: Not Empty");
	return;	
}

int main()
{
	int Queue_Size, choice, num;
	system("color 2");
	printf("Enter the size of your Queue: ");
	scanf("%d", &Queue_Size);
	
	Create(Queue_Size);
	
	printf("1. Enqueue\n");
	printf("2. Dequeue\n ");
	printf("3. Head of queue\n");
	printf("4. End of queue\n");
	printf("5. Display Queue\n");
	printf("6. Size of queue\n");
	printf("7. Status of queue\n");
	options:
		printf("\nChoose the operation to be performed with your list: ");
	scanf("%d", &choice);
	
		while(choice == 1|| choice == 2|| choice == 3|| choice == 4 || choice == 5 || choice == 6 || choice == 7)
	{
		
		while(choice==1)
			{
				printf("Enter a number: ");
				scanf("%d", &num);
				Enqueue(Queue_Size, num);
				goto options;
			}
			
		while(choice == 2){
			result = Dequeue(Queue_Size);
			if(result == 0 )
				printf("Queue is empty");
			else
				printf("%d", result);
			goto options;
		}
			
		while(choice == 3){
			result = headOfQueue();
			if(result == 0)
				printf("No Element at the front");
			else
				printf("%d", result);
			goto options;
		}
			
		while(choice == 4){
			result = endOfQueue();
			if(result == 0)
				printf("No Element at the end");
			else
				printf("%d", result);
			goto options;
		}
			
		while(choice == 5){
			Display(Queue_Size);
			goto options;
		}
		
			while(choice == 6){
			result= sizeOfQueue();
			if(result == 0)
				printf("Queue is empty");
			else
				printf("%d", result);
			goto options;
		}
			while(choice == 7){
				statusOfQueue(Queue_Size);
				goto options;
			}
			
	}
		
return 0;
}