import java.util.*;
class VotingSystem{
	Map<String,Integer> voted=new HashMap<>();
	Map<String,Integer> sortedvote=new LinkedHashMap<>();
	public void castVote(String candidate) {
		voted.put(candidate,voted.getOrDefault(candidate, 0)+1);
		sortedvote.put(candidate, voted.getOrDefault(candidate, 0)+1);
		}
	public void displayRawVotes() {
		System.out.println("Entered votes: ");
		voted.forEach((candidate,votes) ->
		System.out.println(candidate+" >> "+votes+" votes"));
		}
	public void sortingvotes() {
		Map<String,Integer> sorted=new TreeMap<>(voted);
		 System.out.println("Sorted Results (by candidate name):");
		 sorted.forEach((candidate,votes) ->
		 System.out.println(candidate+" >> "+votes+" votes"));
	}
	public void enteredWise() {
		 System.out.println("Vote Order (first appearance of candidates):");
		 sortedvote.forEach((candidate,votes) ->
		 System.out.println(candidate+" >> "+votes+" votes"));
	}

}
 public class Voting {
	public static void main(String[] args) {
		VotingSystem vote=new VotingSystem();
		vote.castVote("Bhakya");
		vote.castVote("Tinbeer");
		vote.castVote("Bhakya");
		vote.castVote("Andrea");
		vote.castVote("Chloe");
		vote.displayRawVotes();
		vote.sortingvotes();
		vote.enteredWise();
		
	}

}
