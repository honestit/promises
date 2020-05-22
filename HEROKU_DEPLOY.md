## Lista kroków do wykonania, aby aplikację zdeployować na heroku

### 1. Utwórz konto

Zarejestruj się na platformie heroku.com tworząc darmowe konto: [Utwórz konto](https://signup.heroku.com/)

### 2. Zainstaluj Heroku CLI

Pobierz narzędzie linii konsoli Heroku CLI właściwe dla Twojego systemu i zainstaluj je: [Heroku CLI](https://devcenter.heroku.com/articles/heroku-cli#download-and-install)

### 3. Zapoznaj się z działaniem platformy Heroku (dla chętnych)

Dobrym początkiem jest przeczytanie artykułu [How it works](https://devcenter.heroku.com/articles/how-heroku-works)

### 4. Skonfiguruj Heroku CLI

Włącz dowolną konsole systemową (np. `CMD` albo `Git bash`) i następnie

1. Przejdź do katalogu z Twoim projektem/repozytorium

   > Chodzi o katalog główny projektu, w którym działa polecenie np. `git status`.

1. Uruchom polecenie `heroku login`.

   > Wyskoczy powiadomienie, które po naciśnięciu dowolnego przycisku przeniesie Cię do logowania na stronie heroku. Po poprawnym zalogowaniu możesz wrócić do okna konsoli.
   
1. Uruchom polecenie `heroku keys`.

   > Powinna pojawić się pusta lista kluczy RSA.
   
1. Uruchom polecenie `heroku keys:add`.

   > Powinien zostać wygenerowany publiczny klucz RSA dla Twojej maszyny. 
   
1. Uruchom polecenie `ssh -v git@heroku.com`.

   > Zweryfikujesz w ten sposób czy Twoje połączenie jest poprawne.
   
### 5. Skonfigurowanie aplikacji

Najważniejszą rzeczą, o którą musisz zadbać, to ustawienie w pliku `application.properties` klucza `server.port` na wartość `${PORT:8080}`. W Heroku nie my decydujemy o porcie, na którym działa aplikacja a sama platforma. Stąd nasza aplikacja musi bazować na zewnętrznych wartościach, ale możemy zostawić wartość domyślną dla lokalnego uruchomienia.

Kiedy chcemu używać bazy danych, np. PostgreSQL, to również `datasource` należy skonfigurować w oparciu o zewnetrzne ustawienia. Odpowiednio:

`spring.datasource.url=${SPRING_DATASOURCE_URL}`

`spring.datasource.username=${SPRING_DATASOURCE_USERNAME}`

`spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}`
   
### 6. Utworzenie aplikacji

Stwórz nową aplikację korzystajać z poniższego polecenia:

`heroku create --remote heroku --region eu --stack heroku-18 <twoja-nazwa-aplikacji>`

Gdzie pod `<twoja-nazwa-aplikacji>` podstawiamy nazwę aplikacji. Przykładowo `super-app`:

`heroku create --remote heroku --region eu --stack heroku-18 super-app`

> Nazwa aplikacji będzie też zewnętrznym adresem do Twojej aplikacji na platformie heroku. Tutaj będzie pod adresem super-app.herokuapp.com

Krótkie wyjaśnienie co jest co:

* `heroku create` służy do utworzenia nowej aplikacji na platofmie Heroku
* `--remote heroku` tworzy nowy lokalny branch w naszym repozytorium o nazwie `heroku`. Branch ten będzie podpięty do zdalnego repozytorium na platofmie Heroku
* `--region eu` wskazuje, że nasza aplikacja powinna być obsługiwana przez serwery europejskie. Domyślnie są to serwery amerykańskie i w Polsce apka działa po prostu wolniej
* `--stack heroku-18` wskazuje, aby używać najnowszej wersji konfiguracji Heroku

### 7. Deployowanie aplikacji

Deployowanie aplikacji odbywa się za każdym razem gdy robimy `push` do brancha `heroku` (jeżeli tak go nazwaliśmy w poprzednim poleceniu).

Przed zdeployowaniem aplikacji upewnij się, że w Twoim projekcie (w głównym katalogu) znajduje się plik `system.properties` i jest w nim określona przynajmniej wersja języka java `java.runtime.version=11`.

Aplikację deploy'ujemy poleceniem:

`git push heroku master`

które powoduje wypchnięcie wszystkich zmian z naszego lokalnego brancha `master` na lokalny/zdalny branch `heroku`. Aplikacja zostanie wtedy zrestartowana, a my w konsoli będziemy widzieli logi z jej uruchamiania.

> Przy pierwszym uruchomieniu może być dużo ściągania zależności przez maven'a, więc trzeba to przeczekać.

#### Problemy, które mogą się pojawić

Przy próbie deploy'owania możemy zostać poproszeni o podanie danych do logowania na konto `git` ale w `heroku.com`. Nie są to w żadnym wypadku dane związane z naszym kontem na `github.com`. Danych tych należy szukać w pliku `_netrc`, który powinien znajdować się w katalogu domowym użytkownika. W pliku znajdziemy login (który jest naszym loginem na konto w Heroku) oraz hasło, które jest tokenem autoryzacyjnym.

> Hasło (token autoryzacyjny) możemy też znaleźć w ustawieniach konta Heroku: [Application authorization](https://dashboard.heroku.com/account/applications)

### 8. Monitorowanie aplikacji

Naszą aplikację możemy znaleźć na dashboard'zie w heroku: [Dashboard](https://dashboard.heroku.com/apps)

Możemy ją też monitorować z poziomu konsoli (w katalogu, w którym znajduje się nasz projekt).

1. `heroku logs` wyświetli nam logi aplikacji
1. `heroku status` powie nam co słychać u naszych aplikacji
1. `heroku ps` powie nam co działa i jak wygląda zużycie przydzielonych nam zasobów
1. `heroku pg` powie nam co słychać u naszej bazy postgres (jeżeli z niej korzystamy)

---

### Linki

Zestaw linków, które mogą się przy tym wszystkim przydać:

1. [https://devcenter.heroku.com/articles/getting-started-with-java](https://devcenter.heroku.com/articles/getting-started-with-java)
1. [https://devcenter.heroku.com/articles/upgrading-to-the-latest-stack](https://devcenter.heroku.com/articles/upgrading-to-the-latest-stack)
1. [https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku](https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku)
1. [https://devcenter.heroku.com/articles/java-support](https://devcenter.heroku.com/articles/java-support)
1. [https://devcenter.heroku.com/articles/connecting-to-relational-databases-on-heroku-with-java#connecting-to-a-database-remotely](https://devcenter.heroku.com/articles/connecting-to-relational-databases-on-heroku-with-java#connecting-to-a-database-remotely)
1. [https://devcenter.heroku.com/articles/keys](https://devcenter.heroku.com/articles/keys)
1. [https://stackoverflow.com/questions/27810419/git-push-heroku-master-is-still-asking-for-authentication](https://stackoverflow.com/a/28331676/1980918)
