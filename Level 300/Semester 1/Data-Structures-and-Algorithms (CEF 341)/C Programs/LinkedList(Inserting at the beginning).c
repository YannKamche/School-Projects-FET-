/* LINKED LIST IMPLEMENTATION
Inserting a node at the beginning of a Linked List
10/19/2022
*/

#include<stdio.h>
#include<stdlib.h>
#include<conio.h>

/*Create a Node containing an integer variable and a pointer variable
( The pointer variable points to the next node)*/

struct Node{
	int data;
	struct Node* next;
};

/*Creating a pointer to the head node- This node contains the address of the first node in our list.
If the List is EMPTY, the head node must point to NULL, otherwise to the first node in the list*/
 
struct Node* head; // head is a global variable that can be accessed anywhere

//Insert_Beginning Function: It inserts a node at the beginning of the List

void Insert_Beginning(int n)
{
	/*To create a node, we use the malloc function
	Bear in mind that malloc returns a pointer to a memory space.
	We need to create a pointer variable 'temp' to store the value returned by malloc*/
	
	struct Node* temp = (struct Node*)malloc(sizeof(struct Node));
	temp->data = n; 
	temp->next = head;
	head = temp; // Points head to the first node, and its value will be the address of the first node

}

//Print Function: It displays the number stored in each node

void Print()
{
	struct Node* temp = head;
	printf("List is: ");
	while(temp != NULL)
	{
		printf("%d ", temp->data);
		temp = temp->next;
	}
	printf("\n");
}
	
int main()
{
	head = NULL;
	 // The list is empty  
	
	/* Inserting a node at beginning of the List
	Let's prompt the user to enter some number
	*/
	
	printf("How many numbers does your list contain? \n");
	
	/* We declare three variables
	- num_element:  Contains the number elements in the list.
	- i:  Iterates through the elements entered by the user.
	- element:  An element entered by the user.
	*/
	
	int num_element, i, element; 
	scanf("%d", &num_element);
	
	for(i = 0; i < num_element; i++)
	
	{
		printf("Enter number %d \n", i+1);
		scanf("%d", &element);
		
		// We call the function Insert_Beginning and Print
		
		Insert_Beginning(element);
		Print();		
	}
	
	
	return 0;
}