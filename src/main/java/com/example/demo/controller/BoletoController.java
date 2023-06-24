package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Boleto;
import com.example.demo.repository.BoletoRepository;
import com.example.demo.service.PdfGeneratorService;

import jakarta.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

@Controller
@RequestMapping("/boleto")
public class BoletoController {
	
	@Autowired
	private BoletoRepository boletoRepository;
	
	@Autowired
	private PdfGeneratorService pdfGeneratorService;
	
    @GetMapping("/mantenimiento")
    public String mostrarPaginaMantenimientoBoleto() {
        return "MantenimientoBoleto";
    }
    
    @PostMapping("/guardar")
    public String guardarBoleto(@ModelAttribute Boleto boleto) {
        boletoRepository.save(boleto);
        return "redirect:/boleto/lista";
    }
    
    @GetMapping("/listar")
    public String mostrarListaBoletos(Model model) {
        Iterable<Boleto> boletos = boletoRepository.findAll();
        model.addAttribute("boletos", boletos);
        return "ListaBoleto";
    }
    
    @GetMapping("/editar/{codigo}")
    public String mostrarPaginaEdicionBoleto(@PathVariable("codigo") String codigo, Model model) {
        Boleto boleto = boletoRepository.findById(codigo).orElse(null);
        model.addAttribute("boleto", boleto);
        return "EditarBoleto";
    }
    
    @PostMapping("/actualizar")
    public String actualizarBoleto(@ModelAttribute Boleto boleto) {
        boletoRepository.save(boleto);
        return "redirect:/boleto/lista";
    }
    
    @GetMapping("/eliminar/{codigo}")
    public String eliminarBoleto(@PathVariable("codigo") String codigo) {
        boletoRepository.deleteById(codigo);
        return "redirect:/boleto/lista";
    }
    
    @GetMapping(value = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public void generateBoletosPdf(HttpServletResponse response) {
        Iterable<Boleto> boletos = boletoRepository.findAll();
        try {
            byte[] pdfBytes = pdfGeneratorService.generateBoletoReport(boletos);
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=boletos.pdf");
            response.getOutputStream().write(pdfBytes);
            response.getOutputStream().flush();
        } catch (Exception e) {
            // Manejar el error apropiadamente
        }
    }
    
}
