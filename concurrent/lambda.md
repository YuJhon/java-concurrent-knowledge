```java
List<User> ts = new ArrayList(100);
Stream<String> stringStream = ts.stream().map(user -> user.getId());
```