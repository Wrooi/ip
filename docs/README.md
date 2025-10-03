Rudeus User Guide
=================

Welcome to Rudeus, your magical command-line task manager inspired by Rudeus Greyrat from Jobless Reincarnation!

───────────────────────────────────────────────────────────��────────────────

Quick Start
-----------
1. Download and run the JAR file:
   java -jar rudeus.jar
2. Type your commands in the terminal and let Rudeus handle your tasks!

────────────────────────────────────────────────────────────────────────────

Features
--------

Add a Todo
----------
Adds a simple todo task.

Usage:
todo <description>

Example:
todo Finish CS assignment

Expected Output:
────────────────────────────────────────────────────────────────────────────
added: [T][ ] Finish CS assignment
────────────────────────────────────────────────────────────────────────────

Add a Deadline
--------------
Adds a task with a deadline.

Usage:
deadline <description> /by <due date>

Example:
deadline Submit report /by Friday

Expected Output:
────────────────────────────────────────────────────────────────────────────
added: [D][ ] Submit report (by: Friday)
────────────────────────────────────────────────────────────────────────────

Add an Event
------------
Adds an event with a start and end time.

Usage:
event <description> /from <start> /to <end>

Example:
event Project meeting /from Monday 2pm /to Monday 4pm

Expected Output:
────────────────────────────────────────────────────────────────────────────
added: [E][ ] Project meeting (from: Monday 2pm to: Monday 4pm)
────────────────────────────────────────────────────────────────────────────

List Tasks
----------
Shows all tasks in your list.

Usage:
list

Expected Output:
────────────────────────────────────────────────────────────────────────────
Here are the tasks in your list:
1. [T][ ] Finish CS assignment
2. [D][ ] Submit report (by: Friday)
3. [E][ ] Project meeting (from: Monday 2pm to: Monday 4pm)
────────────────────────────────────────────────────────────────────────────

Mark/Unmark Tasks
-----------------
Marks a task as done or not done.

Usage:
mark <task number>
unmark <task number>

Example:
mark 2

Expected Output:
────────────────────────────────────────────────────────────────────────────
Nice! I've marked this task as done:
[D][X] Submit report (by: Friday)
────────────────────────────────────────────────────────────────────────────

Delete Tasks
------------
Deletes a task from your list.

Usage:
delete <task number>

Example:
delete 1

Expected Output:
────────────────────────────────────────────────────────────────────────────
Alright, I've erased this task from existence:
[T][ ] Finish CS assignment
Now you have 2 task(s) left in the list.
────────────────────────────────────────────────────────────────────────────

Find Tasks
----------
Finds tasks containing a keyword.

Usage:
find <keyword>

Example:
find report

Expected Output:
────────────────────────────────────────────────────────────────────────────
Here are the matching tasks in your list:
1. [D][X] Submit report (by: Friday)
────────────────────────────────────────────────────────────────────────────

────────────────────────────────────────────────────────────────────────────

Save and Load
-------------
Tasks are automatically saved to disk and loaded when you start Rudeus.
No manual action is needed!

How Saving and Loading Works:
-----------------------------
- All tasks are saved to the file `data/tasks.txt` in your project directory.
- When you start Rudeus, it automatically loads tasks from this file.
- When you add, mark/unmark, or delete a task, the file is updated automatically.

────────────────────────────────────────────────────────────────────────────

Exit
----
Ends the program.

Usage:
bye

Expected Output:
────────────────────────────────────────────────────────────────────────────
See you around! Don’t get into too much trouble without me!
���───────────────────────────────────────────────────────────────────────────

────────────────────────────────────────────────────────────────────────────

Error Handling
--------------
Rudeus will let you know if you enter an invalid command or forget required details, always with a bit of personality!

────────────────────────────────────────────────────────────────────────────

FAQ
---
Q: Where are my tasks saved?
A: In the data/tasks.txt file in your project directory.

Q: What happens if I enter an invalid command?
A: Rudeus will respond with a friendly error message.

────────────────────────────────────────────────────────────────────────────

Contact
-------
For bugs or suggestions, open an issue on GitHub!

────────────────────────────────────────────────────────────────────────────

Sample Session
--------------
Yo! The name's Rudeus.
At your service, as always. Need some magic—or maybe just a hand? Ask away!

todo Read magic book
deadline Submit assignment /by Monday
event Adventure /from Tuesday /to Wednesday
list
mark 2
find magic
delete 1
bye

────────────────────────────────────────────────────────────────────────────
