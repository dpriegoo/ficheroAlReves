package diferFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class principal {

	public static void main(String[] args) {
		File fichero = new File("fch1.txt");
		File fichero2 = new File("fch2.txt");
		File fDiff = new File("diferencias.txt");
		lecturaComparada(fichero, fichero2, fDiff);
	}

	private static void lecturaComparada(File fichero, File fichero2, File fDiff) {

		try {

			BufferedReader bufFch = new BufferedReader(new FileReader(fichero));
			BufferedWriter bufFch3 = new BufferedWriter(new FileWriter(fDiff));

			String lineaLeida1=bufFch.readLine();
			int iCont = 0;

			while(lineaLeida1!=null) {
			iCont++;
			lineaLeida1=bufFch.readLine();
			}
			bufFch = new BufferedReader(new FileReader(fichero));
			
			while(iCont!=1) {
			for (int i=1; i<=iCont;i++) {
				lineaLeida1=bufFch.readLine();
				if (i==iCont && iCont>1) {
					
					bufFch3.append(lineaLeida1+"\n");
					System.out.println(lineaLeida1+"\n");
					iCont--;
					i=0;
					bufFch = new BufferedReader(new FileReader(fichero));
				} else if(iCont==1) {
					bufFch3.append(lineaLeida1);
					
				}
				
			}
			bufFch3.close();
			bufFch.close();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Alguno de los ficheros no se puede encontrar");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Hay un error con alguno de los ficheros");
			e.printStackTrace();
		}

	}
}
