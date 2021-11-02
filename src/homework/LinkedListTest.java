package homework;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListTest {

    @BeforeTest
    public void beforeTest() {
        System.out.println("Ready to start");
    }

    @Test
    public void equals_equalityWithNullTest_shouldBeFalse() {
        LinkedList list = new LinkedList();

        boolean result = list.equals(null);

        Assert.assertFalse(result);
    }

    @Test
    public void equals_reflexivityTest_shouldBeTrue() {
        LinkedList list = new LinkedList();
        LinkedList list2 = list;

        boolean result = list.equals(list2);

        Assert.assertTrue(result);
    }

    @Test
    public void equals_symmetryTest_shouldBeTrue() {
        LinkedList list = new LinkedList();
        LinkedList list2 = new LinkedList();
        list.add("Hello");
        list2.add("Hello");

        boolean result = list.equals(list2);
        boolean result2 = list2.equals(list);

        Assert.assertTrue(result);
        Assert.assertTrue(result2);
    }

    @Test
    public void equals_transitivityTest_shouldBeTrue() {
        LinkedList list = new LinkedList();
        LinkedList list2 = new LinkedList();
        LinkedList list3 = new LinkedList();
        list.add("Hello");
        list2.add("Hello");
        list3.add("Hello");

        boolean result = list.equals(list3);
        boolean result2 = list2.equals(list3);
        boolean result3 = list.equals(list2);

        Assert.assertTrue(result);
        Assert.assertTrue(result2);
        Assert.assertTrue(result3);
    }

    @Test
    public void equals_consistencyTest_shouldBeTrue() {
        LinkedList list = new LinkedList();
        LinkedList list2 = new LinkedList();
        list.add("Hello");
        list2.add("Hello");

        boolean result = list.equals(list2);
        boolean result2 = list.equals(list2);

        Assert.assertTrue(result);
        Assert.assertTrue(result2);
    }

    @Test
    public void equals_objectNotInstanceofThis_shouldBeFalse() {
        LinkedList list = new LinkedList();
        java.util.LinkedList<String> list2 = new java.util.LinkedList<>();

        boolean result = list.equals(list2);

        Assert.assertFalse(result);
    }

    @Test
    public void equals_objectFieldsAreEqual_shouldBeTrue() {
        LinkedList list = new LinkedList();
        LinkedList list2 = new LinkedList();
        list.add("Hello");
        list.add("World");
        list2.add("Hello");
        list2.add("World");

        boolean result = list.equals(list2);

        Assert.assertTrue(result);
    }

    @Test
    public void equals_objectElementsAreNotEqual_shouldBeFalse() {
        LinkedList list = new LinkedList();
        LinkedList list2 = new LinkedList();
        list.add("Hello");
        list.add("World");
        list2.add("Hello");
        list2.add("Me");

        boolean result = list.equals(list2);

        Assert.assertFalse(result);
    }

    @Test
    public void equals_objectsSizesAreNotEqual_shouldBeFalse() {
        LinkedList list = new LinkedList();
        list.add("Hello");
        LinkedList list2 = new LinkedList();

        boolean result = list.equals(list2);

        Assert.assertFalse(result);
    }

    @Test
    public void hashcode_theSameObject_shouldBeEqual() {
        LinkedList list = new LinkedList();
        LinkedList list2 = list;

        int result = list.hashCode();
        int result2 = list2.hashCode();

        Assert.assertEquals(result, result2);
    }

    @Test
    public void hashcode_twoEqualObjects_shouldBeEqual() {
        LinkedList list = new LinkedList();
        LinkedList list2 = new LinkedList();
        list.add("Hello");
        list.add("World");
        list2.add("Hello");
        list2.add("World");

        int result = list.hashCode();
        int result2 = list2.hashCode();

        Assert.assertEquals(result, result2);
    }

    @Test
    public void hashcode_consistencyTest_shouldBeTrue() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        int result = list.hashCode();
        int result2 = list.hashCode();

        Assert.assertEquals(result, result2);
    }

    @Test
    public void toString_matchingFields_shouldMatch() {
        LinkedList list = new LinkedList();
        LinkedList list2 = new LinkedList();
        list.add("One");
        list2.add("One");
        list2.add("Two");
        list2.add("Three");

        assertThat(list.toString()).isEqualTo("[ One ]");
        assertThat(list2.toString()).isEqualTo("[ One  Two  Three ]");
    }

    @Test
    public void add_addingElement_mustBeDone() {
        LinkedList list = new LinkedList();

        boolean result = list.add("Hello");

        Assert.assertTrue(result);
        assertThat(list).contains("Hello");
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    public void add_correctIndex_mustBeDone() {
        LinkedList list = new LinkedList();

        list.add(0, "Two");
        list.add(1, "Three");
        list.add(0, "One");

        assertThat(list).contains("One", "Two", "Three");
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    public void addFirst_addingElement_mustBeDone() {
        LinkedList list = new LinkedList();

        list.addFirst("World");
        list.addFirst("Hello");

        assertThat(list.get(0)).isEqualTo("Hello");
        assertThat(list.get(1)).isEqualTo("World");
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    public void addLast_addingElement_mustBeDone() {
        LinkedList list = new LinkedList();

        list.addLast("Hello");
        list.addLast("World");

        assertThat(list.get(0)).isEqualTo("Hello");
        assertThat(list.get(1)).isEqualTo("World");
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    public void addAll_addingCollection_mustBeDone() {
        LinkedList list = new LinkedList();
        ArrayList<String> collection = new ArrayList<>();
        collection.add("New");
        collection.add("collection");

        list.addAll(collection);

        assertThat(list.get(0)).isEqualTo("New");
        assertThat(list.get(1)).isEqualTo("collection");
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    public void addAll_addingCollectionWithCorrectIndex_mustBeDone() {
        LinkedList list = new LinkedList();
        ArrayList<String> collection = new ArrayList<>();
        collection.add("New");
        collection.add("collection");

        list.addAll(0, collection);

        assertThat(list.get(0)).isEqualTo("New");
        assertThat(list.get(1)).isEqualTo("collection");
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    public void checkForAction_listIsNotEmpty_shouldBeTrue() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        boolean result = list.checkForAction();

        Assert.assertTrue(result);
    }

    @Test(expectedExceptions = NoElementException.class)
    public void checkForAction_listIsEmpty_shouldThrowAnException() {
        LinkedList list = new LinkedList();

        list.checkForAction();
    }

    @Test
    public void clear_clearList_shouldBeEmpty() {
        LinkedList list = new LinkedList();
        list.add("Hello");
        list.add("World");

        list.clear();

        assertThat(list).doesNotContain("Hello", "World");
        Assert.assertEquals(list.size(), 0);
    }


    @Test
    public void contains_existingItem_shouldBeTrue() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        boolean result = list.contains("Hello");

        Assert.assertTrue(result);
    }

    @Test
    public void contains_nonexistentItem_shouldBeFalse() {
        LinkedList list = new LinkedList();

        boolean result = list.contains("Hello");

        Assert.assertFalse(result);
    }

    @Test
    public void containsAll_allElementsAreContained_shouldBeTrue() {
        LinkedList favoriteDays = new LinkedList();
        ArrayList<String> holidays = new ArrayList<>();
        favoriteDays.add("Friday");
        favoriteDays.add("Saturday");
        favoriteDays.add("Sunday");
        holidays.add("Saturday");
        holidays.add("Sunday");

        boolean result = favoriteDays.containsAll(holidays);

        Assert.assertTrue(result);
    }

    @Test
    public void containsAll_elementsAreNotContained_shouldBeFalse() {
        LinkedList numbers = new LinkedList();
        ArrayList<String> evenNumbers = new ArrayList<>();
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        evenNumbers.add("2");
        evenNumbers.add("4");

        boolean result = numbers.containsAll(evenNumbers);

        Assert.assertFalse(result);
    }

    @Test
    public void get_correctIndex_mustBeGot() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        String result = list.get(0);

        assertThat(result).isEqualTo("Hello");
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void get_negativeIndex_shouldThrowAnException() {
        LinkedList list = new LinkedList();

        list.get(-1);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void get_incorrectIndex_shouldThrowAnException() {
        LinkedList list = new LinkedList();

        list.get(1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void indexOf_objectNotInstanceofString_shouldThrowAnException() {
        LinkedList list = new LinkedList();

        list.indexOf(1);
    }

    @Test
    public void indexOf_existingItem_shouldReturnIndex() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        assertThat(list.indexOf("Hello")).isEqualTo(0);
    }

    @Test
    public void indexOf_nonexistentItem_shouldReturnNegativeNumber() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        assertThat(list.indexOf("World")).isEqualTo(-1);
    }

    @Test(expectedExceptions = NoElementException.class)
    public void indexOf_listIsEmpty_shouldThrowAnException() {
        LinkedList list = new LinkedList();

        list.indexOf("Hello");
    }

    @Test
    public void isEmpty_listIsEmpty_shouldBeTrue() {
        LinkedList list = new LinkedList();

        boolean result = list.isEmpty();

        Assert.assertTrue(result);
    }

    @Test
    public void isEmpty_listIsNotEmpty_shouldBeFalse() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        boolean result = list.isEmpty();

        Assert.assertFalse(result);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void lastIndexOf_objectNotInstanceofString_shouldThrowAnException() {
        LinkedList list = new LinkedList();

        list.lastIndexOf(1);
    }

    @Test
    public void lastIndexOf_existingItem_shouldReturnLastIndex() {
        LinkedList list = new LinkedList();
        list.add("Run");
        list.add("Forrest");
        list.add("Run");

        assertThat(list.lastIndexOf("Run")).isEqualTo(2);
    }

    @Test
    public void lastIndexOf_nonexistentItem_shouldReturnNegativeNumber() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        assertThat(list.lastIndexOf("World")).isEqualTo(-1);
    }

    @Test(expectedExceptions = NoElementException.class)
    public void lastIndexOf_listIsEmpty_shouldThrowAnException() {
        LinkedList list = new LinkedList();

        list.lastIndexOf("Hello");
    }

    @Test
    public void remove_existingItem_shouldBeTrue() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        boolean result = list.remove("Hello");

        Assert.assertTrue(result);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void remove_nonexistentItem_shouldThrowAnException() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        list.remove("World");
    }

    @Test(expectedExceptions = NoElementException.class)
    public void remove_listIsEmpty_shouldThrowAnException() {
        LinkedList list = new LinkedList();

        list.remove("Hello");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void remove_incorrectType_shouldThrowAnException() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        list.remove(new Exception());
    }

    @Test
    public void remove_correctIndex_shouldReturnRemovedValue() {
        LinkedList list = new LinkedList();
        list.add("Hello");
        list.add("World");

        String result = list.remove(1);

        assertThat(result).isEqualTo("World");
        Assert.assertEquals(list.size(), 1);
    }

    @Test
    public void removeAll_listWasModified_shouldBeTrue() {
        LinkedList fruits = new LinkedList();
        ArrayList<String> vegetables = new ArrayList<>();
        fruits.add("banana");
        fruits.add("orange");
        fruits.add("potato");
        vegetables.add("tomato");
        vegetables.add("potato");

        boolean result = fruits.removeAll(vegetables);

        Assert.assertTrue(result);
        Assert.assertEquals(fruits.size(), 2);
    }

    @Test
    public void removeAll_listWasNotModified_shouldBeFalse() {
        LinkedList fruits = new LinkedList();
        ArrayList<String> vegetables = new ArrayList<>();
        fruits.add("banana");
        fruits.add("mango");
        vegetables.add("carrot");
        vegetables.add("cucumber");

        boolean result = fruits.removeAll(vegetables);

        Assert.assertFalse(result);
        Assert.assertEquals(fruits.size(), 2);
    }

    @Test
    public void retainAll_listWasModified_shouldBeTrue() {
        LinkedList people = new LinkedList();
        ArrayList<String> friends = new ArrayList<>();
        people.add("Kianu");
        people.add("Cillian");
        people.add("Jim");
        friends.add("Kianu");
        friends.add("Jim");

        boolean result = people.retainAll(friends);

        Assert.assertTrue(result);
        Assert.assertEquals(people.size(), 2);
    }

    @Test
    public void retainAll_listWasNotModified_shouldBeFalse() {
        LinkedList friends = new LinkedList();
        ArrayList<String> people = new ArrayList<>();
        friends.add("Kianu");
        friends.add("Jim");
        people.add("Kianu");
        people.add("Jim");

        boolean result = friends.retainAll(people);

        Assert.assertFalse(result);
        Assert.assertEquals(friends.size(), 2);
    }

    @Test
    public void set_setValue_shouldReturnPreviouslyValue() {
        LinkedList list = new LinkedList();
        list.add("Hello");
        list.add("World");

        String value = list.set(1, "!");

        assertThat(value).isEqualTo("World");
        assertThat(list.get(1)).isEqualTo("!");
    }

    @Test
    public void toArray_gettingTheObjectsArray_mustBeGot() {
        LinkedList colors = new LinkedList();
        colors.add("green");
        colors.add("yellow");

        Object[] array = colors.toArray();

        assertThat(array.getClass()).isEqualTo(Object[].class);
        assertThat(array[0]).isEqualTo("green");
        assertThat(array[1]).isEqualTo("yellow");
    }

    @Test
    public void toArray_arrayLengthLessOrEqualsSize_shouldReturnOnlyListElements() {
        LinkedList colors = new LinkedList();
        String[] array = new String[2];
        colors.add("green");
        colors.add("yellow");
        colors.add("red");

        String[] newArray = colors.toArray(array);

        assertThat(newArray.getClass()).isEqualTo(String[].class);
        assertThat(newArray[0]).isEqualTo("green");
        assertThat(newArray[1]).isEqualTo("yellow");
        assertThat(newArray[2]).isEqualTo("red");
        assertThat(newArray.length).isEqualTo(3);
    }

    @Test
    public void toArray_arrayLengthMoreThanSize_shouldReturnAllElements() {
        LinkedList colors = new LinkedList();
        String[] array = new String[4];
        colors.add("green");
        colors.add("yellow");
        array[2] = "willNull";
        array[3] = "black";

        String[] newArray = colors.toArray(array);

        assertThat(newArray.getClass()).isEqualTo(String[].class);
        assertThat(newArray[0]).isEqualTo("green");
        assertThat(newArray[1]).isEqualTo("yellow");
        assertThat(newArray[2]).isEqualTo(null);
        assertThat(newArray[3]).isEqualTo("black");
        assertThat(newArray.length).isEqualTo(4);
    }

    @AfterTest
    public void iterator_gettingIterator_mustBeDone() {
        LinkedList list = new LinkedList();
        list.add("1");
        list.add("2");

        Iterator<String> iterator = list.iterator();

        assertThat(iterator).isNotNull();
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo("1");
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo("2");
    }

    @AfterTest
    public void listIterator_gettingListIterator_mustBeGot() {
        LinkedList list = new LinkedList();
        list.add("1");
        list.add("2");

        ListIterator<String> listIterator = list.listIterator();

        assertThat(listIterator).isNotNull();
        assertThat(listIterator.hasNext()).isTrue();
        assertThat(listIterator.next()).isEqualTo("1");
        assertThat(listIterator.hasNext()).isTrue();
        assertThat(listIterator.next()).isEqualTo("2");
    }

    @AfterTest
    public void listIterator_withCorrectIndex_mustBeGot() {
        LinkedList list = new LinkedList();
        list.add("1");
        list.add("2");

        ListIterator<String> listIterator = list.listIterator(1);

        assertThat(listIterator).isNotNull();
        assertThat(listIterator.hasNext()).isTrue();
        assertThat(listIterator.next()).isEqualTo("2");
    }

    @AfterTest
    public void subList_withCorrectIndexes_mustBeGot() {
        LinkedList daysOfTheWeek = new LinkedList();
        daysOfTheWeek.add("Monday");
        daysOfTheWeek.add("Tuesday");
        daysOfTheWeek.add("Wednesday");
        daysOfTheWeek.add("Thursday");
        daysOfTheWeek.add("Friday");
        daysOfTheWeek.add("Saturday");
        daysOfTheWeek.add("Sunday");

        List<String> weekend = daysOfTheWeek.subList(5, 6);

        assertThat(weekend.get(0)).isEqualTo("Saturday");
        assertThat(weekend.get(1)).isEqualTo("Sunday");
        assertThat(weekend.size()).isEqualTo(2);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void subList_withIncorrectIndex_shouldThrowAnException() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        List<String> list2 = list.subList(5, 6);
    }

    @AfterTest
    public void afterTest() {
        System.out.println("All tests passed");
    }
}
