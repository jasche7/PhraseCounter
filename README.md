# PhraseCounter (REST API)
Java app that counts occurrences of phrases in a file.
Can filter output to phrases that occur at least a certain number of times or are at max a certain length.
Has basic Maven usage, including continuous integration with Github Actions.

v0.5.0 is a Spring Boot Rest API that takes a single file path as an argument. Prints out phrase count.
Currently deployed to Heroku at https://phrase-counter.herokuapp.com/. 

React frontend is deployed at: https://jasche7.github.io/PhraseCounter-React/.
Its repo can be found at: https://github.com/jasche7/PhraseCounter-React


## Project Screenshot(s)
Sample output:

<img width="565" alt="Screen Shot 2021-04-12 at 5 03 13 PM" src="https://user-images.githubusercontent.com/25709225/114477446-062c1100-9bb1-11eb-80cc-907d4af6db92.png">


## Usage
POST requests can be made to https://phrase-counter.herokuapp.com/phrase.


## Reflection
This project was imagined as a tool for me to check text that I type for excessive repetition of certain phrases.

I prioritized learning good development practices, such as unit testing, clean code, and documentation. There is also the 
goal of familiarizing with essential software development tools such as build tools and continuous integration frameworks.
