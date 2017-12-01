Searching by keyword

Scenario: Поиск по коду страны
Given У меня есть код страны [countryCode]
When Я выполняю поиск страны с помощью кода
Then Поиск должен завершиться успешно
And Я должен найти страну [countryName]

Examples:
|countryCode|countryName|
|RU|Russian Federation|
|US|United States of America|
