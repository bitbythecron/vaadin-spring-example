# vaadin-spring-example
Trying to get Vaadin and Spring Boot to play nicely with each other.

## Running Locally
```
./gradlew clean bootJar && java -Dspring.config=. -jar build/libs/vaadin-spring-example.jar
```

## Requirements
```
- layout issue with Supers tab
- ajax issue w/ Supers tab & DataService
- i18n
- routing & history API
```

### Notes
```
You have the Views which are the things that describe what UI controls exist and how to lay them out:
    - This could be an entire Page or Screen
    - Or could be a reusable Widget (set of controls on some kind of container or layout)
    
You have the Styles which dictate the look and feel of the Views

You have EventListeners that execute when the user interacts with a Control or Widget

ui
    screens
    widgets
styles
listeners
resources
services

controls should send AJAX calls to REST Endpoints (resources)

since we'll be injecting EVERY control and listener into a view, we will need a decentralized configuration suite
    probably a spring.inject package where we decompose @Beans by view
```