# WeatherApp

WeatherApp is a sample Android application that uses the clean MVVM architecture approach and is written in Kotlin.

### Used libraries: ###
- `HILT` - used for dependency injection.
- `ViewModel` - handles data updates and configuration changes.
- `Retrofit` - is used for network calls.
- `Coroutine` - is useful to handle threading.
- `Room` - is used for data caching.

#### The app has following packages:
1. `data`: It contains all the data accessing classes.
2. `di`: Dependency providing classes using HILT.
3. `presentation`: Activity and fragment classes to show weather details along with their corresponding ViewModel.
4. `domain`: Domain has single responsibility usecases and interfaces of data layer.

#### Testing
Written unit test cases for mappers, repository and database.

#### TODO
- ViewModel test cases are not written.
- UI test cases are not written.

| Requirement                  | Status |   
| :--------------------------: | :----: | 
| Kotlin Used                  | &check;|
| DI                           | &check;|
| Unit test cases              | &check;|
| Data caching                 | &check;|
| Build variants               | &check;|
| Multi modular architecture   | &cross;| 
| Display weather data         | &check;|
| List of weather data         | &check;|
| Search another city          | &cross;|  
| Add city to favourite list   | &cross;|
| View favourite city list     | &cross;|
| Change °C to °F              | &cross;|
| Import/Export csv file       | &cross;|
| Weather notification at 6 AM | &cross;|
| View list of favourite cities| &cross;|
