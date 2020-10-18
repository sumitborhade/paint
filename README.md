
# CS Paint Solution

## Design and Development Approach

<ol>
<li><b>Single Responsibility:</b> Code has been written in such a way that there is only one reason to modify the class and same has been specified in the comments mentioned in the classes</li>
<li><b>Open-Close Principle:</b> It is used to ensure that the application is close for modification but open for extension. e.g. Once line shape is created, it will not be touched if the new shape needs to be created. However new shape can extend Shape interface to create new shape</li>
<li><b>Design Patterns:</b> I have used  <u>Factory design pattern </u> for creating factories for Shape Creators and Validators, as I wanted to avoid if-else conditions as well as to segregate the logic in as required for a particular class. I have modified <u>Singleton design pattern</u> (without changing the core objective of Singleton) while creating Canvas as only one canvas should be created. Added the comments in the code to elaborate more</li>
<li><b>OO Principles:</b> I have used fundamental object oriented principles such as Encapsulation (e.g. in PointModel class), inheritance (e.g. ValidatorService and it's child classes) and Polymorphism (e.g. in ShapeCreationOrchestrator class)</li>
<li><b>Test Driven Development:</b> I have written the code by writing the test cases first. Primary intension was to test the logic thoroughly and while doing that 97.4% of lines of code was covered. 
Test case names have been written in BDD convention to make it easier to read and understand the rationale behind it</li>
</ol>

## Problem Assumptions
<ol>
<li>Only one canvas can be created. If another canvas was tried to be created then appropriate message should be displayed to the user</li>
<li>Only horizontal or vertical line can be drawn</li>
</ol>

## Tool/Technology used
<ol>
<li>Java 8</li>
<li>Maven 3.6.0</li>
<li>Eclipse 4.10.0</li>
</ol>

## Program Execution 
Unzip the code and put in a code directory "{Code_Dir}" 

### Program Execution via IDE:
1. Import the project in Eclipse or any other IDE 
2. Program's execution point is `com.cs.paint.MainClass.java`
3. Integration test location is `com.cs.paint.orchestrator.ProcessOrchestratorTest` (Inputs to this test case it currently same as that of inputs mentioned in the problem statement and can be modified for testing purpose)

### Program Execution via Command prompt using Maven
1. Go to the {Code_Dir} and execute `mvn clean install` to build the code, execute the test case and create a jar file
2. Execute `java -jar {Code_Dir}/target/paint-1.0.0-SNAPSHOT.jar`