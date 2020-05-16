## Correlation

```
Correlation(a, b)
```

> computes Pearson's correlation of two equal-sized vectors `a` and `b`.

See:
* [Wikipedia - Pearson correlation coefficient](https://en.wikipedia.org/wiki/Pearson_correlation_coefficient)

### Examples

```
>> Correlation({a,b},{c,d})
((a-b)*(Conjugate(c)-Conjugate(d)))/(Sqrt((a-b)*(Conjugate(a)-Conjugate(b)))*Sqrt((c-d)*(Conjugate(c)-Conjugate(d))))
				
>> Correlation({10, 8, 13, 9, 11, 14, 6, 4, 12, 7, 5}, {8.04, 6.95, 7.58, 8.81, 8.33, 9.96, 7.24, 4.26, 10.84, 4.82, 5.68})
0.81642
```

