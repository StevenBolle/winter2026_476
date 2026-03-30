# python has no abstraction, simulate with abc
from abc import ABC, abstractmethod

class RoomHandler(ABC):
    def __init__(self, room):
        self.nextHandler = None
        self.room = room

    # nextHandler will enable chaining for CoR
    # setNext will handle building chain Suite -> Deluxe -> Standard
    def setNext(self, handler):
        self.nextHandler = handler

    # subclasses forced to implement handleBid
    @abstractmethod
    def handleBid(self, bidAmount):
        pass