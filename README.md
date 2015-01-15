# slowpoke-arithmetics
Support of arithmetics for very big numbers

This library theoretically may support arithmetics for numbers with any number of digits, 
even thousands or millions (the number of digits is limited by abilities of client's JVM). 
This is simple implementation of school arithmetics rules and nothing more.

This library is named "Slowpoke" in honor of famous pokemon and because it's implementation is really slow and ugly, 
because author have not mattered about performance, memory consumption and multithreading in the 1st version. 
But real problem will be exposed by future stress tests.

How to use it?

Very simple:

String addResultStr = VeryBigNumber.add( arg1Str, arg2Str );
String subResultStr = VeryBigNumber.sub( arg1Str, arg2Str );
String mulResultStr = VeryBigNumber.mul( arg1Str, arg2Str );
int precision = 3;  // extra digits after calculation
String divResultStr = VeryBigNumber.div( arg1Str, arg2Str, precision );

In every case if argument is not parsable decimal number, it is treated as zero.
If you try to divide by zero, method throws an exception.
Precision is the maximum number of additional digits, that may be added during division action. 
It's implemented in order to avoid possibly division period.


January 15, 2015

