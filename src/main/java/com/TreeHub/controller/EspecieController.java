package com.TreeHub.controller;

import com.TreeHub.domain.Especie;
import com.TreeHub.services.EspecieService;
import com.TreeHub.services.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/Especie")
public class EspecieController {
    
    @Autowired
    private EspecieService EspecieService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var lista=EspecieService.getEspecies(false);
        model.addAttribute("Especies", lista);
        model.addAttribute("totalEspecies", lista.size());
        return "/Especie/listado";
    }  
        @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String EspecieGuardar(Especie Especie,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            EspecieService.save(Especie);
            Especie.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "Especie", 
                            Especie.getIdEspecie()));
        }
        EspecieService.save(Especie);
        return "redirect:/Especie/listado";
    }

    @GetMapping("/eliminar/{idEspecie}")
    public String EspecieEliminar(Especie Especie) {
        EspecieService.delete(Especie);
        return "redirect:/Especie/listado";
    }

    @GetMapping("/modificar/{idEspecie}")
    public String EspecieModificar(Especie Especie, Model model) {
        Especie = EspecieService.getEspecie(Especie);
        model.addAttribute("Especie", Especie);
        return "/Especie/modifica";
    }
}
