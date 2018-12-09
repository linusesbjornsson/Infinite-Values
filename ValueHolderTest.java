package com.linesb.value;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by linus on 2018-03-07.
 */
public class ValueHolderTest {

    @Test
    public void addValue() throws Exception {
        Gold gold = ValueHolderFactory.createGoldFactory().create(5000);
        gold.addValue(ValueHolderFactory.createGoldFactory().create(200000));
        Assert.assertTrue(gold.toString().equals("205K"));
    }

    @Test
    public void removeValue() throws Exception {
        Gold gold = ValueHolderFactory.createGoldFactory().create(5000);
        gold.removeValue(ValueHolderFactory.createGoldFactory().create(200));
        Assert.assertTrue(gold.toString().equals("4,800"));
    }

}