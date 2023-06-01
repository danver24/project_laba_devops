## В первом пункте, "Шаг 1: Настройка системы сборки и установка зависимостей", мы выполнили следующие действия:
### 1. Определили необходимую систему сборки: Maven. Это позволяет автоматизировать процесс компиляции и сборки приложения.
### 2. Произвели ее установку на нашей рабочей машине или сервере разработки с помощью команды brew install maven.
### 3. Создали файл с зависимостями: создали файл pom.xml для проекта Maven содержит список зависимостей и конфигурацию проекта. 
## Выполнили команды: 
#### 3.1 mvn archetype:generate  для генерации maven архитектуры 
#### 3.2 mvn org.apache.maven.plugins:maven-archetype-plugin:3.1.2:create-pom для создания pom файла
#### 3.3 mvp package для проверки работоспособности mvn архитектуры

## Во втором пункте, "Создание простого пайплайна сборки в GitHub Actions", мы выполнили следующие действия:

#### 1. Создали файл main.yml: Мы создали конфигурационный файл main.yml для определения пайплайна GitHub Actions. В этом файле мы определили различные шаги, которые должны быть выполнены при запуске пайплайна.

#### 2. Определили событие для запуска пайплайна: В секции on мы определили событие, которое будет запускать пайплайн. Например, мы могли указать, что пайплайн будет запускаться при каждом push в ветку main.

#### 3. Настроили окружение выполнения: В секции runs-on мы указали операционную систему, на которой будет выполняться пайплайн. Например, мы могли выбрать операционную систему Ubuntu с помощью ubuntu-latest.
#### 4. Задали шаги выполнения: В секции steps мы определили различные шаги, которые будут выполняться последовательно при запуске пайплайна. Например, мы могли добавить шаги для клонирования репозитория, установки зависимостей, выполнения сборки проекта и т.д. Например, мы использовали шаг name: Checkout code и действие uses: actions/checkout@v2 для клонирования репозитория.
#### 5. Сборка проекта: Мы добавили шаг для сборки проекта. В данном случае мы использовали команду run: mvn package для выполнения сборки проекта с помощью Maven.
#### 6. Выгрузка артефактов: Мы расширили пайплайн, добавив шаг для выгрузки артефактов после успешной сборки. Мы использовали действие actions/upload-artifact@v2 для загрузки созданного артефакта (например, JAR-файла) в качестве артефакта GitHub Actions.
### В результате мы создали простой пайплайн сборки в GitHub Actions, который выполняет сборку проекта при каждом пуше в определенную ветку и выгружает артефакты после успешной сборки. Это обеспечивает автоматизацию процесса сборки и предоставляет результаты в виде артефактов, которые могут быть использованы для дальнейшего развертывания или тестирования приложения.


