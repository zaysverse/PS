import java.util.*;

public class Solution {
    static String[][] map;
    static int x, y, stat, height, width;
    static String status = "^v<>";
    static String skill = "UDLRS";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            height = sc.nextInt();
            width = sc.nextInt();
            map = new String[height][width];

            for (int i = 0; i < height; i++) {
                map[i] = sc.next().split("");
                for (int j = 0; j < width; j++) {
                    String cur = map[i][j];
                    if (status.contains(cur)) { // 전차 위치 기록
                        x = i;
                        y = j;
                        stat = status.indexOf(cur);
                        map[x][y] = ".";
                    }
                }

            }

            int N = sc.nextInt();   // 입력의 개수
            String command = sc.next();

            for (int i = 0; i < N; i++) {
                int com = skill.indexOf(command.charAt(i));
                game(com);
            }
            map[x][y]=status.charAt(stat)+"";


            System.out.print("#" + test_case + " ");
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }

    }


    static void game(int com) {

        if (com == 4) {     // Shoot
            shoot();
        } else {    // 방향을 바꾸고, 평지라면 이동.
            stat = com;
            isFlat(com);
        }


    }

    //평지라면 이동한다.
    static void isFlat(int com) {
        if (com == 0) {
            if (x > 0 && map[x-1][y].contains(".")) x--;
        } else if (com == 1) {
            if (x < height - 1 && map[x+1][y].contains(".")) x++;
        } else if (com == 2) {
            if (y > 0 && map[x][y-1].contains(".")) y--;
        } else if (com == 3) {
            if (y < width - 1 && map[x][y+1].contains(".")) y++;
        }
    }

    //        static String status = "^v<>";
//        static String skill = "UDLRS";
    static void shoot() {
        int x_ = (stat == 0) ? -1 : (stat == 1) ? 1 : 0;
        int y_ = (stat == 2) ? -1 : (stat == 3) ? 1 : 0;

        int shotX = x;
        int shotY = y;
        while (true) {
            shotX += x_;
            shotY += y_;
            if (shotX < 0 || shotX >= height || shotY < 0 || shotY >= width) break;
            if( map[shotX][shotY].contains("#")) break;
            if (map[shotX][shotY].contains("*")) {
                map[shotX][shotY] = ".";
                break;
            }
        }
    }


}
