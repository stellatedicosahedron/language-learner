from django.urls import path
from . import views

urlpatterns = [
    path("get/<int:id>/", views.get_question),
    path("check/<int:id>/<int:choice>/", views.check_answer),
    path("", views.question_list),
    path("add/", views.add_question),
    path("update/<int:id>/", views.update_question),
    path("delete/<int:id>/", views.delete_question),
    path("delete_all/", views.delete_all_questions),
]
