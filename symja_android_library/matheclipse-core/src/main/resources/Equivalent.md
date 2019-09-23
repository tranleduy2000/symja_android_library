## Equivalent

```
Equivalent(arg1, arg2, ...)
```

>  Equivalence relation. `Equivalent(A, B)` is `True` iff `A` and `B` are both `True` or both `False`. Returns `True` if all of the arguments are logically equivalent. Returns `False` otherwise. `Equivalent(arg1, arg2, ...)` is equivalent to `(arg1 && arg2 && ...) || (!arg1 && !arg2 && ...)`.

### Examples

```
>> Equivalent(True, True, False)
False

>> Equivalent(x, x && True)
True
```

If all expressions do not evaluate to `True` or `False`, `Equivalent` returns a result in symbolic form:

```
>> Equivalent(a, b, c)
Equivalent(a,b,c)
```

Otherwise, `Equivalent` returns a result in DNF

```
>> Equivalent(a, b, True, c)
a && b && c
>> Equivalent()
True
>> Equivalent(a)
True
 ```