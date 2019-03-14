/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical() {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  public static void testMirrorVerticalRightToLeft() {
      Picture hk = new Picture("hk.png");
      hk.mirrorVerticalRightToLeft();
      hk.explore();
    }
    
   public static void testMirrorHorizontal() {
       Picture hk = new Picture("hk.png");
       hk.mirrorHorizontal();
       hk.explore();
    }
    
   public static void testMirrorHorizontalBotToTop() {
       Picture hk = new Picture("hk.png");
       hk.mirrorHorizontalBotToTop();
       hk.explore();
    }
   
   public static void testMirrorDiagonal() {
       Picture cavestory = new Picture("cavestory.png");
       cavestory.mirrorDiagonal();
       cavestory.explore();
    }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple() {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  public static void testMirrorArms() {
      Picture snowman = new Picture("snowman.jpg");
      snowman.mirrorArms();
      snowman.explore();
    }
  
  public static void testMirrorGull() {
      Picture gull = new Picture("seagull.jpg");
      gull.mirrorGull();
      gull.explore();
    }
  
  /** Method to test the collage method */
  public static void testCollage() {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  public static void testMyCollage() {
      Picture canvas = new Picture ("hk.png");
      canvas.myCollage();
      canvas.explore();
    }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void testKeepOnlyBlue() {
      Picture cavestory = new Picture("cavestory.jpg");
      cavestory.keepOnlyBlue();
      cavestory.explore();
    }
    
   public static void testKeepOnlyRed() {
       Picture cavestory = new Picture("cavestory.jpg");
       cavestory.keepOnlyRed();
       cavestory.explore();
    }
    
   public static void testKeepOnlyGreen() {
       Picture cavestory = new Picture("cavestory.jpg");
       cavestory.keepOnlyGreen();
       cavestory.explore();
    }
    
   public static void testNegate() {
       Picture cavestory = new Picture("cavestory.jpg");
       cavestory.negate();
       cavestory.explore();
    }
    
   public static void testGrayscale() {
       Picture cavestory = new Picture("cavestory.jpg");
       cavestory.grayscale();
       cavestory.explore();
    }
    
   public static void testFixUnderwater() {
       Picture water = new Picture("water.jpg");
       water.fixUnderwater();
       water.explore();
    }
    
   public static void testCopy() {
       Picture ocean = new Picture("beach.jpg");
       Picture daddy = new Picture("snowman.jpg");
       ocean.copy(daddy, 10, 10, 60, 160, 180, 220);
       ocean.explore();
    }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args) {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    testZeroBlue();
    testKeepOnlyBlue();
    testKeepOnlyRed();
    testKeepOnlyGreen();
    testNegate();
    testGrayscale();
    testFixUnderwater();
    testMirrorVertical();
    testMirrorVerticalRightToLeft();
    testMirrorHorizontal();
    testMirrorHorizontalBotToTop();
    testMirrorTemple();
    testMirrorArms();
    testMirrorGull();
    testMirrorDiagonal();
    testCollage();
    testMyCollage();
    testCopy();
    testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}