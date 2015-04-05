package com.gmil.at.sichyuriyy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Task1 {

	public static void main(String[] args) throws IOException {
		Scanner in  = new Scanner(System.in);
		String inputFile;
		Vector<Vector<Integer>> inputArray = new Vector<Vector<Integer>>();
		BufferedReader inputStream = null;
		System.out.println("Enter path to the input file");
		inputFile = in.next();
		in.close();
		inputStream = new BufferedReader(new FileReader(inputFile));
		PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
		String s;

		int line = 0;

		while ((s = inputStream.readLine()) != null) {

			inputArray.addElement(new Vector<Integer>());
			String[] F = s.split(" ");
			for (int i = 0; i < F.length; i++)
				inputArray.get(line).add(Integer.parseInt(F[i]));
			line++;

		}
		inputStream.close();

		shuffledArray(inputArray);

		for (int i = 0; i < inputArray.size(); i++) {
			for (int j = 0; j < inputArray.get(i).size(); j++) {
					System.out.print(inputArray.get(i).get(j) + " ");
					out.print(inputArray.get(i).get(j) + " ");
			}
			System.out.println();
			out.println();
		}
		out.close();
	}

	public static void shuffledArray(Vector<Vector<Integer>> inputArray) {
		Integer randomIndex;
		HashSet<Integer> randIndex = new HashSet<Integer>();
		Random rand = new Random();
		int[][] index = new int[inputArray.size() * inputArray.get(0).size()
				/ 4][2];
		int[] elements = new int[index.length];
		int[] shuffledElements = new int[index.length];

		for (int i = 0; i < index.length; i++) {

			do {
				randomIndex = rand.nextInt(inputArray.size()
						* inputArray.get(0).size());
			} while (randIndex.contains(randomIndex));
			randIndex.add(randomIndex);
			index[i][0] = randomIndex / inputArray.get(0).size();
			index[i][1] = randomIndex % inputArray.get(0).size();

			elements[i] = inputArray.get(index[i][0]).get(index[i][1]);

		}
		int number;
		boolean swap = false;
		for (int i = 0; i < elements.length; i++) {
			do {
				number = rand.nextInt(index.length - i);

				if (i == elements.length - 1
						&& elements[number] == inputArray.get(index[i][0]).get(
								index[i][1])) {
					randomIndex = rand.nextInt(shuffledElements.length - 1);
					shuffledElements[i] = shuffledElements[randomIndex];
					shuffledElements[randomIndex] = elements[number];
					swap = true;
					break;
				}

			} while (elements[number] == inputArray.get(index[i][0]).get(
					index[i][1]));
			if (!swap) {
				shuffledElements[i] = elements[number];
				elements[number] = elements[elements.length - 1 - i];
			}
		}

		for (int i = 0; i < index.length; i++) {
			inputArray.get(index[i][0]).set(index[i][1], shuffledElements[i]);
		}
	}
}
