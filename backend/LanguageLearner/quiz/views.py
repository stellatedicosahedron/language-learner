from rest_framework import status
from rest_framework.response import Response
from rest_framework.decorators import api_view
from quiz.models import Quiz
from .serializers import QuizSerializer
from question.models import Question
from question.serializers import QuestionSerializer
from django.shortcuts import get_object_or_404


# get a quiz's fields given its id
@api_view(["GET"])
def get_quiz(request, id):
    quiz = get_object_or_404(Quiz, id=id)
    serializer = QuizSerializer(quiz)
    return Response(serializer.data)


# add a quiz
@api_view(["POST"])
def add_quiz(request):
    serializer = QuizSerializer(data=request.data)
    if serializer.is_valid():
        serializer.save()
        return Response(serializer.data, status=status.HTTP_201_CREATED)
    else:
        return Response(status=status.HTTP_400_BAD_REQUEST)


# list all questions associated with a quiz
@api_view(["GET"])
def get_questions(request, id):
    quiz = get_object_or_404(Quiz, id=id)
    questions = quiz.questions.all()
    serializer = QuestionSerializer(questions, many=True)
    return Response(serializer.data)


# list all quizzes
@api_view(["GET"])
def quiz_list(request):
    quiz = Quiz.objects.all()
    serializer = QuizSerializer(quiz, many=True)
    return Response(serializer.data)


# update a quiz
@api_view(["PUT"])
def update_quiz(request, id):
    quiz = get_object_or_404(Quiz, id=id)
    serializer = QuizSerializer(instance=quiz, data=request.data)
    if serializer.is_valid():
        serializer.save()
        return Response(serializer.data, status=status.HTTP_200_OK)
    else:
        return Response(status=status.HTTP_400_BAD_REQUEST)


# delete a quiz from the database
@api_view(["DELETE"])
def delete_quiz(request, id):
    quiz = get_object_or_404(Quiz, id=id)
    quiz.delete()
    return Response(
        f"The Question with id='{id}' was deleted successfully.",
        status=status.HTTP_200_OK,
    )


# delete all quizzes from the database
@api_view(["DELETE"])
def delete_all_quizzes(request):
    Quiz.objects.all().delete()
    return Response(
        "All stored Quizzes deleted successfully.",
        status=status.HTTP_200_OK,
    )
