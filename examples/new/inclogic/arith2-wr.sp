variables {
    hidden int x <- IEX1;
    int a <- IEX2;
    int b <- IEX2;
    int x_out <- IEX2;
    hidden int h0 <- IEX3;
    hidden int h1 <- IEX4;
}

signatures {
    prog(x, h0, h1, x_out);
}

relations {
    pre(x, a, b);
}

language {
    boolean B0 -> B ;
    boolean B -> false | AP | AP && AP;

    boolean AP -> L < R | L <= R | L > R | L >= R | L == R;
    int L -> x_out;
    int R -> N | N + N | N + N + N;
    int N -> a | b | 0 | 1;
}

examples {
    int IEX1 -> ??(3) | -??(3) ;
    int IEX2 -> ??(3) | -??(3) ;
    int IEX3 -> 1 | 2;
    int IEX4 -> ??(1);
    boolean BEX -> ??(1);
}