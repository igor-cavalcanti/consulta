package com.programem.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dependente")
public class DependenteController {

    @Autowired
    private DependenteRepository DependenteRepository;

    
    private ListaDependente listaDependente = new ListaDependente();

    @GetMapping("/")
    public String dependenteForm(){
      return "dependenteForm";
    }

    @PostMapping(path="/insere") // Map ONLY POST Requests
    public @ResponseBody String addNewDependente (
         @RequestParam String nome
        ,@RequestParam Integer idade
        ,@RequestParam String endereco
        ) {

            Dependente d = new Dependente();

            d.setNome(nome);
            d.setIdade(idade);
            d.setEndereco(endereco);

            DependenteRepository.save(d);

            return nome+" "+idade+" "+endereco;
    }

    @GetMapping(path="/lista")
    public @ResponseBody String getAllDependente() {
        
        Iterable<Dependente> resultado = DependenteRepository.findAll();
     
        return listaDependente.listaDependente(resultado);
    }
    @GetMapping(path="/filtro")
    public @ResponseBody String getDependente(@RequestParam Integer idade) {
        
        Iterable<Dependente> resultado = DependenteRepository.findDependente(idade);
     
        return listaDependente.listaDependente(resultado);
  
    } 

    @GetMapping(path="/filtroForm")
    public String filtroForm() {
      return "filtroForm";
  
    }
} 
