# Generated by Django 5.2 on 2025-04-10 19:17

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('question', '0003_alter_question_choices_alter_question_prompt_and_more'),
    ]

    operations = [
        migrations.AlterField(
            model_name='question',
            name='question',
            field=models.CharField(max_length=100),
        ),
    ]
