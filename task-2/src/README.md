Please put your code in this folder.

2.44: 
Constructor with price as the default value 1000: 
~~~
public TicketMachine()
    {
        price = 1000;
        balance = 0;
        total = 0;
    }
~~~
Constructor with single paramater that specifies the price:
~~~
public TicketMachine(int cost)
    {
        price = cost;
        balance = 0;
        total = 0;
    }
~~~
2.45: 
~~~
/**
     * Empty the machine. 
     */
    public void empty()
    {
        total = 0;
    }
~~~
2.61: 
~~~
/**
     * Empty the machine of money. 
     * Total is cleared. 
     */
    public int emptyMachine() 
    {
        int valueStoredInTotal;
        valueStoredInTotal = total; 
        total = 0; 
        return valueStoredInTotal;
    }
~~~
