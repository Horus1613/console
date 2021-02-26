package ru.horus.console.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OffsetTest {

    @Test
    void isValidForManual() {
        Offset goodOffset = new Offset(-1, 0, 0);
        assertTrue(goodOffset.isValidForManual());

        Offset badOffset = new Offset(0,0,-3);
        assertFalse(badOffset.isValidForManual());

        Offset badOffset2 = new Offset(1,0,-1);
        assertFalse(badOffset2.isValidForManual());
    }
}