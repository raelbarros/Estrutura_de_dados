package aula01;
import java.util.Arrays;


public class Ex01 {
	public static void main(String[] args) {
		int v[] = {8,9,4,2,6,10,2,5,3,15,12,10};
		
		int []retorno = maior_segundoMaior(v);
		
		System.out.println(Arrays.toString(retorno));
	}

	private static int[] maior_segundoMaior(int[] v) {
		int []retorno = new int[2];
		
		int idx_maior;
		
		for (int j = 0; j < 2; j++){
			idx_maior = j;
			for (int i = j + 1; i < v.length; i++){
				if (v[i] > v[idx_maior])
					idx_maior = i;
			}
			trocar(v, j, idx_maior);
			retorno[j] = v[j];

		}	
		return retorno;
	}

	private static void trocar(int[] v, int i, int idx_maior) {
		int aux = v[i];
		v[i] = v[idx_maior];
		v[idx_maior] = aux;
		
	}
}
