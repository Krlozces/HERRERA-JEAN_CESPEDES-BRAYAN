package dao.implementacion;
import dao.BD;
import dao.IDao;
import model.Odontologo;
import org.apache.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImplementacionDaoH2 implements IDao<Odontologo> {
    private static final Logger LOGGER = Logger.getLogger(ImplementacionDaoH2.class);

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        LOGGER.info("Comenzamos a persistir un odontologo");
        try {
            connection = BD.getConnection();
            PreparedStatement psmt = connection.prepareStatement(
                    "INSERT INTO odontologos (matricula, nombre, apellido) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS
            );
            psmt.setInt(1, odontologo.getMatricula());
            psmt.setString(2, odontologo.getNombre());
            psmt.setString(3, odontologo.getApellido());
            psmt.execute();

            ResultSet rs = psmt.getGeneratedKeys();
            while(rs.next()){
                odontologo.setId(rs.getInt(1));
                LOGGER.info("Este es el odontologo que se guardó " +
                        odontologo.getNombre());
                // TODO: REVISAR
                // System.out.println(odontologo.getId());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodo() {
        Connection connection = null;
        LOGGER.info("Comenzamos a listar todos los odontologos");
        List<Odontologo> odontologos = new ArrayList<>();
        Odontologo odontologo = null;
        try {
            connection = BD.getConnection();
            PreparedStatement psmt = connection.prepareStatement(
                    "SELECT * FROM odontologos"
            );

            ResultSet rs = psmt.executeQuery();
            while(rs.next()){
                odontologo = new Odontologo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                odontologos.add(odontologo);
                LOGGER.info("Este es el odontologo: " + odontologo.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return odontologos;
    }

}
