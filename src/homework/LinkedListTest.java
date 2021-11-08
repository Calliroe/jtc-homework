package homework;

import org.testng.annotations.Test;
import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListTest {

    @Test
    public void equals_incomingParameterIsNull_shouldReturnFalse() {
        LinkedList list = new LinkedList();

        boolean result = list.equals(null);

        assertThat(result).isFalse();
    }

    @Test
    public void equals_incomingParameterIsTheSameObject_shouldReturnTrue() {
        LinkedList list = new LinkedList();
        LinkedList list2 = list;

        boolean result = list.equals(list2);

        assertThat(result).isTrue();
    }

    @Test
    public void equals_theSymmetryConditionIsMet_shouldReturnTrue() {
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
    public void equals_TheTransitivityConditionIsMet_shouldReturnTrue() {
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
    public void equals_objectsFieldsDidNotChange_shouldReturnTrue() {
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
    public void equals_incomingParameterNotInstanceOfLinkedList_shouldReturnFalse() {
        LinkedList list = new LinkedList();
        ArrayList<String> list2 = new ArrayList<>();

        boolean result = list.equals(list2);

        assertThat(result).isFalse();
    }

    @Test
    public void equals_parameterFieldsAreEqualToObjectFields_shouldReturnTrue() {
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
    public void equals_parameterItemsAreNotEqualToListItems_shouldReturnFalse() {
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
    public void equals_parameterSizeIsNotEqualToListSize_shouldReturnFalse() {
        LinkedList list = new LinkedList();
        list.add("Hello");
        LinkedList list2 = new LinkedList();

        boolean result = list.equals(list2);

        assertThat(result).isFalse();
    }

    @Test
    public void hashcode_incomingParameterIsTheSameObject_shouldBeEqual() {
        LinkedList list = new LinkedList();
        LinkedList list2 = list;

        int result = list.hashCode();
        int result2 = list2.hashCode();

        assertThat(result).isEqualTo(result2);
    }

    @Test
    public void hashcode_parameterItemsAreEqualToListItems_shouldBeEqual() {
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
    public void hashcode_listFieldsDidNotChange_shouldBeEqual() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        int result = list.hashCode();
        int result2 = list.hashCode();

        assertThat(result).isEqualTo(result2);
    }

    @Test
    public void toString_itemsAreDisplayedAccordingToTheOrderTheyWereAdded_shouldBeEqual() {
        LinkedList list = new LinkedList();
        list.add("One");
        list.add("Two");
        list.add("Three");

        assertThat(list.toString()).isEqualTo("[ One  Two  Three ]");
    }

    @Test
    public void add_incomingParameterInstanceOfString_shouldReturnTrueAndElementAdded() {
        LinkedList list = new LinkedList();

        boolean result = list.add("Hello");

        assertThat(result).isTrue();
        assertThat(list).contains("Hello");
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    public void add_indexIsBetweenZeroAndListSize_elementAdded() {
        LinkedList list = new LinkedList();

        list.add(0, "Two");
        list.add(1, "Three");
        list.add(0, "One");

        assertThat(list).containsOnly("One", "Two", "Three");
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    public void addFirst_incomingParameterInstanceOfString_elementAddedToBeginning() {
        LinkedList list = new LinkedList();

        list.add("World");
        list.addFirst("Hello");

        assertThat(list.get(0)).isEqualTo("Hello");
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    public void addLast_incomingParameterInstanceOfString_elementAddedToTheEnd() {
        LinkedList list = new LinkedList();

        list.add("Hello");
        list.addLast("World");

        assertThat(list.get(1)).isEqualTo("World");
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    public void addAll_collectionHoldStrings_collectionItemsAddedToTheEnd() {
        LinkedList list = new LinkedList();
        ArrayList<String> collection = new ArrayList<>();
        list.add("list item");
        collection.add("New");
        collection.add("collection");

        list.addAll(collection);

        assertThat(list.get(0)).isEqualTo("list item");
        assertThat(list.get(1)).isEqualTo("New");
        assertThat(list.get(2)).isEqualTo("collection");
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    public void addAll_indexIsBetweenZeroAndListSize_collectionItemsAddedToIndexPosition() {
        LinkedList list = new LinkedList();
        ArrayList<String> collection = new ArrayList<>();
        list.add("list item");
        collection.add("New");
        collection.add("collection");

        list.addAll(0, collection);

        assertThat(list.get(0)).isEqualTo("New");
        assertThat(list.get(1)).isEqualTo("collection");
        assertThat(list.get(2)).isEqualTo("list item");
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    public void checkForAction_listIsNotEmpty_shouldReturnTrue() {
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
    public void clear_listIsEmpty_listShouldBeEmpty() {
        LinkedList list = new LinkedList();

        list.clear();

        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    public void clear_listIsNotEmpty_listShouldBeEmpty() {
        LinkedList list = new LinkedList();
        list.add("Hello");
        list.add("World");

        list.clear();

        assertThat(list).doesNotContain("Hello", "World");
        assertThat(list.size()).isEqualTo(0);
    }


    @Test
    public void contains_itemExistsInList_shouldReturnTrue() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        boolean result = list.contains("Hello");

        assertThat(result).isTrue();
    }

    @Test
    public void contains_itemDoesNotExistInList_shouldReturnFalse() {
        LinkedList list = new LinkedList();

        boolean result = list.contains("Hello");
        boolean result2 = list.contains(3);

        assertThat(result).isFalse();
        assertThat(result2).isFalse();
    }

    @Test
    public void containsAll_allCollectionItemsExistInList_shouldReturnTrue() {
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
    public void containsAll_notAllCollectionItemsExistInList_shouldReturnFalse() {
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
    public void get_itemByTheIndexExistsInList_shouldReturnElement() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        String result = list.get(0);

        assertThat(result).isEqualTo("Hello");
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void get_indexIsNegativeNumber_shouldThrowAnException() {
        LinkedList list = new LinkedList();

        list.get(-1);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void get_itemByTheIndexDoesNotExistInList_shouldThrowAnException() {
        LinkedList list = new LinkedList();

        list.get(1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void indexOf_incomingParameterNotInstanceOfString_shouldThrowAnException() {
        LinkedList list = new LinkedList();

        list.indexOf(1);
    }

    @Test
    public void indexOf_itemExistsInList_shouldReturnIndex() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        assertThat(list.indexOf("Hello")).isEqualTo(0);
    }

    @Test
    public void indexOf_itemDoesNotExistInList_shouldReturnMinusOne() {
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
    public void isEmpty_listIsEmpty_shouldReturnTrue() {
        LinkedList list = new LinkedList();

        boolean result = list.isEmpty();

        assertThat(result).isTrue();
    }

    @Test
    public void isEmpty_listIsNotEmpty_shouldReturnFalse() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        boolean result = list.isEmpty();

        assertThat(result).isFalse();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void lastIndexOf_incomingParameterNotInstanceOfString_shouldThrowAnException() {
        LinkedList list = new LinkedList();

        list.lastIndexOf(1);
    }

    @Test
    public void lastIndexOf_itemExistsInList_shouldReturnLastIndex() {
        LinkedList list = new LinkedList();
        list.add("Run");
        list.add("Forrest");
        list.add("Run");

        assertThat(list.lastIndexOf("Run")).isEqualTo(2);
    }

    @Test
    public void lastIndexOf_itemDoesNotExistInList_shouldReturnMinusOne() {
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
    public void remove_itemExistsInList_shouldReturnTrueAndRemoveIt() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        boolean result = list.remove("Hello");

        assertThat(result).isTrue();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void remove_itemDoesNotExistInList_shouldThrowAnException() {
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
    public void remove_incomingParameterNotInstanceOfStringAndListIsNotEmpty_shouldThrowAnException() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        list.remove(new Exception());
    }

    @Test
    public void remove_itemByTheIndexExistsInList_shouldReturnRemovedValueAndRemoveIt() {
        LinkedList list = new LinkedList();
        list.add("Hello");
        list.add("World");

        String result = list.remove(1);

        assertThat(result).isEqualTo("World");
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    public void removeAll_listHasItemsContainedInTheCollection_shouldReturnTrueAndRemoveIt() {
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
    public void removeAll_listHasNoItemsContainedInTheCollection_shouldReturnFalseAndListDidNotChange() {
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
    public void retainAll_listHasItemsNotContainedInTheCollection_shouldReturnTrueAndRemoveIt() {
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
    public void retainAll_listHasNoItemsNotContainedInTheCollection_shouldReturnFalseAndListDidNotChange() {
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
    public void set_itemByTheIndexExistsInList_shouldReturnPreviouslyValueAndSetValue() {
        LinkedList list = new LinkedList();
        list.add("Hello");
        list.add("World");

        String value = list.set(1, "!");

        assertThat(value).isEqualTo("World");
        assertThat(list.get(1)).isEqualTo("!");
    }

    @Test
    public void toArray_listIsNotEmpty_shouldReturnObjectsArrayWithListItems() {
        LinkedList colors = new LinkedList();
        colors.add("green");
        colors.add("yellow");

        Object[] array = colors.toArray();

        assertThat(array.getClass()).isEqualTo(Object[].class);
        assertThat(array[0]).isEqualTo("green");
        assertThat(array[1]).isEqualTo("yellow");
    }

    @Test
    public void toArray_incomingArrayLengthLessOrEqualsToListSize_shouldReturnOnlyListItems() {
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
    public void toArray_incomingArrayLengthMoreThanListSize_shouldReturnAllItemsFromListThenNullThenArrayItems() {
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
    public void iterator_listIsNotEmpty_getIterator() {
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
    public void iterator_listIsEmpty_shouldReturnEmptyIterator() {
        LinkedList list = new LinkedList();

        Iterator<String> iterator = list.iterator();

        assertThat(iterator.hasNext()).isFalse();
    }

    @Test
    public void listIterator_listIsNotEmpty_getListIterator() {
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
    public void listIterator_listIsEmpty_shouldReturnEmptyIterator() {
        LinkedList list = new LinkedList();

        ListIterator<String> listIterator = list.listIterator();

        assertThat(listIterator.hasNext()).isFalse();
    }

    @Test
    public void listIterator_itemByTheIndexExistsInList_getListIteratorFromTheIndexPosition() {
        LinkedList list = new LinkedList();
        list.add("1");
        list.add("2");

        ListIterator<String> listIterator = list.listIterator(1);

        assertThat(listIterator).isNotNull();
        assertThat(listIterator.hasNext()).isTrue();
        assertThat(listIterator.next()).isEqualTo("2");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void listIterator_itemByTheIndexDoesNotExistInList_shouldThrowAnException() {
        LinkedList list = new LinkedList();
        list.add("1");
        list.add("2");

        ListIterator<String> listIterator = list.listIterator(6);
    }

    @Test
    public void subList_itemsByTheIndexesExistInList_getSubList() {
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
    public void subList_itemByAnyOfTheIndexesNotExistInList_shouldThrowAnException() {
        LinkedList list = new LinkedList();
        list.add("Hello");

        List<String> list2 = list.subList(5, 6);
    }

}
