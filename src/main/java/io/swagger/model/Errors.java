package io.swagger.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
  * Si existen errores, se listarán.
 **/
@ApiModel(description="Si existen errores, se listarán.")
public class Errors  {
  
  @ApiModelProperty(value = "")
  private List<Error> errors = null;
 /**
   * Get errors
   * @return errors
  **/
  @JsonProperty("errors")
  public List<Error> getErrors() {
    return errors;
  }

  public void setErrors(List<Error> errors) {
    this.errors = errors;
  }

  public Errors errors(List<Error> errors) {
    this.errors = errors;
    return this;
  }

  public Errors addErrorsItem(Error errorsItem) {
    this.errors.add(errorsItem);
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Errors {\n");
    
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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