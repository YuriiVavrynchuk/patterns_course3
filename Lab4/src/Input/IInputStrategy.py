from abc import ABC, abstractmethod


class IInputStrategy(ABC):

    @abstractmethod
    def get_data(self) -> list:
        pass
