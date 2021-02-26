package ru.horus.console.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Offset {
    private int x;
    private int y;
    private int z;

    public boolean isValidForManual() {
        List<Integer> fields = List.of(x, y, z);
        return List.of(-1, 0, 1).containsAll(fields) && fields.stream().filter(val -> val != 0).count() == 1;
    }
}

