package fivego;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		int size = 20; // 바둑판 가로세로(19*19)
		String[][] field = new String[size][size];
		Scanner in = new Scanner(System.in);
		Random r = new Random();
		String space = ". "; // 바둑판 빈공간
		// 기본 오목판 배열 생성
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

		// 출력부
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				System.out.print(field[i][j]);
			}
			System.out.println();
		}
		//게임 플레이 선공 정하기 + 플레이어 정하기
		System.out.println("흑돌로 시작할 사람을 정하겠습니다.");
		System.out.println("더 큰 수를 뽑은 사람이 흑돌입니다.");
		
		System.out.print("플레이어 1의 이름을 입력해주세요. >> ");
		String stName = in.nextLine();
		
		System.out.print("플레이어 2의 이름을 입력해주세요. >> ");
		String ndName = in.nextLine();
		System.out.println("");
		String blName = null ; // 흑돌 플레이어 저장할 변수
		String wtName = null ; // 백돌 플레이어 저장할 변수
		
		for (int i = 0 ; stName != "" && ndName != "" ; ) {
			if(stName != null && ndName != null) {
				int stNum = r.nextInt(10) ;
				int ndNum = r.nextInt(10) ;
				if (stNum > ndNum) {
					System.out.println(stName + " 님이 뽑으신 숫자는 " + stNum + "입니다.");
					System.out.println(ndName + " 님이 뽑으신 숫자는 " + ndNum + "입니다.");
					System.out.println("");
					System.out.println(stName + " 님이 흑돌입니다.");
					blName = stName ;
					wtName = ndName ;
					System.out.println("----------- 게임 시작 -----------");
					break ;
				} else if (stNum < ndNum) {
					System.out.println(stName + " 님이 뽑으신 숫자는 " + stNum + "입니다.");
					System.out.println(ndName + " 님이 뽑으신 숫자는 " + ndNum + "입니다.");
					System.out.println("");
					System.out.println(ndName + " 님이 흑돌입니다.");
					blName = ndName ;
					wtName = stName ;
					System.out.println("");
					System.out.println("----------- 게임 시작 -----------");
					break ;
				} else if (stNum == ndNum) {
					i-- ;
				}
			}
		}
				

		// 게임 플레이
		for (int i = 0;; i++) {			
			String userIn;
			String black = "● ";
			String white = "○ ";
			char stone;

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
				System.out.println("정확한 좌표를 입력하세요.");
				i--;
				continue;
			}
			if (field[rowNum][colNum] != space) { // 이미 돌 있음
				System.out.println("해당 위치에 이미 돌이 있습니다.");
				i--;
				continue;
			}
			field[rowNum][colNum] = stone + " ";

			// 출력부
			for (int j = 0; j < field.length; j++) {
				for (int k = 0; k < field[0].length; k++) {
					System.out.print(field[j][k]);
				}
				System.out.println();
			}
			

			// 5개 판단
			int cnt = 0;
			boolean fiveGo = false;

			// 가로
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

			// 세로
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

			// 오른쪽 위 -> 왼쪽 아래 대각선
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

			// 왼쪽 위 -> 오른쪽 아래 대각선
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

			// 5개 연속 발견했을 때
			if (fiveGo == true) {
				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
				if (i % 2 == 0) {
					System.out.println(blName + " 승리.");
				} else {
					System.out.println(wtName + " 승리.");
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
				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
				System.out.println("게임을 종료합니다.");
				
				break;
			}
		}

	}
}