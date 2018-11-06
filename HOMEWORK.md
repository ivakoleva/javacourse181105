06.11:

Data structures:
* one (concurrent) queue
* state of transfer (count of batches transferred)

Feature:
* generate a Map of 5 (constant) entries (batch):
    * Identification code (for key) and
    * Person or Company (for value) 

Threads:
* a thread adding to queue batches of persons, then sleeps for a second
* a thread adding to queue batches of companies, then sleeps for a second
* a thread getting 2 batches, then printing to standard output using lambda
* join to main thread

Data quantity:
* 50 companies and/or person

05.11:

Ceremonies:
* Entry point class (main method)

Implementation:
* Using lambda
    * populate person & company instances (generating number of age automatically)
    * assign them to type-safe collection(s)

<i>Bonus:</i>:
* implement helper class (utility class), that implements Comparator by (both domain classes) age
* sort the collection(s)
* print result to standard output