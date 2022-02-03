/**
 * 
 */
package shorturl;

/**
 * @author duchauha
 *
 */
public class TinyUrlServiceTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TinyUrlService tiny = new TinyUrlService();
	    String sampleUrl1 = "http://www.xyz.com/abc";
	    String shortUrl = tiny.longToShort(sampleUrl1);
	    System.out.println("Short url is:"+shortUrl);
	    System.out.println("Long url is:"+tiny.shortToLong(shortUrl));
	    System.out.println("-----");
	    String sampleUrl2 = "http://www.xyz.com/xyz";
	    String shortUrl2 = tiny.longToShort(sampleUrl2);
	    System.out.println("Short url is:"+shortUrl2);
	    System.out.println("Long url is:"+tiny.shortToLong(shortUrl2));

	}

}
