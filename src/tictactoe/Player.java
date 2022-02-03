/**
 * 
 */
package tictactoe;

/**
 * @author duchauha
 *
 */
public class Player {

	private String id;
	private String name;
	// 1 or -1
	private int playSymbol;

	private int ranking;
	private String address;
	// may be win percentage in future

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPlaySymbol() {
		return playSymbol;
	}

	public void setPlaySymbol(int playSymbol) {
		this.playSymbol = playSymbol;
	}

}
