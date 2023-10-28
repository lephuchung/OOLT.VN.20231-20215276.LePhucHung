
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	private int qtyOrdered=0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		DigitalVideoDisc rong = new DigitalVideoDisc(null, null, null, 0, 0);
		if(this.qtyOrdered<20) {
			for (int i = 0; i < 20; i++) {
				if(itemOrdered[i] == null) {
					itemOrdered[i] = disc;
					break;
				}
			}
			this.qtyOrdered++;
			System.out.println("The disc has been added");
		}
		else {
			System.out.println("The cart is almost full");
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		DigitalVideoDisc rong = new DigitalVideoDisc("", "", "", 0, 0);
		for(int i = 0; i < 20; i++ ) {
			if(itemOrdered[i].equals(disc)) {
				itemOrdered[i] = rong;
				break;
			}
		}
		this.qtyOrdered--;
		System.out.println("The disc has been removed");
	}
	
	public float totalCost() {
		float sum = 0.00f;
		for(int i = 0; i < 20; i++) {
			if(itemOrdered[i] != null) {
				sum += itemOrdered[i].getCost();
			}
		}
		return (float) Math.round(sum * 100) / 100;
	}
}
