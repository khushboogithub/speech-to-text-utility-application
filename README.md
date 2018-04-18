# speech-to-text-utility-application
This project is a Speech To Text Coversion Utility Application having 3 modules.
 
 To set it up :
 1. Include the given jar files of CMU Sphinx4 STT Libraries in the project after opening it in any Java environment IDE such as Netbeans(7.1 and above) and derby jar files --> "derby","derbynet","derbyclient" : .
 2. Make sure you add the "1814.dic","1814.lm","3043.dic","3043.lm","stud_emp.dic","stud_emp.lm" files.
 3. You will find 3 modules : 
    3.1 VoiceLauncher.java
        - This will help in opening/closing of computer applications(in this project we have included only 2 of them(open/close of both))
        - Say "Open browser"/"Close Browser"/"Open file manager"/"Close file manager" after the module asks to "start speaking"

    3.2 Calculator.java
        - This module does basic mathematical calculations such as addition,subtraction,multiplication and division.
        - Say "add"/"plus" for addition , "minus"/"subtract" for subtraction , "multiply"/"into" for multiplication , "divide" for division.
        - Say "one"/"two"/"three"/"four"/"five"/"six"/"seven"/"eight"/"nine" for numbers 
        - To use any number such as "seven hundred thirty four" say "Seven Three Four" rather than saying "seven hundred thirty four"
        - Make sure to say a number first and then any operation else the program would behave inappropriately
        - To get the results of the computation , say "gives"/"equal"
        - To clear the values of the variables and start again , say "clear"

    3.3 DatabaseFinal.java
        - This will help to fetch values from the database , the project is designed using "derby" database so make sure you have/create a database names "project" (with username and password as "project") and create the following tables: 
             * Table 1 : student(name,class)
             * Table 2 : employee(name,department)
        - After creating the database:
             * for fetching all the details of the student table , say "all students" 
             * for fetching names of all the students , say "name students"
             * for fetching class of all the students , say "class students"
             * for fetching all the details of the employee table , say "all employee" 
             * for fetching names of all the employee , say "name employee"
             * for fetching department of all the employee , say "department employee"




