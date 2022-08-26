package ELDAR_EJECRICIO_JOSSPE.eldar_operaciones.controller;



import ELDAR_EJECRICIO_JOSSPE.eldar_operaciones.models.Tarjeta;
import ELDAR_EJECRICIO_JOSSPE.eldar_operaciones.models.reportes.*;
import ELDAR_EJECRICIO_JOSSPE.eldar_operaciones.repository.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/eldar_operaciones")

public class TrarjetaMainController {

    @Autowired
    private TarjetaRepository tarjetaRepository;

    @GetMapping(path = "/tarjeta/all")
    public @ResponseBody
    Iterable<Tarjeta> getAllTarjeta() {
        return tarjetaRepository.findAll();
    }

    @GetMapping(path = "/tarjeta/{id_tarjeta}")
    public @ResponseBody
    Optional<Tarjeta> getTarjetaById(@PathVariable("id_tarjeta") int id_t) {
        return tarjetaRepository.findById(id_t);
    }

    @PostMapping(path = "/tarjeta/create",
            consumes = "application/json", produces = "application/json")
    public Tarjeta createTarjeta(@RequestBody Tarjeta newTarjeta) {
        return tarjetaRepository.save(newTarjeta);
    }

    @PutMapping(path = "/tarjeta/update",
            consumes = "application/json", produces = "application/json")
    public Tarjeta updateTarjeta(@RequestBody Tarjeta updateTarjeta) {
        return tarjetaRepository.save(updateTarjeta);
    }

    @DeleteMapping(path = "/tarjeta/delete/{id_tarjeta}")
    public @ResponseBody
    Iterable<Tarjeta> deleteTarjetaById(@PathVariable("id_tarjeta") int id_t) {
        try {
            tarjetaRepository.deleteById(id_t);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return tarjetaRepository.findAll();
        }

    }


    // consultas

    @GetMapping(path = "/tarjeta/datos")
    public @ResponseBody
    Collection<DatosCompletos> getDatosCompletos() {
        return tarjetaRepository.getDatosCompletos();
    }

    @GetMapping(path = "/tarjeta/operacion/valida")
    public @ResponseBody
    Collection<OperacionValida> getOperacionValida() {
        return tarjetaRepository.getOperacionValida();

    }

    @GetMapping(path = "/tarjeta/tarjeta/valida")
    public @ResponseBody
    Collection<TarjetaValida> getTarjetaValida() {
        return tarjetaRepository.getTarjetaValida();
    }

    @GetMapping(path = "/tarjeta/tasa/nara")
    public @ResponseBody
    Iterable<TasaNara> getTasaNara() {
        return tarjetaRepository.getTasaNara();
    }

    @GetMapping(path = "/tarjeta/tasa/visa")
    public @ResponseBody
    Iterable<TasaVisa> getTasaVisa() {
        return tarjetaRepository.getTasaVisa();
    }

    @GetMapping(path = "/tarjeta/tasa/amex")
    public @ResponseBody
    Iterable<TasaAmex> getTasaAmex() {
        return tarjetaRepository.getTasaAmex();
    }

}
