# ENSE 470
My solutions to labs in ENSE 470 - Software Systems Design

## Overview
> **Lab 1** - UML  
> **Lab 2** - Factory Pattern  
> **Lab 3** - Decorator Design Pattern  
> **Lab 4** - Redesign and Refactoring - Phase 1  
> **Lab 5** - Redesign and Refactoring - Phase 2


## Compilation
### Eclipse IDE for Java Neon.1
To compile, go to
> File -> New -> Java Project

Name the project, set the `Location` of the project or keep the default, and navigate to the directory of the project in the system explorer.  

Move the folder of one of the labs from this repository and merge it with the `src/ `
directory where you created the project.  

The project files should now be visible in the IDE's `Package Editor`. If not, press `F5` with the `Package Editor` highlighted to refresh the directories.  

Press `Ctrl + F11` to build and run, or `F11` to build and debug.  

You may receive a window to choose how to run the application. Select `Java Application`.  

### IntelliJ IDEA 2016.2
To compile, go to  
> File -> New -> Project

Make sure that `Java` is selected in the list on the left side of the window.
Click `Next`, `Next`, name the project, and `Finish`.  

Move the folder of one of the labs from this repository and merge it with the `src\ `
directory where you created the project.  

Then, open the `Project` tab on the left, and expand the root folder.

Expand the file containing `main()`. In the editor window, click the green play button beside it. There, you can choose to either run or debug the program.

### NetBeans IDE 8.2
To compile, go to
> File -> New Project  

Click `Next`, name the project, choose a directory for the project, and click
`Finish`.

Right click on the default package that was created with the same name you
have given the project and `Delete` it.

Move the folder of one of the labs from this repository and merge it with the `src/ `
directory where you created the project. This will automatically update the
project files in the IDE. Press `F6` to run or `Ctrl + F5` to debug.

## Details
### Lab 1 - UML
Implementation of a simple product ordering system based on given UML class and sequence diagrams.  

### Lab 2 - Factory Pattern
Implementation of the factory pattern to create multiple concrete Tank classes with similar functionality.  

### Lab 3 - Decorator Pattern
Implemented a simulation of a vehicle customizer using the decorator pattern.

### Lab 4 - Redesign and Refactoring - Phase 1
Reverse engineered the source code of an existing Coffee Maker simulation program and redesigned it from scratch to be more dynamic and modifiable.

### Lab 5 - Redesign and Refactoring - Phase 2
Further modified the new design for the Coffee Maker simulation, added a design pattern into the design, and created supporting documentation.
