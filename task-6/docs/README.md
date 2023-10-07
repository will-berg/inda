If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)

**4.50. Suppose that the Auction class includes a method that makes it possible to remove a lot from the auction. Assuming that the remaining lots do not have their lotNumber fields changed when a lot is removed, write down what you think the impact would be on the getLot method.**
If the remaining lots don't change number when a lot is removed, there will be a problem. If you were to remove the first lot for instance (number 0), then the entire list would start at 1 instead of 0. The biggest problem is that you might remove the number before the number that you selected when running the getLot method. Since the method relies on there being a number before it (lotNumber - 1), this would cause problems.

**4.77. Which hour is returned by your busiestHour method if more than one hour has the biggest count?**
If more than one hour has the biggest count (they share the highest value), then the first value in the list will be returned since the busiesthour variable I have made only changes when hourCounts[hour] is bigger than hourCounts[busiesthour]. 
