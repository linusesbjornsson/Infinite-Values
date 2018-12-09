package com.linesb.value;

public class Gold extends AbstractCurrency<Gold> {

    public Gold() {
        super();
    }

    public Gold(Value[] value) {
        super(value);
    }

    public Gold(int value) {
        super(value);
    }

    public Gold(int value, char suffix) {
        super(value, suffix);
    }

    @Override
    public CurrencyType getType() {
        return CurrencyType.GOLD;
    }

}
