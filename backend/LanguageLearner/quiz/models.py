from django.db import models


# Quiz model
class Quiz(models.Model):
    name = models.CharField(max_length=100, default="Default Name")
    language = models.CharField(max_length=2, default="jp")
    level_requirement = models.IntegerField(default=1)
    level_reward = models.IntegerField(default=1)

    # determines what the string version of the object returns
    def __str__(self):
        return self.name
