package cs3560Assignment1;
//@author: David Maestas
//Date last modified: 9/28/2020

public interface VotingInterface {
	 public void setQType(String type);
	 
	 public void setAnswer(String ans);
	 
	 public void receiveAnswer(String nameID, String submission);
	 
	 public void showResults(); 	
	 
	 public void tally();
	 
}//end VotingInterface
