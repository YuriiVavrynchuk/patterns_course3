from src.Input.IInputStrategy import IInputStrategy

from sodapy import Socrata


class SocrataInputStrategy(IInputStrategy):
    def __init__(self, configuration: dict):
        self.__configuration = configuration
        self.__api_id = None
        self.__client = None
        self.__data_size = 0

    def __initialize_source(self) -> None:
        api_base_url = self.__configuration['api_base_url']
        self.__api_id = self.__configuration['api_id']
        self.__data_size = self.__configuration['limit']
        self.__client = Socrata(api_base_url, None)

    def get_data(self) -> list:
        self.__initialize_source()
        data: list = self.__client.get(self.__api_id, limit=self.__data_size)
        return data
