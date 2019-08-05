package HomeTask1;

import java.util.List;

public class Television {

  private List<Channel> channels;

  public Television (List<Channel> temp){
      this.channels=temp;
  }

  public Channel getChannel(int i){
      return channels.get(i);
  }

}
