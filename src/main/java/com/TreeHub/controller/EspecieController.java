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
@RequestMapping("/especie")
public class EspecieController {
    
    @Autowired
    private EspecieService especieService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var lista=especieService.getEspecies(false);
        model.addAttribute("especies", lista);
        model.addAttribute("totalEspecies", lista.size());
        return "/especie/listado";
    }  
        @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String especieGuardar(Especie especie,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            especieService.save(especie);
            especie.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "especie", 
                            especie.getIdEspecie()));
        }
        especieService.save(especie);
        return "redirect:/especie/listado";
    }

    @GetMapping("/eliminar/{idEspecie}")
    public String especieEliminar(Especie especie) {
        especieService.delete(especie);
        return "redirect:/especie/listado";
    }

    @GetMapping("/modificar/{idEspecie}")
    public String especieModificar(Especie especie, Model model) {
        especie = especieService.getEspecie(especie);
        model.addAttribute("especie", especie);
        return "/especie/modifica";
    }
}
