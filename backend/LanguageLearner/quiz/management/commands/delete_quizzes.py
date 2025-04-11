from django.core.management.base import BaseCommand
from quiz.models import Quiz


class Command(BaseCommand):
    help = "Deletes all existing Quizzes."

    def handle(self, **options):
        Quiz.objects.all().delete()

        self.stdout.write(self.style.SUCCESS("Successfully deleted all Quiz entries."))
