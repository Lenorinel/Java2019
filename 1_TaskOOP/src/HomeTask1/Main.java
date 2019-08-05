package HomeTask1;

import java.util.LinkedList;
import java.util.List;

public class Main {



    public static void main(String[] args) {



        Television television = onTv();

        Controller controller = new Controller(television);

        controller.selectChannel(1);
        controller.selectChannel(2);
        controller.selectChannel(3);
        controller.selectChannel(4);
    }

    private static Television onTv() {

        List<Broadcast> broadcastsA = addCasts("A", "brd1", "brd2", "brd3");
        List<Broadcast> broadcastsB = addCasts("B", "brd1", "brd2", "brd3");
        List<Broadcast> broadcastsC = addCasts("C", "brd1", "brd2", "brd3");
        Television tv = new Television(crateChannels(broadcastsA,broadcastsB,broadcastsC));
        return tv;
    }

    private static List<Channel> crateChannels(List<Broadcast> broadcastsA, List<Broadcast> broadcastsA1, List<Broadcast> broadcastsA2) {
        List<Channel> channels = new LinkedList<>();
        Channel channelA = new Channel("A", 1, broadcastsA);
        Channel channelB = new Channel("B", 2, broadcastsA1);
        Channel channelC = new Channel("C", 3, broadcastsA2);
        channels.add(channelA);
        channels.add(channelB);
        channels.add(channelC);
        return channels;
    }

    private static List<Broadcast> addCasts(String name, String c1, String c2, String c3) {
        List<Broadcast> broadcasts = new LinkedList<>();
        Broadcast broadcast1 = new Broadcast(name + " " + c1);
        Broadcast broadcast2 = new Broadcast(name + " " + c2);
        Broadcast broadcast3 = new Broadcast(name + " " + c3);
        broadcasts.add(broadcast1);
        broadcasts.add(broadcast2);
        broadcasts.add(broadcast3);
        return broadcasts;
    }
    }


