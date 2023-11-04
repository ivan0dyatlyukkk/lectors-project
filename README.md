<h1 align="center">
    The Lectors&Departments console application 
</h1>

## Overview 
The simple Spring Boot console application with 
the console interface for university, which consists of departments and lectors.

## Main commands
In this section, we will discuss all features of the console application

| Name                                       |                           Command                            |                                                      Answer                                                       |
|--------------------------------------------|:------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------------------------:|
| Get a head of department                   |         Who is head of department {department_name}          |                         Head of {department_name} department is {head_of_department_name}                         |
| Show statistics of the department          |              Show {department_name} statistics               | assistans - {assistams_count} associate professors - {associate_professors_count} professors - {professors_count} |
| Show the average salary for the department | Show the average salary for the department {department_name} |                            The average salary of {department_name} is {average_salary}                            |
| Show count of employee for the department  |         Show count of employee for {department_name}         |                                                 {employee_count}                                                  |
| Global search by name                      |                 Global search by {template}                  |                                           {lector_name}, {lector_name}                                            |
