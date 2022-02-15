import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Image{
//    int height;
//    int width;
//    String Imagepath;
    File f;
    BufferedImage image;

    public Image(String Imagepath){
        f = new File(Imagepath);
    }

    public void setImageSize(int height, int width) throws IOException {
        try{
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            image = ImageIO.read(f);
        }catch (IOException e){
            System.out.println("Error: " + e);
        }

    }

}
