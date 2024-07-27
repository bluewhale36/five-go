package fivego;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		int size = 20; // 바둑판 가로세로(19*19)
		String[][] field = new String[size][size];
		Scanner in = new Scanner(System.in);
		Random r = new Random();
		String space = ". "; // 바둑판 빈공간
		JOptionPane aa = new JOptionPane();
		aa.showMessageDialog(null, "오목 게임 시작");
		// 기본 오목판 배열 생성
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

		// 출력부
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(field[i][j]);
			}
			System.out.println();
		}
		// 게임 플레이 선공 정하기 + 플레이어 정하기

		String stName = ""; // 플레이어 1의 이름 입력받는 변수 stName 선언
		int spCnt = 0;
		for (; stName.length() == 0 || (spCnt == stName.length());) {
			spCnt = 0;
			System.out.print("플레이어 1의 이름을 입력해주세요. >> ");
			stName = in.nextLine();
			for (int i = 0; i < stName.length(); i++) {
				if ((int) (stName.charAt(i)) == 32) {
					spCnt++;
				}
			}
			if (stName.length() == 0) {
				System.out.println("이름은 최소 1글자 이상이어야 합니다.");
			} else if (spCnt == stName.length()) {
				System.out.println("이름을 공백으로 설정 할 수 없습니다.");
			}

		}

		String ndName = ""; // 플레이어 2의 이름 입력받는 변수 ndName 선언
		// 플레이어 이름 중복 체크
		for (; ndName.length() == 0 || (spCnt == ndName.length()) || ndName.equals(stName);) {
			spCnt = 0;
			System.out.print("플레이어 2의 이름을 입력해주세요. >> ");
			ndName = in.nextLine();
			// 플레이어 2의 이름을 입력받은 뒤, 플레이어 1의 이름과 중복된다면,
			for (int i = 0; i < ndName.length(); i++) {
				if ((int) (ndName.charAt(i)) == 32) {
					spCnt++;
				}
			}
			if (ndName.length() == 0) {
				System.out.println("이름은 최소 1글자 이상이어야 합니다.");
			} else if (spCnt == ndName.length()) {
				System.out.println("이름을 공백으로 설정 할 수 없습니다.");
			} else if (ndName.equals(stName)) {
				System.out.println("플레이어 1과 이름이 동일합니다. 다시 입력해주세요.");
			}
		}

		System.out.println();
		String blName/* = null */; // 흑돌 플레이어 이름 저장할 변수
		String wtName/* = null */; // 백돌 플레이어 이름 저장할 변수
		
		System.out.println("흑돌로 시작할 사람을 정하겠습니다.");
		System.out.println("더 큰 수를 뽑은 사람이 흑돌입니다.");

		while (true) {
			int stNum = r.nextInt(10);
			int ndNum = r.nextInt(10);
			if (stNum > ndNum) {
				System.out.println(stName + " 님이 뽑으신 숫자는 " + stNum + "입니다.");
				System.out.println(ndName + " 님이 뽑으신 숫자는 " + ndNum + "입니다.");
				System.out.println("");
				System.out.println(stName + " 님이 흑돌입니다.");
				blName = stName;
				wtName = ndName;
				System.out.println("----------- 게임 시작 -----------");
				break;
			} else if (stNum < ndNum) {
				System.out.println(stName + " 님이 뽑으신 숫자는 " + stNum + "입니다.");
				System.out.println(ndName + " 님이 뽑으신 숫자는 " + ndNum + "입니다.");
				System.out.println("");
				System.out.println(ndName + " 님이 흑돌입니다.");
				blName = ndName;
				wtName = stName;
				System.out.println("");
				System.out.println("----------- 게임 시작 -----------");
				break;
			}
		}

		// 게임 플레이
		for (int i = 0;; i++) {
			String userIn;
			String black = "● ";
			String white = "○ ";
			char stone;
			int target = 5;

			if (i % 2 == 0) {
				System.out.println(blName + " 님 흑돌의 위치를 정하세요. 예시: Aa");
				stone = black.charAt(0);
			} else {
				System.out.println(wtName + " 님 백돌의 위치를 정하세요. 예시: Aa");
				stone = white.charAt(0);
			}
			System.out.println(">>");

			for (userIn = in.nextLine(); userIn.length() <= 1;) {
				userIn = in.nextLine(); // 길이 안맞으면 무한 반복
			}

			int rowNum = userIn.charAt(0) - 'A' + 1;
			int colNum = userIn.charAt(1) - 'a' + 1;
			if (rowNum >= field.length || rowNum < 0 || colNum >= field[0].length || colNum < 0) { // 범위 벗어난 인덱스
				JOptionPane.showMessageDialog(null, "정확한 좌표를 입력하세요.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
				i--;
				continue;
			}
			if (field[rowNum][colNum] != space) { // 이미 돌 있음
				System.out.println("해당 위치에 이미 돌이 있습니다.");
				JOptionPane.showMessageDialog(null, "해당 위치에 이미 돌이 있습니다.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
				i--;
				continue;
			}
			field[rowNum][colNum] = stone + " ";

			// 출력부
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					System.out.print(field[j][k]);
				}
				System.out.println();
			}

			// 5개 판단
			int cnt = 0;
			boolean fiveGo = false;

			// 가로
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

			// 세로
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

			// 오른쪽 위 -> 왼쪽 아래 대각선
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

			// 왼쪽 위 -> 오른쪽 아래 대각선
			if (fiveGo == false) {
				int z; // 시작 열
				int jj; // 시작 행
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

			// 5개 연속 발견했을 때
			if (fiveGo == true) {
				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
				if (i % 2 == 0) {

					System.out.println(blName + " 승리.");
					JOptionPane.showMessageDialog(null, blName + " 님 승리!!!.", "Game Over",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					System.out.println(wtName + " 승리.");
					JOptionPane.showMessageDialog(null, wtName + " 님 승리!!!.", "Game Over",
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
				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
				System.out.println("게임을 종료합니다.");

				break;
			}
		}

	}
}