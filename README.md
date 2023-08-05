# AutoTrace

AutoTrace is an Android app designed to provide users with essential vehicle information by inputting their license plate. It offers a simple and efficient way to retrieve car model and registration date data as well as view traffic ticket violations from relevant databases. Additionally, it allows Users to register vehicles into the system, with an associated driver name and License Plates.

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
<img width="268" alt="Screenshot 2023-08-04 at 10 07 27 PM" src="https://github.com/CSC207-2023Y-UofT/course-project-autotrace/assets/95944688/d0ab10c0-5991-48f7-9c0f-de599393fb5f">

### Vehicle Registration 
1. User logs into the AutoTrace app using their email and password.
2. User taps the plus button on the Dashboard/Home Screen, which redirects to the vehicle registration screen.
3. User inputs the license plate number, Last Name, and Date of Birth into the provided fields.
4. After filling in the required information, the administrator taps on the "Register" button to submit the details.
5. Information is then verified based on if the vehicle exists in the database.
6. If the information is valid, the vehicle is registered under the User's Account and is now viewable from the dashboard.
<img width="270" alt="Screenshot 2023-08-04 at 11 08 57 PM" src="https://github.com/CSC207-2023Y-UofT/course-project-autotrace/assets/95944688/b434e074-2a40-42c7-aa5c-2e788c722038">

### Viewing RegistedVehicle Information
1. User logs in with their email and password.
2. They are directed to the home screen, where they can view different previously registered vehicles.
3. The user selects a specific vehicle and can access the car information screen, which includes insurance Provider, Car Model/Year, and Owner.

### Checking Traffic Violations
1. User logs in with their email and password.
2. They are directed to the home screen.
3. The user presses the traffic violation icon in the navigation bar.
4. They are taken to the traffic violations page, displaying various tickets with details such as the amount payable, date the ticket was issued, the intersection where the violation occurred, and a description of the violation (e.g., parking ticket, traffic light violation).
<img width="287" alt="Screenshot 2023-08-04 at 11 18 05 PM" src="https://github.com/CSC207-2023Y-UofT/course-project-autotrace/assets/95944688/c0166df5-a3dc-4cbc-a993-7bdccba191c8">

### User Log In
1. User launches the application
2. User prompted with the splash screen
3. User inputs their email and password
4. Directed to home Screen
<img width="271" alt="Screenshot 2023-08-04 at 10 07 15 PM" src="https://github.com/CSC207-2023Y-UofT/course-project-autotrace/assets/95944688/0164d4d5-bd00-4db5-9968-7ce585b690db">


### User Registration
1. User presses the sign-up button upon launching the app
2. User inputs their email, password, and password confirmation.
3. The user views a verification success pop-up confirming their successful registration.

### Reset Password
1. User presses the Forgot Password button upon launching the app
2. User inputs their email.
3. An email is sent to the user's email containing a reset password link.
4. User clicks the link, inputs their new password
5. User's password is updated in the database
<img width="286" alt="Screenshot 2023-08-04 at 11 32 15 PM" src="https://github.com/CSC207-2023Y-UofT/course-project-autotrace/assets/95944688/476760e7-4298-40f6-a966-9fa9d0908b2c">


### Team Roles

- Haris

- Diler

- Ji

- Milan

