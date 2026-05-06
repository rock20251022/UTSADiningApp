# UTSA Dining Application

---

## Project Overview

**UTSA Dining** is a desktop application created with **JavaFX** for students who want an easier way to view campus dining information in one place.

The application uses a graphical interface with multiple screens that allow users to log in, move through a dashboard, view restaurants, check meal plans, browse dining events, learn about mobile ordering, and read information about UTSA Dining.

This project follows the **Model–View–Controller (MVC)** structure:

- **Model classes** store information such as restaurants, events, meal plans, mobile ordering steps, and about page sections.
- **View files** are created with FXML and define what each screen looks like.
- **Controller classes** handle button clicks, screen changes, loading data, and updating labels/images on the screen.

The goal of the project is to make campus dining information easier to access through a simple desktop app.

---

## Application Features

The UTSA Dining application includes the following features:

- User login screen
- Dashboard navigation screen
- Restaurant list page
- Restaurant details page
- Meal plans page
- Meal plan details page
- Meal plan sign-up page
- Dining events page
- Event details page
- Mobile ordering information page
- About Us page
- About detail pages for dining information
- Local CSV file loading
- Local image loading
- JavaFX styling with CSS

---

## What the Application Does

After opening the application, the user begins on the login screen. The login screen checks the username and password using a local `users.csv` file.

Once the user logs in successfully, the app opens the dashboard. The dashboard is the main navigation page of the application.

From the dashboard, users can go to:

- **Restaurants**
    - View campus dining locations
    - Open a restaurant detail page
    - See restaurant name, location, description, hours, and image

- **Meal Plans**
    - View available meal plan options
    - Open a detailed page for each plan
    - See pricing, plan description, included benefits, and who the plan is best for
    - Submit a meal plan sign-up request

- **Events**
    - View campus dining events
    - Open event detail pages
    - See event title, date, time, location, description, and image

- **Mobile Ordering**
    - View instructions for using GrubHub with UTSA Dining
    - Learn how to connect campus dining with a student account

- **About Us**
    - Learn about UTSA Dining quality, balanced choices, and the dining experience
    - Open detail pages for each about section


---

## Contributors


- Andrew Teran
- Ian Villarreal
- Aria McNulty
- Matthew Knudsen

---

## Software and File Requirements

Before running the application, make sure you have the following:

- JDK 24 
- JavaFX SDK 25 installed
- OpenCSV library added to the project
- An IDE that supports Java and JavaFX
    - IntelliJ IDEA
    - Eclipse
    - Visual Studio Code with Java extensions

Internet access is not required because the application runs using local project files.

---



## How to Run the Application



### 1. Clone the Repository

Open a terminal and clone the project repository:

```bash
git clone https://github.com/UTSA-CS-3443/Spring2026-CS3443-006-UTSADining.git
```





### 2. Open the Project in an IDE

Open the project using your preferred Java IDE.

Recommended options:

- IntelliJ IDEA
- Eclipse
- Visual Studio Code

For IntelliJ IDEA:

1. Open IntelliJ IDEA
2. Click **File**
3. Click **Open**
4. Select the project folder



### 3. Configure JavaFX

If JavaFX is not already configured, add the JavaFX SDK to the project.

In IntelliJ IDEA:

1. Go to **Run**
2. Click **Edit Configurations**
3. Select the application run configuration
4. Add the JavaFX VM options

Example VM options:

```bash
--module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml
```

Replace `/path/to/javafx-sdk/lib` with the actual location of your JavaFX SDK `lib` folder.

Example for macOS:

```bash
--module-path /Users/yourname/Downloads/javafx-sdk-25/lib --add-modules javafx.controls,javafx.fxml
```

Example for Windows:

```bash
--module-path C:\Users\yourname\Downloads\javafx-sdk-25\lib --add-modules javafx.controls,javafx.fxml
```



### 4. Add the OpenCSV Library

The restaurant page uses OpenCSV to read restaurant data from a CSV file.

If OpenCSV is not already added to the project, add the OpenCSV `.jar` file to your project libraries.

In IntelliJ IDEA:

1. Go to **File**
2. Click **Project Structure**
3. Click **Libraries**
4. Click the `+` button
5. Add the OpenCSV `.jar` file
6. Click **Apply**
7. Click **OK**





### 5. Run the Program

```text
Launcher.java
```

The `Launcher` class starts the JavaFX application.

The login screen will appear. Input login credentials to access the dashboard

**Username:** abc123

**Password:** password123
