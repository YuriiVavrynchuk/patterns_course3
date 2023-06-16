from src.Output.IOutputStrategy import IOutputStrategy

import json
import redis


class RedisOutputStrategy(IOutputStrategy):
    def __init__(self, configuration: dict):
        self.__configuration = configuration
        self.__redis_client = None
        self.__limit = 0

    def __initialize_source(self) -> None:
        host = self.__configuration["host"]
        port = self.__configuration["port"]
        self.__limit = self.__configuration["limit"]
        self.__redis_client = redis.Redis(host, port, decode_responses=True)

    def put_data(self, data: list) -> None:
        self.__initialize_source()
        for index in range(self.__limit):
            serialized_data = json.dumps(data[index])
            self.__redis_client.rpush(f'data', serialized_data)
