

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ExemploConcorrencia extends RecursiveAction {
	
	private static final long serialVersionUID = -1239388207015743433L;
	private String palavra;
	private static int LIMITE = 3;
	
	private static final String textoBase = "francisco";
	private String lista[];
	
	public ExemploConcorrencia(String palavra, String lista[]) {
		this.palavra = palavra;
		this.lista = lista;
	}
	
	@Override
	protected void compute() {
		if(palavra.length() > LIMITE) {
			ForkJoinTask.invokeAll(criaSubTarefas());
		} else {
			reorganizaPalavra(transformaPalavra(palavra));
		}
	}
	
	protected List<ExemploConcorrencia> criaSubTarefas(){
		
		List<ExemploConcorrencia> subTarefas =  new ArrayList<>();
		String parte1 = palavra.substring(0, palavra.length() / 2);
		String parte2 = palavra.substring(palavra.length() / 2, palavra.length() );
		
		subTarefas.add(new ExemploConcorrencia(parte1, lista));
		subTarefas.add(new ExemploConcorrencia(parte2, lista));
		
		return subTarefas;
	}
	
	protected void reorganizaPalavra(String resultado) {
		for (int i = 0; i < resultado.length(); i++) {
			String a = Character.toString(resultado.charAt(i));
			for (int j = 0; j < textoBase.length(); j++) {
				String b = Character.toString(textoBase.charAt(j));
				if (a.equalsIgnoreCase(b)) {
					lista[j] = a;
				}
			}
			System.out.println(a + " Foi processado por: " + Thread.currentThread().getName());
		}
	}
	
	protected String transformaPalavra(String palavra) {
		String resultado = palavra.toUpperCase();
		return resultado;
	}
	
	protected void imprime() {
		for (int i = 0; i < lista.length; i++) {
			System.out.println(lista[i]);
		}
	}
	
	public static void main(String[] args) {
		ExemploConcorrencia e = new ExemploConcorrencia(textoBase, new String[textoBase.length()]);
		e.compute();
		e.imprime();
		
	}

}
