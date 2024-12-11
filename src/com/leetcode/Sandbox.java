package com.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;

public class Sandbox {

  public static void main(String[] args) {

    //task1
    //    String word1 = "abcd", word2 = "pq";
    //    String answer = mergeAlternately(word1, word2);
    //    System.out.println(answer);

    //task3
    //    int[] flowerbed = { 0};
    //    int n = 2;
    //    System.out.println(canPlaceFlowers(flowerbed, n));

    //task 4
    //    System.out.println(reverseVowels("leetcode"));

    //task 5
    //    System.out.println(reverseWords(" Aaa Sss Ffff Ggggg    Hhh  Jjjjj "));
    //    System.out.println(reverseWords("Aaa     Sss Ffff Ggggg    Hhh"));

    //task6
    //    int[] x = { 2,3,4,2 };
    //    System.out.println(Arrays.toString(productExceptSelf(x)));

    //task8
    //    char[] chars = {'o', 'a', 'a','l', 'b', 'b', 'c', 'c', 'c'};
    //    System.out.println(compress(chars));

    //task9
    //    int[] x = { 0, 1, 34, 56, 0, 45, 22, 3, 0, 0, 44, 0 };
    //    System.out.println(Arrays.toString(moveZeroes(x)));

    //task10
    //    System.out.println(isSubsequence("b", "abc"));

    //task 11
    //    int[] x = { 1, 5, 6, 4, 9, 3 };
    //    System.out.println(maxArea(x));

    //task12
    //    int[] x = {3,1,5,1,1,1,1,1,2,2,3,2,2};
    //    System.out.println(maxOperations(x, 1));

    //task13
    //    int[] x = {3,1,5,1,1,1,1,1,2,2,3,2,20};
    //    System.out.println(findMaxAverage(x, 2));

    //task14
    //    System.out.println(maxVowels("svanbdms", 3));

    //task15
    //    System.out.println(longestOnes(
    //        new int[] { 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, 3));

    //task16
    //    System.out.println(longestSubarray(new int[] { 0, 1, 1, 1, 0, 1, 1, 0, 1 }));

    //task17
    //    System.out.println(highestAltitude(new int[] { -2, 55, -60, 10 }));

    //task18
    //    System.out.println(pivotIndex(new int[] {2,1,-1}));
    //task19
    //    System.out.println(findDifference(new int[] { 1, 2, 3, 3 }, new int[] { 1, 1, 2, 2 }));

    //task20
    //    System.out.println(uniqueOccurrences(new int[] { -3,0,1,-3,1,1,1,-3,10,0}));

    //task21
    //    System.out.println(closeStrings("cabbba", "abbccc"));

    //task22
    //    System.out.println(equalPairs(new int[][] {
    //        { 3, 1, 2, 2 },
    //        { 1, 4, 4, 5 },
    //        { 2, 4, 2, 2 },
    //        { 2, 4, 2, 2 }
    //    }));

    //task 23
    //    System.out.println(removeStars("erase*****"));

    //task24
    //    System.out.println(
    //        Arrays.toString(asteroidCollision(new int[] { 5,-5})));

    //task25
    //    System.out.println(maxDepth(new TreeNode(3,
    //        new TreeNode(9,
    //            new TreeNode(15, null, null), new TreeNode(7, null, null)),
    //
    //                                                                      new TreeNode(20,
    //                                    new TreeNode(15, null, null), new TreeNode(7, null, null)))));

    //task 26
    //    System.out.println(predictPartyVictory("RDRD"));

    //task 27
    //    System.out.println(lemonadeChange(
    //        new int[] { 5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5 }));

    //task 28
//    System.out.println(canJump(new int[] { 3,2,1,0,4 }));

    //task29
//    System.out.println(decodeString("3[abc2[def]]2[k]"));

    //task30
//    System.out.println(romanToInt("III"));

    //tsak31
    ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
    ListNode l1 = new ListNode(9, new ListNode(9));

    ListNode numbers = addTwoNumbers(l1, l2);
    System.out.println(numbers);

  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode();
    sumUp(l1, l2, result, false);
    return result;
  }

  public static void sumUp(ListNode l1, ListNode l2, ListNode result, boolean hasExtra) {
    result.val = l1.val + l2.val;
    if (hasExtra) {
      result.val++;
    }
    if (result.val >= 10) {
      result.val %= 10;
      hasExtra = true;
    } else {
      hasExtra = false;
    }
    if (Objects.nonNull(l1.next) || Objects.nonNull(l2.next)) {

      ListNode next1 = Optional.ofNullable(l1.next).orElse(new ListNode(0));
      ListNode next2 = Optional.ofNullable(l2.next).orElse(new ListNode(0));
      result.next = new ListNode();
      sumUp(next1, next2, result.next, hasExtra);
    } else if (Objects.isNull(l1.next) && Objects.isNull(l2.next) && hasExtra == true) {
      result.next = new ListNode(1);
    }
  }


