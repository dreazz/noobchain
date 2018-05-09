import java.security.MessageDigest;//Lo importamos para acceder al algoritmo SHA256 para poder crear una firma digital

public class StringUtility {
	
	
	public static String applySha256(String input){		
	
		//Usamos el try ya que puede que el codigo nos de una excepción
		//El try permite ejecutar el codigo y que el programa no se rompa si hay excepcion
		try {
				
			//creamos una variable digest de tipo MessageDigest y le asignamos un metodo que tiene el algoritmo SHA-256
			MessageDigest digest = MessageDigest.getInstance("SHA-256");	        
			
			//Array de byte llamado hash al cual le asignamos los valores de digest parseado por el metodo digest a UTF8
			
			byte[] hash = digest.digest(input.getBytes("UTF-8"));	        
			
			//instanciamos la clase Stingbuffer y creamos el objetohexString de tipo StringBuffer
			//Aqui se guardará el hash en hexadecimal
			StringBuffer hexString = new StringBuffer(); 
			
			//cogemos el tamaño del hash que esta en la clase noobchain como publico
			for (int i = 0; i < hash.length; i++) {
				
				//creamos variable hex de tipo String donde pasamos todos los Integers a hexadecimal
				String hex = Integer.toHexString(0xff & hash[i]);
				//Si el length del hex es 1 le añadimos un 0
				if(hex.length() == 1) hexString.append('0');
				//Añadimos a hexString, hex.
				hexString.append(hex);
			}
			//devolvemos el hexadecimal parseado a string 
			return hexString.toString();
		}
		//se recoge la exepcion en caso de que falle en el try y se 
		
		catch(Exception e) {
			throw new RuntimeException(e);
		}
} 
	}

//TODO entender todo el codigo de la class Utility que no se como funciona y seguir con el tutorial

