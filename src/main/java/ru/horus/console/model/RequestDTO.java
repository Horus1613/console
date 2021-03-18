package ru.horus.console.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDTO {
    private Mode mode;
    private String x;
    private String y;
    private Control control;
}
