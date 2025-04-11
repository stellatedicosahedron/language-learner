from django.core.management.base import BaseCommand
from question.models import Question


class Command(BaseCommand):
    help = "Deletes all existing Questions."

    def handle(self, **options):
        Question.objects.all().delete()

        self.stdout.write(
            self.style.SUCCESS("Successfully deleted all Question entries.")
        )
