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
import application.model.Preco;
import application.repository.PrecoRepository;

@RestController
@RequestMapping("/preco")
public class PrecoController {
    @Autowired
    private PrecoRepository precoRepo;

    @GetMapping
    public Iterable<Preco> getall(){
        return precoRepo.findAll();
    }

    @GetMapping("/{id}")
    public Preco getOne(@PathVariable long id){
        Optional<Preco> result = precoRepo.findById(id);
        if (result.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,"Preco não encontrada"
            );
        }
        return result.get();
    }

    @PostMapping
    private Preco post(@RequestBody Preco preco){
        return precoRepo.save(preco);
    }

    @PutMapping("/{id}")
    private Preco put(@RequestBody Preco preco, @PathVariable long id){
        Optional<Preco> result = precoRepo.findById(id);
        
        if (result.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,"Preco não encontrada"
            );
        }
        
        result.get().setPreco(preco.getPreco());
        return precoRepo.save(result.get());

    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable long id){
        if(precoRepo.existsById(id)){
            precoRepo.deleteById(id);
        } else {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,"Preco não encontrada"
            );
        }
        
    }
}