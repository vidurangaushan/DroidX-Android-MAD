package com.example.droidx_mad;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCalc {

    private Confirm_payment confirm_payment;
    @BeforeEach
    public  void setup(){
        confirm_payment = new Confirm_payment();
    }

    @Test
    public void testmultiply(){
        float results = confirm_payment.multiply(2, 998.5F);
        assertEquals(1997.0, results);
    }
}
