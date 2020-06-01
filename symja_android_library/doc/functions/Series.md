## Series

```
Series(expr, {x, x0, n})
```

> create a power series of `expr` up to order `(x- x0)^n` at the point `x = x0`

See:
* [Wikipedia - Taylor series](https://en.wikipedia.org/wiki/Taylor_series)
* [Wikipedia - Big O notation](https://en.wikipedia.org/wiki/Big_O_notation)

### Examples

```
>> Series(f(x),{x,a,3})  
f(a)+f'(a)*(-a+x)+1/2*f''(a)*(-a+x)^2+1/6*Derivative(3)[f][a]*(-a+x)^3+O(-a+x)^4
```
				
The [A053614 Numbers that are not the sum of distinct triangular numbers. ](https://oeis.org/A053614) integer sequence

```
>> nn=10; t=Rest(CoefficientList(Series(Product((1+x^(k*(k+1)/2)), {k, nn}), {x, 0, nn*(nn+1)/2}), x)); Flatten(Position(t, 0))
{2,5,8,12,23,33}
```
