from django.urls import path
from . import views

urlpatterns = [
    path("", views.question_list),
    path("add/", views.add_question),
    path("check/<int:id>/<int:choice>/", views.check_answer),
]
