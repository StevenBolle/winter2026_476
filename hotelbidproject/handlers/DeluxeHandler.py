from handlers.RoomHandler import RoomHandler

class DeluxeHandler(RoomHandler):

    def __init__(self, room, suiteRoom):
        super().__init__(room)
        self.suiteRoom = suiteRoom

    def handleBid(self, bidAmount):
        # Deluxe accepts bids from 150 to 280 (normal case)
        if 150 <= bidAmount <= 280 and self.room.getAvailableRooms() > 0:
            self.room.decrementRoom()
            return f"Deluxe room booked, rooms remaining: {self.room.getAvailableRooms()}"

        # deluxe accepts bids over 280 ONLY when no remaining suites available
        if (
                bidAmount >= 280
                and self.suiteRoom.getAvailableRooms() == 0
                and self.room.getAvailableRooms() > 0
        ):
            self.room.decrementRoom()
            return f"Deluxe room booked, suite level room unavailable. Remaining: {self.room.getAvailableRooms()}"

        if self.nextHandler:
            return self.nextHandler.handleBid(bidAmount)

        return "Bid rejected, please enter a new bid."