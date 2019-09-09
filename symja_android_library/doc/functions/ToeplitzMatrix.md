## ToeplitzMatrix

``` 
ToeplitzMatrix(n)
```

> gives a toeplitz matrix with the dimension `n`.

``` 
ToeplitzMatrix(vector)
```

> gives a toeplitz matrix of the elements of `vector`.

### Examples
 
```
>> ToeplitzMatrix(3)
{{1,2,3},
 {2,1,2},
 {3,2,1}}

>> ToeplitzMatrix({1, 2, 3, 4, 5, 6}, {1, a, b, c})
{{1,a,b,c},
 {2,1,a,b},
 {3,2,1,a},
 {4,3,2,1},
 {5,4,3,2},
 {6,5,4,3}}
 
 >> ToeplitzMatrix({1, a, b, c}, {1, 2, 3, 4, 5, 6})
{{1,2,3,4,5,6},
 {a,1,2,3,4,5},
 {b,a,1,2,3,4},
 {c,b,a,1,2,3}}
```