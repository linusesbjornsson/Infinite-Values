package com.linesb.value;

public class Attack extends AbstractValueHolder<Attack> {

    public Attack() {
        super();
    }

    public Attack(Value[] value) {
        super(value);
    }

    public Attack(int value) {
        super(value);
    }

    public Attack(int value, char suffix) {
        super(value, suffix);
    }

    public Health getAttack() {
        return ValueHolderFactory.createHealthFactory().create(clone());
    }
}
