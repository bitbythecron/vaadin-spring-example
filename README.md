# vaadin-spring-example
Trying to get Vaadin and Spring Boot to play nicely with each other.

## Running Locally
```
./gradlew clean bootJar && java -Dspring.config=. -jar build/libs/vaadin-spring-example.jar
```

## Requirements
```
1 main screen/landing page w/ 2 tabs (tabbed panes) and a carousel
also a link to an About page
everything in i18n
routing: clicking the tab and going from Landing <-> About gets added to browser route History and you can toggle forward/
  backward with it

1 tab manages Powers (CRUD) and works with a backend servlet to actually update H2
1 tab manages Supers and CRUDs them based on available Powers
All CRUD operations are ajax under the hood
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