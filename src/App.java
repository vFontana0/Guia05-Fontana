import java.time.LocalDate;

public class App {

	
public static void main(String[] args) {
	
	//Crear entidades
	Oficio s1 = new Oficio("Carpinteria");
	Oficio s4 = new Oficio("Albanileria");
	
	Servicio pintarCasa = new ServicioEstandar(s4, 50000.0, 500.0);
	Servicio arreglarCasa = new servicioPersonalizado(s4, 30000.0, 15000.0, 2000.0);
	Servicio hacerMueble = new ServicioEstandar(s1, 20000.0, 400.0);
	
	Herramienta martillo = new Herramienta("Herramienta", 350.0);
	
	Alquiler a1 = new Alquiler(martillo, LocalDate.now().minusDays(5), 7);
	Alquiler a2 = new Alquiler(martillo, LocalDate.now().minusDays(5), 4);
	Alquiler a3 = new Alquiler(martillo, LocalDate.now().minusDays(4), 8);
	Alquiler a4 = new Alquiler(martillo, LocalDate.now().minusDays(3), 9);
	Alquiler a5 = new Alquiler(martillo, LocalDate.now().minusDays(3), 10);
	
	Trabajador t1 = new Trabajador("Juan", "juan@gmail.com", s4, 500.00, 20.00);
	
	Trabajo trabajo = new Trabajo(pintarCasa, LocalDate.now(), true);
	Trabajo trabajo2 = new Trabajo(pintarCasa, LocalDate.now(), false);
	Trabajo trabajo3 = new Trabajo(pintarCasa, LocalDate.now().plusDays(2), false);
	Trabajo trabajo4 = new Trabajo(hacerMueble, LocalDate.now().plusDays(2), false);
	Trabajo trabajo5 = new Trabajo(arreglarCasa, LocalDate.now().plusDays(2), false);
	
	Usuario u1 = new Usuario("u1@gmail.com");

	//Prueba de metodos
	
	System.out.println("Alquiler 1 - Precio: " + a1.Precio()); //Se calcula el precio por los dias hasta la fecha ya que no se devolvio.
	System.out.println("Alquiler 1 - Finalizado: " + a1.finalizado());
	System.out.println("Alquiler 1 - enMora: " + a1.enMora());
	
	a1.devolver(LocalDate.now().plusDays(15)); //Se devuelve la herramienta luego de la fecha estipulada
	
	System.out.println("Alquiler 1 - Precio: " + a1.Precio()); //Se calcula el precio con la fecha que se devolvio
	System.out.println("Alquiler 1 - Finalizado: " + a1.finalizado());
	System.out.println("Alquiler 1 - enMora: " + a1.enMora());	//Esta en mora debido a que fue devuelta luego de la fecha de fin
	System.out.println("Alquiler 2 - enMora: " + a1.enMora()); //Debe estar en mora ya que no fue devuelto pero la fecha es posterior a la de devolucion
	
	System.out.println("Trabajo 1 - Precio " + trabajo.Precio()); //es urgente
	System.out.println("Trabajo 2 - Precio " + trabajo2.Precio()); //mismo servicio que el anterior, no es urgente
	System.out.println("Trabajo 5 - Precio " + trabajo5.Precio());

	try {
		System.out.println("t1 - agregarTrabajo: " + t1.agregarTrabajo(trabajo));
		System.out.println("t1 - agregarTrabajo: " + t1.agregarTrabajo(trabajo3)); //Se agrega ya que el dia no coincide
		System.out.println(t1.agregarTrabajo(trabajo2)); //No se puede agregar ya que tiene otro trabajo el mismo dia.
		System.out.println(t1.agregarTrabajo(trabajo4)); //No se puede agregar ya que no coincide el oficio.
	} catch (OficioNoCoincideException e) {
		System.out.println(e.getMessage());
	} catch (AgendaOcupadaException e) {
		System.out.println(e.getMessage());
	}
	
	System.out.println("Trabajo2 - finalizado: " + trabajo2.finalizado()); //trabajo no esta finalizado
	trabajo2.finalizar(LocalDate.now()); //Se setea la fecha de fin
	System.out.println("Trabajo2 - finalizado: " + trabajo2.finalizado()); //trabajo tiene fecha de fin

	
	try {
		System.out.println("u1 - contratarTrabajo: " + u1.Contratar(trabajo2)); //no hay problema con los trabajos
		System.out.println("u1 - alquilar: " + u1.Contratar(a2)); //tiene 0 alquileres sin devolver asi que puede
		System.out.println("u1 - alquilar: " + u1.Contratar(a3)); //tiene 1 alquileres sin devolver asi que puede
		System.out.println("u1 - alquilar: " + u1.Contratar(a4)); //tiene 2 alquileres sin devolver asi que puede
		System.out.println("u1 - alquilar: " + u1.Contratar(a5)); //tiene 3 alquileres sin devolver asi que no puede
		
	} catch (AlquilerNoEntregadoException e) {
		System.out.println(e.getMessage());
	}
	
	
	}
}
