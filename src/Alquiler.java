
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alquiler implements Contratable{
private Herramienta herramienta;
private LocalDate fechaInicio;
private LocalDate fechaFin;
private LocalDate hoy = LocalDate.now();
private LocalDate fechaFinReal = null;
@Override



public double Precio() {
	if(fechaFinReal != null) {
		return (ChronoUnit.DAYS.between(fechaInicio, fechaFinReal))*herramienta.getCostoPorDia();
	} else {
		return (ChronoUnit.DAYS.between(fechaInicio, hoy))*herramienta.getCostoPorDia();
	}
}

public Alquiler(Herramienta herramienta, LocalDate fechaInicio, int cantDias) {
	this.herramienta = herramienta;
	this.fechaInicio = fechaInicio;
	this.fechaFin = fechaInicio.plusDays(cantDias);
	this.fechaFinReal = null;
}

public Boolean enMora() {
	Boolean ret = false;
	LocalDate hoy = LocalDate.now();
	if((fechaFinReal != null && fechaFinReal.isAfter(fechaFin)) || (fechaFinReal == null && hoy.isAfter(fechaFin))) {
		ret = true;
	}
	return ret;
}

@Override
public Boolean finalizado() {
	Boolean ret = false;
	if(this.fechaFinReal != null) {
		ret = true;
	}
	
	return ret;
}

public void devolver(LocalDate fechaDev) {
	this.fechaFinReal = fechaDev;
}

}
