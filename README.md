# AutoStates-Android
Attempt at making views more stateful by autogenerating drawables and colors

### Apply states
The idéa is that missing states (like pressed and disabled) can be generated from default state.
Generate and set missing states:
```java
Button button = (Button)findViewById(R.id.button);
AutoState.apply(button);
```

### Exameple
Following views have only one background drawable and one text color by default. The other states are generated.

![alt text](https://raw.githubusercontent.com/simonedstromsi/AutoStates-Android/master/assets/sample.png)
