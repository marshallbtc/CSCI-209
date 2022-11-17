# Assigment 6: Eclipse, Inheritance, Interfaces, Collections, and Javadocs Practice
## Author: Marshall Jones

# Choice of Map in CollectionDriver
In the CollectionDriver class, I chose to organize the catalog of media items in a map. Maps are better than sets and lists in this scenario because of their key:value structure. For each media item, the key is represented by the title, and the value is represented by the media item's characteristics.  
While the map may use more memory than a list does, memory is not a concern for such a small catalog of items.  
The added benefit of a map is its key. If we want to look through the media items quickly, we can just view the title as a string located in the key, rather than accessing each object's data every time we loop through the catalog.  
Finally, maps can be easily sorted by key value with one line of code by creating a new TreeMap object.