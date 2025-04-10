from rest_framework.views import APIView
from rest_framework.response import Response
from ..models import User
from ..serializers import UserSerializer
from rest_framework.permissions import IsAuthenticated

class ViewUser(APIView):
    """
    Gets the information of the currently logged in user
    """
    permission_classes = [IsAuthenticated]

    def get(self, request, format=None):
        user = self.request.user
        serializer = UserSerializer(user)
        return Response(serializer.data)