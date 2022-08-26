package ELDAR_EJECRICIO_JOSSPE.eldar_operaciones.models;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Tarjeta {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private int numTarjeta;
    private int consumo;

    private Date fechaVencimiento;

    @OneToOne
    @JoinColumn(name = "marca_id", referencedColumnName = "id")
    private Marca marca;

    @OneToOne
    @JoinColumn(name = "cardholder_id", referencedColumnName = "id")
    private Cardholder cardholder;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(int numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Cardholder getCardholder() {
        return cardholder;
    }

    public void setCardholder(Cardholder cardholder) {
        this.cardholder = cardholder;
    }
}
