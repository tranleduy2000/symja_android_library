{

StruveH(-1/2,z_):=Sqrt(2/(Pi*z))*Sin(z), 
StruveH(1/2,z_):=Sqrt(2/(Pi*z))*(1-Cos(z)),

StruveH(Undefined, y_):=Undefined,
StruveH(x_, Undefined):=Undefined
}