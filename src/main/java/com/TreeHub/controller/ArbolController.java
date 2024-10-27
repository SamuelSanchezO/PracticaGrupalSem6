package com.TreeHub.controller;

import com.TreeHub.domain.Arbol;
import com.TreeHub.services.ArbolService;
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
@RequestMapping("/Arbol")
public class ArbolController {
    
    @Autowired
    private ArbolService ArbolService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var lista=ArbolService.getArbols(false);
        model.addAttribute("Arbols", lista);
        model.addAttribute("totalArbols", lista.size());
        return "/Arbol/listado";
    }  
        @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String ArbolGuardar(Arbol Arbol,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            ArbolService.save(Arbol);
            Arbol.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "Arbol", 
                            Arbol.getIdArbol()));
        }
        ArbolService.save(Arbol);
        return "redirect:/Arbol/listado";
    }

    @GetMapping("/eliminar/{idArbol}")
    public String ArbolEliminar(Arbol Arbol) {
        ArbolService.delete(Arbol);
        return "redirect:/Arbol/listado";
    }

    @GetMapping("/modificar/{idArbol}")
    public String ArbolModificar(Arbol Arbol, Model model) {
        Arbol = ArbolService.getArbol(Arbol);
        model.addAttribute("Arbol", Arbol);
        return "/Arbol/modifica";
    }
}
