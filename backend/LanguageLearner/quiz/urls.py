from django.urls import path
from . import views

urlpatterns = [
    path("", views.quiz_list),
    path("get/<int:id>/", views.get_quiz),
    path("get_questions/<int:id>/", views.get_questions),
    path("add/", views.add_quiz),
    path("update/<int:id>/", views.update_quiz),
    path("add_level/<int:id>/", views.add_level),
    path("delete/<int:id>/", views.delete_quiz),
    path("delete_all/", views.delete_all_quizzes),
    path("add_quizzes/", views.add_quizzes),
]
