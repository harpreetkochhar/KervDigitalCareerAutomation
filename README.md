# KervDigitalCareerAutomation
Kerv Digital Career Automation Framework
Kerv Digital Automation

This framework is created using Cucumber TestNG.

Under Config folder---->Configuration.properties file has the browser, chrome path, URL & wait. we can change these parameters.

This framework is dynamic and can take any JoRole and Candidate Details.

Steps to make changes to Job Role Or Candidate Details:

Goto SRC-->test--->resources--->Features---Kfeature.feature file
Change the Job Role, County or Candidate Details.
Steps to Execute the framework:

Goto command Prompt--->create directory where program file is kept
Run command mvn test
Or

Select KERVJOB project--->right click--->Run as---->Maven Test
Report:

HTMLReport is under test-output---->extent---->ExtentHtml.html
Spart---Index.html
Logs: Logs are under---target--->logs-->app.log
