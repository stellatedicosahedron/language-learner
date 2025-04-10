from rest_framework.views import APIView
from rest_framework import status
from rest_framework.response import Response
from rest_framework.permissions import IsAuthenticated
from django.contrib.auth import logout

class LogoutUser(APIView):
    """
    Logs out the current user
    """
    permission_classes = [IsAuthenticated]

    # When testing using postman, you need to find the cookie called csrftoken and use its value
    # as a header with the key X-CSRFToken
    def post(self, request, format=None):
        logout(request)
        response = Response(
            {"detail": "Successfully logged out."},
            status=status.HTTP_200_OK,
        )

        return response