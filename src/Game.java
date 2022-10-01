public class Game extends Thread {

    public static boolean[] moveBack = new boolean[10];

    public static boolean[] auauau = new boolean[10];
    
    public static boolean started = false;

    public static boolean over = false;

    public static int[] coordsX = new int[10];
    public static int[] coordsY = new int[10];

    public static int overTimer = 0;

    public static int timer = 0; 
    public static int level = 1;

    public static int score = 0;

    public static int live = 5;

    // Start when Thread got started
    public void run() {

        int x;
        started = true;
        
        for (x = 0; x < coordsX.length; x++){

        coordsX[x] = -100;
        coordsY[x] = (int) (Math.random() * 500 + 1);

        }

        cubeMain(x);
    }

    // Main loop Method
    public void cubeMain(int x){

        while(true){

        level(x);
        moveCube(x);

        switch (Game.timer){
            case 1910:
            Game.auauau[0] = true;
            Game.coordsY[0] = (int) (Math.random() * 500 + 1);
            break;
            case 1930:
            Game.auauau[1] = true;
            Game.coordsY[1] = (int) (Math.random() * 500 + 1);
            break;
            case 1950:
            Game.auauau[2] = true;
            Game.coordsY[2] = (int) (Math.random() * 500 + 1);
            break;
            case 1970:
            Game.auauau[3] = true;
            Game.coordsY[3] = (int) (Math.random() * 500 + 1);
            break;
            case 1990:
            Game.auauau[4] = true;
            Game.coordsY[4] = (int) (Math.random() * 500 + 1);
            break;
            case 2010:
            Game.auauau[5] = true;
            Game.coordsY[5] = (int) (Math.random() * 500 + 1);
            break;
            case 2030:
            Game.auauau[6] = true;
            Game.coordsY[6] = (int) (Math.random() * 500 + 1);
            break;
            case 2050:
            Game.auauau[7] = true;
            Game.coordsY[7] = (int) (Math.random() * 500 + 1);
            break;
            case 2070:
            Game.auauau[8] = true;
            Game.coordsY[8] = (int) (Math.random() * 500 + 1);
            break;
            case 2090:
            Game.auauau[9] = true;
            Game.coordsY[9] = (int) (Math.random() * 500 + 1);
            break;
            case 2110:
            Game.auauau[0] = true;
            Game.coordsY[0] = (int) (Math.random() * 500 + 1);
            break;
            case 2130:
            Game.auauau[1] = true;
            Game.coordsY[1] = (int) (Math.random() * 500 + 1);
            break;
            case 2140:
            Game.auauau[2] = true;
            Game.coordsY[2] = (int) (Math.random() * 500 + 1);
            break;
            case 2170:
            Game.auauau[3] = true;
            Game.coordsY[3] = (int) (Math.random() * 500 + 1);
            break;
            case 2200:
            Game.auauau[4] = true;
            Game.coordsY[4] = (int) (Math.random() * 500 + 1);
            break;
            case 2220:
            Game.auauau[5] = true;
            Game.coordsY[5] = (int) (Math.random() * 500 + 1);
            break;
            case 2250:
            Game.auauau[6] = true;
            Game.coordsY[6] = (int) (Math.random() * 500 + 1);
            break;
            case 2280:
            Game.auauau[7] = true;
            Game.coordsY[7] = (int) (Math.random() * 500 + 1);
            break;
            case 2300:
            Game.auauau[8] = true;
            Game.coordsY[8] = (int) (Math.random() * 500 + 1);
            break;
            case 2320:
            Game.auauau[9] = true;
            Game.coordsY[9] = (int) (Math.random() * 500 + 1);
            break;
            case 2340:
            Game.auauau[0] = true;
            Game.coordsY[0] = (int) (Math.random() * 500 + 1);
            break;
            case 2360:
            Game.auauau[1] = true;
            Game.coordsY[1] = (int) (Math.random() * 500 + 1);
            break;
            case 3200:
            Game.auauau[0] = true;
            Game.coordsY[0] = (int) (Math.random() * 500 + 1);
            break;
            case 3220:
            Game.auauau[1] = true;
            Game.coordsY[1] = (int) (Math.random() * 500 + 1);
            break;
            case 3240:
            Game.auauau[2] = true;
            Game.coordsY[2] = (int) (Math.random() * 500 + 1);
            break;
            case 3260:
            Game.auauau[3] = true;
            Game.coordsY[3] = (int) (Math.random() * 500 + 1);
            break;
            case 3280:
            Game.auauau[4] = true;
            Game.coordsY[4] = (int) (Math.random() * 500 + 1);
            break;
            case 3300:
            Game.auauau[5] = true;
            Game.coordsY[5] = (int) (Math.random() * 500 + 1);
            break;
            case 3320:
            Game.auauau[6] = true;
            Game.coordsY[6] = (int) (Math.random() * 500 + 1);
            break;
            case 3340:
            Game.auauau[7] = true;
            Game.coordsY[7] = (int) (Math.random() * 500 + 1);
            break;
            case 3360:
            Game.auauau[8] = true;
            Game.coordsY[8] = (int) (Math.random() * 500 + 1);
            break;
            case 3380:
            Game.auauau[9] = true;
            Game.coordsY[9] = (int) (Math.random() * 500 + 1);
            break;
            case 3400:
            Game.auauau[0] = true;
            Game.coordsY[0] = (int) (Math.random() * 500 + 1);
            break;
        }
        
        timer ++;
    }

    }

    // increase Level after time
    public void level(int x){
        if (live <= 0){
            over(x);
        } else {
        if (timer > 1900){
            level = 5;
            Frame.paint = true;
        }
        else if (timer > 1120){
            level = 4;
            Frame.paint = true;
        } else if (timer > 710){
            level = 3;
            Frame.paint = true;
        } else if (timer > 420){
            level = 2;
            Frame.paint = true;
        }
        }
    }

    // Move the Cube/Button
    public void moveCube(int x){

        for (x = 0; x < coordsX.length ; x++){

        if (coordsX[x] >= 750){
            moveBack[x] = true;
            live --;
            Frame.paint = true;
        }
        if (moveBack[x] == true){
                coordsX[x] = -100;
                moveBack[x] = false;
        }
        if (auauau[x] == true){
            coordsX[x] = 500;
            auauau[x] = false;
        }

        try {
            Thread.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        coordsX[x] += level;
        }
    
    }

    // Remove moving Buttons back to spawn, increase overTimer for animation
    public void over(int x){
        over = true;

        for (x = 0; x < coordsX.length; x++){
            coordsX[x] = -100;
        }

        do {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            overTimer ++;

        }while(over == true);
        cubeMain(x);
        
    }
}
