from rest_framework.response import Response
from rest_framework.decorators import api_view
from quiz.models import Quiz
from .serializers import QuizSerializer


# list all quizzes
@api_view(["GET"])
def quiz_list(request):
    quiz = Quiz.objects.all()
    serializer = QuizSerializer(quiz, many=True)
    return Response(serializer.data)


# add a quiz
@api_view(["POST"])
def add_quiz(request):
    serializer = QuizSerializer(data=request.data)
    if serializer.is_valid():
        serializer.save()
    return Response(serializer.data)
