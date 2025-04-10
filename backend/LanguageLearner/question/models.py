from django.db import models
from quiz.models import Quiz
from django.core.validators import MaxValueValidator, MinValueValidator
import json


# Question model
class Question(models.Model):
    question = models.CharField(max_length=100)
    prompt = models.CharField(max_length=100)
    answer = models.IntegerField(
        default=1, validators=[MinValueValidator(1), MaxValueValidator(4)]
    )
    # default json object to prevent errors
    choices = models.TextField(
        default=json.dumps(
            {
                "1": "Choice 1",
                "2": "Choice 2",
                "3": "Choice 3",
                "4": "Choice 4",
            }
        )
    )
    quiz = models.ForeignKey(Quiz, on_delete=models.CASCADE, default=None)

    # determines what the string version of the object returns
    def __str__(self):
        return self.question
