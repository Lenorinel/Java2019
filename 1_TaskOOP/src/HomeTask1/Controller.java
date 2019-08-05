package HomeTask1;

//Пульт может выбирать каналы
public class Controller implements Switcher {
    Television television;

    public Controller(Television television) {
        this.television = television;
    }

    @Override
    public void selectChannel(int number) {
        switch (number) {
            case (1):
                television.getChannel(0).showBroadcast();
                break;
            case (2):
                television.getChannel(1).showBroadcast();
                break;
            case (3):
                television.getChannel(2).showBroadcast();
                break;
            default:
                break;
        }
    }

}
