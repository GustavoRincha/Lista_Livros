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
import application.model.Autor;
import application.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    private AutorRepository autorRepo;

    @GetMapping
    public Iterable<Autor> getall(){
        return autorRepo.findAll();
    }

    @GetMapping("/{id}")
    public Autor getOne(@PathVariable long id){
        Optional<Autor> result = autorRepo.findById(id);
        if (result.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,"Autor não encontrada"
            );
        }
        return result.get();
    }

    @PostMapping
    private Autor post(@RequestBody Autor autor){
        return autorRepo.save(autor);
    }

    @PutMapping("/{id}")
    private Autor put(@RequestBody Autor autor, @PathVariable long id){
        Optional<Autor> result = autorRepo.findById(id);
        
        if (result.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,"Autor não encontrada"
            );
        }
        
        result.get().setNome(autor.getNome());
        result.get().setNacionalidade(autor.getNacionalidade());
        return autorRepo.save(result.get());

    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable long id){
        if(autorRepo.existsById(id)){
            autorRepo.deleteById(id);
        } else {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,"Autor não encontrada"
            );
        }
        
    }
}