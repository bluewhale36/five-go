package fivego;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		int size = 20; // �ٵ��� ���μ���(19*19)
		String[][] field = new String[size][size];
		Scanner in = new Scanner(System.in);
		Random r = new Random();
		String space = ". "; // �ٵ��� �����
		// �⺻ ������ �迭 ����
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				field[i][j] = space;
			}
		}
		for (int i = 0; i < field.length - 1; i++) {
			field[i + 1][0] = (char) ('A' + i) + " ";
		}
		for (int i = 0; i < field.length - 1; i++) {
			field[0][i + 1] = (char) ('a' + i) + " ";
		}
		field[0][0] = "  ";

		// ��º�
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				System.out.print(field[i][j]);
			}
			System.out.println();
		}
		//���� �÷��� ���� ���ϱ� + �÷��̾� ���ϱ�
		System.out.println("�浹�� ������ ����� ���ϰڽ��ϴ�.");
		System.out.println("�� ū ���� ���� ����� �浹�Դϴ�.");
		
		System.out.print("�÷��̾� 1�� �̸��� �Է����ּ���. >> ");
		String stName = in.nextLine();
		
		System.out.print("�÷��̾� 2�� �̸��� �Է����ּ���. >> ");
		String ndName = in.nextLine();
		System.out.println("");
		String blName = null ; // �浹 �÷��̾� ������ ����
		String wtName = null ; // �鵹 �÷��̾� ������ ����
		
		for (int i = 0 ; stName != "" && ndName != "" ; ) {
			if(stName != null && ndName != null) {
				int stNum = r.nextInt(10) ;
				int ndNum = r.nextInt(10) ;
				if (stNum > ndNum) {
					System.out.println(stName + " ���� ������ ���ڴ� " + stNum + "�Դϴ�.");
					System.out.println(ndName + " ���� ������ ���ڴ� " + ndNum + "�Դϴ�.");
					System.out.println("");
					System.out.println(stName + " ���� �浹�Դϴ�.");
					blName = stName ;
					wtName = ndName ;
					System.out.println("----------- ���� ���� -----------");
					break ;
				} else if (stNum < ndNum) {
					System.out.println(stName + " ���� ������ ���ڴ� " + stNum + "�Դϴ�.");
					System.out.println(ndName + " ���� ������ ���ڴ� " + ndNum + "�Դϴ�.");
					System.out.println("");
					System.out.println(ndName + " ���� �浹�Դϴ�.");
					blName = ndName ;
					wtName = stName ;
					System.out.println("");
					System.out.println("----------- ���� ���� -----------");
					break ;
				} else if (stNum == ndNum) {
					i-- ;
				}
			}
		}
				

		// ���� �÷���
		for (int i = 0;; i++) {			
			String userIn;
			String black = "�� ";
			String white = "�� ";
			char stone;

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
				System.out.println("��Ȯ�� ��ǥ�� �Է��ϼ���.");
				i--;
				continue;
			}
			if (field[rowNum][colNum] != space) { // �̹� �� ����
				System.out.println("�ش� ��ġ�� �̹� ���� �ֽ��ϴ�.");
				i--;
				continue;
			}
			field[rowNum][colNum] = stone + " ";

			// ��º�
			for (int j = 0; j < field.length; j++) {
				for (int k = 0; k < field[0].length; k++) {
					System.out.print(field[j][k]);
				}
				System.out.println();
			}
			

			// 5�� �Ǵ�
			int cnt = 0;
			boolean fiveGo = false;

			// ����
			for (int ii = 1; ii < field[0].length; ii++) {
				if (field[rowNum][ii].charAt(0) == stone) {
					cnt++;
				} else {
					cnt = 0;
				}
				if (cnt == 5) {
					fiveGo = true;
					break;
				}
			}
			cnt = 0;

			// ����
			if (fiveGo == false) {
				for (int ii = 1; ii < field.length; ii++) {
					if (field[ii][colNum].charAt(0) == stone) {
						cnt++;
					} else {
						cnt = 0;
					}
					if (cnt == 5) {
						fiveGo = true;
						break;
					}
				}
			}
			cnt = 0;

			// ������ �� -> ���� �Ʒ� �밢��
			if (fiveGo == false) {
				int kk = rowNum + colNum;
				for (int ii = 1; ii < field.length; ii++) {
					for (int jj = 1; jj < field[0].length; jj++) {
						if (ii + jj == kk) {
							if (field[ii][jj].charAt(0) == stone) {
								cnt++;
							} else {
								cnt = 0;
							}
							if (cnt == 5) {
								fiveGo = true;
								break;
							}
						}
					}
					if (cnt == 5) {
						break;
					}
				}
			}
			cnt = 0;

			// ���� �� -> ������ �Ʒ� �밢��
			if (fiveGo == false) {
				for (int ii = field[0].length - 5; ii > 0; ii--) {
					int z = ii;
					for (int jj = 1; z < field[0].length; jj++) {
						if (field[jj][z].charAt(0) == stone) {
							cnt++;
						} else {
							cnt = 0;
						}
						if (cnt == 5) {
							fiveGo = true;
							break;
						}
						z++;
					}
					if (cnt == 5) {
						break;
					}
				}
				for (int ii = 2; ii <= field.length - 5; ii++) {
					int z = ii;
					for (int jj = 1; z < field.length; jj++) {
						if (field[z][jj].charAt(0) == stone) {
							cnt++;
						} else {
							cnt = 0;
						}
						if (cnt == 5) {
							fiveGo = true;
							break;
						}
						z++;
					}
				}
			}

			// 5�� ���� �߰����� ��
			if (fiveGo == true) {
				System.out.println("�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�");
				if (i % 2 == 0) {
					System.out.println(blName + " �¸�.");
				} else {
					System.out.println(wtName + " �¸�.");
				}
				for (int ii = 0; ii < field.length; ii++) {
					for (int jj = 0; jj < field[0].length; jj++) {
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