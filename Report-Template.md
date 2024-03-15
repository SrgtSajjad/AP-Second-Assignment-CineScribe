# CineScribe

An application used for getting movies and actor information.

## Description

This application uses *api keys* for getting the latest information on a movie and an actor afterward.
It gets the name of a movie and shows the year released, the imdb rating and votes etc... including 
the list of the actors who played in it. Then you can choose one of the actors from list which you'd
like to know more about and the app will show you their information.

## Getting Started

### Dependencies

* IntelliJ for running the code
* Gradle as package manager
* com.googlecode.json-simple
* org.json
* com.fasterxml.jackson.core
* org.junit.jupiter:junit-jupiter-engine:5.8.1
* org.junit.jupiter:junit-jupiter-api:5.8.1
* org.junit.jupiter:junit-jupiter:5.8.1

### Installing

* The app can be downloaded from [*GitHub*](https://github.com/SrgtSajjad/AP-Second-Assignment-CineScribe.git)
* Download Gradle 8.6 from [*Gradle*](https://gradle.org/releases/)
* Download IntelliJ IDEA community version from [*JetBrains*](https://www.jetbrains.com/idea/download/)
* Download Java from [*Oracle*](https://www.oracle.com/java/technologies/downloads/)

### Executing program

* Run the program using IntelliJ
* Enter the name of a movie
* Enter the name of an actor from the list (case-sensitive)
* * * 
## Tasks Completed
* Movie Class:
  * Imdb Votes
  * Imdb Rating
  * Year Released
  * Actor List
  * Check Response (for handling errors)
* Actor Class:
  * Birthday
  * Net Worth
  * Age
  * Is Alive
  * Death Date
  * Occupations

## Challenges
* Movie Class
  * Listing the actors: accomplished by using regex and the split method
* Actor Class
  * Extracting data: accomplished by creating a JSONArray
* * * 
## Authors

Mohammad Sajjad Zanganeh
[@SrgtSajjad](https://github.com/SrgtSajjad)


## External Links
* [Movie Api](https://omdbapi.com/)
* [Actor Api](https://api-ninjas.com/api/celebrity)