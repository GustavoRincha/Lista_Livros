package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import application.model.Meio_de_Leitura;
import application.repository.Meio_de_LeituraRepository;

@RestController
@RequestMapping("/meio_de_Leitura")
public class Meio_de_LeituraController {
    @Autowired
    private Meio_de_LeituraRepository meio_de_leituraRepo;

    @GetMapping
    public Iterable<Meio_de_Leitura> getall(){
        return meio_de_leituraRepo.findAll();
    }

    @GetMapping("/{id}")
    public Meio_de_Leitura getOne(@PathVariable long id){
        Optional<Meio_de_Leitura> result = meio_de_leituraRepo.findById(id);
        if (result.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,"Meio de Leitura não encontrada"
            );
        }
        return result.get();
    }

    @PostMapping
    private Meio_de_Leitura post(@RequestBody Meio_de_Leitura meio_de_leitura){
        return meio_de_leituraRepo.save(meio_de_leitura);
    }

    @PutMapping("/{id}")
    private Meio_de_Leitura put(@RequestBody Meio_de_Leitura meio_de_leitura, @PathVariable long id){
        Optional<Meio_de_Leitura> result = meio_de_leituraRepo.findById(id);
        
        if (result.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,"Meio de Leitura não encontrada"
            );
        }
        
        result.get().setMeio_de_Leitura(meio_de_leitura.getMeio_de_Leitura());
        return meio_de_leituraRepo.save(result.get());

    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable long id){
        if(meio_de_leituraRepo.existsById(id)){
            meio_de_leituraRepo.deleteById(id);
        } else {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,"Meio de Leitura não encontrada"
            );
        }
        
    }
}