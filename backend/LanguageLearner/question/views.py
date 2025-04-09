from rest_framework.response import Response
from rest_framework.decorators import api_view
from question.models import Question
from .serializers import QuestionSerializer


# Create your views here.
@api_view(["GET"])
def question_list(request):
    question = Question.objects.all()
    serializer = QuestionSerializer(question, many=True)
    return Response(serializer.data)


@api_view(["POST"])
def add_question(request):
    serializer = QuestionSerializer(data=request.data)
    if serializer.is_valid():
        serializer.save()
    return Response(serializer.data)
