import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  } //END zeroBlue()
  
  public void keepOnlyBlue() {
      zeroRed();
      zeroGreen();
    } //END keepOnlyBlue()
    
   public void zeroRed() {
       Pixel[][] image = this.getPixels2D();
       for (Pixel[] row : image) {
           for (Pixel pixel : row) {
               pixel.setRed(0);
            }
        }
    } //END zeroRed
    
   public void keepOnlyRed() {
       zeroBlue();
       zeroGreen();
    } //END keepOnlyRed()
    
   public void zeroGreen() {
       Pixel[][] image = this.getPixels2D();
       for(Pixel[] row : image) {
           for (Pixel pixel : row) {
               pixel.setGreen(0);
            }
        }
    } //END zeroGreen()
    
   public void keepOnlyGreen() {
       zeroRed();
       zeroBlue();
    } //END keepOnlyGreen()
    
   public void negate() {
       Pixel[][] image = this.getPixels2D();
       for (Pixel[] row : image) {
           for (Pixel pixel : row) {
               pixel.setRed(255-pixel.getRed());
               pixel.setGreen(255-pixel.getGreen());
               pixel.setBlue(255-pixel.getBlue());
            }
        }
    } //END negate
    
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < width / 2; col++) {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  public void mirrorVerticalRightToLeft() {
      Pixel[][] image = this.getPixels2D();
      Pixel leftPixel, rightPixel;
      int width = image[0].length;
      for (int row = 0; row<image.length; row++) {
          for (int col = width/2; col<width; col++) {
              rightPixel = image[row][col];
              leftPixel = image[row][width-1-col];
              leftPixel.setColor(rightPixel.getColor());
            }
        }
    }
    
   public void mirrorHorizontal() {
       Pixel[][] image = this.getPixels2D();
       Pixel topPixel, botPixel;
       int height = image.length;
       for (int row=0; row<image.length/2; row++) {
           for (int col=0; col<image[row].length; col++) {
               topPixel = image[row][col];
               botPixel = image[height-1-row][col];
               botPixel.setColor(topPixel.getColor());
            }
        }
    }
    
   public void mirrorHorizontalBotToTop() {
       Pixel[][] image = this.getPixels2D();
       Pixel topPixel, botPixel;
       int height = image.length;
       for (int row=image.length/2; row<image.length; row++) {
           for (int col=0; col<image[row].length; col++) {
               botPixel = image[row][col];
               topPixel = image[height-1-row][col];
               topPixel.setColor(botPixel.getColor());
           }
       }
   }

    public void mirrorDiagonal() {
       Pixel[][] image = this.getPixels2D();
       int end = Math.min(image.length, image[0].length);
       Pixel botLeftPixel, topRightPixel;
       for (int row=0; row<end; row++) {
           for (int col=0; col<row; col++) {
               botLeftPixel = image[row][col];
               topRightPixel = image[col][row];
               topRightPixel.setColor(botLeftPixel.getColor());
           }
       }
   }
    
                   
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple() {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++) {
      count++;
      for (int col = 13; col < mirrorPoint; col++) {
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    } System.out.print(count);
  }
  
  public void mirrorArms() {
      Pixel[][] image = this.getPixels2D();
      int mirrorPoint = 194;
      Pixel botPixel, topPixel;
      for (int row = 165; row < 190; row++) {
          for (int col = 100; col < 297; col++) {
              topPixel = image[row][col];
              botPixel = image[mirrorPoint-row+mirrorPoint][col];
              botPixel.setColor(topPixel.getColor());
            }
        }
    }
      
  public void mirrorGull() {
      Pixel[][] image = this.getPixels2D();
      int mirrorPoint = 350;
      Pixel leftPixel, rightPixel;
      for (int row = 230; row < 325; row++) {
          for (int col = 233; col < 346; col++) {
              leftPixel = image[row][col];
              rightPixel = image[row][mirrorPoint-col+mirrorPoint];
              rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol) {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++) {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++) {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
    public void copy(Picture fromPic, 
                 int startRow, int startCol,
                 int fSR,      int fSC,
                 int fER,      int fEC){
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = fSR, toRow = startRow; 
         fromRow < fER &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = fSC, toCol = startCol; 
           fromCol < fEC &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }
  }
  
  
  
  /** Method to create a collage of several pictures */
  public void createCollage() {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  public void myCollage() {
    Picture balrog = new Picture("balrog.jfif");
    Picture cavestory = new Picture("cavestory.png");
    this.copy(balrog,0,0);
    balrog.mirrorVertical();
    this.copy(balrog,230,100);
    balrog.mirrorHorizontalBotToTop();
    this.copy(balrog,500,500);
    balrog.mirrorHorizontal();
    cavestory.mirrorDiagonal();
    this.copy(cavestory,800,500);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist) {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel downPixel, upPixel;
    Pixel[][] pixels = this.getPixels2D();
    Color downColor;
    Color rightColor = null;
    for (int row = 0; row < pixels.length-1; row++) {
      for (int col = 0; col < pixels[0].length-1; col++) {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        upPixel = pixels[row][col];
        downPixel = pixels[row+1][col];
        downColor = downPixel.getColor();
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > edgeDist || upPixel.colorDistance(downColor) > edgeDist) {
          leftPixel.setColor(Color.BLACK);
          upPixel.setColor(Color.BLACK);
        } else {
          leftPixel.setColor(Color.WHITE);
          upPixel.setColor(Color.WHITE);
        }
      }
    }
  }
  
  public void grayscale() {
      Pixel[][] image = this.getPixels2D();
      for (Pixel[] row : image) {
          for (Pixel pixel : row) {
              int average = (pixel.getRed()+pixel.getGreen()+pixel.getBlue())/3;
              pixel.setRed(average);
              pixel.setGreen(average);
              pixel.setBlue(average);
            }
        }
    } //END grayscale()
    
   public void fixUnderwater() {
       Pixel[][] image = this.getPixels2D();
       for (Pixel[] row : image) {
           for (Pixel pixel : row) {
               pixel.setRed(pixel.getRed()*6);
               if (pixel.getRed()<150) pixel.setRed(0);
            }
        }
    }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
