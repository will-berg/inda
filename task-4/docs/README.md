If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)

**Exercise 3.1
Think again about the lab-classes project that we discussed in Chapter 1 and Chapter 2. Imagine that we create a LabClass object and three Student objects. We then enroll all three students in that lab. Try to draw a class diagram and an object diagram for that situation. Identify and explain the differences between them.**

[object and class diagrams](https://imgur.com/oaJopji "diagram")

The class diagram simply shows that the class called LabClass makes use of the class Student. Then we have the object diagram that shows that the three student objects are enrolled in labClass1.

**Exercise 3.2 At what time(s) can a class diagram change? How is it changed?**

A class diagram can change if the relationship between the classes is somehow changed. For example if the dependency between the classes is changed. The dependency arrows will change to display this.

**Exercise 3.3 At what time(s) can an object diagram change? How is it changed?**

An object diagram can change very easily. It changes when you create more objects by adding those objects and it changes when you remove objects in the same way.

**Exercise 3.9 Which of the following expressions return true?**
~~~
! (4 < 5)
! false
(2 > 2) ││ ((4 == 4) && (1 < 0))
(2 > 2) ││ (4 == 4) && (1 < 0)
(34 != 33) && ! false
~~~
~~~
! (4 < 5):False
! false:True
(2 > 2) || ((4 == 4) && (1 < 0)):False
(2 > 2) || (4 == 4) && (1 < 0):False
(34 != 33) && ! false:True
~~~

**3.10. Write an expression using Boolean variables a and b that evaluates to true when a and b are either both true or both false.**
~~~
a || !b or !a || b
~~~

**3.11. Write an expression using boolean variables a and b that evaluates to true when only one of a and b is true, and that is false if a and b are both false or both true.**
~~~
(a || b) && (!a || !b)
~~~
**3.12. Consider the expression (a && b). Write an equivalent expression (one that evaluates to true at exactly the same values for a and b) without using the && operator.**
~~~
!(!a || !b)
~~~
**3.21. Rewrite the increment method without the modulo operator, using an if statement. Which solution is better?**
~~~
public void increment()
    {
    if(value < (limit - 1)) {
        value = (value + 1);
    }
    else {
        value = 0;
    }
~~~
The solution with the modulo operator is superior since it requires less code.

**3.26. Write the signature of a constructor that matches the following object creation instruction: new Editor(“readme.txt”, -1)**
~~~
ClassName(string, int)
~~~

**3.27. Write Java statements that define a variable named window of type
Rectangle, and then create a rectangle object and assign it to that variable. The rectangle
constructor has two int parameters.**
~~~
private Rectangle window;
window = new Rectangle(20, 30);
~~~
**3.30. Given a variable Printer p1; which currently holds a reference to a printer object, and two methods inside the Printer class with the headers**
~~~
public void print(String filename, boolean doubleSided)
public int getStatus(int delay)
~~~
**write two possible calls to each of these methods.**
~~~
p1.getStatus(1);
p1.getStatus(2);
p1.print("file1", true);
p1.print("file2", false);
~~~
