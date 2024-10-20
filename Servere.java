import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Servere {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new File("servere.in"));
			PrintWriter writer = new PrintWriter(new File("servere.out"))) {

			int n = sc.nextInt();

			int[] P = new int[n];
			for (int i = 0; i < n; i++) {
				P[i] = sc.nextInt();
			}

			double maxC = Integer.MIN_VALUE;
			double minC = Integer.MAX_VALUE;
			int[] C = new int[n];
			for (int i = 0; i < n; i++) {
				C[i] = sc.nextInt();
				maxC = Math.max(maxC, C[i]);
				minC = Math.min(minC, C[i]);
			}

			double left = minC;
			double right = maxC;
			double maxPower = Double.NEGATIVE_INFINITY;
			while (left + 0.05 < right) {

				double mid = (left + right) / 2;
				double minPower = Double.MAX_VALUE;
				double power = 0;

				for (int i = 0; i < n; i++) {
					power = P[i] - Math.abs(mid - C[i]);
					minPower = Math.min(minPower, power);
				}

				if (minPower > maxPower) {
					maxPower = minPower;
				}

				double tempC = mid - 0.05;
				double tempPower = 0;
				double tempMinPower = Double.MAX_VALUE;

				for (int i = 0; i < n; i++) {
					tempPower = P[i] - Math.abs(tempC - C[i]);
					tempMinPower = Math.min(tempMinPower, tempPower);
				}

				if (tempMinPower > minPower) {
					right = mid;
				} else {
					left = mid;
				}
			}

			writer.printf("%.1f", maxPower);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}