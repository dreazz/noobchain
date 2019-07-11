import java.util.Date;
import java.security.MessageDigest;//Lo importamos para acceder al algoritmo SHA256 para poder crear una firma digital

public class Block {
		public String hash;
		public String previousHash;
		private String data; //our data will be a simple message.
		private long timeStamp; //as number of milliseconds since 1/1/1970.

		//Block Constructor.
		public Block(String data,String previousHash ) {
			this.data = data;
			this.previousHash = previousHash;
			this.timeStamp = new Date().getTime();
			this.hash = calculateHash();
			
			
			
			}
		public String calculateHash() {
			String calculatedhash = StringUtility.applySha256( 
					previousHash +
					Long.toString(timeStamp) +
					data 
					);
			return calculatedhash;
		}
		
		@Override
		public String toString() {
			return "Block [hash=" + hash + ", previousHash=" + previousHash + ", data=" + data + ", timeStamp="
					+ timeStamp + "]";
		}
	

}
