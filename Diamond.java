package com.linesb.value;

public class Diamond extends AbstractCurrency<Diamond> {

    public Diamond() {
        super();
    }

    public Diamond(Value[] value) {
        super(value);
    }

    public Diamond(int value) {
        super(value);
    }

    public Diamond(int value, char suffix) {
        super(value, suffix);
    }

    @Override
    public CurrencyType getType() {
        return CurrencyType.DIAMOND;
    }

}
