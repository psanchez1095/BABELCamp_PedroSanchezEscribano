package modelo.negocio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import modelo.entidad.User;
import modelo.persistencia.DaoUserMySQL;
import modelo.persistencia.interfaces.DaoUser;


public class GestorUser {

	private DaoUser daoUser = new DaoUserMySQL();

	
	

}
