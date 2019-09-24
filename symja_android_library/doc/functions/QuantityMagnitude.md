## QuantityMagnitude

```
QuantityMagnitude(quantity)
```

> returns the value of the `quantity` 


```
QuantityMagnitude(quantity, unit)
```

> returns the value of the `quantity` for the given `unit`

See 
* [Wikipedia - International System of Units](https://en.wikipedia.org/wiki/International_System_of_Units)

### Examples

Convert from degrees to radians

```
>> QuantityMagnitude(Quantity(360, "deg"), "rad")
2*Pi
```
