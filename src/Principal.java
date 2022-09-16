

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Principal {
	

	static int numeros[] = {10, 2, 5, 6, 8, 3, 7, 9};
	
	public static int media() {
		int total = 0;
		for (int i = 0; i < numeros.length; i++) {
			total += numeros[i];
		}
		return total/numeros.length;
	}
	
	public static int maior() {
		int maior = 0;
		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] >= maior) {
				maior = numeros[i];
			}
		}
		return maior;
	}
	
	public static int menor() {
		int menor = Integer.MAX_VALUE;
		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] < menor) {
				menor = numeros[i];
			}
		}
		return menor;
	}
	
	public static List<Integer> ordena() {
		List<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < numeros.length; i++) {
			a.add(numeros[i]);
		}
		Collections.sort(a);
		return a;
	}
	
	public static Runnable t1 = new Runnable() {
		public void run() {
			System.out.println(Principal.media());
		}
	};
	
	public static Runnable t2 = new Runnable() {
		public void run() {
			System.out.println(Principal.maior());
		}
	};
	
	public static Runnable t3 = new Runnable() {
		public void run() {
			System.out.println(Principal.menor());
		}
	};
	
	public static Runnable t4 = new Runnable() {
		public void run() {
			List<Integer> lista = Principal.ordena();
			for (Integer integer : lista) {
				System.out.print(integer + " ");
			}
		}
	};
	
	
	public static void main(String[] args) throws InterruptedException {

		System.out.println("Inicio");
		Thread th1 = new Thread(t1);
		th1.start();
		
		Thread th2 = new Thread(t2);
		th2.start();
		
		Thread th3 = new Thread(t3);
		th3.start();
		
		Thread th4 = new Thread(t4);
		th4.start();

		System.out.println("Fim");
		
	}
	

}