//@Description Toy benchmarks to show complex recursive generators.

variables {
    int x;
    int o;
}

signatures {
    sum(x, o);
}

language {
    boolean B -> false | AP | AP && AP | AP && AP && AP;
    boolean AP -> I < I | I <= I | I == I | I != I ;
    int I -> x | -x | o | -o | 0 | 1 ;
}

examples {
    int IEX -> ??(5) ;
}

