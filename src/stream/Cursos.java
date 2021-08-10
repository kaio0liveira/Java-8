package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Cursos implements Comparable<Integer>{

	private String nome;
	private Integer alunos;

	public Cursos(String nome, int alunos) {
		super();
		this.nome = nome;
		this.alunos = alunos;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getAlunos() {
		return alunos;
	}
	public void setAlunos(int alunos) {
		this.alunos = alunos;
	}


	@Override
	public String toString() {
		return "Cursos [nome=" + nome + ", alunos=" + alunos + "]";
	}


	@Override
	public int compareTo(Integer o) {
		return o.compareTo(getAlunos());
		
	}
	
	
	
}

class ExemploCursos{
	public static void main(String[] args) {
		List<Cursos> cursos = new ArrayList<>();
		cursos.add(new Cursos("Python", 45));
		cursos.add(new Cursos("JavaScript", 150));
		cursos.add(new Cursos("Java", 113));
		cursos.add(new Cursos("C", 55));
		
		cursos.sort(Comparator.comparing(c -> c.getAlunos()));
		
		cursos.forEach(c -> System.out.println(c.getNome()));
		
		
		//Atribuindo a soma de numeros de alunos maiores que 100.
		int sum = cursos.stream().filter(curso -> curso.getAlunos() > 100).mapToInt(c -> c.getAlunos())
		.sum();
		System.out.println(sum);
		
		
//		Comparator<Cursos> nu = (n1,n2) -> {
//			return n1.getAlunos().compareTo(n2.getAlunos()) ;
//			
//		};
		
		//Retornando o curso que tenha o menor número de alunos.
		Optional <Cursos> n = cursos.stream().min(Comparator.comparing(c -> c.getAlunos()));	
		//System.out.println(n);
		
		cursos.stream().filter(c -> c.getAlunos() >= 100)
		.findAny()
		.ifPresent(c -> System.out.println(c.getNome()));

		//cursos = cursos.stream().filter(c -> c.getAlunos() >= 100).collect(Collectors.toList());
		
		System.out.println("=================");
		cursos.stream().
		collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()))
		.forEach((nome, aluno) ->{
			System.out.println("Curso: " + nome+ "Qtd alunos: "+ aluno);
		});
		
		//calcula a media da lista.
		Double result = cursos.stream().mapToInt(m -> m.getAlunos()).average().getAsDouble();
		
		System.out.println(result);
	}
}
