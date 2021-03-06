package jdk.java.util;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JDK8 List api 테스트 유닛
 * 
 * @since 2018-12-28
 * @author fixalot
 */
public class ListTest {
	private static final Logger logger = LoggerFactory.getLogger(ListTest.class);

	/**
	 * 리스트의 "d"를 찾아 "b"앞에 끼워넣기
	 * 
	 * @author fixalot
	 */
	@Test
	public void moveElement1() {
		ArrayList<String> list = getAList();
		Assert.assertEquals("[a, b, c, d, f]", (String.valueOf(list)));
		
//		Collections.rotate(list, 2); // 이거 아님
//		Assert.assertEquals("[d, f, a, b, c]", (String.valueOf(list)));
		
		list = move1(list, 3, 1);
		Assert.assertEquals("[a, d, b, c, f]", String.valueOf(list));
		
		list = getAList();
		list = move2(list, 3, 1);
		Assert.assertEquals("[a, d, b, c, f]", String.valueOf(list));
	}
	
	private ArrayList<String> getAList() {
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "f"));
		return list;
	}
	
	private ArrayList<String> move1(ArrayList<String> list, int target, int dest) {
		logger.debug("{}", list);
		// 일단 찾고
		int index = list.indexOf("d");
		Assert.assertEquals(target, index);
		
		String element = list.get(target);
		list.remove(target);
		logger.debug("{}", list);
		list.add(dest, element);
		
		return list;
	}
	
	/**
	 * indexOf 생략하는 방식
	 * 
	 * @param list
	 * @param target
	 * @param dest
	 * @return
	 * @author fixalot
	 */
	private ArrayList<String> move2(ArrayList<String> list, int target, int dest) {
		logger.debug("{}", list);

		String element = list.get(target);
		list.remove(element);
		logger.debug("{}", list);
		list.add(dest, element);
		
		return list;
	}
}
