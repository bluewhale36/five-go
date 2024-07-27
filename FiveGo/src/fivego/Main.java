package fivego;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		int size = 20; // �ٵ��� ���μ���(19*19)
		String[][] field = new String[size][size];
		Scanner in = new Scanner(System.in);
		Random r = new Random();
		String space = ". "; // �ٵ��� �����
		JOptionPane aa = new JOptionPane();
		aa.showMessageDialog(null, "���� ���� ����");
		// �⺻ ������ �迭 ����
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				field[i][j] = space;
			}
		}
		for (int i = 0; i < size - 1; i++) {
			field[i + 1][0] = (char) ('A' + i) + " ";
		}
		for (int i = 0; i < size - 1; i++) {
			field[0][i + 1] = (char) ('a' + i) + " ";
		}
		field[0][0] = "  ";

		// ��º�
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(field[i][j]);
			}
			System.out.println();
		}
		// ���� �÷��� ���� ���ϱ� + �÷��̾� ���ϱ�

		String stName = ""; // �÷��̾� 1�� �̸� �Է¹޴� ���� stName ����
		int spCnt = 0;
		for (; stName.length() == 0 || (spCnt == stName.length());) {
			spCnt = 0;
			System.out.print("�÷��̾� 1�� �̸��� �Է����ּ���. >> ");
			stName = in.nextLine();
			for (int i = 0; i < stName.length(); i++) {
				if ((int) (stName.charAt(i)) == 32) {
					spCnt++;
				}
			}
			if (stName.length() == 0) {
				System.out.println("�̸��� �ּ� 1���� �̻��̾�� �մϴ�.");
			} else if (spCnt == stName.length()) {
				System.out.println("�̸��� �������� ���� �� �� �����ϴ�.");
			}

		}

		String ndName = ""; // �÷��̾� 2�� �̸� �Է¹޴� ���� ndName ����
		// �÷��̾� �̸� �ߺ� üũ
		for (; ndName.length() == 0 || (spCnt == ndName.length()) || ndName.equals(stName);) {
			spCnt = 0;
			System.out.print("�÷��̾� 2�� �̸��� �Է����ּ���. >> ");
			ndName = in.nextLine();
			// �÷��̾� 2�� �̸��� �Է¹��� ��, �÷��̾� 1�� �̸��� �ߺ��ȴٸ�,
			for (int i = 0; i < ndName.length(); i++) {
				if ((int) (ndName.charAt(i)) == 32) {
					spCnt++;
				}
			}
			if (ndName.length() == 0) {
				System.out.println("�̸��� �ּ� 1���� �̻��̾�� �մϴ�.");
			} else if (spCnt == ndName.length()) {
				System.out.println("�̸��� �������� ���� �� �� �����ϴ�.");
			} else if (ndName.equals(stName)) {
				System.out.println("�÷��̾� 1�� �̸��� �����մϴ�. �ٽ� �Է����ּ���.");
			}
		}

		System.out.println();
		String blName/* = null */; // �浹 �÷��̾� �̸� ������ ����
		String wtName/* = null */; // �鵹 �÷��̾� �̸� ������ ����
		
		System.out.println("�浹�� ������ ����� ���ϰڽ��ϴ�.");
		System.out.println("�� ū ���� ���� ����� �浹�Դϴ�.");

		while (true) {
			int stNum = r.nextInt(10);
			int ndNum = r.nextInt(10);
			if (stNum > ndNum) {
				System.out.println(stName + " ���� ������ ���ڴ� " + stNum + "�Դϴ�.");
				System.out.println(ndName + " ���� ������ ���ڴ� " + ndNum + "�Դϴ�.");
				System.out.println("");
				System.out.println(stName + " ���� �浹�Դϴ�.");
				blName = stName;
				wtName = ndName;
				System.out.println("----------- ���� ���� -----------");
				break;
			} else if (stNum < ndNum) {
				System.out.println(stName + " ���� ������ ���ڴ� " + stNum + "�Դϴ�.");
				System.out.println(ndName + " ���� ������ ���ڴ� " + ndNum + "�Դϴ�.");
				System.out.println("");
				System.out.println(ndName + " ���� �浹�Դϴ�.");
				blName = ndName;
				wtName = stName;
				System.out.println("");
				System.out.println("----------- ���� ���� -----------");
				break;
			}
		}

		// ���� �÷���
		for (int i = 0;; i++) {
			String userIn;
			String black = "�� ";
			String white = "�� ";
			char stone;
			int target = 5;

			if (i % 2 == 0) {
				System.out.println(blName + " �� �浹�� ��ġ�� ���ϼ���. ����: Aa");
				stone = black.charAt(0);
			} else {
				System.out.println(wtName + " �� �鵹�� ��ġ�� ���ϼ���. ����: Aa");
				stone = white.charAt(0);
			}
			System.out.println(">>");

			for (userIn = in.nextLine(); userIn.length() <= 1;) {
				userIn = in.nextLine(); // ���� �ȸ����� ���� �ݺ�
			}

			int rowNum = userIn.charAt(0) - 'A' + 1;
			int colNum = userIn.charAt(1) - 'a' + 1;
			if (rowNum >= field.length || rowNum < 0 || colNum >= field[0].length || colNum < 0) { // ���� ��� �ε���
				JOptionPane.showMessageDialog(null, "��Ȯ�� ��ǥ�� �Է��ϼ���.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
				i--;
				continue;
			}
			if (field[rowNum][colNum] != space) { // �̹� �� ����
				System.out.println("�ش� ��ġ�� �̹� ���� �ֽ��ϴ�.");
				JOptionPane.showMessageDialog(null, "�ش� ��ġ�� �̹� ���� �ֽ��ϴ�.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
				i--;
				continue;
			}
			field[rowNum][colNum] = stone + " ";

			// ��º�
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					System.out.print(field[j][k]);
				}
				System.out.println();
			}

			// 5�� �Ǵ�
			int cnt = 0;
			boolean fiveGo = false;

			// ����
			for (int ii = 1; ii < size; ii++) {
				if (field[rowNum][ii].charAt(0) == stone) {
					cnt++;
					if (cnt == target && ii == size - 1) {
						fiveGo = true;
						break;
					}
				} else if (cnt == target) {
					fiveGo = true;
					break;
				} else {
					cnt = 0;
				}
			}
			cnt = 0;

			// ����
			if (fiveGo == false) {
				for (int ii = 1; ii < size; ii++) {
					if (field[ii][colNum].charAt(0) == stone) {
						cnt++;
						if (cnt == target && ii == size - 1) {
							fiveGo = true;
							break;
						}
					} else if (cnt == target) {
						fiveGo = true;
						break;
					} else {
						cnt = 0;
					}
				}
			}
			cnt = 0;

			// ������ �� -> ���� �Ʒ� �밢��
			if (fiveGo == false) {
				int kk = rowNum + colNum;
				for (int ii = 1; ii < size; ii++) {
					for (int jj = 1; jj < size; jj++) {
						if (ii + jj == kk) {
							if (field[ii][jj].charAt(0) == stone) {
								cnt++;
								if (cnt == target && (ii == size - 1 || jj == 1)) {
									fiveGo = true;
									break;
								}
							} else if (cnt == target) {
								fiveGo = true;
								break;
							} else {
								cnt = 0;
							}
						}
					}
				}
			}
			cnt = 0;

			// ���� �� -> ������ �Ʒ� �밢��
			if (fiveGo == false) {
				int z; // ���� ��
				int jj; // ���� ��
				if (rowNum > colNum) {
					jj = rowNum - colNum + 1;
					z = 1;
				} else {
					z = colNum - rowNum + 1;
					jj = 1;
				}
				if (jj <= size - target && z <= size - target) {
					for (; z < size && jj < size;) {
						if (field[jj][z].charAt(0) == stone) {
							cnt++;
							if (cnt == target && (jj == size - 1 || z == size - 1)) {
								fiveGo = true;
								break;
							}
						} else if (cnt == target) {
							fiveGo = true;
							break;
						} else {
							cnt = 0;
						}
						z++;
						jj++;
					}
				}
			}

			// 5�� ���� �߰����� ��
			if (fiveGo == true) {
				System.out.println("�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�");
				if (i % 2 == 0) {

					System.out.println(blName + " �¸�.");
					JOptionPane.showMessageDialog(null, blName + " �� �¸�!!!.", "Game Over",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					System.out.println(wtName + " �¸�.");
					JOptionPane.showMessageDialog(null, wtName + " �� �¸�!!!.", "Game Over",
							JOptionPane.INFORMATION_MESSAGE);
				}
				for (int ii = 0; ii < size; ii++) {
					for (int jj = 0; jj < size; jj++) {
						if (field[ii][jj] == space) {
							field[ii][jj] = "  ";
						}
						System.out.print(field[ii][jj]);
					}
					System.out.println();
				}
				System.out.println("�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�");
				System.out.println("������ �����մϴ�.");

				break;
			}
		}

	}
}