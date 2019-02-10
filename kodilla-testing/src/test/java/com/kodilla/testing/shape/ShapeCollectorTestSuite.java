package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests(){
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    //Test 1: sprawdzający, czy po dodaniu nowej figury geometrycznej liczba figur w kolekcji wynosi 1.
    @Test
    public void testAddFigure(){
        //given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(5, "square");
        //when
        shapeCollector.addFigure(square);
        //then
        Assert.assertEquals(1, shapeCollector.geometricFigures.size());
    }

    //Test 2: sprawdzający, czy próba usunięcia nieistniejącej figury skończy się zwróceniem wyniku false.
    @Test
    public void testRemoveFigureNotExisting() {
        //given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(5, "square");
        //when
        boolean result = shapeCollector.removeFigure(square);
        //then
        Assert.assertFalse(result);
    }

    //Test 3: weryfikujący, czy udało się usunąć wybraną figurę z klasy.
    @Test
    public void testRemoveFigure() {
        //given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(5, "square");
        shapeCollector.addFigure(square);
        //when
        boolean result = shapeCollector.removeFigure(square);
        //then
        Assert.assertTrue(result);
    }

    //Test 4: sprawdzający, czy figura pobrana z klasy ShapeCollector jest taka sama, jak figura, która była wstawiana do klasy.
    @Test
    public void testGetFigure(){
        //given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(5, "square");
        shapeCollector.addFigure(square);
        //when
        Shape expectedShape = shapeCollector.getFigure(0);
        //then
        Assert.assertEquals(expectedShape, square);
    }

    @Test
    public void testShowFiguresWhenCollectionIsEmpty(){
        //given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(5, "square");
        //when
        String figuresInCollection = shapeCollector.showFigures();
        //then
        Assert.assertEquals(figuresInCollection, "");
    }

    @Test
    public void testShowFigures(){
        //given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(5, "square");
        shapeCollector.addFigure(square);
        //when
        String figuresInCollection = shapeCollector.showFigures();
        //then
        Assert.assertEquals(figuresInCollection, "square, pole: 25.0\n");
    }
}
