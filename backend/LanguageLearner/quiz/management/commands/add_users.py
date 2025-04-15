from django.core.management.base import BaseCommand
from users.serializers import UserSerializer
import json


class Command(BaseCommand):
    help = "Adds User data to the database."

    def handle(self, **options):
        with open("test_user_data.json", "r") as file:
            data = json.load(file)

        for item in data:
            user = UserSerializer(data=item)
            if user.is_valid():
                user.save()
                self.stdout.write(self.style.SUCCESS("Added 1 User."))
            else:
                print(user.errors)
                self.stdout.write(self.style.SUCCESS("Unable to add User."))

        file.close()
