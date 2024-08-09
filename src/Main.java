import dao.BD;
import model.Odontologo;
import servicio.OdontologoServicio;

public class Main {
    public static void main(String[] args) {
        BD.ejecutarScript();
        Odontologo odontologo = new Odontologo(123, "Pedro", "Gamarra");
        OdontologoServicio servicio = new OdontologoServicio();
        servicio.guardar(odontologo);
        System.out.println(odontologo.toString());

        Odontologo odontologo2 = new Odontologo(123, "Piero", "Gamarra");
        Odontologo odontologo3 = new Odontologo(456, "Pedro2", "Gamarra");
        Odontologo odontologo4 = new Odontologo(789, "Pedro3", "Gamarra");
        
        servicio.guardar(odontologo2);
        servicio.guardar(odontologo3);
        servicio.guardar(odontologo4);
        servicio.listarTodo();
    }
}
