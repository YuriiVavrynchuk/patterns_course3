from src.Input.SocrataInputStrategy import SocrataInputStrategy
from src.Output.RedisOutputStrategy import RedisOutputStrategy
from src.Output.ConsoleOutputStrategy import ConsoleOutputStrategy


class DataProcessor:
    def __init__(self, input_strategy: dict, output_strategy: dict):
        self.__input_strategy_params = input_strategy
        self.__output_strategy_params = output_strategy
        self.__input_strategy = None
        self.__output_strategy = None

    def __initialize_processor(self):
        if self.__input_strategy_params["input_type"] == "Socrata":
            self.__input_strategy = SocrataInputStrategy(self.__input_strategy_params)

    def __initialize_deployer(self):
        if self.__output_strategy_params["output_type"] == "Redis":
            self.__output_strategy = RedisOutputStrategy(self.__output_strategy_params)
        elif self.__output_strategy_params["output_type"] == "Console":
            self.__output_strategy = ConsoleOutputStrategy(self.__output_strategy_params)

    def process(self) -> None:
        self.__initialize_processor()
        self.__initialize_deployer()
        data = self.__input_strategy.get_data()
        self.__output_strategy.put_data(data)
        self.__output_strategy.write_csv(data)
