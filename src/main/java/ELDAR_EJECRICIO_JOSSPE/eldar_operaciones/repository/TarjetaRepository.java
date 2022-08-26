package ELDAR_EJECRICIO_JOSSPE.eldar_operaciones.repository;


import ELDAR_EJECRICIO_JOSSPE.eldar_operaciones.models.Tarjeta;
import ELDAR_EJECRICIO_JOSSPE.eldar_operaciones.models.reportes.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.Collection;
import java.util.List;

public interface TarjetaRepository extends CrudRepository<Tarjeta, Integer> {

    @Query (value = "SELECT m.nombre as marca, t.num_tarjeta as numero, concat(c.nombre, ' ', c.apellido) as titular, t.consumo as opercione, t.fecha_vencimiento as vencimiento from tarjeta as t, marca as m, cardholder as c where t.marca_id = m.ID and t.cardholder_id= c.id group by t.id" , nativeQuery = true)
    Collection<DatosCompletos> getDatosCompletos();

    // valides operacion

    @Query (value = "SELECT t.consumo as operaciones, m.nombre as marca, concat(c.nombre, ' ', c.apellido) as titular from tarjeta as t, marca as m, cardholder as c where t.marca_id = m.ID and t.cardholder_id= c.id having consumo < 1000 order by 3 desc;" , nativeQuery = true)
    Collection<OperacionValida> getOperacionValida();

    // validez tarjeta

    @Query (value = "SELECT t.fecha_vencimiento as vecimiento, m.nombre as marca, concat(c.nombre, ' ', c.apellido) as titular from tarjeta as t, marca as m, cardholder as c where t.marca_id = m.ID and t.cardholder_id= c.id and fecha_vencimiento > current_date();" ,  nativeQuery = true)
    Collection<TarjetaValida> getTarjetaValida();

    // tasa

    @Query(value = "SELECT ((consumo * dayofmonth(t.fecha_vencimiento))/100) + consumo + consumo as tasa, m.nombre as marca, concat(c.nombre, ' ', c.apellido) as titular from tarjeta as t, marca as m, cardholder as c where t.marca_id = m.ID and t.cardholder_id= c.id and m.nombre like '%nara%';" , nativeQuery = true)
    List<TasaNara> getTasaNara();

    @Query(value = "SELECT (consumo*(year(t.fecha_vencimiento)/month(t.fecha_vencimiento))/100) + consumo as tasa, m.nombre as marca, concat(c.nombre, ' ', c.apellido) as titular from tarjeta as t, marca as m, cardholder as c where t.marca_id = m.ID and t.cardholder_id= c.id and m.nombre like '%visa%';" , nativeQuery = true)
    List<TasaVisa> getTasaVisa();

    @Query(value = "SELECT ((consumo * month(t.fecha_vencimiento))/100) + consumo as tasa, m.nombre as marca, concat(c.nombre, ' ', c.apellido) as titular from tarjeta as t, marca as m, cardholder as c where t.marca_id = m.ID and t.cardholder_id= c.id and m.nombre like '%amex%';" , nativeQuery = true)
    List<TasaAmex> getTasaAmex();

}
