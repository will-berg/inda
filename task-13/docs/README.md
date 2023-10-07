If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)

**Exercise 8.12 
Assume that we have four classes: Person, Teacher, Student, and PhDStudent. Teacher and Student are both subclasses of Person. PhDStudent is a subclass of Student.**

**a. Which of the following assignments are legal, and why or why not?**

**Person p1 = new Student();** <br />
**Person p2 = new PhDStudent();** <br />
**PhDStudent phd1 = new Student();** <br />
**Teacher t1 = new Person();** <br />
**Student s1 = new PhDStudent();** <br />

The first assignment is completely legal since Student is a subtype of the type Person. <br />
The second assignment is also legal since PhDStudent is also a subtype of the type Person. <br />
The third assignment is not legal since Student is not a subtype of type PhDStudent. <br />
The same goes for the third assignment, Person is not a subtype of type Teacher. <br />
The final assignment is valid since PhDStudent is a subtype of type Student. <br />

**b. Suppose that we have the following legal declarations and assignments:**

**Person p1 = new Person();** <br />
**Person p2 = new Person();** <br />
**PhDStudent phd1 = new PhDStudent();** <br />
**Teacher t1 = new Teacher();** <br />
**Student s1 = new Student();** <br />
**Based on those just mentioned, which of the following assignments are legal, and why or why not?** <br />

**s1 = p1;** <br />
**s1 = p2;** <br />
**p1 = s1;** <br />
**t1 = s1;** <br />
**s1 = phd1;** <br />
**phd1 = s1;** <br />

The first two don't work since they are attempting to store a person object in a student variable and Person is not a subtype of Student. <br />
The third assignment is the other way around and is therefore valid, because Student is a subtype of Person. <br /> 
The fourth assignment attempts to store an object of type Student in a Teacher variable. This is invalid since Student is not a subtype of type Teacher. <br />
The fifth assignment is valid since it is declaring a variable of type Student and storing a subtype of it (PhDStudent). <br />
The last assignment however is the other way around and is therefore not legal. <br />

**Exercise 8.14
What has to change in the NewsFeed class when another Post subclass (for example, a class EventPost) is added? Why?**

Nothing would have to be changed since everything in the NewsFeed class is specified by the Post class, which includes all of its subclasses. 
