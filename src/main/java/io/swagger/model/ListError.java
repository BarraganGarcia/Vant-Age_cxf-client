package io.swagger.model;

import java.util.ArrayList;

import io.swagger.annotations.ApiModel;

/**
 * Si existen errores, se listarán.
 **/
@ApiModel(description = "Si existen errores, se listarán.")
public class ListError extends ArrayList<Error> {
	private static final long serialVersionUID = 5804130566788207445L;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ListError {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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
