from django.db import models


# Quiz model
class Quiz(models.Model):
    name = models.CharField(max_length=100)
    level_requirement = models.IntegerField(default=1)
    level_reward = models.IntegerField(default=1)
    # json containing 5 integers from 1-5 in a random order
    # backend would generate this and send to client at start of quiz
    question_order = models.TextField(default="1, 2, 3, 4, 5 (placeholder)")
    # represents the current question being shown in quiz (index an array?)
    # should be reset when a quiz is started
    current_question = models.IntegerField(default=1)
    # this should also be reset upon quiz start
    correct_answers = models.IntegerField(default=0)

    # determines what the string version of the object returns
    def __str__(self):
        return self.name
