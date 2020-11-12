package org.jesuitasrioja.ftpproject.ftpLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.log4j.Logger;

public class FTPOperationsImpl implements FTPOperations {

	Logger logger = Logger.getLogger(FTPOperationsImpl.class);

	@Override
	public String directorioDeTrabajo() {

		Integer replyCodeConnection = null;
		Integer replyCode2 = null;
		String pwd = null;

		try {

			FTPClient fClient = new FTPClient();
			fClient.connect("localhost");
			fClient.enterLocalPassiveMode();
			fClient.login("ftp", "ftp");
			replyCodeConnection = fClient.getReplyCode();
			fClient.setFileType(FTP.BINARY_FILE_TYPE);
			pwd = fClient.printWorkingDirectory();
			replyCode2 = fClient.getReplyCode();
			logger.warn("directorioDeTrabajo(): REPLY CODES > " + replyCodeConnection + " -- " + replyCode2 + "\n");
			logger.info("directorioDeTrabajo(): ");
			fClient.disconnect();

		} catch (IOException e) {
			logger.error("PWD ERROR");
			e.printStackTrace();
		}
		return pwd;
	}

	@Override
	public Boolean cambiarDirectorioDeTrabajo(String path) {

		Integer replyCodeConnection = null;
		Integer replyCode2 = null;
		Boolean cwd = null;

		try {

			FTPClient fClient = new FTPClient();
			fClient.connect("localhost");
			fClient.enterLocalPassiveMode();
			fClient.login("ftp", "ftp");
			replyCodeConnection = fClient.getReplyCode();
			fClient.setFileType(FTP.BINARY_FILE_TYPE);
			cwd = fClient.changeWorkingDirectory(path);
			replyCode2 = fClient.getReplyCode();
			logger.warn(
					"cambiarDirectorioDeTrabajo(): REPLY CODES > " + replyCodeConnection + " -- " + replyCode2 + "\n");
			logger.info("cambiarDirectorioDeTrabajo(): " + cwd.toString() + "\n");
			logger.info("directorioDeTrabajo(): " + fClient.printWorkingDirectory());
			fClient.disconnect();

		} catch (IOException e) {

			logger.error("cambiarDirectorioDeTrabajo() ERROR");
			e.printStackTrace();

		}
		return cwd;
	}

	@Override
	public Boolean subirFichero(String path) {

		File fileToUpload = new File(path);

		Integer replyCodeConnection = null;
		Integer replyCode2 = null;
		Boolean fileUpload = null;

		try {

			FTPClient fClient = new FTPClient();
			fClient.connect("localhost");
			fClient.enterLocalPassiveMode();
			fClient.login("ftp", "ftp");
			replyCodeConnection = fClient.getReplyCode();
			fClient.setFileType(FTP.BINARY_FILE_TYPE);
			fileUpload = fClient.storeFile(fileToUpload.getName(), new FileInputStream(fileToUpload));
			replyCode2 = fClient.getReplyCode();
			logger.warn("subirFichero(): REPLY CODES > " + replyCodeConnection + " -- " + replyCode2 + "\n");
			logger.info("subirFichero(): " + fileUpload.toString());
			fClient.disconnect();

		} catch (IOException e) {

			logger.error("subirFichero() ERROR");
			e.printStackTrace();

		}
		return fileUpload;
	}

	@Override
	public Boolean bajarFichero(String file, String path) {
		Integer replyCodeConnection = null;
		Integer replyCode2 = null;
		Boolean dlFile = null;

		try {
			FileOutputStream fos = new FileOutputStream(file);
			FTPClient fClient = new FTPClient();
			fClient.connect("localhost");
			fClient.enterLocalPassiveMode();
			fClient.login("ftp", "ftp");
			replyCodeConnection = fClient.getReplyCode();
			fClient.setFileType(FTP.BINARY_FILE_TYPE);
			dlFile = fClient.retrieveFile(file, fos);
			replyCode2 = fClient.getReplyCode();
			logger.warn("bajarFichero(): REPLY CODES > " + replyCodeConnection + " -- " + replyCode2 + "\n");
			logger.info("bajarFichero(): " + dlFile.toString());
			fClient.disconnect();

		} catch (IOException e) {

			logger.error("bajarFichero() ERROR");
			e.printStackTrace();

		}
		return dlFile;

	}

