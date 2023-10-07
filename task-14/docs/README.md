If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)

**Exercise 9.11 Assume that you see the following lines of code:** <br />
  ~~~~
  Device dev = new Printer();
  dev.getName();
  ~~~~
**Printer is a subclass of Device. Which of these classes must have a definition of method getName for this code to compile?** <br />
The superclass Device must have the getName method. This is because for type-checking static type is used and Device is the static type of dev. 

**Exercise 9.12 In the same situation as in the previous exercise, if both classes have an implementation of getName, which one will be executed?** <br />
The dynamic type of the variable dev is Printer since that is the type of object currently stored in the variable. The static type is Device since that is what is declared in the statement in the source code. Seeing as which method is found and executed first is determined by the dynamic type and not the static type, the getName method in the Printer class will be executed. 

**Exercise 9.13 Assume that you write a class Student that does not have a declared superclass. You do not write a toString method. Consider the following lines of code:**
~~~~
Student st = new Student(); 
String s = st.toString(); 
~~~~
**Will these lines compile? If so, what exactly will happen when you try to execute?**
These lines will compile, since the toString method is a method of the superclass Object. Therefore all objects can call this method and it will compile. When executing the method however we will receive a String similar to Student@7bcdd2 where the seemingly random number tells us where the object is stored in memory. It is not really useful since the object does not override the method. 

**Exercise 9.14 In the same situation as before (class `Student`, no `toString` method), will the following lines compile? Why?**
```java
Student st = new Student();
System.out.println(st);
```
No they will not compile since the only way this will work is if the toString method has been overridden in the Student class. Invoking the toString method this way is only possible if the static type has a toString method. 

**Exercise 9.15 Assume that your class `Student` overrides `toString` so that it returns the
student's name. You now have a list of students. Will the following code
compile? If not, why not? If yes, what will it print? Explain in detail what
happens.**

```java
for (Object st : myList) {
    System.out.println(st);
}
```
This code will compile and print every student's name to the terminal. This time it will work for the opposite reasons as to why it didn't work in exercise 9.14.

**Exercise 9.16 Write a few lines of code that result in a situation where a variable `x` has the static type `T` and the dynamic type `D`.**
~~~~
T x = new D();
~~~~

**Calculate the asymptotic worst-case-time for all public methods in your implementation. Express the time as a function of the number of elements n in the list.** 

addFirst: O(1) <br />
addLast: O(1)  <br />
getFirst: O(1)  <br />
getLast: O(1)  <br />
get: O(n)  <br />
removeFirst: O(1)  <br />
clear: O(n)  <br />
size: O(1)  <br />
isEmpty: O(1)  <br />
toString: O(n)  <br />
