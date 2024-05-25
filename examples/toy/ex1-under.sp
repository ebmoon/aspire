variables {
    int x;
    hidden int h;
    int xout;
}

signatures {
    f(x, h, xout);
}

language {
    boolean AP -> N < C | N == C | N <= C | N != C | N > C | N >= C;
    int N -> I | I + I | I - I;
    int I -> x | xout;
    int C -> 0 | 1 | 2;
}

examples {
    int IEX -> ??(4);
    boolean BEX -> ??(1);
}
