package cs3560Assignment1;
//@author: David Maestas
//Date last modified: 9/28/2020
//purpose: A desktop based console program that simulates a live poll program

import java.util.ArrayList;
import java.util.Random;

public class SimulationDriver {
	
	private static ArrayList<String> students = new ArrayList<String>(1);	//creates an array list to store the students' names
	private static final String CHOICES = "ABCD";		//string contains the available answer selections
	
	//method to see if a char array contains a specific char value
	private static boolean contains(char c, char[] array) {
		for(int i = 0; i < array.length; i++) {
			char index = array[i];
			if(index == c) {
				return true;		//returns true if char is in array
			}//end if
		}//end for
		return false;				//returns false if char is not in array
	}//end contains
	
	
	//generates the list of students
	private static void generateStudents() {
		Random rand = new Random();
		int participants = rand.nextInt(29) + 1;		//generates a random integer value of participants
		System.out.println("\nCreating " + participants + " participants. \n");
		for(int i = 0; i < participants; i++) {
			students.add(Student.generateName());		//calls a method to generate name then adds the name into array list 
		}//end for
	}//end generateStudents
	
	
	//generates the students' answers for single choice questions
	private static void generateAnswerS(VotingService iVote) {
		Random r1 = new Random();
		String selection;
		char[] letter = new char[1];
		int x;
		int count;		//used to determine if the student has already submitted an answer before
		
		//loops through students so that each student submits an answer
		for(int i = 0; i < students.size(); i++) {
			x = 0;
			count = 0;
			//while loop randomly determines if a student changes their answer
			while(x == 0) {
				selection = "";
				letter[0] = CHOICES.charAt(r1.nextInt(CHOICES.length()));	//adds a random char from String "CHOICES" into char[] letter
				selection += letter[0];			//appends the char at index 0 of letter into the selection string
				if(count == 0) {
					System.out.println(students.get(i) + " has made a selection!");
					count++;
				}//end if
				else {
					System.out.println(students.get(i) + " has changed their selection!");
				}//end else
				iVote.receiveAnswer(students.get(i), selection);
				x = r1.nextInt(4);
			}//end while
		}//end for
	}//end generateAnswerS
	
	
	
	private static void generateAnswersM(VotingService iVote) {
		Random r1 = new Random();
		String selection;
		char[] letter = new char[4];	//char[] used to track which answer has already been chosen by a student
		int x;	//variable to determine if the student will resubmit their answer
		int y;	//variable to keep track of letter index location
		int count;		//used to determine if the student has already submitted an answer before
		int total;		//int that counts how many choices the student selects for their answer
		char alpha;		//char variable used to store the randomly generated char value representing an answer choice
		
		//loops through students so that each student submits an answer
		for(int i = 0; i < students.size(); i++) {
			x = 0;
			count = 0;
			/*while loop randomly determines if a student changes their answer 
			 * if x is 0, the current student resubmits their answer
			 * breaks out of the while loop if x is not 0*/
			while(x == 0) {
				selection = "";
				total = r1.nextInt(4) + 1;
				y = 0;
				
				//while loop adds either 1, 2, 3, or 4 selections for the student's answer
				while(total != 0) {
					alpha = CHOICES.charAt(r1.nextInt(CHOICES.length()));	//stores the randomly selected char into alpha
					boolean check = contains(alpha, letter);	//calls contains and stores boolean value in check
					if(check) {
						total++;
					}//end if
					else {
						letter[y] = alpha;	//adds the char into letter array to keep track of selected answer	
						selection += alpha;		//appends the char at the end of the String "selection"
						y++;
					}//end else
					total--;
				}//end while
				
				for(int j = 0; j < letter.length; j++) {
					letter[j] = 'Z';	//resets the letter array for the next student's answers
				}//end for
				
				if(count == 0) {
					System.out.println(students.get(i) + " has made a selection!");
					count++;
				}//end if
				else {
					System.out.println(students.get(i) + " has changed their selection!");
				}//end else
				iVote.receiveAnswer(students.get(i), selection);	//calls the iVote service to receive the student's answer	
				x = r1.nextInt(4);		//randomly generates an int to determine if the student will resubmit their answer
			}//end while
		}//end for
		
	}//end generateAnswersM

	public static void main(String[] args) {
		Question question = new Question();
		VotingService iVote = new VotingService();
		Random rand = new Random();
		int x = rand.nextInt(2);	//generates a random integer from 0-1
		
		//randomly chooses single question if integer x is 0;
		if(x == 0) {
			String qType = "singleQ";		//configures the question type
		
			question.setSingleChoice("How many Super Bowls have the Pittsburgh Steelers won?");
			question.setAnswerS("C");
			question.setA("A: 4");
			question.setB("B: 3");
			question.setC("C: 6");
			question.setD("D: 8");
			System.out.println(question.getSingleChoice());
			System.out.println(question.getA() + " \t" + question.getB());
			System.out.println(question.getC() + " \t" + question.getD());
		
			//configure iVote's question type
			iVote.setQType(qType);
		
			//configures iVote's answer selections
			iVote.setAnswer(question.getAnswerS());
		
			generateStudents();
			generateAnswerS(iVote);
			System.out.println();
			iVote.tally();		//calls the tally method
			iVote.showResults();		//calls the showResults method
		}//end if
		
		//randomly chooses multiple choice question if integer x is 1
		if(x == 1) {
			String qType = "multiQ";
			
			question.setMultipleChoice("Which of the following teams have never won a Super Bowl? (Choose all that apply)");
			question.setAnswerM("A, D");
			question.setA("A: Cleveland Browns");
			question.setB("B: Philadelphia Eagles");
			question.setC("C: Tampa Bay Buccaneers");
			question.setD("D: Buffalo Bills");
			System.out.println(question.getMultipleChoice());
			System.out.println(question.getA() + " \t" + question.getB());
			System.out.println(question.getC() + " \t" + question.getD());
			
			//configure iVote's question type
			iVote.setQType(qType);
			
			//configures iVote's answer selections
			iVote.setAnswer(question.getAnswerM());
			
			generateStudents();
			generateAnswersM(iVote);
			System.out.println();
			iVote.tally();			//calls the tally method
			iVote.showResults();	//calls the showResults method
		}//end if
	}//end main
	
}
