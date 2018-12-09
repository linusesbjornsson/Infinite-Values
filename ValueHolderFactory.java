package com.linesb.value;

/**
 * Created by linus on 2018-02-26.
 */
public class ValueHolderFactory<T extends ValueHolder<?>> {

    private final FactoryType type;

    private ValueHolderFactory(FactoryType type) {
        this.type = type;
    }

    public T create() {
        return create(0);
    }

    public T create(int value) {
        return create(value, Character.MIN_VALUE);
    }

    public T create(Value[] value) {
        switch (type) {
            case HEALTH:
                return (T) new Health(value);
            case ATTACK:
                return (T) new Attack(value);
            case DEFENSE:
                return (T) new Defense(value);
            case HEALING:
                return (T) new Healing(value);
            case GOLD:
                return (T) new Gold(value);
            default:
                return (T) new DefaultValue(value);
        }
    }

    @SuppressWarnings("unchecked")
    public T create(int value, char suffix) {
        switch (type) {
            case HEALTH:
                return (T) new Health(value, suffix);
            case ATTACK:
                return (T) new Attack(value, suffix);
            case DEFENSE:
                return (T) new Defense(value, suffix);
            case HEALING:
                return (T) new Healing(value, suffix);
            case GOLD:
                return (T) new Gold(value);
            default:
                return (T) new DefaultValue(value, suffix);
        }
    }

    private enum FactoryType {
        DEFAULT,
        GOLD,
        HEALTH,
        ATTACK,
        DEFENSE,
        HEALING
    }

    public static ValueHolderFactory<DefaultValue> createDefaultValue() {
        return new ValueHolderFactory<DefaultValue>(FactoryType.DEFAULT);
    }

    public static ValueHolderFactory<Gold> createGoldFactory() {
        return new ValueHolderFactory<Gold>(FactoryType.GOLD);
    }

    public static ValueHolderFactory<Health> createHealthFactory() {
        return new ValueHolderFactory<Health>(FactoryType.HEALTH);
    }

    public static ValueHolderFactory<Attack> createAttackFactory() {
        return new ValueHolderFactory<Attack>(FactoryType.ATTACK);
    }

    public static ValueHolderFactory<Defense> createDefenseFactory() {
        return new ValueHolderFactory<Defense>(FactoryType.DEFENSE);
    }
    
    public static ValueHolderFactory<Healing> createHealingFactory() {
        return new ValueHolderFactory<Healing>(FactoryType.HEALING);
    }

}
