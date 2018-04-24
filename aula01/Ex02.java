package aula01;
import java.util.Arrays;


public class Ex02 {

	public static void main(String[] args) {
		teste01();
		teste02();
	}

	private static void teste01() {
		int []v = {1,5,6,7,89,2,5,6,3,1,2,3,85};
		inverter(v);
		System.out.println(Arrays.toString(v));
	}
	private static void teste02() {
		int []v = {1,2,3,4,5};
		inverter(v);
		System.out.println(Arrays.toString(v));
	}

	private static void inverter(int[] v) {
		int inicio = 0;
		int fim = v.length - 1;
		
		while(inicio < fim){
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
