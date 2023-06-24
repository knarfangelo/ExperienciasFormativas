package com.example.demo.controller;

import com.example.demo.model.Espectaculo;
import com.example.demo.repository.EspectaculoRepository;
import com.example.demo.service.PdfGeneratorService;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/espectaculo")
public class EspectaculoController {

    @Autowired
    private EspectaculoRepository espectaculoRepository;
    @Autowired
    private PdfGeneratorService pdfGeneratorService;
    
    @GetMapping("/mantenimiento")
    public String mostrarPaginaMantenimiento(Model model) {
        model.addAttribute("espectaculo", new Espectaculo());
        return "MantenimientoEspectaculo";
    }

    @PostMapping("/guardar")
    public String guardarEspectaculo(@ModelAttribute("espectaculo") Espectaculo espectaculo) {
        espectaculoRepository.save(espectaculo);
        return "redirect:/espectaculo/mantenimiento";
    }

    @GetMapping("/listar")
    public String listarEspectaculos(Model model) {
        Iterable<Espectaculo> espectaculos = espectaculoRepository.findAll();
        model.addAttribute("espectaculos", espectaculos);
        return "ListaEspectaculos";
    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminarEspectaculo(@PathVariable("codigo") String codigo) {
        espectaculoRepository.deleteById(codigo);
        return "redirect:/espectaculo/listar";
    }

    @GetMapping("/editar/{codigo}")
    public String editarEspectaculo(@PathVariable("codigo") String codigo, Model model) {
        Espectaculo espectaculo = espectaculoRepository.findById(codigo).orElse(null);
        model.addAttribute("espectaculo", espectaculo);
        return "MantenimientoEspectaculo";
    }
    
    @GetMapping(value = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public void generateEspectaculosPdf(HttpServletResponse response) {
        Iterable<Espectaculo> espectaculos = espectaculoRepository.findAll();
        try {
            byte[] pdfBytes = pdfGeneratorService.generateEspectaculoReport(espectaculos);
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=espectaculos.pdf");
            response.getOutputStream().write(pdfBytes);
            response.getOutputStream().flush();
        } catch (Exception e) {
            // Manejar el error apropiadamente
        }
    }

}
