variables {
    int x;
    int a;
    int b;
    hidden boolean h;
    hidden boolean x_out;
    boolean ok;
}

signatures {
    flip(x, a, b, h, x_out);
}

relations {
    post(x_out, a, b);
}

language {
    boolean B0 ->  B ;
    boolean B -> false | AP | AP && AP
                | AP && AP && AP
                | AP && AP && AP && AP
                | AP && AP && AP && AP && AP
                | AP && AP && AP && AP && AP && AP;
    boolean AP -> N < N | N <= N | N == N | N != N | is_pos(N);
    int N -> N0 | -N0;
    int N0 -> x | a | b | 0 ;
}

examples {
    int IEX -> ??(3) | -??(3);
    boolean BEX -> ??(1);
}