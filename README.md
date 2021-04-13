# PhraseCounter
Java app that counts occurrences of phrases in a file.
Can filter output to phrases that occur at least a certain number of times or are at max a certain length.
Has basic Maven usage, including continuous integration with Github Actions.

v0.5.0 is a Spring Boot Rest API that takes a single file path as an argument. Prints out phrase count.
Currently deployed to Heroku at https://phrase-counter.herokuapp.com/. 

React frontend is deployed at: https://jasche7.github.io/PhraseCounter-React/.
Its repo can be found at: https://github.com/jasche7/PhraseCounter-React


## Project Screenshot(s)
Sample output:

<img width="332" alt="Screen Shot 2021-03-11 at 11 41 31 PM" src="https://user-images.githubusercontent.com/25709225/110908406-9da4f800-82c3-11eb-96de-a81088ff1cc3.png">


## Usage
POST requests can be made to https://phrase-counter.herokuapp.com/phrase.

Use the latest CLI jar file provided in releases or run `mvn package` in the source code root folder to create an executable jar file.

`java -jar <jar-file-name> <filepath> [# of minimum occurrences] [# of maximum phrase length]`


## Reflection
This project was imagined as a tool for me to check text that I type for excessive repetition of certain phrases.

I prioritized learning good development practices, such as unit testing, clean code, and documentation. There is also the 
goal of familiarizing with essential software development tools such as build tools and continuous integration frameworks.
