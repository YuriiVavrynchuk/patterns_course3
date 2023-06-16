from src.Output.IOutputStrategy import IOutputStrategy


class ConsoleOutputStrategy(IOutputStrategy):
    def __init__(self, configuration: dict):
        self.__configuration = configuration
        self.__limit = 0

    def __initialize_source(self) -> None:
        self.__limit = self.__configuration["limit"]

    def put_data(self, data: list) -> None:
        self.__initialize_source()
        for index in range(self.__limit):
            print(f"{index}. {data[index]}")
