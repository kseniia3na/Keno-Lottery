import java.util.ArrayList;
import java.util.Random;

public class KenoInfo {
    Integer money;
    Integer amountWon;
    ArrayList<Integer> spots;
    Integer limit;
    Integer temp;
    Random rand;
    ArrayList<Integer> winningNumbers;
    ArrayList<Integer>  numbersMatch;
    Integer limitDraws;

    KenoInfo(){
        spots = new ArrayList<Integer>();
        limit = 0;
        winningNumbers = new ArrayList<Integer>();
        rand = new Random();
        temp = 0;
        numbersMatch = new ArrayList<>();
        limitDraws = 0;
        money = 0;
        amountWon =0;
    }

    void setLimit(int val){
        limit = val;
    }

    void setLimitDraw(int val){
        limitDraws = val;
    }

    //delete and generate
    void delAndGen(){
        winningNumbers.removeAll(winningNumbers);
        while(winningNumbers.size() < 20){
            temp = rand.nextInt(80 - 1 ) + 1;
            if(!winningNumbers.contains(temp)){
                winningNumbers.add(temp);
            }
        }
    }

    //checking winning numbers
    void checkSpots(){
        numbersMatch.removeAll(numbersMatch);
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < limit; j++){
                if(winningNumbers.get(i)==spots.get(j)){
                    numbersMatch.add(spots.get(j));
                }
            }
        }
        winning();
    }

    void winning(){
        if(limit == 1){
            money += (numbersMatch.size()) * 2;
            amountWon += (numbersMatch.size()) * 2;
        }
        else if(limit == 4){
            if(numbersMatch.size() == 4){money+=75;amountWon += 75;}
            else if(numbersMatch.size() == 3){money+=5;amountWon += 5;}
            else if(numbersMatch.size() == 2){money+=1;amountWon += 1;}
        }
        else if(limit == 8){
            if(numbersMatch.size() == 8){money += 10000;amountWon += 10000;}
            else if(numbersMatch.size() == 7){money+=750;amountWon += 750;}
            else if(numbersMatch.size() == 6){money+=50;amountWon += 50;}
            else if(numbersMatch.size() == 5){money+=12;amountWon += 12;}
            else if(numbersMatch.size() == 4){money+=2;amountWon += 2;}
        }
        else if(limit == 10) {
            if(numbersMatch.size() == 10){money += 100000;amountWon += 100000;}
            else if(numbersMatch.size() == 9){money+=4250;amountWon += 4250;}
            else if(numbersMatch.size() == 8){money+=450;amountWon += 450;}
            else if(numbersMatch.size() == 7){money+=40;amountWon += 40;}
            else if(numbersMatch.size() == 6){money+=15;amountWon += 15;}
            else if(numbersMatch.size() == 5){money+=2;amountWon += 2;}
            else if(numbersMatch.size() == 0){money+=5;amountWon += 5;}
        }
    }
}
