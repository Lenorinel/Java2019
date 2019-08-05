package HomeTask1;//У передачи есть название, которое выводится на экран

public class Broadcast {
    private String name;

    public Broadcast(String name){
        this.name = name;
    }

    public void showTheName(){
        System.out.println(name);
    }
}
