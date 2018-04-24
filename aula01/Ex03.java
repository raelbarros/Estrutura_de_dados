package aula01;
import java.util.Arrays;


public class Ex03 {
	public static void main(String[] args) {
		int []v = {1, 2, 3, 4, 5, 6, 7};
		deslocar(v, 3);
		System.out.println(Arrays.toString(v));
	}

	private static void deslocar(int[] v, int k) {
		int n = v.length;
		inverter(v, 0, k);
		inverter(v, k + 1, n - 1);
		inverter(v, 0, n - 1);
		
	}

	private static void inverter(int[] v, int inicio, int fim) {
		while (inicio < fim){
			trocar(v, inicio, fim);
			inicio++; fim--;
		}
		
	}

	private static void trocar(int[] v, int inicio, int fim) {
		int aux = v[inicio];
		v[inicio] = v[fim];
		v[fim] = aux;
	}

}
