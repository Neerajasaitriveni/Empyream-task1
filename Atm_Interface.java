package atmInterface;

import java.util.*;

public class Atm_Interface {
		private String str1;
		
		private boolean checkUser(String user) {
			str1 = "user1";
			if(str1.equalsIgnoreCase(user)) return true;
			return false;
		}
		
		private boolean checkPass(int pass) {
			int str2 = 2002;
			if(str2 == pass) return true;
			return false;
		}
		
		private static boolean checkTransferName(String name) {
			String str = "user2";
			if(str.equalsIgnoreCase(name)) return true;
			return false;
		}

		public static void main(String[] args){
			Scanner sc = new Scanner(System.in);
			int balance = 10000, addAmount = 0, takeAmount = 0, bal = balance, addAmount1 = 0, transferAmount = 0;
			
			Atm_Interface atm = new Atm_Interface();
			
			for(int i=1; i<=3; i++) {
				System.out.print("Enter UserName : ");
				String user = sc.next();
				
				if(atm.checkUser(user)) {
					for(; i<=3; i++) {
						
						System.out.print("Enter PIN : ");
						int pass = sc.nextInt();
						
						if(atm.checkPass(pass)) {
							System.out.println("\nWelcome " + atm.str1 + " !");
							while(true) {
								System.out.print("\n1. Check Balance\n2. Deposit Amount\n3. Withdrawal\n4. Transaction History\n5. Transfer Amount\n6. Exit\n\nYour Option : ");
								int opt = sc.nextInt();
								
								switch(opt) {
									case 1:
										System.out.println("\n***************To Check Balance Amount***************");
										System.out.println("Your Balance : " + balance);
										break;
										
									case 2:
										System.out.println("\n***************To Deposit Amount***************");
										System.out.print("Enter amount to Deposit : ");
										addAmount = sc.nextInt();
										addAmount1 = addAmount;
										balance += addAmount;
										System.out.println("Credited Successfully!");
										break;
										
									case 3:
										System.out.println("\n***************To Withdraw Amount***************");
										System.out.print("Enter Amount to Withdraw : ");
										takeAmount = sc.nextInt();
										if(takeAmount > balance) {
											System.out.print("Insufficient Balance\nTry less than Available Balance !\n");
											System.out.println("Your Current Balance : " + balance);
										}
										else {
											balance -= takeAmount;
											System.out.println("Collect your Amount");
										}
										break;
										
									case 4:
										System.out.println("\n***************Transaction History***************");
										
										System.out.println("\nWelcome to Mini Bank\n-------------------------------");
										System.out.println("Available Balance   : " + bal);
										System.out.println("Amount Deposited    : " + addAmount1);
										System.out.println("Amount Withdrawed   : " + takeAmount);
										System.out.println("Amount Transferred  : " + transferAmount);
										System.out.println("-------------------------------\nUpdated Balance     : " + (bal + addAmount1 - takeAmount - transferAmount));
										System.out.println("-------------------------------\n***********Thank You***********");
										break;
										
									case 5:
										System.out.println("\n***************To Transfer Amount***************");
										
										for(int k = 1; k <=3; k++) {
											System.out.print("\nEnter UserName : ");
											String otherUser = sc.next();
											
											if(checkTransferName(otherUser)) {
												
												for(; k <=3; k++) {
													System.out.print("Enter Account Number : ");
													String otherPass = sc.next();
													
													if(otherPass.length() > 5 && otherPass.length() < 10) {
														System.out.print("\nEnter Amount to Transfer : ");
														transferAmount = sc.nextInt();
														
														if(transferAmount < balance) {
															balance -= transferAmount;
															System.out.println("Amount Transferred Successfully to " + otherUser + " !\nDo you want know your current balance ? (Yes / No) :");
															String s = sc.next();
															switch(s) {
																case "yes":
																case "Yes":
																	System.out.println("Your Current Balance : " + balance);
																	break;
																	
																case "no":
																case "No":
																default:
																	break;
															}
															
														}
														
														else System.out.println("Amount should be less than balance");
														break;
													}
													
													else {
														System.out.println("Account Number must be greater than 5 characters!!!");
													}
													
												}
												break;
											}
											else {
												System.out.println("No user have that username!");
											}
										}
										break;
										
								}
								if(opt == 6) {
									System.out.println("Thank you for coming...");
									break;
								}
							}
							break;
						}
						else if(i>2) {
							System.out.print("Account Locked!");
						}
					}
					break;
				}
			}
			sc.close();
		}
}