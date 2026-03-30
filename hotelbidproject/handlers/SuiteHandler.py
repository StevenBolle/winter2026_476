from handlers.RoomHandler import RoomHandler

class SuiteHandler(RoomHandler):
    def handleBid(self, bidAmount):
        # check if suite can accept a proposed bid
        # suite accepts bids that are 280 or above
        if bidAmount >= 280 and self.room.getAvailableRooms() > 0:
            self.room.decrementRoom()
            return f"Suite booked. Remaining: {self.room.getAvailableRooms()}"

        # if amount too low, give to next handler if handler exists
        if self.nextHandler:
            # CoR - pass to next handler
            return self.nextHandler.handleBid(bidAmount)

        return "Bid rejected. Enter a new bid."
