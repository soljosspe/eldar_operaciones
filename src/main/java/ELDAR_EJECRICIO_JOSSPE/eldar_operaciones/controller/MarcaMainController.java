package ELDAR_EJECRICIO_JOSSPE.eldar_operaciones.controller;



import ELDAR_EJECRICIO_JOSSPE.eldar_operaciones.models.Marca;
import ELDAR_EJECRICIO_JOSSPE.eldar_operaciones.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/eldar_operaciones")

public class MarcaMainController {

    @Autowired
    private MarcaRepository marcaRepository;

    @GetMapping(path = "/marca/all")
    public @ResponseBody
    Iterable<Marca> getAllMarca() {
        return marcaRepository.findAll();
    }

    @GetMapping(path = "/marca/{id_marca}")
    public @ResponseBody
    Optional<Marca> getCardHolderById(@PathVariable("id_marca") int id_m) {
        return marcaRepository.findById(id_m);
    }

    @PostMapping(path = "/marca/create",
            consumes = "application/json", produces = "application/json")
    public Marca createMarca(@RequestBody Marca newMarca) {
        return marcaRepository.save(newMarca);
    }

    @PutMapping(path = "/marca/update",
            consumes = "application/json", produces = "application/json")
    public Marca updateCardHolder(@RequestBody Marca updateMarca) {
        return marcaRepository.save(updateMarca);
    }

    @DeleteMapping(path = "/marca/delete/{id_marca}")
    public @ResponseBody
    Iterable<Marca> deleteMarcaById(@PathVariable("id_marca") int id_m) {
        try {
            marcaRepository.deleteById(id_m);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return marcaRepository.findAll();
        }

    }
}
