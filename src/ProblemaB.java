//Autores:
//Carlos Eduardo González Álvarez - 201511169
//Javier Antonio Troconis Guia - 201424518

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemaB {




	public static int[] metodoB(String[] datos)
	{
		int max_so_far = 0;
		int max_ending_here = 0;
		int ini = 0;
		int ini_max = 0;
		int fin = -1;
		int[] resp = new int[3];


		for(int i = 0; i < datos.length; i++)
		{
			if(datos[i].startsWith("-"))
			{
				max_ending_here = max_ending_here -1;

			}
			else if(datos[i].equals("0"))
			{
			}
			else
			{
				max_ending_here = max_ending_here + 1;
			}
			if(max_ending_here < 0)
			{
				max_ending_here = 0;
				ini = i + 1;
			}
			if(max_so_far < max_ending_here)
			{
				ini_max = ini;
				max_so_far = max_ending_here;
				fin = i;
			}
		}

		resp[0] = max_so_far;
		resp[1] = ini_max;
		resp[2] = fin + 1;
		return resp;



	}



	public static void main(String[] args) {


		String msg="";
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
		{
			while((msg = br.readLine())!= null && msg.length() != 0)
			{
				msg = br.readLine();
				String[] datos = msg.split(" ");

				int[] resp = metodoB(datos);

				String rta = resp[0] + " " + resp[1] + " " + resp[2];
				System.out.println(rta);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}


}


