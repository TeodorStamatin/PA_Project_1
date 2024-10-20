import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Word {
	String word;
	int length;
	int[] freq = new int[26];
	double[] dp = new double[26];

	public Word(String word) {
		this.word = word;
		this.length = word.length();
		for (int i = 0; i < word.length(); i++) {
			freq[word.charAt(i) - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			dp[i] = (double) freq[i] / length;
		}
	}
}

public class Criptat {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new File("criptat.in"));
			PrintWriter writer = new PrintWriter(new File("criptat.out"))) {

			int N = sc.nextInt();
			ArrayList<Word> words = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				words.add(new Word(sc.next()));
			}

			int maxLen = -1;
			int currentLen;
			double currentDp;

			for (int i = 0; i < 26; i++) {
				currentLen = 0;
				currentDp = 0;

				int idx = i;
				words.sort(Comparator.comparingDouble((Word w) -> w.dp[idx]).reversed());

				for (Word word : words) {
					if ((currentDp + (double) word.freq[i]) / (currentLen
							+ word.length) > 0.5) {
						currentDp += word.freq[i];
						currentLen += word.length;
					}
				}

				if (currentLen > maxLen) {
					maxLen = currentLen;
				}
			}

			writer.println(maxLen);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}