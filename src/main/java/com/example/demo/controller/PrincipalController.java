package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PrincipalController {
	
	@GetMapping("/")
    public String mostrarPaginaPrincipal() {
        return "Principal";
    }
	@GetMapping("/mantenimiento")
    public String mostrarPaginaMantenimiento() {
        return "Mantenimiento";
    }
	@GetMapping("/consulta")
    public String mostrarPaginaConsulta() {
        return "Consulta";
    }
	@GetMapping("/reporte")
    public String mostrarPaginaReporte() {
        return "Reporte";
    }
}