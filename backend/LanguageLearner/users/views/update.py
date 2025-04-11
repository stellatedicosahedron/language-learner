from django.shortcuts import get_object_or_404
from rest_framework import generics
from ..models import User
from ..serializers import UserSerializer
from rest_framework.permissions import IsAuthenticated

class UpdateUser(generics.UpdateAPIView):
    """
    Updates the information of the currently logged in user
    """
    permission_classes = [IsAuthenticated]
    serializer_class = UserSerializer

    # When testing using postman, you need to find the cookie called csrftoken and use its value
    # as a header with the key X-CSRFToken
    def get_object(self):
        user = get_object_or_404(User, pk=self.request.user.pk)
        return user
