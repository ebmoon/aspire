variables {
    int i1;
    boolean h1;
    int o1;
    hidden RandomBits H1;
    int i2;
    boolean h2;
    int o2;
    hidden RandomBits H2;
}

signatures {
    controller(i1, h1, H1, o1);
    controller(i2, h2, H2, o2);
}

language {
    boolean B0 -> !(i1 == i2) || B;
    boolean B -> true | AP | AP || AP;
    boolean AP -> I == I | I != I;
    int I -> i1 | o1 | i2 | o2;
}

examples {
    int IEX -> ??(8);
    boolean BEX -> ??(1);
    RandomBits RBEX -> genRandomBits();
}