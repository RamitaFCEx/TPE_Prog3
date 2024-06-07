import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Procesador implements Comparable<Procesador>{
    private int id,anio_funcionamiento;
    private String codigo;
    private boolean is_refrigerado;

    private LinkedList<Tarea> tareas;

    private int tareasCriticas;

    public Procesador(int id, int anio_funcionamiento, boolean is_refrigerado, String codigo) {
        this.id = id;
        this.anio_funcionamiento = anio_funcionamiento;
        this.is_refrigerado = is_refrigerado;
        this.codigo = codigo;
        this.tareas = new LinkedList<>();
        this.tareasCriticas = 0;
    }

    public void addTarea(Tarea t){
        if (t.is_critica())
            tareasCriticas++;
        this.tareas.add(t);
    }

    public int cantTareasCriticas() {
        return tareasCriticas;
    }

    public void removeTarea(Tarea t){
        tareas.remove(t);
    }

    public int getTiempoEjecucionMaximo(){
        return this.tareas.stream().mapToInt(Tarea::getTiempo_ejec).sum();
    }

    public List<Tarea> getTareas() {
        return new LinkedList<>(tareas);
    }

    public int getId() {
        return id;
    }

    public int getAnio_funcionamiento() {
        return anio_funcionamiento;
    }

    public String getCodigo() {
        return codigo;
    }

    public boolean isRefrigerado() {
        return is_refrigerado;
    }

    @Override
    public String toString() {
        return "Procesador{" +
                "id=" + id +
                ", anio_funcionamiento=" + anio_funcionamiento +
                ", codigo='" + codigo + '\'' +
                ", is_refrigerado=" + is_refrigerado +
                '}';
    }

    public Procesador getCopy(){
        return new Procesador(this.id, this.anio_funcionamiento, this.is_refrigerado, this.codigo);
    }

    @Override
    public int compareTo(Procesador o) {
        return Integer.compare(this.getTiempoEjecucionMaximo(), o.getTiempoEjecucionMaximo());
    }
}
