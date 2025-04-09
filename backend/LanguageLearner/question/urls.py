from django.urls import path
from . import views

urlpatterns = [
    path("", views.question_list),
    path("add/", views.add_question),
]
