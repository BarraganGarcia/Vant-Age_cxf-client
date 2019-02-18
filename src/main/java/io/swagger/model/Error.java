package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Error
 **/
@ApiModel(description = "error")
public class Error {

	@ApiModelProperty(example = "VA003", value = "Código de error.")
	/**
	 * Código de error.
	 **/
	private String code = null;

	@ApiModelProperty(example = "Título de error, El campo \"campo\" es requerido.", value = "Mensaje de error.")
	/**
	 * Mensaje de error.
	 **/
	private String message = null;

	/**
	 * Código de error.
	 * 
	 * @return code
	 **/
	@JsonProperty("code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Error code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * Mensaje de error.
	 * 
	 * @return message
	 **/
	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Error message(String message) {
		this.message = message;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Error {\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
