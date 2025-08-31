import java.util.*;

public class Principal {
    public static void main(String[] args) {
    
        Nombre n1 = new Nombre(1, "Carlos", 25, "Premium");
        Nombre n2 = new Nombre(2, "Ana", 30, "Básica");
        Nombre n3 = new Nombre(3, "Pedro", 22, "VIP");
        Nombre n4 = new Nombre(4, "Lucía", 28, "Premium");

        ArrayList<Nombre> listaMiembros = new ArrayList<>();
        listaMiembros.add(n1);
        listaMiembros.add(n2);
        listaMiembros.add(n3);
        listaMiembros.add(n4);

        
        ArrayList<Nombre> miembrosLuis = new ArrayList<>();
        miembrosLuis.add(n1);
        miembrosLuis.add(n2);

        ArrayList<Nombre> miembrosMaria = new ArrayList<>();
        miembrosMaria.add(n3);
        miembrosMaria.add(n4);

        Entrenador e1 = new Entrenador(1, "Luis", "Pesas", miembrosLuis);
        Entrenador e2 = new Entrenador(2, "María", "Cardio", miembrosMaria);

        ArrayList<Entrenador> listaEntrenadores = new ArrayList<>();
        listaEntrenadores.add(e1);
        listaEntrenadores.add(e2);

       
        ArrayList<Nombre> miembrosCardio = new ArrayList<>();
        miembrosCardio.add(n1);
        miembrosCardio.add(n3);

        ArrayList<Nombre> miembrosPesas = new ArrayList<>();
        miembrosPesas.add(n2);
        miembrosPesas.add(n4);

        Rutina r1 = new Rutina("R01", "Cardio Express", "Ejercicios de resistencia", 45, "Intermedio", "Cardio", miembrosCardio);
        Rutina r2 = new Rutina("R02", "Full Pesas", "Entrenamiento de fuerza", 60, "Avanzado", "Pesas", miembrosPesas);

        ArrayList<Rutina> listaRutinas = new ArrayList<>();
        listaRutinas.add(r1);
        listaRutinas.add(r2);

        
        Gimnasio gimnasio = new Gimnasio(listaMiembros, listaEntrenadores, listaRutinas);

       
        System.out.println("=== Reportes del Gimnasio ===");

        
        Rutina rutinaTop = null;
        int maxMiembros = 0;
        for (Rutina r : gimnasio.GetRutinas()) {
            if (r.GetMiembrosAsignados().size() > maxMiembros) {
                maxMiembros = r.GetMiembrosAsignados().size();
                rutinaTop = r;
            }
        }
        if (rutinaTop != null) {
            System.out.println("Rutina más popular: " + rutinaTop.GetNombre() +
                    " con " + maxMiembros + " practicantes.");
        }

        
        System.out.println("Total de rutinas activas: " + gimnasio.GetRutinas().size());

        
        Entrenador entrenadorTop = null;
        int maxAlumnos = 0;
        for (Entrenador e : gimnasio.GetEntrenadores()) {
            if (e.GetMiembrosAsignados().size() > maxAlumnos) {
                maxAlumnos = e.GetMiembrosAsignados().size();
                entrenadorTop = e;
            }
        }
        if (entrenadorTop != null) {
            System.out.println("Entrenador con más alumnos: " + entrenadorTop.GetEntrenadorAsignado() +
                    " con " + maxAlumnos + " alumnos.");
        }
    }
}