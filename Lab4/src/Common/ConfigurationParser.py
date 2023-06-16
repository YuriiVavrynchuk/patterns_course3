import json


class ConfigurationParser:
    def __init__(self, json_path: str):
        with open(json_path, 'r', encoding="utf-8") as json_file:
            self.__parsed_json = json.load(json_file)

    def get_input_strategy(self) -> dict:
        return {
            "input_type": self.__parsed_json["input_strat_conf"].get("type"),
            "api_base_url": self.__parsed_json["input_strat_conf"]["arguments"].get("api_base_url", None),
            "api_id": self.__parsed_json["input_strat_conf"]["arguments"].get("api_id", None),
            "limit": self.__parsed_json["input_strat_conf"]["arguments"].get("limit")
        }

    def get_output_strategy(self) -> dict:
        return {
            "output_type": self.__parsed_json["output_strat_conf"].get("type"),
            "host": self.__parsed_json["output_strat_conf"]["arguments"].get("host", None),
            "port": self.__parsed_json["output_strat_conf"]["arguments"].get("port", None),
            "limit": self.__parsed_json["output_strat_conf"]["arguments"].get("limit")
        }
