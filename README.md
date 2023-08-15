# AutoTrace

AutoTrace is an all-in-one Android application designed to keep drivers informed and responsible. By logging in to their accounts, users can effortlessly access a wealth of information, including their up-to-date traffic violations, ensuring they never miss a ticket payment. Additionally, the app provides real-time insurance information such as provider details and premium status. AutoTrace also offers insights into basic vehicle information like car model, registration year and insurance provider by just inputting a license plate number without logging in. Its unique feature of registering vehicles from the centralized database of cars with associated driver's name and license plates further enhances the personalized user experience, making AutoTrace an essential tool for every driver.

## Motivation

We aimed to create an app that works as a centralized system for displaying issued traffic tickets. The app displays information about each car, such as insurance provider. Another app feature is verifying ownership details by looking up any vehicle registered by the license plate in the database. Users can create an account to register their cars and view filed traffic tickets.

## Features

- Access Basic Car Information: Users can input a license plate number and retrieve the corresponding car model and registration date.
- Vehicle Registration: Users register vehicles under their account by providing information (Vehicles/License Plates have to already exist in the database).
- User Log In: Returning Users are able to Log in to their previously created accounts to view their User-specific Information.
- User Registration: Users can create new accounts by providing their emails and creating a password
- Vehicle Information: Users can view detailed information about registered vehicles, such as Models and Insurance Details.
- Traffic Violations: Users can check for any traffic violation tickets associated with a particular vehicle, displaying relevant details such as amount payable, issue date, intersection, and violation description.
- Navigation Bar: Provides an accessible way for Users to navigate between different screens

## Scenario Walkthroughs

### Access Basic Information
1. User opens the AutoTrace Android app
2. User enters the license plate number into the input field under the Log-In section and taps on the "Continue" button.
3. The app processes the input and queries the relevant databases based.
4. The app retrieves the car model and registration date associated with the provided license plate number.
5. Finally, the app displays the car model and registration date on the user interface, allowing the user to view a limited amount of information.
   <img width="190" alt="Screenshot 2023-08-05 at 10 48 58 PM" src="https://github.com/CSC207-2023Y-UofT/course-project-autotrace/assets/95944688/20fe6d5a-fed3-42fd-b5f7-38d101f6d954">


### Vehicle Registration
1. User logs into the AutoTrace app using their email and password.
2. User taps the plus button on the Dashboard/Home Screen, which redirects to the vehicle registration screen.
3. User inputs the license plate number, Last Name, and Date of Birth into the provided fields.
4. After filling in the required information, the administrator taps on the "Register" button to submit the details.
5. Information is then verified based on if the vehicle exists in the database.
6. If the information is valid, the vehicle is registered under the User's Account and is now viewable from the dashboard.
   <img width="190" alt="Screenshot 2023-08-05 at 4 22 31 PM" src="https://github.com/CSC207-2023Y-UofT/course-project-autotrace/assets/95944688/a9c25fbe-26f6-4a14-8d4a-4cf57426159d">


### Viewing RegistedVehicle Information
1. User logs in with their email and password.
2. They are directed to the home screen, where they can view different previously registered vehicles.
3. The user selects a specific vehicle and can access the car information screen, which includes insurance Provider, Car Model/Year, and Owner.
   <img width="190" alt="Screenshot 2023-08-05 at 4 13 18 PM" src="https://github.com/CSC207-2023Y-UofT/course-project-autotrace/assets/95944688/d80941e1-3613-4943-a484-5a6cc553f3d7">

### Checking Traffic Violations
1. User logs in with their email and password.
2. They are directed to the home screen.
3. The user presses the traffic violation icon in the navigation bar.
4. They are taken to the traffic violations page, displaying various tickets with details such as the amount payable, date the ticket was issued, the intersection where the violation occurred, and a description of the violation (e.g., parking ticket, traffic light violation).
   <img width="190" alt="Screenshot 2023-08-05 at 10 48 04 PM" src="https://github.com/CSC207-2023Y-UofT/course-project-autotrace/assets/95944688/d3c2a9dc-3f5f-4cb9-8c46-85fb34082a9b">


