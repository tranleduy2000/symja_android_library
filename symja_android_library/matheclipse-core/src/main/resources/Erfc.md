## Erfc

```
Erfc(z)
```

> returns the complementary error function of `z`.

See
* [Wikipedia - Error function - Complementary error function](https://en.wikipedia.org/wiki/Error_function#Complementary_error_function)
* [Fungrim - Error functions](http://fungrim.org/topic/Error_functions/)

### Examples

`Erf(z)` is an odd function:

```
>> Erfc(-x) / 2    
1/2*(2-Erfc(x))   
 
>> Erfc(1.0)
0.15729920705028488
 
>> Erfc(0)    
1    
```