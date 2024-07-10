# Инструкция по запуску программы.

1. **Скачать проект**

   Перейти в нужную папку, выкачать ветку:

    ```sh
    git clone -b feature/entry-core https://github.com/balticano05/Check.git
    ```

2. **Перейти в директорию проекта**

   Используйте терминал и команду, перейти в директорию проекта:

    ```sh
    cd путь к папке
    ```

3. **Сборка приложения**

    Собрать проект следующие командой:

    ```sh
    .\gradlew build
    ```

4. **Запуск программы**

   Используйте следующую команду для запуска приложения:

    ```sh
    java -jar CheckRunner.java id-quantity discountCard=xxxx balanceDebitCard=xxxx
    ```

   Где:
    - `id-quantity` - номер товара и его количество.
    - `discountCard=xxxx` - номер дисконтной карты.
    - `balanceDebitCard=xxxx` - баланс на расчётной карте.


   #### Пример запуска

    ```sh
    java -jar CheckRunner.jar 3-2 2-4 5-2 discountCard=1121 balanceDebitCard=100.85
    ```