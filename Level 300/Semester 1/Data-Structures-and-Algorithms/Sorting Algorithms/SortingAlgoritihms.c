/* 
Sorting Algorithms
Author: Kamche Yann Arnaud
12/01/2022
*/

#include<stdio.h>
#include<stdlib.h>

void Display(int array[], int sizeArray){
	int i;
	printf("Array: ");
	for (i = 0; i < sizeArray; i++){
		printf("%d ", array[i]);
	}	
}

//Selection Sort: Search for min or max and put it at its place

void Selection_sort(int array[], int i, int j){
	int k, max, pos, tem;
	int new_array[100];
	
	for (k = j; k>i; k--){
		max = i;
	}
	for (pos = i; pos<=k; pos++){
		if(array[pos] > array[max])
			max = pos; 
			// We permute array[max] and array[k]
			
			tem = array[max];
			array[max] = array[k];
			array[k] = tem;
			
	}
//	new_array = array; 
	printf("\n\nSelection Sort\n");
	Display(new_array, j);
	return;
}

// Bubble_sorting: Constantly checks two successive elements and put them in their right order
void Bubble_sort(int array[], int sizeArray){
	int i, j;
	
	i = sizeArray;
	while(i > 1){
		for ( j = 2; j < = i; j++){
			if (array[j] < array[j-1]){
				
			}
		}
	}
}


int main(){
	
	int T[100], size, i;//T is the array, the vaiable 'size' denotes the size of the array
	
	printf("Enter the size of your array\n");
	scanf("%d", &size);
	printf("Enter the values in your array: ");
	
	for (i = 0; i < size; i++){
		scanf("%d", &T[i]);
	}
	
	Display(T,size);
	Selection_sort(T, 0, size);
	
	return 0;
	
}