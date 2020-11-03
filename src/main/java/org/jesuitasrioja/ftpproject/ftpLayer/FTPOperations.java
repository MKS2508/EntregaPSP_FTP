package org.jesuitasrioja.ftpproject.ftpLayer;

import java.util.List;

import org.apache.commons.net.ftp.FTPFile;

public interface FTPOperations {
	
	
	
	/**
	 * Se devolverá el directorio actual de trabajo
	 * 
	 * @return Directorio actual de trabajo
	 */
	public String directorioDeTrabajo();
	
	/**
	 * Cambiar el directorio de trabajo en el servidor
	 * 
	 * @param path Directorio al que se desea cambiar
	 * @return Devolverá verdadero en caso de haber podido cambiar de directorio y falso en caso contrario. 
	 */
	public Boolean cambiarDirectorioDeTrabajo(String path);
	

	/**
	 * Se subirá un fichero pasado como parámetro al directorio de trabajo en el que estés situado en el servidor FTP. 
	 * 
	 * @param path Ruta del fichero que quieres subir
	 * @return Devolverá verdadero en caso de subirse correctamente y falso en caso contrario.
	 */
	public Boolean subirFichero(String path);
	

	/**
	 * Descargará un fichero de nombre dado en la ruta que se especifica. 
	 * 
	 * @param file Nombre del fichero que deseas descargar. Debe de estar accesible desde el directorio de trabajo en el servidor FTP. 
	 * @param path Ruta del directorio donde quieres almacenar el fichero almacenado en el servidor FTP.  
	 * @return Devolverá verdadero en caso de descargarse correctamente y falso en caso contrario. 
	 */
	public Boolean bajarFichero(String file, String path);
	
	/**
	 * Eliminar un fichero que se encuentra en el directorio de trabajo del servidor.
	 * 
	 * @param file Nombre del fichero que deseas eliminar en el servidor. Debe de estar accesible desde el directorio de trabajo en el servidor FTP.  
	 * @return Devolverá verdadero en caso de eliminarse correctamente y falso en caso contrario.
	 */
	public Boolean eliminarFichero(String file);
	

	/**
	 * Creará una nueva carpeta dentro del directorio de trabajo del servidor. 
	 * 
	 * @param nombreCarpeta Nombre de la carpeta que deseas crear en el directorio de trabajo del servidor.
	 * @return Devolverá verdadero en caso de crearse el directorio y falso en caso contrario. 
	 */
	public Boolean crearCarpeta(String nombreCarpeta);
	
	
	/**
	 * Eliminar una carpeta del directorio de trabajo.
	 * 
	 * @param nombreCarpeta Nombre de la carpeta que deseas eliminar.
	 * @return Devolverá verdadero en caso de eliminarse el directorio y falso en caso contrario.
	 */
	public Boolean eliminarCarpeta(String nombreCarpeta);
	
	
	
	/**
	 * Método que nos permitirá obtener una lista de los ficheros que se encuentran en el directorio path. 
	 * 
	 * @param path Directorio del que se quiere obtener la lista de ficheros. 
	 * @return Lista de ficheros que se encuentran dentro de path. 
	 */
	public List<FTPFile> listaFicherosCarpeta(String path);
	
	//
	/**
	 * Método que nos permitirá obtener una lista de todos los subdirectorios que se encuntran en el directorio path. 
	 * 
	 * @param path Directorio del que se quiere obtener la lista de subdirectorios. 
	 * @return Lista de subdirectorios que se encuentran dentro de path.
	 */
	public List<FTPFile> listaDirectoriosCarpeta(String path);
	
	
	/**
	 * Se mostrará información del fichero que se pasa como parámetro siguiendo el siguiente formato:
	 * Nombre: <nombre>, Tamanio: <tamanio>, Tipo: <fichero/directorio/enlace>, Usuario: <usuario>, Ultima modificacion: <fecha>
	 * 
	 * @param file Fichero del que se desea mostrar la información.
	 */
	public void mostrarInformacionFile(FTPFile file);
	
}
