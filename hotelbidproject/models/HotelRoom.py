class HotelRoom:
    def __init__(self, roomType, availableRooms):
        self.roomType = roomType
        self.availableRooms = availableRooms

    # subtract a single room from the total of remaining
    # available rooms after successful bid
    def decrementRoom(self):
        if self.availableRooms > 0:
            self.availableRooms -= 1

    # control access and track room inventory
    def getAvailableRooms(self):
        return self.availableRooms
