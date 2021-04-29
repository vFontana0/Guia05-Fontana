
public class servicioPersonalizado extends Servicio{
private double presupuesto;
private double costoMateriales;
private double costoTransporte;


public servicioPersonalizado(Oficio oficio, double presupuesto, double costoMateriales, double costoTransporte) {
	this.oficio = oficio;
	this.presupuesto = presupuesto;
	this.costoMateriales = costoMateriales;
	this.costoTransporte = costoTransporte;
}



	public Double costo() {
		return presupuesto + costoMateriales + costoTransporte;
	}


}
