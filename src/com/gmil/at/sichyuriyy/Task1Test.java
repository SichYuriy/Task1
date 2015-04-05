package com.gmil.at.sichyuriyy;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

public class Task1Test {

	@Test
	public void test() {
		for (int l = 0; l < 100; l++) {
			boolean test = true;
			int difference = 0;
			Vector<Vector<Integer>> inputArray = new Vector<Vector<Integer>>();
			for (int i = 0; i < 10; i++) {
				inputArray.add(new Vector<Integer>());
				for (int j = 0; j < 10; j++)
					inputArray.get(i).add(i * 10 + j + 1);
			}
			Vector<Vector<Integer>> result = new Vector<Vector<Integer>>();
			for (int i = 0; i < inputArray.size(); i++) {
				result.add(new Vector<Integer>());
				for (int j = 0; j < inputArray.get(i).size(); j++)
					result.get(i).add(inputArray.get(i).get(j));
			}
			Task1.shuffledArray(result);
			for (int i = 0; i < inputArray.size(); i++)
				for (int j = 0; j < inputArray.get(i).size(); j++)
					if (inputArray.get(i).get(j) != result.get(i).get(j))
						difference++;

			if (difference != inputArray.size() * inputArray.get(0).size() / 4)
				test = false;
			assertTrue(test);
		}
	}

}
