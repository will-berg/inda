package projects.chapter04.auction;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael KÃ¶lling.
 * @version 2011.07.31
 */
public class Auction {
    // The list of Lots in this auction.
    private ArrayList<Lot> lots;
    // The number that will be given to the next lot entered
    // into this auction.
    private int nextLotNumber;

    /**
     * Create a new auction.
     */
    public Auction() {
        lots = new ArrayList<Lot>();
        nextLotNumber = 1;
    }

    /**
     * Enter a new lot into the auction.
     * @param description A description of the lot.
     */
    public void enterLot(String description) {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    /**
     * Show the full list of lots in this auction.
     */
    public void showLots() {
        for (Lot lot : lots) {
            System.out.println(lot.toString());
        }
    }

    /**
     * Make a bid for a lot.
     * A message is printed indicating whether the bid is
     * successful or not.
     *
     * @param lotNumber The lot being bid for.
     * @param bidder The person bidding for the lot.
     * @param value  The value of the bid.
     */
    public void makeABid(int lotNumber, Person bidder, long value) {
        Lot selectedLot = getLot(lotNumber);
        if (selectedLot != null) {
            Bid bid = new Bid(bidder, value);
            boolean successful = selectedLot.bidFor(bid);
            if (successful) {
                System.out.println("The bid for lot number " + lotNumber + " was successful.");
            } else {
                // Report which bid is higher.
                Bid highestBid = selectedLot.getHighestBid();
                System.out.println("Lot number: " + lotNumber +
                                   " already has a bid of: " +
                                   highestBid.getValue());
            }
        }
    }

    /**
     *
     */
    // 4.48
    public void Close() {
        for (Lot lot : lots) {
            Bid variableBid = lot.getHighestBid();
            if (variableBid == null) {
                System.out.println(" " + lot.getNumber() + " : This lot has no bidder");
            } else {
                System.out.println("The winning bidder is: " + lot.getHighestBid().getBidder().getName() + "with a bid of: " + lot.getHighestBid() + "");
        }
      }
    }

   /**
    *
    */
   // 4.49
   public ArrayList<Lot> getUnsold() {
       ArrayList<Lot> unsoldlot = new ArrayList<Lot>();
       for (Lot lot : lots) {
           if (lot.getHighestBid() == null) unsoldlot.add(lot);
        }
        return unsoldlot;
    }

    /**
     * Remove the lot with the given lot number.
     * @param number The number of the lot to be removed.
     * @return The Lot with the given number, or null if
     * there is no such lot.
     */
    // 4.52
    public Lot removeLot(int number) {
        Iterator<Lot> it = lots.iterator();
        while (it.hasNext()) {
            Lot lot1 = it.next();
            int lot2 = lot1.getNumber();
            if (lot2 == number) {
				it.remove();
				return lot1;
        }
    }
    return null;
}

    /**
     * Return the lot with the given number. Return null
     * if a lot with this number does not exist.
     * @param lotNumber The number of the lot to return.
     */
    // 4.51
    public Lot getLot(int lotNumber) {
        Iterator<Lot> it = lots.iterator();
        while (it.hasNext()) {
            Lot lot1 = it.next();
            int lot2 = lot1.getNumber();
            if (lot2 == lotNumber) {
            	return lot1;
        	}
        }
        System.out.println("Lot number: " + lotNumber + " does not exist.");
        return null;
    }
}

