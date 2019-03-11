package io.swagger.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class Respuesta  {
  
  @ApiModelProperty(required = true, value = "Número folio asignado por el solicitante para identificar el crédito")
 /**
   * Número folio asignado por el solicitante para identificar el crédito
  **/
  private String folio = null;

  @ApiModelProperty(value = "Folio de respuesta")
 /**
   * Folio de respuesta
  **/
  private String folioRespuestaCDC = null;

  @ApiModelProperty(value = "Segmentación de la cuenta A-F donde las primeras letras del alfabeto indican un mayor índice de aceptacion")
 /**
   * Segmentación de la cuenta A-F donde las primeras letras del alfabeto indican un mayor índice de aceptacion
  **/
  private String segmentos = null;

  @ApiModelProperty(value = "Versión del segmento")
 /**
   * Versión del segmento
  **/
  private String versionSegmentos = null;
 /**
   * Número folio asignado por el solicitante para identificar el crédito
   * @return folio
  **/
  @JsonProperty("folio")
  public String getFolio() {
    return folio;
  }

  public void setFolio(String folio) {
    this.folio = folio;
  }

  public Respuesta folio(String folio) {
    this.folio = folio;
    return this;
  }

 /**
   * Folio de respuesta
   * @return folioRespuestaCDC
  **/
  @JsonProperty("folioRespuestaCDC")
  public String getFolioRespuestaCDC() {
    return folioRespuestaCDC;
  }

  public void setFolioRespuestaCDC(String folioRespuestaCDC) {
    this.folioRespuestaCDC = folioRespuestaCDC;
  }

  public Respuesta folioRespuestaCDC(String folioRespuestaCDC) {
    this.folioRespuestaCDC = folioRespuestaCDC;
    return this;
  }

 /**
   * Segmentación de la cuenta A-F donde las primeras letras del alfabeto indican un mayor índice de aceptacion
   * @return segmentos
  **/
  @JsonProperty("segmentos")
  public String getSegmentos() {
    return segmentos;
  }

  public void setSegmentos(String segmentos) {
    this.segmentos = segmentos;
  }

  public Respuesta segmentos(String segmentos) {
    this.segmentos = segmentos;
    return this;
  }

 /**
   * Versión del segmento
   * @return versionSegmentos
  **/
  @JsonProperty("versionSegmentos")
  public String getVersionSegmentos() {
    return versionSegmentos;
  }

  public void setVersionSegmentos(String versionSegmentos) {
    this.versionSegmentos = versionSegmentos;
  }

  public Respuesta versionSegmentos(String versionSegmentos) {
    this.versionSegmentos = versionSegmentos;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Respuesta {\n");
    
    sb.append("    folio: ").append(toIndentedString(folio)).append("\n");
    sb.append("    folioRespuestaCDC: ").append(toIndentedString(folioRespuestaCDC)).append("\n");
    sb.append("    segmentos: ").append(toIndentedString(segmentos)).append("\n");
    sb.append("    versionSegmentos: ").append(toIndentedString(versionSegmentos)).append("\n");
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