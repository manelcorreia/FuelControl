package com.FuelControl.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NaoHaCombustivelNomeException extends RuntimeException {
    public NaoHaCombustivelNomeException(String message) {
        super(message);
    }
}