	@Override
	public Boolean eliminarFichero(String file) {
		Integer replyCodeConnection = null;
		Integer replyCode2 = null;
		Boolean rmFile = null;

		try {

			FTPClient fClient = new FTPClient();
			fClient.connect("localhost");
			fClient.enterLocalPassiveMode();
			fClient.login("ftp", "ftp");
			replyCodeConnection = fClient.getReplyCode();
			fClient.setFileType(FTP.BINARY_FILE_TYPE);
			rmFile = fClient.deleteFile(file);
			replyCode2 = fClient.getReplyCode();
			logger.warn("eliminarFichero(): REPLY CODES > " + replyCodeConnection + " -- " + replyCode2 + "\n");
			logger.info("eliminarFichero(): " + rmFile.toString());
			fClient.disconnect();

		} catch (IOException e) {

			logger.error("eliminarFichero() ERROR");
			e.printStackTrace();

		}
		return rmFile;

	}

	@Override
	public Boolean crearCarpeta(String nombreCarpeta) {

		Integer replyCodeConnection = null;
		Integer replyCode2 = null;
		Boolean mkdir = null;

		try {

			FTPClient fClient = new FTPClient();
			fClient.connect("localhost");
			fClient.enterLocalPassiveMode();
			fClient.login("ftp", "ftp");
			replyCodeConnection = fClient.getReplyCode();
			fClient.setFileType(FTP.BINARY_FILE_TYPE);
			mkdir = fClient.makeDirectory(nombreCarpeta);
			replyCode2 = fClient.getReplyCode();
			logger.warn("crearCarpeta(): REPLY CODES > " + replyCodeConnection + " -- " + replyCode2 + "\n");
			logger.info("crearCarpeta(): " + mkdir.toString());
			fClient.disconnect();

		} catch (IOException e) {

			logger.error("crearCarpeta() ERROR");
			e.printStackTrace();

		}
		return mkdir;
	}

	@Override
	public Boolean eliminarCarpeta(String nombreCarpeta) {

		Integer replyCodeConnection = null;
		Integer replyCode2 = null;
		Boolean rmdir = null;

		try {

			FTPClient fClient = new FTPClient();
			fClient.connect("localhost");
			fClient.enterLocalPassiveMode();
			fClient.login("ftp", "ftp");
			replyCodeConnection = fClient.getReplyCode();
			fClient.setFileType(FTP.BINARY_FILE_TYPE);
			rmdir = fClient.removeDirectory(nombreCarpeta);
			replyCode2 = fClient.getReplyCode();
			logger.warn("eliminarCarpeta(): REPLY CODES > " + replyCodeConnection + " -- " + replyCode2 + "\n");
			logger.info("eliminarCarpeta(): " + rmdir.toString());
			fClient.disconnect();

		} catch (IOException e) {

			logger.error("eliminarCarpeta() ERROR");
			e.printStackTrace();

		}
		return rmdir;
	}

	@Override
	public List<FTPFile> listaFicherosCarpeta(String path) {

		Integer replyCodeConnection = null;
		Integer replyCode2 = null;
		List ls = new ArrayList<FTPFile>();

		try {

			FTPClient fClient = new FTPClient();
			fClient.connect("localhost");
			fClient.enterLocalPassiveMode();
			fClient.login("ftp", "ftp");
			replyCodeConnection = fClient.getReplyCode();
			fClient.setFileType(FTP.BINARY_FILE_TYPE);
			FTPFile[] files = fClient.listFiles();

			for (FTPFile ftpFile : files) {
				ls.add(ftpFile);
			}

			replyCode2 = fClient.getReplyCode();
			logger.warn("listaFicherosCarpeta(): REPLY CODES > " + replyCodeConnection + " -- " + replyCode2 + "\n");
			logger.info("listaFicherosCarpeta(): ");
			fClient.disconnect();

		} catch (IOException e) {

			logger.error("listaFicherosCarpeta() ERROR");
			e.printStackTrace();

		}
		return ls;
	}

