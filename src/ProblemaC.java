//Autores:
//Carlos Eduardo González Álvarez - 201511169
//Javier Antonio Troconis Guia - 201424518

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Linea
{
	public int count;
	public int valMax;

	public Linea ()
	{
		count = 0;
		valMax = -1;
	}

	public void add (int val)
	{
		if(val == 0)
		{
			count = 0;
		}
		count += val;
		if(count > valMax)
		{
			valMax = count;
		}
	}
}

public class ProblemaC {


	public static void main(String[] args) {


		String mess = "";
		String[] dim;
		String[] msg;

		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
		{
			while((mess = br.readLine())!= null && mess.length() != 0)
			{
				dim = mess.split(" ");
				int fil = Integer.parseInt(dim[0]);
				int cols = Integer.parseInt(dim[1]);
				Linea [] filas = new Linea[fil];
				Linea[] columnas = new Linea[cols];
				for(int i = 0; i < fil; i++)
				{
					msg = br.readLine().split("");
					filas[i] = new Linea();
					for(int j = 0; j < cols; j++)
					{
						if(i == 0)
						{
							columnas[j] = new Linea();
						}
						int dato = Integer.parseInt(msg[j]);
						columnas[j].add(dato);

						filas[i].add(dato);
					}

				}
				int maxFila = -1;
				int maxCol = -1;

				for (Linea fila : filas)
				{
					if (fila.valMax > maxFila)
					{
						maxFila = fila.valMax;
					}
				}
				for (Linea columna : columnas)
				{
					if (columna.valMax > maxCol)
					{
						maxCol = columna.valMax;
					}
				}
				if(maxFila >= maxCol)
				{
					System.out.println("H " + maxFila);
				}
				else
				{
					System.out.println("V " + maxCol);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}



}
