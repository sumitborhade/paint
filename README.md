# Paint Solution

## Design and development approach

<ol>
<li><b>Single Responsibility:</b> Code has been written in such a way that there is only one reason to modify the class and same has been specified in the comments mentioned in the classes</li>
<li><b>Open-Close Principle:</b> It is used to ensure that the application is close for modification but open for extension. e.g. Once line shape is created, it will not be touched if the new shape needs to be created. However new shape can extend Shape interface to create new shape</li>
<li><b>Design Patterns:</b> I have used  <u>Factory design pattern </u> for creating factories for Shape Creators and Validators, as I wanted to avoid if-else conditions as well as to segregate the logic in as required for a particular class. I have modified <u>Singleton design pattern</u> (without changing the core objective of Singleton) while creating Canvas as only one canvas should be created. Added the comments in the code to elaborate more</li>
<li><b>OO Principles:</b> I have used fundamental object oriented principles such as Encapsulation (e.g. in PointModel class), inheritance (e.g. ValidatorService and it's child classes) and Polymorphism (e.g. in ShapeCreationOrchestrator class)</li>
<li><b>Test Driven Development:</b> I have written the code by writing the test cases first. Intension was to test the logic thoroughly and while doing that 97.4% of code was covered</li>
</ol>

## Problem Assumptions
<ol>
<li>Only one canvas can be created. If another canvas was tried to be created then appropriate message should be displayed to the user</li>
<li>Only horizontal or vertical line can be drawn</li>
</ol>

## Technology stack
<ol>
<li>Java 8</li>
<li>Maven 3.6.0</li>
</ol>

## Program Execution
<ol>
<li>Program's execution point is `com.cs.paint.MainClass.java`</li>
<li>Integration test location is `com.cs.paint.orchestrator.ProcessOrchestratorTest`</li>
</ol>
