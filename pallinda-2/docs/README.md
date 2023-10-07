### Task 1 - Debugging Concurrent Programs
In this task, you will be provided with two buggy programs. For each program, you should:  
1. Explain what is worng with the code. 
1. Fix the bug.  
1. Explain why your solution fixes the bug.  

#### bug01.go 
The code in its current implementation produces a deadlock situation, where the goroutines are are waiting for each other and none of them are able to proceed. This happens in bug01.go because the program gets stuck on the channel send operation ```ch <- "Hello world!"```, waiting forever for someone to receive or read the value string.  
My solution fixes this bug because we now have a **sending** goroutine and a **receiving** goroutine (the receiving goroutine is the main function itself).  

#### bug02.go
The initial code had the problem that the channel is closed before the receiving goroutine has a chance to receive the value. This happens because the loop exits after the last value is sent on the channel and then the close function is executed before it has time to be received (removing the close function would not fix this though, as the main function would still finish before the last value from the loop is received by the channel). To fix this, I added waitgroup functionality. Now the goroutines are coordinated so that they wait for each other to finish by way of the ``Done()`` and ``Wait()`` commands from the sync package.  
-[x]

### Task 2 - Many Senders; Many Receivers
The program many2many.go contains four producers that together send 32 strings over a channel. At the other end there are two consumers that receive the strings. Describe what happens, and explain why it happens, if you make the following changes in the program. Try first to reason your way through, and then test your hypothesis by changing and running the program.

* What happens if you switch the order of the statements ``wgp.Wait()`` and ``close(ch)`` in the end of the main function?
  * If you switch the order of those two statements, the program will close the channel before waiting for it to finish using it. This will     cause a problem because you will be attempting to send and receive over a closed channel. 
* What happens if you move the ``close(ch)`` from the main function and instead close the channel in the end of the function Produce?
  * Moving the ``close(ch)`` statement to the end of the ``produce`` function will allow some messages to be sent through before the channel closes prematurely and we get an error telling us that we can't send over a closed channel. Some of the last messages don't get sent through because the channel is closed after the first producer has finished and the leftover strings that are to be sent through don't get a chance to since the remaining goroutines will attempt to send over a closed channel. 
* What happens if you remove the statement ``close(ch)`` completely?
  * If we remove the ``close()`` statement entirely, nothing will change. This is because the closing of a channel is only necessary if a receiver is looking for a close, which is not the case here. 
* What happens if you increase the number of consumers from 2 to 4?
  * The code will run faster since there will be more receiving goroutines.
* Can you be sure that all strings are printed before the program stops?
  * All of the strings will only be printed if the first sending goroutine is completed *after* the receiving goroutine since the print statement is in the receiving goroutine and the program only waits for the sending goroutine ``produce``. You would have to add a waitgroup that waits for all consumers as well if you want to guarantee all of the strings being printed.


