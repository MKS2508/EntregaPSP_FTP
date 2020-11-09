package org.jesuitasrioja.ftpproject.ftpLayer;

import java.util.List;

import org.apache.commons.net.ftp.FTPFile;
import org.apache.log4j.Logger;

public class FTPOperationsImpl implements FTPOperations {
	
	Logger logger = Logger.getLogger(FTPOperationsImpl.class);

	@Override
	public String directorioDeTrabajo() {
		return null;
	}

	@Override
	public Boolean cambiarDirectorioDeTrabajo(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean subirFichero(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean bajarFichero(String file, String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean eliminarFichero(String file) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean crearCarpeta(String nombreCarpeta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean eliminarCarpeta(String nombreCarpeta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FTPFile> listaFicherosCarpeta(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FTPFile> listaDirectoriosCarpeta(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mostrarInformacionFile(FTPFile file) {
		// TODO Auto-generated method stub

	}

}
