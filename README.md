# Concurrency in Java: Overview
### Aim:
This repository is intend to outline the key concepts of concurrency in Java and provide reference materials that may act as a refresher on the topic of concurrency/threads in Java.
### Introduction
Concurrency in programming is the ability of a computer to execute 2 or more tasks at the same time. More accurately, the tasks are executed one at a time but done in such a way as to give the appearance of being executed in parallel (at the same time).

For example, consider an application designed to do the following:
- Download data
- Draw a shape on the monitor using the data

Without concurrency, this application would first download all the data then draw the shape once all the required data finished downloading.

A concurrent implementation of this application however could download some data, draw a pixel on the screen, download some more data then draw another pixel etc and by repeating this process it appears to the user that the program is executing both tasks at the same time.

Concurrency allows:
- Multiple apps to run at the same time on a smartphone
- Website servers to process the requests of simultaneous users
- Multiple applications to run at the same time on a computer
- GUI based programs to perform background tasks that do not interrupt user experience
