from django.core.management.base import BaseCommand
from quiz.models import Quiz
from question.models import Question


class Command(BaseCommand):
    help = "Deletes all existing Questions, Users, and Quizzes."

    def handle(self, **options):
        Quiz.objects.all().delete()
        Question.objects.all().delete()

        self.stdout.write(
            self.style.SUCCESS("Successfully deleted all Quiz and Question entries.")
        )
