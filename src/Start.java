import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		String encripitado ="";
		// String mensaje = "";
		//String operacion="";
		Scanner lector= new Scanner(System.in);
		try {
		KeyGenerator keygen= KeyGenerator.getInstance("AES");// GENERO LA KEY SIMETRRICA
    	SecretKey clave=keygen.generateKey();//Aplica opacidad a la key
    	Cipher desCipher=Cipher.getInstance("AES");//activo cifrador AES
    	
    	System.out.println("Introduzca el nombre de un fichero:"); //le el fichero que contiene la palabra encripita
    	String direccion= lector.nextLine();
    	Path fichero_aleer=Paths.get(direccion);
    	
    	desCipher.init(Cipher.ENCRYPT_MODE, clave);//activa cifrador AES
    	byte[] lectura=Files.readAllBytes(fichero_aleer);// le el fichero y lo almacena en array de bytes
    	System.out.println("El mensaje a encripitar  es:" + new String(lectura) );//muestra el mensaje
    	
    	byte[] encriptado=desCipher.doFinal(lectura);
    	System.out.println(" El mensaje encripitafo es  " + new String (encripitado));
    	
		  }catch(Exception e) {e.printStackTrace();}
	}

}
