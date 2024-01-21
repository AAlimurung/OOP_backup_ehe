package Elementals;

interface Conductive {
    float percent_c();
}

interface Radioactive {
    void hanyo(); //halflife
}
interface Magnetic {
    int magn_strength();
    Type magn_type();
}
enum Type {
    ferromagnetic, paramagnetic;
}
