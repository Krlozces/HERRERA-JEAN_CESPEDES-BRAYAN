package servicio;

import dao.BD;
import model.Odontologo;
import org.junit.Test;

import java.util.List;
import static org.junit.Assert.assertEquals;

public class OdontologoServicioTest {
    @Test
    public void listarOdontologos(){
        // Arrange
        //BD.ejecutarScript();
        Odontologo odontologo = new Odontologo(123, "Pedro", "Gamarra");
        OdontologoServicio servicio = new OdontologoServicio();

        Odontologo odontologo2 = new Odontologo(123, "Piero", "Gamarra");
        Odontologo odontologo3 = new Odontologo(456, "Pedro2", "Gamarra");
        Odontologo odontologo4 = new Odontologo(789, "Pedro3", "Gamarra");

        // Act
        servicio.guardar(odontologo);
        servicio.guardar(odontologo2);
        servicio.guardar(odontologo3);
        servicio.guardar(odontologo4);
        List<Odontologo> result = servicio.listarTodo();

        // Asert
        assertEquals(4,result.size());
    }
}