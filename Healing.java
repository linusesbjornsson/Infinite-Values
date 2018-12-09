package com.linesb.value;

public class Healing extends AbstractValueHolder<Healing> {

    public Healing() {
        super();
    }

    public Healing(Value[] value) {
        super(value);
    }

    public Healing(int value) {
        super(value);
    }

    public Healing(int value, char suffix) {
        super(value, suffix);
    }

    public Health getHealing() {
        return ValueHolderFactory.createHealthFactory().create(clone());
    }

}
