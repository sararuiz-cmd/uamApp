import dao.CarreraDao;
import modelos.Carrera;

public class Main {
    public static void main(String[] args) {

        CarreraDao registro = new CarreraDao();

        // GUARDAR
        Carrera nuevaCarrera = new Carrera(null, "Ingeniería de Sistemas", 250);
        registro.guardar(nuevaCarrera);

        // LISTAR
        System.out.println("Lista de carreras:");
        for (Carrera c : registro.listar()) {
            System.out.println(c);
        }

        // BUSCAR POR ID
        Carrera carreraEncontrada = registro.buscarPorId(1L);

        if (carreraEncontrada != null) {
            System.out.println("Carrera encontrada:");
            System.out.println(carreraEncontrada);
        } else {
            System.out.println("No se encontró la carrera.");
        }

        // ACTUALIZAR
        Carrera carreraActualizar = registro.buscarPorId(1L);

        if (carreraActualizar != null) {
            carreraActualizar.setNombre("Ingeniería en Sistemas Actualizada");
            carreraActualizar.setPrecio(300);
            registro.actualizar(carreraActualizar);
        }

        // ELIMINAR
        // registro.eliminar(1L);

        // Cerrar EntityManagerFactory al final
        configuracion.JPAUtil.close();
    }
}