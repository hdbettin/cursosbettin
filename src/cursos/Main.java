/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos;
import java.util.Date;
import java.util.Calendar;



/**
 *
 * @author Usuario
 */
public class Main {
    public static void main(String[] args) {
        Alumno alumno1 = new Alumno("Pepe", "34678904");
        Alumno alumno2 = new Alumno("Andrea", "17679456");
        
        Date now  = new Date();
        Calendar ahora = Calendar.getInstance();
        ahora.set(2004,1,7);
        
        CursoPresencial curso_pres = new CursoPresencial(20, 1, "Diseños de bases de datos", ahora, 
        ahora, 1, 50.0);
        CursoOnline curso_on = new CursoOnline("Administracion de bases de datos", ahora, 
        ahora, 5, 25.0, 4, curso_pres);
        
        curso_pres.matriculacion(alumno1);
        curso_pres.matriculacion(alumno2);
        
        curso_pres.registroAsistencia(1, alumno1);
        
        curso_pres.numeroAsisIndividual (alumno1);
        
        curso_on.matriculacion(alumno1);
        curso_on.matriculacion(alumno2);
        
        curso_on.subirNivel(alumno1);
        
        
        
        
    }
}
