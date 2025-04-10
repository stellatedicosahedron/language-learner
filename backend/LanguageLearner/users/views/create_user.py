from rest_framework.views import APIView
from rest_framework import status
from rest_framework.response import Response
from ..models import User
from ..serializers import UserSerializer
from rest_framework.permissions import IsAuthenticated

class CreateUser(APIView):
    """
    Creates a new user

    Expected payload:
    username (string): the user's name
    password (string): the user's password
    confirm_password (string): confirmation of the user's password
    email (string): the user's email, optional I guess?
    """

    def post(self, request, format=None):
        serializer = UserSerializer(data=request.data)

        if serializer.is_valid():
            user = serializer.save()
            response = Response(
                {
                    "user": serializer.data,
                },
                status=status.HTTP_201_CREATED,
            )

            return response
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)