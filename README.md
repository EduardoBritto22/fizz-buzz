# Fizz-Buzz App

The original fizz-buzz consists in writing all numbers from 1 to 100, and just replacing :

all multiples of 3 by "fizz",
all multiples of 5 by "buzz",
and all multiples of 15 by "fizzbuzz".

The output would look like this: "1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz, 16, ...".

[first screen] Have a form that accepts five parameters : two integers int1 and int2, one long limit, and two strings str1 and str2.

[second screen] Display a scrollable screen with a list of strings with numbers from 1 to limit, where: all multiples of int1 are replaced by str1, all multiples of int2 are replaced by str2, all multiples of int1 and int2 are replaced by str1str2.

![fizzbuzz](https://user-images.githubusercontent.com/31722494/216072273-acf7d7f2-3700-466d-9e95-62da4e6f1ba3.gif)



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

