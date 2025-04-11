from django.core.management.base import BaseCommand
from quiz.models import Quiz
from question.models import Question
import json


class Command(BaseCommand):
    help = "Adds User/Quiz/Question data to the database. Overwrites data if primary key previously existed."

    def handle(self, **options):
        # quiz import section
        with open("test_quiz_data.json", "r") as file:
            data = json.load(file)

        for item in data:
            quiz = Quiz(
                pk=item["pk"],
                name=item["fields"]["name"],
                level_requirement=item["fields"]["level_requirement"],
                level_reward=item["fields"]["level_reward"],
            )
            quiz.save()

        file.close()

        self.stdout.write(self.style.SUCCESS("Successfully added Quiz data to the DB."))

        # question import section
        with open("test_question_data.json", "r") as file:
            data = json.load(file)

        for item in data:
            question = Question(
                pk=item["pk"],
                question=item["fields"]["question"],
                prompt=item["fields"]["prompt"],
                answer=item["fields"]["answer"],
                choices=item["fields"]["choices"],
                quiz=Quiz.objects.get(id=item["fields"]["quiz"]),
            )
            question.save()

        file.close()

        self.stdout.write(
            self.style.SUCCESS("Successfully added Question data to the DB.")
        )
