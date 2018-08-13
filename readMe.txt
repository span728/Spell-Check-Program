// Stephanie Pan
// COMS3134 Blaer
// Problem Set 4
// readMe.txt
// Due Dec 1st, 2017 



Programming Problem 1
For this problem, the only file I wrote was Spellchecker.java. This program has a main method, which takes in a dictionary and a text file to be checked, makes a HashSet out of the dictionary, and then goes through the text file line by line and checks each word against the dictionary to see if it can be found.  If yes, it will print the word out.  If it cannot, then it provides suggestions using three methods: it tries adding a letter in each possible space, it tries deleting each of the letters, and it tries swapping each set of adjacent letters.  My program provides an array of options for each method of "fixing" the word.  A word that cannot be found in the dictionary will be followed by three arrays ([ ]).  If a method cannot return any results, then its array will be empty.  If all three methods cannot return any results, then you will see three empty arrays.  
To run this program, compile it, then type "java SpellChecker (name of dictionary file) (name of text file)" into the command line.  



Programming Problem 2
This problem asked me to use a PriorityQueue to keep track of the k best (or largest/highest) items in a sequence of elements (it doesn't really matter how long the sequence is).  I wrote a program called KBestCounter.java.  As instance variables, it has two generic PriorityQueues, one called heap and one called temp, and an integer k, which stores the number of items you want to keep track of (the k in k best seen earlier).  There are two methods.  The first one, count(), looks at each item in the sequence and decides if it belongs in the PriorityQueue.  The first k elements are added automatically, but once you get to the k+1 element, you need to compare it to the minimum value in the PriorityQueue, and if it is larger, then discard the current min and add the element you are looking at instead.  This method has O(logk) because in the worst case scenario, the method will perform one remove, which is O(logk), where k is the number of elements in the binary tree. The second method, kbest(), returns a List in sorted order (from largest to smallest) of the kbest items seen so far in the sequence.  It does this by removing each item, putting that item into a List, and putting that item into a temp PriorityQueue as well.  When the original heap is empty, you end up with a LinkedList of the elements, and a PriorityQueue that looks identical to the original.  You set heap to temp, and then set temp to a brand new PriorityQueue (this is space inefficient but there were no memory restrictions in the problem).  At the end of the method, you return the LinkedList. This method is O(klogk) because you perform k removes, each one O(logk).  
The tester was provided for us.  To run this program, compile both KBestCounter and TestKBest, then type "java TestKBest" into the command line.  