	@Override
	public List<FTPFile> listaDirectoriosCarpeta(String path) {

		Integer replyCodeConnection = null;
		Integer replyCode2 = null;
		List ls = new ArrayList<FTPFile>();

		try {

			FTPClient fClient = new FTPClient();
			fClient.connect("localhost");
			fClient.enterLocalPassiveMode();
			fClient.login("ftp", "ftp");
			replyCodeConnection = fClient.getReplyCode();
			fClient.setFileType(FTP.BINARY_FILE_TYPE);
			FTPFile[] files = fClient.listDirectories();

			for (FTPFile ftpFile : files) {
				ls.add(ftpFile);
			}

			replyCode2 = fClient.getReplyCode();
			logger.warn("listaDirectoriosCarpeta(): REPLY CODES > " + replyCodeConnection + " -- " + replyCode2 + "\n");
			logger.info("listaDirectoriosCarpeta(): ");
			fClient.disconnect();

		} catch (IOException e) {

			logger.error("listaDirectoriosCarpeta() ERROR");
			e.printStackTrace();

		}
		return ls;
	}

	@Override
	public void mostrarInformacionFile(FTPFile file) {

		Integer replyCodeConnection = null;
		Integer replyCode2 = null;
		String name = null;
		String user = null;
		Long size = null;
		Calendar lastMod = Calendar.getInstance();
		int type = -1;

		try {

			FTPClient fClient = new FTPClient();
			fClient.connect("localhost");
			fClient.enterLocalPassiveMode();
			fClient.login("ftp", "ftp");
			replyCodeConnection = fClient.getReplyCode();
			fClient.setFileType(FTP.BINARY_FILE_TYPE);
			name = file.getName();
			size = file.getSize();
			user = file.getUser();
			type = file.getType();
			lastMod = file.getTimestamp();

			replyCode2 = fClient.getReplyCode();

			logger.warn("mostrarInformacionFile(): REPLY CODES > " + replyCodeConnection + " -- " + replyCode2 + "\n");
			logger.info("mostrarInformacionFile(): " + "Name: " + name + " " + " - Size: " + size + " " + " - User: "
					+ user + " " + " - Type: " + type + " " + "Last Modification: " + lastMod.get(lastMod.YEAR)+" - "+lastMod.get(lastMod.MONTH)+" - "+lastMod.get(lastMod.DAY_OF_MONTH));
			fClient.disconnect();

		} catch (IOException e) {

			logger.error("mostrarInformacionFile() ERROR");
			e.printStackTrace();

		}
	}

	public List<FTPFile> listaFicherosCarpetaAux(String string) { // No devuelve logs, para utilizarse en el metodo de mostrar info

		Integer replyCodeConnection = null;
		Integer replyCode2 = null;
		List ls = new ArrayList<FTPFile>();

		try {

			FTPClient fClient = new FTPClient();
			fClient.connect("localhost");
			fClient.enterLocalPassiveMode();
			fClient.login("ftp", "ftp");
			replyCodeConnection = fClient.getReplyCode();
			fClient.setFileType(FTP.BINARY_FILE_TYPE);
			FTPFile[] files = fClient.listFiles();

			for (FTPFile ftpFile : files) {
				ls.add(ftpFile);
			}

			replyCode2 = fClient.getReplyCode();
//			logger.warn("listaFicherosCarpeta(): REPLY CODES > " + replyCodeConnection + " -- " + replyCode2 + "\n");
//			logger.info("listaFicherosCarpeta(): ");
			fClient.disconnect();

		} catch (IOException e) {

			logger.error("listaFicherosCarpetaAux() ERROR");
			e.printStackTrace();

		}
		return ls;
	}
}