### User Log In
1. User launches the application
2. User prompted with the splash screen
3. User inputs their email and password
4. Directed to Home Screen
   <img width="190" alt="Screenshot 2023-08-05 at 4 12 54 PM" src="https://github.com/CSC207-2023Y-UofT/course-project-autotrace/assets/95944688/bea6fe9c-0e71-47ef-b785-4aebe3fe6c2c">


### User Registration
1. User presses the sign-up button upon launching the app
2. User inputs their email, password, and password confirmation.
3. The user views a verification success pop-up confirming their successful registration.
   <img width="190" alt="Screenshot 2023-08-05 at 4 14 56 PM" src="https://github.com/CSC207-2023Y-UofT/course-project-autotrace/assets/95944688/509f823d-bb2a-424d-a5f4-6b6c3f25a78c">


### Reset Password
1. User presses the Forgot Password button upon launching the app
2. User inputs their email.
3. An email is sent to the user's email containing a reset password link.
4. User clicks the link, inputs their new password
5. User's password is updated in the database
   <img width="190" alt="Screenshot 2023-08-05 at 4 15 12 PM" src="https://github.com/CSC207-2023Y-UofT/course-project-autotrace/assets/95944688/e862ac40-2614-4a92-8654-e1421b5a97a2">

## Clean Architecture Design
### MVP Model
- We made repeated use of the MVP model of designing apps from Clean Architecture
- Examples of this are the UseProfile, Login and Signup Screens
- Every package is separated into a model, view and presenter to follow MVP
- Integrated with entities and use cases to follow Clean Architecture
- The separation of xml files for frontend in AndroidStudio helps separate roles further
- Follows the SOLID Design Principles

### UseCases
- An example of this is ``FetchCarInfoUseCase``
- This use case extracts car details and returns a car object

### Entity
- Some examples of this are the CarEntity and UseAccountEntity
- CarEntity is what is returned in ``FetchCarInfoUseCase``

## Design Pattern
### Observer Pattern
- We made use of the observer pattern to implement the ForgotPassword feature
- ForgotPasswordPresenter implements observable
- Observer observers the presenter to see if ForgotPassword succeeded or failed
- The update logic of update in observer is implemented in the model to follow CleanArchitecture

### Dependency Injection Design Pattern
- 


## Team Roles

### Haris
- (Scrum Master)
- Directed and Delegated Tasks
- Co-organized team meetings and assigned roles
- Set Up Firebase Database
- Worked on the frontend and backend of Access Basic Info, Sign Up,
  Traffic Violations, HomeScreen, Register New Vehicle Screen
- Refactored and repackaged the source code
- Worked on Readme
- Worked on Figma Designs


### Diler
- Co-organized Team Meetings
- Worked on Read Me
- Worked on Frontend for Splash, Traffic Violations, Access Basic Info,
- Log In Screens and backend work for Home Screen
- Debugging the splash screen code
- Worked on Figma Designs

### Ji
- Refactoring Code for Login Screen
- Worked on Frontend and Backend for Login Screen
- Worked on Frontend and Backend for Signup Screen
- Implemented Frontend for Forgot Password Screen
- Implemented the Forgot Password feature with real emails
- Worked on Figma Designs


### Milan
- Worked on Read Me
- Implemented Frontend and Backend for Profile Screen
- Worked on navigating between the screens
- Streamlined buttons and xml naming conventions
- Refactored code into Clean Architecture
- Worked on Figma Designs

## Code Smells and Issues for Future Work
- The home screen has dummy values rather than real vehicle models
- The basic access from license plate shows inconsistent names
- The database is set up so the ticket violations page can only display one ticket at a time 
