from rest_framework import status
from rest_framework.response import Response
from rest_framework.decorators import api_view
from question.models import Question
from quiz.models import Quiz
from .serializers import QuestionSerializer
from django.shortcuts import get_object_or_404
import json


# get a question's fields given its id
@api_view(["GET"])
def get_question(request, id):
    question = get_object_or_404(Question, id=id)
    serializer = QuestionSerializer(question)
    return Response(serializer.data)


# check the user's answer choice against the stored answer
@api_view(["GET"])
def check_answer(request, id, choice):
    question = get_object_or_404(Question, id=id)
    return Response({"result": question.answer == choice})


# list all questions
@api_view(["GET"])
def question_list(request):
    question = Question.objects.all()
    serializer = QuestionSerializer(question, many=True)
    return Response(serializer.data)


# add a question
@api_view(["POST"])
def add_question(request):
    serializer = QuestionSerializer(data=request.data)
    if serializer.is_valid():
        serializer.save()
        return Response(serializer.data, status=status.HTTP_201_CREATED)
    else:
        return Response(status=status.HTTP_400_BAD_REQUEST)


# update a question
@api_view(["PUT"])
def update_question(request, id):
    question = get_object_or_404(Question, id=id)
    serializer = QuestionSerializer(instance=question, data=request.data)
    if serializer.is_valid():
        serializer.save()
        return Response(serializer.data, status=status.HTTP_200_OK)
    else:
        return Response(status=status.HTTP_400_BAD_REQUEST)


# delete a question from the database
@api_view(["DELETE"])
def delete_question(request, id):
    question = get_object_or_404(Question, id=id)
    question.delete()
    return Response(
        f"The Question with id='{id}' was deleted successfully.",
        status=status.HTTP_200_OK,
    )


# delete all questions from the database
@api_view(["DELETE"])
def delete_all_questions(request):
    Question.objects.all().delete()
    return Response(
        "All stored Questions deleted successfully.",
        status=status.HTTP_200_OK,
    )


# add questions from test data json file
@api_view(["POST"])
def add_questions(request):
    with open("backend/LanguageLearner/question/test_question_data.json", "r") as file:
        data = json.load(file)

    count = 0

    for item in data:
        try:
            question = Question(
                pk=item["pk"],
                question=item["question"],
                prompt=item["prompt"],
                answer=item["answer"],
                choices=item["choices"],
                quiz=Quiz.objects.get(id=item["quiz"]),
            )
            question.save()
            count = count + 1
        except Quiz.DoesNotExist:
            pass

    file.close()

    return Response(
        f"Successfully added {count} Questions to the DB.",
        status=status.HTTP_200_OK,
    )
