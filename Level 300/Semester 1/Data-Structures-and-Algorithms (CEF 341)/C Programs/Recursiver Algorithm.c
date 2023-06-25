#include<stdio.h>

int Seq_Un(int n)
{
	if( n == 0 || n == 1 || n == 2)
		return 1;
	else
		return (Seq_Un(n-3) + (2 * Seq_Un(n-2)) + (3* Seq_Un(n-1)));
}
int main()
{
	int num;
	printf("Enter a number: ");
	scanf("%d", &num);
	printf("Result: %d", Seq_Un(num));
	
	return 0;
}