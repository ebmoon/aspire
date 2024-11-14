variables {
    int x <- IEX1;
    int a <- IEX2;
    int b <- IEX2;
    hidden int h0 <- IEX3;
    hidden int h1 <- IEX4;
    hidden int x_out <- IEX2;
}

signatures {
    prog(x, h0, h1, x_out);
}

relations {
    post(x_out, a, b);
}

language {
    boolean B -> false | AP | AP && AP;
    boolean AP -> N < N | N <= N | N == N;
    int N -> N0 | N0 + N0 | N0 - N0;
    int N0 -> x | a | b | 0 | 1 ;
}

examples {
    int IEX1 -> ??(3) | -??(3);
    int IEX2 -> ??(3) | -??(3);
    int IEX3 -> 1 | 2;
    int IEX4 -> 0 | 1;
    boolean BEX -> ??(1);
}