# Fizz-Buzz App

## Clean architecture with 3 layers
- Data (for database, API and preferences code): Not implemented
- Domain (for business logic and models)
- Presentation (for UI logic, with MVVM)

## Tests
- Unit test for the class that calculate the fizz buzz sequence

## Other useful features
- View Binding: To facilitate the coding of Fragments and for null safety;
- Dependency injection (with [Hilt](http://google.github.io/hilt/))
- Android architecture components to share ViewModels during configuration changes

# To Do Notes

- Implement JetPack Compose with a study to implement the design MVI (Model - View - Intent)
- Add more unit tests and integration tests
- Add a repository to stock the data in local level (multiples, limit and words):
  - Maybe shared preferences or jetpack DataStore at the beginning
- Improve the UI design

