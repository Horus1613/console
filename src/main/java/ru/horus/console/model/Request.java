package ru.horus.console.model;

import lombok.Data;

@Data
public class Request {
    private Mode mode;
    private Offset offset;
    private Control control;
}
