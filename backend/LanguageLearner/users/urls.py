from django.urls import path
from .views.view_user import ViewUser
from .views.create_user import CreateUser
from .views.login import LoginUser
from .views.logout import LogoutUser
from .views.update import UpdateUser
from .views.all_users import AllUsers
from .views.delete import DeleteUser
from .views.add_users import AddUsers

app_name = "users"
urlpatterns = [
    path("view/", ViewUser.as_view(), name="view_user"),
    path("create/", CreateUser.as_view(), name="create_user"),
    path("login/", LoginUser.as_view(), name="login_user"),
    path("logout/", LogoutUser.as_view(), name="logout_user"),
    path("update/", UpdateUser.as_view(), name="update_user"),
    path("all/", AllUsers.as_view(), name="all_users"),
    path("delete/", DeleteUser.as_view(), name="delete_user"),
    path("add_users/", AddUsers.as_view(), name="add_users"),
]
