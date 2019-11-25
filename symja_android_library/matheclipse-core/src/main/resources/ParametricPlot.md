## ParametricPlot

```
ParametricPlot({function1, function2}, {t, tMin, tMax})  
```

> generate a JavaScript control for the parametric expressions `function1`, `function2` in the `t` range `{t, tMin, tMax}`.
	 
**Note**: This feature is available in the console app and in the web interface.

### Examples

In the console apps, this command shows an HTML page with a JavaScript parametric plot control.
 
```
>> ParametricPlot({Sin(t), Cos(t^2)}, {t, 0, 2*Pi}) 
```

With `JSForm` you can display the generated JavaScript form of the `ParametricPlot` function

```
>> ParametricPlot({Sin(t), Cos(t^2)}, {t, 0, 2*Pi}) // JSForm
```

### Related terms 
[JSForm](JSForm.md) [Manipulate](Manipulate.md) [Plot](Plot.md) [Plot3D](Plot3D.md)