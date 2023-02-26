package com.shield.eaarogya.Controller;

import com.shield.eaarogya.DTO.PrescriptionDetails;
import com.shield.eaarogya.Service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.Date;

@CrossOrigin("*")
@RestController
@RequestMapping("/pdf")
public class PdfController {

    @Autowired
    private PdfService pdfService;

    // ------------------------ Generating Pdf based on Prescription Id -------------------------------
    @GetMapping("/getPdf/{prescriptionId}")
    public ResponseEntity<InputStreamResource> getPdf(@PathVariable String prescriptionId) {

        ByteArrayInputStream pdf = pdfService.generatePdf(Integer.parseInt(prescriptionId));

        String date = String.valueOf((new Date()));

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition",
                "attachment;filename=" + prescriptionId + " " + date +".pdf");
// Adding headerValue to attachment will make it download the pdf and setting it to inline will show in browser only.

        return ResponseEntity
                .ok()
                .headers(httpHeaders)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(pdf));
    }
}
