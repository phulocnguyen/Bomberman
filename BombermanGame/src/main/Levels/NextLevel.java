// package main.Levels;

// import javafx.scene.image.Image;

// import static main.BombermanGame.*;

// public class NextLevel {
//     public static boolean wait;
//     public static long waitingTime;

//     public static void waitToLevelUp() {
//         if (wait) {
//             Image waitToNext = new Image("images/levelUp.png");
//             authorView.setImage(waitToNext);
//             authorView.setX(-658);
//             authorView.setY(-358);
//             authorView.setScaleX(0.3849);
//             authorView.setScaleY(0.3849);
//             long now = System.currentTimeMillis();
//             if (now - waitingTime > 4000) {
//                 if (_level > 0)
//                     my_score += 10000;
//                 new nowLevel(_level + 1);
//                 wait = false;
//             }
//         }
//     }
// }