BareBonesInterpreter README:

When initialising the "BareBonesInterpreter" class, you should have a direct path to the file you want to read. You
can do this by doing: "shift" + "right-click" on the file, and selecting "Copy as path".

There are 6 separate commands:
    - "clear" : Initialises the variable after it or resets it back to 0
    - "incr" : Increment the variable by 1
    - "decr" : Decrease the variable by 1
    - "while" : Performs a while loop, for a variable while it is not equal to 0
    - "end" : End of a while loop, either going back to the while loop or continuing
    - "print" : Prints the variables value to console

Formatting with examples
    - "clear X" : Creates a variable named X, anything past X will not be read
    - "incr X" : Increases the variable X by 1
    - "decr X" : Decreases the variable X by 1
    - "while X not 0 do" : While X!=0, do the following lines of code
    - "end" : End of a while loop
    - "print X" : Prints the value of X

You should not use a ';' at the end of each line, and each line is taken as a new statement meaning you cannot combine
multiple lines of code into 1. It will run (usually) but it will not read anything past it.
    e.g. clear Y; incr Y; clear X;
    would create a variable named 'Y;' instead of 'Y' and anything past that will break

Indentation also does not matter, this is all cleared out in code anyway.

All lines of code will run until an error is met, where in this case, the console will give an error which will state
what went wrong and where (not in much detail though).

