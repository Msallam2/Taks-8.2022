public class TV_Remote {
    private String[] channels;
    private int current_channel;

    TV_Remote(int a_o_c){
        channels = new String[a_o_c];

        for (int z = 0; z < a_o_c; z++){
            channels[z] = "Channel " + z;
        }

        current_channel = 0;
    }

    void nextChannel(){
        if (current_channel < channels.length - 1){
            current_channel++;  
        }

        else{
            current_channel = 0;
        }

    }


    void nameChannel(String n){
        String on = channels[current_channel];
        channels[current_channel] = n;
        System.out.println("Name geändert: " + on + " -> " + n);
    }
    
    void acquireData(){
        System.out.println();
        System.out.println("Current channel: " + current_channel);
        System.out.println("Channel name: " + channels[current_channel]);
        System.out.println();
    }

}
