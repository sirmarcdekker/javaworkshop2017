# java workshop 2017
Java 8 workshop

The purpose of this workshop is to help developers who have a basic understanding of java to learn java 8 concepts in a
hands on process.

We hope to help both beginners and more experienced java 8 developers with something new to learn. This is why we have
divided each feature in multiple levels. These levels are Basic, Advanced and Challenges.
The Basic level addresses the most basic topics of a feature such as construction and simple manipulation. We also try
to make sure that we keep the topic isolated if at all possible so that each topic can be picked up without the need
to have done the other modules. If this is not the case this will be noted in the comments at the start of the class as
explained below.
The Advanced level goes more in depth into possibilities of features especially when they touch upon/use the other
 Java 8 features such as lambda's. We will note in the comments at the start of the file what other features are
 touched upon in the class and we advice that if you have no experience with these subjects that you do the basic lesson
 of those features so you have no problem during with the exercises.
The Challenges level are the most complex and are intended to let you try your hand at more complex problems which
uses the knowledge gained from earlier exercises and might also more heavily require knowledge of other features.

During this workshop we will be discussing various topics that have been added or significantly changed with the
introduction of java 8. The features are Optionals, Streams, Java Time, Lambda's, concurrency and the New IO API. While
the repo is set up so you can do study the features in any order you want we want to advice people completely new to
Java 8 to go through the following features in the noted order: Optional -> Lambda -> Stream. this is because the
Stream basics topic actually will be using concepts of the other two features.

The excersizes are set up in a uniform way. Each file is named after the feature it covers and the level it is for. In
the comments at the start of the file we will explain which topics will be covered in the file and which other java 8
 features will be covered during in the class. Each excersize class will contain one or more excersizes in the form of
 methods. Above the method will be a piece of java doc explaining what needs to be done for the excersize and which test
 file will check the results of the test. These test files contain one or more JUnit tests that will check if the
 function has been implemented correctly. We are aware that a lot of excerzises can be done without using Java 8
 features but doing that would offcourse defeat the point of the excerzise.
 
 The various features of Java 8 have been designed to solve diffrent problems. Below we will explain in general terms 
 what problem each feature tries to solve.
 
 Optionals
 ... the creator of the null reference has said it is his billion dollar mistakes. A lot of times a runtime problem is caused by an unexpected null reference. Optionals aim to solve stray null reference. They allow you to wrap an reference in an entity which has either a valid reference or an empty instance which we need to explicitly check.
 
Streams
A lot of work in applications is doing operations on collections of date. This involves manimulation of both the data in the collection and the collection itself. The Streams API introduced in Java 8 by allowing easy changes of the data using methods like map and flatmap and manipulating the collection with methods like filter and collect.

Concurrency
CPU developement has moved away from making single more powerfull processors and has been moving towards multi core systems. The new concurrency features of Java 8 are there to make better use of the system resources and improve the performance of your application.

Lambda
Very often a piece of code will be needed multiple times with only one operation being different from the other uses. This was normally solved by making an inner class with one method that was overwritten for the different uses.

Java Time
Many applications touch the subject of time. Before Java 8 time management in java out of the box was cumbersome and non intuitive. This means that a lot of projects use an third party package for time operation with the most populair being JodaTime. To improve on this the creator of JodaTime has written the java.time API to handle time in java

NIO
Just like time dealing with IO used to be cumbersome and awkward before java 8. Navigating file structures and such was difficult and a lot of basic checks had to be done by hand. With the new NIO API the handeling of the file system is done much easier by identifying a data source and using the paths in the source as objects easaly interchangeable to the real files 