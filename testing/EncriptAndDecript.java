//package testing;
//import java.lang.System.Logger;
//import java.nio.charset.StandardCharsets;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.util.Arrays;
//import java.util.Base64;
//
//import javax.crypto.Cipher;
//import javax.crypto.spec.SecretKeySpec;
//
//import com.sun.org.slf4j.internal.LoggerFactory;
//
//public class EncriptAndDecript {
//	
//	
//	     private static SecretKeySpec secretKey;
//	        private static byte[] key;
//	        private static final String ALGORITHM = "AES";
//	        private Logger log=LoggerFactory.getLogger(this.getClass());
//	        public void prepareSecreteKey(String myKey) {
//	            MessageDigest sha = null;
//	            try {
//	                key = myKey.getBytes(StandardCharsets.UTF_8);
//	                sha = MessageDigest.getInstance("SHA-1");
//	                key = sha.digest(key);
//	                key = Arrays.copyOf(key, 16);
//	                secretKey = new SecretKeySpec(key, ALGORITHM);
//	            } catch (NoSuchAlgorithmException e) {
//	                e.printStackTrace();
//	            }
//	        }
//	        public String encrypt(String strToEncrypt, String secret) {
//	            try {
//	                prepareSecreteKey(secret);
//	                Cipher cipher = Cipher.getInstance(ALGORITHM);
//	                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
//	                return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
//	            } catch (Exception e) {
//	                System.out.println("Error while encrypting: " + e.toString());
//	            }
//	            return null;
//	        }
//	        public String decrypt(String strToDecrypt, String secret) {
//	            try {
//	                System.out.println(strToDecrypt);
//	                prepareSecreteKey(secret);
//	               
//	                Cipher cipher = Cipher.getInstance(ALGORITHM);
//	               
//	                cipher.init(Cipher.DECRYPT_MODE, secretKey);
//	                
//	                return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
//	                
//	            } catch (Exception e) {
//	                System.out.println("Error while decrypting: " + e.toString());
//	            }
//	            return null;
//	        }
//	}
//
