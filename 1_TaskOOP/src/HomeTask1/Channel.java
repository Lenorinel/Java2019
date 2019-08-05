package HomeTask1;

import java.util.List;


//Имеет название
// Имеет номер закрепленный на пульте
// Может показать текущую передачу
public class Channel {
    private String name;
    private int number;

    private List<Broadcast> broadcasts;

    public  Channel (String name, int number, List<Broadcast> broadcastsTemp){
        this.name = name;
        this.number = number;
       this.broadcasts = broadcastsTemp;
    }
    public void showBroadcast(){
        int number = (int)(Math.random()*100);
        if(number%2 == 0 && number != 0){
            number = 0;
        } else if (number != 0 && number%2 != 0) number = 1;
        else number = 2;
        broadcasts.get(number).showTheName();
    }


}
