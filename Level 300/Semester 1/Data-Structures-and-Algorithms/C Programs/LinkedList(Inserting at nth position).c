/*Inserting a node at any position in the linked list
10/27/2022
*/
#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
//We declare a structure Node that will contain an integer and a pointer to the next node
struct Node{
	int data;
	struct Node* next;
};

struct Node* head = NULL;

//Insert function: Inserts a node at any position n

void Insert()
{
	int pos, i;
	struct Node* new_node = (struct Node*)malloc(sizeof(struct Node)); // Create a pointer to new node
	printf("\nEnter data: ");
	scanf("%d", &new_node->data);
	new_node->next = NULL;
	
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

}

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

int main()
{
	char choice;
	do{
		Insert();
		Display();
		printf("\n\nDo you want to insert another node? 'y' or 'n'");
		choice = getche();
		
	} while(choice != 'n');
	getch();
return 0;	
}

