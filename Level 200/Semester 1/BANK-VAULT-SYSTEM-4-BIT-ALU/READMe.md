# BANK VAULT SYSTEM
As a computer engineer, you are asked to design a system that will control the opening of a bank
vault. The specifications are the following; <br>
 During working hours, the president can open it or in his absence, the two vice presidents
will be needed to open it. <br>
 When it is not a working hour, it needs the president and at least one vice president before
it can open. The two vice presidents cannot op
<br>

# 4-BIT ALU
As a computer engineer, you are ask to design a 4-bit ALU that can perform the following
operations:
<br>

## Analysis

Designing a 4 BIT ALU though possible, will be such a tedious task to do. So let us use a
more tactical approach to do so. By using the principle of Divide and Conquer, splitting the 4 bit
ALU into smaller components and assembling them at the end, achieving a 4 bit ALU will be made
easier and simpler to implement. So the principle would be to create a 1 BIT ALU, and then cascade
4 of them to get the 4 BIT ALU.
<br>

Note that the ALU is able to perform 8 main operations, so the need of 3 SELECTION BITS that
would provide a basis for choosing the expected result.
<br>

## For the Arithmetic unit (AU): <br>
 Addition<br>
 Subtraction<br>
 Increment input A<br>
 Decrement input A<br>
<br>

## For the logic unit (LU)<br>
 ANDing<br>
 ORing<br>
 Complement input A<br>
 XORing<br>
 Comparator<br>

Solution. <br>
Inputs;
### A = A3 A2 A1 A0 <br>
### B = B3 B2 B1 B0<br>
### S = S2 S1 S0<br>
Outputs;<br>

### FAU – Arithmetic unit output<br>
### FLU – Logic unit output<br>
### F -- Final output<br>

# I- CONCEPTION OF THE ARITHMETIC UNIT
The AU is able to perform the 4 Mathematical operations which are:<br>
1- Addition ie A+B<br>
2- Subtraction ie A-B<br>
3- Increment ie A+1<br>
4- Decrement ie A-1<br>

But the computer uses only addition to perform any operation so how then
can we transform the additive function?<br>
In 2’s complement notation, we have: <br>
Addition A+B+0<br>
Subtraction A+ 1’s (B) +1<br>
Increment A+0+1<br>
Decrement A+ 1+0<br>


So to get subtraction, decrementation and incrementation, all we have to do is to change
the mode bit (Cin) and the entries of B to get the appropriate result.
Now, we need a component Y GEN that would select if it’s either B, 1’s (B), 0 or 1 that is to
come out with respect to the users selection code.

<br>


# II- COMPARATOR
Since our ALU works in 4-bits, it is expected to output if A<B, A>B or A=B. Let us work
from the idea of creating a two 2-bit comparator and then cascading them to get our 4-bit
comparator.