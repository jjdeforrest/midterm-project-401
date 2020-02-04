# Vision

Our vision is to help users strengthen and level up their meme game by being able to see which of their memes are highly liked by other users as well as find highly liked memes from other users.</br>
Users will be able to store their favorite memes in their account. Users will have the ability to like other user memes or delete their memes. Additional functionality will include the ability to modify memes with text and update the file on the database.</br></br>

# Scope (In/Out)
* IN - What will your product do</br>

1. Users will be able to add and save memes into their accounts.
2. Other users will be able to like other user's memes.
3. Users will be able to add text to their meme.
4. The app will be able to filter memes from most likable to least.

* OUT - What will your product not do.
1. Our website will not collect your personal information.

**Minimum Viable Product vs**
 * What will your MVP functionality be?</br>
 * Login page
 * User Profile
 * Main Meme page where users can like other memes
 * Separate page with meme generator capacities(use app stored images and add your text to the image)

* Stretch Goal</br>
As a stretch goal- user could upload their images and add text. 


# Functional Requirements
List the functionality of your product. This will consist of tasks such as the following:

1. A user can create an account and login. 
2. A user can add and delete their memes.
3. A user can add their profile information and picture.
4. A user can search all the memes from the app.

## Data Flow
Describe the flow of data in your application. Write out what happens from the time the user begins using the app to the time the user is done with the app. Think about the “Happy Path” of the application. Describe through visuals and text what requests are made, and what data is processed, in addition to any other details about how the user moves through the site.

![DataFlow](/memestagram/src/main/resources/static/images/erd.jpg)

# Non-Functional Requirements

Non-Functional Requirement (NFR) defines the quality attribute of a software system. It judges the software system based on Responsiveness, Usability, Security, Portability and other non-functional standards that are critical to the success of the software system.</br>
Resource: [www.guru99.com](https://www.guru99.com/non-functional-requirement-type-example.html)

1. Security: We are using thymeleaf security to protect the user's password.
2. Capacity: We will be using AWS S3 to store users' meme images.
