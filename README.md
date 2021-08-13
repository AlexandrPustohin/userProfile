# userProfile
REST - сервис получения и обработки данных по пользователю<br>
Сделано: <br>
 - обработка GET /api/users/ и /user/{id} запросов - получение всего списка и по id<br>
 - обработка POST (/user)  запроса - сохрание данных в БД<br>
 - обработка DELETE (/user/{id}) запроса - удаление записи по id<br>
 - обработка PUT (/user/{id}) запроса - изменение записи по id<br>
 - обработка POST (/filter) запроса - получение данных по фильтру (структура в JSON) - пока по двум полям (остальные привязать не сложно - был важен принцип работы). Используется в запросе "LIKE" и без учета регистра.<br>
 Нет обработки исключений.Валидация для полей класса DTO (не понятно из задания). <br>
  Нет тестов.<br>
 Проверено в Postman. Сделан front-end (https://github.com/AlexandrPustohin/userProfile_front)<br>
