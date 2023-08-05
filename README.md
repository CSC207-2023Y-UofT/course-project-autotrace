# AutoTrace

AutoTrace is an Android app designed to provide users with essential information about vehicles by inputting their license plate numbers. It offers a simple and efficient way to retrieve car model and registration date data from relevant databases. Additionally, it provides administrators with the ability to register license plates into the system, along with associated driver and car information.

## Motivation

The primary motivation behind AutoTrace is to offer a convenient solution for users who need to identify car models and registration dates based on license plate numbers. This app aims to streamline the process of accessing vehicle information by leveraging databases and providing an intuitive user interface.

## Features

- License Plate Search: Users can input a license plate number and retrieve the corresponding car model and registration date.
- User Registration: Administrators have the option to register new license plates into the system along with driver and car information.
- Secure Authentication: The app provides secure login functionality for both regular users and administrators to access their respective features.
- Vehicle Information: Users can view detailed information about previously registered vehicles, including insurance details.
- Traffic Violations: Users can check for any traffic violation tickets associated with a particular vehicle, displaying relevant details such as amount payable, issue date, intersection, and violation description.

## Scenario Walkthrough

### License Plate Search
1. User opens the AutoTrace Android app and launches the license plate search feature.
2. They enter the license plate number into the provided input field and tap on the "Search" button.
3. The app processes the input and queries the relevant databases based on the user's access key.
4. The app retrieves the car model and registration date associated with the provided license plate number.
5. Finally, the app displays the car model and registration date on the user interface, allowing the user to view the information.

### Vehicle Registration (Admin)
1. The administrator logs into the AutoTrace Android app with their credentials to access the registration section.
2. They input the license plate number, driver details, and car information into the provided fields.
3. After filling in the required information, the administrator taps on the "Register" button to submit the details.
4. The app receives the registration information and validates it.
5. If the information is valid, the app stores the license plate, driver, and car information in the database.
6. The administrator receives a confirmation message indicating successful registration, and the newly registered information is now accessible within the system.

### Viewing Vehicle Information
1. User logs in with their email and password.
2. They are directed to the home screen, where they can view different previously registered vehicles.
3. The user selects a specific vehicle and can access the car information screen, which may include insurance details.

### Checking Traffic Violations
1. User logs in with their email and password.
2. They are directed to the home screen, where they can view different vehicles.
3. The user presses the traffic violation icon in the bottom bar.
4. They are taken to the traffic violations page, displaying various tickets with details such as amount payable, date ticket was issued, the intersection where the violation occurred, and a description of the violation (e.g., parking ticket, traffic light violation).

### Registering a New Vehicle
1. User logs in with their email and password.
2. They are directed to the home screen, where they can view different previously registered vehicles.
3. The user presses the plus button (new vehicle registration button).
4. They proceed to register a new vehicle by inputting the License Plate, Last Name, and Date of Birth.
5. Once the information is input, the user views a vehicle registration confirmation screen, confirming the successful registration if the information is valid and meets the requirements.

### Accessing Basic Information Screen (Guest Login)
1. A user can access the basic information screen by inputting a license plate number without logging in.
2. The user views basic car information associated with the inputted license plate number.

### User Registration
1. User presses the sign-up button and inputs their email, password, and password confirmation.
2. The user receives a verification email with a four-digit code.
3. They input the four-digit code into the verification field.
4. The user views a verification success pop-up confirming their successful registration.

## Getting Started

To use AutoTrace, simply sign up for an account once you open the app. Once you have an account, you can register your new vehicles and if you get a parking violation, it will show up on your account. You can also customize your profile from the profile page. If you made an account and forgot your password, you can reset that too.
