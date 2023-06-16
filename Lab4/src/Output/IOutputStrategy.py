import csv
from os import path
from abc import ABC, abstractmethod


class IOutputStrategy(ABC):

    CSV_FILE_NAME = "output"

    @abstractmethod
    def put_data(self, data: list) -> None:
        pass

    @staticmethod
    def write_csv(data: list) -> None:
        fieldnames = set().union(*data)
        with open(f'{IOutputStrategy.CSV_FILE_NAME}.csv', 'w', newline='') as csvfile:
            writer = csv.DictWriter(csvfile, fieldnames)
            writer.writeheader()
            for row in data:
                writer.writerow(row)
