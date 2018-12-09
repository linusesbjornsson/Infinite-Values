package com.linesb.value;

import com.dungeon.clickers.Formatter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linus on 2018-02-26.
 *
 * @param <T>
 */
public class AbstractValueHolder<T extends ValueHolder<?>> implements ValueHolder<T>, Cloneable {

    private Value[] value;

    public AbstractValueHolder() {
        value = ValueFactory.createValue();
    }

    public AbstractValueHolder(Value[] value) {
        this.value = value;
    }

    public AbstractValueHolder(int value) {
        this.value = ValueFactory.createValue(value);
    }

    public AbstractValueHolder(int value, char suffix) {
        this.value = ValueFactory.createValue(value, suffix);
    }

    @Override
    public boolean addValue(T value) {
        for (int i = this.value.length - 1; i >= 0; i--) {
            int valueHolderValue = value.getValue()[i].getValue();
            if (valueHolderValue > 0) {
                int rest = this.value[i].addValue(valueHolderValue);
                if (rest > 0) {
                    int j = i;
                    if (j + 1 < this.value.length - 1) {
                        j++;
                        while (j < this.value.length - 1 && rest > 0) {
                            rest = this.value[j].addValue(rest);
                            j++;
                        }
                        return rest == 0;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean removeValue(T value) {
        for (int i = this.value.length - 1; i >= 0; i--) {
            int valueHolderValue = value.getValue()[i].getValue();
            if (valueHolderValue > 0) {
                int rest = this.value[i].removeValue(valueHolderValue);
                if (rest > 0) {
                    if (i + 1 >= this.value.length - 1 || this.value[i + 1].getValue() == 0) {
                        this.value[i].setValue(0);
                        while (i >= 0) {
                            this.value[i].setValue(0);
                            i--;
                        }
                        return false;
                    }
                    int j = i;
                    if (j + 1 < this.value.length) {
                        j++;
                        while (j < this.value.length - 1 && rest > 0) {
                            if (this.value[j].getValue() > 0) {
                                rest = this.value[j].removeValue(rest);
                                if (j + 1 >= this.value.length - 1) {
                                    this.value[j].setValue(0);
                                }
                                j++;
                            } else {
                                rest = 0;
                            }
                        }
                        if (rest > 0) {
                            while (i >= 0) {
                                this.value[i].setValue(0);
                                i--;
                            }
                        }
                        return rest == 0;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T setValue(int value, char suffix) {
        Value localValue = getValue(suffix);
        if (localValue != null) {
            localValue.setValue(value);
        }
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T setValue(T value) {
        this.value = value.getValue();
        return (T) this;
    }

    @Override
    public Value[] getValue() {
        return value;
    }

    @Override
    public Value getValue(char suffix) {
        Value[] value = getValue();
        for (Value v : value) {
            if (v.getSuffix() == suffix) {
                return v;
            }
        }
        return null;
    }

    @Override
    public Value getMaxValue() {
        for (int i = value.length - 1; i >= 0; i--) {
            if (value[i].getValue() > 0) {
                return value[i];
            }
        }
        return value[0];
    }

    @Override
    public String toString() {
        Formatter formatter = new ValueHolderFormatter(this);
        return formatter.format();
    }

    @Override
    public int compareTo(T valueHolder) {
        for (int i = value.length - 1; i >= 0; i--) {
            int thisValue = value[i].getValue();
            int valueHolderValue = valueHolder.getValue()[i].getValue();
            if (thisValue > valueHolderValue) {
                return 1;
            } else if (valueHolderValue > thisValue) {
                return -1;
            } else if (thisValue == valueHolderValue) {
                if (i == 0) {
                    return 0;
                }
            }
        }
        return -1;
    }

    @Override
    public Value[] clone() {
        List<Value> newValues = new ArrayList<Value>();
        for (Value singleValue : value) {
            newValues.add(singleValue.clone());
        }
        return newValues.toArray(new Value[newValues.size()]);
    }
}
