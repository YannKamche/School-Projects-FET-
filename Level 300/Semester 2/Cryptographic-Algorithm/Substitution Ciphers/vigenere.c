#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main()
{
    char inputString[100];
    char keyString [] = "SECURITY";
	int i, j;
	
    int keyLength = strlen(keyString);
	//Getting a value for inputString
    printf("Please enter a message: ");
    gets(inputString);
    int stringLength = strlen(inputString); 
    char newKeyValue[stringLength], encryptedString[stringLength], decryptedString[stringLength];
    
    //Setting inputString to uppercase
    for(i=0; inputString[i]!='\0'; i++)
    {
   	if(inputString[i]>='a' && inputString[i]<='z')
    	{
    		inputString[i] = inputString[i] - 32;
		}
	}
	//Creating new key according to inputString length
    for(i=0, j=0; i<stringLength; i++, j++)
    {
    	if(j == keyLength)
    		j=0;	
    		newKeyValue[i] = keyString[j];
	}
	newKeyValue[i] = '\0';
	//Encryption Section
	for(i=0; i< stringLength; i++)
		if(inputString[i] == 32) //Handling blank space between words
		{
			encryptedString[i] = 32; // assigning blank space to encrypted string
				}	
				else
				{
						
		encryptedString[i] = ((inputString[i] + newKeyValue[i]) % 26) + 65;
}
	encryptedString[i] = '\0'; //Letting the code know that it reached the end of the string
	
	//Decryption Section
	for(i=0; i<stringLength; i++)
		if(encryptedString[i] == 32) //Handling blank space between word
		{
			decryptedString[i] = 32; // assigning blank space to decrypted string
		}
		else
		{
		
		decryptedString[i] = (((encryptedString[i] - newKeyValue[i]) + 26) % 26) + 65;
}
	decryptedString[i] = '\0'; //Letting the code know that it reached the end of the string
    //Output results
    printf("Plaintext: %s\n", inputString);
    printf("Keyword: %s\n", keyString);
    printf("Ciphertext: %s\n", encryptedString);
    printf("Decrypted Text: %s\n", decryptedString);
    return 0;
}