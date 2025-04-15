from django.core.management.base import BaseCommand
from quiz.models import Quiz
from question.models import Question
import json


class Command(BaseCommand):
    help = "Adds Question data to the database. Overwrites data if primary key previously existed."

    def handle(self, **options):
        with open("test_question_data.json", "r") as file:
            data = json.load(file)

        for item in data:
            question = Question(
                pk=item["pk"],
                question=item["question"],
                prompt=item["prompt"],
                answer=item["answer"],
                choices=item["choices"],
                quiz=Quiz.objects.get(id=item["quiz"]),
            )
            question.save()

        file.close()

        self.stdout.write(
            self.style.SUCCESS("Successfully added Question data to the DB.")
        )
