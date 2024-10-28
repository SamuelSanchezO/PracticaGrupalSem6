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
public class ArbolController {
    
    @Autowired
    private ArbolService arbolService;
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    // New method to handle root URL
    @GetMapping("/")
    public String redirectToListado() {
        return "redirect:/arbol/listado"; // Redirect to the listado method
    }

    @GetMapping("/arbol/listado")
    public String listado(Model model) {
        var lista = arbolService.getArboles();
        model.addAttribute("arboles", lista);
        model.addAttribute("totalArboles", lista.size());
        return "/arbol/listado"; // Return the view for the list of trees
    }

    @PostMapping("/arbol/guardar")
    public String arbolGuardar(Arbol arbol, @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            arbolService.save(arbol);
            arbol.setRuta_imagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "arbol", 
                            arbol.getId_arbol()));
        }
        arbolService.save(arbol);
        return "redirect:/arbol/listado"; // Redirect after saving
    }

    @GetMapping("/arbol/eliminar/{id_arbol}")
    public String arbolEliminar(Arbol arbol) {
        arbolService.delete(arbol);
        return "redirect:/arbol/listado"; // Redirect after deletion
    }

    @GetMapping("/arbol/modificar/{id_arbol}")
    public String arbolModificar(Arbol arbol, Model model) {
        arbol = arbolService.getArbol(arbol);
        model.addAttribute("arbol", arbol);
        return "/arbol/modifica"; // Return the view for modifying a tree
    }
}