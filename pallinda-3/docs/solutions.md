## Assignment 3

### Task 1 - Matching Behaviour 
Take a look at the program matching.go. Explain what happens and why it happens if you make the following changes. Try first to reason about it, and then test your hypothesis by changing and running the program.

* What happens if you remove the go-command from the Seek call in the main function?    
    * Then the seek function will not be executed simultaneously for all of the people in the array and it will instead be executed in order. Initially with the go statement it was randomly decided (the last goroutine to finish could be any of the goroutines for any of the people) which person that would not receive a message. Now it will always be Eva that is left out since she is the last person in the array. 
* What happens if you switch the declaration wg := new(sync.WaitGroup) to var wg sync.WaitGroup and the parameter wg *sync.WaitGroup to wg sync.WaitGroup?
    * We get a deadlock error. The first version uses a pointer of type sync.WaitGroup where as the second version just uses a variable of type sync.WaitGroup. This will matter because a pointer must be used when a variable may be modified. When we don't use a pointer the ``Done()`` statement is not recognized.
* What happens if you remove the buffer on the channel match?
    * We get a deadlock because without a buffer the sender will block until the receiver has received the value. This is problematic since the receiver needs a little more time to process (something the buffered channel accomplishes). 
* What happens if you remove the default-case from the case-statement in the main function?
    * Nothing, since there is no default case anyway. Without a default case the channel is simply blocked until one of the communications can complete.

### Task 2 - Fractal Images 
The file julia.go contains a program that creates images and writes them to file. The program is pretty slow. Your assignment is to divide the computations so that they run in parallel on all available CPUs. Use the ideas from the example in the efficient parallel computation section of the course literature. You can also make changes to the program, such as using different functions and other colourings.

**How many CPUs does you program use? How much faster is your parallel version?** <br>
The parallel version of the program takes 1.55 seconds to complete where as the original version takes just over 14 seconds to complete. By changing the value of ``GOMAXPROCS`` to one and then increasing the value gradually up again, you can start to notice an increase in performance until the value is set to 12 (which is how many logical processors my PC has). This indicates that the program uses around 12 CPUs, or in other words, all of the available processing power is being used to run this program.  

### Task 3 - MapReduce 
|Variant       | Runtime (ms) |
| ------------ | ------------:|
| singleworker |       48.68  |
| mapreduce    |       16.60  |

**Find the optimal amount of gorountines before you encounter diminishing returns in performance improvements.** <br>
After about 300 goroutines (where it seems to peak) I start to encounter diminishing returns in performance improvements.
