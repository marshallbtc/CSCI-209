# Assignment 3
@author Marshall Jones
Practicing writing static methods.

## Design Analysis

*Why is it appropriate for these methods to be static?*
It is appropriate for reverseString and isPalindrome to be static because they do not require an object of their class to be created in order to use them. The only data needed by these methods is passed directly into the method arguments; there is no need for non-static fields in the class.