# Library Web Application


Przed uruchomieniem aplikacji należy stworzyć i skonfigurować bazę danych:

>nazwa: pgs_library

>localhost:3306

>brak nazwy użytkownika i hasła



Aplikacja używa **MapStruct**, który generuje dodatkowe klasy. Dlatego przed pierwszy uruchomieniem, należy **skompilować** projekt używając **Mavena**.

Aplikację można uruchomić za pomocą **IntelliJ IDEA**. 

Po poprawnym połączeniu z bazą danych, program powinien stworzyć tabele i wygenerować przykładowe dane. Po pierwszym uruchomieniu aplikacji należy otworzyć plik `application.yml` znajdujący w folderze `resources` i zmienić `ddl-auto: create`, na `ddl-auto: none`, aby zapobiec nadpisywaniu się danych.

Aplikacja jest zabezpieczona przez **Spring Security** i posiada dwa konta z których można się do niej zalogować:

- Administrator(dostęp do wszystkich fukcji)

>nazwa użytkownika: **admin**

>hasło: **admin**

- User(dostęp ograniczony)
>nazwa użytkownika: user

>hasło: user

**Dokumentacja API** dostępna jest na: http://localhost:8080/swagger-ui.html
