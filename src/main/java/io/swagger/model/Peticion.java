package io.swagger.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class Peticion  {
  
  @ApiModelProperty(required = true, value = "Número folio asignado por el solicitante para identificar el crédito")
 /**
   * Número folio asignado por el solicitante para identificar el crédito
  **/
  private Long folio = null;

  @ApiModelProperty(required = true, value = "Número de cuenta que reportan a Círculo de Crédito")
 /**
   * Número de cuenta que reportan a Círculo de Crédito
  **/
  private String numeroCuenta = null;

  @ApiModelProperty(required = true, value = "Tipo de contrato reportado a Circulo de Credito")
 /**
   * Tipo de contrato reportado a Circulo de Credito
  **/
  private String tipoContrato = null;

  @ApiModelProperty(required = true, value = "Tipo de cuenta dentro del catálogo")
 /**
   * Tipo de cuenta dentro del catálogo
  **/
  private String tipoCuenta = null;

  @ApiModelProperty(required = true, value = "Clasificación de la frecuencia de pago. Ver catálogo")
 /**
   * Clasificación de la frecuencia de pago. Ver catálogo
  **/
  private String tipoFrecuencia = null;

  @ApiModelProperty(required = true, value = "Número de periodos vencidos de la cuenta. Ver catálogo")
 /**
   * Número de periodos vencidos de la cuenta. Ver catálogo
  **/
  private String periodosVencidos = null;

  @ApiModelProperty(required = true, value = "Días de atraso de la cuenta. Debe de ser mayor a cero.")
 /**
   * Días de atraso de la cuenta. Debe de ser mayor a cero.
  **/
  private Integer diasAtraso = null;

  @ApiModelProperty(required = true, value = "Saldo actual de la deuda")
 /**
   * Saldo actual de la deuda
  **/
  private BigDecimal saldo = null;

  @ApiModelProperty(required = true, value = "Fecha de apertura del crédito  (DD/MM/YYYY)")
 /**
   * Fecha de apertura del crédito  (DD/MM/YYYY)
  **/
  private String fechaApertura = null;

  @ApiModelProperty(value = "Apellido paterno de la persona.")
 /**
   * Apellido paterno de la persona.
  **/
  private String apellidoParterno = null;

  @ApiModelProperty(value = "Apellido materno de la persona.")
 /**
   * Apellido materno de la persona.
  **/
  private String apellidoMaterno = null;

  @ApiModelProperty(value = "Nombre de la persona")
 /**
   * Nombre de la persona
  **/
  private String nombres = null;

  @ApiModelProperty(value = "Fecha de nacimiento de la persona, en el formato especificado (por defecto DD/MM/YYYY).")
 /**
   * Fecha de nacimiento de la persona, en el formato especificado (por defecto DD/MM/YYYY).
  **/
  private String fechaNacimiento = null;

  @ApiModelProperty(value = "RFC con homoclave de la persona.")
 /**
   * RFC con homoclave de la persona.
  **/
  private String rfc = null;

  @ApiModelProperty(value = "Calle y número del domicilio.")
 /**
   * Calle y número del domicilio.
  **/
  private String direccion = null;

  @ApiModelProperty(value = "Colonia en que se ubica domicilio.")
 /**
   * Colonia en que se ubica domicilio.
  **/
  private String coloniaPoblacion = null;

  @ApiModelProperty(value = "Municipio en que se ubica el domicilio.")
 /**
   * Municipio en que se ubica el domicilio.
  **/
  private String delegacionMunicipio = null;

  @ApiModelProperty(value = "Ciudad en que se ubica el domicilio.")
 /**
   * Ciudad en que se ubica el domicilio.
  **/
  private String ciudad = null;


@XmlType(name="EstadoEnum")
@XmlEnum(String.class)
public enum EstadoEnum {

@XmlEnumValue("AGS") AGS(String.valueOf("AGS")), @XmlEnumValue("BC") BC(String.valueOf("BC")), @XmlEnumValue("BCS") BCS(String.valueOf("BCS")), @XmlEnumValue("CAMP") CAMP(String.valueOf("CAMP")), @XmlEnumValue("COAH") COAH(String.valueOf("COAH")), @XmlEnumValue("COL") COL(String.valueOf("COL")), @XmlEnumValue("CHIS") CHIS(String.valueOf("CHIS")), @XmlEnumValue("CHIH") CHIH(String.valueOf("CHIH")), @XmlEnumValue("CDMX") CDMX(String.valueOf("CDMX")), @XmlEnumValue("DGO") DGO(String.valueOf("DGO")), @XmlEnumValue("GTO") GTO(String.valueOf("GTO")), @XmlEnumValue("GRO") GRO(String.valueOf("GRO")), @XmlEnumValue("HGO") HGO(String.valueOf("HGO")), @XmlEnumValue("JAL") JAL(String.valueOf("JAL")), @XmlEnumValue("MEX") MEX(String.valueOf("MEX")), @XmlEnumValue("MICH") MICH(String.valueOf("MICH")), @XmlEnumValue("MOR") MOR(String.valueOf("MOR")), @XmlEnumValue("NAY") NAY(String.valueOf("NAY")), @XmlEnumValue("NL") NL(String.valueOf("NL")), @XmlEnumValue("OAX") OAX(String.valueOf("OAX")), @XmlEnumValue("PUE") PUE(String.valueOf("PUE")), @XmlEnumValue("QRO") QRO(String.valueOf("QRO")), @XmlEnumValue("QROO") QROO(String.valueOf("QROO")), @XmlEnumValue("SLP") SLP(String.valueOf("SLP")), @XmlEnumValue("SIN") SIN(String.valueOf("SIN")), @XmlEnumValue("SON") SON(String.valueOf("SON")), @XmlEnumValue("TAB") TAB(String.valueOf("TAB")), @XmlEnumValue("TAMP") TAMP(String.valueOf("TAMP")), @XmlEnumValue("TLAX") TLAX(String.valueOf("TLAX")), @XmlEnumValue("VER") VER(String.valueOf("VER")), @XmlEnumValue("YUC") YUC(String.valueOf("YUC")), @XmlEnumValue("ZAC") ZAC(String.valueOf("ZAC"));


    private String value;

    EstadoEnum (String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static EstadoEnum fromValue(String v) {
        for (EstadoEnum b : EstadoEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}

  @ApiModelProperty(value = "Estado en que se ubica el domicilio.")
 /**
   * Estado en que se ubica el domicilio.
  **/
  private EstadoEnum estado = null;

  @ApiModelProperty(value = "Código postal al que pertenece el domicilio.")
 /**
   * Código postal al que pertenece el domicilio.
  **/
  private String cp = null;
 /**
   * Número folio asignado por el solicitante para identificar el crédito
   * @return folio
  **/
  @JsonProperty("folio")
  public Long getFolio() {
    return folio;
  }

  public void setFolio(Long folio) {
    this.folio = folio;
  }

  public Peticion folio(Long folio) {
    this.folio = folio;
    return this;
  }

 /**
   * Número de cuenta que reportan a Círculo de Crédito
   * @return numeroCuenta
  **/
  @JsonProperty("numeroCuenta")
  public String getNumeroCuenta() {
    return numeroCuenta;
  }

  public void setNumeroCuenta(String numeroCuenta) {
    this.numeroCuenta = numeroCuenta;
  }

  public Peticion numeroCuenta(String numeroCuenta) {
    this.numeroCuenta = numeroCuenta;
    return this;
  }

 /**
   * Tipo de contrato reportado a Circulo de Credito
   * @return tipoContrato
  **/
  @JsonProperty("tipoContrato")
  public String getTipoContrato() {
    return tipoContrato;
  }

  public void setTipoContrato(String tipoContrato) {
    this.tipoContrato = tipoContrato;
  }

  public Peticion tipoContrato(String tipoContrato) {
    this.tipoContrato = tipoContrato;
    return this;
  }

 /**
   * Tipo de cuenta dentro del catálogo
   * @return tipoCuenta
  **/
  @JsonProperty("tipoCuenta")
  public String getTipoCuenta() {
    return tipoCuenta;
  }

  public void setTipoCuenta(String tipoCuenta) {
    this.tipoCuenta = tipoCuenta;
  }

  public Peticion tipoCuenta(String tipoCuenta) {
    this.tipoCuenta = tipoCuenta;
    return this;
  }

 /**
   * Clasificación de la frecuencia de pago. Ver catálogo
   * @return tipoFrecuencia
  **/
  @JsonProperty("tipoFrecuencia")
  public String getTipoFrecuencia() {
    return tipoFrecuencia;
  }

  public void setTipoFrecuencia(String tipoFrecuencia) {
    this.tipoFrecuencia = tipoFrecuencia;
  }

  public Peticion tipoFrecuencia(String tipoFrecuencia) {
    this.tipoFrecuencia = tipoFrecuencia;
    return this;
  }

 /**
   * Número de periodos vencidos de la cuenta. Ver catálogo
   * @return periodosVencidos
  **/
  @JsonProperty("periodosVencidos")
  public String getPeriodosVencidos() {
    return periodosVencidos;
  }

  public void setPeriodosVencidos(String periodosVencidos) {
    this.periodosVencidos = periodosVencidos;
  }

  public Peticion periodosVencidos(String periodosVencidos) {
    this.periodosVencidos = periodosVencidos;
    return this;
  }

 /**
   * Días de atraso de la cuenta. Debe de ser mayor a cero.
   * minimum: 1
   * @return diasAtraso
  **/
  @JsonProperty("diasAtraso")
  public Integer getDiasAtraso() {
    return diasAtraso;
  }

  public void setDiasAtraso(Integer diasAtraso) {
    this.diasAtraso = diasAtraso;
  }

  public Peticion diasAtraso(Integer diasAtraso) {
    this.diasAtraso = diasAtraso;
    return this;
  }

 /**
   * Saldo actual de la deuda
   * @return saldo
  **/
  @JsonProperty("saldo")
  public BigDecimal getSaldo() {
    return saldo;
  }

  public void setSaldo(BigDecimal saldo) {
    this.saldo = saldo;
  }

  public Peticion saldo(BigDecimal saldo) {
    this.saldo = saldo;
    return this;
  }

 /**
   * Fecha de apertura del crédito  (DD/MM/YYYY)
   * @return fechaApertura
  **/
  @JsonProperty("fechaApertura")
  public String getFechaApertura() {
    return fechaApertura;
  }

  public void setFechaApertura(String fechaApertura) {
    this.fechaApertura = fechaApertura;
  }

  public Peticion fechaApertura(String fechaApertura) {
    this.fechaApertura = fechaApertura;
    return this;
  }

 /**
   * Apellido paterno de la persona.
   * @return apellidoParterno
  **/
  @JsonProperty("apellidoParterno")
  public String getApellidoParterno() {
    return apellidoParterno;
  }

  public void setApellidoParterno(String apellidoParterno) {
    this.apellidoParterno = apellidoParterno;
  }

  public Peticion apellidoParterno(String apellidoParterno) {
    this.apellidoParterno = apellidoParterno;
    return this;
  }

 /**
   * Apellido materno de la persona.
   * @return apellidoMaterno
  **/
  @JsonProperty("apellidoMaterno")
  public String getApellidoMaterno() {
    return apellidoMaterno;
  }

  public void setApellidoMaterno(String apellidoMaterno) {
    this.apellidoMaterno = apellidoMaterno;
  }

  public Peticion apellidoMaterno(String apellidoMaterno) {
    this.apellidoMaterno = apellidoMaterno;
    return this;
  }

 /**
   * Nombre de la persona
   * @return nombres
  **/
  @JsonProperty("nombres")
  public String getNombres() {
    return nombres;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  public Peticion nombres(String nombres) {
    this.nombres = nombres;
    return this;
  }

 /**
   * Fecha de nacimiento de la persona, en el formato especificado (por defecto DD/MM/YYYY).
   * @return fechaNacimiento
  **/
  @JsonProperty("fechaNacimiento")
  public String getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public Peticion fechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
    return this;
  }

 /**
   * RFC con homoclave de la persona.
   * @return rfc
  **/
  @JsonProperty("rfc")
  public String getRfc() {
    return rfc;
  }

  public void setRfc(String rfc) {
    this.rfc = rfc;
  }

  public Peticion rfc(String rfc) {
    this.rfc = rfc;
    return this;
  }

 /**
   * Calle y número del domicilio.
   * @return direccion
  **/
  @JsonProperty("direccion")
  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public Peticion direccion(String direccion) {
    this.direccion = direccion;
    return this;
  }

 /**
   * Colonia en que se ubica domicilio.
   * @return coloniaPoblacion
  **/
  @JsonProperty("coloniaPoblacion")
  public String getColoniaPoblacion() {
    return coloniaPoblacion;
  }

  public void setColoniaPoblacion(String coloniaPoblacion) {
    this.coloniaPoblacion = coloniaPoblacion;
  }

  public Peticion coloniaPoblacion(String coloniaPoblacion) {
    this.coloniaPoblacion = coloniaPoblacion;
    return this;
  }

 /**
   * Municipio en que se ubica el domicilio.
   * @return delegacionMunicipio
  **/
  @JsonProperty("delegacionMunicipio")
  public String getDelegacionMunicipio() {
    return delegacionMunicipio;
  }

  public void setDelegacionMunicipio(String delegacionMunicipio) {
    this.delegacionMunicipio = delegacionMunicipio;
  }

  public Peticion delegacionMunicipio(String delegacionMunicipio) {
    this.delegacionMunicipio = delegacionMunicipio;
    return this;
  }

 /**
   * Ciudad en que se ubica el domicilio.
   * @return ciudad
  **/
  @JsonProperty("ciudad")
  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public Peticion ciudad(String ciudad) {
    this.ciudad = ciudad;
    return this;
  }

 /**
   * Estado en que se ubica el domicilio.
   * @return estado
  **/
  @JsonProperty("estado")
  public String getEstado() {
    if (estado == null) {
      return null;
    }
    return estado.value();
  }

  public void setEstado(EstadoEnum estado) {
    this.estado = estado;
  }

  public Peticion estado(EstadoEnum estado) {
    this.estado = estado;
    return this;
  }

 /**
   * Código postal al que pertenece el domicilio.
   * @return cp
  **/
  @JsonProperty("cp")
  public String getCp() {
    return cp;
  }

  public void setCp(String cp) {
    this.cp = cp;
  }

  public Peticion cp(String cp) {
    this.cp = cp;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Peticion {\n");
    
    sb.append("    folio: ").append(toIndentedString(folio)).append("\n");
    sb.append("    numeroCuenta: ").append(toIndentedString(numeroCuenta)).append("\n");
    sb.append("    tipoContrato: ").append(toIndentedString(tipoContrato)).append("\n");
    sb.append("    tipoCuenta: ").append(toIndentedString(tipoCuenta)).append("\n");
    sb.append("    tipoFrecuencia: ").append(toIndentedString(tipoFrecuencia)).append("\n");
    sb.append("    periodosVencidos: ").append(toIndentedString(periodosVencidos)).append("\n");
    sb.append("    diasAtraso: ").append(toIndentedString(diasAtraso)).append("\n");
    sb.append("    saldo: ").append(toIndentedString(saldo)).append("\n");
    sb.append("    fechaApertura: ").append(toIndentedString(fechaApertura)).append("\n");
    sb.append("    apellidoParterno: ").append(toIndentedString(apellidoParterno)).append("\n");
    sb.append("    apellidoMaterno: ").append(toIndentedString(apellidoMaterno)).append("\n");
    sb.append("    nombres: ").append(toIndentedString(nombres)).append("\n");
    sb.append("    fechaNacimiento: ").append(toIndentedString(fechaNacimiento)).append("\n");
    sb.append("    rfc: ").append(toIndentedString(rfc)).append("\n");
    sb.append("    direccion: ").append(toIndentedString(direccion)).append("\n");
    sb.append("    coloniaPoblacion: ").append(toIndentedString(coloniaPoblacion)).append("\n");
    sb.append("    delegacionMunicipio: ").append(toIndentedString(delegacionMunicipio)).append("\n");
    sb.append("    ciudad: ").append(toIndentedString(ciudad)).append("\n");
    sb.append("    estado: ").append(toIndentedString(estado)).append("\n");
    sb.append("    cp: ").append(toIndentedString(cp)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private static String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
