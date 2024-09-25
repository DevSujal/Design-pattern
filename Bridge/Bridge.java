abstract class TV {

    abstract public void on();

    public abstract void off();

    public abstract void setChannel(int channelNo);
}

class PhilipsTV extends TV {

    @Override
    public void on() {
        System.out.println("Philips TV is on");
    }

    @Override
    public void off() {
        System.out.println("Philips TV is off");
    }

    @Override
    public void setChannel(int channelNo) {
        System.out.println("Philips TV is set to : " + channelNo + " channel number!");
    }
}

class SonyTV extends TV {

    @Override
    public void on() {
        System.out.println("Sony TV is on");
    }

    @Override
    public void off() {
        System.out.println("Sony TV is off");
    }

    @Override
    public void setChannel(int channelNo) {
        System.out.println("Sony TV is set to : " + channelNo + " channel number!");
    }
}

abstract class Remote {
    private TV tv;

    protected Remote(TV tv) {
        this.tv = tv;
    }

    public void off() {
        tv.off();
    }
    public void on() {
        tv.on();
    }

    public void setChannel(int channelNo) {
        tv.setChannel(channelNo);
    }
}

class SonyRemote extends Remote {
    int currChannel;

    public SonyRemote(TV tv) throws Exception {
        super(tv);
        if(!(tv instanceof SonyTV)) {
            throw new Exception("please provide sony refrence");
        }
        currChannel = 1;
    }

    public void prevChannel() {
        if(currChannel == 1) {
            System.out.println("you can't change the channel because you are at the first channel!");
            return;
        }
        currChannel--;
        setChannel(currChannel);
    }

    public void nextChannel() {
        if(currChannel == 999) {
            System.out.println("you can't change the channel because you are at the last channel!");
            return;
        }
        currChannel++;
        setChannel(currChannel);
    }
}
class PhilipsRemote extends Remote {
    int currChannel;

    public PhilipsRemote(TV tv) throws Exception {
        super(tv);
        if(!(tv instanceof PhilipsTV)) {
            throw new Exception("please provide sony refrence");
        }
        currChannel = 1;
    }

    public void prevChannel() {
        if(currChannel == 1) {
            System.out.println("you can't change the channel because you are at the first channel!");
            return;
        }
        currChannel--;
        setChannel(currChannel);
    }

    public void nextChannel() {
        if(currChannel == 999) {
            System.out.println("you can't change the channel because you are at the last channel!");
            return;
        }
        currChannel++;
        setChannel(currChannel);
    }

    public void jumpChannel(int channel) {
        if(channel < 1 && channel > 999) {
            System.out.println("the channel is not available");
            return;
        }

        setChannel(channel);
    }
}

public class Bridge {

    public static void main(String[] args) throws Exception {
        SonyRemote remote = new SonyRemote(new SonyTV());

        remote.on();
        remote.nextChannel();
        remote.prevChannel();
        remote.off();
        System.out.println();
        PhilipsRemote pRemote = new PhilipsRemote(new PhilipsTV());
        pRemote.on();
        pRemote.nextChannel();
        pRemote.prevChannel();
        pRemote.jumpChannel(90);
        pRemote.off();
    }
}