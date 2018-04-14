package practise_package;

import java.util.Scanner;

public class TICKET {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Tickets Sales System Menu ");
		TICKET t = new TICKET();
		t.displayMenu();
	}

	private String eventName;
	private String date;
	private char eventType;
	private char ticketClass;
	private double price;
	private boolean member;

	TICKET() {
		this.eventName = "unknown";
		this.date = "unknown";
		this.eventType = 'I';
		this.ticketClass = 'S';
		this.price = 0;
		this.member = true;
	}

	public String getEventName() {
		return this.eventName;
	}

	public String getDate() {
		return this.date;
	}

	public boolean isMember() {
		return this.member;
	}
	
	public char getEventType() {
		return this.eventType;
	}
	
	public char getEventClass() {
		return this.ticketClass;
	}

	public void sellTicket() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the event Name : ");
	    this.eventName = sc.next();
		System.out.print("Enter the event date (dd/mm/yyyy): ");
		this.date = sc.next();
		if(this.date.substring(6).equalsIgnoreCase("2018")){
			System.out.println("valid date ");
		} else {
			System.out.println("invalid date ");
		}
		System.out.print("Enter the event Type : ");
		this.eventType = sc.next().charAt(0);
		System.out.print("Enter the ticket class : ");
		this.ticketClass = sc.next().charAt(0);
		System.out.print("Enter the ticket price : ");
		this.price = sc.nextDouble();
		System.out.print("Are you a member? (true/false) ");
		this.member = sc.nextBoolean();
		
		if(member==false){
			this.price = this.price+10;
		} else {
			System.out.println("Are you VIP? (y/n)");
			char status = sc.next().charAt(0);
			if(status=='y'){
				this.price = this.price*3;
			}
			
			this.price = this.price - ((20/100)*this.price);
		}
	}

	public void display() {
		System.out.println(getEventName());
		System.out.println(getDate());
		if (isMember() == true) {
			System.out.println("This purchase is made by Member ");
		} else {
			System.out.println("This purchase is made by non member ");
		}
	}

	private void displayMenu() {
		
		char a;
		do{
			System.out.println("1. Sell Ticekts ");
			System.out.println("2. Display all tickets ");
			System.out.println("3. Display tickets sold to members for a given event name ");
			System.out.println("4. Display tickets in decresing order of event date ");
			System.out.println("5. exit ");
			
			int i = sc.nextInt();
			if(i==1){
				this.sellTicket();
			} else if(i==2){
				this.display();
			} else if(i==3){
				this.display();
			} else if(i==4){
				this.display();
			} else {
				 return;
			}
			System.out.println("Do you want to continue? (y/n)");
			a = sc.next().charAt(0);
		}while(a=='Y'|| a=='y');
	}
}
