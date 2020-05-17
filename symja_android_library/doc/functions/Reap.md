## Reap

```
Reap(expr)
```

> gives the result of evaluating `expr`, together with all values sown during this evaluation. Values sown with different tags are given in different lists.

### Examples

```
>> Reap(Sow(3); Sow(1))
{1,{{3,1}}}
```

[OEIS - A020652](https://oeis.org/A020652):

```
>> Reap(Do(If(GCD(num, den) == 1, Sow(num)), {den, 1, 20}, {num, 1, den-1}) )[[2, 1]] 
{1,1,2,1,3,1,2,3,4,1,5,1,2,3,4,5,6,1,3,5,7,1,2,4,5,7,8,1,3,7,9,1,2,3,4,5,6,7,8,9,
10,1,5,7,11,1,2,3,4,5,6,7,8,9,10,11,12,1,3,5,9,11,13,1,2,4,7,8,11,13,14,1,3,5,7, 
9,11,13,15,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,1,5,7,11,13,17,1,2,3,4,5,6,7,8,
9,10,11,12,13,14,15,16,17,18,1,3,7,9,11,13,17,19}
```

### Related terms
[Sow](Sow.md) 
