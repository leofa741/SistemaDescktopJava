package negocio;


import datos.RolDao;
import entidades.Rol;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class RolControl {

    private final RolDao DATOS;
    private Rol obj;
    private DefaultTableModel modeloTabla;

    public int registrosMostrados;


    public RolControl(RolDao datos, Rol obj, DefaultTableModel modeloTabla) {
        DATOS = datos;
        this.obj = obj;
        this.modeloTabla = modeloTabla;
    }

    public RolControl() {
        this.DATOS = new RolDao();
        this.obj = new Rol();
        this.registrosMostrados = 0;
    }

    public DefaultTableModel listar() {
        List<Rol> lista = new ArrayList();
        lista.addAll(DATOS.listar());
        String[] titulos = {"Id", "Nombre", "Descripción"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String[] registro = new String[4];
        this.registrosMostrados = 0;

        for (Rol item : lista) {
            registro[0] = Integer.toString(item.getId());
            registro[1] = item.getNombre();
            registro[2] = item.getDescripcion();
            this.modeloTabla.addRow(registro);
            this.registrosMostrados = this.registrosMostrados + 1;
        }
        return this.modeloTabla;
    }

    public List<Rol> seleccionar() {
        List<Rol> registros =new ArrayList<>();
        registros.addAll(DATOS.seleccionar());
        return registros;
    }

    public int total() {
        return DATOS.total();
    }


    public int totalMostrados() {
        return this.registrosMostrados;
    }




}
