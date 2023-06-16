/*
Author: Kamche Yann Arnaud
Title: Linked List
11/14/2022
*/

#include<stdio.h>
#include<stdlib.h>
#include<conio.h>

struct Node* head = NULL;
	struct Node{
	int data;
	struct Node* next;
};
	
//Inserts an element at any position
void Insert(int data, int pos)
{
	int i;
	struct Node* new_node = (struct Node*)malloc(sizeof(struct Node)); // Create a pointer to new node
	
	new_node->data = data;
	//new_node->next = NULL;
	
	printf("Enter the position: ");
	scanf("%d", &pos);
	
	if(pos == 1){
		new_node->next = head;
		head = new_node;
	}
	
	else{
		struct Node* temp = head;
		for(i = 0; i < pos-2; i++)
		{
			temp = temp->next;
		}
		
		new_node->next = temp->next;
		temp->next = new_node;
	}
	return;
}

//Display the Linked List
void Display()
{
	struct Node* temp;
	temp = head;
	printf("The Linked List is: ");
	while(temp != NULL)
	{
		printf("%d-->", temp->data);
		temp = temp->next;
	}
	
	printf("NULL");
}
//Reverse a Linked List
void Reverse()
{
	struct Node *current, *prev, *next;
	current = head;
	prev = NULL;
	while (current!= NULL)
	{
		next = current->next;
		current->next = prev;
		prev = current;
		current = next;
	}
	head = prev;
	Display();
}

//Destroy a Linked List
void Destroy()
{
	struct Node* next;
	
	while (head!= NULL)
	{
		next = head->next;
		free(head);
		head = next;
	}
	Display();
	return;
}

int main(){
	int choice, value, position;
	
	options:
		printf("\n");
	printf("1. Insert an element in the linked list at any position\n");
	printf("2. Destroy linked list\n");
	printf("3. Reverse linked list\n");
	printf("4. Display linked list\n");
	
	printf("\n Make a choice: ");
	scanf("%d", &choice);
	
	switch(choice){
		
		case 1:
			printf("Enter the value to be inserted: ");
			scanf("%d", &value);
			printf("Enter the position: ");
			scanf("&d", &position);
			
			Insert(value, position);
			break;
		
		case 2:
			Destroy();
			break;
		
		case 3:
			Reverse();
			break;
		
		case 4:
			Display();
			break;		
			}
		goto options;
	return 0;
}
	


