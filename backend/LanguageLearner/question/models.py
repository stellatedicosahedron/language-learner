from django.db import models


# Create your models here.
class Question(models.Model):
    question = models.CharField(max_length=100)
    prompt = models.CharField(max_length=100)
    answer = models.CharField(max_length=50)
    choices = models.TextField()

    # determines what the string version of the object returns
    # must be indented to be a part of the class
    def __str__(self):
        return self.question
