package BrickDestroyFX.Model;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;

public class Level {
    private static final int LEVELS_COUNT = 6;

    Brick[] bricks;
    private Brick[][] levels;
    private Wall wall;
    private int level;
    private int brickCount;
    private BrickFactory brickFactory;

    public Level(Rectangle drawArea, int brickCount, int lineCount, double brickDimensionRatio, Point2D ballPos, Wall wall) {
        levels = makeLevels(drawArea, brickCount, lineCount, brickDimensionRatio);
        this.wall = wall;
        this.brickCount = brickCount;
    }

    private Brick[] makeSingleTypeLevel(Rectangle drawArea, int brickCnt, int lineCnt, double brickSizeRatio, String type) {
        /*
          if brickCount is not divisible by line count,brickCount is adjusted to the biggest
          multiple of lineCount smaller then brickCount
         */
        brickCnt -= brickCnt % lineCnt;

        int brickOnLine = brickCnt / lineCnt;

        double brickLen = drawArea.getWidth() / brickOnLine;
        double brickHgt = brickLen / brickSizeRatio;

        brickCnt += lineCnt / 2;

        Brick[] tmp = new Brick[brickCnt];

        Dimension2D brickSize = new Dimension2D((int) brickLen, (int) brickHgt);
        Point2D p = new Point2D(0, 0);

        int i;
        for (i = 0; i < tmp.length; i++) {
            int line = i / brickOnLine;
            if (line == lineCnt)
                break;
            double x = (i % brickOnLine) * brickLen;
            x = (line % 2 == 0) ? x : (x - (brickLen / 2));
            double y = (line) * brickHgt;
            //p=setLocation(x, y);
            p = new Point2D(x, y);
            tmp[i] = makeBrick(p, brickSize, type);
        }

        for (double y = brickHgt; i < tmp.length; i++, y += 2 * brickHgt) {
            double x = (brickOnLine * brickLen) - (brickLen / 2);
            p = new Point2D(x, y);
            tmp[i] = new ClayBrick(p, brickSize);
        }
        return tmp;

    } //Generate Level 1  brick only

    private Brick[] makeChessboardLevel(Rectangle drawArea, int brickCnt, int lineCnt, double brickSizeRatio, String typeA, String typeB) {
        /*
          if brickCount is not divisible by line count,brickCount is adjusted to the biggest
          multiple of lineCount smaller then brickCount
         */
        brickCnt -= brickCnt % lineCnt;

        int brickOnLine = brickCnt / lineCnt;

        int centerLeft = brickOnLine / 2 - 1;
        int centerRight = brickOnLine / 2 + 1;

        double brickLen = drawArea.getWidth() / brickOnLine;
        double brickHgt = brickLen / brickSizeRatio;

        brickCnt += lineCnt / 2;

        Brick[] tmp = new Brick[brickCnt];

        Dimension2D brickSize = new Dimension2D((int) brickLen, (int) brickHgt);
        Point2D p = new Point2D(0, 0);

        int i;
        for (i = 0; i < tmp.length; i++) {
            int line = i / brickOnLine;
            if (line == lineCnt)
                break;
            int posX = i % brickOnLine;
            double x = posX * brickLen;
            x = (line % 2 == 0) ? x : (x - (brickLen / 2));
            double y = (line) * brickHgt;
            p = new Point2D(x, y);

            boolean b = ((line % 2 == 0 && i % 2 == 0) || (line % 2 != 0 && posX > centerLeft && posX <= centerRight));
            tmp[i] = b ? makeBrick(p, brickSize, typeA) : makeBrick(p, brickSize, typeB);
        }

        for (double y = brickHgt; i < tmp.length; i++, y += 2 * brickHgt) {
            double x = (brickOnLine * brickLen) - (brickLen / 2);
            p = new Point2D(x, y);
            tmp[i] = makeBrick(p, brickSize, typeA);
        }
        return tmp;
    } // generate level 2,3,4

    public Brick[][] makeLevels(Rectangle drawArea, int brickCount, int lineCount, double brickDimensionRatio) {
        Brick[][] tmp = new Brick[LEVELS_COUNT][];
        tmp[0] = makeSingleTypeLevel(drawArea, brickCount, lineCount, brickDimensionRatio, "CLAY");
        tmp[1] = makeChessboardLevel(drawArea, brickCount, lineCount, brickDimensionRatio, "CLAY", "CEMENT");
        tmp[2] = makeChessboardLevel(drawArea, brickCount, lineCount, brickDimensionRatio, "CLAY", "STEEL");
        tmp[3] = makeChessboardLevel(drawArea, brickCount, lineCount, brickDimensionRatio, "STEEL", "CEMENT");
        tmp[4] = makeSingleTypeLevel(drawArea, brickCount, lineCount, brickDimensionRatio, "CEMENT");
        tmp[5] = makeSingleTypeLevel(drawArea, brickCount, lineCount, brickDimensionRatio, "STEEL");
        return tmp;
    } //call levels after generation.


    public void nextLevel() {
        wall.setBricks(levels[level++]);
        wall.setBrickCount(wall.getBricks().length);
    } // method to increase level

    public boolean hasLevel() {
        return level < levels.length;
    } //method to see whather it has reach the last level

    private Brick makeBrick(Point2D point, Dimension2D size, String type) {
        BrickFactory brickFactory = new BrickFactory();
        return brickFactory.makeBrick(point, size, type);
    } //makeBrick method that passes elements to brickFactory
}

