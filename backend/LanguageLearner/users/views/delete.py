from rest_framework.views import APIView
from rest_framework import status
from rest_framework.response import Response
from django.contrib.auth import logout
from rest_framework.permissions import IsAuthenticated

class DeleteUser(APIView):
    """
    Logs out and deletes the current user
    """
    permission_classes = [IsAuthenticated]

    # When testing using postman, you need to find the cookie called csrftoken and use its value
    # as a header with the key X-CSRFToken

    def delete(self, request, format=None):
        user = self.request.user
        logout(request)
        user.delete()
        response = Response(
            {"detail": "Successfully deleted."},
            status=status.HTTP_200_OK,
        )

        return response