from django.urls import path
from . import views

urlpatterns = [
    path("", views.quiz_list),
    path("add/", views.add_quiz),
]
