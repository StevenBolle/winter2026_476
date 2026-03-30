from models.HotelRoom import HotelRoom
from handlers.SuiteHandler import SuiteHandler
from handlers.DeluxeHandler import DeluxeHandler
from handlers.StandardHandler import StandardHandler

class HotelClient:
    def __init__(self):
        # initialize objects
        suiteRoom = HotelRoom("Suite", 10)
        deluxeRoom = HotelRoom("Deluxe", 15)
        standardRoom = HotelRoom("Standard", 45)

        # create Handlers
        suiteHandler = SuiteHandler(suiteRoom)
        deluxeHandler = DeluxeHandler(deluxeRoom, suiteRoom)
        standardHandler = StandardHandler(standardRoom, suiteRoom, deluxeRoom)

        # build CoR
        suiteHandler.setNext(deluxeHandler)
        deluxeHandler.setNext(standardHandler)

        # where bids should first look: SuiteHandler
        self.firstHandler = suiteHandler

    def submitBid(self, bidAmount):
        return self.firstHandler.handleBid(bidAmount)

# testing
if __name__ == "__main__":
    client = HotelClient()
    print(client.submitBid(79))
    for _ in range(10):
        print(client.submitBid(300))
    print(client.submitBid(300))
    for _ in range(15):
        print(client.submitBid(200))
    print(client.submitBid(150))
    print(client.submitBid(149))
    print(client.submitBid(80))
    for _ in range(41):
        print(client.submitBid(80))
    print(client.submitBid(80))


