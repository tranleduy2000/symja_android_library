## Inner

```
Inner(f, x, y, g)
```

> computes a generalized inner product of `x` and `y`, using a multiplication function `f` and an addition function `g`.

See
* [Wikipedia - Inner product space](https://en.wikipedia.org/wiki/Inner_product_space)

### Examples

```
>> Inner(f, {a, b}, {x, y}, g)
g(f(a, x), f(b, y))
```

'Inner' can be used to compute a dot product:

```
>> Inner(Times, {a, b}, {c, d}, Plus) == {a, b} . {c, d}
```

The inner product of two boolean matrices:

```
>> Inner(And, {{False, False}, {False, True}}, {{True, False}, {True, True}}, Or)
{{False, False}, {True, True}}
```
 