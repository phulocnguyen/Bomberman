package main.Control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HighScore {
    private final String filename = "BombermanGame/src/res/levels/HighScore.txt";
    public List<Integer> highscore_st;

    public HighScore() throws IOException {
        highscore_st = new ArrayList<Integer>();
        this.readHighScore();
    }

    public void writeHighScore(int score) throws IOException {
        this.readHighScore();
        FileWriter fw = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < 5; i++) {
            if (highscore_st.get(i) < score) {
                highscore_st.set(i, score);
                break;
            }
        }
        String ans = "";
        for (int i = 0; i < 5; i++) {
            int x = highscore_st.get(i);
            ans += x;
            ans += "\n";
        }
        bw.write(ans);
        bw.close();
        fw.close();
    }

    public void readHighScore() throws IOException {
        String st = "";
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        int index;
        int n;
        while ((index = br.read()) != -1) {
            char x = (char) index;
            if (x != '\n') {
                st += x;
            } else {
                try {
                    n = Integer.parseInt(st);
                } catch (Exception e) {
                    n = -1;
                }
                if (n != -1) {
                    highscore_st.add(n);
                    st = "";
                }
            }
        }
        try {
            n = Integer.parseInt(st);
        } catch (Exception e) {
            n = -1;
        }
        if (n != -1) {
            highscore_st.add(n);
            st = "";
        }
        br.close();
        fr.close();
    }

    public int getHighScoreSt(int index) {
        return highscore_st.get(index);
    }
}
