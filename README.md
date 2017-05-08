# AutoStates-Android
Attempt at making views more stateful by autogenerating drawables and colors

### Apply states
The idéa is that missing states (like pressed and disabled) can be generated from default state.
Generate and set default states on a view:
```java
  AutoState.apply(button)
```

### Exameple
![alt text](https://raw.githubusercontent.com/simonedstromsi/AutoStates-Android/master/assets/sample.png)
