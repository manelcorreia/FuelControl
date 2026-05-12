package com.FuelControl.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NaoHaUtilizadorComXId extends RuntimeException {
    public NaoHaUtilizadorComXId(String message) {
        super(message);
    }
}
