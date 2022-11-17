# Assignment 7: Testing
## **Marshall's Analysis**

**Describe your process. What made the process easy? What made the process difficult?**  
We split our project into 3 classes: SetterTests, GetterTests, and CarTest, which is a tester class for the constructor, toString(), and compareTo(). We agreed on which methods we would take responsibility for, and we checked over each other's test methods.

**How difficult was it to write test cases for this class? What made the process difficult? easy?**  
The difficult parts were getting started, and just the fact that I have no experience with testing.  Having the stub methods and documentation on the car class made testing a lot easier because it gave us a good idea of how each method should behave.

**Would it be more or less difficult for you to write test cases for a class that you had already written? Why? Try to think of at least one advantage and one disadvantage to testing your own classes.**  
I think writing test cases for code that I haven't seen or written yet is much easier; by default, following this process gives the test writer an objective view of how the code should behave.  
Writing code for test cases that I've already written creates a dilemma that many literature writers experience. For example, when I edit a paper that I've spent a lot of time on, I fail to see that certain parts need to be deleted or changed. Similarly, coders can unintentionally test and publish code that has certain faults they were completely unaware of. This can be avoided by writing the test cases first, and/or asking an unbiased peer to review the code and test cases.

**What could you do when writing your own classes to make testing easier? How could you make testing your classes easier for someone else?**  
It is important to write code on a basic level so that unit testing is straight forward. Thus, I would write my classes with more methods that contain less code, rather than less methods that contain more code. In other words, the coder should be following good object-oriented practices. Each method should have a very specific, granular purpose.  
When writing classes that will be tested by others, I would follow the practice mentioned above, and I would also be sure to document class and method behavior as much as possible. Of course, this practice should also be followed at all times.

**What do you think of the JUnit framework? How easy/difficult was it to write test cases using JUnit? How would the testing process go without JUnit? Did JUnit limit you in any way?**  
I really like the JUnit framework. The assert_() methods in particular make a big difference in the ease of writing test cases.  Without JUnit, we would have had to come up with custom methods to handle each test case. JUnit did not limit me in any way, but I could see how test cases for a more complex class would require specially-written unit test cases.

**This is your first collaborative project in CSCI209. How did the collaboration go? What would you do to improve collaboration in future projects?**  
Frankly, the collaboration was a bit difficult. My group agreed to communicate over GroupMe, and I don't think I would do that again. I prefer messages (iPhone texting), although Discord would be an even more effective option. It was also difficult to find times for everyone to meet. I knew I had a lot of work and meetings on Monday and Tuesday, so I wanted to get started early on Thursday or Friday. Unfortunately, we did not end up meeting until Sunday night over Zoom. We spoke briefly about a general game plan, then met in person on Monday. Our in person meeting was very productive. I would say that the more collaborative code sessions, the better. Successful collaboration is really a matter of making the effort to communicate clearly and often.

**How would more or fewer people change your process?**  
More than three people would have been quite difficult had we organized our process the same way. When a group has four or more people, there should definitely be a leader, or a project manager who does less coding and more oversight. This responsibility would entail delegating project responsibilities, reviewing/editing/questioning pushed code, and filling in the gaps where new code is needed.  
A group of two people would have made the process easier in terms of communication. However, each person would be responsible for more code, and errors may be caught less quickly and frequently.

**Approximately how much time did you spend on the project--in your team and on your own? (Does not affect your grade in any way.)**  
Aside from this analysis, I spent roughly 4.5 hours on this project. Half of that was reading the documentation, stub methods, and notes from class.