package auction;

public class Auction {
	// SIZE is the maximum number of lots of the auction
	private final int SIZE = 1000;
	// The lots in the auction.
	private Lot[] lots;
	// The number that will be given to the next lot entered into this auction.
	private int nextLotNumber;
	
	/**
	 * Create a new auction.
	 */
	public Auction() {
		this.lots = new Lot[SIZE];
		this.nextLotNumber = 0;
	}
	
	/**
	 * Enter a new lot into the auction.
	 * @param description A description of the lot.
	 */
	public void enterLot(String description) {
		this.lots[this.nextLotNumber] = new Lot(this.nextLotNumber, description);
		this.nextLotNumber++;
	}

	/**
	 * Show the lots in this auction.
	 */
	public void showLots() {
		// for i = 0; i < this.lots.length; i++)
		// if (lots[i] != null) System.out.println(lots[i].toString());
		for (Lot l : this.lots)
		if (l!= null) System.out.println(l.toString());
	}
	
	/**
	 * Bid for a lot.
	 * A message indicating whether the bid is successful or not is printed.
	 * @param number The lot number being bid for.
	 * @param bidder The person bidding for the lot.
	 * @param value The value of the bid.
	 */
	public void bidFor(int lotNumber, Person bidder, long value) {
		Lot selectedLot = this.getLot(lotNumber);
		if (selectedLot != null) {
			boolean successful = selectedLot.bidFor(new Bid(bidder, value));
			if (successful)
				System.out.println("The bid for lot number " + lotNumber + " was successful.");
			else {
				// Report which bid is higher.
				Bid highestBid = selectedLot.getHighestBid();
				System.out.println("Lot number: " + lotNumber + " already has a bid of: " + highestBid.getValue());
			}
		}
	}
	
	/**
	 * Return the lot with the given number.
	 * Return null if a lot with this number does not exist.
	 * @param lotNumber The number of the lot to return.
	 */
	public Lot getLot(int lotNumber) {
		if ((lotNumber >= 0) && (lotNumber < nextLotNumber)) {
			// The number seems to be reasonable.
			Lot selectedLot = this.lots[lotNumber];
			// Include a confidence check to be sure we have the right lot.
			if (selectedLot.getNumber() != lotNumber) {
				System.out.println("Internal error: Lot number " + selectedLot.getNumber() + " was returned instead of " + lotNumber);
			}
			return selectedLot;
		}
		else {
			System.out.println("Lot number: " + lotNumber + " does not exist.");
			return null;
		}
	}
}