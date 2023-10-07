If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)

**Task 2**

| Operation   | Unsorted Array   | Sorted Array   | Unsorted SLL   | Sorted SLL   | Hash table (Average) | Hash table (Worst)  |
| ----------- | ---------------- | -------------- | -------------- | ------------ | ----------------     | ------------------- |
| Find        |      O(n)        |     O(log(n))  |      O(n)      |     O(n)     |         O(1)         |          O(n)       |
| Insert      |      O(1)        |     O(n)       |      O(1)      |     O(n)     |         O(1)         |          O(n)       |
| Remove      |      O(n)        |     O(log(n))  |      O(n)      |     O(n)     |         O(1)         |          O(n)       |

Assuming that we find elements in the array based on its contents and not its index, the find operation will take O(n) time for an unsorted array, as we have to loop through the elements in the array until we find a match. In a sorted array however we could now use binary search, which has a time complexity of O(log(n)). Insert however, is faster in an unsorted array, assuming that the array should remain sorted after the insertion in to the sorted array. Inserting in an unsorted array however, is only O(1) if it is not full. Removing an element from an unsorted array takes linear time, since that's how long it takes to find the element to remove. Removing an element in the sorted array is logarithmic, once again because we can use binary search to locate the element before deleting it. 

For hash table operations the amortized average time complexity is O(1) for remove, insert and find. If, however the hash table has suffered many collisions, the worst case time complexity is O(n). 

For linked lists, insertion and deletion of elements at the start and end of the list is constant if the list is unsorted (this is true for appending and prepending); once again, assuming that the list should remain sorted after the operation is complete. If we want to remove a specific element however, it will take O(n) time to do this because in the worst case we have to iterate through the entire list to find it. If the list is sorted, appending and prepending can no longer be done for insertion since the correct order of the list will probably be wrong. 

**Task 3**

**1. What is the initial capacity of an `ArrayList`'s internal array?**

There is an array used internally to store the list, which is the arraylists internal array. Therefore, each arraylist instance has a capacity. The capacity is the size of this internal array used to store the elements in the list and is always atleast as large as the list size. The capacity of an empty arraylist is zero but is increased to the default initial capacity after one element is added. The default initial capacity is set to 10. 

**2. Starting with the `add(E e)` method (ln:442), find the line number for the conditional statement used to determine that the internal array needs to grow.**

At line 443 there is a method call to the method ensureCapacityInternal(size + 1); that then has a method call to ensureExplicitCapacity(). The ensureExplicitCapacity() method then in turn has a call to the grow method that increases the capacity if necessary. That if statement is located on line 219. 

**3. Looking at the `grow(int minCapacity)` method (ln:237), which operator is used to decide the new size of the internal array?**

The bitwise right-shift operator (>>) is used in the grow method to increase the capacity of the internal array by 50%. 

**4. What is the scaling factor for growth of the internal array?**

As mentioned in the previous question, the capacity of the internal array is increased by 50% by way of the >> operator. In other words, the scaling factor is 1.5. 

**5. If 20 elements had been added to an empty ArrayList, what would the size of the internal array be?**

It would start of at zero, like any empty arraylist. After adding the first element however, it would increase to the default initial capacity of 10. It would then allow 9 more elements to be added before that threshold is crossed, which would require another increase in size. Since the array grows in size by the scaling factor 1.5, it would increase from 10 to 15 after the 11th element is added and then from 15 to 22 after the 15th element is added. This would be the final size of the internal array after 20 elements had been added.

**6. What is the worst, average, and best-case time complexity of the `add(E e)`
   method of `Arraylist`?**
   
The best case time complexity of the add operation is when the internal array does not need to increase its capacity; which results in a constant O(1) time complexity. <br>
The worst case time complexity is when the array needs to increase its size to accomodate the new element to be added, this results in a O(n) time complexity. <br>
The average, or amortized time complexity of the operation is constant O(1). This is because the best case is far more common than the worst case. 
   
