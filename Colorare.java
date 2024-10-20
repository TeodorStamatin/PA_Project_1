import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Colorare {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new File("colorare.in"));
			PrintWriter writer = new PrintWriter(new File("colorare.out"))) {

			long Mod = (long) (Math.pow(10, 9) + 7);

			long n = sc.nextInt();
			int prevPoz = 0;
			int currPoz = 0;
			long value = 0;
			long result = 1;
			boolean first = true;
			for (int i = 0; i < n; i++) {
				value = sc.nextInt();
				prevPoz = currPoz;
				currPoz = (sc.next().equals("V")) ? 1 : 0;
				if (first) {
					switch (currPoz) {
						case 0:
							result *= 6;
							break;
						case 1:
							result *= 3;
							break;
						default:
							break;
					}
					value--;
					first = !first;
					prevPoz = currPoz;
				}
				while (value > 0) {
					if (currPoz == prevPoz) {
						long temp;
						long base;
						switch (currPoz) {
							case 0:
								temp = 1;
								base = 3;
								while (value > 0) {
									if (value % 2 == 1) {
										temp = (temp * base) % Mod;
									}
									base = (base * base) % Mod;
									value /= 2;
								}
								result = (result * temp) % Mod;
								break;
							case 1:
								temp = 1;
								base = 2;
								while (value > 0) {
									if (value % 2 == 1) {
										temp = (temp * base) % Mod;
									}
									base = (base * base) % Mod;
									value /= 2;
								}
								result = (result * temp) % Mod;
								break;
							default:
								break;
						}
					} else {
						switch (currPoz) {
							case 0:
								result = (result * 2) % Mod;
								break;
							case 1:
								result %= Mod;
								break;
							default:
								break;
						}
						prevPoz = currPoz;
						value--;
					}
				}
			}

			writer.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
