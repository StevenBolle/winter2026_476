from handlers.RoomHandler import RoomHandler

class StandardHandler(RoomHandler):
    def __init__(self, room, suiteRoom, deluxeRoom):
        super().__init__(room)
        self.suiteRoom = suiteRoom
        self.deluxeRoom = deluxeRoom

    def handleBid(self, bidAmount):
        # Standard accepts bid from 80 to < 150
        if 80 <= bidAmount < 150 and self.room.getAvailableRooms() > 0:
            self.room.decrementRoom()
            return f"Standard room booked. Standard rooms remaining: {self.room.getAvailableRooms()}"

        # high bid, but deluxe and suite sold out
        if (
                bidAmount >= 150 and self.suiteRoom.getAvailableRooms() == 0
                and self.deluxeRoom.getAvailableRooms() == 0
                and self.room.getAvailableRooms() > 0
        ):
            self.room.decrementRoom()
            return (f"Standard room booked, higher tiers unavailable at this time. "
                    f"Standard rooms remaining: {self.room.getAvailableRooms()}")

        # Final check if no rooms available
        if (
                self.room.getAvailableRooms() == 0
                and self.suiteRoom.getAvailableRooms() == 0
                and self.deluxeRoom.getAvailableRooms() == 0
        ):
            return "All rooms currently sold out"

        # bid is too low to accept
        return "Bid rejected, please enter a new bid"


