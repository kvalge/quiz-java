# Quiz Application  

A Quiz is made of Questions. Every Question is related to a topic, and has a difficulty rank number. Every Question
has a content and a list of Response. Every Response has a text and a boolean (correct).  

Used IDE: IntelliJ IDEA Community Edition 2023.1.1.  

## Project setup  

Imported PostgreSQL JDBC Driver library.  

## Structure and functionalities  

Model directory contains model classes.  
Dao directory contains dao quiz class with add, get, updated and delete methods for topic, question, response and quiz.
And views to display questions by topic with right answer.   
database directory:  
Configuration class to create connection to database via java Connection interface.  
CreateTableQuery class to add tables to database.  
