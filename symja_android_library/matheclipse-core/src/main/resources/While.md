## While

```
While(test, body)
```
> evaluates `body` as long as test evaluates to `True`.
 
```
While(test)
```
> runs the loop without any body.

### Examples

Compute the GCD of two numbers:

```
>> {a, b} = {27, 6};
>> While(b != 0, {a, b} = {b, Mod(a, b)});
>> a
3
 
>> i = 1; While(True, If(i^2 > 100, Return(i + 1), i++))
12
```

### Related terms 
[Break](Break.md), [Continue](Continue.md), [Do](Do.md), [For](For.md) 