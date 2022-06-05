package ma.enset.etudiantsmvc.web;

import ma.enset.etudiantsmvc.entities.Etudiant;
import ma.enset.etudiantsmvc.repositeries.EtudiantRepositery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class EtudiantController {
    private EtudiantRepositery etudiantRepositery ;

    public EtudiantController(EtudiantRepositery etudiantRepositery) {
        this.etudiantRepositery = etudiantRepositery;
    }
    @GetMapping("/user/index")
    public String etudiants(Model model ,@RequestParam(defaultValue =  "0") int page,
                            @RequestParam(defaultValue = "5" ) int size,
                            @RequestParam(defaultValue = "" ) String keyword){
        Page<Etudiant> etudiants = etudiantRepositery.findByNomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("listEtudiants" , etudiants);
        model.addAttribute("pages" , new int[etudiants.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword",keyword);

        return "etudiants";
    }

    @GetMapping("/admin/delete")
    public String delete(Long id , String keyword , int page ){
        etudiantRepositery.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/")
    public String home(){

        return "home";
    }

    @GetMapping("/admin/formEtudiant")
    public String formEtudiants(Model model){
        Etudiant etudiant = new Etudiant();
        if (etudiant != null) {
            model.addAttribute("p", etudiant);
        } else {
            model.addAttribute("p", new Etudiant());
        }
        return "formEtudiant";
    }

    @PostMapping(path = "/admin/save")
    public String save(@Valid @ModelAttribute Etudiant etudiant, BindingResult bindingResult , Model model , @RequestParam(defaultValue = "0") int page ,
                       @RequestParam(defaultValue = "") String keyword){
        model.addAttribute("p", etudiant);
        if(bindingResult.hasErrors()) {
            return "formEtudiant";
        }

        etudiantRepositery.save(etudiant);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/admin/editEtudiant")
    public String editPatient(Model model , Long id , String keyword , int page ){
        Etudiant etudiant =etudiantRepositery.findById(id).orElse(null);
        if(etudiant==null) throw new RuntimeException("patient introuvable");
        model.addAttribute("p" ,etudiant);
        model.addAttribute("page", page);
        model.addAttribute("keyword", keyword);
        return "editEtudiant";
    }


}

