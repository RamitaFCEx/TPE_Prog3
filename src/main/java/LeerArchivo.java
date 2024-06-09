import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LeerArchivo {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String procesadoresArchivo;
        String tareasArchivo;
        boolean archivosValidos = false;
        String asignarTareas;

        while (!archivosValidos) {
            System.out.println("Ingrese el nombre del archivo de procesadores (con extensión .csv):");
            //procesadoresArchivo = "src/main/resources/" + scanner.nextLine();

            procesadoresArchivo = "src/main/resources/" + "procesadores.csv";

            System.out.println("Ingrese el nombre del archivo de tareas (con extensión .csv):");
            //tareasArchivo = "src/main/resources/" + scanner.nextLine();
            tareasArchivo = "src/main/resources/" + "tareas.csv";

            if (Files.exists(Paths.get(procesadoresArchivo)) && Files.exists(Paths.get(tareasArchivo))) {
                archivosValidos = true;
                Servicio s=new Servicio(procesadoresArchivo,tareasArchivo);

                Tarea pruebaServ1 = s.servicio1("499");

                List<Tarea> pruebaServ2T = s.servicio2(true);
                List<Tarea> pruebaServ2F = s.servicio2(false);
                List<Tarea> pruebaServ3 = s.servicio3(2,15);
                asignarTareas = "y";

                if(asignarTareas.equalsIgnoreCase("Y")){
                    System.out.println("Ingrese el tiempo de ejecucion max para los procesadores no refrigerados:");
                    //tiempoDEMax = Integer.parseInt(scanner.nextLine());
                    s.asignarTareas(15);
                }

                String ss=" ";

            } else {
                System.out.println("Uno o ambos archivos no existen en la carpeta 'resources'. Intente de nuevo.");
            }
        }
        scanner.close();

    }


}


