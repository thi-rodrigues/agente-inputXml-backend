package com.ewave.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ewave.service.AgenteService;
import com.ewave.service.projections.AgenteProjection;

@RestController
@RequestMapping(value = "/agentes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AgenteController {

	@Autowired
	private AgenteService agenteService;
	
	@PostMapping("/inputarNotas")
	public void inputarNotas(@RequestParam MultipartFile file) throws ParseException {
		File convertMultipart = new File(file.getOriginalFilename());
		try {
			FileOutputStream output = new FileOutputStream(convertMultipart);
			output.write(file.getBytes());
			output.close();
			agenteService.lerXml(convertMultipart);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/buscarRegioes")
	public ResponseEntity<List<AgenteProjection>>  buscarRegioes() {
		return ResponseEntity.ok(agenteService.buscarRegioes());
	}
	
	
	@GetMapping("/buscarPorRegiao/{regiao}")
	public ResponseEntity<List<AgenteProjection>> buscarPorRegiao(@PathVariable String regiao) {
		return ResponseEntity.ok(agenteService.buscarPorRegiao(regiao));
	}
	
	
}
