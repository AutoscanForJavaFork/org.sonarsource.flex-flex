function func1(p1, p2, p3, p4, p5, p6, p7) { // Noncompliant {{This function has 7 parameters, which is greater than the 4 authorized.}}
}

function func2(p1, p2, p3, p4, p5, p6, p7, ...p8) { // Noncompliant {{This function has 8 parameters, which is greater than the 4 authorized.}}
}
