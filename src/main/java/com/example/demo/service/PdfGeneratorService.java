package com.example.demo.service;

import com.example.demo.model.Boleto;
import com.example.demo.model.Espectaculo;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.Iterator;

@Service
public class PdfGeneratorService {

    public byte[] generateEspectaculoReport(Iterable<Espectaculo> espectaculos) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, baos);
            document.open();

            // Generar contenido del informe de espectáculos
            Iterator<Espectaculo> iterator = espectaculos.iterator();
            while (iterator.hasNext()) {
                Espectaculo espectaculo = iterator.next();
                document.add(new Paragraph("Nombre: " + espectaculo.getNombreProveedor()));
                document.add(new Paragraph("Descripción: " + espectaculo.getDireccion()));
                document.add(new Paragraph("----------------------------------------"));
            }

            document.close();
        } catch (DocumentException e) {
            // Manejar el error apropiadamente
            e.printStackTrace();
        }

        return baos.toByteArray();
    }

    public byte[] generateBoletoReport(Iterable<Boleto> boletos) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, baos);
            document.open();

            // Generar contenido del informe de boletos
            Iterator<Boleto> iterator = boletos.iterator();
            while (iterator.hasNext()) {
                Boleto boleto = iterator.next();
                document.add(new Paragraph("Número: " + boleto.getCodigo()));
                document.add(new Paragraph("Precio: " + boleto.getPrecio()));
                document.add(new Paragraph("----------------------------------------"));
            }

            document.close();
        } catch (DocumentException e) {
            // Manejar el error apropiadamente
            e.printStackTrace();
        }

        return baos.toByteArray();
    }
}
