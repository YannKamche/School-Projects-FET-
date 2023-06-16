/* LINKED LIST IMPLEMENTATION
Inserting a node at the end  of a Linked List
10/22/2022
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

//Insert_End Function: It inserts a node at the end of the List

void Insert_End(int n)
{

	//Create a new memory location  with malloc( It returns a pointer to that location)
	struct Node* temp = (struct Node*)malloc(sizeof(struct Node));
	temp->data = n;
	temp->next = NULL;
	
	if(head == NULL){
		head = temp;
		return;
	}
	struct Node* temp1 = head;
	while(temp1->next != NULL)
	{
		temp1=temp1->next;
	}
	temp1->next = temp;	
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
		
		// We call the function Insert_End and Print
		Insert_End(element);
		Print();		
	}
	                     
}

