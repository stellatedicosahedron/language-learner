FROM python:3.14-rc-slim-bookworm

WORKDIR /app

COPY requirements.txt requirements.txt

RUN pip3 install -r requirements.txt

COPY . .

CMD [ "python3", "./backend/LanguageLearner/manage.py", "runserver", "0.0.0.0:8000" ]