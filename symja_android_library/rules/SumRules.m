{
  {

    Sum(c_^i_, {i_Symbol,1,Infinity}) := -c*(c-1)^(-1)
    /; FreeQ(c,i) && (!NumberQ(c) || (c>(-1) && c<1)),

Sum(i_^k_Symbol, {i_Symbol,1,n_Symbol}) := HarmonicNumber(n, -k)
/; FreeQ(k,i)&&FreeQ(n,i),

Sum(i_^k_, {i_Symbol,1,Infinity}) := Zeta(-k)
    /; FreeQ(k,i),
Sum(1/(i_^k_), {i_Symbol,1,Infinity}) := Zeta(k)
    /;  FreeQ(k,i),

Sum(k_^(a_.*i_), {i_Symbol,1,Infinity}) := -(k^a)/(-1+(k^a))
    /; FreeQ(k,i) && a<0 && (k>1 || k<(-1)),

Sum(Ceiling(Log(i_)), {i_Symbol,1,n_Symbol}):=
( Floor(Log(n))*E^(Floor(Log(n))+1)-(Floor(Log(n))+1)*E^Floor(Log(n))+1 ) * (E-1)^(-1) + (n-E^Floor(Log(n)))*Ceiling(Log(n))
    /; FreeQ(n,i),

Sum(Ceiling(Log(i_)/Log(a_)), {i_Symbol,1,n_Symbol}):=
( Floor(Log(a,n))*a^(Floor(Log(a,n))+1)-(Floor(Log(a,n))+1)*a^Floor(Log(a,n))+1 ) * (a-1)^(-1) + (n-a^Floor(Log(a,n)))*Ceiling(Log(a,n))
/; FreeQ(a,i)&&FreeQ(n,i),


Sum(x_^(2*i_+1)/(2*i_+1)!, {i_Symbol,0,Infinity}) := Sinh(x)
    /;  FreeQ(x,i),
Sum((-1)^i_*x_^(2*i_+1)/(2*i_+1)!, {i_Symbol,0,Infinity}) := Sin(x)
    /;  FreeQ(x,i),
Sum(x_^(2*i_)/(2*i_)!, {i_Symbol,0,Infinity}) := Cosh(x)
    /;  FreeQ(x,i),
Sum((-1)^i_*x_^(2*i_)/(2*i_)!, {i_Symbol,0,Infinity}) := Cos(x)
    /;  FreeQ(x,i),
Sum((-1)^i_*x_^(2*i_+1)/(2*i_+1), {i_Symbol,0,Infinity}) := ArcTanh(x)
    /;  FreeQ(x,i),
Sum(1/(i_!), {i_Symbol,0,Infinity}) := E
    /;  FreeQ(x,i),
Sum(x_^i_/(i_!), {i_Symbol,0,Infinity}) := E^x
    /;  FreeQ(x,i),

Sum(1/Binomial(2*i_,i_), {i_Symbol,1,Infinity}) :=  (2*Pi*Sqrt(3)+9)/27,
Sum(1/i_*1/Binomial(2*i_,i_), {i_Symbol,1,Infinity}) :=  (Pi*Sqrt(3))/9,
Sum(1/i_^2*1/Binomial(2*i_,i_), {i_Symbol,1,Infinity}) :=  Zeta(2)/3,
Sum((-1)^(i_-1)/i_, {i_Symbol,1,Infinity}) := Log(2)

},{

  Sum(i_^c_, {i_Symbol,0,n_Symbol}) := 0^c + HarmonicNumber(n, -c)
/;  FreeQ({c,n},i),

Sum(c_^i_, {i_Symbol,0,n_Symbol}) := (-1 + c^(1 + n))/(-1 + c)
    /; FreeQ({c,n},i),


Sum(i_*c_^i_, {i_Symbol,0,n_Symbol}) := (c + c^(1 + n)*(-1 - n + c*n))/(1 - c)^2
    /;  FreeQ({c,n},i),

Sum(Binomial(n_, i_), {i_Symbol,0,n_Symbol}) := 2^n
    /; FreeQ(n,i),

Sum(i_*Binomial(n_, i_), {i_Symbol,0,n_Symbol}) := n*2^(n-1)
    /; FreeQ(n,i),

Sum(i_!, {i_Symbol,0,n_Symbol}):=
Gamma(n+2)*(-1)^(n+1)*Subfactorial(-n-2)-Subfactorial(-1)
    /; FreeQ(n,i)

}
}