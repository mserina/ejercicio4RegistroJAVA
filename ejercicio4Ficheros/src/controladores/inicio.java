package controladores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class inicio {

	public static void main(String[] args ) {
		Scanner sc = new Scanner(System.in);
		
		//Indicar la ruta de archivo
		String rutaArchivo = "C:\\Users\\csi23-mserina\\Desktop\\fcihero\\archivo.txt";
		
		System.out.println("Inserte el texto");
		String texto = sc.next();
		System.out.println("Inserte la linea en el que quiera insertar texto");
		int numeroLinea = sc.nextInt();
		System.out.println("Inserte la posicion en el que quiera insertar texto");
		int posicionEspecifica = sc.nextInt();
			
		try {
			FileReader sr = new FileReader(rutaArchivo);
			BufferedReader lector = new BufferedReader(sr);
			StringBuilder contenido = new StringBuilder();
			String lineaActual;
			int contador = 0;
			//Cuenta las lineas del archivo y las guarda en lineaActual hasta que no haya mas lineas (!=)
			while ((lineaActual = lector.readLine()) != null) {
				contador ++;
				
				//Aqui se va a comparar la linea que insertamos con el numero del contador, cada valor de contador representa una linea del fichero
				if(contador == numeroLinea) {
					//Y aqui se modifica el la linea deseada.
					contenido.append(lineaActual.substring(0, posicionEspecifica)).append(texto).append(lineaActual.substring(posicionEspecifica));
				
				}else {
					contenido.append(lineaActual);
				}
				contenido.append(System.lineSeparator());
			}
			lector.close();
			
			FileWriter sw = new FileWriter(rutaArchivo);
			BufferedWriter escribir = new BufferedWriter(sw);
			escribir.write(contenido.toString());
			escribir.close();
			
			System.out.println("Las modificaciones se han implementado");
		}
		catch(IOException io) {
			System.out.println(io.getMessage());
			
		}
	}
}
