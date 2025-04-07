# Java
A collection of Java algorithm implementations.

### Geometry Figures Calculator

This project implements a basic shape calculator in Java that supports 2D and 3D figures using object-oriented principles such as abstraction and interfaces.  
It includes an abstract base class for geometric figures (`Figure`), an interface for printable objects (`Printable`), and several implementations such as `Circle`, `Square`, `Triangle`, and `Prism`.  
The program calculates areas, perimeters, surface areas, and volumes, and allows for user interaction through a simple console menu.

Key Concepts Used:
- Interface (`Printable`)
- Abstract class (`Figure`)
- Inheritance and polymorphism
- Exception handling for invalid inputs
- Separation of logic and UI components (clean architecture)


## Car Showroom Simulator

This project is a simple car showroom simulation implemented in Java using collections and object-oriented principles.  
It includes classes for managing multiple showrooms, adding/removing/searching vehicles, and calculating inventory statistics.  

Key Features:
- Managing multiple car showrooms via a container class
- Tracking vehicles with conditions (NEW, USED, DAMAGED)
- Searching, sorting, and summarizing vehicle data
- Demonstration of Comparable and Comparator usage

## Java Algorithms & Custom Exceptions:

This project showcases several algorithmic solutions and utility tools written in Java.  
It demonstrates clean code structure, the use of design patterns, custom exceptions, and tailored data structures.

Key Features:
- Multiple sorting algorithms implemented using the Strategy design pattern, including performance benchmarking
- Zigzag string conversion by row
- Efficient median-finding method for sorted arrays
- Unique triplet finder for arrays summing to zero
- Counter-clockwise spiral traversal of matrices
- Custom exception types for validating algorithm inputs
- Usage of custom collections and overriding base Java class behaviors

  ## Java Unit Testing with JUnit5 and Maven

This project contains a comprehensive set of unit tests written using the JUnit5 framework.  
It covers algorithmic logic, exception handling, and performance evaluation across multiple Java modules.  
The test suites are organized to ensure maintainability, meaningful coverage, and clarity of test intent.

Key Highlights:
- Full use of JUnit5 features including assertions, test suites, and lifecycle annotations
- Performance tests and validation of exception-throwing behavior
- Organized structure with meaningful test case names and scenarios
- Code coverage optimization with IDE tools (e.g., IntelliJ IDEA)
- Maven-based build system with dependency management and test execution

## Java Swing GUI 
This project implements a desktop application using Java Swing for managing car showrooms and vehicles.  
It combines a custom business logic layer with an interactive graphical interface, allowing users to manage showrooms, add/remove/search vehicles, and sort or filter data dynamically.

Key Features:
- Object-oriented model with classes like Vehicle, CarShowroom, and CarShowroomContainer
- Full GUI built with Swing components such as JTable, JButton, JComboBox, and JOptionPane
- Dynamic views with support for filtering, sorting, and real-time updates
- Custom `AbstractTableModel` implementation for generic data binding
- Clean architecture with clear separation between UI and logic layers
- Exception handling with user feedback via dialog panels
- Optional features like text filtering and state-based filtering with dropdowns
