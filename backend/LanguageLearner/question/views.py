from rest_framework.response import Response
from rest_framework.decorators import api_view
from question.models import Question
from .serializers import QuestionSerializer


# list all questions
@api_view(["GET"])
def question_list(request):
    question = Question.objects.all()
    serializer = QuestionSerializer(question, many=True)
    return Response(serializer.data)


# check the user's answer choice against the stored answer
@api_view(["GET"])
def check_answer(request, id, choice):
    question = Question.objects.get(id=id)
    return Response({"result": question.answer == choice})


# add a question
@api_view(["POST"])
def add_question(request):
    serializer = QuestionSerializer(data=request.data)
    if serializer.is_valid():
        serializer.save()
    return Response(serializer.data)
