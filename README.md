# PhraseCounter
Java app that counts occurrences of words in a file and calculates occurrences of words.

## Project Status
Current milestone:
Command line tool that takes a single file path as an argument. Prints out phrase count.
Has basic Maven usage, including continuous integration with Github Actions.

Next milestone:
Desperately needs configuration options to limit output. Unfiltered output is excessive.

Endgoal:
With improved UI, counts phrases (consecutive words) instead of words and has customizable options for computing output.
Possibly create new branch to turn into single page webapp.

## Project Screenshot(s)
Sample output:

<img width="332" alt="Screen Shot 2021-03-11 at 11 41 31 PM" src="https://user-images.githubusercontent.com/25709225/110908406-9da4f800-82c3-11eb-96de-a81088ff1cc3.png">


## Usage
Run "mvn package" to create an executable jar file, or otherwise create the jar file independently.

`java -jar <jar-file-name> <filepath>`


## Reflection
This project was imagined as a tool for me to check text that I type for excessive repetition of certain phrases. 
By the end, I should be able to quickly and conveniently get results, without needing to perform any significant amount of 
setup beforehand.

I prioritized learning good development practices, such as unit testing, clean code, and documentation. There is also the 
goal of familiarizing with essential software development tools such as build tools and some continuous integration framework.
