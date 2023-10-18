import requests

class BlizzardApiHelper:
    def __init__(self, api_credentials):
        self.__access_token = self.__get_access_token(api_credentials)

    def __get_access_token(self, api_credentials):
        url = 'https://oauth.battle.net/token'
        data = {
            'grant_type': 'client_credentials'
        }
        auth = (api_credentials['client_id'], api_credentials['client_secret'])
        response = requests.post(url=url, data=data, auth=auth, timeout=10)
        return response.json()['access_token']

    def get_character_summary(self, realm, name):
        url = f'https://us.api.blizzard.com/profile/wow/character/{realm}/{name}'
        parameters = {
            'namespace': 'profile-us',
            'locale': 'en_US'
        }
        headers = {
            'Authorization': f'Bearer {self.__access_token}'
        }
        response = requests.get(url=url, params=parameters, headers=headers, timeout=10)
        return response.json()
