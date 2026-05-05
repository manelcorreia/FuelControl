package com.FuelControl.controller;

import com.FuelControl.service.DescontoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/descontos")
public class DescontoController {
    private final DescontoService descontoService;

    @GetMapping("/{nomeGasolineira}")
    public String verTodosDescontosDaGasolineira(@PathVariable String nomeGasolineira) {
        return descontoService.verTodosDescontos(nomeGasolineira);
    }
}
