import java.security.MessageDigest;//Lo importamos para acceder al algoritmo SHA256 para poder crear una firma digital

public class Utility {
	
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
			
			//cogemos el tamaño del hash
			for (int i = 0; i < hash.length; i++) {
			
				String hex = Integer.toHexString(0xff & hash[i]);
				
				if(hex.length() == 1) hexString.append('0');
				
				hexString.append(hex);
			}
			
			return hexString.toString();
		}
		
		catch(Exception e) {
			throw new RuntimeException(e);
		}
} 
}
//TODO entender todo el codigo de la class Utility que no se como funciona y seguir con el tutorial

