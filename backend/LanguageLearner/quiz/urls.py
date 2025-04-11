from django.urls import path
from . import views

urlpatterns = [
    path("", views.quiz_list),
    path("get/<int:id>", views.get_quiz),
    path("add/", views.add_quiz),
    path("update/<int:id>", views.update_quiz),
    path("delete/<int:id>", views.delete_quiz),
]
