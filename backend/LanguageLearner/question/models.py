from django.db import models
from quiz.models import Quiz


# Question model
class Question(models.Model):
    question = models.CharField(max_length=100)
    prompt = models.CharField(max_length=100)
    answer = models.CharField(max_length=50)
    # add a default json object here to prevent errors
    choices = models.TextField()
    quiz = models.ForeignKey(Quiz, on_delete=models.CASCADE, default=None)

    # determines what the string version of the object returns
    # must be indented to be a part of the class
    def __str__(self):
        return self.question
