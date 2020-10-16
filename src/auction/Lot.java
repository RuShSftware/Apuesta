package auction;

public class Lot {
	// A unique identifying number.
	private final int number;
	// A description of the lot.
	private String description;
	// The current highest bid for this lot.
	private Bid highestBid;
	
	/**
	 * Construct a Lot, setting its number and description.
	 * @param number The lot number.
	 * @param description A description of this lot.
	 */
	public Lot(int number, String description) {
		this.number = number;
		this.description = description;
	}
	
	/**
	 * Attempt to bid for this lot. A successful bid
	 * must have a value higher than any existing bid.
	 * @param bid A new bid.
	 * @return true if successful, false otherwise
	 */
	public boolean bidFor(Bid bid) {
		if ((this.highestBid == null) || (bid.getValue() > this.highestBid.getValue())) {
			// This bid is the best so far.
			this.highestBid = bid;
			return true;
		}
		else return false;
	}
	
	/**
	 * @return A string representation of this lot's details.
	 */
	public String toString() {
		String details = number + ": " + description;
		if (this.highestBid != null) {
			details += " Bid: " + this.highestBid.getValue();
		}
		else details += " (No bid)";
		return details;
	}
	
	/**
	 * @return The lot's number.
	 */
	public int getNumber() {
		return this.number;
	}
	
	/**
	 * @return The lot's description.
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * @return The highest bid for this lot.
	 * This could be null if there is
	 * no current bid.
	 */
	public Bid getHighestBid() {
		return this.highestBid;
	}
}