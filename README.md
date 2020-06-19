# Project: Flashcards

## Source
 ***More details about the [project](https://hyperskill.org/projects/44) on [JetBrains Academy](https://hyperskill.org)***

## Description
This is a simple program that is created only for the purpose of learning and gaining practical skills using the Java programming language. Just play around with it

You can pass the argument -import, to read an initial cards set from an external file
 ```
 java Flashcards -import <name-of-file>.txt
 ```
 Also you can pass the -export argument followed by the file name, to write all the cards that are in the program memory into file
 ```
 java Flashcards -export <name-of-file>.txt
 ```
 And of course you may combine them
 ```
 java Flashcards -import <name-of-file>.txt -export <name-of-file>.txt
 ```
  Actions:
 - add: add a card
 - remove: remove a card
 - import: load cards from file
 - export: save cards to file
 - ask: ask for a definition of some random cards
 - exit: exit the program
 - log: saves the application log to the given file
 - hardest card: prints the term of the card that has the most mistakes
 - reset stats: erases the mistake counts for all cards

## Usage
Run programm with arguments
```
>java Flashcards -import Flashcards/task/capitals.txt
```
```
5 cards have been loaded.
Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
>add
The card:
>Japan
The definition of the card:
>Tokyo
The pair ("Japan":"Tokyo") has been added.

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
>ask
How many times
>1
Print the definition of "United Kingdom":
>London
Correct answer

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
>remove
The card:
>Japan
The card has been removed.

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
>exit
Bye bye!
```
