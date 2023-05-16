# Quiz Application
A Quiz is made of N Questions. Every Question is related to a topic, and has a difficulty rank number.  
Every Question has a content and a list of Response. Every Response has a text and a boolean (correct).  
Questions can have more than 1 Response correct.  

Used IDE: IntelliJ IDEA Community Edition 2023.1.1.  

## Project setup  
Used PostgreSQL JDBC Driver library.  

## Structure and functionalities
model directory contains model classes.  
dao directory contains dao classes with add, get, updated and delete methods.  
database directory:  
Configuration class to create connection to database via java Connection interface.  
CreateTableQuery class to add tables to database.  
