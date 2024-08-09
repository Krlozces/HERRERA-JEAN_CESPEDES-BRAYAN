package servicio;

import dao.IDao;
import dao.implementacion.ImplementacionDaoH2;
import model.Odontologo;

import java.util.List;

public class OdontologoServicio {
    private IDao<Odontologo> idao;

    public OdontologoServicio() {
        this.idao = new ImplementacionArrayList();
    }

    public Odontologo guardar(Odontologo odontologo){
        return idao.guardar(odontologo);
    }

    public List<Odontologo> listarTodo(){
        return idao.listarTodo();
    }
}
