08.11:

* populate a few person/company instances by CLI using Scanner
* print to stdout
* write to a file

* test WatchServiceRunner
* test FileVisitorWalkTreeRunner

07.11:

* emulate exception bubbling (on multiple layers)
    * on each throw, to add exception to suppressed and cause
    * on main method interception, traverse and print all causes up to initial cause   
    * print all suppressed as well
    
* add dateOfCreation to person/company
* deprecate dateOfBirth (rewrite, bridge to dateOfCreation and/or mark as deprecated)
* calculate dateOfBirth in a dynamic fashion when printing Ageables

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
    * populate person & company instances (generating number of dateOfBirth automatically)
    * assign them to type-safe collection(s)

<i>Bonus:</i>:
* implement helper class (utility class), that implements Comparator by (both domain classes) dateOfBirth
* sort the collection(s)
* print result to standard output