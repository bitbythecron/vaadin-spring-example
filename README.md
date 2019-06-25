# vaadin-spring-example
Trying to get Vaadin and Spring Boot to play nicely with each other.

## Running Locally
```
./gradlew clean bootRepackage && java -Dspring.config=. -jar build/libs/vaadin-spring-example.jar
```

### Error at startup
```
17:37:31.209 [main] WARN  o.s.boot.SpringApplication - Unable to close ApplicationContext
java.lang.reflect.MalformedParameterizedTypeException: null
	at sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl.validateConstructorArguments(ParameterizedTypeImpl.java:58)
	at sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl.<init>(ParameterizedTypeImpl.java:51)
	at sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl.make(ParameterizedTypeImpl.java:92)
	at sun.reflect.generics.factory.CoreReflectionFactory.makeParameterizedType(CoreReflectionFactory.java:105)
	at sun.reflect.generics.visitor.Reifier.visitClassTypeSignature(Reifier.java:140)
	at sun.reflect.generics.tree.ClassTypeSignature.accept(ClassTypeSignature.java:49)
	at sun.reflect.generics.repository.MethodRepository.getReturnType(MethodRepository.java:68)
	at java.lang.reflect.Method.getGenericReturnType(Method.java:255)
	at org.springframework.core.MethodParameter.getGenericParameterType(MethodParameter.java:382)
	at org.springframework.core.SerializableTypeWrapper$MethodParameterTypeProvider.getType(SerializableTypeWrapper.java:337)
	at org.springframework.core.SerializableTypeWrapper.forTypeProvider(SerializableTypeWrapper.java:149)
	at org.springframework.core.ResolvableType.forType(ResolvableType.java:1346)
	at org.springframework.core.ResolvableType.forMethodParameter(ResolvableType.java:1249)
```
