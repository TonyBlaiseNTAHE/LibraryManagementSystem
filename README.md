## Auca Library Management System

### Problem identification: Library Management System

- Users should be authenticated based on their role
- Users should have a membership to borrow a book
- users should borrow books(number of book: book number limit) based on the `membership_type`.
- users should be fined if they delay to give back the book(s).
- The librarian should validate the request of members.
- The librarian should see what the users have requested, book(s) borrowed and all transactions.
- HOD, Dean, Register, and Manage can see and view all details but do not have insert privilege. These administrators should not be allowed to borrow the books.
- The system should validate if the user does not borrow more books than his/her membership books
- The librarian should have a way to assign the book to the shelf.
- The librarian should have a way to assign the shelf to the room.
- The librarian should have a way to check how many books are in a specific room.

### Day 1 Goals:
- Models creations
- Defining relationship
- Table creation
- Mapping classes to the PostgreSQL database
- Servlet creation
- Implementing authentication attempts.

## Library Management System - Model Documentation

### Overview
The library management system allows users to manage hard copies of books, track borrowing activities, handle memberships, and apply fines for late returns. The system organizes users and their locations in a hierarchical structure.

### 1. Person (Super Class)
**Attributes:**
- `person_id`: String - Unique identifier for a person.
- `first_name`: String - First name of the person.
- `last_name`: String - Last name of the person.
- `gender`: PersonGender - Gender of the person (uses an enum).
- `phone_number`: String - Contact number of the person.

**Relationships:**
- User: Inherits from Person, extending its attributes to include user-specific information.

**Explanation:**
The Person class is an abstract superclass representing common attributes for all types of people in the system. It uses the `@MappedSuperclass` annotation to indicate that it serves as a base class for entity classes.

### 1.1. PersonGender (Enumeration)
- **Values:** `MALE`, `FEMALE`  
This enumeration defines the possible genders for a person.

### 2. User (Subclass of Person)
**Attributes:**
- `password`: String - User's password (hashed for security).
- `role`: UserRole - Role of the user in the system (uses an enum).
- `user_name`: String - Unique username for the user.
- `village_id`: UUID - Reference to the user's location.

**Relationships:**
- Village: Each user is associated with a location via `village_id`.

**Explanation:**
The User class extends Person to include attributes specific to users, such as their role in the library system and their login credentials. The `village_id` connects the user to a specific location, allowing the system to manage users by their geographical area.

### 3. Location
**Attributes:**
- `location_id`: UUID - Unique identifier for the location.
- `location_code`: String - Code representing the location.
- `location_name`: String - Name of the location.
- `location_type`: LocationType - Type of the location (uses an enum).
- `parent_id`: UUID - Reference to the parent location (used for hierarchical structure).

**Relationships:**
- User: Each location can be referenced by multiple users via `village_id`.

**Explanation:**
The Location class manages hierarchical locations, allowing for the organization of geographical data into provinces, districts, sectors, cells, and villages. The `parent_id` attribute allows for parent-child relationships between different location levels.

### 3.1. LocationType (Enumeration)
- **Values:** `PROVINCE`, `DISTRICT`, `SECTOR`, `CELL`, `VILLAGE`  
This enumeration defines the different types of locations.

### 4. Membership
**Attributes:**
- `membership_id`: UUID - Unique identifier for the membership.
- `membership_code`: String - Code representing the membership type.
- `membership_status`: Status - Current status of the membership (uses an enum).
- `reader_id`: UUID - Reference to the user who owns this membership.
- `expiring_time`: Date - Expiration date of the membership.
- `registration_date`: Date - Date when the membership was created.
- `membership_type_id`: UUID - Reference to the type of membership.

**Relationships:**
- User: Each membership is associated with a user (reader) through `reader_id`.
- MembershipType: Links to a specific type of membership.

**Explanation:**
The Membership class manages user memberships, including their status, expiration, and association with a user. This allows the system to enforce borrowing limits and track membership validity.

### 4.1. Status (Enumeration)
- **Values:** `APPROVED`, `REJECTED`, `PENDING`  
This enumeration defines the possible statuses for a membership.

### 5. Book
**Attributes:**
- `book_id`: UUID - Unique identifier for the book.
- `title`: String - Title of the book.
- `author`: String - Author of the book.
- `edition`: int - Edition of the book.
- `ISBNCode`: String - ISBN code for the book.
- `publication_year`: Date - Year the book was published.
- `publisher_name`: String - Publisher of the book.
- `book_status`: BookStatus - Current status of the book (uses an enum).
- `shelf_id`: UUID - Reference to the shelf where the book is stored.

**Relationships:**
- Shelf: Each book is associated with a shelf where it is located.

**Explanation:**
The Book class manages the details of books within the library, including their current status (borrowed, reserved, or available) and location within the library.

### 5.1. BookStatus (Enumeration)
- **Values:** `BORROWED`, `RESERVED`, `AVAILABLE`  
This enumeration defines the possible statuses of a book.

### 6. Shelf
**Attributes:**
- `room_id`: UUID - Reference to the room where the shelf is located.
- `available_stock`: int - Number of available books on the shelf.
- `book_category`: String - Category of books on the shelf.
- `initial_stock`: int - Total number of books initially placed on the shelf.
- `borrowed_number`: int - Number of books currently borrowed from the shelf.

**Relationships:**
- Room: Each shelf is located in a specific room.

**Explanation:**
The Shelf class organizes books within a specific room, tracking both available and borrowed stock, facilitating the management of book inventory.

### 7. Room
**Attributes:**
- `room_id`: UUID - Unique identifier for the room.
- `room_code`: String - Code representing the room.

**Relationships:**
- Shelf: Each room can contain multiple shelves.

**Explanation:**
The Room class organizes shelves within the library, providing a structure for where books are physically located.

### 8. Borrower
**Attributes:**
- `id`: UUID - Unique identifier for the borrowing transaction.
- `book_id`: UUID - Reference to the borrowed book.
- `reader_id`: UUID - Reference to the user borrowing the book.
- `pickup_date`: Date - Date when the book was picked up.
- `due_date`: Date - Date by which the book should be returned.
- `return_date`: Date - Date when the book was returned.
- `late_change_fees`: int - Fees applied for late returns.

**Relationships:**
- User: Each borrowing transaction is associated with a user.
- Book: Each transaction references a specific book.

**Explanation:**
The Borrower class tracks book borrowing transactions, managing details such as pickup and due dates, and calculating late fees as necessary.

### Summary of Relationships
- User ↔ Location: Each user is associated with a location through `village_id`.
- User ↔ Membership: Each user can have one or more memberships.
- Membership ↔ MembershipType: Each membership is linked to a specific membership type.
- Book ↔ Shelf: Each book resides on a specific shelf.
- Shelf ↔ Room: Each shelf is located within a room.
- Borrower ↔ User: Each borrowing transaction is associated with a user.
- Borrower ↔ Book: Each borrowing transaction references a specific book.

