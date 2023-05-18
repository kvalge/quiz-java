# Quiz Application  

A Quiz is made of Questions. Every Question is related to a topic, and has a difficulty rank number. Every Question
has a content and a list of Response. Every Response has a text and a boolean (correct).  

Used IDE: IntelliJ IDEA Community Edition 2023.1.1.  

## Project setup  

Imported PostgreSQL JDBC Driver library.  

## Structure and functionalities  
Database directory:  
Configuration class to create connection to database via java Connection interface.  
CreateTableQuery class to add tables to database.  
  
Model directory contains model classes.  
Dao directory contains dao Quiz class for a database interaction with add, get, updated and delete methods for Topic,
Question, Response and Quiz.  
Created methods to generate database views to display questions by topic with the right answer.   
Created a method to print questions and answers to the console.  

