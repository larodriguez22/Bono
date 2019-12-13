package model.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Arrays;

import model.data_structures.Graph;
import model.data_structures.Queue;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;


/**
 * Definicion del modelo del mundo
 *
 */

public class MVCModelo<K> {

	public final static int MAX_COL=5;

	private Graph<Integer,Informacion> grafo;
	
	private boolean matriz[][];

	private Edge arcos;
	private Informacion infos;
	
	

	private Queue<Integer> ids = new Queue<>();
	private Queue<String> values = new Queue<>();

	public MVCModelo() throws Exception
	{
		ids=new Queue<>();
		values=new Queue<>();
	}

	public void cargarTxtHash() throws IOException
	{
		grafo=new Graph<>(1000000);
		matriz= new boolean[1000][10000];
		String ruta="./data/datos.txt";
		int vertices=0;
		try{
			// Abre el archivo utilizando un FileReader
			FileReader reader = new FileReader(ruta);
			// Utiliza un BufferedReader para leer por líneas
			BufferedReader lector = new BufferedReader( reader );   
			// Lee línea por línea del archivo
			String linea = lector.readLine( );
			int contadorFilas=0;
			int contadorColumnas=0;
			
			while(linea!=null)
			{
				// Parte la línea con cada coma
				for(int i=0; i<MAX_COL; i++)
				{
					char parte = linea.charAt(i);
					if(parte=='1')
					{
						Informacion inf=new Informacion(vertices, contadorFilas+","+contadorColumnas);
						grafo.addVertex(vertices, inf);
						vertices++;
						matriz[contadorFilas][contadorColumnas]=true;
					}
					else
					{
						matriz[contadorFilas][contadorColumnas]=false;
					}
					contadorColumnas++;
				}
				contadorFilas++;
				linea=lector.readLine();
			}
			for(int i=0; i<contadorFilas; i++)
			{
				for(int j=0;j<contadorColumnas; j++)
				{
					if(matriz[i][j]==true)
					{
						if(i-1>=0&&matriz[i-1][j]==true)
						{
							System.out.println("("+i+","+j+")-("+(i-1)+","+j+")");
						}
						if(i+1<contadorFilas&&matriz[i+1][j]==true)
						{
							System.out.println("("+i+","+j+")-("+(i+1)+","+j+")");
						}
						if(j-1>=0&&matriz[i][j-1]==true)
						{
							System.out.println("("+i+","+j+")-("+i+","+(j-1)+")");
						}
						if(j+1<contadorColumnas&&matriz[i][j+1]==true)
						{
							System.out.println("("+i+","+j+")"+"-("+i+","+(j+1)+")");
						}
					}
				}
			}
			lector.close( );
			reader.close( );
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("La cantidad total de vertices es "+vertices);
		// Cierra los lectores y devuelve el resultado
		
	}

}