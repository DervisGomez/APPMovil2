package com.app;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Contrato {
	private String contrato;//CONTRATO
	private String nombre;//NOMBRE
	private String cc;//CC
	private String direccionContrato;//DIRECCIONCONTRATO
	private String telefono;//TELEFONOS
	private String atraso;//ATRASOS
	private String uso;//USO
	private String estrato;//ESTRATO
	private String saldo;//SALDO
	private String unidadesResidenciales;//UNIDRESIDENCIALES
	private String unidadesNoResidenciales;//UNIDNORESIDENCIALES
	
	private String cicloFactura;// CICLOFACTURACION
	private String cicloConsumo;//CICLOCONSUMO
	private String direccionCorrespondencia;//DIRECCIONCORRESPONDENCIA
	private String rutaLectura;//RUTALECTURA
	private String rutaReparto;//RUTAREPARTO
	
	private String productoAcueducto;//PRODACUEDUCTO
	private String estadoAcueducto;//ESTADOCORTEP45
	private String productoAlcantarillado;//PRODALCANTARILLADO
	private String estadoAlcantarillado;//ESTADOCORTEP46
	
	private String numeroMedidor;//IDMEDIDOR
	private String serialMedidor;//SERIALMEDIDOR
	private String fechaInstalacion;//FINSTALACIÓN
	private String tipoMedidor;//TIPOMEDIDOR
	private String totalizador;//TOTALIZADOR
	private String medidoresHijos;//SERIALESMEDIDORESHIJOS
	private String pdoFacturacion;//PDOFACTURACIÓN
	
	public Contrato() {
		// TODO Auto-generated constructor stub
		
	}
	

	public Contrato(String contrato, String nombre, String cc,
			String direccionContrato, String telefono, String atraso,
			String uso, String estrato, String saldo,
			String unidadesResidenciales, String unidadesNoResidenciales,
			String cicloFactura, String cicloConsumo,
			String direccionCorrespondencia, String rutaLectura,
			String rutaReparto, String productoAcueducto,
			String estadoAcueducto, String productoAlcantarillado,
			String estadoAlcantarillado, String numeroMedidor,
			String serialMedidor, String fechaInstalacion, String tipoMedidor,
			String totalizador, String medidoresHijos, String pdoFacturacion) {
		super();
		this.contrato = contrato;
		this.nombre = nombre;
		this.cc = cc;
		this.direccionContrato = direccionContrato;
		this.telefono = telefono;
		this.atraso = atraso;
		this.uso = uso;
		this.estrato = estrato;
		this.saldo = saldo;
		this.unidadesResidenciales = unidadesResidenciales;
		this.unidadesNoResidenciales = unidadesNoResidenciales;
		this.cicloFactura = cicloFactura;
		this.cicloConsumo = cicloConsumo;
		this.direccionCorrespondencia = direccionCorrespondencia;
		this.rutaLectura = rutaLectura;
		this.rutaReparto = rutaReparto;
		this.productoAcueducto = productoAcueducto;
		this.estadoAcueducto = estadoAcueducto;
		this.productoAlcantarillado = productoAlcantarillado;
		this.estadoAlcantarillado = estadoAlcantarillado;
		this.numeroMedidor = numeroMedidor;
		this.serialMedidor = serialMedidor;
		this.fechaInstalacion = fechaInstalacion;
		this.tipoMedidor = tipoMedidor;
		this.totalizador = totalizador;
		this.medidoresHijos = medidoresHijos;
		this.pdoFacturacion = pdoFacturacion;
	}


	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getDireccionContrato() {
		return direccionContrato;
	}

	public void setDireccionContrato(String direccionContrato) {
		this.direccionContrato = direccionContrato;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getAtraso() {
		return atraso;
	}

	public void setAtraso(String atraso) {
		this.atraso = atraso;
	}

	public String getUso() {
		return uso;
	}

	public void setUso(String uso) {
		this.uso = uso;
	}

	public String getEstrato() {
		return estrato;
	}

	public void setEstrato(String estrato) {
		this.estrato = estrato;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public String getUnidadesResidenciales() {
		return unidadesResidenciales;
	}

	public void setUnidadesResidenciales(String unidadesResidenciales) {
		this.unidadesResidenciales = unidadesResidenciales;
	}

	public String getUnidadesNoResidenciales() {
		return unidadesNoResidenciales;
	}

	public void setUnidadesNoResidenciales(String unidadesNoResidenciales) {
		this.unidadesNoResidenciales = unidadesNoResidenciales;
	}

	public String getCicloFactura() {
		return cicloFactura;
	}

	public void setCicloFactura(String cicloFactura) {
		this.cicloFactura = cicloFactura;
	}

	public String getCicloConsumo() {
		return cicloConsumo;
	}

	public void setCicloConsumo(String cicloConsumo) {
		this.cicloConsumo = cicloConsumo;
	}

	public String getDireccionCorrespondencia() {
		return direccionCorrespondencia;
	}

	public void setDireccionCorrespondencia(String direccionCorrespondencia) {
		this.direccionCorrespondencia = direccionCorrespondencia;
	}

	public String getRutaLectura() {
		return rutaLectura;
	}

	public void setRutaLectura(String rutaLectura) {
		this.rutaLectura = rutaLectura;
	}

	public String getRutaReparto() {
		return rutaReparto;
	}

	public void setRutaReparto(String rutaReparto) {
		this.rutaReparto = rutaReparto;
	}

	public String getProductoAcueducto() {
		return productoAcueducto;
	}

	public void setProductoAcueducto(String productoAcueducto) {
		this.productoAcueducto = productoAcueducto;
	}

	public String getEstadoAcueducto() {
		return estadoAcueducto;
	}

	public void setEstadoAcueducto(String estadoAcueducto) {
		this.estadoAcueducto = estadoAcueducto;
	}

	public String getProductoAlcantarillado() {
		return productoAlcantarillado;
	}

	public void setProductoAlcantarillado(String productoAlcantarillado) {
		this.productoAlcantarillado = productoAlcantarillado;
	}

	public String getEstadoAlcantarillado() {
		return estadoAlcantarillado;
	}

	public void setEstadoAlcantarillado(String estadoAlcantarillado) {
		this.estadoAlcantarillado = estadoAlcantarillado;
	}

	public String getNumeroMedidor() {
		return numeroMedidor;
	}

	public void setNumeroMedidor(String numeroMedidor) {
		this.numeroMedidor = numeroMedidor;
	}

	public String getSerialMedidor() {
		return serialMedidor;
	}

	public void setSerialMedidor(String serialMedidor) {
		this.serialMedidor = serialMedidor;
	}

	public String getFechaInstalacion() {
		return fechaInstalacion;
	}

	public void setFechaInstalacion(String fechaInstalacion) {
		this.fechaInstalacion = fechaInstalacion;
	}

	public String getTipoMedidor() {
		return tipoMedidor;
	}

	public void setTipoMedidor(String tipoMedidor) {
		this.tipoMedidor = tipoMedidor;
	}

	public String getTotalizador() {
		return totalizador;
	}

	public void setTotalizador(String totalizador) {
		this.totalizador = totalizador;
	}

	public String getMedidoresHijos() {
		return medidoresHijos;
	}

	public void setMedidoresHijos(String medidoresHijos) {
		this.medidoresHijos = medidoresHijos;
	}

	public String getPdoFacturacion() {
		return pdoFacturacion;
	}

	public void setPdoFacturacion(String pdoFacturacion) {
		this.pdoFacturacion = pdoFacturacion;
	}
	
}
