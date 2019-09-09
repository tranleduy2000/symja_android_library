## Plot3D

```
Plot3D(function, {x, xMin, xMax}, {y,yMin,yMax})  
```

> generate a JavaScript control for the expression `function` in the `x` range `{x, xMin, xMax}` and `{yMin, yMax}` in the `y` range.
	 
**Note**: This feature is available in the console app and in the web interface.

### Examples

In the console apps, this command shows an HTML page with a JavaScript of a 3D surface plot control:

```
>> Plot3D(Sin(x*y), {x, -1.5, 1.5}, {y, -1.5, 1.5}) 
```  

With `JSForm` you can display the generated JavaScript form of the `Manipulate` function

```
>> Plot3D(Sin(x*y), {x, -1.5, 1.5}, {y, -1.5, 1.5}) // JSForm
```

### Related terms 
[JSForm](JSForm.md) [Manipulate](Manipulate.md) [Plot](Plot.md)