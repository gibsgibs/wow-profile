from flask import Flask,request
import yaml
from blizzard_api_helper import BlizzardApiHelper

app = Flask(__name__)

@app.route("/api", methods=["POST"])
def character_info():
    api_credentials = read_yaml_file('api_config.yaml')['blizzard_api']
    blizzard_api_helper = BlizzardApiHelper(api_credentials=api_credentials)
    request_content = request.get_json()['content']
    character_summary_json = blizzard_api_helper.get_character_summary(request_content['realm'], request_content['name'])
    return character_summary_json

def read_yaml_file(path):
    with open(path, "r", encoding='utf-8') as file:
        return yaml.safe_load(file)

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=80)