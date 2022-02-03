/**
 * 
 */
package shorturl;

/**
 * @author duchauha
 *
 */
public class TinyUrl {
	
	char map[] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	
	//base 62 based url
	public String getShortUrl(int num) {
		
		StringBuilder url = new StringBuilder();
		while(num>0) {
			url.insert(0,map[num%62]);
			num = num/62;
		}
		
		 while (url.length() != 7) {
			 url.insert(0, '0');
	     }
		
		return url.toString();
	}
	
	
       // get the int back from the short url
		public int getIntFromUrl(String url) {
			int num=0;
			
			for(int i=0;i<url.length();i++) {
				if('a'<=url.charAt(i) && url.charAt(i)<='z') {
					num = num*62+ url.charAt(i)-'a'+10;
				}
				
				if('A'<=url.charAt(i) && url.charAt(i)<='Z') {
					num = num*62+ url.charAt(i)-'A'+36;
				}
				
				if('0'<=url.charAt(i) && url.charAt(i)<='9') {
					num = num*62+ url.charAt(i)-'0';
				}
			}
			
			return num;
		}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TinyUrl url = new TinyUrl();
		int num = 12346; // counter which machine maintained and get it from zookeeper
		String shortUrl = url.getShortUrl(num);
		System.out.println("short url is:"+shortUrl);
		System.out.println("int from short url is:"+url.getIntFromUrl(shortUrl));
	}

}
