package auction;

public class Main {
	public static void main(String[] args) {
		Auction au=new Auction();
		au.enterLot("Silla Luis XVI");
		au.enterLot("Pintura de Picasso");
		au.enterLot("Collar de diamantes");
		au.bidFor(1, new Person("Antonio"), 1000);
		au.bidFor(2, new Person("Pepe"), 100);
		au.bidFor(1, new Person("Juan"), 1500);
		au.bidFor(1, new Person("Andrea"), 1505);
		au.bidFor(0, new Person("Juan"), 1500);
		au.bidFor(2, new Person("Monica"), 99);
		au.bidFor(6, new Person("Juan"), 200);
		au.showLots();
	}
}