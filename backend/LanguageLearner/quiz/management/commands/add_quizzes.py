from django.core.management.base import BaseCommand
from quiz.models import Quiz
import json


class Command(BaseCommand):
    help = "Adds Quiz data to the database. Overwrites data if primary key previously existed."

    def handle(self, **options):
        with open("test_quiz_data.json", "r") as file:
            data = json.load(file)

        for item in data:
            quiz = Quiz(
                pk=item["pk"],
                name=item["name"],
                level_requirement=item["level_requirement"],
                level_reward=item["level_reward"],
            )
            quiz.save()

        file.close()

        self.stdout.write(self.style.SUCCESS("Successfully added Quiz data to the DB."))
