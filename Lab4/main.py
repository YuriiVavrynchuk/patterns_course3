from src.Common.ConfigurationParser import ConfigurationParser
from src.Common.DataProcessor import DataProcessor


def main() -> None:
    configuration_parser = ConfigurationParser("conf.json")
    input_strategy = configuration_parser.get_input_strategy()
    output_strategy = configuration_parser.get_output_strategy()
    data_processor = DataProcessor(input_strategy, output_strategy)
    data_processor.process()


if __name__ == '__main__':
    main()
