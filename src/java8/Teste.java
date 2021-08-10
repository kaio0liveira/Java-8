package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Teste {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		
		
		
		Consumer<String> consumidor = new ImprimaNaLinha();

		ComparadorPorTamanho camparador = new ComparadorPorTamanho();
		
		palavras.sort((s1,s2)->{
			if (s1.length() > s2.length()) {
				return 1;
			}
			if (s1.length() < s2.length()) {
				return -1;
			}
			return 0;
		});
		palavras.forEach(s -> System.out.println(s));
		
	System.out.println("=====");
	Function<String, Integer> funcao = String::length;
	Function<String, Integer> funcao2 = s -> s.length();
	
	palavras.sort(Comparator.comparing(funcao2));
	
	palavras.sort(Comparator.comparing(funcao));
	palavras.forEach(s -> System.out.println(s));
	
	System.out.println("=============");

//
//		Consumer<String> consumidor2 = new Consumer<String>() {
//			public void accept(String s) {
//				System.out.println(s);
//			}
//		};
		// new Thread(() -> System.out.println("Executando um Runnable")).start();
		//palavras.forEach(consumidor2);

		System.out.println("=====================");
		palavras.forEach(new Consumer<String>() {
			public void accept(String s) {
				System.out.println(s);
			}
			
			
		});
		System.out.println("===============");
		//palavras.forEach(s -> System.out.println(s));
		palavras.forEach(System.out::println);

	}

	
}
class ImprimaNaLinha implements Consumer<String> {

	@Override
	public void accept(String t) {

		System.out.println(t);

	}
	
}

class ComparadorPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return 1;
		}
		if (s1.length() < s2.length()) {
			return -1;
		}
		return 0;
	}

}
