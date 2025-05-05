from rest_framework.views import APIView
from rest_framework import status
from rest_framework.response import Response
from django.contrib.auth import authenticate, login

class LoginUser(APIView):
    """
    Attempts to log a user in using given credentials

    Expected payload:
    username (string): the user's name
    password (string): the user's password
    """

    def post(self, request, format=None):
        username = request.data['username']
        password = request.data['password']

        user = authenticate(username=username, password=password)
        if user is not None:
            login(request, user)
            response = Response(
                {"detail": "Successfully logged in."},
                status=status.HTTP_200_OK,
            )

            return response
        return Response(status=status.HTTP_400_BAD_REQUEST)