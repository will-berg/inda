If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)

**2.45: Implement a method empty, that simulates the effect of removing all money from the machine. This method should have a void return type, and its body should simply set the total field to zero. Does this method need to take any parameters? Test your method by creating a machine, inserting some money, printing some tickets, checking the total, and then emptying the machine. Is the empty method a mutator or an accessor?**

The method does not need to take any parameters. It is a mutator method since it changes the state of the object.

**2.58: Why does the following version of refundBalance not give the same results as the original?**
```java
public int refundBalance() {
    balance = 0;
    return balance;
}
```
**What tests can you run to demonstrate that it does not?**

Because it does not include the local variable `amountToRefund`. Without the local variable the balance is not returned and is simply just set to zero. This is because the balance is first set to zero and is later then of course returned as zero. This does not happen with the other code since there the `amountToRefund` variable goes around that problem. This is accomplished by using the local variable as temporary storage of the balance value. This can be tested by replacing the code with the local variable with the one without the local variable in the class source code.

**2.59: What happens if you try to compile the TicketMachine class with the following version of refundBalance?**
```java
public int refundBalance() {
    return balance;
    balance = 0;
}
```
**What do you know about return statements that helps to explain why this version does not compile?**

When trying to compile we get the error "unreachable statement". This does not compile because a method's return statement must always be the last to be executed.

**2.60: What is wrong with the following version of the constructor of TicketMachine?**
```java
public TicketMachine(int cost) {
    int price = cost;
    balance = 0;
    total = 0;
}
```
**Try out this version in the better-ticket-machine project. Does this version compile? Create an object and then inspect its fields. Do you notice something wrong about the value of the price field in the inspector with this version? Can you explain why this is?**

The version does compile but when inspecting the fields we can see that no matter what we set the price to when creating the object, the price field will always have the default value 0. This is because when adding int, price becomes a local variable and is therefore destroyed after the method is finished.


