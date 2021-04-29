import java.time.LocalDate;

public class Trabajo implements Contratable {
private Servicio servicio;
private LocalDate fechaInicio;
private LocalDate fechaFin = null;
private Boolean urgente;

public Trabajo(Servicio servicio, LocalDate fecha, Boolean urgente) {
	this.servicio = servicio;
	this.fechaInicio = fecha;
	this.urgente = urgente;
}

public double Precio() {
	double costoServicio = servicio.costo();
	
	if(this.urgente) {
		costoServicio*=1.50;
	}
	return costoServicio;
}

public Oficio getOficio() {
	return this.servicio.getOficio();
}

public Boolean finalizado() {
	Boolean ret = true;
	if(fechaFin == null || (fechaFin != null && fechaFin.isAfter(LocalDate.now()))) {
		ret=false;
	}
	return ret;
}


public LocalDate getFecha() {
	return fechaInicio;
}

public void finalizar(LocalDate fecha) {
	this.fechaFin = fecha;
}


}
