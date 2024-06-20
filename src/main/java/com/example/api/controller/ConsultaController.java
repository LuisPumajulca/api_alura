package com.example.api.controller;

import com.example.api.domain.consula.DatosAgendarConsulta;
import com.example.api.domain.consula.DatosDetalleConsulta;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/consultas")
public class ConsultaController {

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DatosAgendarConsulta datos){
        return ResponseEntity.ok(new DatosDetalleConsulta(null, null, null, null));
    }
}
