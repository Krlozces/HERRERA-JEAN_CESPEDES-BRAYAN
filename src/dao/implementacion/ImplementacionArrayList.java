package dao.implementacion;

import dao.IDao;
import model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ImplementacionArrayList implements IDao<Odontologo> {
    private static final Logger LOGGER = Logger.getLogger(ImplementacionArrayList.class);

    private static final List<Odontologo> ODONTOLOGOS = new ArrayList<>();

    private static Integer id = 0;

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologo.setId(id);
        LOGGER.info("Agregando odontologo (sin BD)" + odontologo.getNombre());
        ODONTOLOGOS.add(odontologo);
        LOGGER.info("Odontologo agregado " + ODONTOLOGOS.get(id).getNombre());
        id++;
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodo() {
        for (Odontologo odontologo : ODONTOLOGOS){
            LOGGER.info("Este es el odontologo (sin BD) : " + odontologo.toString());
        }
        return ODONTOLOGOS;
    }
}
