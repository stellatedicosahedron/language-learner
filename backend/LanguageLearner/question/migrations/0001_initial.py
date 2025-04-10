# Generated by Django 5.2 on 2025-04-10 16:45

import django.db.models.deletion
from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
        ('quiz', '0001_initial'),
    ]

    operations = [
        migrations.CreateModel(
            name='Question',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('question', models.CharField(max_length=100)),
                ('prompt', models.CharField(max_length=100)),
                ('answer', models.CharField(max_length=50)),
                ('choices', models.TextField(default='{"choice1": "Choice 1", "choice2": "Choice 2", "choice3": "Choice 3", "choice4": "Choice 4"}')),
                ('quiz', models.ForeignKey(default=None, on_delete=django.db.models.deletion.CASCADE, to='quiz.quiz')),
            ],
        ),
    ]
