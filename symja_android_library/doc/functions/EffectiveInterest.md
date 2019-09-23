## EffectiveInterest

```
EffectiveInterest(i, n)
```

> returns an effective interest rate object.
  

See:
* [Wikipedia - Annuity](https://en.wikipedia.org/wiki/Effective_interest_rate)
 
### Examples

```
>> TimeValue(Annuity(100, 12), EffectiveInterest(.01, 0.25), 12)
1268.515
```

### Related terms 
[Annuity](Annuity.md), [AnnuityDue](AnnuityDue.md), [TimeValue](TimeValue.md)