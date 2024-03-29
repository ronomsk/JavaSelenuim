package ru.raif.cources.structure;

public class ValueParams {
    public static void main(String[] args) {
        metod1(n); //значение переменной n останется = 10;

        ValueParams a = new ValueParams();
        metod2(a); //значение переменной n станет = 12;

        a.l = 3;
        ValueParams b = new ValueParams();
        b.l = 6;
        metod4(a, b); //значение a.l останется = 3, b.l останется = 6;
    }

    public static void metod1(int _n) {
        _n = _n * 3; //значение переменной _n станет = 30, но _n удалится после завершения работы метода;
    }

    public static void metod2(ValueParams _a) {
        _a.metod3(2); //изменяет состояние объекта, на который ссылаются как переменая _a, так и переменная a;
    }

    public void metod3(int _p) {
        n = n + _p; //увеличивает значение переменной n на _p;
    }

    private static void metod4(ValueParams _a, ValueParams _b) {
        ValueParams temp = _a;
        _a = _b; //значение _a.l теперь = 6;
        _b = temp; //значение _b.l теперь = 3;
//по завершении метода переменные _a и _b уничтожаются;
    }

    private static int n = 10;
    private int l;
}
