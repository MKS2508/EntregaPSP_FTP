package org.jesuitasrioja.ftpproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.jesuitasrioja.ftpproject.ftpLayer.FTPOperations;
import org.jesuitasrioja.ftpproject.ftpLayer.FTPOperationsImpl;

public class App {

	public static void main(String[] args) {

		FTPOperationsImpl ftp = new FTPOperationsImpl();

		System.out.print(ftp.directorioDeTrabajo());
		System.out.println();
		System.out.println();
		System.out.println("---------------------------------------------------------------------");
		ftp.cambiarDirectorioDeTrabajo("./apuntesPSP"); // ademas de devolver boolean ejecuta pwd y lo muestra
		System.out.println();
		System.out.println();
		System.out.println("---------------------------------------------------------------------");
		ftp.subirFichero("./logo.jpeg");
		System.out.println();
		System.out.println();
		System.out.println("---------------------------------------------------------------------");
		ftp.bajarFichero("logo.jpeg", "./");
		System.out.println();
		System.out.println();
		System.out.println("---------------------------------------------------------------------");
		ftp.eliminarFichero("logo.jpeg");
		System.out.println();
		System.out.println();
		System.out.println("---------------------------------------------------------------------");
		ftp.crearCarpeta("./apuntesPSP24");
		System.out.println();
		System.out.println();
		System.out.println("---------------------------------------------------------------------");
		ftp.eliminarCarpeta("./apuntesPSP24");
		System.out.println();
		System.out.println();
		System.out.println("---------------------------------------------------------------------");
		System.out.println(ftp.listaFicherosCarpeta("./"));
		System.out.println();
		System.out.println();
		System.out.println("---------------------------------------------------------------------");
		System.out.println(ftp.listaDirectoriosCarpeta("./"));
		System.out.println();
		System.out.println();
		System.out.println("---------------------------------------------------------------------");
//		ftp.mostrarInformacionFile(FTPFile); // falta pasar como parametro FTPFILE
		System.out.println();
		System.out.println();
		System.out.println("---------------------------------------------------------------------");

	}
}
