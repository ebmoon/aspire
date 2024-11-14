 variables {
    hidden int x;
    int a;
    int b;
    int x_out;
    hidden boolean h;
}

signatures {
    flip(x, h, x_out);
}

relations {
    pre(x, a, b);
}

language {
    boolean B0 -> B;
    boolean B -> false | AP | AP && AP
                | AP && AP && AP
                | AP && AP && AP && AP
                | AP && AP && AP && AP && AP
                | AP && AP && AP && AP && AP && AP;
    boolean AP -> N < N | N <= N | N == N | N != N | is_pos(N);
    int N -> N0 | -N0;
    int N0 -> x_out | a | b | 0 ;
}

examples {
    int IEX -> ??(3) | -??(3);
    boolean BEX -> ??(1);
}