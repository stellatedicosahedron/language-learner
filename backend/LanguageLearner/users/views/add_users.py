from rest_framework.views import APIView
from rest_framework import status
from rest_framework.response import Response
from ..serializers import UserSerializer
import json


class AddUsers(APIView):
    """
    Creates users from using the data from test_user_data.json

    No request body required.
    """

    def post(self, request):
        with open("backend/LanguageLearner/users/test_user_data.json", "r") as file:
            data = json.load(file)

        count = 0

        for item in data:
            user = UserSerializer(data=item)
            if user.is_valid():
                user.save()
                count = count + 1
            else:
                print(user.errors)

        file.close()

        return Response(
            f"Successfully added {count} Users to the DB.", status=status.HTTP_200_OK
        )
