package Utilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Util {

	static NumberFormat formatarValores = new DecimalFormat("R$ #,##0.00");

	// converte uma String para double
	public static String doubleToString(double valor) {
		return formatarValores.format(valor);
	}
}
