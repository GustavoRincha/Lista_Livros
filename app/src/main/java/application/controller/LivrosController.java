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
import application.model.Livros;
import application.repository.LivrosRepository;

@RestController
@RequestMapping("/livros")
public class LivrosController {
    @Autowired
    private LivrosRepository livrosRepo;

    @GetMapping
    public Iterable<Livros> getall(){
        return livrosRepo.findAll();
    }

    @GetMapping("/{id}")
    public Livros getOne(@PathVariable long id){
        Optional<Livros> result = livrosRepo.findById(id);
        if (result.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,"Obra não encontrada"
            );
        }
        return result.get();
    }

    @PostMapping
    private Livros post(@RequestBody Livros livros){
        return livrosRepo.save(livros);
    }

    @PutMapping("/{id}")
    public Livros put(@RequestBody Livros livros, @PathVariable long id){
        Optional<Livros> result = livrosRepo.findById(id);
        
        if (result.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,"Livros não encontrada"
            );
        }
        
        result.get().setTitulo(livros.getTitulo());
        result.get().setGenero(livros.getGenero());
        result.get().setEditora(livros.getEditora());
        result.get().setData_de_Lancamento(livros.getData_de_Lancamento());
        return livrosRepo.save(result.get());

    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable long id){
        if(livrosRepo.existsById(id)){
            livrosRepo.deleteById(id);
        } else {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,"ivros não encontrada"
            );
        }
        
    }
}