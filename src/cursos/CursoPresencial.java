package cursos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CursoPresencial extends Curso {
    private final int cupoMax;
    private final int asistenciasMin;
    private Map<Integer, ArrayList<String>> asistencias;

    public CursoPresencial(int cupoMax, int asistenciasMin, String titulo, Calendar fechaInicio, Calendar fechaFinal, int numeroDias, double precio) {
        super(titulo, fechaInicio, fechaFinal, numeroDias, precio);
        this.cupoMax = cupoMax;
        this.asistenciasMin = asistenciasMin;
        this.asistencias = new HashMap<>();

    }
    
    public boolean registroAsistencia(int dia, Alumno alumno){
        ArrayList<String> lista;
        if(numeroDias <= dia && alumnos.contains(alumno)){
            lista = asistencias.get(dia);
            if(lista == null){
                lista = new ArrayList<>();
                asistencias.put(dia, lista);
            }
            lista.add(alumno.getNombre());
            return true;
        }
        return false;
    }
    
    public int numeroAsisIndividual (Alumno alumno){
        Iterator it = asistencias.keySet().iterator();
        int sumatoria = 0;
        while(it.hasNext()){
            Integer key =  (Integer) it.next();
            if(asistencias.get(key).contains(alumno.getNombre())){
                sumatoria++;
            }
        }
        return sumatoria;
    }
    
    @Override
    public boolean matriculacion(Alumno alumno){
        if(alumno.getCredito() >= precio && cupoMax - alumnos.size() > 0){
            alumno.decrementarCredito(precio);
            alumnos.add(alumno);
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public boolean alumnoApto(Alumno alumno) {
        return numeroAsisIndividual(alumno) >= asistenciasMin;
    }

    @Override
    public boolean vacio() {
        return this.alumnos.isEmpty() && this.alumnosAptos.isEmpty() && asistencias.isEmpty();
    }
    
}