    public static int romanToInt(String s) {
    ArrayList<Integer> number = new ArrayList<>();
    for (char ch : s.toCharArray()) {
      number.add(convert(ch));
    }

    ListIterator<Integer> iterator = number.listIterator();
    int result = 0;
    Integer current = iterator.next();
    while (iterator.hasNext()) {
      Integer next = iterator.next();
      if (next > current) {
        result -= current;
      } else {
        result += current;
      }
      current = next;
    }

    return result + current;
  }

  private static Integer convert(Character ch) {
    return switch (ch) {
      case 'I' -> 1;
      case 'V' -> 5;
      case 'X' -> 10;
      case 'L' -> 50;
      case 'C' -> 100;
      case 'D' -> 500;
      case 'M' -> 1000;
      default -> 0;
    };
  }

  public static String decodeString(String s) {
    Deque<Integer> repetitionNumbers = new ArrayDeque<>();
    Deque<StringBuilder> substrings = new ArrayDeque<>();
    StringBuilder stringBuilder = new StringBuilder();
    int repNum = 0;

    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        repNum = repNum * 10 + Integer.valueOf(String.valueOf(c));
      } else if (c == '[') {
        repetitionNumbers.push(repNum);
        repNum = 0;
        substrings.push(stringBuilder);
        stringBuilder = new StringBuilder();
      } else if (c == ']') {
        int k = repetitionNumbers.pop();
        StringBuilder temp = stringBuilder;
        stringBuilder = substrings.pop();
        while (k-- > 0) {
          stringBuilder.append(temp);
        }
      } else if (Character.isAlphabetic(c)){
        stringBuilder.append(c);
      }
    }

    return stringBuilder.toString();

  }

  public static boolean canJump(int[] nums) {

    int target = nums.length - 1;
    int i = target - 1;
    while (i >= 0) {
      if (i + nums[i] >= target) {
        target = i;
      }
      i--;
    }

    return target <= 0;
  }

  public static boolean lemonadeChange(int[] bills) {
    int change5 = 0;
    int change10 = 0;
    for (int bill : bills) {
      switch (bill) {
        case 5 -> change5++;
        case 10 -> {
          change5--;
          change10++;
          if (change5 < 0) {
            return false;
          }
        }
        case 20 -> {
          if (change10 > 0) {
            change10--;
            change5--;
          } else {
            change5 -= 3;
          }
          if (change5 < 0 || change10 < 0) {
            return false;
          }
        }
      }
    }
    return true;
  }

  public static String predictPartyVictory(String senate) {

    Queue<Character> senateQueue = new LinkedList<>();
    senate.chars().mapToObj(i -> (char) i).forEach(senateQueue::add);

    if (Objects.equals(senateQueue.size(), 1)) {
      return getFullName(senateQueue.peek());
    }

    while (senateQueue.size() > 1) {
      Character current = senateQueue.poll();
      Character rival = getRival(current);
      if (!blockVote(rival, senateQueue)) {
        return getFullName(current);
      }
      senateQueue.add(current);
    }
    return getFullName(senateQueue.peek());
  }

  private static Character getRival(Character current) {
    return current.equals('R') ? 'D' : 'R';
  }

  private static boolean blockVote(Character rivalToRemove, Queue<Character> senateQueue) {
    return senateQueue.remove(rivalToRemove);
  }

  private static String getFullName(Character current) {
    return current.equals('R') ? "Radiant" : "Dire";
  }

  public static int longestSubarray(int[] nums) {

    int pointerRight = 0;
    int maxLen = 0;
    boolean hasO = false;
    int pointerLeft = 0;
    int pointerAtO = 0;

    while (pointerRight < nums.length) {
      if (nums[pointerRight] == 0) {
        if (hasO) {
          pointerLeft = pointerAtO + 1;
          pointerAtO = pointerRight;
        } else {
          hasO = true;
          pointerAtO = pointerRight;
        }
      }
      maxLen = Math.max(maxLen, pointerRight - pointerLeft);
      pointerRight++;

    }
    return maxLen;

  }

  public static int longestOnes(int[] nums, int k) {
    int pointerLeft = 0;
    int pointerRight = 0;
    int currentNumOfOs = 0;
    int maxLen = 0;

    while (pointerRight < nums.length) {
      if (nums[pointerRight] == 1) {
        pointerRight++;
      } else {
        if (currentNumOfOs < k) {
          currentNumOfOs++;
          pointerRight++;
        } else {
          while (nums[pointerLeft] == 1) {
            pointerLeft++;
          }
          pointerLeft++;
          currentNumOfOs--;
        }
      }
      maxLen = Math.max(maxLen, pointerRight - pointerLeft);
    }
    return maxLen;
  }

  public static int maxVowels(String s, int k) {
    int maxVowelAmount = 0;
    for (int i = 0; i < k; ++i) {
      if (isVowel(s.charAt(i))) {
        maxVowelAmount++;
      }
    }

    if (s.length() == k) {
      return maxVowelAmount;
    }

    int currentVovelAmount = maxVowelAmount;
    int pointer = k;

    while (pointer < s.length()) {
      if (isVowel(s.charAt(pointer))) {
        currentVovelAmount++;
      }

      if (isVowel(s.charAt(pointer - k))) {
        currentVovelAmount--;
      }

      maxVowelAmount = Math.max(maxVowelAmount, currentVovelAmount);
      pointer++;
    }
    return maxVowelAmount;
  }

  public static double findMaxAverage(int[] nums, int k) {
    int len = nums.length;
    if (len == k) {
      return (double) Arrays.stream(nums).sum() / len;
    }
    int maxSum = 0;

    for (int i = 0; i < k; ++i) {
      maxSum += nums[i];
    }
    int newSum = maxSum;
    int pointer = k;

    while (pointer < len) {
      newSum -= nums[pointer - (k)];
      newSum += nums[pointer];

      maxSum = Math.max(newSum, maxSum);
      pointer++;
    }
    return (double) maxSum / k;

  }

  public static int maxOperations(int[] nums, int k) {
    Arrays.sort(nums);
    int i = 0;
    int j = nums.length - 1;
    int counter = 0;

    while (i < j) {
      if (nums[j] >= k) {
        j--;
        continue;
      } else if (nums[i] >= k) {
        break;
      }

      int sum = nums[i] + nums[j];
      if (sum == k) {
        counter++;
        i++;
        j--;
      } else if (sum > k) {
        j--;
      } else {
        i++;
      }
    }
    return counter;
  }

  public static int maxArea(int[] height) {

    if (height.length == 0 || height.length == 1) {
      return 0;
    }
    int maxVolume = 0;
    int i = 0;
    int j = height.length - 1;

    while (i < j) {
      int currentVolume = volume(i, height[i], j, height[j]);
      if (currentVolume > maxVolume) {
        maxVolume = currentVolume;
      }

      if (height[i] < height[j]) {
        ++i;
      } else {
        --j;
      }
    }
    return maxVolume;
  }

  private static int volume(int i, int valI, int j, int valJ) {
    int len = Math.abs(j - i);
    return valI < valJ ? len * valI : len * valJ;
  }

  public static boolean isSubsequence(String s, String t) {
    if (s.isEmpty()) {
      return true;
    }

    if (s.length() > t.length() || t.isEmpty()) {
      return false;
    }

    int pointerS = 0;
    for (int i = 0; i < t.length(); ++i) {
      if (pointerS == s.length()) {
        return true;
      }
      if (t.charAt(i) == s.charAt(pointerS)) {
        pointerS++;
      }
    }
    return pointerS == s.length();
  }

  public static int[] moveZeroes(int[] nums) {
    int idx = 0;
    for (int num : nums) {
      if (num != 0) {
        nums[idx++] = num;
      }
    }
    while (idx < nums.length) {
      nums[idx++] = 0;
    }
    return nums;

  }

  public static int compress(char[] chars) {

    if (chars.length == 1) {
      return 1;
    }

    StringBuilder str = new StringBuilder();
    int counter = 1;

    for (int i = 1; i < chars.length; ++i) {
      if (chars[i - 1] == chars[i]) {
        counter++;
      } else {
        str.append(chars[i - 1]);
        if (counter != 1) {
          str.append(counter);
        }
        counter = 1;
      }
    }

    str.append(chars[chars.length - 1]);
    if (counter != 1) {
      str.append(counter);
    }

    char[] newChars = str.toString().toCharArray();
    for (int i = 0; i < newChars.length; ++i) {
      chars[i] = newChars[i];
    }

    return newChars.length;
  }

  public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    int biggestBunchOfCandies = 0;
    List<Boolean> result = new ArrayList<>();

    for (int i = 0; i < candies.length; i++) {
      if (candies[i] > biggestBunchOfCandies) {
        biggestBunchOfCandies = candies[i];
      }
      candies[i] = candies[i] + extraCandies;
    }

    for (int candyBunch : candies) {
      boolean resValue = biggestBunchOfCandies <= candyBunch;
      result.add(resValue);
    }
    return result;
  }

  public static String mergeAlternately(String word1, String word2) {
    char[] word01 = word1.toCharArray();
    char[] word02 = word2.toCharArray();
    char[] result = new char[word01.length + word02.length];

    int i = 0;
    int j = 0;
    int k = 0;

    while (k < result.length) {
      if (i < word01.length) {
        result[k] = word01[i];
        k++;
        i++;
      }
      if (j < word02.length) {
        result[k] = word02[j];
        k++;
        j++;
      }
    }

    return String.valueOf(result);
  }

  public static boolean canPlaceFlowers(int[] flowerbed, int n) {//[000000] [101010] [0] [00]
    int amountFlowersAbleToBePlanted = 0;

    int length = flowerbed.length;
    int newLength = length + 2;
    int[] extendedFlowerbed = new int[newLength];

    for (int i = 0; i < length; ++i) {
      extendedFlowerbed[i + 1] = flowerbed[i];
    }

    for (int i = 1; i < newLength - 1; ++i) {
      if (extendedFlowerbed[i - 1] == 0 && extendedFlowerbed[i] == 0 &&
          extendedFlowerbed[i + 1] == 0) {
        extendedFlowerbed[i] = 1;
        amountFlowersAbleToBePlanted++;
      }
    }

    return amountFlowersAbleToBePlanted >= n;
  }

  public static String reverseVowels(String s) {
    StringBuilder newWord = new StringBuilder();
    StringBuilder vowelsFromWord = new StringBuilder();

    //collect vowels in reverse order
    for (int i = s.length() - 1; i >= 0; --i) {
      char currentLetter = s.charAt(i);
      if (isVowel(currentLetter)) {
        vowelsFromWord.append(currentLetter);
      }
    }

    int k = 0;
    for (int i = 0; i < s.length(); ++i) {
      char currentLetter = s.charAt(i);
      if (isVowel(currentLetter)) {
        newWord.append(vowelsFromWord.charAt(k));
        ++k;
      } else {
        newWord.append(s.charAt(i));
      }
    }
    return newWord.toString();

  }

  public static boolean isVowel(char letter) {
    char[] vowels = { 'e', 'E', 'a', 'A', 'i', 'I', 'o', 'O', 'u', 'U' };
    for (char vowel : vowels) {
      if (letter == vowel) {
        return true;
      }
    }
    return false;
  }

  public static String reverseWords(String s) {

    StringBuilder newString = new StringBuilder();
    Deque<String> words = new ArrayDeque<>();
    s = s.strip();

    for (int i = 0; i < s.length(); ++i) {
      char currentChar = s.charAt(i);
      if (currentChar != ' ') {
        newString.append(currentChar);
      } else {
        if (!newString.isEmpty()) {
          words.addFirst(newString.toString());
          newString = new StringBuilder();
        }
      }
    }
    words.addFirst(newString.toString());
    newString = new StringBuilder();

    for (String word : words) {
      newString.append(word);
      newString.append(' ');
    }

    return newString.toString().strip();
  }

  public static int[] productExceptSelf(int[] nums) {

    int length = nums.length;
    int[] newArray = new int[length];

    int[] prefix = new int[length];
    prefix[0] = 1;

    int[] postfix = new int[length];
    postfix[length - 1] = 1;

    for (int i = 1; i < length; ++i) {
      prefix[i] = prefix[i - 1] * nums[i - 1];
    }

    for (int i = length - 2; i >= 0; --i) {
      postfix[i] = postfix[i + 1] * nums[i + 1];
    }

    for (int i = 0; i < length; ++i) {
      newArray[i] = prefix[i] * postfix[i];
    }

    return newArray;
  }

  public static int highestAltitude(int[] gain) {
    int max = 0;
    int currentHigh = 0;
    for (int point : gain) {
      currentHigh += point;
      if (currentHigh > max) {
        max = currentHigh;
      }
    }

    return max;
  }

  public static int pivotIndex(int[] nums) {
    int maxSum = 0;
    for (int num : nums) {
      maxSum += num;
    }

    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      if (sum == maxSum - sum - nums[i]) {
        return i;
      }
      sum += nums[i];
    }
    return -1;
  }

  public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

    nums1 = Arrays.stream(nums1).distinct().toArray();
    nums2 = Arrays.stream(nums2).distinct().toArray();

    ArrayList<Integer> list1 = new ArrayList<>();
    for (int num : nums1) {
      list1.add(num);
    }
    List<Integer> list1Immutable = Arrays.stream(nums1).boxed().toList();

    ArrayList<Integer> list2 = new ArrayList<>();
    for (int num : nums2) {
      list2.add(num);
    }

    list1.removeAll(list2);
    list2.removeAll(list1Immutable);

    return List.of(list1, list2);
  }

  public static boolean uniqueOccurrences(int[] arr) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int key : arr) {
      if (map.containsKey(key)) {
        map.put(key, map.get(key) + 1);
      } else {
        map.put(key, 1);
      }
    }

    HashSet<Integer> set = new HashSet<>(map.values());

    return set.size() == map.size();
  }

  public static boolean closeStrings(String word1, String word2) {
    if (word1.length() != word2.length()) {
      return false;
    }

    HashMap<Character, Integer> map1 = getMapOfLettersFrequence(word1);
    HashMap<Character, Integer> map2 = getMapOfLettersFrequence(word2);

    List<Integer> list1 = new ArrayList<>(map1.values());
    list1.sort(Comparator.naturalOrder());

    List<Integer> list2 = new ArrayList<>(map2.values());
    list2.sort(Comparator.naturalOrder());

    return map1.keySet().containsAll(map2.keySet()) && list1.equals(list2);
  }

  private static HashMap<Character, Integer> getMapOfLettersFrequence(String word) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (char key : word.toCharArray()) {
      if (map.containsKey(key)) {
        map.put(key, map.get(key) + 1);
      } else {
        map.put(key, 1);
      }
    }
    return map;
  }

  public static int equalPairs(int[][] grid) {
    int length = grid.length;

    List<List<Integer>> rows = new ArrayList<>();
    List<List<Integer>> columns = new ArrayList<>();

    for (int i = 0; i < length; ++i) {
      rows.add(new ArrayList<>());
      columns.add(new ArrayList<>());
    }
    for (int i = 0; i < length; ++i) {
      for (int j = 0; j < length; ++j) {
        rows.get(i).add(grid[i][j]);
        columns.get(j).add(grid[i][j]);
      }
    }

    int counter = 0;
    for (int i = 0; i < length; ++i) {
      for (int j = 0; j < length; ++j) {
        if (columns.get(i).equals(rows.get(j))) {
          counter++;
        }
      }
    }

    return counter;
  }

  public static String removeStars(String s) {
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == '*') {
        str.deleteCharAt(str.length() - 1);
      } else {
        str.append(s.charAt(i));
      }
    }
    return str.toString();
  }

  public static int[] asteroidCollision(int[] asteroids) {
    List<Integer> list = new LinkedList<>();
    for (int asteroid : asteroids) {
      list.add(asteroid);
    }
    Integer first = list.get(0);
    Integer second = list.get(1);

    int i = 0;
    while (i < list.size()) {
      if ((first > 0 && second > 0) || (first < 0 && second < 0)) {
        if (list.size() == 2) {
          break;
        }
        first = second;
        ++i;
        second = list.get(i + 1);
      } else if (Math.abs(first) < Math.abs(second)) {
        list.remove(first);

        if (i != 0) {
          second = list.get(i);
          first = list.get(--i);
        } else {
          first = list.get(i);
          second = list.get(i + 1);
        }
        if (i == list.size() - 1) {
          break;
        }
      } else if (Math.abs(first) > Math.abs(second)) {
        list.remove(second);
        if (i == list.size() - 1) {
          break;
        }
        second = list.get(i + 1);
      } else if (Math.abs(first) == Math.abs(second)) {
        list.remove(first);
        list.remove(second);
        if (list.isEmpty()) {
          break;
        }
        first = list.get(i - 1);
        second = list.get(i);
      }
    }

    return list.stream().mapToInt(Integer::intValue).toArray();
  }

  public static int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int depth = 1;
    return getdepthRecursive(root, depth);
  }

  private static Integer getdepthRecursive(TreeNode node, int depth) {
    if (node != null) {
      if (node.left != null || node.right != null) {
        depth++;
      }
      int depthL = getdepthRecursive(node.left, depth);
      int depthR = getdepthRecursive(node.right, depth);
      depth = Math.max(depthL, depthR);
    }
    return depth;
  }
}
