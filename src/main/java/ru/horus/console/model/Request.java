package ru.horus.console.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString
public class Request {
    private Mode mode;
    private Offset offset;
    private Control control;

    public Request(RequestDTO requestDTO) {
        this.mode = requestDTO.getMode();
        this.control = requestDTO.getControl();
        this.offset = new Offset(requestDTO.getX(), requestDTO.getY());
    }
}
