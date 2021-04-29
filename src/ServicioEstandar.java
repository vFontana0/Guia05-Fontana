
public class ServicioEstandar extends Servicio{
	
	private Double montoFijo;
	private Double serviciosProfesionales;
	
	public ServicioEstandar(Oficio oficio, Double montoFijo, Double serviciosProfesionales) {
		this.oficio = oficio;
		this.montoFijo = montoFijo;
		this.serviciosProfesionales = serviciosProfesionales;
	}
	

	public Double costo() {
		return montoFijo + serviciosProfesionales;
	}


	

}
