If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in Markdown format :)

**Exercise S.6
Come up with one or more further optimizations that could be made to the algorithm. Also consider if you would have to alter any of the unit tests before implementing the optimization(s). Write down your ideas in docs/README.md.
Of course, if you want to implement your ideas you are free to do so as long as your implementation still passes the tests.**

We could exclude all numbers that don't end in 1,3,7 and 9 from being checked (since we know that they are prime). This would help save time since the program wouldn't have to check all of those numbers for primality. 
Of course, to do this we would have to initially declare 2 and 5 as prime numbers, since they are the only prime numbers that don't follow the rule.   
The SieveTest class would not have to be modified for these implementations. 



