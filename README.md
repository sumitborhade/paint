# Paint Solution:

## Design and development approach
Before I started developing the code, I read the problem statement thoroughly and created a design on paper first.
Below are the highlights of it
<ol>
<li><b>Single Responsibility:</b>Code has been written in such a way that there is only one reason to modify the class and same has been specified in the comments mentioned in the classes</li>
<li><b>Open-Close Principle:</b>It is used to ensure that the application is close for modification but open for extension. e.g. Once line shape is created, it will not be touched if the new shape needs to be created. However new shape can extend Shape interface to create new shape</li>
<li><b>Design Patterns:</b>I have used Factory design pattern for creating factories for Shape Creators and Validators, as I wanted to avoid if-else conditions as well as to segregate the logic in as required for a particular class. I have modified Singleton design pattern (without changing the core objective of Singleton) while creating Canvas as only one canvas should be created. Added the comments in the code to elaborate more</li>
<li><b>Test Driven Development:</b> I have written the code by writing the test cases first</li>
<li><b></b></li>
</ol>
