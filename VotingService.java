package cs3560Assignment1;
//@author: David Maestas
//Date last modified: 9/28/2020
//purpose: a voting service that accepts student submissions and can output the
//	statistic results using standard output

import java.util.ArrayList;

public class VotingService implements VotingInterface {
	private int a = 0;	//variable that stores the # of times 'A' is chosen
	private int b = 0;	//variable that stores the # of times 'B' is chosen
	private int c = 0;	//variable that stores the # of times 'C' is chosen
	private int d = 0;	//variable that stores the # of times 'D' is chosen
	private String q;		//variable to store the chosen question type
	private String answer;	//variable to store the answer
	private ArrayList<String> students = new ArrayList<String>();
	private ArrayList<String> choice = new ArrayList<String>();
	
	//configures the question type
	public void setQType(String type){
		q = type;
	}//end setQType
	
	
	//sets the answer string within the String variable "answer"
	public void setAnswer(String ans) {
		answer = ans;
	}//end setAnswer
	
	//receives the answer(s) selected by a student
	public void receiveAnswer(String nameID, String submission) {
		
		//run if nameID is not in the students array list
		if(!students.contains(nameID)) {
			students.add(nameID);		//add the nameID to the students array list
			choice.add(submission);		//add the submission to the choice array list
		}//end if
		//run if nameID is in the students array list
		else {
			int index = students.indexOf(nameID);		//get the index where the nameID is located
			choice.set(index, submission);				//overwrite the submission at the corresponding index in submission array list
		}//end else
	}//end receiveAnswer
	
	//tallys how many times each answer choice is chosen
	public void tally() {
		//run this if the question type is single choice
		if(q.equals("singleQ")) {
			for(int i = 0; i < choice.size(); i++) {
				//increments each option as they appear in array list
				switch(choice.get(i)){
					case "A":
						a++;
						break;
					case "B":
						b++;
						break;
					case "C":
						c++;
						break;
					case "D":
						d++;
						break;
					default:
						System.out.println("ERROR: No Value detected");
						System.exit(0);
				}//end switch statement
			}//end for
		}//end if
		//run this if the question type is multiple choice
		if(q.contentEquals("multiQ")) {
			for(int i = 0; i < choice.size(); i++) {
				String str = choice.get(i);
				String[] arr = str.split("");	//splits the string into characters for when student selects multiple choices
				for(int j = 0; j < arr.length; j++) {
					//switch statement increments a variable depending on which value is found
					switch(arr[j]) {
					case "A":
						a++;
						break;
					case "B":
						b++;
						break;
					case "C":
						c++;
						break;
					case "D":
						d++;
						break;
					default:
						System.out.println("ERROR: No Value detected");
						System.exit(0);
					}//end switch
				}//end for
			}//end for
		}//end if
	}//end tally
	
	@Override
	//prints the statistical results of the poll to the screen
	public void showResults() {
		System.out.println("Here are the sudents' choices:");
		System.out.println("A: " + a + " votes");
		System.out.println("B: " + b + " votes");
		System.out.println("C: " + c + " votes");
		System.out.println("D: " + d + " votes");
		System.out.println("The correct answer is: " + answer);	
	}//end showResults
}
