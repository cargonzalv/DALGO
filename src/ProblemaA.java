//Autores:
//Carlos Eduardo González Álvarez - 201511169
//Javier Antonio Troconis Guia - 201424518

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemaA {

	public static int[] metodoA(int[] datos)
	{
		int[] data = new int[datos.length];
		for(int i = 0; i < datos.length-1; i++)
		{
			for(int j = i+1; j< datos.length; j++)
			{
				int[] resp = mcdExtendido(datos[i],datos[j]);
				if(resp[0] == 1)
				{
					data[i] = resp[1];
					data[j] = resp[2];
					return data;
				}

			}
		}
		return null;


	}

	public static int[] mcdExtendido(int a, int b)
	/*  Retorna d y numeros j and k tal que 
               d = j*a + k*b
        donde d es el mcd de a y b.
	 */
	{ 
		int[] ans = new int[3];
		int q;

		if (b == 0)  {  /*  Si b = 0, terminamos...  */
			ans[0] = a;
			ans[1] = 1;
			ans[2] = 0;
		}
		else
		{     /*  De lo contrario, recursivo  */ 
			q = a/b;
			ans = mcdExtendido (b, a % b);
			int temp = ans[1] - ans[2]*q;
			ans[1] = ans[2];
			ans[2] = temp;
		}

		return ans;
	}


	public static void main(String[] args) {


		// Leer datos de consola
		String msg = "";
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
		{
			while((msg = br.readLine())!= null && msg.length() != 0)
			{
				String[] datos = msg.split(" ");
				int[] data = new int[datos.length - 1];
				for(int i = 1; i < datos.length; i++)
				{
					data[i-1] = Integer.parseInt(datos[i]);
				}
				int[] resp = metodoA(data);
				String respuesta = "";
				if(resp != null)
				{
					for(int j = 0; j < data.length-1;j++)
					{
						respuesta+= resp[j] + " ";
					}
					respuesta+= resp[data.length-1];
				}
				else
				{
					respuesta = "*";
				}
				System.out.println(respuesta);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
