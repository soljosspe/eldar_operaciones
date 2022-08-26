package ELDAR_EJECRICIO_JOSSPE.eldar_operaciones.controller;

import ELDAR_EJECRICIO_JOSSPE.eldar_operaciones.models.Cardholder;
import ELDAR_EJECRICIO_JOSSPE.eldar_operaciones.repository.CardholderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/eldar_operaciones")

public class CardholderMainController {

    @Autowired
    private CardholderRepository cardholderRepository;

    @GetMapping(path = "/cardholder/all")
    public @ResponseBody
    Iterable<Cardholder> getAllCardHolder() {
        return cardholderRepository.findAll();
    }

    @GetMapping(path = "/cardholder/{id_cardholder}")
    public @ResponseBody
    Optional<Cardholder> getCardHolderById(@PathVariable("id_cardholder") int id_ch) {
        return cardholderRepository.findById(id_ch);
    }

    @PostMapping(path = "/cardholder/create",
            consumes = "application/json", produces = "application/json")
    public Cardholder createCardHolder(@RequestBody Cardholder newCardHolder) {
        return cardholderRepository.save(newCardHolder);
    }

    @PutMapping(path = "/cardholder/update",
            consumes = "application/json", produces = "application/json")
    public Cardholder updateCardHolder(@RequestBody Cardholder updateCardHolder) {
        return cardholderRepository.save(updateCardHolder);
    }

    @DeleteMapping(path = "/cardholder/delete/{id_cardholder}")
    public @ResponseBody
    Iterable<Cardholder> deleteCardHolderById(@PathVariable("id_cardholder") int id_ch) {
        try {
            cardholderRepository.deleteById(id_ch);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return cardholderRepository.findAll();
        }

    }



}
