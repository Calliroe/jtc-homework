package homework;

import org.testng.annotations.Test;
import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListTest {

    @Test
    public void equals_equalityWithNullTest_shouldBeFalse() {
        LinkedList list = new LinkedList();

        boolean result = list.equals(null);

        assertThat(result).isFalse();
    }

    @Test
    public void equals_reflexivityTest_shouldBeTrue() {
        LinkedList list = new LinkedList();
        LinkedList list2 = list;

        boolean result = list.equals(list2);

        assertThat(result).isTrue();
    }

    @Test
    public void equals_symmetryTest_shouldBeTrue() {
        LinkedList list = new LinkedList();
        LinkedList list2 = new LinkedList();
        list.add("Hello");
        list2.add("Hello");

        boolean result = list.equals(list2);
        boolean result2 = list2.equals(list);

        assertThat(result).isTrue();
        assertThat(result2).isTrue();
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

        assertThat(result).isTrue();
        assertThat(result2).isTrue();
        assertThat(result3).isTrue();
    }

    @Test
    public void equals_consistencyTest_shouldBeTrue() {
        LinkedList list = new LinkedList();
        LinkedList list2 = new LinkedList();
        list.add("Hello");
        list2.add("Hello");

        boolean result = list.equals(list2);
        boolean result2 = list.equals(list2);

        assertThat(result).isTrue();
        assertThat(result2).isTrue();
    }

    @Test
    public void equals_objectNotInstanceOfThis_shouldBeFalse() {
        LinkedList list = new LinkedList();
        java.util.LinkedList<String> list2 = new java.util.LinkedList<>();

        boolean result = list.equals(list2);

        assertThat(result).isFalse();
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

        assertThat(result).isTrue();
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

        assertThat(result).isFalse();
    }

    @Test
    public void equals_objectsSizesAreNotEqual_shouldBeFalse() {
        LinkedList list = new LinkedList();
        list.add("Hello");
        LinkedList list2 = new LinkedList();

        boolean result = list.equals(list2);

        assertThat(result).isFalse();
    }

    @Test
    public void hashcode_theSameObject_shouldBeEqual() {
        LinkedList list = new LinkedList();
        LinkedList list2 = list;

        int result = list.hashCode();
        int result2 = list2.hashCode();

        assertThat(result).isEqualTo(result2);
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

        assertThat(result).isEqualTo(result2);
    }

    @Test
    public void hashcode_consistencyTest_shouldBeEqual() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        int result = list.hashCode();
        int result2 = list.hashCode();

        assertThat(result).isEqualTo(result2);
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
    public void add_elementInstanceOfString_elementAdded() {
        LinkedList list = new LinkedList();

        boolean result = list.add("Hello");

        assertThat(result).isTrue();
        assertThat(list).contains("Hello");
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    public void add_supportedIndex_elementAdded() {
        LinkedList list = new LinkedList();

        list.add(0, "Two");
        list.add(1, "Three");
        list.add(0, "One");

        assertThat(list).containsOnly("One", "Two", "Three");
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    public void addFirst_elementInstanceOfString_elementAddedToBeginning() {
        LinkedList list = new LinkedList();

        list.add("World");
        list.addFirst("Hello");

        assertThat(list.get(0)).isEqualTo("Hello");
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    public void addLast_elementInstanceOfString_elementAddedToTheEnd() {
        LinkedList list = new LinkedList();

        list.add("Hello");
        list.addLast("World");

        assertThat(list.get(1)).isEqualTo("World");
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    public void addAll_collectionHoldStrings_collectionElementsAdded() {
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
    public void addAll_supportIndex_collectionElementsAdded() {
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

        assertThat(result).isTrue();
    }

    @Test(expectedExceptions = NoElementException.class)
    public void checkForAction_listIsEmpty_shouldThrowAnException() {
        LinkedList list = new LinkedList();

        list.checkForAction();
    }

    @Test
    public void clear_elementsDeleted_listShouldBeEmpty() {
        LinkedList list = new LinkedList();
        list.add("Hello");
        list.add("World");

        list.clear();

        assertThat(list).doesNotContain("Hello", "World");
        assertThat(list.size()).isEqualTo(0);
    }


    @Test
    public void contains_elementExistInList_shouldBeTrue() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        boolean result = list.contains("Hello");

        assertThat(result).isTrue();
    }

    @Test
    public void contains_elementNotExistInList_shouldBeFalse() {
        LinkedList list = new LinkedList();

        boolean result = list.contains("Hello");

        assertThat(result).isFalse();
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

        assertThat(result).isTrue();
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

        assertThat(result).isFalse();
    }

    @Test
    public void get_supportedIndex_elementGot() {
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
    public void get_notSupportedIndex_shouldThrowAnException() {
        LinkedList list = new LinkedList();

        list.get(1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void indexOf_objectNotInstanceOfString_shouldThrowAnException() {
        LinkedList list = new LinkedList();

        list.indexOf(1);
    }

    @Test
    public void indexOf_elementExistInList_shouldReturnIndex() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        assertThat(list.indexOf("Hello")).isEqualTo(0);
    }

    @Test
    public void indexOf_elementNotExistInList_shouldReturnMinusOne() {
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

        assertThat(result).isTrue();
    }

    @Test
    public void isEmpty_listIsNotEmpty_shouldBeFalse() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        boolean result = list.isEmpty();

        assertThat(result).isFalse();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void lastIndexOf_objectNotInstanceOfString_shouldThrowAnException() {
        LinkedList list = new LinkedList();

        list.lastIndexOf(1);
    }

    @Test
    public void lastIndexOf_elementExistInList_shouldReturnLastIndex() {
        LinkedList list = new LinkedList();
        list.add("Run");
        list.add("Forrest");
        list.add("Run");

        assertThat(list.lastIndexOf("Run")).isEqualTo(2);
    }

    @Test
    public void lastIndexOf_elementNorExistInList_shouldReturnMinusOne() {
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
    public void remove_elementExistInList_removeIt() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        boolean result = list.remove("Hello");

        assertThat(result).isTrue();
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void remove_elementNotExistInList_shouldThrowAnException() {
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
    public void remove_motSupportedType_shouldThrowAnException() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        list.remove(new Exception());
    }

    @Test
    public void remove_supportedIndex_shouldReturnRemovedValue() {
        LinkedList list = new LinkedList();
        list.add("Hello");
        list.add("World");

        String result = list.remove(1);

        assertThat(result).isEqualTo("World");
        assertThat(list.size()).isEqualTo(1);
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

        assertThat(result).isTrue();
        assertThat(fruits.size()).isEqualTo(2);
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

        assertThat(result).isFalse();
        assertThat(fruits.size()).isEqualTo(2);
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

        assertThat(result).isTrue();
        assertThat(people.size()).isEqualTo(2);
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

        assertThat(result).isFalse();
        assertThat(friends.size()).isEqualTo(2);
    }

    @Test
    public void set_supportedIndex_shouldReturnPreviouslyValue() {
        LinkedList list = new LinkedList();
        list.add("Hello");
        list.add("World");

        String value = list.set(1, "!");

        assertThat(value).isEqualTo("World");
        assertThat(list.get(1)).isEqualTo("!");
    }

    @Test
    public void toArray_gettingTheObjectsArray_objectsArrayGot() {
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

    @Test
    public void iterator_gettingIterator_iteratorGot() {
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

    @Test
    public void listIterator_gettingListIterator_ListIteratorGot() {
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

    @Test
    public void listIterator_supportedIndex_ListIteratorGot() {
        LinkedList list = new LinkedList();
        list.add("1");
        list.add("2");

        ListIterator<String> listIterator = list.listIterator(1);

        assertThat(listIterator).isNotNull();
        assertThat(listIterator.hasNext()).isTrue();
        assertThat(listIterator.next()).isEqualTo("2");
    }

    @Test
    public void subList_supportedIndexes_subListGot() {
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
    public void subList_notSupportedIndex_shouldThrowAnException() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        List<String> list2 = list.subList(5, 6);
    }

}
