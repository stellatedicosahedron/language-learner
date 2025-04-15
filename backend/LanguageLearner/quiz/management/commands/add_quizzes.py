from django.core.management.base import BaseCommand
from quiz.models import Quiz
import json


class Command(BaseCommand):
    help = "Adds Quiz data to the database. Overwrites data if primary key previously existed."

    def handle(self, **options):
        with open("test_quiz_data.json", "r") as file:
            data = json.load(file)

        count = 0

        for item in data:
            quiz = Quiz(
                pk=item["pk"],
                name=item["name"],
                language=item["language"],
                level_requirement=item["level_requirement"],
                level_reward=item["level_reward"],
            )
            quiz.save()
            count = count + 1

        file.close()

        self.stdout.write(
            self.style.SUCCESS(f"Successfully added {count} Quizzes to the DB.")
        )
