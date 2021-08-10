package datas;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {

	public static void main(String[] args) {
		
		LocalDate agora = LocalDate.now();
		LocalDate dataFutura = LocalDate.of(2099, Month.JANUARY, 25);

		Period periodo = Period.between(agora, dataFutura);
		
		//Periodo entre as datas
		System.out.println(periodo.getYears());
		
		DateTimeFormatter n = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(n.format(agora));
	}

}
