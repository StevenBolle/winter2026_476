# Project 2: CoR Hotel Bidding
## Overview:
Project implements a hotel room bidding system using the Chain of Responsibility (CoR) design pattern.

Customers submit a bid price to the system and are rewarded with booking to hotel rooms.
The system takes the bid amount and determines what type of room the request will fulfill by checking:
    - The bid amount
    - Availability of rooms

System includes:
    - Flask based Web App (GUI)
    - Console based test runner for validation

## Stack:
    - Python 3
    - Flask
    - OOP
    - Chain of Responsibility Design Pattern

### How to clone repository:
git clone https://github.com/StevenBolle/winter2026_476.git
cd winter2026_476

### Running Web Application
1. Make sure Flask is installed
pip install flask
2. Run the application
python app.py
3. Open your browser and go to:
http://127.0.0.1:5000/
4. Enter a bid and view the result

### Running Console Tests
To run in console mode:
python HotelClient.py

- The predefined bid scenarios will execute and output to the console.
- The bid scenarios in the console app cover all CoR fallbacks and expected outcomes

### System Behavior
- Suite: 
  - accepts bids >= 280.00
- Deluxe: 
  - accepts bids 150.00 - 280.00
  - accepts bids >= 280.00 if suites are sold out
- Standard:
  - accepts bids from 80.00 - 150.00
  - accepts bids >= 150.00 if Deluxe AND Suite are sold out

### Room Availability
- Suite: 10
- Deluxe: 15
- Standard: 45

Rooms decremented after a successful bid

### Design Pattern
This project uses the chain of responsibility design pattern.
Suite -> Deluxe -> Standard

Each Handler in the chain:
- Attempts to process the bid
- Passes the request to the next handler if it cannot

### Author
- Steven Bolle