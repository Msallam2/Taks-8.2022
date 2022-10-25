import java.awt.*;

public class AmbientLight {
    public int hue, saturation, brightness;

    public AmbientLight(int hue, int saturation, int helligkeit) {

        if (hue > 360){
            hue = 360;
        }

        if (saturation > 100){
            saturation = 100;
        }

        if (helligkeit > 100){
            helligkeit = 100;
        }

        this.hue = hue;
        this.saturation = saturation;
        this.brightness = helligkeit;
    }

    public void increaseSaturation() {
        if (saturation < 100) {
            saturation = saturation + 1;
        } else {
            saturation = 100;
        }
    }

    public void decreaseSaturation() {
        if (saturation > 0) {
            saturation = saturation - 1;
        } else {
            saturation = 0;
        }
    }

    public void increaseBrightness() {
        if (brightness < 100) {
            brightness = brightness + 1;
        } else {
            brightness = 100;
        }
    }

    public void decreaseBrightness() {
        if (brightness > 0) {
            brightness = brightness - 1;
        } else {
            brightness = 0;
        }
    }

    public int[] getNextColor() {
        hue = hue + 1;
        if (hue > 360) {
            hue = 0;
        }
        return toRGB(hue, saturation, brightness);
    }

    public int[] getRandomColor() {
        hue = (int) (Math.random() * 360 + 0);
        saturation = (int) (Math.random() * 100 + 0);
        brightness = (int) (Math.random() * 100 + 0);
        return toRGB(hue, saturation, brightness);
    }

    private int[] toRGB(int hue, int saturation, int helligkeit) {
        int rgb = Color.HSBtoRGB(hue,  (float) saturation / 100, (float) helligkeit / 100);
        Color c = new Color(rgb);
        int[] output = {
                c.getRed(),
                c.getGreen(),
                c.getBlue()
        };
        return output;
    }
}