# THE CONTROL UNIT
This is sometimes referred as the master of the computer processes because it lets the computer’s logic unit,
memory and both input and output devices know how to respond to instructions received from a program.
Instructions are fetched into the control unit which in turn decodes the instructions so that the adder and logic
circuit can understand. 
<br>
As it can be seen below our control unit is made up of the control logic gates, 7-flipflops, PQ-generator, sequence
counter, 4x16-decoder and the 3x8-decoder.
<br>

# The Control Logic Gates
This is a hardware component of a basic computer system, it comprises
of inputs and outputs the diagram below shows hard wiring of the control
organization.<br>
<br>
Here, we have the 9 control logic gates for the 9registers, fetch and
decode process, the bus counter gates, the 7-flipflop as you can clearly observe
below.<br><br>
The control logic gates get its inputs from the 3x8 decoder and the 4x16
decoder, the I-flip-flop, bits 0 through 11 of the instruction register.
<br>

# THE REGISTERS
This refers to a group of flip-flops with each flip-flop capable of storing
one bit of information, this mean that an n-bit register has n-flip-flops and store
n-bit of information. In this project, we shall focus on 9- registers which store
their own amount of data and have different number of bits.
<br>
<br>
The memory address register (AR) has 12 bits since this is the width of a
memory address. The program counter (PC) also has 12 bits and it holds the
address of the next instruction to be read from memory after the current
instruction is executed. The PC goes through a counting sequence and causes the
computer to read sequential instructions previously stored in memory. 
<br>
<br>
Instruction words are read and executed in sequence unless a branch instruction is
encountered. A branch instruction calls for a transfer to a nonconsecutive
instruction in the program. The address part of a branch instruction is transferred
to PC to become the address of the next instruction. To read an instruction, the
content of PC is taken as the address for memory and a memory read cycle is
initiated. <br><br>
PC is then incremented by one, so it holds the address of the next
instruction in sequence. Two registers are used for input and output. The input
register (INPR) receives an 8-bit character from an input device. The output
register (OUTR) holds an 8-bit character for an output device.
<br>

# THE BUS
A bus structure consists of a set of common lines, one for each bit of a register,
through which binary information is transferred one at a time. Control signals
determine which register is selected by the bus during each particular register
transfer. One way of constructing a common bus system is with multiplexers. 
<br><br>
The multiplexers select the source register whose binary information is then placed on
the bus. The construction of a bus system for eight registers is shown below. Each
register has its own number of bits which ranges from 8-16 bits. The bus consists
of sixteen 8x1 multiplexers with 3 selection inputs, S2, S1 and S0. In order not to
complicate the diagram with 16 lines crossing each other, we use labels to show
the connections from the outputs of the registers to the inputs of the multiplexers.


# THE MEMORY
The memory sometimes known as the storage unit of the computer is divided into
the RAM and ROM in our case.