package HW_to_Lesson16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringCollectionImplTest {
    private StringCollectionImpl collection;
    private int initializationSize = 10;
    private int collectionSizeAfterAddingNewElement = initializationSize + 1;

    @BeforeEach
    void setUp(){
        collection = formCollection();
    }

    @Test
    void should_make_size_10_when_added_10_elements() {
        Assertions.assertEquals(initializationSize, collection.size());
    }

    @Test
    void should_get_element_by_index(){
        String expectedElement = "String4";

        String actualElement = collection.get(4);

        Assertions.assertEquals(expectedElement, actualElement);
    }

    @Test
    void should_add_element(){
        String newValue = "String10";
        collection.add(newValue);

        int currentSize = collection.size();
        String addedValue = collection.get(collectionSizeAfterAddingNewElement - 1);

        Assertions.assertEquals(collectionSizeAfterAddingNewElement, currentSize);
        Assertions.assertEquals(newValue, addedValue);
    }

    @Test
    void should_add_element_by_index(){
        String newValue = "checkElement";
        int indexOfNewElement = 5;
        collection.add(indexOfNewElement, newValue);

        int getCollectionSize = collection.size();
        String getAddedElement = collection.get(indexOfNewElement);

        Assertions.assertEquals(collectionSizeAfterAddingNewElement, getCollectionSize);
        Assertions.assertEquals(newValue, getAddedElement);
    }

    @Test
    void should_delete_element_by_value(){
        String elementToDelete = "String9";
        collection.delete(elementToDelete);

        int expectedSize = 9;

        int actualSize = collection.size();

        Assertions.assertEquals(expectedSize, actualSize);
    }

    @Test
    void  should_return_true_when_contains_element(){
        String checkedValue = "Test123";
        collection.add(checkedValue);
        Assertions.assertTrue(collection.contains(checkedValue));

    }

    @Test
    void  should_return_false_when_doesnt_contain_element(){
        String addedValue = "Test123";
        String checkedValue = "Test321";
        collection.add(addedValue);
        Assertions.assertFalse(collection.contains(checkedValue));

    }

    @Test
    void  should_clear_collection(){
        collection.clear();
        Assertions.assertEquals(0, collection.size());
    }

    @Test
    void should_return_true_when_collections_are_equal(){
        StringCollectionImpl collectionToCheck = formCollection();

        Assertions.assertTrue(collection.equals(collectionToCheck));
    }

    private StringCollectionImpl formCollection(){
        StringCollectionImpl result = new StringCollectionImpl();
        for (int i = 0; i < initializationSize; i++) {
            result.add("String" + i);
        }
        return result;
    }
}